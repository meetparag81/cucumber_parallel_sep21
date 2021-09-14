package DataManupulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.channels.Channel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.botsftool.filehandling.FileHandlingUtilities;
import com.botsftool.utilities.Utilities;

public class CorehelperClass {
	private static ThreadLocal<ThreadedItems> threadDriver;

	public static WebDriver getDriver(String ExecuteinBackground)
	{
		try {
			Utilities utilities = new Utilities();
			String browser = "chrome";
			String local = "true";
			initializeThreadLocal();
			if (threadDriver.get().getDriver() == null){
				if ("chrome".equals(browser)){
					String downloadFilePath = utilities.getFileDownloadPath();
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--start-maximized");
					options.addArguments("disable-infobars");
					if(ExecuteinBackground.equalsIgnoreCase("Yes")) {
						options.addArguments("--headless");
						options.addArguments("window-size=1200x600");
					}
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("credentials_enable_service", false);
					prefs.put("profile.password_manager_enabled", false);
					prefs.put("download.default_directory", downloadFilePath);
					prefs.put("profile.default_content_setting_values.plugins", 1);
					prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
					prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
					// Enable Flash for this site
					prefs.put("PluginsAllowedForUrls","");
					options.setExperimentalOption("prefs", prefs);
					capabilities.setCapability(ChromeOptions.CAPABILITY, options);

					FileHandlingUtilities fn = new FileHandlingUtilities();
					Properties p = fn.fnReadPropertyFile();
					String chromePath = System.getProperty("user.home").replaceAll("\\\\", "/") +p.getProperty("ChromeDriver");
					System.setProperty("webdriver.chrome.driver", chromePath);

					//System.setProperty("webdriver.chrome.driver", "C:\\LiquidAutomation\\driver\\chromedriver.exe");
					if (!"false".equals(local))	{
						threadDriver.get().setDriver(new ChromeDriver(capabilities));
						//						threadDriver.get().setDriver(new RemoteWebDriver(new URL("http://192.168.0.101:4444/wd/hub"), capabilities));
					}
				}
			}

		}
		catch(Exception e) {
			if (threadDriver.get().getDriver() == null){
				getDriver(ExecuteinBackground);
			}
			System.out.println("Exception Caught in GetDriver Method " +e.getLocalizedMessage());
			return threadDriver.get().getDriver();
		}
		return threadDriver.get().getDriver();
	}

	public static WebDriver initializeDriver(String ExecuteinBackground)
	{
		WebDriver driver = null;
		try {
			Utilities utilities = new Utilities();
			String browser = "chrome";
			String local = "true";
			if (driver == null){
				if ("chrome".equals(browser)){
					String downloadFilePath = utilities.getFileDownloadPath();
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--start-maximized");
					options.addArguments("disable-infobars");
					options.addArguments("--disable-backgrounding-occluded-windows");
					if(ExecuteinBackground.equalsIgnoreCase("Yes")) {
						options.addArguments("--headless");
						//options.addArguments("window-size=1200x600");
						options.addArguments("window-size=1980x1080");
						options.addArguments("--disable-gpu");
					}
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("credentials_enable_service", false);
					prefs.put("profile.password_manager_enabled", false);
					prefs.put("download.default_directory", downloadFilePath);
					prefs.put("profile.default_content_setting_values.plugins", 1);
					prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
					prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
					// Enable Flash for this site
					prefs.put("PluginsAllowedForUrls","");
					options.setExperimentalOption("prefs", prefs);
					capabilities.setCapability(ChromeOptions.CAPABILITY, options);

					FileHandlingUtilities fn = new FileHandlingUtilities();
					Properties p = fn.fnReadPropertyFile();
					String chromePath = System.getProperty("user.home").replaceAll("\\\\", "/") +p.getProperty("ChromeDriver");
					System.setProperty("webdriver.chrome.driver", chromePath);

					//System.setProperty("webdriver.chrome.driver", "C:\\LiquidAutomation\\driver\\chromedriver.exe");
					if (!"false".equals(local))	{
						driver=new ChromeDriver(capabilities);
					}
				}
			}
		}
		catch(Exception e) {
			if (driver == null){
				initializeDriver(ExecuteinBackground);
			}
			return driver;
		}
		return driver;
	}

