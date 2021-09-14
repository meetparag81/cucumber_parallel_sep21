package DataManupulation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ApplyforJobPage extends CustomMethods {

	public ApplyforJobPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//button[@id='_apply_showhide']")
	public WebElement ClosePopUp;
	
	@FindBy(xpath = "//button[@id='cookie-accept']")
	public WebElement acceptCookies;

	@FindBy(xpath = "(//a[contains(text(),'Apply now')])[1]")
	public WebElement ApplyNow;

	@FindBy(xpath = "(//button[contains(text(),'Apply')])[1]")
	public WebElement Apply;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	public WebElement SearchJobs;

	@FindBy(xpath = "//label[contains(text(),'Requisition ID')]/following::td[1]/input[@type='text']")
	public WebElement RequisitionID;

	@FindBy(xpath = "//label[contains(text(),'Keywords')]/following::td[1]//input[@type='text']")
	public WebElement Keywords;

	@FindBy(xpath = "//label[contains(text(),'Exact Match')]/preceding::a[@role='checkbox']")
	public WebElement ExactMatchCheckbox;

	@FindBy(xpath = "(//a[contains(text(),'Create an account')])[1]")
	public WebElement CreateanAccount;

	@FindBy(xpath = "(//button[contains(text(),'Create Account')])[1]")
	public WebElement CreateAccount;

	@FindBy(xpath = "(//a[contains(text(),'Read and accept')])[1]")
	public WebElement ReadandAcceptTerms;

	@FindBy(xpath = "//button[text()='Accept']")
	public WebElement AcceptTerms;

	@FindBy(xpath = "//button[text()='I understand']")
	public WebElement IUnderstand;
	
	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement Continue;

	@FindBy(xpath = "//a[text()='Expand all sections']")
	public WebElement ExpandAllSections;

	@FindBy(xpath = "//input[@type='CHECKBOX' and contains(@name,'cust_disclaimer')]")
	public WebElement AcceptCheckbox;

	@FindBy(xpath = "//span[text()='Apply']")
	public WebElement ApplyJob;

	@FindBy(xpath = "//*[text()='Upload a Resume Opens a dialog']/preceding::span[@role='button']")
	public WebElement UploadResume;

	@FindBy(xpath = "//label[contains(text(),'Resume')]/span[@class='requiredField']")
	public WebElement UploadResumeLabel;

	@FindBy(xpath = "//div[contains(@id,'attachOptions')]")
	public WebElement ChooseFile;

	@FindBy(xpath = "(//a[@class='jobTitle'])[1]")
	public WebElement JobTitle;
	
	@FindBy(xpath = "(//a[text()='Select Action'])[1]")
	public WebElement SelectAction;
	
	@FindBy(xpath = "//*[text()='Apply']")
	public WebElement SelectApply;
	

	public String AllCreateAccountInputs = "//table[@id='fieldsContainer']//input | //select";
	public String AllCandidateFormInputs = "//div[@id='rcmJobApplicationCtr']//input[not(contains(@type, 'CHECKBOX'))] | //select";
	public String AllRadioInputs = "//div[@id='rcmJobApplicationCtr']//a[@role='radio']";
	public String InputLabel = "ancestor::tr[1]/td[1]//label[1]";
	public String InputLabel1 = "ancestor::tr[2]/td[1]//label[1]";
	public String InputLabel2 = "preceding::tr[1]/td[1]/label[1]";
	public String InputLabel3 = "preceding::label[1]";
	public String RadioInputLabel = "ancestor::div[contains(@class,'Question')]/label[1]";
	public String RemoveButtons = "//div[text()='Remove']//span[@class='hiddenAriaContent' and string-length(@aria-label) > 0]/ancestor::div[@title='Delete Row']";


	//Method to click on Apply Now Button
	public ApplyforJobPage ApplyNowforJob(String ReqID, String keywords){

		//To Hanlde Search Jobs Section
		if(iselementExists(SearchJobs)) {
			if(iselementExists(RequisitionID)) {
				waitForClickable(RequisitionID);
				enterText(RequisitionID, ReqID);
				waitForTime(5000);
			}
			else {
				waitForClickable(Keywords);
				enterText(Keywords, keywords);
				waitForTime(1000);
				click(ExactMatchCheckbox);
				waitForTime(5000);
			}
			click(SearchJobs);
			waitForTime(5000);
			try {
				waitForClickable(JobTitle);
				waitForTime(2000);
				click(driver.findElement(By.xpath("//*[text()='"+ReqID.trim()+"']//following::td[1]//a[text()='Select Action']")));
				waitForTime(2000);
				click(SelectApply);
				
			}
			catch(Exception timeout) {
				waitForTime(8000);
				waitForClickable(JobTitle);
				waitForTime(2000);
				click(JobTitle);
			}
		}

		//To handle Apply Now
		waitForTime(12000);
		try {
			//waitForClickable(sapPopup);
			executeJavaScript("arguments[0].click();",ClosePopUp);
			waitForTime(2000);
		}
		catch(Exception noPopupBlocker) {
			waitForTime(1000);
		}
		
		try {
			//waitForClickable(sapPopup);
			executeJavaScript("arguments[0].click();",acceptCookies);
			waitForTime(2000);
		}
		catch(Exception noPopupBlocker) {
			waitForTime(1000);
		}

		if(iselementExists(ApplyNow)) {
			waitForClickable(driver.findElement(By.xpath("(//a[contains(text(),'Apply now')])[1]")));
			waitForClickable(ApplyNow);
			click(ApplyNow);
		}
		else if(iselementExists(Apply)) {
			waitForClickable(driver.findElement(By.xpath("(//button[contains(text(),'Apply')])[1]")));
			waitForClickable(Apply);
			click(Apply);
		}
		waitForTime(8000);
		return this;
	}

	//To click on Create An Account
	public ApplyforJobPage CreateanAccount(){
		waitForTime(2000);
		try {
			waitForClickable(CreateanAccount);
			click(CreateanAccount);
		}
		catch(Exception objectnotfound) {
			waitForTime(8000);
			waitForClickable(driver.findElement(By.xpath("(//a[contains(text(),'Create an account')])[1]")));
			click(driver.findElement(By.xpath("(//a[contains(text(),'Create an account')])[1]")));
		}
		waitForTime(5000);
		return this;
	}

	//To Click on Create Account and submit the candidate
	public ApplyforJobPage CreateAccount(){
		if(iselementExists(ReadandAcceptTerms)) {
			waitForClickable(ReadandAcceptTerms);
			click(ReadandAcceptTerms);
			waitForTime(5000);
			if(iselementExists(AcceptTerms)) {
				waitForClickable(AcceptTerms);
				click(AcceptTerms);
			}
			else if(iselementExists(IUnderstand)) {
				waitForClickable(IUnderstand);
				click(IUnderstand);
			}
			else if(iselementExists(Continue)) {
				waitForClickable(Continue);
				click(Continue);
			}
			waitForTime(3000);
		}
		waitForClickable(CreateAccount);
		click(CreateAccount);
		waitForTime(12000);
		return this;
	}

	//Expand all Section under candidate creation
	public ApplyforJobPage ExpandAllSections(){
		waitForTime(2000);
		waitForClickable(ExpandAllSections);
		click(ExpandAllSections);
		waitForTime(3000);
		return this;
	}

	//To click on Apply Terms Checkbox
	public ApplyforJobPage AcceptTerms(){
		if(iselementExists(AcceptCheckbox)) {
			waitForClickable(AcceptCheckbox);
			click(AcceptCheckbox);
			waitForTime(3000);
		}
		return this;
	}

	//To click on Apply Terms Checkbox
	public ApplyforJobPage ApplyforJob(){
		waitForClickable(ApplyJob);
		click(ApplyJob);
		return this;
	}

	public ApplyforJobPage ResumeUpload(String userFilePath){
		boolean fileUpload=false;
		if(iselementExists(UploadResumeLabel)) {
			if(iselementExists(UploadResume)) {
				waitForClickable(UploadResume);
				waitForTime(1000);
				click(UploadResume);
				waitForTime(3000);
				if(iselementExists(ChooseFile)) {
					waitForClickable(ChooseFile);
					waitForTime(2000);
					click(ChooseFile);
					waitForTime(5000);
					try {
						Thread fileUploadThread = new Thread(new FileUpload (userFilePath));
						fileUploadThread.start();
						fileUpload=true;
					}
					catch(Exception threadfailedtoExecute) {
						fileUpload=false;
					}
					if(fileUpload) {
						System.out.println("Resume Upload Successfull");
						waitForTime(5000);
					}
					else {
						System.out.println("Resume Upload Failed");
						waitForTime(5000);
					}
				}
			}
		}
		return this;
	}

}
