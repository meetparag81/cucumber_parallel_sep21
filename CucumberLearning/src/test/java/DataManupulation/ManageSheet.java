package com.botsftool.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import au.com.bytecode.opencsv.CSVReader;

public class ManageSheet {
	static Logger logger = Logger.getLogger(ManageSheet.class.getName());

	public String removeColumnsExceptAndReturnFilePath(String inputFile, List<String> columnsToBePreserved,
			String outputFileLoc) {
		XSSFWorkbook workBook = null;
		XSSFWorkbook wrk1 = null;
		FileOutputStream fileOutputStream = null;
		try {
			wrk1 = new XSSFWorkbook(new FileInputStream(new File(inputFile)));
			XSSFSheet sSheet = wrk1.getSheetAt(0);
			workBook = new XSSFWorkbook();
			XSSFSheet dSheet = workBook.createSheet("sheet1");
			if (sSheet != null) {
				Set<Integer> colSet = getHeaderIndexes(sSheet, columnsToBePreserved);
				for (int r = 0; r < sSheet.getPhysicalNumberOfRows(); r++) {
					Row sRow = sSheet.getRow(r);
					Row dRow = dSheet.createRow(r);
					int colsProcessed = 0;
					for (int c = 0; c < sRow.getPhysicalNumberOfCells(); c++) {
						if(colsProcessed == colSet.size())break;
						Integer cI = c;
						if(colSet.contains(cI)){
							Cell sCell = sRow.getCell(c);
							Cell dCell = dRow.createCell(colsProcessed);
							colsProcessed++;
							if (sCell != null) {
								try{
									dCell.setCellValue(getCellValue(sCell));
								}catch(Exception ex){}
							}
						}else{
							continue;
						}
					}
				}
			}

			fileOutputStream = new FileOutputStream(outputFileLoc);
			workBook.write(fileOutputStream);
		} catch (Exception e) {
			logger.info(e.getStackTrace());
		} finally {
			try {
				wrk1.close();
				workBook.close();
				fileOutputStream.close();
				logger.info("Done");
			} catch (IOException e2) {
				logger.info(e2.getStackTrace());
			}
		}
		return outputFileLoc;
	}

	public String getCellValue(Cell cell) throws Exception {
		String value = new String();
		if (cell != null) {
			if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				DataFormatter formatter = new DataFormatter();
				value = formatter.formatCellValue(cell);
			} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				value = cell.getStringCellValue();
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				value = "";
			} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				value = String.valueOf(cell.getBooleanCellValue());
			} else {
				value = cell.getStringCellValue();
			}
		}
		return value;
	}
	
	public Set<Integer> getHeaderIndexes(XSSFSheet sheet, List<String> colNameList){
		Set<Integer> hIdxList = new TreeSet<Integer>();
		
		if(sheet.getPhysicalNumberOfRows()>0){
			Row row = sheet.getRow(0);
			for(int c=0; c<row.getPhysicalNumberOfCells(); c++){
				Cell cell = row.getCell(c);
				try {
					String cValue = getCellValue(cell);
					if(colNameList.contains(cValue)){
						hIdxList.add(c);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return hIdxList;
	}
	
	public void convertToCSVRemoveColsExcept(String inputFleLoc, String outputFleLoc, List<String> columnsToBePreserved) {
		CSVReader reader = null;
		FileOutputStream fileOutputStream = null;
		XSSFWorkbook workBook = null;
		String input_file = inputFleLoc;
		// xls file name
		String xlsxFileAddress = outputFleLoc;
		try {
			// Get the CSVReader instance with specifying the delimiter to be
			// used
			String[] nextLine;
			reader = new CSVReader(new FileReader(input_file), ',');
			workBook = new XSSFWorkbook();
			XSSFSheet sheet = workBook.createSheet("sheet1");
			int RowNum = 0;
			boolean first = true;
			Set<Integer> hIdx = null;
			while ((nextLine = reader.readNext()) != null) {
				if(first){
					hIdx = getCSVHeaderIndexes(nextLine, columnsToBePreserved);
					first = false;
				}
				
				XSSFRow currentRow = sheet.createRow(RowNum++);
				int colsProcessed = 0;
				for (int i = 0; i < nextLine.length; i++) {
					if(colsProcessed == hIdx.size())break;
					Integer cI = i;
					if(hIdx.contains(cI)){
						currentRow.createCell(colsProcessed).setCellValue(nextLine[i]);
						colsProcessed++;
					}
				}
			}
			fileOutputStream = new FileOutputStream(xlsxFileAddress);
			workBook.write(fileOutputStream);
		} catch (Exception e1) {
			logger.info("\nFile \"" + input_file + "\" does not exist!");
		} finally {
			if (reader != null) {
				try {
					workBook.close();
					fileOutputStream.close();
					reader.close();
					logger.info("Done");
				} catch (IOException e2) {
					logger.info("\nFile \"" + input_file + "\" can not be closed correctly!");
				}
			}
		}
	}
	
	public Set<Integer> getCSVHeaderIndexes(String[] headAr, List<String> colNameList){
		Set<Integer> hIdxList = new TreeSet<Integer>();
		
		for(int i=0; i<headAr.length; i++){
			if(colNameList.contains(headAr[i])) hIdxList.add(i);
		}
		return hIdxList;
	}
	

}
