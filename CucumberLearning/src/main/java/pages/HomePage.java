package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import DataManupulation.AddNewEmployeePage;
import DataManupulation.CareersiteBuilderPage;
import DataManupulation.CompanyInfoPage;
import DataManupulation.CustomMethods;
import DataManupulation.LearningAdminPage;
import DataManupulation.ManageDataPage;
import DataManupulation.MyEmployeeFilePage;
import DataManupulation.RecruitingPage;
import utilities.Constants;





public class HomePage extends CustomMethods {

	public HomePage(WebDriver driver){
		super(driver);
	}

	@FindBy(xpath = "//input[@id='bizXSearchField-I']")
	public WebElement search;

	@FindBy(id = "sap-ui-blocklayer-popup")
	public WebElement sapPopup;

	@FindBy(id = "utilityLinksMenuId")
	public WebElement proxyMenu;

	@FindBy(xpath = "//a[text()='Proxy Now']")
	public WebElement proxyNow;

	@FindBy(xpath = "//*[contains(text(),'Please enter target user name')]//following::input[1]")
	public WebElement targetUser;

	@FindBy(xpath = "//*[text()='OK']/ancestor::button[1]")
	public WebElement OK;

	@FindBy(xpath = "//button[@id='customHeaderModulePickerBtn']")
	public WebElement HomeDropdown;
	
	@FindBy(xpath = "//span[text()='Tool Search']//following::input[1]")
	public WebElement ToolSearch;
	@FindBy(xpath="//div[@title='Learning Administration']")
	public WebElement learningAdmin;

	
	//To Search for Add New Employee Command
	public AddNewEmployeePage searchAddNewEmployee(){
		wait(5000);
		try {
			//waitForClickable(sapPopup);
			executeJavaScript("arguments[0].click();",sapPopup);
			wait(1000);
		}
		catch(Exception noPopupBlocker) {
			wait(10);
		}
		waitForClickable(search);
		String selectedValue = pick(search, "Add New Employee", "//input[@id='bizXSearchField-I']");
		if(!selectedValue.equals("Add New Employee")) {
			pickfromdropdown(search, "Add New Employee", "//input[@id='bizXSearchField-I']");
		}
		wait(10000);
		return new AddNewEmployeePage(driver);
	}

	//To Search for Add New Employee Command with SHTA Integration
	public AddNewEmployeePage searchAddNewEmployee(String SHTAIntegration){
		wait(5000);
		try {
			//waitForClickable(sapPopup);
			executeJavaScript("arguments[0].click();",sapPopup);
			wait(1000);
		}
		catch(Exception noPopupBlocker) {
			wait(10);
		}
		waitForClickable(search);

		//Liquid Automation Integration
		if(SHTAIntegration.equalsIgnoreCase("Yes")) {
			try {
				String Label = getElementLabel(driver, search);
				Constants.LabelHeader.add(Label);
				Constants.LabelValue.add("Add New Employee");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Failed to retrieve SHTA Integration label for Search");
			}
		}

		pick(search, "Add New Employee", "//input[@id='bizXSearchField-I']");
		wait(10000);
		return new AddNewEmployeePage(driver);
	}

	//To Search for ManageData Command
	public ManageDataPage searchManageData(){
		wait(5000);
		try {
			//waitForClickable(sapPopup);
			executeJavaScript("arguments[0].click();",sapPopup);
			wait(1000);
		}
		catch(Exception noPopupBlocker) {
			wait(10);
		}
		waitForClickable(search);
		String SelectedValue=pick(search, "Manage Data", "//input[@id='bizXSearchField-I']");
		if(!SelectedValue.equals("Manage Data")) {
			pickfromdropdown(search, "Manage Data", "//input[@id='bizXSearchField-I']");
		}
		wait(10000);
		return new ManageDataPage(driver);
	}

