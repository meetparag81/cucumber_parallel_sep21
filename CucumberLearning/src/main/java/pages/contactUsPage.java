package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import factory.DriverFactory;
import utilities.WaitHelper;

public class contactUsPage {
	
	private WebDriver driver;
	//1.Bylocators:
	private By subjectHeading = By.id("id_contact");
	private By email = By.id("email");
	private By orderRef = By.id("id_order");
	private By messageText = By.id("message");
	private By sendButton = By.id("submitMessage");
	private By successMessg = By.cssSelector("div#center_column p");
private WaitHelper wait = new WaitHelper(DriverFactory.getDriver());
	//2.constructor:
	public contactUsPage(WebDriver driver){
		this.driver=driver;
	}
	//3.Actions:
	public String contactsPageTitle() {
		return driver.getTitle();
		
	}
	
	 public void fillContactUsForm(String heading, String emailId, String orderReference, String message) {
		 Select sel = new Select(driver.findElement(subjectHeading));
		 sel.selectByVisibleText(heading);
		
		
	}
	 
	 public void clickSend() {
			driver.findElement(sendButton).click();
		}
		
		public String getSuccessMessg() {
			return driver.findElement(successMessg).getText();
		}
	 
	 
	
	
	

}
