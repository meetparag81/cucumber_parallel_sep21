package DataManupulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.After;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.thoughtworks.selenium.Selenium;

import DataManupulation.Constnts.BOTSF_AutoConfig_Constants;

@SuppressWarnings("deprecation")
public class BrowserSetUp {
	static Logger logger = Logger.getLogger(BrowserSetUp.class.getName());
	private static final String TASKLIST = "tasklist";
	private static final String KILL = "taskkill /F /IM ";

	String sfnewPass = new String();

	public WebDriver setUp() throws Exception {
		WebDriver driver = null;
		String fireFoxPath = System.getenv("FIREFOX_PATH");
		if (fireFoxPath != null && !fireFoxPath.equals("")) {
			System.setProperty("webdriver.firefox.bin", fireFoxPath);
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.startup.page", 0); // Empty start
																// page
			profile.setPreference("browser.startup.homepage_override.mstone", "ignore");
			driver = new FirefoxDriver(profile);
			driver.manage().window().maximize();
		}
		return driver;
	}

	public WebDriver setUpChrome() {
		WebDriver driver = null;
		Utilities utilities = new Utilities();
		try {
			String downloadFilePath = utilities.getFileDownloadPath();
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			// options.addArguments("--incognito");
			options.addArguments("disable-infobars");
			options.addArguments("--disable-backgrounding-occluded-windows");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("download.default_directory", downloadFilePath);
			prefs.put("profile.default_content_setting_values.plugins", 1);
			prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
			prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
			// Enable Flash for this site
			prefs.put("PluginsAllowedForUrls",
					"https://partner0314.scdemo.successfactors.com/learning/admin/theming/updateThemingInfo.do?OWASP_CSRFTOKEN=DG1Q-OCB1-B4XY-K6NK-75U7-QBVR-RRK7-3BDC");
			options.setExperimentalOption("prefs", prefs);

			// options.setExperimentalOption("excludeSwitches",
			// Collections.singletonList("enable-automation"));
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			FileHandlingUtilities fn = new FileHandlingUtilities();
			Properties p = fn.fnReadPropertyFile();
			String chromePath = System.getProperty("user.home").replaceAll("\\\\", "/") + p.getProperty("ChromeDriver");
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver(capabilities);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error StackTrace :", e);
			return null;
		}
		return driver;
	}

	@After
	public void tearDown(Selenium selenium, WebDriver driver) throws Exception {
		driver.quit();
		selenium.stop();
		if (isProcessRunning("chromedriver.exe")) {
			killProcess("chromedriver.exe");
		}
	}

