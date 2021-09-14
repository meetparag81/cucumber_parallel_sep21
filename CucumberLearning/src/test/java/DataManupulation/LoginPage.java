package DataManupulation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CustomMethods{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@name='username']")
	public WebElement userName;

	@FindBy(xpath = "//input[contains(@placeholder,'E-Mail')]")
	public WebElement Email;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement passwords;

	@FindBy(xpath = "//*[text()='Log in']/ancestor::button[1]")
	public WebElement LogIn;
	
	@FindBy(xpath = "//*[text()='Continue']")
	public WebElement Continue;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement SignIn;

	@FindBy(xpath = "//button[text()='Log On']")
	public WebElement LogOn;

	@FindBy(xpath = "//input[@placeholder='Enter Company ID']")
	public WebElement CompanyID;

	@FindBy(xpath = "//button[@title='Submit']")
	public WebElement Submit;

	//To Load URL
	public LoginPage LoadURL(String URL){
		driver.get(URL);
		wait(10000);
		return this;
	}
	
	public LoginPage LoadExternalURL(String URL){
		driver.get(URL);
		wait(10000);
		return this;
	}

	//To Load URL with SHTA Integration
	public LoginPage LoadURL(String URL,String SHTAIntegration){
		driver.get(URL);
		//Liquid Automation Integration
		if(SHTAIntegration.equalsIgnoreCase("Yes")) {
			Constants.LabelHeader.add("url");
			Constants.LabelValue.add(URL);
		}
		wait(5000);
		return this;
	}

	//Method to enter Company ID
	public LoginPage EnterCompanyID(String companyID){
		if(iselementExists(CompanyID)){
			enterText(CompanyID, companyID);
			click(Submit);
			wait(5000);
		}
		return this;
	}

	//Method to enter Company ID with SHTA Integration
	public LoginPage EnterCompanyID(String companyID,String SHTAIntegration){
		if(iselementExists(CompanyID)){
			enterText(CompanyID, companyID);
			//Liquid Automation Integration
			if(SHTAIntegration.equalsIgnoreCase("Yes")) {
				try {
					String Label = getElementLabel(driver, CompanyID);
					Constants.LabelHeader.add(Label);
					Constants.LabelValue.add(companyID);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Failed to retrieve SHTA Integration label for Company ID");
				}
			}
			click(Submit);
			wait(5000);
		}
		return this;
	}

	//Method to Login to application
	public HomePage Login(String sUsername,String sPassword){
		wait(5000);
		if(iselementExists(userName))  {
			waitForClickable(userName);
			enterText(userName, sUsername);
			wait(1000);
			enterText(password, sPassword);
			//To perform Login/SignIn
			if(iselementExists(SignIn)) {
				click(SignIn);
				System.out.println("Login Step Executed");
			}
			else if(iselementExists(LogIn)) {
				click(LogIn);
				System.out.println("Login Step Executed");
			}
		}
		else if(iselementExists(Email)) {
			waitForClickable(Email);
			enterText(Email, sUsername);
			wait(2000);
			
			if(iselementExists(Continue)) {
				click(Continue);
				wait(2000);
			}
			
			enterText(passwords, sPassword);

			//To perform Login/SignIn
			if(iselementExists(LogOn)) {
				click(LogOn);
				System.out.println("Login Step Executed");
			}
		}
		else {
			System.out.println("Failed to execute Login Step");
		}
		wait(5000);
		return new HomePage(driver);
	}

	//Method to Login to application with SHTA Integartion
	public HomePage Login(String sUsername,String sPassword,String SHTAIntegration){
		wait(5000);
		if(iselementExists(userName)) {
			waitForClickable(userName);
			enterText(userName, sUsername);
			if(SHTAIntegration.equalsIgnoreCase("Yes")) {
				//Liquid Automation Integration
				try {
					String Label = getElementLabel(driver, userName);
					Constants.LabelHeader.add(Label);
					Constants.LabelValue.add(sUsername);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Failed to retrieve SHTA Integration label for UserName");
				}
			}
			enterText(password, sPassword);
			//Liquid Automation Integration
			if(SHTAIntegration.equalsIgnoreCase("Yes")) {
				try {
					String Label = getElementLabel(driver, password);
					Constants.LabelHeader.add(Label);
					Constants.LabelValue.add(sPassword);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Failed to retrieve SHTA Integration label for Password");
				}
			}
			//To perform Login/SignIn
			if(iselementExists(SignIn)) {
				click(SignIn);
			}
			else if(iselementExists(LogIn)) {
				click(LogIn);
			}
		}
		else if(iselementExists(Email)) {
			waitForClickable(Email);
			enterText(Email, sUsername);
			if(SHTAIntegration.equalsIgnoreCase("Yes")) {
				//Liquid Automation Integration
				try {
					String Label = getElementLabel(driver, Email);
					Constants.LabelHeader.add(Label);
					Constants.LabelValue.add(sUsername);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Failed to retrieve SHTA Integration label for Email");
				}
			}
			
			if(iselementExists(Continue)) {
				click(Continue);
				wait(2000);
			}
			
			enterText(passwords, sPassword);
			//Liquid Automation Integration
			if(SHTAIntegration.equalsIgnoreCase("Yes")) {
				try {
					String Label = getElementLabel(driver, passwords);
					Constants.LabelHeader.add(Label);
					Constants.LabelValue.add(sPassword);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Failed to retrieve SHTA Integration label for Password");
				}
			}

			//To perform Login/SignIn
			if(iselementExists(LogOn)) {
				click(LogOn);
			}
		}
		wait(5000);
		return new HomePage(driver);
	}
}