	public static void wait(int seconds){
		try{
			Thread.sleep(seconds);
		}
		catch (Exception e){
			System.out.println("Exception Caught in Wait command " +e.getLocalizedMessage());
		}
	}

	private static void initializeThreadLocal(){
		try {
			if (threadDriver == null){
				threadDriver = new ThreadLocal<ThreadedItems>();
			}
			if (threadDriver.get() == null){
				threadDriver.set(new ThreadedItems());
			}
		}
		catch(Exception e) {
			System.out.println("Failed to intialize Thread local  " +e.getLocalizedMessage());
		}
	}

	public static void initializeWebDriver(String ExecuteinBackground){
		try {
			killBogusProcesses();
			initializeThreadLocal();
			getDriver(ExecuteinBackground).manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch(Exception e) {
			threadDriver=null;
			getDriver(ExecuteinBackground).manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	public static void killWebDriver()
	{
		try {
			threadDriver.get().getDriver().quit();
			threadDriver.get().setDriver(null);
		}
		catch(Exception e) {

		}

		//killProcess("EXCEL.EXE");
	}

	private static void killProcess(String name){
		try{
			if (processIsRunning(name)) {
				Runtime.getRuntime().exec(Constants.KILL + name);
			}
		}
		catch (IOException ioe){
		}
	}

	private static boolean processIsRunning(String name) throws IOException{
		Process p = Runtime.getRuntime().exec(Constants.TASKLIST);
		BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null){
			System.out.println(line);
			if (line.contains(name)){
				return true;
			}
		}
		return false;
	}

	private static void killBogusProcesses(){
		String processName = "";
		String browser = "chrome";
		if ("chrome".equals(browser)){
			processName = "chromedriver.exe";
		}
		String[] processes = processName.split(",");
		for (String process : processes){
			killProcess(process);
		}
	}

	public static void captureScreen(final String imagesPath,final String screenShotName) {
		try {
			final TakesScreenshot oScn = (TakesScreenshot)threadDriver.get().getDriver();
			final File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
			final String timestamp = new SimpleDateFormat("yyyyMMddhhmmss",Locale.US).format(new Date());
			final File oDest = new File(String.valueOf(imagesPath) + "/"+screenShotName+"_" +timestamp+ ".png");
			try {
				FileUtils.copyFile(oScnShot, oDest);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch (NoSuchWindowException excption) {
		}
		catch (UnhandledAlertException ae) {
		}
	}

	public static void captureScreen(WebDriver driver,final String imagesPath,final String screenShotName) {
		try {
			final TakesScreenshot oScn = (TakesScreenshot)driver;
			final File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
			final String timestamp = new SimpleDateFormat("yyyyMMddhhmmss",Locale.US).format(new Date());
			final String random = String.format("%03d", RandomInteger(0,999));
			final File oDest = new File(String.valueOf(imagesPath) + "/"+screenShotName+"_" +timestamp+random+ ".png");
			try {
				FileUtils.copyFile(oScnShot, oDest);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		catch (NoSuchWindowException excption) {
		}
		catch (UnhandledAlertException ae) {
		}
	}

	public static int RandomInteger(int maximum, int minimum){
		return ((int) (Math.random()*(maximum - minimum))) + minimum;
	}

	public synchronized void WriteStatustoexcel(String filepath, String SheetName, int TotalPassed, int TotalFailed, String Errmessage) throws FileNotFoundException
	{
		XSSFWorkbook wb=null;
		FileOutputStream fos=null;
		InputStream fis=null;
		try {
			File file = new File(filepath); 
			XSSFSheet sheet;
			Row row;
			int RowCount = 0;
			Cell cell;
			if(!file.exists()) {
				wb=new XSSFWorkbook();
				sheet = wb.createSheet(SheetName);
				row=sheet.createRow(RowCount);
				cell=row.createCell(0);
				cell.setCellType(XSSFCell.CELL_TYPE_STRING);
				cell.setCellValue("SUCCESSFULL RECORDS - "+ TotalPassed);
				RowCount=RowCount+1;
				row=sheet.createRow(RowCount);
				cell=row.createCell(0);
				cell.setCellType(XSSFCell.CELL_TYPE_STRING);
				cell.setCellValue("FAILED RECORDS - "+ TotalFailed);
				if(!Errmessage.isEmpty()) {
					RowCount=RowCount+1;
					row=sheet.createRow(RowCount);
					cell=row.createCell(0);
					cell.setCellType(XSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("FAILURE REASON - "+ Errmessage);
				}
				try {
					fos=new FileOutputStream(filepath);
					wb.write(fos);
					fos.flush();
					fos.close();
					wb.close();
				}
				catch(Exception writedata) {
					writedata.printStackTrace();
					File newFileName = new File(filepath);
					boolean fileIsNotLocked = isFileClosed(newFileName);
					while(!fileIsNotLocked) {
						Thread.sleep(3000);
						fileIsNotLocked = isFileClosed(newFileName);
					}
					fos=new FileOutputStream(filepath);
					wb.write(fos);
					fos.flush();
					fos.close();
					wb.close();
				}
			}
			else {
				File newFileName = new File(filepath);
				boolean fileIsNotLocked = file.renameTo(newFileName);
				while(!fileIsNotLocked) {
					Thread.sleep(3000);
					fileIsNotLocked = file.renameTo(newFileName);
				}
				fis= new FileInputStream(filepath);
				try {
					wb=new XSSFWorkbook(fis);
				}
				catch(Exception workbookException) {
					workbookException.printStackTrace();
					newFileName = new File(filepath);
					fileIsNotLocked = isFileClosed(newFileName);
					while(!fileIsNotLocked) {
						Thread.sleep(3000);
						fileIsNotLocked = isFileClosed(newFileName);
					}
					fis= new FileInputStream(filepath);
					wb=new XSSFWorkbook(fis);
				}
				sheet=wb.getSheet(SheetName);
				int lastrowcount = sheet.getLastRowNum();
				row=sheet.createRow(lastrowcount+1);
				cell=row.createCell(0);
				cell.setCellType(XSSFCell.CELL_TYPE_STRING);
				cell.setCellValue("SUCCESSFULL RECORDS - "+ TotalPassed);
				row=sheet.createRow(lastrowcount+2);
				cell=row.createCell(0);
				cell.setCellType(XSSFCell.CELL_TYPE_STRING);
				cell.setCellValue("FAILED RECORDS - "+ TotalFailed);
				if(!Errmessage.isEmpty()) {
					row=sheet.createRow(lastrowcount+3);
					cell=row.createCell(0);
					cell.setCellType(XSSFCell.CELL_TYPE_STRING);
					cell.setCellValue("FAILURE REASON - "+ Errmessage);
				}

				//Close inputStream
				fis.close();

				try {
					fos=new FileOutputStream(filepath);
					wb.write(fos);
					fos.flush();
					fos.close();
					wb.close();
				}
				catch(Exception writedata) {
					writedata.printStackTrace();
					File newFileNames = new File(filepath);
					boolean fileIsLocked = isFileClosed(newFileNames);
					while(!fileIsLocked) {
						Thread.sleep(3000);
						fileIsLocked = isFileClosed(newFileNames);
					}
					fos=new FileOutputStream(filepath);
					wb.write(fos);
					fos.flush();
					fos.close();
					wb.close();
				}
			}

		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error in Writing Execution Summary to output file"+ e.getMessage());
			e.printStackTrace();
		}
	}

	//To check if file is locked
	private boolean isFileClosed(File file) {  
		boolean closed;
		Channel channel = null;
		try {
			channel = new RandomAccessFile(file, "rw").getChannel();
			closed = true;
		} catch(Exception ex) {
			closed = false;
		} finally {
			if(channel!=null) {
				try {
					channel.close();
				} catch (IOException ex) {
					// exception handling
				}
			}
		}
		return closed;
	}

}