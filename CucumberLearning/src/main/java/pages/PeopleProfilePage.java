package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class PeopleProfilePage extends BaseClass {
	private WebDriver driver;
	
	@FindBy(id = "customHeaderModulePickerBtn")
	        private WebElement Home;
	


	
	
	        



	public PeopleProfilePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	
	public OnOffBoardingPage SelectOptionfromHomeDropdown(String option)
    {
        WaitForjQuerytoLoad();
        WaitForClickable(Home);
        SendKeyPressToElement(Home, "ENTER");
        WebElement selection = driver.findElement(By.linkText(option));
        WaitForClickable(selection);
        SendKeyPressToElement(selection, "ENTER");
        waitforPageLoad(driver);
        //WaitForjQuerytoLoad();
        return new OnOffBoardingPage(driver);
    }
	
	
	

}
