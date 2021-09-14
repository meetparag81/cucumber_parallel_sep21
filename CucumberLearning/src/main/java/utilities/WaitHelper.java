package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverFactory;






public class WaitHelper {
	private WebDriver driver;
	static Logger log=LoggerHelper.GetLogger(WaitHelper.class);
public WaitHelper(WebDriver driver){
	this.driver=driver;
}


	public static void ClickOn(WebDriver driver,WebElement locator,int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		log.info("Driver is wait for the element  to be clicked.");
		locator.click();
		log.info("Driver is wait for the element  to be clicked.");

	}
	public static void  VisibleOn(WebDriver driver,WebElement element,int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
		log.info("Driver is waited for"+element+"to be seen for" + timeout);
	}
	public static void  Clicable(WebDriver driver,WebElement element,int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
		log.info("Driver is waited for"+element+"to be seen for" + timeout);
	}

	public static void  VisibleElementsOn(WebDriver driver,List<WebElement> element,int timeout)
	{
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public static void ScrollthePage(JavascriptExecutor js,WebDriver driver)
	{
		JavascriptExecutor js1 = (JavascriptExecutor) DriverFactory.getDriver();
		js1.executeScript("scroll(0, 250);");

	}
	public static boolean iselementExists (WebElement element)
	{
		boolean result=false;;
		try{
			if(element.isDisplayed())
				result=true;
		}
		catch(Exception e){
			result=false;
		}
		return result;
	}




	public static void takeScreenshotAtEndOfTest1()
	{
		File scrFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try 
		{
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots1/" + System.currentTimeMillis() + ".png"));
		}
		catch (IOException e) 
		{
			System.out.println("Exception are" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static void takescreenshot(WebDriver driver, String screenshotname)  
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try 
		{
			log.info("Screenshot Name is"+ screenshotname+".png");
			FileUtils.copyFile(source, new File(currentDir + "/screenshots"+ screenshotname +".png"));
		} 
		catch (IOException e) 
		{
			System.out.println("Exception are" + e.getMessage());
			e.printStackTrace();
		}	

	}
	public static  void ActionForMovetoElement(WebElement element )
	{

		Actions act1 = new Actions(DriverFactory.getDriver());
		act1.moveToElement(element);

	}

	public static String getScreenshot(WebDriver driver, String screenshotName,int i, int j) throws Exception 
	{
		//below line is just to append the date format with the screenshot name to avoid duplicate names 
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"  +","+ "hh-mm-ss");
		formatter = new SimpleDateFormat("dd,MM,yyyy"); 
		String dateName = new SimpleDateFormat("dd,MM,yyyy" +","+ "hh-mm-ss").format(new Date());
		//  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination="";
		if(!(i==j))
		{
			//after execution, you could see a folder "FailedTestsScreenshots" under src folder

			destination = System.getProperty("user.dir") + "/PassesTestsScreenshots/"+screenshotName+dateName+".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
		}
		else
		{
			//after execution, you could see a folder "FailedTestsScreenshots" under src folder
			log.info("Screenshot Name is"+ screenshotName+".png");
			destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
		}
		return destination;




	}
}
