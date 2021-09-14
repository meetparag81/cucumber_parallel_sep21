package com.botsftool.dsg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.botsftool.dsg.utilities.CustomMethods;

public class AddNewEmployeePage extends CustomMethods {

	public AddNewEmployeePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String Header = "//span[contains(@class,'stepPanelStatusIcon')]/preceding::span[1]";
	//public String InputLabel = "preceding::div[1]//bdi";
	public String InputLabel = "preceding::div[1]//span[1]";
	public String PanelInputLabel = "preceding::div[1]//span[contains(@class,'sapMLabelRequired')]";
	//public String InputTableLabel = "preceding::div[2]//bdi";
	public String InputTableLabel = "preceding::div[2]//span[1]";
	public String ContinueHire = "//*[text()='Continue']";
	public String IgnoreMatches = "//*[text()='Ignore Matches']";
	public String ConfirmNo = "//bdi[text()='No']/ancestor::button[1]";
	public String WarningCorrect = "//*[text()='Warning']//following::button[1]";
	public String WarningProceed = "//*[text()='Warning']//following::button[2]";
	public String ConfirmHire =  "//*[text()='Confirm']/ancestor::button[1]";
	public String ErrorOk =  "//*[text()='Error']/following::bdi[text()='OK']/ancestor::button[1]";
	public String DeleteJobRelation =  "(//*[text()='Job Relationships']/following::button[@title='Delete' and @class='sapMBtnBase sapMBtn'])";
	public String dependentDetailsInputs = "//section[@class='sapMPageEnableScrolling' and not(contains(@id, 'main'))]//input[@aria-required='true']";
	public String ErrorList = "//div[@role='alertdialog']//li";
	public String PanelAllInputs = "//div[contains(@id,'panel') and contains(@id,'content')]//input";
	
	@FindBy(xpath = "//*[text()='National ID Information' or text()='National ID' or text()='National Id Card']/following::tr[2]/td[text()='No data']")
	public WebElement NationalIDportlet;
	
	@FindBy(xpath = "//*[text()='National ID Information' or text()='National ID' or text()='National Id Card']/following::tr[2]//button[@title='Delete'][1]")
	public WebElement NationalIDDelete;
	
	@FindBy(xpath = "//*[text()='Email Information']/following::tr[2]/td[text()='No data']")
	public WebElement EmailInformationportlet;
	
	@FindBy(xpath = "//*[text()='Email Information']/following::tr[2]//button[@title='Delete'][1]")
	public WebElement EmailInformationDelete;
	
	@FindBy(xpath = "//*[text()='Phone Information']/following::tr[2]/td[text()='No data']")
	public WebElement PhoneInformationportlet;
	
	@FindBy(xpath = "//*[text()='Phone Information']/following::tr[2]//button[@title='Delete'][1]")
	public WebElement PhoneInformationDelete;
	
	@FindBy(xpath = "//*[text()='Compensation']/following::tr[2]/td[text()='No data']")
	public WebElement Compensationportlet;
	
	@FindBy(xpath = "//*[text()='Compensation']/following::tr[2]//button[@title='Delete'][1]")
	public WebElement CompensationDelete;
	
	@FindBy(xpath = "//*[text()='Recurring']/following::tr[2]/td[text()='No data']")
	public WebElement Recurringportlet;
	
	@FindBy(xpath = "//*[text()='Recurring']/following::tr[2]//button[@title='Delete'][1]")
	public WebElement RecurringDelete;
	
	@FindBy(xpath = "//*[text()='National ID Information' or text()='National ID' or text()='National Id Card']//following::button[1]")
	public WebElement NationalIDAdd;
	
	@FindBy(xpath = "//*[text()='Email Information']//following::button[1]")
	public WebElement EmailAdd;
	
	@FindBy(xpath = "//*[text()='Phone Information']//following::button[1]")
	public WebElement PhoneAdd;
	
	@FindBy(xpath = "//*[text()='Compensation']//following::button[1]")
	public WebElement CompensationAdd;
	
	@FindBy(xpath = "//*[text()='Recurring']//following::button[1]")
	public WebElement RecurringAdd;
	
	@FindBy(xpath = "//span[contains(text(),'Emergency Contact')]/ancestor::header/following::div[1]")
	public WebElement EmergencyContactPortlet;
	
	@FindBy(xpath = "//span[contains(text(),'Emergency Contact')]/ancestor::header[1]//button[@title='Delete'][1]")
	public WebElement EmergencyContactDelete;
	
	@FindBy(xpath = "//bdi[contains(text(),'Emergency Contact')]/ancestor::button[1]")
	public WebElement AddEmergencyContact;
	
	@FindBy(xpath = "//span[contains(text(),'Work')]/ancestor::header/following::div[1]")
	public WebElement AddWorkPermitPortlet;
	
	@FindBy(xpath = "//span[contains(text(),'Work')]/ancestor::header[1]//button[@title='Delete'][1]")
	public WebElement AddWorkPermitDelete;
	
	@FindBy(xpath = "//bdi[contains(text(),'Add Work')]/ancestor::button[1]")
	public WebElement WorkPermitAdd;
	
	@FindBy(xpath = "//span[contains(text(),'Dependents') or contains(text(),'Family Members')]/ancestor::header/following::div[1]")
	public WebElement AddDependentPortlet;
	
	@FindBy(xpath = "//span[contains(text(),'Dependents') or contains(text(),'Family Members')]//following::bdi[text()='Details']/ancestor::button[1]")
	public WebElement DependentDetails;
	
	@FindBy(xpath = "//*[text()='Copy Address from Employee']/following::div[1]//input[1]")
	public WebElement CopyAddressfromEmployee;
	
	@FindBy(xpath = "//span[contains(text(),'Dependents') or contains(text(),'Family Members')]/ancestor::header[1]//button[@title='Delete'][1]")
	public WebElement AddDependentDelete;
	
	@FindBy(xpath = "//bdi[contains(text(),'Add Dependents') or contains(text(),'Add Family Members')]/ancestor::button[1]")
	public WebElement AddDependents;
	
	@FindBy(xpath = "//span[contains(text(),'Address')]/ancestor::header/following::div[1]")
	public WebElement AddressesPortlet;
	
	@FindBy(xpath = "//span[contains(text(),'Address')]/ancestor::header[1]//button[@title='Delete'][1]")
	public WebElement AddressesDelete;
	
	@FindBy(xpath = "//bdi[contains(text(),'Add Address') or contains(text(),'Add Home Address')]/ancestor::button[1]")
	public WebElement AddAddresses;
	
	@FindBy(xpath = "//*[text()='Continue'][1]")
	public WebElement Continue;
	
	@FindBy(xpath = "//*[text()='Submit']/ancestor::button[1]")
	public WebElement Submit;
	
	@FindBy(xpath = "//*[text()='Cancel']/ancestor::button[1]")
	public WebElement Cancel;
	
	@FindBy(xpath = "//span[(contains(@class, 'StatusIconComplete')) and not(contains(@class, 'sapMBarChild'))]")
	public WebElement HireSuccessIcon;
	
	@FindBy(xpath = "//div[@role='alertdialog']")
	public WebElement dailogwindow;
	
	@FindBy(xpath = "//*[text()='Close']/ancestor::button[1]")
	public WebElement CloseError;
	
	@FindBy(xpath = "//span[contains(@id,'title-inner')]")
	public WebElement PanelContent;
	
	
	public AddNewEmployeePage waitforload(){
		waitForClickable(Continue);
		wait(5000);
		return this;
	}
}