	public void sfInstanceLogin(Selenium selenium, WebDriver driver, String sfUrl, String sfUserID, String sfPassword,
			String cmpID) throws Exception {
		logger.info("Inside sf login");
		Utilities utilities = new Utilities();
		FileHandlingUtilities fileUtility = new FileHandlingUtilities();
		Properties configProp = fileUtility.fnReadPropertyFile(BOTSF_AutoConfig_Constants.EC_PROPERTIES_LOC);
		
		selenium.open(sfUrl);
		selenium.waitForPageToLoad("8000");
		
		// utilities.waitForElementPresent(driver,By.xpath("//input[@placeholder='Enter
		// Company ID']"), 120);
		
		
		if (isElementPresent(By.xpath("//input[@placeholder='Enter Company ID']"), driver)) {
			utilities.waitForElementPresent(driver, By.xpath("//input[@placeholder='Enter Company ID']"), 120);
			driver.findElement(By.xpath("//input[@placeholder='Enter Company ID']")).sendKeys(cmpID);
			driver.findElement(By.xpath("//button[@title='Submit']")).click();
		}
		Thread.sleep(20000);
		// selenium.waitForPageToLoad("5000");
		
		if (isElementPresent(By.xpath("//button[@id='logOnFormSubmit' and text()='Continue']"), driver)) {
			utilities.waitForElementPresent(driver, By.xpath("//input[@placeholder='E-Mail']"), 120);
			driver.findElement(By.xpath("//input[@placeholder='E-Mail']")).sendKeys(sfUserID);
			utilities.waitForElementPresent(driver, By.xpath("//button[@id='logOnFormSubmit' and text()='Continue']"), 120);
			driver.findElement(By.xpath("//button[@id='logOnFormSubmit' and text()='Continue']")).click();
		}
		Thread.sleep(20000);
		
		if(utilities.isElementPresent(By.xpath("//input[@placeholder='E-Mail']"), driver)) {
			utilities.waitForVisibility(driver, selenium, "//input[@placeholder='E-Mail']");
			//driver.findElement(By.xpath("//input[@placeholder='E-Mail']")).click();
			//driver.findElement(By.xpath("//input[@placeholder='E-Mail']")).clear();
			driver.findElement(By.xpath("//input[@placeholder='E-Mail']")).sendKeys(sfUserID);
		}
		
		else if(utilities.isElementPresent(By.xpath("//input[@name='username']"), driver))
		{
		utilities.waitForVisibility(driver, selenium, "//input[@name='username']");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(sfUserID);
		}
		
		if(utilities.isElementPresent(By.xpath("//input[@name='password']"), driver)) {
			utilities.waitForVisibility(driver, selenium, "//input[@name='password']");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(sfPassword);
		}
		//for Yazaki Project
		else if(utilities.isElementPresent(By.xpath("//input[@placeholder='Password']"), driver)) {
			utilities.waitForVisibility(driver, selenium, "//input[@placeholder='Password']");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(sfPassword);
		}
		else {
			utilities.waitForVisibility(driver, selenium, "//input[@name='passwordHints']");
			WebElement element=driver.findElement(By.xpath("//input[@name='passwordHints']"));
			//driver.findElement(By.xpath("//input[@name='passwordHints']")).sendKeys(sfPassword);
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.click();
			actions.sendKeys(sfPassword);
			actions.build().perform();
		}
		
		Thread.sleep(10000);
		if(utilities.isElementPresent(By.xpath("//*[text()='Log in']"), driver)) {
			utilities.waitForVisibility(driver, selenium, "//*[text()='Log in']");
			driver.findElement(By.xpath("//*[text()='Log in']")).click();
		}
		else if(utilities.isElementPresent(By.xpath("//button[text()='Log On']"), driver)) {
			utilities.waitForVisibility(driver, selenium, "//button[text()='Log On']");
			driver.findElement(By.xpath("//button[text()='Log On']")).click();
		}
		else {
			utilities.waitForVisibility(driver, selenium, "//*[@name='login']");
			driver.findElement(By.xpath("//*[@name='login']")).click();
		}
		
		Thread.sleep(20000);
		
		if (utilities.isElementPresent(By.xpath("//*[@title='Add']"), driver))
		{
			WebElement ele=driver.findElement(By.xpath("//*[@title='Add']"));
			if(ele.isEnabled()){
				try {
					//waitForClickable(sapPopup);
					executeJavaScript(driver,"arguments[0].click();",driver.findElement(By.id("sap-ui-blocklayer-popup")));
				}
				catch(Exception noPopupBlocker) {
				}
				//driver.findElement(By.xpath("//body[@id='appCanvas']")).click();
			}
		}
		
		logger.info(sfnewPass);
		if(utilities.isElementPresent(By.xpath("//th[text()='New Password:']//preceding::input[1]"), driver)){
			if (sfnewPass != null && !(sfnewPass == "")) {
			logger.info("Inside pwd reset if");
			driver.findElement(By.xpath("//th[text()='New Password:']//preceding::input[1]")).sendKeys(sfPassword);
			driver.findElement(By.xpath("//th[text()='New Password:']//following::input[1]")).sendKeys(sfnewPass);
			driver.findElement(By.xpath("//th[text()='Repeat New Password:']//following::input[1]")).sendKeys(sfnewPass);
			driver.findElement(By.xpath("//*[text()='Save']")).click();
			}
		}

		if (!(isElementPresent(By.xpath("//h1[text()='Admin Center']"), driver))) {
			changeOptions(driver, selenium);
		}

		if (utilities.isElementPresent(By.xpath("//span[text()='Internal Server Error.']"), driver)) {
			logger.info("Alert is persent");
			WebElement myEle = utilities.getVisibleELement(driver, selenium, "//span[text()='Close']");
			myEle.click();
		}
		if (isElementPresent(By.xpath("//*[text()='Switch back to OneAdmin']"), driver)) {
			logger.info("Inside element present check in sf login");
			selenium.waitForPageToLoad("5000");
			utilities.waitForElementPresent(driver, By.xpath("//a[text()='Switch back to OneAdmin']"), 120);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, 250);");
			WebElement myEle = utilities.getVisibleELement(driver, selenium, "//a[text()='Switch back to OneAdmin']");
			myEle.click();
		}

