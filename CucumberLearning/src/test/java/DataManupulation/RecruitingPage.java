package com.botsftool.dsg.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.botsftool.dsg.utilities.CustomMethods;

public class RecruitingPage extends CustomMethods {

	public RecruitingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[text()='Job Requisitions']")
	public WebElement JobRequisitions;

	@FindBy(xpath = "//*[text()='Create New']//ancestor::a[1]")
	public WebElement CreateNewRequisition;

	@FindBy(xpath = "//a[text()='Clear all filters']")
	public WebElement clearAllFilters;

	@FindBy(xpath = "//*[text()='Filter Job Requisitions']/following::select[1]")
	public WebElement FilterJobRequisitions;

	@FindBy(xpath = "//button[text()='Filter Options']")
	public WebElement FilterOptions;

	@FindBy(xpath = "//label[text()='Job Requisition ID:']/following::td[1]//input[1]")
	public WebElement JobRequisitionIDInput;

	@FindBy(xpath = "//button[@class=' globalPrimaryButton']")
	public WebElement UpdateScreen;

	@FindBy(xpath = "//div[@role='alertdialog']")
	public WebElement dailogwindow;

	/*@FindBy(xpath = "//*[text()='Forward Form to']/following::td[1]/input[1]")
	public WebElement approver;*/

	@FindBy(xpath = "//*[text()='Forward Form to']/following::td[1]")
	public WebElement approver;

	@FindBy(xpath = "//*[text()='Forward Form to']/following::td[1]/input")
	public WebElement approverID;

	@FindBy(xpath = "//a[contains(text(),'Job Postings')]")
	public WebElement JobPosting;

	@FindBy(xpath = "//a[@title='Corporate Posting' or @title='External Posting' or @title='External Career Site Posting']")
	public WebElement CorporatePosting;

	@FindBy(xpath = "//*[contains(text(),'Corporate Posting') or contains(text(),'External Posting') or contains(text(),'External Career Site Posting')]/ancestor::tr[1]/td[9]/input[@value='Post Job']")
	public WebElement PostJob;

	@FindBy(xpath = "//*[contains(text(),'Corporate Posting') or contains(text(),'External Posting') or contains(text(),'External Career Site Posting')]/ancestor::tr[1]/td[3]//input[@type='text']")
	public WebElement PostingStartDate;

	@FindBy(xpath = "//*[contains(text(),'Corporate Posting')  or contains(text(),'External Posting')or contains(text(),'External Career Site Posting')]/ancestor::tr[1]/td[5]//input[@type='text']")
	public WebElement PostingEndDate;

	@FindBy(xpath = "//a[text()='Add Candidate']")
	public WebElement AddCandidate;

	@FindBy(xpath = "//*[text()='Add Candidate']/ancestor::a[1]")
	public WebElement AddCandidateLink;

	@FindBy(xpath = "//*[text()='Add a Single Candidate']")
	public WebElement AddSingleCandidate;

	@FindBy(xpath = "//button[text()='Create Profile']")
	public WebElement CreateProfile;

	@FindBy(xpath = "//button[text()='Cancel']")
	public WebElement CancelUploadResume;

	@FindBy(xpath = "//button[text()='Upload']")
	public WebElement UploadResume;

	@FindBy(xpath = "//button[text()='OK']")
	public WebElement UploadOk;

	@FindBy(xpath = "//input[@type='file']")
	public WebElement ChooseFile;

	@FindBy(xpath = "//em[contains(text(),'Save')]/ancestor::button[1]")
	public WebElement SaveProfile;

	@FindBy(xpath = "//em[contains(text(),'Close Window')]/ancestor::button[1]")
	public WebElement CloseWindow;

	@FindBy(xpath = "//li[contains(@id,'BrowseTab')]")
	public WebElement CompetencyBrowseTab;

	@FindBy(xpath = "(//table[@class='browseTable']//a)[1]")
	public WebElement CompetenciesList;

