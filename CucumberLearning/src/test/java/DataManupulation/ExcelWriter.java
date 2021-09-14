package com.botsftool.dsg.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter implements Runnable  {

	//To Declare Variables
	private String file="";
	private String Sheet="";
	ArrayList<String> headers = new ArrayList<String>();
	ArrayList<String> values =  new ArrayList<String>();
	
	 public ExcelWriter(String filePath, String Sheetname, ArrayList<String> LabelHeader,ArrayList<String> LabelValue){
	      this.file = filePath;
	      this.Sheet = Sheetname;
	      this.headers = LabelHeader;
	      this.values = LabelValue;
	   }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Writetoexcel(file,Sheet,headers,values);
			return;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to Write Data to Excel");
		}
	}
	
    
	public static synchronized boolean Writetoexcel(String filepath, String SheetName, ArrayList<String> header, ArrayList<String> value) throws FileNotFoundException
	{
		boolean result = false;
		XSSFWorkbook wb = null;
		FileOutputStream fos=null;
		InputStream fis=null;
		try {
			File file = new File(filepath); 
			XSSFSheet sheet;
			Row headerrow;
			int RowCount = 0;
			Cell headercell;
			if(!file.exists()) {
				wb=new XSSFWorkbook();
				sheet = wb.createSheet(SheetName);
				headerrow=sheet.createRow(RowCount);
				CellStyle style = wb.createCellStyle();
				style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
				style.setFillPattern(CellStyle.SOLID_FOREGROUND);
				for(int i=0;i<header.size();i++) {
					headercell = headerrow.createCell(i);
					headercell.setCellValue(header.get(i));
					headercell.setCellStyle(style);
				}
				RowCount=RowCount+1;
				headerrow=sheet.createRow(RowCount);
				for(int j=0;j<value.size();j++) {
					headercell=headerrow.createCell(j);
					headercell.setCellType(XSSFCell.CELL_TYPE_STRING);
					headercell.setCellValue(value.get(j));
				}
				fos=new FileOutputStream(filepath);
				wb.write(fos);
				fos.flush();
				fos.close();
				wb.close();
				result=true;
			}
			else {
				boolean found =false;
				fis= new FileInputStream(filepath);
				wb=new XSSFWorkbook(fis);
				sheet=wb.getSheet(SheetName);
				headerrow=sheet.getRow(RowCount);
				CellStyle style = wb.createCellStyle();
				style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
				style.setFillPattern(CellStyle.SOLID_FOREGROUND);
				for(int i=0;i<header.size();i++) {
					found = false;
					String headerValue= header.get(i);
					for(int j=0;j<headerrow.getLastCellNum();j++) {
						if(headerValue.equals(headerrow.getCell(j).toString())) {
							found = true;
							break;
						}
					}
					if(!found) {
						headercell = headerrow.createCell(headerrow.getLastCellNum());
						headercell.setCellType(XSSFCell.CELL_TYPE_STRING);
						headercell.setCellValue(headerValue);
						headercell.setCellStyle(style);
					}
				}
				int lastrowcount = sheet.getLastRowNum();
				headerrow=sheet.createRow(lastrowcount+1);
				for(int k=0;k<value.size();k++) {
					int colindex = 0;
					for(int l=0;l<sheet.getRow(RowCount).getLastCellNum();l++) {
						if(header.get(k).equals(sheet.getRow(RowCount).getCell(l).toString())) {
							colindex=l;
							break;
						}
					}
					headercell = headerrow.createCell(colindex);
					headercell.setCellValue(value.get(k));
				}

				//Close inputStream
				fis.close();

				fos=new FileOutputStream(filepath);
				wb.write(fos);
				fos.flush();
				fos.close();
				wb.close();
				result=true;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error in Writing Data to Output File "+ e.getMessage());
			e.printStackTrace();
			result=false;
		}
		return result;
	}

}
