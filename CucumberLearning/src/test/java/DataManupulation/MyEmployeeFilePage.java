package DataManupulation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyEmployeeFilePage extends CustomMethods {

	public MyEmployeeFilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	} 
	
	@FindBy(xpath = "//div[contains(@class,'BusyIndicator')]")
	public WebElement BusyIndicator;
	
	@FindBy(xpath = "//div[contains(@id,'header')]//following::button[@title='Actions']")
	public WebElement Actions;
	
	@FindBy(xpath = "//*[text()='Terminate']//ancestor::li[1]")
	public WebElement Terminate;
	
	@FindBy(xpath = "(//*[text()='Terminate']//ancestor::li[1])[2]")
	public WebElement Terminate1;
	
	@FindBy(xpath = "//*[text()='Change Job and Compensation Info']//ancestor::li[1]")
	public WebElement changeJobCompInfo;
	
	@FindBy(xpath = "(//*[text()='Change Job and Compensation Info']//ancestor::li[1])[2]")
	public WebElement changeJobCompInfo1;
	
	@FindBy(xpath = "//div[@role='alertdialog']")
	public WebElement TerminatePopUp;
	
	@FindBy(xpath = "//div[@role='alertdialog']")
	public WebElement TransferPopUp;
	
	@FindBy(xpath = "//div[@role='alertdialog']")
	public WebElement AddressesPopUp;
	
	@FindBy(xpath = "//*[text()='Close']/ancestor::button[1]")
	public WebElement ClosePopup;
	
	@FindBy(xpath = "(//a[contains(@class,'headerFullName')])[2]")
	public WebElement EmployeeFullName;
	
	@FindBy(xpath = "(//div[contains(text(),'Address')])[1]")
	public WebElement AddressSection;
	
	@FindBy(xpath = "//button[contains(@title,'Edit') and contains(@title,'Address') ]")
	public WebElement EditAddresses;
	
	public MyEmployeeFilePage waitforload(){
		waitForClickable(Actions);
		waitForTime(2000);
		return this;
	}
	
	public TerminatePage TerminateEmployee(){
		waitForClickable(Actions);
		click(Actions);
		wait(1000);
		if(iselementExists(Terminate)) {
			waitForClickable(Terminate);
			click(Terminate);
		}
		else if(iselementExists(Terminate1)) {
			waitForClickable(Terminate1);
			click(Terminate1);
		}
		wait(5000);
		return new TerminatePage(driver);
	}
	
	public TerminatePage ChangeJobCompInfo(){
		waitForClickable(Actions);
		click(Actions);
		wait(1000);
		if(iselementExists(changeJobCompInfo)) {
			waitForClickable(changeJobCompInfo);
			click(changeJobCompInfo);
		}
		else if(iselementExists(changeJobCompInfo1)) {
			waitForClickable(changeJobCompInfo1);
			click(changeJobCompInfo);
		}
		wait(5000);
		return new TerminatePage(driver);
	}

}
