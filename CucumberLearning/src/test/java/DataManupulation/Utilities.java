package DataManupulation;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Function;
import com.thoughtworks.selenium.*;

import DataManupulation.Constnts.BOTSF_AutoConfig_Constants;
import au.com.bytecode.opencsv.CSVReader;

@SuppressWarnings("deprecation")
public class Utilities {
	static Logger logger = Logger.getLogger(Utilities.class.getName());

	public static WebElement waitForElementPresent(WebDriver driver, final By by, int timeOutInSeconds) {
		WebElement element;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify
																			// implicitlyWait()
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // reset
																				// implicitlyWait
			return element; // return the element
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error StackTrace :", e);
		}
		return null;
	}
	
	
	public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		 //Convert web driver object to TakeScreenshot
		 TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		 //Call getScreenshotAs method to create image file
		 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		 //Move image file to new destination
		 File DestFile=new File(fileWithPath);
		 //Copy file at destination
		 FileUtils.copyFile(SrcFile, DestFile);

	 }

	public void waitForPresence(WebDriver driver, Selenium selenium, String element) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
		WebElement myElement = driver.findElement(By.xpath(element));
		scrollToElement(driver, myElement);
	}

	public void waitForPresenceProv(WebDriver driver, Selenium selenium, String element) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
	}

	public void waitForVisibility(WebDriver driver, Selenium selenium, String element) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		WebElement myElement = driver.findElement(By.xpath(element));
		scrollToElement(driver, myElement);
	}

	public void waitForPresence5(WebDriver driver, Selenium selenium, String element) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	}

	public WebElement getVisibleELement(WebDriver driver, Selenium selenium, String element) throws Exception {
		List<WebElement> elements = driver.findElements(By.xpath(element));
		Iterator<WebElement> ite = elements.iterator();
		while (ite.hasNext()) {
			WebElement we = ite.next();
			if (we.isDisplayed()) {
				return we;
			}
		}
		return null;
	}
	public List<WebElement> getVisibleListOfELement(WebDriver driver, Selenium selenium, String element) throws Exception {
		List<WebElement> elements = driver.findElements(By.xpath(element));
		List<WebElement> elementsVisible=new ArrayList<WebElement>();
		Iterator<WebElement> ite = elements.iterator();
		while (ite.hasNext()) {
			WebElement we = ite.next();
			if (we.isDisplayed()) {
				elementsVisible.add(we);
			}
		}
		return elementsVisible;
	}

	public WebElement getVisibleELementRadio(WebDriver driver, Selenium selenium, String element) throws Exception {
		List<WebElement> elements = driver.findElements(By.xpath(element));
		Iterator<WebElement> ite = elements.iterator();
		while (ite.hasNext()) {
			WebElement we = ite.next();
			if (we.isDisplayed()) {
				if (!we.isSelected()) {
					return we;
				}
			}
		}
		return null;
	}

	public void searchSheet(WebDriver driver, Selenium selenium, String sheetName) throws Exception {
		logger.info("Inside search");
		selenium.waitForPageToLoad("5000");
		waitForVisibility(driver, selenium, "//input[@placeholder='Search for actions or people']");
		WebElement myEle = getVisibleELement(driver, selenium, "//input[@placeholder='Search for actions or people']");
		myEle.sendKeys(sheetName);
		Thread.sleep(1000);
		waitForVisibility(driver, selenium, "//*[text()='" + sheetName + "']");
		myEle.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		myEle.sendKeys(Keys.RETURN);
		selenium.waitForPageToLoad("5000");
		// waitForPresence(driver, selenium, "//ul//li//b[text()='" + sheetName
		// + "']");
		// retryingFindClick(driver, "//ul//li//b[text()='" + sheetName + "']");
		// driver.findElement(By.xpath("//ul//li//b[text()='" + sheetName +
		// "']")).click();
		// waitForPresence(driver, selenium, "//li[contains(@id, 'item0')]");
		// driver.findElement(By.xpath("//li[contains(@id, 'item0')]")).click();
	}

	public void searchSheetExact(WebDriver driver, Selenium selenium, String sheetName) throws Exception {
		logger.info("Inside search");
		selenium.waitForPageToLoad("5000");
		waitForVisibility(driver, selenium, "//input[@placeholder='Search for actions or people']");
		WebElement myEle = getVisibleELement(driver, selenium, "//input[@placeholder='Search for actions or people']");
		myEle.sendKeys(sheetName);
		Thread.sleep(1000);
		/*
		 * waitForVisibility(driver, selenium, "//*[text()='" + sheetName +
		 * "']"); myEle.sendKeys(Keys.DOWN); Thread.sleep(1000);
		 * myEle.sendKeys(Keys.RETURN);
		 */
		waitForPresence(driver, selenium, "//ul//li//b[text()='" + sheetName + "']");
		retryingFindClick(driver, "//ul//li//b[text()='" + sheetName + "']");
		driver.findElement(By.xpath("//ul//li//b[text()='" + sheetName + "']")).click();
		waitForPresence(driver, selenium, "//li[contains(@id, 'item0')]");
		driver.findElement(By.xpath("//li[contains(@id, 'item0')]")).click();
		selenium.waitForPageToLoad("5000");
	}

	public void toolSearch(WebDriver driver, Selenium selenium, String sheetName) throws Exception {

		selenium.waitForPageToLoad("5000");
		waitForVisibility(driver, selenium, "//span[text()='Tool Search']//following::input[1]");
		WebElement myEle = getVisibleELement(driver, selenium, "//span[text()='Tool Search']//following::input[1]");
		myEle.sendKeys(sheetName);
		Thread.sleep(1000);
		waitForVisibility(driver, selenium, "//*[text()='" + sheetName + "']");
		myEle.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		myEle.sendKeys(Keys.RETURN);
		selenium.waitForPageToLoad("5000");
	}

	public void searchSheetSPCDP(WebDriver driver, Selenium selenium, String sheetName) throws Exception {
		selenium.waitForPageToLoad("5000");
		waitForVisibility(driver, selenium, "//input[@placeholder='Search for actions or people']");
		driver.findElement(By.xpath("//input[@placeholder='Search for actions or people']")).sendKeys(sheetName);
		Thread.sleep(1000);
		// waitForPresence(driver, selenium, "//ul//li//b[text()='" + sheetName
		// + "']");
		// driver.findElement(By.xpath("//ul//li//b[text()='" + sheetName +
		// "']")).click();
		waitForVisibility(driver, selenium, "//*[text()='" + sheetName + "']");
		driver.findElement(By.xpath("//input[@placeholder='Search for actions or people']")).sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search for actions or people']")).sendKeys(Keys.RETURN);
		selenium.waitForPageToLoad("5000");
	}

	public void back2AdminCenter(WebDriver driver, Selenium selenium) throws Exception {
		logger.info("Inside back2admin");
		selenium.waitForPageToLoad("5000");
		scrollUp(driver);
		waitForVisibility(driver, selenium, "//*[text()='Admin Center']//ancestor::button[1]");
		try {
			WebElement myEle = getVisibleELement(driver, selenium, "//*[text()='Admin Center']//ancestor::button[1]");
			myEle.click();
		}catch(StaleElementReferenceException se) {
			WebElement myEle = getVisibleELement(driver, selenium, "//*[text()='Admin Center']//ancestor::button[1]");
			myEle.click();
		}
		waitForVisibility(driver, selenium, "//ul[@role='listbox']//following::a[text()='Admin Center']");
		driver.findElement(By.xpath("//ul[@role='listbox']//following::a[text()='Admin Center']")).click();
		Alert alert = isAlertPresent(driver);
		if (alert != null) {
			logger.info("Alert present");
			alert.accept();
		}
		waitForVisibility(driver, selenium, "//a[text()='Switch back to NextGen Admin Center']");
	}
	
	public void back2HomePage(WebDriver driver, Selenium selenium) throws Exception {
		logger.info("Inside back2HomePage");
		selenium.waitForPageToLoad("5000");
		scrollUp(driver);
		
		waitForVisibility(driver, selenium, "//*[text()='Admin Center']//ancestor::button[1]");
		if(isElementPresent(By.xpath("//*[text()='Admin Center']//ancestor::button[1]"), driver))
		{
		WebElement myEle = getVisibleELement(driver, selenium, "//*[text()='Admin Center']//ancestor::button[1]");
		myEle.click();
		waitForVisibility(driver, selenium, "//ul[@role='listbox']//child::a[text()='Home']");
		driver.findElement(By.xpath("//ul[@role='listbox']//child::a[text()='Home']")).click();
		Alert alert = isAlertPresent(driver);
		if (alert != null) {
			logger.info("Alert present");
			alert.accept();
		}
		}
		//waitForVisibility(driver, selenium, "//a[text()='Switch back to NextGen Admin Center']");
	}

	public void back2AdminCenterCPP(WebDriver driver, Selenium selenium) throws Exception {
		logger.info("Inside back2admin");
		selenium.waitForPageToLoad("5000");
		scrollUp(driver);
		if (isElementPresentWithTime(By.xpath("//span[text()='Admin Center']//ancestor::a[1]"), driver, 5)) {
			WebElement myEle = getVisibleELement(driver, selenium, "//span[text()='Admin Center']//ancestor::a[1]");
			myEle.click();
		} else {
			waitForVisibility(driver, selenium, "//span[text()='Admin Center']//ancestor::button[1]");
			WebElement myEle = getVisibleELement(driver, selenium,
					"//span[text()='Admin Center']//ancestor::button[1]");
			myEle.click();
		}
		waitForVisibility(driver, selenium, "//ul[@role='listbox']//following::a[text()='Admin Center']");
		driver.findElement(By.xpath("//ul[@role='listbox']//following::a[text()='Admin Center']")).click();
		Alert alert = isAlertPresent(driver);
		if (alert != null) {
			logger.info("Alert present");
			alert.accept();
		}
		waitForVisibility(driver, selenium, "//a[text()='Switch back to NextGen Admin Center']");
	}

	public void back2homePageinProvision(WebDriver driver, Selenium selenium, String cmpID) {
		selenium.waitForPageToLoad("5000");
		driver.findElement(By.xpath("//img[@name='doc']//parent::a[1]")).click();
		if (isAlert_Present(driver)) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		driver.findElement(By.xpath("//*[text()='" + cmpID + "']//preceding::a[1]")).click();
		if (isAlert_Present(driver)) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		selenium.waitForPageToLoad("2000");
	}

	public String getDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		String myDate = dtf.format(localDate).replaceAll("/", "-");
		return (myDate);
	}

	public String getESTDate() {
		Date date = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
		format1.setTimeZone(TimeZone.getTimeZone("US/Eastern"));
		String myDate = format1.format(date);
		return myDate;
	}

	public String getAutoITFile() {
		FileHandlingUtilities fn = new FileHandlingUtilities();
		Properties p = fn.fnReadPropertyFile();
		String autoITPath = System.getProperty("user.home").replaceAll("\\\\", "/") + p.getProperty("AUTOIT");
		return autoITPath;
	}

	public String getPermissionRolesFileLoc() {
		FileHandlingUtilities fn = new FileHandlingUtilities();
		Properties p = fn.fnReadPropertyFile();
		String permissionRolesFilePath = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("ECPermissionRolesFile");
		return permissionRolesFilePath;
	}

	public String getSPCDPPermissionRolesFileLoc() {
		FileHandlingUtilities fn = new FileHandlingUtilities();
		Properties p = fn.fnReadPropertyFile();
		String permissionRolesFilePath = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("SPCDPInsallationPermissionRoleFile");
		return permissionRolesFilePath;
	}

	public String getPermissionGroupFileLoc() {
		FileHandlingUtilities fn = new FileHandlingUtilities();
		Properties p = fn.fnReadPropertyFile();
		String permissionRolesFilePath = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("SPCDPPermissionSuperAdminGroupFile");
		return permissionRolesFilePath;
	}

	public String getPMSuperAdminPermissionRolesFileLoc() {
		FileHandlingUtilities fn = new FileHandlingUtilities();
		Properties p = fn.fnReadPropertyFile();
		String permissionRolesFilePath = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("PMAdminPermissionRolesFile");
		return permissionRolesFilePath;
	}

	/*
	 * public String getCPMSuperAdminPermissionRolesFileLoc() {
	 * FileHandlingUtilities fn = new FileHandlingUtilities(); Properties p =
	 * fn.fnReadPropertyFile(); String permissionRolesFilePath =
	 * System.getProperty("user.home").replaceAll("\\\\", "/") +
	 * p.getProperty("CPMSuperAdminPermissionRolesFile"); return
	 * permissionRolesFilePath; }
	 */

	public String getRCMSuperAdminPermissionRolesFileLoc() {
		FileHandlingUtilities fn = new FileHandlingUtilities();
		Properties p = fn.fnReadPropertyFile();
		String permissionRolesFilePath = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("RCMSuperAdminPermissionRolesFile");
		return permissionRolesFilePath;
	}

	public String getCompSuperAdminPermissionRolesFileLoc() {
		FileHandlingUtilities fn = new FileHandlingUtilities();
		Properties p = fn.fnReadPropertyFile();
		String permissionRolesFilePath = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("COMPSuperAdminPermissionRolesFile");
		return permissionRolesFilePath;
	}

	public Map<String, String> getSPCDPPermissionGroupsFilesLoc() {
		Map<String, String> groupsFilesLocMap = new HashMap<String, String>();
		FileHandlingUtilities fn = new FileHandlingUtilities();
		Properties p = fn.fnReadPropertyFile();

		String superAdmin = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("SPCDPPermissionSuperAdminGroupFile");
		groupsFilesLocMap.put("SuperAdmin", superAdmin);

		/*
		 * String boardMembers = System.getProperty("user.home").replaceAll(
		 * "\\\\", "/") + p.getProperty("SPCDPPermissionBoardMembersGroupFile");
		 * groupsFilesLocMap.put("BoardMembers", boardMembers);
		 */

		String employees = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("SPCDPPermissionEmployeesGroupFile");
		groupsFilesLocMap.put("Employees", employees);

		String successionSpecialist = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("SPCDPPermissionTalentManagementSpecialistGroupFile");
		groupsFilesLocMap.put("SuccessionSpecialist", successionSpecialist);

		return groupsFilesLocMap;
	}

	public Map<String, String> getECPermissionRolesFilesLoc() {
		Map<String, String> groupsFilesLocMap = new HashMap<String, String>();
		FileHandlingUtilities fn = new FileHandlingUtilities();
		Properties p = fn.fnReadPropertyFile();

		String employeeSelf = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("ECEmployeeSelfPermissionRolesFile");
		groupsFilesLocMap.put("EmployeeSelf", employeeSelf);

		String hrAdmin = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("ECHRAdminPermissionRolesFile");
		groupsFilesLocMap.put("HRAdmin", hrAdmin);

		String hrManager = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("ECHRManagerPermissionRolesFile");
		groupsFilesLocMap.put("HRManager", hrManager);

		String manager = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("ECManagerPermissionRolesFile");
		groupsFilesLocMap.put("Manager", manager);

		String nonEmployeeSelf = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("ECNonEmployeeSelfPermissionRolesFile");
		groupsFilesLocMap.put("NONEmployeeSelf", nonEmployeeSelf);

		String employeePublic = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("ECEmployeePublicPermissionRolesFile");
		groupsFilesLocMap.put("EmployeePublic", employeePublic);

		return groupsFilesLocMap;
	}

	public Map<String, String> getSPCDPPermissionRolesFilesLoc() {
		Map<String, String> groupsFilesLocMap = new HashMap<String, String>();
		FileHandlingUtilities fn = new FileHandlingUtilities();
		Properties p = fn.fnReadPropertyFile();

		String superAdminRole = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("SPCDPPermissionRolesFile");
		groupsFilesLocMap.put("SuperAdminRole", superAdminRole);

		String hrBussinessPatner = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("SPCDPHRBusinessPartnerPermissionRolesFile");
		groupsFilesLocMap.put("HRBussinessPatner", hrBussinessPatner);

		String employee = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("SPCDPEmployeePermissionRolesFile");
		groupsFilesLocMap.put("Employee", employee);

		String manager = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("SPCDPManagerPermissionRolesFile");
		groupsFilesLocMap.put("Manager", manager);

		String talentManagementSpecialists = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("SPCDPTalentManagementSpecialistsPermissionRolesFile");
		groupsFilesLocMap.put("TalentManagementSpecialists", talentManagementSpecialists);

		return groupsFilesLocMap;
	}

	public Map<String, String> getPMGMPermissionRolesFilesLoc() {
		Map<String, String> groupsFilesLocMap = new HashMap<String, String>();
		FileHandlingUtilities fn = new FileHandlingUtilities();
		Properties p = fn.fnReadPropertyFile();

		String pmmanager = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("PMManagerPermissionRolesFile");
		groupsFilesLocMap.put("PMManager", pmmanager);

		String pmemployee = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("PMEmployeePermissionRolesFile");
		groupsFilesLocMap.put("PMEmployee", pmemployee);

		String pmpublicview = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("PMPublicViewPermissionRolesFile");
		groupsFilesLocMap.put("PMPublicView", pmpublicview);

		return groupsFilesLocMap;
	}

	public Map<String, String> getRCMPermissionGroupsFilesLoc() {
		Map<String, String> groupsFilesLocMap = new HashMap<String, String>();
		FileHandlingUtilities fn = new FileHandlingUtilities();
		Properties p = fn.fnReadPropertyFile();

		String recruiterAdmin = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("RCMSuperAdminPermissionRolesFile");
		groupsFilesLocMap.put("RecruiterAdmin", recruiterAdmin);

		String hiringManager = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("RCMHiringManagerPermissionRolesFile");
		groupsFilesLocMap.put("HiringManager", hiringManager);

		String recruiter = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("RCMRecruiterPermissionRolesFile");
		groupsFilesLocMap.put("Recruiter", recruiter);

		String employee = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("RCMEmployeePermissionRolesFile");
		groupsFilesLocMap.put("Employee", employee);

		String compensationApprover = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("RCMCompensationApproverRoleFile");
		groupsFilesLocMap.put("CompensationApprover", compensationApprover);

		String hrBusinessPartner = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("RCMHRBusinessPartnerRoleFile");
		groupsFilesLocMap.put("HRBusinessPartner", hrBusinessPartner);

		return groupsFilesLocMap;
	}

	public Map<String, String> getCOMPPermissionRolesFilesLoc() {
		Map<String, String> rolesFilesLocMap = new HashMap<String, String>();
		FileHandlingUtilities fn = new FileHandlingUtilities();
		Properties p = fn.fnReadPropertyFile();

		String managerRole = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("COMPManagerPermissionRolesFile");
		rolesFilesLocMap.put("Manager", managerRole);

		String employeeRole = System.getProperty("user.home").replaceAll("\\\\", "/")
				+ p.getProperty("COMPEmployeePermissionRolesFile");
		rolesFilesLocMap.put("Employee", employeeRole);

		return rolesFilesLocMap;
	}

	public String getFileDownloadPath() {
		FileHandlingUtilities fn = new FileHandlingUtilities();
		Properties p = fn.fnReadPropertyFile();
		String autoITPath = System.getProperty("user.home").replaceAll("\\\\", "/") + p.getProperty("FileLoc");
		return autoITPath;
	}

	public File getFile() {
		FileHandlingUtilities fn = new FileHandlingUtilities();
		Properties p = fn.fnReadPropertyFile();
		String prefix = "jobResponse";
		File dir = new File(System.getProperty("user.home").replaceAll("\\\\", "/") + p.getProperty("FileLoc"));
		File[] candidates = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File dir) {
				return dir.getName().startsWith(prefix);
			}
		});
		return candidates[0];
	}

	public String fnConversionCSVtoXLSX1(File inputFile) {
		CSVReader reader = null;
		try {
			String[] nextLine;
			reader = new CSVReader(new FileReader(inputFile), ',');
			while ((nextLine = reader.readNext()) != null) {
				for (int i = 0; i < nextLine.length; i++) {
					if (nextLine[i].contains("Users imported/updated")) {
						return nextLine[i];
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("\nFile does not exist!");
			logger.error("Error StackTrace :", e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
					logger.info("Done");
				} catch (IOException e) {
					e.printStackTrace();
					logger.info("\nFile can not be closed correctly!");
					logger.error("Error StackTrace :", e);
				}
			}
		}
		return null;
	}

	public boolean isElementPresentWithTime(By by, WebDriver driver, int seconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementPresent(By by, WebDriver driver) {
		try {
			/*WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));*/
			Thread.sleep(1000);
			driver.findElement(by);
			return true;
		} catch(NoSuchElementException e){
			return false;
		}
		catch (Exception e) {
			return false;
		}
	}

	public void back2HomePageInLMS(WebDriver driver, Selenium selenium) throws Exception {
		WebElement Webelement=driver.findElement(By.xpath("//bdi[text()='Admin Center']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", Webelement); 
		Webelement.click();
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		Thread.sleep(1000);
	}
	public void back2admincenterPageInLMS(WebDriver driver, Selenium selenium) throws Exception {
		WebElement Webelement=driver.findElement(By.xpath("//*[text()='Home']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", Webelement); 
		Webelement.click();
		driver.findElement(By.xpath("//*[text()='Admin Center']")).click();
		Thread.sleep(1000);
	}
	
	public void logOutProvision(WebDriver driver) {
		driver.findElement(By.xpath("//*[text()='logout']")).click();
	}

	public void passwordReset(WebDriver driver, String superAdmin, String superAdminPass) {
		FileHandlingUtilities fileUtility = new FileHandlingUtilities();
		if (isElementPresent(By.xpath("//th[text()='New Password:']//preceding::input[1]"), driver)) {
			Properties configProp = fileUtility.fnReadPropertyFile(BOTSF_AutoConfig_Constants.EC_PROPERTIES_LOC);

			String oldPassword = configProp.getProperty(BOTSF_AutoConfig_Constants.SUPERADMINTEMPPASS);
			driver.findElement(By.xpath("//th[text()='New Password:']//preceding::input[1]")).sendKeys(oldPassword);
			driver.findElement(By.xpath("//th[text()='New Password:']//following::input[1]")).sendKeys(superAdminPass);
			;
			driver.findElement(By.xpath("//th[text()='Repeat New Password:']//following::input[1]"))
					.sendKeys(superAdminPass);
			driver.findElement(By.xpath("//*[text()='Save']")).click();
		}
	}

	public boolean retryingFindClick(WebDriver driver, String element) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				logger.info("Attempts :" + attempts);
				driver.findElement(By.xpath(element)).click();
				result = true;
				break;
			} catch (Exception e) {
			}
			attempts++;
		}
		return result;
	}

	public void closeTabs(WebDriver driver) {
		if ((driver.findElements(By.xpath("//*[text()='Search and Select Items']//following::*[text()='Cancel']")))
				.size() != 0) {
			driver.findElement(By.xpath("//*[text()='Search and Select Items']//following::*[text()='Cancel']"))
					.click();
		} else if ((driver.findElements(By.xpath("//*[text()='Add another']//following::*[text()='Cancel']")))
				.size() != 0) {
			driver.findElement(By.xpath("//*[text()='Add another']//following::*[text()='Cancel']")).click();
		}
		if ((driver.findElements(By.xpath("//*[text()='Cancel']"))).size() != 0) {
			driver.findElement(By.xpath("//*[text()='Cancel']")).click();
		}
	}

	public Alert isAlertPresent(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			return alert;
		} catch (Exception Ex) {
			return null;
		}
	}

	public boolean isAlert_Present(WebDriver driver) {
		boolean foundAlert = false;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			foundAlert = true;
		} catch (TimeoutException eTO) {
			foundAlert = false;
		}
		return foundAlert;
	}

	public boolean waitForOptionsTOAppear(WebDriver driver, String clickableEle, String ele) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(10, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		boolean val = false;
		WebElement test = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				driver.navigate().refresh();
				driver.findElement(By.xpath(clickableEle)).click();
				if (driver.findElement(By.xpath(ele)).isEnabled()) {
					return driver.findElement(By.xpath(ele));
				}
				return null;
			}
		});
		if (test != null) {
			val = true;
		}
		driver.navigate().refresh();
		return val;
	}

	public boolean checkForOptions(WebDriver driver, String clickableEle, String ele) {
		boolean val = false;
		driver.findElement(By.xpath(clickableEle)).click();
		if (isElementPresent(By.xpath(ele), driver)) {
			val = true;
			return val;
		} else {
			return val;
		}
	}

	public boolean checkForDialog(WebDriver driver, Selenium selenium, String dialogMsg) {
		selenium.waitForPageToLoad("10000");
		boolean code = driver.findElement(By.xpath("//span[text()='" + dialogMsg + "']")).isDisplayed();
		if (code) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean checkIfRoleorGrpExists(Selenium selenium, WebDriver driver, String name) throws Exception {
		Boolean result = false;
		waitForElementPresent(driver,
				By.xpath("//input[contains(@title, 'Enter your keywords to search all selectable items')]"), 60);
		WebElement searchEle = driver.findElement(
				By.xpath("//input[contains(@title, 'Enter your keywords to search all selectable items')]"));
		searchEle.clear();
		searchEle.sendKeys(Keys.chord(Keys.CONTROL, "a"), name, Keys.RETURN);
		Thread.sleep(2000);
		if (isElementPresent(By.xpath("//a[text()='" + name + "']"), driver)) {
			result = true;

		}
		return result;
	}
	public boolean isAttribtuePresent(WebElement element, String attribute) {
	    Boolean result = false;
	    try {
	        String value = element.getAttribute(attribute);
	        if (value != null){
	            result = true;
	        }
	    } catch (Exception e) {}

	    return result;
	}

	public void scrollUp(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");

	}

	public void scrollToElement(WebDriver driver, WebElement myElement) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", myElement);
	}

	public void scrollToBottom(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, document.body.scrollHeight);");
	}

	public void selectCheckBox(WebDriver driver, String xpath) {
		if (!driver.findElement(By.xpath(xpath)).isSelected()) {
			driver.findElement(By.xpath(xpath)).click();
		}
	}
	public static String GenerateRandomString(int length)
    {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(length);
  
        for (int i = 0; i < length; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sb.toString();
    }
	public void GenerateRandomDate()
    {
        String dateType = "past";
          LocalDate StartRange = LocalDate.now();
          Random rand = new Random();
        
        LocalDate todaysDate = StartRange;
        
		int randomNum;
		if (dateType.equals("past")){
        	
           randomNum = rand.nextInt((1 - 15) + 1) + 1;
        long time = System.currentTimeMillis();
        String uniqueValue = randomNum+""+time;
        }
        else if (dateType.equals("future" ))
        {
            todaysDate = todaysDate.plusDays(rand.nextInt((1 - 15) + 1) + 1);
        }
        else if (dateType.equals("current") || dateType.equals(""))
        {
             todaysDate = LocalDate.now();
        }
        
    }


	public static LocalDate generateRandomDate(LocalDate startRange, String dateType) {
        // dateType = "past";
        
        Random rand = new Random();
      
       LocalDate todaysDate = startRange;
      int randomNum = rand.nextInt((15 - 1) + 1) + 1;
		
		if (dateType.equals("past")){
      	
         
			todaysDate = todaysDate.minusDays(randomNum);
      
      }
      else if (dateType.equals("future" ))
      {
          todaysDate = todaysDate.plusDays(randomNum);
      }
      else if (dateType.equals("current") || dateType.equals(""))
      {
           todaysDate = LocalDate.now();
      }
		return todaysDate;
      
  }
}