		Alert alert = utilities.isAlertPresent(driver);
		if (alert != null) {
			logger.info("Inside alert check.");
			alert.accept();
		}

	}
	
	public void sfInstanceLoginLMS(Selenium selenium, WebDriver driver, String sfUrl, String sfUserID, String sfPassword,
			String cmpID) throws Exception {
		logger.info("Inside sf login");
		Utilities utilities = new Utilities();
		FileHandlingUtilities fileUtility = new FileHandlingUtilities();
		Properties configProp = fileUtility.fnReadPropertyFile(BOTSF_AutoConfig_Constants.EC_PROPERTIES_LOC);

		selenium.open(sfUrl);
		selenium.waitForPageToLoad("200000");
		// utilities.waitForElementPresent(driver,By.xpath("//input[@placeholder='Enter
		// Company ID']"), 120);
		
		if (utilities.isElementPresent(By.xpath("//input[@placeholder='Enter Company ID']"), driver)) {
			utilities.waitForElementPresent(driver, By.xpath("//input[@placeholder='Enter Company ID']"), 120);
			driver.findElement(By.xpath("//input[@placeholder='Enter Company ID']")).sendKeys(cmpID);
			driver.findElement(By.xpath("//button[@title='Submit']")).click();
		}
		Thread.sleep(30000);
		// selenium.waitForPageToLoad("5000");
		utilities.waitForVisibility(driver, selenium, "//input[@name='username']");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(sfUserID);
		if(utilities.isElementPresent(By.xpath("//input[@name='password']"), driver)) {
			utilities.waitForVisibility(driver, selenium, "//input[@name='password']");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(sfPassword);
		}else {
			utilities.waitForVisibility(driver, selenium, "//input[@name='passwordHints']");
			WebElement element=driver.findElement(By.xpath("//input[@name='passwordHints']"));
			//driver.findElement(By.xpath("//input[@name='passwordHints']")).sendKeys(sfPassword);
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.click();
			actions.sendKeys(sfPassword);
			actions.build().perform();
		}
		
		Thread.sleep(10000);
		if(utilities.isElementPresent(By.xpath("//*[text()='Log in']"), driver)) {
			utilities.waitForVisibility(driver, selenium, "//*[text()='Log in']");
			driver.findElement(By.xpath("//*[text()='Log in']")).click();
		}else {
			utilities.waitForVisibility(driver, selenium, "//*[@name='login']");
			driver.findElement(By.xpath("//*[@name='login']")).click();
		}
	}
	public void provisionLogin(Selenium selenium, WebDriver driver, String provUrl, String provUserID,
			String provPassword, String cmpID) throws Exception {
		Utilities utilities = new Utilities();
		driver.navigate().refresh();
		selenium.open(provUrl);
		selenium.waitForPageToLoad("200000");
		utilities.waitForVisibility(driver, selenium, "//input[@name='j_username']");
		driver.findElement(By.xpath("//input[@name='j_username']")).sendKeys(provUserID);
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys(provPassword);
		driver.findElement(By.xpath("//button[text()='Log On']")).click();
		selenium.waitForPageToLoad("50000");
		driver.findElement(By.xpath("//*[text()='" + cmpID + "']//preceding::a[1]")).click();
	}

	public static void killProcess(String serviceName) throws Exception {
		Runtime.getRuntime().exec(KILL + serviceName);
	}

	public static boolean isProcessRunning(String serviceName) throws Exception {
		try {
			Process p = Runtime.getRuntime().exec(TASKLIST);
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {

				// System.out.println(line);
				if (line.contains(serviceName)) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public boolean isElementPresent(By by, WebDriver driver) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}catch (Exception e) {
			return false;
		}
	}

	public void passwordReset(WebDriver driver, String superAdmin, String superAdminPass) {
		FileHandlingUtilities fileUtility = new FileHandlingUtilities();
		if (isElementPresent(By.xpath("//th[text()='New Password:']//preceding::input[1]"), driver)) {
			logger.info("Inside pwd reset if");
			Properties configProp = fileUtility.fnReadPropertyFile(BOTSF_AutoConfig_Constants.EC_PROPERTIES_LOC);
			String oldPassword = configProp.getProperty(BOTSF_AutoConfig_Constants.SUPERADMINTEMPPASS).trim();
			driver.findElement(By.xpath("//th[text()='New Password:']//preceding::input[1]")).sendKeys(oldPassword);
			driver.findElement(By.xpath("//th[text()='New Password:']//following::input[1]")).sendKeys(superAdminPass);
			driver.findElement(By.xpath("//th[text()='Repeat New Password:']//following::input[1]"))
					.sendKeys(superAdminPass);
			driver.findElement(By.xpath("//*[text()='Save']")).click();
		}
	}

	public void logOutProvision(WebDriver driver) {
		driver.findElement(By.xpath("//*[text()='logout']")).click();
	}

	public void logOutSFInstance(WebDriver driver, String userName) throws Exception {
		if (isElementPresent(
				By.xpath(
						"//*[@class='sapMBarChild surjNotificationWrapper']//following::button[contains(@title,'Account Navigation for')]"),
				driver)) {
			driver.findElement(By
					.xpath("//*[@class='sapMBarChild surjNotificationWrapper']//following::button[contains(@title,'Account Navigation for')]"))
					.click();
		}

		else if (isElementPresent(By.xpath("//*[@class='sapMBarChild surjNotificationWrapper']//following::span[1]"),
				driver)) {
			driver.findElement(By.xpath("//*[@class='sapMBarChild surjNotificationWrapper']//following::span[1]"))
					.click();
		}
		while (!(isElementPresent(By.xpath("//a[text()='Log out']"), driver))) {
			driver.switchTo().activeElement().sendKeys(Keys.DOWN);
		}
		// Actions actions = new Actions(driver);
		// actions.moveToElement(driver.findElement(By.xpath("//a[text()='Log
		// out']"))).doubleClick().perform();

		driver.findElement(By.xpath("//a[text()='Log out']")).click();
	}

	public void back2AdminCenterHome(WebDriver driver, Selenium selenium) throws Exception {
		Utilities utilities = new Utilities();

		if (isElementPresent(
				By.xpath(
						"//*[@class='sapMBarChild surjNotificationWrapper']//following::button[contains(@title,'Account Navigation for')]"),
				driver)) {
			
			WebElement Webelement=driver.findElement(By
					.xpath("//*[@class='sapMBarChild surjNotificationWrapper']//following::button[contains(@title,'Account Navigation for')]"))
					;
			JavascriptExecutor jse = (JavascriptExecutor)driver;

			jse.executeScript("arguments[0].scrollIntoView()", Webelement); 
			
			
		}

		else if (isElementPresent(By.xpath("//*[@class='sapMBarChild surjNotificationWrapper']//following::span[1]"),
				driver)) {
			driver.findElement(By.xpath("//*[@class='sapMBarChild surjNotificationWrapper']//following::span[1]"))
					.click();
		}

		Thread.sleep(1000);
		//utilities.waitForElementPresent(driver, By.xpath("//a[text()='Admin Center']"), 120);
		if(isElementPresent(By.xpath("//a[text()='Admin Center']"),driver))
		{
		driver.findElement(By.xpath("//a[text()='Admin Center']")).click();
		}
		else if(isElementPresent(By.xpath("//a[text()='Admin Centre']"),driver))
		{
		driver.findElement(By.xpath("//a[text()='Admin Centre']")).click();
		}
		
	}

	public void changeOptions(WebDriver driver, Selenium selenium) throws Exception {
		Utilities utilities = new Utilities();
		/*
		 * utilities.waitForElementPresent(driver, By.xpath(
		 * "//*[@class='sapMBarChild surjNotificationWrapper']//following::button[contains(@title,'Account Navigation for')]"
		 * ), 120); driver.findElement(By .xpath(
		 * "//*[@class='sapMBarChild surjNotificationWrapper']//following::button[contains(@title,'Account Navigation for')]"
		 * )) .click();
		 */
		Thread.sleep(5000);
		if (isElementPresent(
				By.xpath(
						"//*[contains(@class,'surjNotificationWrapper')]//following::*[contains(@title,'Account Navigation for')]"),
				driver)) {
			
			Thread.sleep(3000);
			/*if(utilities.isElementPresent(By.xpath("//button[@title='Add']"), driver)){
				driver.findElement(By.xpath("//button[@title='Add']")).click();
			}*/
			driver.findElement(By
					.xpath("//*[contains(@class,'surjNotificationWrapper')]//following::*[contains(@title,'Account Navigation for')]"))
					.click();
		}

		else if (isElementPresent(By.xpath("//*[@class='sapMBarChild surjNotificationWrapper']//following::span[1]"),
				driver)) {
			
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//*[@class='sapMBarChild surjNotificationWrapper']//following::span[1]"))).doubleClick().perform();
		}

		if(isElementPresent(
				By.xpath(
						"//a[text()='Options']"),
				driver)){
			utilities.waitForElementPresent(driver, By.xpath("//a[text()='Options']"), 120);
			driver.findElement(By.xpath("//a[text()='Options']")).click();
			driver.findElement(By.xpath("//*[text()='Start Page']")).click();
			driver.findElement(By.xpath("//*[text()='Save']//preceding::select | Home")).sendKeys("Admin Center");
			driver.findElement(By.xpath("//*[text()='Save']")).click();
		}else if(isElementPresent(By.xpath("//a[text()='Admin Center']"),driver))
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[text()='Admin Center']")).click();
		}
		else if(isElementPresent(By.xpath("//a[text()='Admin Centre']"),driver))
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[text()='Admin Centre']")).click();	
		}
		

		back2AdminCenterHome(driver, selenium);
	}

	public void passwordResetRelogin(Selenium selenium, WebDriver driver, String sfUrl, String sfUserID,
			String sfPassword, String cmpID) throws Exception {
		logOutProvision(driver);
		FileHandlingUtilities fileUtility = new FileHandlingUtilities();
		Properties configProp = fileUtility.fnReadPropertyFile(BOTSF_AutoConfig_Constants.EC_PROPERTIES_LOC);
		String oldPassword = configProp.getProperty(BOTSF_AutoConfig_Constants.SUPERADMINTEMPPASS);
		sfnewPass = sfPassword;
		// setPropertyDynamically(sfPassword);
		sfInstanceLogin(selenium, driver, sfUrl, sfUserID, oldPassword, cmpID);
		// passwordReset(driver, sfUserID, sfPassword);
		// changeOptions(driver, selenium);
		logOutSFInstance(driver, sfUserID);
	}

	public void setPropertyDynamically(String sfNewPassword) {
		BufferedWriter outputStream = null;

		try {
			FileHandlingUtilities fhUtil = new FileHandlingUtilities();
			Properties props = fhUtil.fnReadPropertyFile();
			// String propertyFilePath=BOTSF_Properties.CONFIG_PROPERTIES_LOC;
			String propertyFilePath = "config.properties";
			File f = new File(propertyFilePath);
			if (f.exists()) {

				props.load(new FileReader(f));
				// Change your values here
				props.setProperty("SFInstancePassword", sfNewPassword);
				logger.info("Inside If");
				logger.info(props.getProperty("SFInstancePassword"));
			} else {
				// Set default values?
				logger.info("Inside else");
				props.setProperty("SFInstancePassword", sfNewPassword);
				f.createNewFile();
			}

			outputStream = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
			props.store(outputStream, "");
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (outputStream != null) {

				try {

					outputStream.close();
				} catch (IOException ex) {

					System.out
							.println("IOException: Could not close myApp.properties output stream; " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		}

	}
	
	public void executeJavaScript(WebDriver driver,String scriptToExecute,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(scriptToExecute,element);
	}
}
