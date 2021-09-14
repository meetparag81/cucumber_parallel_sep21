package DataManupulation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.botsftool.dsg.utilities.Constants;
import com.botsftool.dsg.utilities.CustomMethods;

public class ManageDataPage extends CustomMethods {

	public ManageDataPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[text()='Create New ']/ancestor::td[1]//input")
	public WebElement createNewPosition;

	@FindBy(xpath = "(//div[@class='buttonBar']//button)[2]")
	public WebElement savePosition;

	@FindBy(xpath = "(//div[@class='buttonBar']//button)[1]")
	public WebElement cancelPosition;

	@FindBy(xpath = "(//div[@class='buttonLayout']//button)[2]")
	public WebElement DontSave;

	@FindBy(xpath = "//button[text()='Confirm']")
	public WebElement ConfirmPosition;

	@FindBy(xpath = "//div[contains(@class,'BusyIndicator')]")
	public WebElement BusyIndicator;
	
	@FindBy(xpath = "//div[contains(@id,'shim')]")
	public WebElement BusyIndicators;

	@FindBy(xpath = "//div[contains(@class,'sfDialogBox')]")
	public WebElement errorDailog;
	
	@FindBy(xpath = "//button[text()='OK']")
	public WebElement OkPopup;
	
	@FindBy(xpath = "//button[text()='No']")
	public WebElement NoPopup;
	
	@FindBy(xpath = "//button[text()='Yes']")
	public WebElement YesPopup;

	public String allInputElements = "//div[@class='layoutFieldsContainer']//input";
	public String InputLabels = "preceding::td[1]";
	public String PositionCode= "(//span[@class='text' and contains(text(),'Position Code')]/following::td[1]//span[contains(@id,'read')])[1]";
	public String PositionCodeInstance= "(//span[@class='text' and contains(text(),'Position Number')]/following::td[1]//span[contains(@id,'read')])[1]";
	public String PositionID= "(//span[@class='text' and contains(text(),'Position ID')]/following::td[1]//span[contains(@id,'read')])[1]";
	public String PositionCodeInstances= "(//span[@class='text' and contains(text(),'Position')]/following::td[1]//span[contains(@id,'read')])[1]";
	public String PositionCodes= "(//span[@class='text' and contains(text(),'Code')]/following::td[1]//span[contains(@id,'read')])[1]";

	public ManageDataPage waitforload(){
		waitForClickable(createNewPosition);
		waitForTime(2000);
		return this;
	}

	//To Search for Position Keyword
	public ManageDataPage CreatePosition(String SearchFilter){
		waitForClickable(createNewPosition);
		click(createNewPosition);
		wait(1000);
		pick(createNewPosition, SearchFilter, "//*[text()='Create New ']/ancestor::td[1]//input");
		wait(1000);
		if(iselementExists(DontSave)) {
			click(DontSave);
		}
		wait(5000);
		return this;
	}

	//To Search for Position Keyword
	public ManageDataPage CreatePosition(String SHTAIntegration,String SearchFilter){
		waitForClickable(createNewPosition);
		//Liquid Automation Integration
		if(SHTAIntegration.equalsIgnoreCase("Yes")) {
			try {
				String Label = getElementLabel(driver, createNewPosition);
				Constants.LabelHeader.add(Label);
				Constants.LabelValue.add("Position");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Failed to retrieve SHTA Integration label for Position Search");
			}
		}
		click(createNewPosition);
		wait(1000);
		pick(createNewPosition, "Position", "//*[text()='Create New ']/ancestor::td[1]//input");
		wait(1000);
		if(iselementExists(DontSave)) {
			click(DontSave);
		}
		return this;
	}

	//Method to Save Position
	public ManageDataPage SavePosition(){
		waitForClickable(savePosition);
		click(savePosition);
		waitForTime(8000);
		return this;
	}

	//Method to click on Confirm Workflow
	public ManageDataPage confirmPositionworkflow(){
		if(iselementExists(ConfirmPosition)) {
			click(ConfirmPosition);
			waitForTime(5000);
		}
		return this;
	}

	//Method to Cancel the position creation transaction
	public ManageDataPage CancelPosition(){
		waitForClickable(cancelPosition);
		click(cancelPosition);
		wait(3000);
		waitForClickable(DontSave);
		click(DontSave);
		wait(3000);
		return this;
	}

}
