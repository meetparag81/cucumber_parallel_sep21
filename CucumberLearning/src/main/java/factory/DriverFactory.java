package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver =  new ThreadLocal<>();
		
	public WebDriver Initalization(String Browser){
		if(Browser.equals("chrome")){
			
			WebDriverManager.chromiumdriver().setup();
			
			tlDriver.set(new ChromeDriver());
		}
		else if (Browser.equals("firefox")) {	
			
			WebDriverManager.firefoxdriver().setup();
			
			tlDriver.set(new FirefoxDriver());
		}
		else if (Browser.equals("Safari")) {
			tlDriver.set(new SafariDriver());
			
		}
		else{
			System.out.println("No driver is matched");
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver(){
		return tlDriver.get();
	}
	

}
