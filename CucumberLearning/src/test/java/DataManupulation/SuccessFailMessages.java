package com.botsftool.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SuccessFailMessages {
	private XSSFWorkbook workBook;
	private XSSFSheet sheet;
	private String TableName;
	private String ProgramId;
	private String result;
	private String comments;
	public SuccessFailMessages(XSSFWorkbook workBook, XSSFSheet sheet, String tableName, String programId,
			String result, String comments) {
		super();
		this.workBook = workBook;
		this.sheet = sheet;
		TableName = tableName;
		ProgramId = programId;
		this.result = result;
		this.comments = comments;
	}
	public XSSFWorkbook getWorkBook() {
		return workBook;
	}
	public XSSFSheet getSheet() {
		return sheet;
	}
	public String getTableName() {
		return TableName;
	}
	public String getProgramId() {
		return ProgramId;
	}
	public String getResult() {
		return result;
	}
	public String getComments() {
		return comments;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}