	@FindBy(xpath = "(//table[@class='browseTable']//a)[2]")
	public WebElement CompetenciesSubList;

	@FindBy(xpath = "((//table[@class='browseTable']//a)[2]//following::div[1]//input[@type='checkbox'])[1]")
	public WebElement CompetenciesCheckBox;
	
	@FindBy(xpath = "//button[text()='Add']")
	public WebElement AddCompetencies;


	public String Inputs = "//div[@aria-label='Job Requisition Information']//input[not(contains(@style, 'none')) and not(contains(@type, 'hidden')) and not(contains(@id, 'Comp') or contains(@id, 'comp'))] | //select[contains(@id,'tor_wf_sect')] | //div[contains(@class,'multi-attachment')] | // div[@id='addMoreSection']";
	public String InputLabel = "ancestor::tr[1]/th[1]/label[1]";
	public String InputLabels = "ancestor::tr[2]/th[1]/label[1]";
	public String Submitbuttons = "//button[contains(@class,'globalPrimaryButton')]";
	public String ActionButtons = "//input[contains(@name,'save_change')]";
	public String RemoveButtons = "//*[text()='Remove']/following::a[1]";
	public String CandidateAllInputs = "//div[@id='candidate_profile']//input[not(contains(@type, 'hidden'))] | //select";
	public String CandidateAllInputsLabels = "ancestor::tr[1]//label";

	public RecruitingPage waitforload(){
		waitForClickable(JobRequisitions);
		return this;
	}

	public boolean ClickonJobPosting(){
		boolean result=false;
		waitForClickable(JobPosting);
		click(JobPosting);
		waitForTime(5000);
		/*List<WebElement> ActionElement = driver.findElements(By.xpath(ActionButtons));
		int elementcounter=1;
		for(int actioncounter=1;actioncounter<=ActionElement.size();actioncounter++) {
			WebElement action = driver.findElement(By.xpath("(//input[contains(@name,'save_change')])["+actioncounter+"]"));
			elementcounter=elementcounter+1;
			waitForClickable(action);
			waitForTime(1000);
			if(action.getAttribute("value").equals("Post Job")) {
				enterText(driver.findElement(By.xpath("//table[@aria-label='Job postings']//tr["+elementcounter+"]/td[3]//input[@placeholder='MM/DD/YYYY']")), getCurrentTimeStamp("MM/dd/yyyy"));
				waitForTime(2000);
				enterText(driver.findElement(By.xpath("//table[@aria-label='Job postings']//tr["+elementcounter+"]/td[5]//input[@placeholder='MM/DD/YYYY']")), getFutureTimeStamp("MM/dd/yyyy"));
				waitForTime(2000);
				click(action);
				waitForTime(8000);
			}
		}*/
		if(iselementExists(PostJob)) {
			String DateFormat = PostingStartDate.getAttribute("value");
			DateFormat=DateFormat.replace("D", "d");
			DateFormat=DateFormat.replace("m", "M");
			DateFormat=DateFormat.replace("Y", "y");
			enterText(PostingStartDate, getCurrentTimeStamp(DateFormat));
			waitForTime(2000);
			DateFormat = PostingEndDate.getAttribute("value");
			DateFormat=DateFormat.replace("D", "d");
			DateFormat=DateFormat.replace("m", "M");
			DateFormat=DateFormat.replace("Y", "y");
			enterText(PostingEndDate, getDateAfterDays(DateFormat,getRandomInteger(60, 30)));
			waitForTime(2000);
			click(PostJob);
			waitForTime(8000);
			result=true;
		}
		try {
			waitForClickable(CorporatePosting);
			waitForTime(2000);
			hoverElement(CorporatePosting);
			result=true;
		}
		catch(Exception unabletopost) {
			result=false;
		}
		return result;
	}

