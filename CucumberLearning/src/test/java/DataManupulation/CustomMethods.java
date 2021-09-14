package DataManupulation;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.Channel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.Charsets;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;
import com.google.common.io.Files;


public class CustomMethods extends CorehelperClass {
	static Logger logger = Logger.getLogger(CustomMethods.class.getName());
	protected WebDriver driver;
	protected WebDriverWait wait;
	private static JavascriptExecutor jsExec;

	public CustomMethods(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Constants.webdriverTimeout);
		jsExec = (JavascriptExecutor) driver;
	}


	public void enterText(WebElement input, String text){
		if (text == null || text.isEmpty())
			return;
		waitForClickable(input);
		input.clear();
		if (text.equals("NULL"))
			return;
		input.sendKeys(text);
	}

	public void click(WebElement elem){
		waitForClickable(elem);
		elem.click();
	}

	public void Actionclick(WebElement elem){
		waitForClickable(elem);
		Actions action = new Actions(driver);
		action.moveToElement(elem).click().perform();
	}

	public boolean iselementExists (WebElement element)
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

	public boolean waitForClickable(WebElement element){
		boolean result;
		try {
			wait = new WebDriverWait(driver, Constants.webdriverTimeout);
			WebElement elm=wait.until(ExpectedConditions.elementToBeClickable(element));
			if(elm.equals(null)) {
				result = false;
			}
			else {
				result=true;
			}
		}
		catch(Exception elementnotfound) {
			result=false;
		}
		return result;
	}

	public void hoverElement(WebElement elem){
		Actions actions = new Actions(driver);
		actions.moveToElement(elem).build().perform();
	}

	public boolean waitForClickable(By element){
		boolean result;
		try {
			wait = new WebDriverWait(driver, Constants.webdriverTimeout);
			WebElement elm=wait.until(ExpectedConditions.presenceOfElementLocated(element));
			if(elm.equals(null)) {
				result = false;
			}
			else {
				result=true;
			}
		}
		catch(Exception elementnotfound) {
			result=false;
		}
		return result;
	}

	public void waitForJQueryLoad() {
		try {
			ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) this.driver).executeScript("return jQuery.active") == 0);
			boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");
			if (!jqueryReady) {
				wait.until(jQueryLoad);
			} 
		}
		catch (Exception ignored) {
		}
	}

	public boolean isEditable(WebElement element){
		boolean result=true;
		try {
			String attribute=element.getAttribute("readonly");
			if(attribute.equals("true")) {
				result=false;
			}
		}
		catch(Exception propertynotfound) {
			return result;
		}
		return result;
	}

	public void sendKeyPress(WebElement elm, Keys k){
		if (elm != null)
			elm.sendKeys(k);
	}

	public boolean isalertexists()
	{
		boolean result=false;
		try {
			driver.switchTo().alert();
			result=true;
		}
		catch(Exception noalertfound) {
			return result;
		}
		return result;
	}

	public void acceptAlert()
	{
		if (wait.until(ExpectedConditions.alertIsPresent()) != null){
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
	}


	//To Read from excel 
	public static String ReadFromExcel(String excelFile, String sheetName,
			String keyColumn, String key, String columnHeader) throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {
		String returnValue = "";
		InputStream inpFile=new FileInputStream(new File(excelFile));
		Workbook workbook=WorkbookFactory.create(inpFile);
		Sheet sheet= workbook.getSheet(sheetName);
		int refCol=findCol(sheet,keyColumn);
		int destCol=findCol(sheet,columnHeader);
		if(refCol!=-1 && destCol!=-1){
			int lastRow=sheet.getLastRowNum();
			Row row;
			for(int i=1;i<lastRow;i++){
				row=sheet.getRow(i);
				if(row.getCell(refCol).toString().equalsIgnoreCase(key)){
					Cell cel=row.getCell(destCol);
					returnValue = cel.getStringCellValue();
					break;
				}
			}
			workbook.write(new FileOutputStream(excelFile));
			workbook.close();
		}else{
			System.out.println("");
		}
		return returnValue;
	}

	//To find the column in the excel
	public static int findCol(Sheet sheet, String colName) {
		Row row = null;            
		int colCount=0;
		row=sheet.getRow(0);
		if(!(row== null)){
			colCount=row.getLastCellNum();
		}
		for(int j=0;j<colCount;j++){
			if(!( row.getCell(j)==null)){
				if(row.getCell(j).toString().trim().equalsIgnoreCase(colName)){
					return j;
				}
			}
		}
		return -1;
	}

	//To Get the element label for SHTA integration
	public static String getElementLabel(WebDriver driver,WebElement element) throws IOException {
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		List<String> elementInfo = null;
		String FieldLabel="";
		try {
			elementInfo =(List<String>)js.executeScript(getJSfileContent()+" return createRelativeXPathFromElement(arguments[0]);",element);
		}
		catch(Exception Elementnotfound) {
			System.out.println("Failed to retrive SHTA Integration Label Value for given field");
		}
		if(!(elementInfo==null)) {
			if(elementInfo.get(1).trim().contains("  ")) {
				FieldLabel=elementInfo.get(1).trim().replace("  ", " ");
			}
			else {
				FieldLabel=elementInfo.get(1).trim();
			}
			System.out.println("Label of Element as per SHTA Integration is "+ FieldLabel.replace(" ", "_").replace("'", "")); 
			FieldLabel=FieldLabel.replace(" ", "_").replace("'", "").trim();
		}
		return FieldLabel;
	}

	//Method to select the value from pick field
	public String pick(WebElement ele,String value,String xpath) {
		String result="";
		try {
			if(!ele.getAttribute("value").equalsIgnoreCase(""))
			{   JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].value = '';", ele);
			}
			if (value.split("\\(")[0].trim().length() >= 27) {
				ele.sendKeys((value.split("\\(")[0].trim()).substring(0, 27).trim());
			} else {
				ele.sendKeys(value.split("\\(")[0].trim());
			}
			wait(10000);
			ele=driver.findElement(By.xpath(xpath));
			//String listXpath = "//div[contains(@class,'sapMComboBoxBasePicker-CTX') and contains(@style,'visibility: visible')]//ul/li[not(contains(@class, 'sapMSelectListItemBaseInvisible'))]";
			String listXpath = "//div[contains(@class,'sapMPopoverScroll')]//ul[contains(@class,'sapMSelectList')]/li";
			List<WebElement> listElement = driver.findElements(By.xpath(listXpath));
			System.out.println("List 1 " + listElement.size());
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[contains(@class,'sf-combo-listselect')]//ul/li[contains(@role,'option')]";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 2 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[contains(@class,'sapMComboBoxBasePicker-CTX') and contains(@style,'visibility: visible')]//ul/li[not(contains(@class, 'sapMSelectListItemBaseInvisible')) and not(contains(@id, 'sap-ui-invisible'))]";
				listElement =driver.findElements(By.xpath(listXpath));
				System.out.println("List 3 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[@class='sapMPopoverCont' and contains(@style, 'overflow: auto;')]/following::td[@class='sapMListTblCell']";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 4 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[@id='phSearchInput_autoCompleteBoxId']//ul/li[contains(@role,'presentation') and contains(@onmouseover,'phSearchInput')]";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 5 " + listElement.size());
			}
			result = "";
			String innerText = "";
			for (WebElement el: listElement) {
				ele.sendKeys(Keys.DOWN);
				waitForTime(1000);
				innerText = el.getText().trim();
				System.out.println("innertext is "+innerText);
				if (innerText.equalsIgnoreCase(value)) {
					ele.sendKeys(Keys.ENTER);
					result=innerText;
					break;
				}
				waitForTime(250);
			}
			waitForTime(2000);

		} catch (Exception e) {
			//failureReason = e.getMessage();
			return result;
			//throw e;
		}
		return result;
	}

	//To pick the search user from target user page
	public String pickFromTargetUser(WebElement ele,String value,String xpath) {
		String result="";
		boolean valueCleared=false;
		try {
			value = value.replaceAll("\\u200e", "").replaceAll("\\u200f", "").replaceAll("\\h"," ").replace("?","").trim();
			if(!ele.getAttribute("value").equalsIgnoreCase("")){   
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].value = '';", ele);
				valueCleared=true;
			}

			/*if(valueCleared) {
				enterValue(value,ele,driver);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].value = '';", ele);
				waitForTime(250);
			}*/

			enterValue(value,ele,driver);
			waitForTime(8000);

			try {
				ele=driver.findElement(By.xpath(xpath));
				if(ele.getAttribute("value").equalsIgnoreCase("")){
					enterValue(value,ele,driver);  
					System.out.println("Value Entered Twice");
					waitForTime(8000);
				} 
			} catch (Exception e) {
				System.out.println("retryFailed"+ e.getMessage());
			}

			ele=driver.findElement(By.xpath(xpath));
			String listXpath = "//div[contains(@class,'sf-combo-listselect')]//ul/li[contains(@role,'option')]";
			List<WebElement> listElement = driver.findElements(By.xpath(listXpath));
			System.out.println("List 1 " + listElement.size());
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[@class='sapMPopoverCont' and contains(@style, 'overflow: auto;')]/following::td[@class='sapMListTblCell']";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 2 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[contains(@class,'sapMComboBoxBasePicker-CTX') and contains(@style,'visibility: visible')]//ul/li[not(contains(@class, 'sapMSelectListItemBaseInvisible')) and not(contains(@id, 'sap-ui-invisible'))]";
				listElement =driver.findElements(By.xpath(listXpath));
				System.out.println("List 3 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[contains(@class,'sapMPopoverScroll')]//ul[contains(@class,'sapMSelectList')]/li";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 4 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[contains(@class,'sapMPopoverScroll')]/descendant::tbody/tr";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 5 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[@id='phSearchInput_autoCompleteBoxId']//ul/li[contains(@role,'presentation') and contains(@onmouseover,'phSearchInput')]";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 6 " + listElement.size());
			}
			result = "";
			String innerText = "";
			for (WebElement el: listElement) {
				ele.sendKeys(Keys.DOWN);
				waitForTime(1000);
				innerText = el.getText().trim();
				System.out.println("innertext is "+innerText);
				if (innerText.contains(value)) {
					ele.sendKeys(Keys.ENTER);
					result=innerText;
					break;
				}
				waitForTime(250);
			}
			waitForTime(2000);

		} catch (Exception e) {
			//failureReason = e.getMessage();
			result="";
			return result;
			//throw e;
		}
		return result;
	}

	//To Pick positions from Position Org chart
	public String pickpositions(WebElement ele,String value,String xpath) {
		String result="";
		try {
			if(!ele.getAttribute("value").equalsIgnoreCase(""))
			{   JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].value = '';", ele);
			}
			if (value.split("\\(")[0].trim().length() >= 27) {
				ele.sendKeys((value.split("\\(")[0].trim()).substring(0, 27).trim());
			} else {
				ele.sendKeys(value.split("\\(")[0].trim());
			}
			wait(8000);
			ele=driver.findElement(By.xpath(xpath));
			//String listXpath = "//div[contains(@class,'sapMComboBoxBasePicker-CTX') and contains(@style,'visibility: visible')]//ul/li[not(contains(@class, 'sapMSelectListItemBaseInvisible'))]";
			String listXpath = "//div[@class='sapMPopoverCont' and contains(@style, 'overflow: auto;')]/following::td[@class='sapMListTblCell']";
			List<WebElement> listElement = driver.findElements(By.xpath(listXpath));
			System.out.println("List 1 " + listElement.size());
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[contains(@class,'sf-combo-listselect')]//ul/li[contains(@role,'option')]";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 2 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[contains(@class,'sapMComboBoxBasePicker-CTX') and contains(@style,'visibility: visible')]//ul/li[not(contains(@class, 'sapMSelectListItemBaseInvisible')) and not(contains(@id, 'sap-ui-invisible'))]";
				listElement =driver.findElements(By.xpath(listXpath));
				System.out.println("List 3 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[contains(@class,'sapMPopoverScroll')]//ul[contains(@class,'sapMSelectList')]/li";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 4 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[@id='phSearchInput_autoCompleteBoxId']//ul/li[contains(@role,'presentation') and contains(@onmouseover,'phSearchInput')]";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 5 " + listElement.size());
			}
			result = "";
			String innerText = "";
			for (WebElement el: listElement) {
				ele.sendKeys(Keys.DOWN);
				waitForTime(1000);
				innerText = el.getText().trim();
				System.out.println("innertext is "+innerText);
				if (innerText.contains(value)) {
					ele.sendKeys(Keys.ENTER);
					result=innerText;
					break;
				}
				else {
					innerText = el.findElement(By.xpath("descendant::a[1]")).getAttribute("title");
					System.out.println("innertext is "+innerText);
					if (innerText.contains(value)) {
						ele.sendKeys(Keys.ENTER);
						result=innerText;
						break;
					}
				}
				waitForTime(250);
			}
			waitForTime(2000);

		} catch (Exception e) {
			//failureReason = e.getMessage();
			result="";
			return result;
			//throw e;
		}
		return result;
	}

	public String pickfromdropdown(WebElement ele,String value,String xpath) {
		String result="";
		try {
			ele=driver.findElement(By.xpath(xpath));
			if(!ele.getAttribute("value").equalsIgnoreCase(""))
			{   JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].value = '';", ele);
			}
			if (value.split("\\(")[0].trim().length() >= 27) {
				ele.sendKeys((value.split("\\(")[0].trim()).substring(0, 27).trim());
			} else {
				ele.sendKeys(value.split("\\(")[0].trim());
			}
			wait(10000);
			ele=driver.findElement(By.xpath(xpath));
			//String listXpath = "//div[contains(@class,'sapMComboBoxBasePicker-CTX') and contains(@style,'visibility: visible')]//ul/li[not(contains(@class, 'sapMSelectListItemBaseInvisible'))]";
			String listXpath = "//div[contains(@class,'sapMPopoverScroll')]//ul[contains(@class,'sapMSelectList')]/li";
			List<WebElement> listElement = driver.findElements(By.xpath(listXpath));
			System.out.println("List 1 " + listElement.size());
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[contains(@class,'sf-combo-listselect')]//ul/li[contains(@role,'option')]";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 2 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[contains(@class,'sapMComboBoxBasePicker-CTX') and contains(@style,'visibility: visible')]//ul/li[not(contains(@class, 'sapMSelectListItemBaseInvisible')) and not(contains(@id, 'sap-ui-invisible'))]";
				listElement =driver.findElements(By.xpath(listXpath));
				System.out.println("List 3 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[@class='sapMPopoverCont' and contains(@style, 'overflow: auto;')]/following::td[@class='sapMListTblCell']";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 4 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[@id='phSearchInput_autoCompleteBoxId']//ul/li[contains(@role,'presentation') and contains(@onmouseover,'phSearchInput')]";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 5 " + listElement.size());
			}
			result = "";
			String innerText = "";
			for (WebElement el: listElement) {
				ele.sendKeys(Keys.DOWN);
				waitForTime(1000);
				innerText = el.getText().trim();
				System.out.println("innertext is "+innerText);
				if (innerText.equalsIgnoreCase(value)) {
					ele.sendKeys(Keys.ENTER);
					result=innerText;
					break;
				}
				waitForTime(250);
			}
			waitForTime(2000);

		} catch (Exception e) {
			//failureReason = e.getMessage();
			return result;
			//throw e;
		}
		return result;
	}

	public String pickEmployee(WebElement ele,String value,String xpath) {
		String result="";
		boolean valueCleared=false;
		try {
			value = value.replaceAll("\\u200e", "").replaceAll("\\u200f", "").replaceAll("\\h"," ").replace("?","").trim();
			if(!ele.getAttribute("value").equalsIgnoreCase("")){   
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].value = '';", ele);
				valueCleared=true;
			}

			if(valueCleared) {
				enterValue(value,ele,driver);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].value = '';", ele);
				waitForTime(250);
			}

			enterValue(value,ele,driver);
			waitForTime(5000);

			try {
				ele=driver.findElement(By.xpath(xpath));
				if(ele.getAttribute("value").equalsIgnoreCase("")){
					enterValue(value,ele,driver);  
					System.out.println("Value Entered Twice");
					waitForTime(5000);
				} 
			} catch (Exception e) {
				System.out.println("retryFailed"+ e.getMessage());
			}

			ele=driver.findElement(By.xpath(xpath));
			//String listXpath = "//div[contains(@class,'sapMComboBoxBasePicker-CTX') and contains(@style,'visibility: visible')]//ul/li[not(contains(@class, 'sapMSelectListItemBaseInvisible'))]";
			String listXpath = "//div[contains(@class,'sapMPopoverScroll')]//ul[contains(@class,'sapMSelectList')]/li";
			List<WebElement> listElement = driver.findElements(By.xpath(listXpath));
			System.out.println("List 1 " + listElement.size());
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[contains(@class,'sf-combo-listselect')]//ul/li[contains(@role,'option')]";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 2 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[contains(@class,'sapMComboBoxBasePicker-CTX') and contains(@style,'visibility: visible')]//ul/li[not(contains(@class, 'sapMSelectListItemBaseInvisible')) and not(contains(@id, 'sap-ui-invisible'))]";
				listElement =driver.findElements(By.xpath(listXpath));
				System.out.println("List 3 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[@class='sapMPopoverCont' and contains(@style, 'overflow: auto;')]/following::td[@class='sapMListTblCell']";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 4 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[@id='phSearchInput_autoCompleteBoxId']//ul/li[contains(@role,'presentation') and contains(@onmouseover,'phSearchInput')]";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 5 " + listElement.size());
			}
			result = "";
			String innerText = "";
			for (WebElement el: listElement) {
				ele.sendKeys(Keys.DOWN);
				waitForTime(1000);
				innerText = el.getText().trim();
				System.out.println("innertext is "+innerText);
				if (innerText.contains(value)) {
					ele.sendKeys(Keys.ENTER);
					result=innerText;
					break;
				}
				waitForTime(250);
			}
			waitForTime(2000);

		} catch (Exception e) {
			//failureReason = e.getMessage();
			return result;
			//throw e;
		}
		return result;
	}

	public String pickEmployeefromdropdown(WebElement ele,String value,String xpath) {
		String result="";
		boolean valueCleared=false;
		try {
			value = value.replaceAll("\\u200e", "").replaceAll("\\u200f", "").replaceAll("\\h"," ").replace("?","").trim();
			ele=driver.findElement(By.xpath(xpath));
			if(!ele.getAttribute("value").equalsIgnoreCase("")){   
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].value = '';", ele);
				valueCleared=true;
			}

			if(valueCleared) {
				enterValue(value,ele,driver);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].value = '';", ele);
				waitForTime(250);
			}

			enterValue(value,ele,driver);
			waitForTime(5000);

			try {
				ele=driver.findElement(By.xpath(xpath));
				if(ele.getAttribute("value").equalsIgnoreCase("")){
					enterValue(value,ele,driver);  
					System.out.println("Value Entered Twice");
					waitForTime(5000);
				} 
			} catch (Exception e) {
				System.out.println("retryFailed"+ e.getMessage());
			}

			ele=driver.findElement(By.xpath(xpath));
			//String listXpath = "//div[contains(@class,'sapMComboBoxBasePicker-CTX') and contains(@style,'visibility: visible')]//ul/li[not(contains(@class, 'sapMSelectListItemBaseInvisible'))]";
			String listXpath = "//div[contains(@class,'sapMPopoverScroll')]//ul[contains(@class,'sapMSelectList')]/li";
			List<WebElement> listElement = driver.findElements(By.xpath(listXpath));
			System.out.println("List 1 " + listElement.size());
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[contains(@class,'sf-combo-listselect')]//ul/li[contains(@role,'option')]";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 2 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[contains(@class,'sapMComboBoxBasePicker-CTX') and contains(@style,'visibility: visible')]//ul/li[not(contains(@class, 'sapMSelectListItemBaseInvisible')) and not(contains(@id, 'sap-ui-invisible'))]";
				listElement =driver.findElements(By.xpath(listXpath));
				System.out.println("List 3 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[@class='sapMPopoverCont' and contains(@style, 'overflow: auto;')]/following::td[@class='sapMListTblCell']";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 4 " + listElement.size());
			}
			if (listElement == null || listElement.size() == 0) {
				listXpath = "//div[@id='phSearchInput_autoCompleteBoxId']//ul/li[contains(@role,'presentation') and contains(@onmouseover,'phSearchInput')]";
				listElement = driver.findElements(By.xpath(listXpath));
				System.out.println("List 5 " + listElement.size());
			}
			result = "";
			String innerText = "";
			for (WebElement el: listElement) {
				ele.sendKeys(Keys.DOWN);
				waitForTime(1000);
				innerText = el.getText().trim();
				System.out.println("innertext is "+innerText);
				if (innerText.contains(value)) {
					ele.sendKeys(Keys.ENTER);
					result=innerText;
					break;
				}
				waitForTime(250);
			}
			waitForTime(2000);

		} catch (Exception e) {
			//failureReason = e.getMessage();
			return result;
			//throw e;
		}
		return result;
	}

	public static void waitForTime(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			//failureReason = e.getMessage();
			e.printStackTrace();
		}
	}

	//To enter value into pick list
	public void enterValue(String value,WebElement element,WebDriver driver) {
		element.click();
		waitForTime(2000);
		if (value.contains("(")){
			if (value.split("\\(")[1].split("\\)")[0].trim().length()==1){
				if (value.split("\\(")[0].trim().length() >= 27){
					String oValue = value.split("\\(")[0].substring(0, 27).trim();
					element.sendKeys(oValue);
				}
				else {
					String oValue = value.split("\\(")[0].trim();
					element.sendKeys(oValue);
				}
			}
			else if (value.split("\\(")[1].split("\\)")[0].trim().length() >= 27) {
				String oValue = value.split("\\(")[1].split("\\)")[0].substring(0, 27).trim();
				element.sendKeys(oValue);
			} else {
				String oValue = value.split("\\(")[1].split("\\)")[0].trim();
				element.sendKeys(oValue);
			}
		}
		else {
			if (value.trim().length() >= 27) {
				element.sendKeys(value.substring(0, 27).trim());
			} else {
				element.sendKeys(value.trim());
			}
		}
	}

	public static By objectName(String objectName, String type) {

		if (objectName != null) {
			type = (type == null || type.trim().isEmpty()) ? "XPATH" : type;
			switch (type.toLowerCase()) {

			case "css":
				return By.cssSelector(objectName);

			case "id":
				return By.id(objectName);

			case "name":
				return By.name(objectName);

			case "lt":
				return By.linkText(objectName);

			case "plt":
				return By.partialLinkText(objectName);

			case "xpath":
				return By.xpath(objectName);

			case "tagname":
				return By.tagName(objectName);

			case "class":
				return By.className(objectName);

			default:
				if ("classname".equals(type.toLowerCase())) {
					return By.className(objectName);
				} else if ("linktext".equals(type.toLowerCase())) {
					return By.linkText(objectName);
				} else if ("partiallinktext".equals(type.toLowerCase())) {
					return By.partialLinkText(objectName);
				} else {
					return By.xpath(objectName);
				}
			}
		}		
		return null;
	}

	public void executeJavaScript(String scriptToExecute,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(scriptToExecute,element);
	}

	//Method to Create and write the data to excel
	//return type changed to boolean to handle exception by Girija
	public synchronized boolean Writetoexcel(String filepath, String SheetName, ArrayList<String> header, ArrayList<String> value) throws FileNotFoundException
	{
		boolean result = false;
		XSSFWorkbook wb = null;
		FileOutputStream fos=null;
		InputStream fis=null;
		try {
			File file = new File(filepath); 
			XSSFSheet sheet;
			Row headerrow;
			int RowCount = 0;
			Cell headercell;
			if(!file.exists()) {
				wb=new XSSFWorkbook();
				sheet = wb.createSheet(SheetName);
				headerrow=sheet.createRow(RowCount);
				CellStyle style = wb.createCellStyle();
				style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				for(int i=0;i<header.size();i++) {
					headercell = headerrow.createCell(i);
					headercell.setCellValue(header.get(i));
					headercell.setCellStyle(style);
				}
				RowCount=RowCount+1;
				headerrow=sheet.createRow(RowCount);
				for(int j=0;j<value.size();j++) {
					headercell=headerrow.createCell(j);
					 headercell = (XSSFCell) headerrow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					 headercell.setCellType(CellType.STRING);
					//headercell.setCellType(XSSFCell.CELL_TYPE_STRING);
					headercell.setCellValue(value.get(j));
				}
				try {
					fos=new FileOutputStream(filepath);
					wb.write(fos);
					fos.flush();
					fos.close();
					wb.close();
					result=true;
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
					result=true;
				}
			}
			else {
				File newFileName = new File(filepath);
				boolean fileIsNotLocked = isFileClosed(newFileName);
				while(!fileIsNotLocked) {
					Thread.sleep(5000);
					fileIsNotLocked = isFileClosed(newFileName);
				}
				boolean found =false;
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
				headerrow=sheet.getRow(RowCount);
				CellStyle style = wb.createCellStyle();
				style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				for(int i=0;i<header.size();i++) {
					found = false;
					String headerValue= header.get(i);
					for(int j=0;j<headerrow.getLastCellNum();j++) {
						if(headerValue.equals(headerrow.getCell(j).toString())) {
							found = true;
							break;
						}
					}
					if(!found) {
						headercell = headerrow.createCell(headerrow.getLastCellNum());
						headercell.setCellType(CellType.STRING);
						//headercell.setCellType(XSSFCell.CELL_TYPE_STRING);
						headercell.setCellValue(headerValue);
						headercell.setCellStyle(style);
					}
				}
				int lastrowcount = sheet.getLastRowNum();
				headerrow=sheet.createRow(lastrowcount+1);
				for(int k=0;k<value.size();k++) {
					int colindex = 0;
					for(int l=0;l<sheet.getRow(RowCount).getLastCellNum();l++) {
						if(header.get(k).equals(sheet.getRow(RowCount).getCell(l).toString())) {
							colindex=l;
							break;
						}
					}
					headercell = headerrow.createCell(colindex);
					headercell.setCellValue(value.get(k));
				}

				//Close inputStream
				fis.close();

				try {
					fos=new FileOutputStream(filepath);
					wb.write(fos);
					fos.flush();
					fos.close();
					wb.close();
					result=true;
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
					result=true;
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error in Writing Data to Output File "+ e.getMessage());
			e.printStackTrace();
			result=false;
		}
		return result;
	}

	public static String getCurrencyfrompropertyfile(String selectedCountry)
	{
		String Result="";
		try {
			String country=selectedCountry.replace(" ", "");
			FileHandlingUtilities fn = new FileHandlingUtilities();
			Properties p = fn.fnReadPropertyFile("/com/botsftool/resources/DSGCurrencyList.properties");
			Result = p.getProperty(country);
		}
		catch(Exception countrynotfound) {
			return Result.trim();
		}
		return Result.trim();		
	}

	public static String getJSfileContent()
	{
		String Result="";
		try {
			String JSFilePath = System.getProperty("user.home").replaceAll("\\\\", "/")+"/RESOURCES/DSG/CustomJS/successfactors.js";
			Result=Files.toString(new File(JSFilePath), Charsets.UTF_8);
		}
		catch(Exception JSfileNotFound) {
			System.out.println("Error Reading JS file for SHTA Integartion");
			return Result;
		}
		return Result;		
	}

	private static boolean isFileClosed(File file) {  
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

	@Override
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
				//cell=row.createCell(0);
				cell = (XSSFCell) row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				cell.setCellType(CellType.STRING);
				//cell.setCellType(XSSFCell.CELL_TYPE_STRING);
				cell.setCellValue("SUCCESSFULL RECORDS - "+ TotalPassed);
				RowCount=RowCount+1;
				
				row=sheet.createRow(RowCount);
				cell = (XSSFCell) row.getCell(RowCount, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				//cell=row.createCell(0);
				cell.setCellType(CellType.STRING);
				//cell.setCellType(XSSFCell.CELL_TYPE_STRING);
				cell.setCellValue("FAILED RECORDS - "+ TotalFailed);
				if(!Errmessage.isEmpty()) {
					RowCount=RowCount+1;
					row=sheet.createRow(RowCount);
					cell=row.createCell(0);
					cell = (XSSFCell) row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					//cell.setCellType(XSSFCell.CELL_TYPE_STRING);
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
						Thread.sleep(5000);
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
					Thread.sleep(1000);
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
						Thread.sleep(5000);
						fileIsNotLocked = isFileClosed(newFileName);
					}
					fis= new FileInputStream(filepath);
					wb=new XSSFWorkbook(fis);
				}
				sheet=wb.getSheet(SheetName);
				int lastrowcount = sheet.getLastRowNum();
				row=sheet.createRow(lastrowcount+1);
				cell = (XSSFCell) row.getCell(0, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
				cell=row.createCell(0);
				cell.setCellType(CellType.STRING);
				cell.setCellValue("SUCCESSFULL RECORDS - "+ TotalPassed);
				row=sheet.createRow(lastrowcount+2);
				
				cell=row.createCell(0);
				cell.setCellType(CellType.STRING);
				cell.setCellValue("FAILED RECORDS - "+ TotalFailed);
				if(!Errmessage.isEmpty()) {
					row=sheet.createRow(lastrowcount+3);
					cell=row.createCell(0);
					cell.setCellType(CellType.STRING);
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
						Thread.sleep(5000);
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
			System.out.println("Error in Writing to Output Excel "+ e.getMessage());
			e.printStackTrace();
		}
	}

	//To generate Todays date
	public String getCurrentTimeStamp(String format) {
		String result="";
		SimpleDateFormat formDate = new SimpleDateFormat(format,Locale.US);
		result = formDate.format(new Date()); 
		return result;
	}

	//To get future Date
	public String getFutureTimeStamp(String format) {
		String result="";
		Faker faker=new Faker();
		SimpleDateFormat formDate = new SimpleDateFormat(format,Locale.US);
		result=formDate.format(faker.date().future(10, TimeUnit.DAYS, new Date())); 
		return result;
	}

	//To get future Date
	public String getDateAfterDays(String format, int days) {
		String result="";
		SimpleDateFormat formDate = new SimpleDateFormat(format,Locale.US);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days); 
		result=formDate.format(cal.getTime()); // +days
		return result;
	}

	//Method to Generate Random Integer
	public int getRandomInteger(int maximum, int minimum){
		return ((int) (Math.random()*(maximum - minimum))) + minimum;
	}

	//Method to parse and format date
	public String parseandFormatDate(String date, String parseformat,String outputformat) throws ParseException
	{
		String result="";
		SimpleDateFormat ParseFormat = new SimpleDateFormat(parseformat,Locale.US);
		Date parseDate= ParseFormat.parse(date);
		SimpleDateFormat Outputformat = new SimpleDateFormat(outputformat,Locale.US);
		result=Outputformat.format(parseDate);
		return result;
	}

	public static void setClipboardData(String filepath) {
		StringSelection stringSelection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

}