	//To Search for ManageData Command
	public ManageDataPage searchforManageData(){
		wait(5000);
		try {
			//waitForClickable(sapPopup);
			executeJavaScript("arguments[0].click();",sapPopup);
			wait(1000);
		}
		catch(Exception noPopupBlocker) {
			wait(10);
		}
		waitForClickable(search);
		String SelectedValue=pick(search, "Manage Data", "//input[@id='bizXSearchField-I']");
		if(!SelectedValue.equals("Manage Data")) {
			pickfromdropdown(search, "Manage Data", "//input[@id='bizXSearchField-I']");
		}
		wait(10000);
		return new ManageDataPage(driver);
	}

	//To Search for ManageData Command with SHTA Integration
	public ManageDataPage searchManageData(String SHTAIntegration){
		wait(5000);
		try {
			//waitForClickable(sapPopup);
			executeJavaScript("arguments[0].click();",sapPopup);
			wait(1000);
		}
		catch(Exception noPopupBlocker) {
			wait(10);
		}
		waitForClickable(search);

		//Liquid Automation Integration
		if(SHTAIntegration.equalsIgnoreCase("Yes")) {
			try {
				String Label = getElementLabel(driver, search);
				Constants.LabelHeader.add(Label);
				Constants.LabelValue.add("Manage Data");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Failed to retrieve SHTA Integration label for Search");
			}
		}
		pick(search, "Manage Data", "//input[@id='bizXSearchField-I']");
		wait(10000);
		return new ManageDataPage(driver);
	}

	//To Search for ManageData Command with SHTA Integration
	public HomePage verfiypopupBlocker(){
		wait(12000);
		try {
			//waitForClickable(sapPopup);
			executeJavaScript("arguments[0].click();",sapPopup);
			wait(1000);
		}
		catch(Exception noPopupBlocker) {
			wait(10);
		}
		return this;
	}

	//To procy the Target User
	public HomePage ProxyNow(String proxyUser){
		wait(12000);
		try {
			//waitForClickable(sapPopup);
			executeJavaScript("arguments[0].click();",sapPopup);
			wait(1000);
		}
		catch(Exception noPopupBlocker) {
			wait(2000);
		}
		try {
			waitForClickable(proxyMenu);
			wait(2000);
			click(proxyMenu);
			wait(1000);
			waitForClickable(proxyNow);
		}
		catch(Exception proxynownotfound) {
			wait(5000);
			waitForClickable(proxyMenu);
			wait(2000);
			click(proxyMenu);
			wait(1000);
			waitForClickable(proxyNow);
		}
		click(proxyNow);
		wait(1000);
		pickFromTargetUser(targetUser, proxyUser, "//*[contains(text(),'Please enter target user name')]//following::input[1]");
		wait(1000);
		waitForClickable(OK);
		click(OK);
		wait(10000);
		return this;
	}

	//To Search for Employee with SHTA Integration
	public CompanyInfoPage SelectfromHomeDropdown(String optiontoselect){
		wait(12000);
		try {
			//waitForClickable(sapPopup);
			executeJavaScript("arguments[0].click();",sapPopup);
			wait(1000);
		}
		catch(Exception noPopupBlocker) {
			wait(2000);
		}
		waitForClickable(HomeDropdown);
		wait(2000);
		click(HomeDropdown);
		wait(1000);
		try {
			click(driver.findElement(By.xpath("//a[text()='"+optiontoselect+"']")));
		}
		catch(Exception notfound) {
			wait(2000);
			waitForClickable(HomeDropdown);
			click(HomeDropdown);
			wait(1000);
			click(driver.findElement(By.xpath("//a[text()='"+optiontoselect+"']")));
		}
		wait(5000);
		return new CompanyInfoPage(driver);
	}

	//To Search for Employee with SHTA Integration
	public RecruitingPage SelectOptionHomeDropdown(String optiontoselect){
		wait(12000);
		try {
			//waitForClickable(sapPopup);
			executeJavaScript("arguments[0].click();",sapPopup);
			wait(1000);
		}
		catch(Exception noPopupBlocker) {
			wait(2000);
		}
		waitForClickable(HomeDropdown);
		wait(2000);
		click(HomeDropdown);
		wait(1000);
		try {
			click(driver.findElement(By.xpath("//a[text()='"+optiontoselect+"']")));
		}
		catch(Exception notfound) {
			wait(2000);
			waitForClickable(HomeDropdown);
			click(HomeDropdown);
			wait(1000);
			click(driver.findElement(By.xpath("//a[text()='"+optiontoselect+"']")));
		}
		wait(5000);
		return new RecruitingPage(driver);
	}