	public RecruitingPage ClickJobPosting(){
		waitForTime(3000);
		/*List<WebElement> ActionElement = driver.findElements(By.xpath(ActionButtons));
		int elementcounter=1;
		for(int actioncounter=1;actioncounter<=ActionElement.size();actioncounter++) {
			WebElement action = driver.findElement(By.xpath("(//input[contains(@name,'save_change')])["+actioncounter+"]"));
			elementcounter=elementcounter+1;
			waitForClickable(action);
			waitForTime(1000);
			if(action.getAttribute("value").equals("Post Job")) {
				enterText(driver.findElement(By.xpath("//table[@aria-label='Job postings']//tr["+elementcounter+"]/td[3]//input[@placeholder='MM/DD/YYYY']")), getCurrentTimeStamp("MM/dd/yyyy"));
				waitForTime(2000);
				enterText(driver.findElement(By.xpath("//table[@aria-label='Job postings']//tr["+elementcounter+"]/td[5]//input[@placeholder='MM/DD/YYYY']")), getFutureTimeStamp("MM/dd/yyyy"));
				waitForTime(2000);
				click(action);
				waitForTime(8000);
			}
		}*/
		if(iselementExists(PostJob)) {
			String DateFormat = PostingStartDate.getAttribute("value");
			DateFormat=DateFormat.replace("D", "d");
			DateFormat=DateFormat.replace("m", "M");
			DateFormat=DateFormat.replace("Y", "y");
			enterText(PostingStartDate, getCurrentTimeStamp(DateFormat));
			waitForTime(2000);
			DateFormat = PostingEndDate.getAttribute("value");
			DateFormat=DateFormat.replace("D", "d");
			DateFormat=DateFormat.replace("m", "M");
			DateFormat=DateFormat.replace("Y", "y");
			enterText(PostingEndDate, getDateAfterDays(DateFormat,getRandomInteger(60, 30)));
			waitForTime(2000);
			click(PostJob);
			waitForTime(8000);
		}
		waitForClickable(CorporatePosting);
		waitForTime(2000);
		hoverElement(CorporatePosting);
		return this;
	}


	public RecruitingPage SearchandselectRequisition(String ReqID){
		if(iselementExists(JobRequisitions)) {
			try {
				click(JobRequisitions);
				waitForTime(3000);
			}
			catch(Exception loadingfound) {
				try {
					while(iselementExists(driver.findElement(By.xpath("//div[@class='overlayShim']")))) {
						waitForTime(1000);
					}
				}
				catch(Exception loading) {
				}
				waitForTime(1000);
				click(JobRequisitions);
				waitForTime(3000);
			}
			try {
				while(iselementExists(driver.findElement(By.xpath("//div[@class='overlayShim']")))) {
					waitForTime(1000);
				}
			}
			catch(Exception loading) {
			}
		}

		if(iselementExists(clearAllFilters)) {
			click(clearAllFilters);
			waitForTime(3000);
			try {
				while(iselementExists(driver.findElement(By.xpath("//div[@class='overlayShim']")))) {
					waitForTime(1000);
				}
			}
			catch(Exception loading) {
			}
		}
		waitForClickable(FilterJobRequisitions);
		Select filterdropdown = new Select(FilterJobRequisitions);
		filterdropdown.selectByValue("OPENANDPENDING");
		waitForTime(5000);
		waitForClickable(FilterOptions);
		click(FilterOptions);
		waitForTime(5000);
		waitForClickable(JobRequisitionIDInput);
		enterText(JobRequisitionIDInput, ReqID);
		waitForTime(2000);
		click(UpdateScreen);
		waitForTime(3000);
		try {
			while(iselementExists(driver.findElement(By.xpath("//div[@class='overlayShim']")))) {
				waitForTime(1000);
			}
		}
		catch(Exception loading) {
		}
		waitForClickable(JobRequisitions);
		return this;
	}

