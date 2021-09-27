package DataManupulation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.CharMatcher;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

public class LMS_deletecourse_driver extends CorehelperClass {


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
	static Logger logger = Logger.getLogger(LMS_deletecourse_driver.class.getName());
	private static WebElement Headertext;
	private static WebElement permissionele;
	private static String xpath;
	private static LearningAdminPage LAP;
	public static void main(String[] args)throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
		// TODO Auto-generated method stub
		executeScript("C:\\WorkingfolderPB\\LMSDemo\\Template\\BulkDeleteTemplate.xlsx","https://performancemanager8.successfactors.com/login?company=BPOCUSTOM10#/login","C:\\WorkingfolderPB\\LMS_Mergeusers\\Template\\MergeUser_Template.xlsx","LH Template", "LH Template", "BPOCUSTOM10", "bparag", "welcome234", "No", "Yes");

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
				try {
				executeJavaScript("arguments[0].click();",sapPopup, driver);
				}
				catch (Exception e) {
				
				}
				wait(1000);
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
				WebElement userlearning = waitithpolling(driver, 150).until(ExpectedConditions.elementToBeClickable(LAP.manageUserLearning)); 
				while(userlearning==null) {
					Thread.sleep(100);
				}

			}
			catch (Exception e) {
				logger.info("element is not seen with in defined time");
				//driver.findElement(By.xpath(xpathExpression))

			}
			LAP.clickonManageuserLearning();			 
			try {
				wait.until(ExpectedConditions.elementToBeClickable(LAP.editLearningHistory)); 
			}
			catch (Exception e) {
				logger.info(e.getStackTrace());
			}
			LAP.clickonEditLearningHistory();

			try {
				wait.until(ExpectedConditions.elementToBeClickable(LAP.useridiframe)); 
			}
			catch (Exception e) {
				logger.info(e.getStackTrace());
			}
			LAP.switchtouseridframe();
			try {
				wait.until(ExpectedConditions.elementToBeClickable(LAP.UserId)); 
			}
			catch (Exception e) {
				logger.info(e.getMessage());
			}

			LAP.clickontheUserID();
			File file= new File(filePath);
			FileInputStream fis= new FileInputStream(file);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet("LH Template");
			int rowsize = sheet.getLastRowNum();
			int noofcells=sheet.getRow(0).getPhysicalNumberOfCells();
			int itemcounter = 1;

			for(int rowcounter=1;rowcounter<=rowsize;rowcounter++ ) {
				WebElement idresltframe = null;
				WebElement noofpages=null;
				boolean statusflag = true;
				

					String UserId= getCellData(filePath,sheetname, "User ID", rowcounter);
					try {
						wait.until(ExpectedConditions.elementToBeClickable(LAP.UserId));
					}
					catch (Exception e) {
						logger.info(e.getMessage());
					}
					Thread.sleep(2000);
					LAP.UserId.click();
					Thread.sleep(1000);
					LAP.UserId.sendKeys(UserId);
					Thread.sleep(3000);
					LAP.Completeddate.clear();
					Thread.sleep(3000);
					LAP.Searchbutton.click();
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
				
				String Itemidwithtext= getCellData(filePath,sheetname, "Item ID", rowcounter);
				Itemidwithtext=Itemidwithtext.trim();
				driver.switchTo().frame(idresltframe);
				String Itemid = CharMatcher.digit().retainFrom(Itemidwithtext);
				String idxpath = "//b[contains(text(),'"+Itemid +"')]";
				List<WebElement> itemids = driver.findElements(By.xpath(idxpath));
				//List<WebElement> itemids1 = driver.findElements(By.partialLinkText(Itemidwithtext));
				int size=itemids.size();
				
				// multiplecourses with same id
				if(size>1) {
					String date1text="";
					String Time1="";
					int endIndex = 0;
					boolean flagdate = false;
WebElement coursenameele = null;
Date completiondate=null;
String completiondateString ="";

String completiondateorg= getCellData(filePath,sheetname, "Completion Date & Time", rowcounter);
completiondateorg=completiondateorg.trim();

if(completiondateorg.contains("AM")) {
 endIndex=completiondateorg.indexOf("AM");
}
else if (completiondateorg.contains("PM")) {
	 endIndex=completiondateorg.indexOf("PM");
}
String completiondatetext = completiondateorg.substring(0, endIndex);
SimpleDateFormat formatexcelsheet = new SimpleDateFormat("M/dd/yyyy hh:mm");
//if date column is blank in excel
try {
 completiondate = formatexcelsheet.parse(completiondatetext);
}
catch (ParseException e) {
	statusflag=false;
	String message = "Date is blank";
	
	
}
try {
 completiondateString = formatexcelsheet.format(completiondate);
}
catch (Exception e) {
	completiondateString="";
}
					List<WebElement> noofrows = driver.findElements(By.xpath("//th[@class='TableHeaderBackground'][5]//following::tbody[1]/tr"));
					
					for(int rowcount=1;rowcount<=noofrows.size();rowcount++) {
						WebElement courseid = driver.findElement(By.xpath("//th[@class='TableHeaderBackground'][3]//following::tbody[1]/tr["+rowcount+"]//child::b//parent::span"));
						String courseidtext = courseid.getText();
						int indexend = courseidtext.indexOf("(");
						courseidtext = courseidtext.substring(0, indexend);
						courseidtext=courseidtext.trim();
						
						WebElement date1=driver.findElement(By.xpath("(//th[@class='TableHeaderBackground'][5]//following::tbody[1]/tr["+rowcount+"]//child::span[@class='TableBodyText'])[5]"));
						System.out.println(date1.getText().trim());
						String Date1= date1.getText();
						String datewithtimeformat = Date1;
						if(Date1.contains("AM")) {
						 endIndex=Date1.indexOf("AM");
						}
						else if (Date1.contains("PM")) {
							 endIndex=Date1.indexOf("PM");
						} 
						Date1=Date1.substring(0, endIndex);
						SimpleDateFormat format = new SimpleDateFormat("M/dd/yyyy hh:mm");
						//SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.US);
						Date date = format.parse(Date1);
						//format = new SimpleDateFormat("dd/MM/yyyy hh:mm ,a");
						String dateString = format.format(date);
						System.out.println(dateString);
						System.out.println(dateString.compareTo(completiondateString));
						if(datewithtimeformat.contains("AM")&&completiondateorg.contains("AM")&&courseidtext.equalsIgnoreCase(Itemidwithtext)) {
							
								 flagdate = compareDateandTime(dateString, completiondateString);					
						}
						else if (datewithtimeformat.contains("PM")&&completiondateorg.contains("PM")&&courseidtext.equalsIgnoreCase(Itemidwithtext)) {
							
							 flagdate = compareDateandTime(dateString, completiondateString);
						}
						
						if(flagdate&&courseidtext.equalsIgnoreCase(Itemidwithtext)) {
							String message;
							WebElement editbutton = driver.findElement(By.xpath("//th[@class='TableHeaderBackground'][5]//following::tbody[1]/tr["+rowcount+"]//a[@class='auto_edit']"));
							Thread.sleep(3000);
							editbutton.click();
							driver.switchTo().defaultContent();
							WebElement deleteframe = driver.findElement(By.xpath("(//iframe[@class='iframeLoader plateauIFrame'])[2]"));
							driver.switchTo().frame(deleteframe);
							try {
								deletebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='delete_button'])[1]")));
							}
							catch (Exception e) {
								logger.info("delete button is not seen within the time");
							}
							deletebutton.click();
							logger.info("Deleteoperationfor item id" + Itemidwithtext+"is started");
							Thread.sleep(1000);
							Alert alert = wait.until(ExpectedConditions.alertIsPresent());
							alert.accept();
							Thread.sleep(3000);
							driver.switchTo().defaultContent();
							try {
								continueframe=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//iframe[@class='iframeLoader plateauIFrame'])[2]")));
							}
							catch (Exception e) {
								// TODO: handle exception
							}
							driver.switchTo().frame(continueframe);
							Thread.sleep(3000);
							try {
								continuebutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']")));
							}
							catch (Exception e) {
								// TODO: handle exception
							}
							continuebutton.click();
							Thread.sleep(3000);
							driver.switchTo().defaultContent();
							Thread.sleep(2000);
							logger.info("Deleteoperationfor item id" + Itemidwithtext+"is completed");
							statusflag=true;
							//message="";
							//addStatusToExcel(rowcounter, message, statusflag, noofcells);
							break;
						
						}
						else {							
							statusflag=false;
							if(rowcount==noofrows.size()) {
								statusflag=false;
								break;
								
							}
						}
						
						

								
					}
					if(statusflag) {
						try {
							String message = "";
							addStatusToExcel(rowcounter, message, statusflag, noofcells);
							
							
						} catch (Exception e) {
							logger.info("please close the excel file");
						}
						
						
					}
					else {
						String message = "Failed to delete Record";
						try {
							addStatusToExcel(rowcounter, message, statusflag, noofcells);
							
							
							
						} catch (Exception e) {
							logger.info("please close the excel file");
						}
						
					}
				}else if (size==1) {
					int endIndex = 0;
					boolean flagdate = false;
					Date date = null;
					Date completiondate=null;
					String completiondateString ="";
					String completiondateorg= getCellData(filePath,sheetname, "Completion Date & Time", rowcounter);
					completiondateorg=completiondateorg.trim();
					WebElement coursenameele = null;
					WebElement courseno = null;
					if(completiondateorg.contains("AM")) {
						 endIndex=completiondateorg.indexOf("AM");
						}
						else if (completiondateorg.contains("PM")) {
							 endIndex=completiondateorg.indexOf("PM");
						}
						String completiondatetext = completiondateorg.substring(0, endIndex);
						SimpleDateFormat formatexcelsheet = new SimpleDateFormat("M/dd/yyyy hh:mm");
						//if date column is blank/incorrect in excel
						try {
						 completiondate = formatexcelsheet.parse(completiondatetext);
						}
						catch (Exception e) {
							String message = "Date is blank/incorrect";
						}
						try {
							 completiondateString = formatexcelsheet.format(completiondate);
						}
						catch (Exception e) {
							completiondateString="";
						}
						List<WebElement> noofrows = driver.findElements(By.xpath("//th[@class='TableHeaderBackground'][5]//following::tbody[1]/tr"));
						
						for(int rowcount=1;rowcount<=noofrows.size();rowcount++) {
							
							WebElement courseid = driver.findElement(By.xpath("//th[@class='TableHeaderBackground'][3]//following::tbody[1]/tr["+rowcount+"]//child::b//parent::span"));
							String courseidtext = courseid.getText();
							if(courseidtext.contains("(")) {
							int indexend = courseidtext.indexOf("(");
							courseidtext = courseidtext.substring(0, indexend);
							courseidtext=courseidtext.trim();
							}
							WebElement date1=driver.findElement(By.xpath("(//th[@class='TableHeaderBackground'][5]//following::tbody[1]/tr["+rowcount+"]//child::span[@class='TableBodyText'])[5]"));
							System.out.println(date1.getText().trim());
							String Date1= date1.getText();
							String datewithtimeformat = Date1;
							if(Date1.contains("AM")) {
							 endIndex=Date1.indexOf("AM");
							}
							else if (Date1.contains("PM")) {
								 endIndex=Date1.indexOf("PM");
							} 
							 Date1=Date1.substring(0, endIndex);
							SimpleDateFormat format = new SimpleDateFormat("M/dd/yyyy hh:mm");
							//SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.US);
							try {
							 date = format.parse(Date1);
							}
							catch (ParseException e) {
							
							}
							//format = new SimpleDateFormat("dd/MM/yyyy hh:mm ,a");
							String dateString = format.format(date);
							logger.info((dateString));
							logger.info("Date with AM/PM status"+ (datewithtimeformat.contains("AM")));
							logger.info("Date with AM/PM status"+ (completiondateorg.contains("AM")));
							logger.info("Course Id status "+("text from application is "+courseidtext+" and from workbook is "+Itemidwithtext+ "and status is "+( courseidtext.equalsIgnoreCase(Itemidwithtext))));
							logger.info(dateString.compareTo(completiondateString));
							if(datewithtimeformat.contains("AM")&&completiondateorg.contains("AM")&&courseidtext.equalsIgnoreCase(Itemidwithtext)) {
								
									 flagdate = compareDateandTime(dateString, completiondateString);					
							}
							else if (datewithtimeformat.contains("PM")&&completiondateorg.contains("PM")&&courseidtext.equalsIgnoreCase(Itemidwithtext)) {
								
								 flagdate = compareDateandTime(dateString, completiondateString);
							}
							
							if(flagdate&&courseidtext.equalsIgnoreCase(Itemidwithtext)) {
								String message;
								WebElement editbutton = driver.findElement(By.xpath("//th[@class='TableHeaderBackground'][5]//following::tbody[1]/tr["+rowcount+"]//a[@class='auto_edit']"));
								Thread.sleep(3000);
								editbutton.click();
								driver.switchTo().defaultContent();
								WebElement deleteframe = driver.findElement(By.xpath("(//iframe[@class='iframeLoader plateauIFrame'])[2]"));
								driver.switchTo().frame(deleteframe);
								try {
									deletebutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='delete_button'])[1]")));
								}
								catch (Exception e) {
									logger.info("delete button is not seen within the time");
								}
								deletebutton.click();
								logger.info("Deleteoperationfor item id" + Itemid+" is started");
								Thread.sleep(1000);
								Alert alert = wait.until(ExpectedConditions.alertIsPresent());
								alert.accept();
								Thread.sleep(3000);
								driver.switchTo().defaultContent();
								try {
									continueframe=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//iframe[@class='iframeLoader plateauIFrame'])[2]")));
								}
								catch (Exception e) {
									// TODO: handle exception
								}
								driver.switchTo().frame(continueframe);
								Thread.sleep(3000);
								try {
									continuebutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']")));
								}
								catch (Exception e) {
									// TODO: handle exception
								}
								continuebutton.click();
								Thread.sleep(3000);
								driver.switchTo().defaultContent();
								Thread.sleep(2000);
								logger.info("Deleteoperationfor item id" + courseidtext+"is completed");
								statusflag=true;
								//message="";
								//addStatusToExcel(rowcounter, message, statusflag, noofcells);
								break;
							
							
						}
							else {
								statusflag=false;
								if(rowcount==noofrows.size()) {
									statusflag=false;
									break;
									
								}
								
							}
							
							}
						
					
					if(statusflag) {
						try {
							String message = "";
							addStatusToExcel(rowcounter, message, statusflag, noofcells);
							
							
						} catch (Exception e) {
							logger.info("please close the excel file");
						}
						
						
					}
					else if (statusflag==false) {
						Cell stcommentcell = null;
						try {
							String message = "please check Timestamp of an Item Id";
							//String message = "Failed to delete Record";
							addStatusToExcel(rowcounter, message, statusflag, noofcells);
							
							
						} catch (Exception e) {
							logger.info("please close the excel file");
							stcommentcell.setCellValue("excel is opened");
							
						}
						
						
						
					}
				
				} else {
					logger.info("Item id "+Itemid+" is not availabled in the system");
					statusflag=false;
					if(statusflag==false) {
						try {
							
							String message="Record not found in system";
							addStatusToExcel(rowcounter, message, statusflag, noofcells);
							
							
						} catch (Exception e) {
							logger.info("please close the excel file");
						}
						
						
					}
				
					

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
						wait.until(ExpectedConditions.elementToBeClickable(LAP.editLearningHistory)); 
					}
					catch (Exception e) {
						logger.info(e.getStackTrace());
					}
					LAP.clickonEditLearningHistory();
					try {
						wait.until(ExpectedConditions.elementToBeClickable(LAP.useridiframe)); 
						moveToElement(driver, LAP.useridiframe);
					}
					catch (Exception e) {
						//logger.info(e.getMessage());
					}
					LAP.switchtouseridframe();
					

				}
				else {
					driver.switchTo().defaultContent();
					String attrvalue = LAP.editLearningHistory.getAttribute("aria-selected");
					
					if(attrvalue.equalsIgnoreCase("true")) {
						LAP.clickonEditLearningHistory();
					}
					
					try {
						wait.until(ExpectedConditions.elementToBeClickable(LAP.useridiframe)); 
						moveToElement(driver, LAP.useridiframe);
						
					}
					catch (Exception e) {
					//	logger.info(e.getMessage());
					}
					LAP.switchtouseridframe();
					
				}
				
				


			}
			Timestamp endTime = new Timestamp(System.currentTimeMillis());
	        System.out.println("End Time of Execution : " +endTime);

			driver.close();
			logger.info("driver is closed");
			result=true;


		}
		catch (Exception e) {

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
					String colname = sheet.getRow(0).getCell(columncounter).toString();
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

			Cell celldata = null;
			/*if(cell==null) {
			return "";
		}*/
			//System.out.println(cell.getCellType());
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
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
							cal.get(Calendar.MONTH)+1 + "/" + 
							cellText;

					//System.out.println(cellText);

				}



				return cellText;
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
