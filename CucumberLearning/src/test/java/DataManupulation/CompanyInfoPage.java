package com.botsftool.dsg.pages;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.botsftool.dsg.utilities.CustomMethods;

public class CompanyInfoPage extends CustomMethods {

	public CompanyInfoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[text()='Position Org Chart']")
	public WebElement positionOrgChartLink;

	@FindBy(xpath = "(//div[@class='buttonLayout']//button)[2]")
	public WebElement DontSave;

	@FindBy(xpath = "//*[text()='Search']/child::span[1]//input[1]")
	public WebElement searchPosition;

	@FindBy(xpath = "//a[@title='Show Menu']")
	public WebElement showMenu;

	@FindBy(xpath = "//a[@title='Create Job Requisition']")
	public WebElement CreateJobRequisition;

	@FindBy(xpath = "//label[text()='Date of New Job Requisition']/following::td[1]//input[1]")
	public WebElement DateofNewJobRequisition;

	@FindBy(xpath = "//label[text()='Job Requisition Template']//following::td[1]//span[@class='toggle']")
	public WebElement JobRequisitionTemplatedropdown;

	@FindBy(xpath = "//a[text()='Requisition - Standard']")
	public WebElement JobRequisitionstandard;

	@FindBy(xpath = "//label[text()='Number of Openings']/following::td[1]//input[1]")
	public WebElement NumberofOpenings;

	@FindBy(xpath = "//button[text()='Create']")
	public WebElement CreateRequisition;

	@FindBy(xpath = "//a[text()='Job Requisition Details']")
	public WebElement JobRequisitionDetailsSection;

	@FindBy(xpath = "//a[text()='Job Requisition Details']/following::div[@class='sidepanelsubsection']//td[text()='Id' or text()='ID']/following::td[1]")
	public WebElement RequisitionID;

	@FindBy(xpath = "//button[@id='customHeaderModulePickerBtn']")
	public WebElement HomeDropdown;

	@FindBy(xpath = "//div[@role='alertdialog']")
	public WebElement dailogwindow;

	//To wait for Company Org chart to be Loaded
	public CompanyInfoPage waitforload(){
		waitForClickable(positionOrgChartLink);
		waitForTime(3000);
		return this;
	}

	//To Search for positions under Org chart
	public String SearchPosition(String positionID){
		String result = "";
		waitForClickable(positionOrgChartLink);
		click(positionOrgChartLink);
		waitForTime(5000);
		try {
			int waitCounter=0;
			while(iselementExists(driver.findElement(By.xpath("//div[@class='loadingShim' and not(contains(@style,'display: none;'))]")))) {
				waitForTime(1000);
				waitCounter=waitCounter+1;
				if(waitCounter>=20) {
					break;
				}
			}
		}
		catch(Exception loading) {
		}
		waitForTime(2000);
		result = pickpositions(searchPosition, positionID, "//*[text()='Search']/child::span[1]//input[1]");
		waitForTime(5000);
		return result;
	}

	//To Select position and select Create New Job Requisition Menu
	public CompanyInfoPage clickonCreateJobRequsition(String positionID){
		waitForClickable(driver.findElement(By.xpath("//a[contains(@title,'"+positionID+"')]")));
		WebElement orgChart = driver.findElement(By.xpath("//a[contains(@title,'"+positionID+"')]"));
		click(orgChart);
		waitForTime(2000);
		waitForClickable(showMenu);
		click(showMenu);
		waitForTime(2000);
		waitForClickable(CreateJobRequisition);
		click(CreateJobRequisition);
		waitForTime(5000);
		return this;
	}