	public RecruitingPage AddCandidate(){
		try {
			while(iselementExists(driver.findElement(By.xpath("//div[@class='overlayShim']")))) {
				waitForTime(1000);
			}
		}
		catch(Exception loading) {
		}
		waitForClickable(AddCandidateLink);
		waitForTime(2000);
		click(AddCandidateLink);
		waitForTime(3000);
		if(iselementExists(AddSingleCandidate)) {
			waitForClickable(AddSingleCandidate);
			waitForTime(2000);
			click(AddSingleCandidate);
			waitForTime(2000);
		}
		return this;
	}

	public RecruitingPage CreateProfile(){
		waitForClickable(CreateProfile);
		waitForTime(1000);
		click(CreateProfile);
		waitForTime(8000);
		return this;
	}

	public RecruitingPage CancelResumeUpload(){
		if(iselementExists(CancelUploadResume)) {
			waitForClickable(CancelUploadResume);
			waitForTime(1000);
			click(CancelUploadResume);
			waitForTime(2000);
		}
		return this;
	}

	public RecruitingPage ResumeUpload(){
		if(iselementExists(UploadResume)) {
			waitForClickable(UploadResume);
			waitForTime(1000);
			click(UploadResume);
			waitForTime(8000);
			if(iselementExists(UploadOk)) {
				click(UploadOk);
				waitForTime(2000);
			}
		}
		return this;
	}

	public RecruitingPage ChooseFile(String userFilePath) throws AWTException{
		if(iselementExists(UploadResume)) {
			waitForClickable(UploadResume);
			waitForTime(1000);
			waitForClickable(ChooseFile);
			waitForTime(2000);
			if(!userFilePath.isEmpty()) {
				ChooseFile.sendKeys(new CharSequence[] { userFilePath });
			}
			else {
				String filepath = System.getProperty("user.home").replaceAll("\\\\", "/")
						+"/RESOURCES/DSG/TEMPLATES/Dummy Resume.docx";
				ChooseFile.sendKeys(new CharSequence[] { filepath });
			}
			waitForTime(2000);
		}
		return this;
	}

	public RecruitingPage SaveandcloseCandidateProfile(){
		waitForClickable(SaveProfile);
		waitForTime(1000);
		click(SaveProfile);
		waitForTime(2000);
		int waitCounter=0;
		while(SaveProfile.getAttribute("aria-disabled").equals("false")) {
			waitForTime(1000);
			waitCounter=waitCounter+1;
			if(waitCounter>=10) {
				break;
			}
		}
		return this;
	}

	public String AddCompetencies(){
		String result="";
		try {
			waitForClickable(CompetencyBrowseTab);
			waitForTime(1000);
			click(CompetencyBrowseTab);
			waitForTime(2000);
			if(iselementExists(CompetenciesList)) {
				if(CompetenciesList.getAttribute("aria-expanded").equals("false")) {
					click(CompetenciesList);
					waitForTime(2000);
				}
				if(iselementExists(CompetenciesSubList)) {
					if(CompetenciesSubList.getAttribute("aria-expanded").equals("false")) {
						click(CompetenciesSubList);
						waitForTime(2000);
					}
				}
				if(iselementExists(CompetenciesCheckBox)) {
					if(CompetenciesCheckBox.findElement(By.xpath("following::label[1]/span")).getText().equalsIgnoreCase("Checkbox not checked")) {
						click(CompetenciesCheckBox);
						waitForTime(2000);
						result=CompetenciesCheckBox.findElement(By.xpath("following::label[1]")).getText();
						click(AddCompetencies);
						waitForTime(5000);
					}
				}
			}
		}
		catch(Exception failedtoselectcompetencies) {
			System.out.println("Failed to Add Competencies");
			result="";
		}
		return result;
	}

	public boolean VerifyCandidateProfile(){
		boolean savesucess=false;
		try {
			if(SaveProfile.getAttribute("aria-disabled").equals("true")) {
				savesucess=true;
			}
		}
		catch(Exception unabletosave) {
			savesucess=false;
		}
		return savesucess;
	}

	public RecruitingPage CloseCandidateProfileWindow(){
		waitForClickable(CloseWindow);
		waitForTime(1000);
		click(CloseWindow);
		return this;
	}

}
