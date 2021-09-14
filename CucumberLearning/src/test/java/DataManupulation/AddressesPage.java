package DataManupulation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class AddressesPage extends CustomMethods {

	public AddressesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	} 

	@FindBy(xpath = "//*[text()='When would you like your changes to take effect?']/following::input[1]")
	public WebElement ChangeEffectiveDate;

	@FindBy(xpath = "(//button[contains(@title,'Add') and contains(@title,'Address')])[1]")
	public WebElement AddAddresses;
	
	@FindBy(xpath = "//*[text()='Address Type']")
	public WebElement AddressType;
	
	@FindBy(xpath = "//footer[@class='sapMPageFooter']//button[@title='Cancel']")
	public WebElement Cancel;
	
	@FindBy(xpath = "//footer[@class='sapMPageFooter']//button[@title='Save']")
	public WebElement Save;
	
	@FindBy(xpath = "//div[contains(@class,'BusyIndicator')]")
	public WebElement BusyIndicator;
	
	@FindBy(xpath = "//*[text()=\"Don't Save\"]/ancestor::button[1]")
	public WebElement DontSave;
	
	@FindBy(xpath = "//*[text()='Close']/ancestor::button[1]")
	public WebElement ErrorDailog;
	
	@FindBy(xpath = "//*[text()='Confirm']/ancestor::button[1]")
	public WebElement confirm;
	
	@FindBy(xpath = "//*[text()='Proceed']/ancestor::button[1]")
	public WebElement proceed;

	public String InputLabel = "preceding::div[1]/span[1]";
	public String InputTableLabel = "preceding::div[2]/span[1]";
	public String AddAddressesAllInputs = "//*[text()='Address Type']/ancestor::div[contains(@id,'panel')]//input";
	

	public AddressesPage waitforload(){
		waitForClickable(ChangeEffectiveDate);
		waitForTime(2000);
		return this;
	}

	//To click on Apply Terms Checkbox
	public AddressesPage AddNewAddresses(){
		waitForClickable(AddAddresses);
		click(AddAddresses);
		waitForTime(3000);
		try {
			waitForClickable(AddressType);
		}
		catch(Exception unabletoviewAddressType) {
			waitForTime(5000);
		}
		return this;
	}
	
	public AddressesPage CancelAddUpdateAddress(){
		waitForClickable(Cancel);
		click(Cancel);
		wait(3000);
		waitForClickable(DontSave);
		click(DontSave);
		wait(3000);
		return this;
	}

}