	//To Search for Employee with SHTA Integration
	public RecruitingPage SelectfromHomeMenu(String optiontoselect){
		wait(12000);
		try {
			executeJavaScript("arguments[0].click();",sapPopup);
			wait(1000);
		}
		catch(Exception noPopupBlocker) {
			wait(2000);
		}
		waitForClickable(HomeDropdown);
		wait(2000);
		click(HomeDropdown);
		wait(1000);
		try {
			click(driver.findElement(By.xpath("//a[text()='"+optiontoselect+"']")));
		}
		catch(Exception notfound) {
			wait(2000);
			waitForClickable(HomeDropdown);
			click(HomeDropdown);
			wait(1000);
			click(driver.findElement(By.xpath("//a[text()='"+optiontoselect+"']")));
		}
		wait(5000);
		return new RecruitingPage(driver);
	}

	//To Search for Employee 
	public MyEmployeeFilePage searchEmployeeData(String Employee){
		wait(5000);
		try {
			//waitForClickable(sapPopup);
			executeJavaScript("arguments[0].click();",sapPopup);
			wait(1000);
		}
		catch(Exception noPopupBlocker) {
			wait(10);
		}
		waitForClickable(search);
		pickEmployee(search, Employee, "//input[@id='bizXSearchField-I']");
		wait(10000);
		return new MyEmployeeFilePage(driver);
	}

	//To Search for Employee with SHTA Integration
	public MyEmployeeFilePage searchEmployeeData(String Employee,String SHTAIntegration){
		wait(10000);
		try {
			//waitForClickable(sapPopup);
			executeJavaScript("arguments[0].click();",sapPopup);
			wait(1000);
		}
		catch(Exception noPopupBlocker) {
			wait(10);
		}
		waitForClickable(search);

		//Liquid Automation Integration
		if(SHTAIntegration.equalsIgnoreCase("Yes")) {
			try {
				String Label = getElementLabel(driver, search);
				Constants.LabelHeader.add(Label);
				Constants.LabelValue.add(Employee);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Failed to retrieve SHTA Integration label for Search");
			}
		}
		pickEmployee(search, Employee, "//input[@id='bizXSearchField-I']");
		wait(10000);
		return new MyEmployeeFilePage(driver);
	}

	public CareersiteBuilderPage searchCareerSiteBuilder() throws InterruptedException {
		boolean flag=false;
		WebElement ToolSearchelement = wait.until(ExpectedConditions.elementToBeClickable(ToolSearch));
		//ToolSearch.sendKeys(input);
		while(ToolSearchelement.equals(null)) {
			wait(5);
		}
		ToolSearchelement.clear();
		ToolSearchelement.click();
		//pick(ToolSearch, input, "//span[text()='Tool Search']//following::input[1]");
		wait(10);
		ToolSearchelement.sendKeys("Manage career site builder");
		wait(5);
		try {
			driver.findElement(By.xpath("(//b[contains(text(),'Manage')])[1]//ancestor::li")).click();
			 flag = true;
		}
		catch (Exception e) {
			System.out.println("pickfunctioal doen'tclicked the element");
		}
		if(!flag) {
		try {
			WebElement dropdownoption= driver.findElement(By.xpath("(//b[contains(text(),'Manage')])[1]//ancestor::li"));
			dropdownoption.click();
			}catch(Exception e) {
			System.out.println("pickfunctioalready clicked the element");
		}
		}
		return  new CareersiteBuilderPage(driver);
		
	}
	public LearningAdminPage clickonLearningAdminstration() {
		learningAdmin.click();
		return new LearningAdminPage(driver);
		
	}

	public void searchManagePermisionRoles() {
		// TODO Auto-generated method stub
		
	}
}
