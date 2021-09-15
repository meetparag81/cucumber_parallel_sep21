package com.botsftool.utilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

public class XExcelFileReader implements IDataFileReader {
	private int rowNum = 0;
	private OPCPackage opcPkg;
	private InputStream inputStream;
	private ReadOnlySharedStringsTable stringsTable;
	private XMLStreamReader xmlReader;

	public XExcelFileReader(File file) throws Exception {
		opcPkg = OPCPackage.open(file, PackageAccess.READ);
		this.stringsTable = new ReadOnlySharedStringsTable(opcPkg);

		XSSFReader xssfReader = new XSSFReader(opcPkg);
		XMLInputFactory factory = XMLInputFactory.newInstance();
		inputStream = xssfReader.getSheetsData().next();
		xmlReader = factory.createXMLStreamReader(inputStream);

		while (xmlReader.hasNext()) {
			xmlReader.next();
			if (xmlReader.isStartElement()) {
				if (xmlReader.getLocalName().equals("sheetData"))
					break;
			}
		}
	}

	@Override
	public int rowNum() {
		return rowNum;
	}

	@Override
	public List<String[]> readRows(int batchSize) throws XMLStreamException, IOException {
		String elementName = "row";
		List<String[]> dataRows = new ArrayList<String[]>();
		if (batchSize > 0) {
			while (xmlReader.hasNext()) {
				xmlReader.next();
				if (xmlReader.isStartElement()) {
					if (xmlReader.getLocalName().equals(elementName)) {
						rowNum++;
						dataRows.add(getDataRow());
						if (dataRows.size() == batchSize)
							break;
					}
				}
			}
		}
		return dataRows;
	}

	private String[] getDataRow() throws XMLStreamException {
		List<String> rowValues = new ArrayList<String>();
		while (xmlReader.hasNext()) {
			xmlReader.next();
			if (xmlReader.isStartElement()) {
				if (xmlReader.getLocalName().equals("c")) {
					CellReference cellReference = new CellReference(xmlReader.getAttributeValue(null, "r"));
					// Fill in the possible blank cells!
					while (rowValues.size() < cellReference.getCol()) {
						rowValues.add("");
					}
					String cellType = xmlReader.getAttributeValue(null, "t");
					rowValues.add(getCellValue(cellType));
				}
			} else if (xmlReader.isEndElement() && xmlReader.getLocalName().equals("row")) {
				break;
			}
		}
		return rowValues.toArray(new String[rowValues.size()]);
	}

	private String getCellValue(String cellType) throws XMLStreamException {
		String value = ""; // by default
		while (xmlReader.hasNext()) {
			xmlReader.next();
			if (xmlReader.isStartElement()) {
				if (xmlReader.getLocalName().equals("v")) {
					if (cellType != null && cellType.equals("s")) {
						int idx = Integer.parseInt(xmlReader.getElementText());
						return new XSSFRichTextString(stringsTable.getEntryAt(idx)).toString();
					} else {
						String temp = xmlReader.getElementText();
						DateValidatorUsingDateFormat validator = new DateValidatorUsingDateFormat("MM/dd/yyyy");
						if (validator.isValid(temp)) {
							if (DateUtil.isADateFormat(14, temp)) {
								Date javaDate = DateUtil.getJavaDate(Double.parseDouble(temp));
								String date = new SimpleDateFormat("MM/dd/yyyy").format(javaDate);
								// Integer Check
								if (Integer.parseInt(date.split("/")[2]) > 1900
										&& Integer.parseInt(date.split("/")[2]) < 2100) {
									return date;
								}
							}
						}
						return temp;
					}
				}
			} else if (xmlReader.isEndElement() && xmlReader.getLocalName().equals("c")) {
				break;
			}
		}
		return value;
	}

	@Override
	public void finalize() throws Throwable {
		if (opcPkg != null)
			opcPkg.close();
		if (inputStream != null)
			inputStream.close();
		if (xmlReader != null)
			xmlReader.close();
		super.finalize();
	}

}
