package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.DriverFactory;
import testBase.BaseClass;
import utilities.WaitHelper;

public class LoginPageHire extends BaseClass {

	private WebDriver driver;
	//1.Bylocators:
	private @FindBy(id="j_username")WebElement username;
	private @FindBy(id="j_password")WebElement password;
	private @FindBy(id="logOnFormSubmit")WebElement loginbutton;

	private WaitHelper wait = new WaitHelper(DriverFactory.getDriver());
	//2.constructor:
	public LoginPageHire(WebDriver driver){

		super(driver);
		this.driver=driver;

	}
	//3.Actions:
	public String getLoginPageTitle() {
		return driver.getTitle();

	}

	public void  getUsername(String username) {
		this.username.sendKeys(username);
	}


	public void clickLoginbutton() {
		loginbutton.click();
	}


	public void getPassword(String password) {
		this.password.sendKeys(password);
	}
	public void clickonTheLoginButton() {

		loginbutton.click();

	}
	public HomePage LoginThePage(String username, String password){

		getUsername(username);
		getPassword(password);
		clickonTheLoginButton();

		return  new HomePage(driver);

	}




}