	//To Enter details under manage Job Requisition
	public CompanyInfoPage ManageJobRequisition(String DateofRequisition, String RequsitionTemplateType, String NoofOpenings) throws ParseException{
		waitForClickable(CreateRequisition);
		//To clear the date feild and enter new Value
		DateofNewJobRequisition.clear();
		waitForTime(2000);
		String DateFormat = DateofNewJobRequisition.getAttribute("value");
		DateFormat=DateFormat.replace("D", "d");
		DateFormat=DateFormat.replace("m", "M");
		DateFormat=DateFormat.replace("Y", "y");
		System.out.println("Format of Date of New Job requisition is "+DateFormat);
		if(!DateofRequisition.isEmpty()) {
			enterText(DateofNewJobRequisition, parseandFormatDate(DateofRequisition, "MM/dd/yyyy", DateFormat));
		}
		else {
			enterText(DateofNewJobRequisition, getCurrentTimeStamp(DateFormat));
		}
		waitForTime(2000);
		if(iselementExists(JobRequisitionTemplatedropdown)) {
			click(JobRequisitionTemplatedropdown);
			waitForTime(5000);
			if(!RequsitionTemplateType.isEmpty()) {
				if(iselementExists(driver.findElement(By.xpath("//a[contains(@class,'globalMenuItem') and text()='"+RequsitionTemplateType+"']")))) {
					click(driver.findElement(By.xpath("//a[contains(@class,'globalMenuItem') and text()='"+RequsitionTemplateType+"']")));
				}
				else {
					System.out.println("Failed to Select the Job Requisition Template");
				}
			}
			else {
				click(driver.findElement(By.xpath("//a[contains(@class,'globalMenuItem') and text()='Requisition - Standard']")));
			}
			waitForTime(2000);
		}
		if(!NoofOpenings.isEmpty() && iselementExists(NumberofOpenings)) {
			enterText(NumberofOpenings, NoofOpenings);
		}
		else {
			if(iselementExists(NumberofOpenings)) {
				enterText(NumberofOpenings, "1");
			}
		}
		waitForTime(2000);
		click(CreateRequisition);
		return this;
	}

	//To Search for Position Keyword
	public String GetRequisitionID(String positionID){
		String result = "";
		wait(10000);
		try {
			waitForClickable(driver.findElement(By.xpath("//a[contains(@title,'"+positionID+"')]")));
			wait(2000);
			WebElement orgChart = driver.findElement(By.xpath("//a[contains(@title,'"+positionID+"')]"));
			wait(1000);
			click(orgChart);
		}
		catch(Exception orchartnotdisplayed) {
			wait(5000);
			int waitCounter=0;
			try {
				while(iselementExists(driver.findElement(By.xpath("//div[@class='loadingShim' and not(contains(@style,'display: none;'))]")))) {
					waitForTime(1000);
					waitCounter=waitCounter+1;
					if(waitCounter>=10) {
						break;
					}
				}
			}
			catch(Exception loading) {
				wait(5000);
			}
			waitForClickable(driver.findElement(By.xpath("//a[contains(@title,'"+positionID+"')]")));
			wait(2000);
			WebElement orgChart = driver.findElement(By.xpath("//a[contains(@title,'"+positionID+"')]"));
			wait(2000);
			click(orgChart);
		}
		wait(5000);
		waitForClickable(JobRequisitionDetailsSection);
		click(JobRequisitionDetailsSection);
		wait(5000);
		try {
			waitForClickable(RequisitionID);
			result = RequisitionID.getText().trim();
			if(result.isEmpty()) {
				wait(3000);
				waitForClickable(RequisitionID);
				result = RequisitionID.getText().trim();
			}
		}
		catch(Exception requistionnotfound) {
			wait(3000);
			waitForClickable(RequisitionID);
			result = RequisitionID.getText().trim();
		}
		wait(3000);
		return result;
	}

	//To Select Menu From dropdown
	public RecruitingPage SelectfromHomeDropdown(String optiontoselect){
		waitForClickable(HomeDropdown);
		click(HomeDropdown);
		wait(1000);
		click(driver.findElement(By.xpath("//a[text()='"+optiontoselect+"']")));
		wait(5000);
		return new RecruitingPage(driver);
	}

}
