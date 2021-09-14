package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;

public class Hooks {
	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader ConfigReader;
	Properties prop;
	
	@Before(order=1)
	public void setup(){
		String browsername = prop.getProperty("browser");
		driverfactory=new DriverFactory();
		driver=driverfactory.Initalization(browsername);
	}
	@Before(order=0)
	public void getproperty(){
		ConfigReader= new ConfigReader();
		prop=ConfigReader.Init_prop();
	}
	
	
	@After(order=0)
	public void quitbrowser(){
		driver.quit();
	}
	
	@After(order=1)
	public void teardown (Scenario scenario){
		if(scenario.isFailed()){
			String screenshotname = scenario.getName().replaceAll(" ", "_");
			byte[] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "image/png", screenshotname);
		}
		
	}


}
