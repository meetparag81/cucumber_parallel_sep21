package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;
import testBase.BaseClass;
import utilities.Constants;

public class HomePageHire extends BaseClass {
	@FindBy(id = "utilityLinksMenuId")
	private WebElement UtilityMenu;

	@FindBy(linkText= "Proxy Now")
	private WebElement proxyNow;

	@FindBy(linkText= "Log out")
	private WebElement logout;

	@FindBy(linkText = "Become Self")
	private WebElement becomeself;

	@FindBy(xpath= "//input[@type='text']")
	private WebElement targetUsernameTextbox;
	@FindBy(xpath = "//*[text()='OK']/ancestor::button")
	private WebElement ok;




	private WebDriver driver;
	public HomePageHire(WebDriver driver) {
		super(driver);
		this.driver=driver;

	}

	public PeopleProfilePage ProxyNow(String proxyuser) throws InterruptedException
	{
		WaitForjQuerytoLoad();
		waitforPageLoad(driver);
		Thread.sleep(6500);
		WaitForClickable(UtilityMenu);
		Thread.sleep(2000);
		SendKeyPressToElement(UtilityMenu, "ENTER");
		WaitForClickable(proxyNow);
		SendKeyPressToElement(proxyNow, "ENTER");
		Thread.sleep(1000);
		EnterText(targetUsernameTextbox, proxyuser);
		WebDriverWait wait = new WebDriverWait(driver, Constants.WEBDRIVER_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody[@class='sapMListItems sapMTableTBody']/tr[1]")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//tbody[@class='sapMListItems sapMTableTBody']//tr//span[text()='‎(" + proxyuser + ")‎']")).click();
		SendKeyPressToElement(ok, "ENTER");
		WaitForjQuerytoLoad();
		Thread.sleep(6000);
		waitforPageLoad(driver);
		WaitForjQuerytoLoad();
		return new PeopleProfilePage(driver);	

	}
	
	
}
