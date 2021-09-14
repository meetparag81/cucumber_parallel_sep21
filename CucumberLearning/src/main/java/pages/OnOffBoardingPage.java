package pages;

import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;
import utilities.Constants;
import utilities.Utilities;

public class OnOffBoardingPage extends BaseClass {
	private WebDriver driver;
	@FindBy(linkText = "US Onboarding")
	private WebElement USOnBoarding;
	@FindBy(linkText = "Global Full Time Onboarding")
	private WebElement GlobalFullTimeOnBoarding;
	@FindBy(id = "onbMenuItem4-txt")
	private WebElement process;
	
	@FindBy(id = "bizxSubTab_ONBOARDING_DASHBOARD_PAGE")
	private WebElement OnOffBoardingDashboard;
	
	 @FindBy(xpath = "//input[@value= 'Start']")
	 private WebElement start;
	 
	 @FindBy(xpath = "//span[@aria-label='Is the new hire an internal employee?']/input[2]")
	 private WebElement IsthenewhireaninternalemployeeNo;
	 
	 @FindBy(xpath="//input[@value='Next']")
	 private WebElement Next;	 
	 
	 @FindBy(xpath = "//input[@aria-label='Previous Company Code']")
	 private WebElement previousCompanyCode;
	 
	 @FindBy(xpath="//*[text()='Start Date']/following::input[1]")	 
	 private WebElement startDate;
	 
	 @FindBy(xpath="//*[text()='First Name']/following::input[1]")
	  private WebElement firstName;
	 
	 @FindBy(xpath = "//*[text()='Company Code']/following::input[1]")
	 private WebElement companycode;
	 @FindBy(xpath = "//*[text()='Last Name']/following::input[1]")
	 private WebElement lastName;
	 @FindBy(xpath = "//label[text()='Personal Email Address']/ancestor::td[1]/following-sibling::td[1]//input[1]")
	 private WebElement personalEmailaddress;





	 
	 
		        

	 
	
		        

	
	         

	
	        


	public OnOffBoardingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	 public OnOffBoardingPage clickonUSOnboardingTab()
     {
         driver.switchTo().defaultContent();
         driver.switchTo().frame(driver.findElement(By.id("iframeForKMS")));
         SendKeyPressToElement(USOnBoarding, "ENTER");
         WaitForjQuerytoLoad();
         return this;
     }
	 
	 public OnOffBoardingPage SelectProcessfromOnOffBoardingDropdown() throws InterruptedException
	    {
	        WaitForjQuerytoLoad();
	        WaitForClickable(OnOffBoardingDashboard);
	        SendKeyPressToElement(OnOffBoardingDashboard, "ENTER");          
	        WaitForClickable(process);
	        Thread.sleep(10);
	       process.click();
	       // clickusingJavaScript(process);
	        Thread.sleep(1000);
	        waitforPageLoad(driver);
	        WaitForjQuerytoLoad();
	        return this;
	    }


	public OnOffBoardingPage clickonGlobalFullTimeOnboardingTab() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("iframeForKMS")));
        SendKeyPressToElement(GlobalFullTimeOnBoarding, "ENTER");
        WaitForjQuerytoLoad();
        return this;
    }


	public OnOffBoardingPage clickonStart() {
		 WaitForClickable(start);
         SendKeyPressToElement(start, "ENTER");
         waitforPageLoad(driver);
         WaitForjQuerytoLoad();
        
		return this;
		
		
	}


	public OnOffBoardingPage SwitchToFrame() throws InterruptedException {
		Thread.sleep(2000);
         driver.switchTo().defaultContent();
         driver.switchTo().frame(driver.findElement(By.id("iframeForKMS")));
         driver.switchTo().frame(driver.findElement(By.name("frmContent")));
         return this;	
		
	}


	public OnOffBoardingPage USPreverificationSteps() {
		
            WaitForClickable(Next);
            clickusingJavaScript(IsthenewhireaninternalemployeeNo);
            clickonStart();
            return this;
        
	}


	public void NewHireSetupInformation(String tdsstartDateType, String tdsstartDate, String tdscompanycode) {
        WaitForClickable(Next);
        Constants.firstname = Utilities.GenerateRandomString(5).toLowerCase();
        EnterText(firstName, Constants.firstname);
        Constants.lastname = Utilities.GenerateRandomString(5).toLowerCase();
        EnterText(lastName, Constants.lastname);
        EnterText(personalEmailaddress, Constants.firstname + "." + Constants.lastname + "@" + Utilities.GenerateRandomString(6).toLowerCase() + ".com");
        if (tdsstartDate == null || tdsstartDate == "")
        {
            tdsstartDate = Utilities.generateRandomDate(LocalDateTime.now().getDayOfMonth(), tdsstartDateType).ToString("MM/dd/yyyy");
        }
        Constants.startDate = tdsstartDate;
        EnterText(startDate, tdsstartDate);
        EnterText(tdscompanycode, tdscompanycode);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(.,'" + tdscompanycode + "')]")));
        SendKeyPressToElement(companycode, "DOWN");
        SendKeyPressToElement(companycode, "DOWN");
        SendKeyPressToElement(companycode, "ENTER");
        ClickOnNext();
        return this;
    }
	

}
