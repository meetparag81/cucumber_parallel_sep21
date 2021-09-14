package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;
import utilities.WaitHelper;

public class LoginPage {
	
	private WebDriver driver;
	//1.Bylocators:
	private By Username= By.id("email");
	private By loginbutton = By.id("SubmitLogin");
	private By Password= By.id("passwd");
	private By forgotpasswordlink=By.partialLinkText("Forgot your password?");
	private By LoginLink=By.partialLinkText("Sign in");
	private WaitHelper wait = new WaitHelper(DriverFactory.getDriver());
	//2.constructor:
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	//3.Actions:
	public String getLoginPageTitle() {
		return driver.getTitle();
		
	}
	public boolean Isforgotfasswordlink(){
		return driver.findElement(forgotpasswordlink).isDisplayed();
	}
	public void  getUsername(String username) {
		driver.findElement(Username).sendKeys(username);
	}
	public WebElement  getUsername() {
		return driver.findElement(Username);
		
	}
	
	public void clickLoginbutton() {
		driver.findElement(loginbutton).click();
	}
	
	
	public void getPassword(String password) {
		driver.findElement(Password).sendKeys(password);
	}
	public void clickonTheLoginLink() {
		
		driver.findElement(LoginLink).click();
		
	}
	public AccountsPage LoginThePage(String username, String password){
		wait.Clicable(DriverFactory.getDriver(), driver.findElement(Username), 30);
		driver.findElement(Username).sendKeys(username);
		driver.findElement(Password).sendKeys(password);
		driver.findElement(loginbutton).click();
		return  new AccountsPage(driver);
		
	}
	
		
	

}
