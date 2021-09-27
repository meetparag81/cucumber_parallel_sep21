package DataManupulation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LMS_mergeuser_driver extends CorehelperClass {


	// Global Variables
	static InputStream inpFile;
	static XSSFWorkbook workbook;
	static Row row = null;
	static Sheet sheet;
	static int lastRow = 0;
	static int templateCounter = 1;
	static String errorMessage = "";
	static ArrayList<String> AllaccessPermission = new ArrayList<String>();
	static XSSFWorkbook wb = null;
	static String Role = "";
	static File[] Files = new File("fileLocation\\").listFiles();

	private static int Inputfilerowcount;
	private static int columncount;
	private static String inputcolvalue;
	static int inputR0wowCount = 1;
	private static HashMap<String, Integer> rolekeyvalue;
	private static int permissionrowcount;
	private static int headrowcounter;
	private static ArrayList<String> PermissionNames;
	private static Row headrownext;
	private static Cell headercellnext;
	private static String cellname;
	private static ArrayList<String> TableHeaderList;
	private static String tableHeader;
	private static int counterheader;
	private static Row headrownextoption3;
	private static int headerOptions1rowcount;
	private static Row headrooption1next;
	private static int Addbuttoncounter;
	private static ArrayList<String> Header1List;
	private static Row headrow1next;
	private static int headrowcounter1;
	private static ArrayList<String> HeaderList;
	private static ArrayList<String> PermisionList;
	private static ArrayList<String> HeaderList2;
	private static int header2owcounter;
	private static XSSFRow headrow2next;
	private static ArrayList<String> Header2List;
	private static int headrowoptins2counter;
	private static Row headroptions2wnext;
	private static String Nextrowvalue;
	private static boolean flag;
	private static boolean flagheader2;
	private static String Nextrowvalueheader2;
	private static String Nextrowvalueheader1;
	private static boolean flagheader1;
	private static int cellcounter;
	private static HomePage HomePage;
	private static CareersiteBuilderPage CSB;
	private static WebElement Pages;
	private static WebElement Region;
	private static String permissionTitle;
	private static int counter;
	static int counterstyle=0;
	static int counterimg=0;
	static int countheadertext=0;
	static int countrbodytext=0;
	static int counterimage=0;
	StringBuilder sb=new StringBuilder();
	static Logger logger = Logger.getLogger(LMS_mergeuser_driver.class.getName());
	private static WebElement Headertext;
	private static WebElement permissionele;
	private static String xpath;
	private static LearningAdminPage LAP;
	public static void main(String[] args)throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
		// TODO Auto-generated method stub
		executeScript("C:\\WorkingfolderPB\\LMSDemo\\Template\\MergeUser_Template.xlsx","https://performancemanager8.successfactors.com/login?company=BPOCUSTOM10#/login","C:\\WorkingfolderPB\\LMSdeletebulktemplate\\Learning History Template060421.xlsx","MergeUsers", "MergeUsers", "BPOCUSTOM10", "bparag", "welcome234", "No", "Yes");

	}

	public static boolean executeScript(String filePath, String sURL, String templateFile, String sheetname,String templateSheet, String CompanyID, String userName, String password, String ExecuteinBackground,String SavetoInstance)throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
		// To Add Variables
		boolean result= false;
		counterstyle=0;
		WebDriver driver=null;
		WebElement learningAdmin = null;
		WebElement deletebutton=null;
		WebElement continueframe=null;
		WebElement continuebutton=null;
		List<WebElement> userids = null;
		WebElement userid = null;
		String outputTimeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());


		// Code Starts
		try {

			// Initialize driver
			initializeWebDriver(ExecuteinBackground);


			// get driver
			driver = getDriver(ExecuteinBackground);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

			// Initialize Custom method class
			CustomMethods helper = new CustomMethods(driver);

			// Login and Search for add new employee
			LoginPage login = new LoginPage(driver);
			HomePage=login.LoadURL(sURL).EnterCompanyID(CompanyID).Login(userName, password);
			Timestamp startTime = new Timestamp(System.currentTimeMillis());
			logger.info( "Start Time of Execution : " +startTime);		
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			Actions act = new Actions(driver);
			Thread.sleep(5000);
			try {

				//WebElement sapPopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sap-ui-blocklayer-popup']")));
				//waitForClickable(sapPopup);
				WebElement sapPopup = null;
				try {
					sapPopup = driver.findElement(By.xpath("//*[@id='sap-ui-blocklayer-popup']"));
					while(sapPopup==null) {
						Thread.sleep(1000);
						try {
						sapPopup = driver.findElement(By.xpath("//*[@id='sap-ui-blocklayer-popup']"));
						}
						catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				wait(100);
				executeJavaScript("arguments[0].click();",sapPopup, driver);
				wait(2000);
			}
			catch(Exception noPopupBlocker) {
				logger.info(noPopupBlocker.getMessage());
			}
			try {
				learningAdmin=  waitithpolling(driver, 150).until(ExpectedConditions.elementToBeClickable(HomePage.learningAdmin)); 
				while(learningAdmin==null) {
					Thread.sleep(100);
				}
			}
			catch (Exception e) {
				logger.info(e.getMessage());
			}
			LAP= HomePage.clickonLearningAdminstration();
			// Thread.sleep(10000);
			try {
				WebElement userlearning = waitithpolling(driver, 150).until(ExpectedConditions.elementToBeClickable(LAP.People)); 
				while(userlearning==null) {
					Thread.sleep(100);
				}

			}
			catch (Exception e) {
				logger.info("element is not seen with in defined time");
				//driver.findElement(By.xpath(xpathExpression))

			}
			LAP.clickonpeople();			 
			try {
				wait.until(ExpectedConditions.elementToBeClickable(LAP.manageUserLearning)); 
			}
			catch (Exception e) {
				logger.info(e.getStackTrace());
			}
			LAP.clickonMergeUser();

			try {
				wait.until(ExpectedConditions.elementToBeClickable(LAP.manageuseriframe)); 
			}
			catch (Exception e) {
				logger.info(e.getStackTrace());
			}
			LAP.switchtouseridframe();
			try {
				wait.until(ExpectedConditions.elementToBeClickable(LAP.mergeuserid)); 
			}
			catch (Exception e) {
				logger.info(e.getMessage());
			}

			LAP.clickonmergerID();
			File file= new File(filePath);
			FileInputStream fis= new FileInputStream(file);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet("MergeUsers");
			int rowsize = sheet.getLastRowNum();
			int noofcells=sheet.getRow(0).getPhysicalNumberOfCells();
			int itemcounter = 1;

			for(int rowcounter=1;rowcounter<=rowsize;rowcounter++ ) {
				WebElement idresltframe = null;
				WebElement noofpages=null;
				WebElement mergeuserfrom=null;
				WebElement mergeuserto=null;
				WebElement elementfound=null;
				boolean statusflag = false;
				String mergeuserfromtext="";
				String mergeusertotext="";
				String elementfoundtext="";


				String MergeFromUser= getCellData(filePath,sheetname, "Merge From User", rowcounter);
				String MergeToUser= getCellData(filePath,sheetname, "Merge To User", rowcounter);
				String UserId= MergeFromUser+","+MergeToUser;
				int size=0;

				try {
					wait.until(ExpectedConditions.elementToBeClickable(LAP.useridselect));
				}
				catch (Exception e) {
					logger.info(e.getMessage());
				}
				Selecttheoption( LAP.useridselect);

				Thread.sleep(2000);
				LAP.mergeuserid.click();
				Thread.sleep(1000);
				LAP.mergeuserid.sendKeys(UserId);
				Thread.sleep(3000);
				LAP.Searchbutton.click();
				try {
					idresltframe=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@title='Search Results']")));
				}
				catch (Exception e) {
					logger.info(e.getMessage());
				}
				driver.switchTo().frame(idresltframe);
				
				
				try {
					
					elementfound = driver.findElement(By.xpath("//span[text()='There are no entities found.']"));
					 elementfoundtext = elementfound.getText();
					 				}
				catch (Exception e) {
					logger.info("No enteties element found");
					elementfoundtext="null";
				}
				 List<WebElement> noofeles = driver.findElements(By.xpath("(//table[contains(@class,'SearchResultsTable')]//child::tbody)[1]/tr"));
				 size= noofeles.size();

				if(elementfoundtext.equalsIgnoreCase("null")&&size>1) {
					Thread.sleep(5000);								
					driver.switchTo().defaultContent();
					WebElement parentframeforallitemid = driver.findElement(By.xpath("//iframe[contains(@name,'iframe')][@class='iframeLoader plateauIFrame']"));
					driver.switchTo().frame(parentframeforallitemid);

					try {
						idresltframe=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@title='Search Results']")));
					}
					catch (Exception e) {
						logger.info(e.getMessage());
					}
					driver.switchTo().frame(idresltframe);
					List<WebElement> noofrows = driver.findElements(By.xpath("(//table[contains(@class,'SearchResultsTable')]//child::tbody)[1]/tr"));
					
					for(int usercounter=3;usercounter<=noofrows.size();usercounter++) {

						//String headertext = driver.findElement(By.xpath("(//table[contains(@class,'SearchResultsTable')]//child::tbody)[1]/tr[2]/th[4]/span/label")).getText();
						try {
							mergeuserfrom = driver.findElement(By.xpath("(//table[contains(@class,'SearchResultsTable')]//child::tbody)[1]/tr["+usercounter+"]/td[1]/span"));

						}
						catch (Exception e) {
							logger.info("element not found at index"+usercounter);
						}
						try {
							mergeuserfromtext = mergeuserfrom.getText();
						}
						catch (Exception e) {
							logger.info("text is blank for element at index"+usercounter);
						}
						try {
							mergeuserto = driver.findElement(By.xpath("(//table[contains(@class,'SearchResultsTable')]//child::tbody)[1]/tr["+(usercounter+1)+"]/td[1]/span"));
							mergeusertotext=mergeuserto.getText();
						}
						catch (Exception e) {
							logger.info("Mergeto usertext not found at index"+usercounter);
						}

						logger.info(mergeuserfromtext.equalsIgnoreCase(MergeFromUser));
						if(mergeuserfromtext.equalsIgnoreCase(MergeFromUser)&&mergeusertotext.equalsIgnoreCase(MergeToUser)&&!mergeuserfromtext.equalsIgnoreCase(mergeusertotext)){

							driver.findElement(By.xpath("(//table[contains(@class,'SearchResultsTable')]//child::tbody)[1]/tr["+usercounter+"]/td[4]/input[1]")).click();
							Thread.sleep(2000);
							driver.findElement(By.xpath("(//table[contains(@class,'SearchResultsTable')]//child::tbody)[1]/tr["+(usercounter+1)+"]/td[5]/input")).click();
							Thread.sleep(3000);
							driver.findElement(By.xpath("(//button[text()='Merge'])[2]")).click();
							Thread.sleep(2000);
							wait.until(ExpectedConditions.alertIsPresent()).accept();
							Thread.sleep(5000);
							statusflag =true;
							String message = "";
							addStatusToExcel(rowcounter, message, statusflag, noofcells);
							driver.switchTo().defaultContent();

							break;

						}
						else if (mergeusertotext.equalsIgnoreCase(MergeFromUser)&&mergeuserfromtext.equalsIgnoreCase(MergeToUser)&&!mergeuserfromtext.equalsIgnoreCase(mergeusertotext)) {
							logger.info(mergeuserfromtext.equalsIgnoreCase(MergeToUser));
						driver.findElement(By.xpath("(//table[contains(@class,'SearchResultsTable')]//child::tbody)[1]/tr["+(usercounter+1)+"]/td[4]/input[1]")).click();
							Thread.sleep(2000);
							driver.findElement(By.xpath("(//table[contains(@class,'SearchResultsTable')]//child::tbody)[1]/tr["+usercounter+"]/td[5]/input")).click();
							Thread.sleep(3000);
							driver.findElement(By.xpath("(//button[text()='Merge'])[2]")).click();
							Thread.sleep(2000);
							wait.until(ExpectedConditions.alertIsPresent()).accept();
							Thread.sleep(5000);
							statusflag =true;
							String message = "";
							addStatusToExcel(rowcounter, message, statusflag, noofcells);
							driver.switchTo().defaultContent();
							break;

							
						}
						else {
							statusflag=false;
							String message="Record not found in the System";
							addStatusToExcel( rowcounter, message,statusflag,noofcells);
							
							
						}



					}
					
				}
				else {
					logger.info("No datafound with this input file");
					statusflag=false;
					
					String message="Record not found in the System";
					addStatusToExcel( rowcounter, message,statusflag,noofcells);
				}
				FileOutputStream fos= new FileOutputStream(file);
				workbook.write(fos);
				if(rowcounter==rowsize) {
					fos.close();
					workbook.close();
				}
				if(rowcounter==rowsize) {
					break;
					
				}
if(rowcounter>=1&&statusflag) {
					
					try {
						wait.until(ExpectedConditions.elementToBeClickable(LAP.mergeUser)); 
					}
					catch (Exception e) {
						logger.info(e.getStackTrace());
					}
					LAP.clickonMergeUser();
					try {
						wait.until(ExpectedConditions.elementToBeClickable(LAP.manageuseriframe)); 
						moveToElement(driver, LAP.manageuseriframe);
					}
					catch (Exception e) {
						//logger.info(e.getMessage());
					}
					Thread.sleep(3000);
					LAP.switchtomergeuseridframe();
					

				}
				else {
					driver.switchTo().defaultContent();
					String attrvalue = LAP.mergeUser.getAttribute("aria-selected");
					
					if(attrvalue.equalsIgnoreCase("true")) {
						LAP.clickonMergeUser();
						Thread.sleep(2000);
					}
					
					try {
						wait.until(ExpectedConditions.elementToBeClickable(LAP.manageuseriframe)); 
						moveToElement(driver, LAP.manageuseriframe);
						
					}
					catch (Exception e) {
					//	logger.info(e.getMessage());
					}
					LAP.switchtomergeuseridframe();
					
				}

				
			}
			Timestamp endTime = new Timestamp(System.currentTimeMillis());
	        System.out.println("End Time of Execution : " +endTime);

			logger.info("Execution is Completed");
			Thread.sleep(2000);
			driver.close();
			logger.info("driver is closed");
			
		}catch (Exception e) {

			logger.info(e.getMessage());
			result=false;
		}
		
		return result;

	}

	private static void addStatusToExcel(int rowcounter, String message, boolean statusflag, int noofcells) {

		try {
			if(statusflag==true) {
			for(int columncounter=0;columncounter<=noofcells;columncounter++) {
				  XSSFCellStyle styleheaderpass = workbook.createCellStyle();
				  styleheaderpass.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
				  styleheaderpass.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				  
				String  colname = sheet.getRow(0).getCell(columncounter).toString();
				if(colname.equals("Status")) {					
					
					Cell statuscell = sheet.getRow(rowcounter).createCell(columncounter);
					statuscell.setCellValue("Pass");
					statuscell.setCellStyle(styleheaderpass);
					Cell statuscommentcell = sheet.getRow(rowcounter).createCell(columncounter+1);
					statuscommentcell.setCellValue("");
					statuscommentcell.setCellStyle(styleheaderpass);
					
					break;
					
				}
			}
			}
			else {
				XSSFCellStyle styleheaderfail = workbook.createCellStyle();
				styleheaderfail.setFillForegroundColor(IndexedColors.RED.getIndex());
				styleheaderfail.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				for(int columncounter=0;columncounter<=noofcells;columncounter++) {
					String colname = sheet.getRow(0).getCell(columncounter).toString();
					if(colname.equals("Status")) {
						Cell statuscell = sheet.getRow(rowcounter).createCell(columncounter);
						statuscell.setCellValue("Fail");
						statuscell.setCellStyle(styleheaderfail);
						Cell statuscommentcell = sheet.getRow(rowcounter).createCell(columncounter+1);
						statuscommentcell.setCellValue(message);
						statuscommentcell.setCellStyle(styleheaderfail);
						break;
						
					}
				}
				
			}
		} catch (Exception e) {
			logger.info("please close the excel file");
		}
		
		
	
	}

	private static void Selecttheoption(WebElement ele) {
		Select sele= new Select(ele);
		sele.selectByVisibleText("Any");
		}

	public static void executeJavaScript(String scriptToExecute,WebElement element,WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(scriptToExecute,element);
	}
	public static String getCellData(String filepath,String sheetName,String colName,int rowNum){
		Cell headercell = null;
		Row headerrow;

		try{
			File file= new File(filepath);
			FileInputStream fis= new FileInputStream(file);
			XSSFWorkbook Workbook = new XSSFWorkbook(fis);
			int col_Num=0;		
			XSSFSheet inputsheet = Workbook.getSheet(sheetName);
			Row inputrow = inputsheet.getRow(0);


			for(int i=0;i<inputrow.getLastCellNum();i++){
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				String inputvalue = inputrow.getCell(i).getStringCellValue().trim();
				String value = colName.trim();

				if(inputrow.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
					col_Num=i;

					break;
				}
			}
			headerrow=inputsheet.getRow(rowNum);
			try {
				headercell = headerrow.getCell(col_Num);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			if(headercell==null) {
				return "";
			}
			/*if(col_Num==-1) {
			return "";
		}
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";*/

			//	Cell cell = inputrow.getCell(col_Num);

			/*if(cell==null) {
			return "";
		}*/
			//System.out.println(cell.getCellType());
			XSSFCell cell = null;
			Cell celldata = null;
			
			if(headercell.getCellType()==celldata.getCellType().STRING) {
				return headercell.getStringCellValue();
			}
			else if(headercell.getCellType()==celldata.getCellType().NUMERIC || headercell.getCellType()==celldata.getCellType().FORMULA ){

				String cellText  = String.valueOf(headercell.getNumericCellValue());
				if (DateUtil.isCellDateFormatted(headercell)) {
					// format in form of M/D/YY
					double d = headercell.getNumericCellValue();

					Calendar cal =Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText =(String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +cal.get(Calendar.MONTH)+1 + "/" + 	cellText;

					//System.out.println(cellText);
					return cellText;
				}



				
			}else if(headercell.getCellType()==celldata.getCellType().BLANK) {
				return ""; 
			}
			else {
				return String.valueOf(headercell.getBooleanCellValue());
			}

		}
		catch(Exception e){

			e.printStackTrace();
			return "row "+rowNum+" or column "+colName +" does not exist in xls";
		}
		return colName;
	}

	public static void moveToElement(WebDriver driver,WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].scrollIntoView(true);", element);
		jse.executeScript("arguments[0].scrollIntoView();", element);
	}
	public static void moveup(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-1000)");
	}
	public static boolean compareDateandTime(String Date1,String Date2) throws ParseException {
		boolean flag=false; 
		  if(Date1.compareTo(Date2) > 0) {
	         System.out.println("Date 1 occurs after Date 2");
	      } else if(Date1.compareTo(Date2) < 0) {
	         System.out.println("Date 1 occurs before Date 2");
	      } else if(Date1.compareTo(Date2) == 0) {
	         System.out.println("Both dates are equal");
	         flag=true;
	         
	      }
		return flag;
	}
	public static   Wait<WebDriver> waitithpolling( WebDriver driver,long duration) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(duration, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		return wait;
		
	}

}
