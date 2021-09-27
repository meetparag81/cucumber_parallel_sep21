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
import org.apache.poi.xssf.usermodel.XSSFCell;



public class Custom_Approval_Roles_driver extends CorehelperClass {/*

	WebDriver driver;
	public Custom_Approval_Roles_driver(WebDriver driver) {
		
		super();
		this.driver=driver;
		
	}
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
		executeScript("C:\\WorkingfolderPB\\LMSDemo\\Template\\Custom Approval Roles_template.xlsx","https://performancemanager8.successfactors.com/login?company=BPOCUSTOM10#/login","C:\\WorkingfolderPB\\LMSdeletebulktemplate\\Learning History Template060421.xlsx","CustomApproval", "CustomApproval", "BPOCUSTOM10", "bparag", "welcome234", "No", "Yes");

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
			
			WebDriverWait wait = new WebDriverWait(driver, 60);
			Actions act = new Actions(driver);
			Thread.sleep(5000);
			try {

				//WebElement sapPopup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sap-ui-blocklayer-popup']")));
				//waitForClickable(sapPopup);
				WebElement sapPopup = null;
				try {
					sapPopup = driver.findElement(By.xpath("//*[@id='sap-ui-blocklayer-popup']"));
					while(sapPopup==null) {
						Thread.sleep(2000);
						try {
						sapPopup = driver.findElement(By.xpath("//*[@id='sap-ui-blocklayer-popup']"));
						}
						catch (Exception e1) {
							// TODO: handle exception
						}
					}
					
				}
				catch (Exception e) {
					
					
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
			Thread.sleep(1000);
			LAP.clickonpeople();			 
			try {
				wait.until(ExpectedConditions.elementToBeClickable(LAP.users)); 
			}
			catch (Exception e) {
				logger.info(e.getStackTrace());
			}
			Thread.sleep(1000);
			LAP.clickonUsers();
			Thread.sleep(3000);
			try {
				wait.until(ExpectedConditions.elementToBeClickable(LAP.usersiframe)); 
			}
			catch (Exception e) {
				logger.info(e.getMessage());
			}
			Thread.sleep(1000);
			LAP.switchtousersiframe();
			
			try {
				wait.until(ExpectedConditions.elementToBeClickable(LAP.userside)); 
			}
			catch (Exception e) {
				logger.info(e.getMessage());
			}
			Thread.sleep(1000);
			LAP.clickonUsersID();
			File file= new File(filePath);
			FileInputStream fis= new FileInputStream(file);
			workbook=new XSSFWorkbook(fis);
			sheet=workbook.getSheet("CustomApproval");
			int rowsize = sheet.getLastRowNum();
			int noofcells=sheet.getRow(0).getPhysicalNumberOfCells();
			int itemcounter = 1;

			for(int rowcounter=1;rowcounter<=rowsize;rowcounter++ ) {
				WebElement idresltframe = null;
				WebElement noofpages=null;
				WebElement mergeuserfrom=null;
				WebElement mergeuserto=null;
				WebElement useridlink=null;
				WebElement more=null;
				WebElement Expandheader=null;
				WebElement  addormore=null;
				WebElement addormore1=null;
				WebElement securitypageiframe=null;
				WebElement securitydomainsearch=null;
				WebElement approvalroleiframe=null;
				WebElement approveformframe=null;
				WebElement approverolesiframe=null;
				WebElement iframeapproveidpage=null;
				WebElement iframeremoveapproveid=null;
				WebElement securitypageframe=null;
				WebElement securitypageframe1=null;
				WebElement useridiframe=null;
				WebElement returnToApprove=null;
				WebElement Applychanges=null;
				WebElement Applychangesremove=null;
				boolean statusflag = false;
				String mergeuserfromtext="";
				String mergeusertotext="";
				String elementfoundtext="";
				String message="";
				String includesecuritydomain="";
				String RoleID="";
				String UserId="";


				try {
					UserId= getCellData(filePath,sheetname, "User ID", rowcounter);	
				}
				catch (Exception e) {
					UserId="null";
				}
				boolean flaguserid = UserId.isEmpty();
				
				int size=0;
				Thread.sleep(1000);
				LAP.mergeuserid.sendKeys(UserId);
				Thread.sleep(3000);
				LAP.Searchbutton.click();
				//If userid is empty
				if(flaguserid==false) {
				try {
					idresltframe=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@title='Search Results']")));
				}
				catch (Exception e) {
					logger.info(e.getMessage());
				}
				Thread.sleep(1000);
				driver.switchTo().frame(idresltframe);
				
				
				try {
					
					useridlink=	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//a[@id='GotoSnapshot']"))));
					}
				catch (Exception e) {
					
				}
				Thread.sleep(1000);
				useridlink.click();
				Thread.sleep(3000);
				driver.switchTo().defaultContent();
				Thread.sleep(1000);
				try {
					 Expandheader = wait.until(ExpectedConditions.elementToBeClickable(LAP.ExpandHeader));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				
				Thread.sleep(1000);				
				boolean Haderflag = LAP.ExpandHeader.getAttribute("class").contains("sapUiHidden");
				Thread.sleep(1000);
				try {
					Expandheader.click();
				}
				catch (Exception e) {
					Expandheader=driver.findElement(By.xpath("//span[text()='Status:']//following::span[contains(@class,'sapUiIcon')][1]"));
					Expandheader.click();
				}
				
				
				
				try {
			 more = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='More']")));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				Thread.sleep(1000);
				try {
				more.click();
				}
				catch (Exception e) {
					
				}
				Thread.sleep(3000);
				LAP.ApprovalRoles.click();
				Thread.sleep(1000);
				}
				String Action = getCellData(filePath,sheetname, "Action", rowcounter);
				//Add approval roles
				if(Action.equalsIgnoreCase("Add")&&!UserId.isEmpty()) {
					logger.info("Add approve id started");
					try {
						approverolesiframe = wait.until(ExpectedConditions.elementToBeClickable(LAP.approverolesiframe));

					}
					catch (Exception e) {
						// TODO: handle exception
					}
					driver.switchTo().frame(approverolesiframe);
					Thread.sleep(2000);
					try {
						addormore = wait.until(ExpectedConditions.elementToBeClickable(LAP.addoneormore));
					}
					catch (Exception e) {

					}
					Thread.sleep(1000);
					addormore.click();
					Thread.sleep(3000);
					driver.switchTo().defaultContent();
					try {
						approveformframe=wait.until(ExpectedConditions.elementToBeClickable(LAP.approveformframe));
					}
					catch (Exception e) {
						
					}
					Thread.sleep(1000);
					driver.switchTo().frame(approveformframe);
					 RoleID = getCellData(filePath,sheetname, "RoleID", rowcounter);
					 try {
					LAP.roleid.click();
					 }
					 catch (Exception e) {
						// TODO: handle exception
					}
					LAP.roleid.sendKeys(RoleID);
					Thread.sleep(2000);
					LAP.roleidSearchbutton.click();
					driver.switchTo().defaultContent();
					Thread.sleep(2000);
					try {
						iframeapproveidpage=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@class='plateauIFrame sfUiEntityEditTabIframe']")));
					}
					catch (Exception e) {
						
					}
					driver.switchTo().frame(iframeapproveidpage);

					List<WebElement> approveidrows = driver.findElements(By.xpath("//table[@class='ResultsTable']//tr"));
					//Add the Approveid
					if(approveidrows.size()>=1) {


						for(int counter=3;counter<=approveidrows.size();counter++) {
							String approveidrowtext = driver.findElement(By.xpath("//table[@class='ResultsTable']//tr["+counter+"]/td[1]")).getText();
							if(approveidrowtext.trim().toString().equalsIgnoreCase(RoleID.trim().toString())) {
								WebElement Addcheckbox = driver.findElement(By.xpath("//table[@class='ResultsTable']//tr["+counter+"]/td[3]/div/input[1]"));
								Addcheckbox.click();
								Thread.sleep(2000);
								driver.findElement(By.xpath("(//input[@name='submitbutton'])[2]")).click();	
								Thread.sleep(5000);
								break;

							}

						}
						driver.switchTo().defaultContent();
						try {
							securitypageframe=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@class='plateauIFrame sfUiEntityEditTabIframe']")));
						}
						catch (Exception e) {

						}
						//add security domain
						driver.switchTo().frame(securitypageframe);					
						List<WebElement> securitydomains = driver.findElements(By.xpath("//table[@class='ResultsTable']//tr"));
						if(securitydomains.size()>=1) {
							for(int idcounter=2;idcounter<=securitydomains.size();idcounter++) {
								String approvalidtext = driver.findElement(By.xpath("//table[@class='ResultsTable']//tr["+idcounter+"]/td[1]/span[1]")).getText();
								logger.info("Approverid is "+ approvalidtext.trim().toString().equalsIgnoreCase(RoleID.trim().toString()));
								if(approvalidtext.trim().toString().equalsIgnoreCase(RoleID.trim().toString())){
									Thread.sleep(3000);									
									WebElement securityid = driver.findElement(By.xpath("//table[@class='ResultsTable']//tr["+idcounter+"]/td[1]/span[1]"));
									moveToElement(driver, securityid);
									Thread.sleep(3000);
									driver.findElement(By.xpath("//table[@class='ResultsTable']//tr["+idcounter+"]/td[3]/a")).click();
									driver.switchTo().defaultContent();
									try {
										securitypageframe1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@class='plateauIFrame sfUiEntityEditTabIframe']")));
									}
									catch (Exception e) {

									}
									Thread.sleep(3000);
									driver.switchTo().frame(securitypageframe1);
									try {
										addormore1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='add one or more from list'][1]")));
									}
									catch (Exception e) {

									}
									Thread.sleep(2000);
									addormore1.click();
									Thread.sleep(5000);
									driver.switchTo().defaultContent();
									
									try {
										securitypageiframe=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@class='plateauIFrame sfUiEntityEditTabIframe']")));
									}
									catch (Exception e) {
										// TODO: handle exception
									}
									driver.switchTo().frame(securitypageiframe);
									Thread.sleep(1000);

									try {
										securitydomainsearch=wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//input[@id='FULL_TEXT_SEARCH']"))));
									}
									catch (Exception e) {
										// TODO: handle exception
									}
									Thread.sleep(2000);
									securitydomainsearch.click();
									Thread.sleep(1000);
									String SecurityID = getCellData(filePath,sheetname, "Control Security Domains/Control Organization", rowcounter);
									SecurityID=SecurityID.trim();
									securitydomainsearch.sendKeys(SecurityID);
									Thread.sleep(3000);
									List<WebElement> searchbuttons = driver.findElements(By.xpath("//input[@id='search'][@class='Button']"));
									for(WebElement we:searchbuttons) {
										if(!(we==null)) {
											Thread.sleep(3000);
											we.click();
											Thread.sleep(5000);
											break;
										}
									}
									//driver.switchTo().frame(arg0)
									Thread.sleep(2000);
									//driver.findElement(By.xpath("//input[@name='bottom_applyChanges']")).click();
									driver.switchTo().defaultContent();
									try {
										approvalroleiframe=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@class='plateauIFrame sfUiEntityEditTabIframe']")));
									}
									catch (Exception e) {

									}
									Thread.sleep(1000);
									driver.switchTo().frame(approvalroleiframe);
									List<WebElement> securitydomainelets = driver.findElements(By.xpath("//table[@class='ResultsTable']//tr"));
									boolean securitydomainflag = false;
									if(securitydomainelets.size()>=1) {
										for(int securityidcounter=3;securityidcounter<=securitydomainelets.size();securityidcounter++) {
											if(securitydomainflag==false) {
												try {
													includesecuritydomain = getCellData(filePath,sheetname, "Include Security Subdomain", rowcounter);
												}
												catch (Exception e) {

												}
												if(includesecuritydomain.equalsIgnoreCase("Y")) {
													String securityidtext=driver.findElement(By.xpath("//table[@class='ResultsTable']//tr["+securityidcounter+"]/td[1]/span")).getText();
													logger.info("Securityid is "+ securityidtext.trim().toString().equalsIgnoreCase(SecurityID.trim().toString()));
													if(securityidtext.trim().toString().equalsIgnoreCase(SecurityID.trim().toString())) {
														Thread.sleep(2000);

														WebElement securitydomainid = driver.findElement(By.xpath("//table[@class='ResultsTable']//tr["+securityidcounter+"]/td[1]/span"));
														Thread.sleep(2000);
														moveToElement(driver, securitydomainid);
														Thread.sleep(1000);
														driver.findElement(By.xpath("//table[@class='ResultsTable']//tr["+securityidcounter+"]/td[3]/div/input[1]")).click();
														Thread.sleep(1000);
														driver.findElement(By.xpath("//table[@class='ResultsTable']//tr["+securityidcounter+"]/td[4]/div/input[1]")).click();
														Thread.sleep(2000);
														driver.findElement(By.xpath("(//input[@name='submitbutton'])[2]")).click();
														Thread.sleep(3000);
														try {
															returnToApprove = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='returnToApproval']")));
														}
														catch (Exception e) {

														}
														Thread.sleep(2000);
														moveToElement(driver, returnToApprove);
														Thread.sleep(3000);
														returnToApprove.click();
														Thread.sleep(5000);
														try {
															Applychanges=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='bottom_applyChanges'][1]")));
														}
														catch (Exception e) {

														}
														Thread.sleep(2000);
														Applychanges.click();
														Thread.sleep(3000);
														statusflag=true;
														message="";
														addStatusToExcel( rowcounter,message, statusflag, noofcells);
														break;
													}

												}
												else if (includesecuritydomain.isEmpty()||includesecuritydomain.equalsIgnoreCase("N")) {
													String securityidtext=driver.findElement(By.xpath("//table[@class='ResultsTable']//tr["+securityidcounter+"]/td[1]/span")).getText();
													logger.info("The textfromsystem is "+ securityidtext.trim());
													logger.info("The textfromexcel is "+ SecurityID.toString().trim());													
													logger.info("Securityid is "+ securityidtext.trim().equalsIgnoreCase(SecurityID.trim()));
													if(securityidtext.trim().equalsIgnoreCase(SecurityID)) {	
												
													driver.findElement(By.xpath("//table[@class='ResultsTable']//tr["+securityidcounter+"]/td[4]/div/input[1]")).click();
													Thread.sleep(1000);
													driver.findElement(By.xpath("(//input[@name='submitbutton'])[2]")).click();	
													Thread.sleep(3000);
													try {
														returnToApprove = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='returnToApproval']")));
													}
													catch (Exception e) {

													}
													Thread.sleep(2000);
													moveToElement(driver, returnToApprove);
													Thread.sleep(3000);
													returnToApprove.click();
													Thread.sleep(5000);
													try {
														Applychanges=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='bottom_applyChanges'][1]")));
													}
													catch (Exception e) {

													}
													Thread.sleep(2000);
													Applychanges.click();
													Thread.sleep(3000);
													statusflag=true;
													message="";
													addStatusToExcel( rowcounter,message, statusflag, noofcells);
													break;

													
													}
													

												} 
												//if includeInclude Security Subdomain is incorrect
												else {
													message = "Incorrect Record is Passed";
													statusflag=false;
													addStatusToExcel( rowcounter,message, statusflag, noofcells);
													securitydomainflag=true;
													break;
												}

											}
										}
									}
									//if securrity id  is not correct
									else {
										statusflag=false;
										message = "Record is not available in System";
										addStatusToExcel( rowcounter,message, statusflag, noofcells);
										break;

									}

								}

							}

						}
						else {
							message = "Security domain is not Availabled";
							addStatusToExcel( rowcounter,message, statusflag, noofcells);
							break;
							
						}

						//ifapproveid is incorrect in Add scenario
					}else {
						statusflag=false;
						 message = "Record is not available in System";
						addStatusToExcel( rowcounter,message, statusflag, noofcells);

					}

				}
				//remove Approval roles
				else if (Action.equalsIgnoreCase("Remove")&&!UserId.isEmpty()) {
					logger.info("remove approveid started");
				
					try {
						approverolesiframe = wait.until(ExpectedConditions.elementToBeClickable(LAP.approverolesiframe));

					}
					catch (Exception e) {
						// TODO: handle exception
					}
					driver.switchTo().frame(approverolesiframe);
					Thread.sleep(1000);
					try {
						addormore = wait.until(ExpectedConditions.elementToBeClickable(LAP.addoneormore));
					}
					catch (Exception e) {

					}
					Thread.sleep(1000);
					addormore.click();
					Thread.sleep(1000);
					Thread.sleep(1000);
					driver.switchTo().defaultContent();
					try {
						approveformframe=wait.until(ExpectedConditions.elementToBeClickable(LAP.approveformframe));
					}
					catch (Exception e) {
						
					}
					Thread.sleep(1000);
					driver.switchTo().frame(approveformframe);
					
						 RoleID = getCellData(filePath,sheetname, "RoleID", rowcounter);
					
					
					LAP.roleid.click();
					LAP.roleid.sendKeys(RoleID);
					Thread.sleep(2000);
					LAP.roleidSearchbutton.click();
					driver.switchTo().defaultContent();
					Thread.sleep(2000);
					try {
						iframeapproveidpage=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@class='plateauIFrame sfUiEntityEditTabIframe']")));
					}
					catch (Exception e) {
						
					}
					driver.switchTo().frame(iframeapproveidpage);

					List<WebElement> approveidrows = driver.findElements(By.xpath("//table[@class='ResultsTable']//tr"));
					//Add the Approveid
					if(approveidrows.size()>=1) {

						boolean removeroleflag = false;
						for(int counter=3;counter<=approveidrows.size();counter++) {
							if(removeroleflag==false) {

								String approveidrowtext = driver.findElement(By.xpath("(//table[@class='ResultsTable']//tr["+counter+"]/td/span)[1]")).getText();

								if(approveidrowtext.trim().toString().equalsIgnoreCase(RoleID.trim().toString())) {
									WebElement Addcheckbox = driver.findElement(By.xpath("//table[@class='ResultsTable']//tr["+counter+"]/td[3]/div/input[1]"));
									Addcheckbox.click();
									driver.findElement(By.xpath("(//input[@name='submitbutton'])[2]")).click();	
									Thread.sleep(2000);
									driver.switchTo().defaultContent();
									Thread.sleep(2000);
									try {
										iframeremoveapproveid=wait.until((ExpectedConditions.elementToBeClickable(By.xpath("//iframe[@class='plateauIFrame sfUiEntityEditTabIframe']"))));
									}
									catch (Exception e) {

									}
									Thread.sleep(2000);
									driver.switchTo().frame(iframeremoveapproveid);
									List<WebElement> removeidrows = driver.findElements(By.xpath("//table[@class='ResultsTable']/tbody/tr"));
									for(int removecounter=2;removecounter<=removeidrows.size();removecounter++) {
										String removeidtext = driver.findElement(By.xpath("//table[@class='ResultsTable']//tr["+removecounter+"]/td[1]/span")).getText();
										logger.info("organization or security id is"+ approveidrowtext.trim().toString().equalsIgnoreCase(RoleID.trim().toString()));
										if(approveidrowtext.trim().toString().equalsIgnoreCase(RoleID.trim().toString())) {
											WebElement removecheckbox = driver.findElement(By.xpath("//table[@class='ResultsTable']//tr["+removecounter+"]/td[4]/input[1]"));
											Thread.sleep(1000);
											moveToElement(driver, removecheckbox);
											Thread.sleep(2000);
											removecheckbox.click();
											Thread.sleep(2000);
											try {
												Applychangesremove=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='bottom_applyChanges'][1]")));
											}
											catch (Exception e) {

											}
											Thread.sleep(2000);
											Applychangesremove.click();
											Thread.sleep(3000);

											statusflag=true;
											message = "";
											addStatusToExcel( rowcounter,message, statusflag, noofcells);
											removeroleflag=true;
											break;
										}

									}




								}
							}
						}
						//ifapproveid is incorrect in remove scenario
					}else {
						statusflag=false;
						 message = "Record is not available in System";
						addStatusToExcel( rowcounter,message, statusflag, noofcells);
					}

					
				}
				else if (UserId.isEmpty()||UserId.equals("null")) {
				statusflag=false;
				 message = "UserId is Empty";
				addStatusToExcel( rowcounter,message, statusflag, noofcells);
		
					
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
	driver.switchTo().defaultContent();
					
					try {
						wait.until(ExpectedConditions.elementToBeClickable(LAP.users)); 
					}
					catch (Exception e) {
						logger.info(e.getMessage());
					}
					Thread.sleep(3000);
					LAP.clickonUsers();
					Thread.sleep(2000);
					try {
						wait.until(ExpectedConditions.elementToBeClickable(LAP.usersiframe)); 
						moveToElement(driver, LAP.usersiframe);
					}
					catch (Exception e) {
						//logger.info(e.getMessage());
					}
					Thread.sleep(3000);
					LAP.switchtousersiframe();
					

				}
				else {
					driver.switchTo().defaultContent();
					String attrvalue = LAP.users.getAttribute("aria-selected");
					
					if(attrvalue.equalsIgnoreCase("true")) {
						Thread.sleep(3000);
						LAP.clickonUsers();
						Thread.sleep(5000);
					}
					
					try {
						useridiframe=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//iframe[contains(@name,'iframe')][@class='plateauIFrame ']"))); 
						moveToElement(driver, useridiframe);
						
					}
					catch (Exception e) {
					//	logger.info(e.getMessage());
					}
					Thread.sleep(3000);
					driver.switchTo().frame(useridiframe);
					
				}

				
			}
			Timestamp endTime = new Timestamp(System.currentTimeMillis());
	        logger.info("End Time of Execution : " +endTime);

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
				 XSSFCellStyle styleheaderpass = workbook.createCellStyle();
				  styleheaderpass.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
				  styleheaderpass.setFillPattern(FillPatternType.SOLID_FOREGROUND);				
			for(int columncounter=0;columncounter<=noofcells;columncounter++) {
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
				headercell = (XSSFCell) headerrow.getCell(col_Num, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			if(headercell==null) {
				return "";
			}
			if(col_Num==-1) {
			return "";
		}
		sheet = workbook.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		if(row==null)
			return "";

			//	Cell cell = inputrow.getCell(col_Num);

			if(cell==null) {
			return "";
		}
			//System.out.println(cell.getCellType());
			
			if(headercell.getCellType()==Cell.CELL_TYPE_STRING) {
				return headercell.getStringCellValue().trim();
			}
			else if(headercell.getCellType()==Cell.CELL_TYPE_NUMERIC || headercell.getCellType()==Cell.CELL_TYPE_FORMULA ){

				String cellText  = String.valueOf(headercell.getNumericCellValue());
				if (DateUtil.isCellDateFormatted(headercell)) {
					// format in form of M/D/YY
					double d = headercell.getNumericCellValue();

					Calendar cal =Calendar.getInstance();
					cal.setTime(DateUtil.getJavaDate(d));
					cellText =(String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +cal.get(Calendar.MONTH)+1 + "/" + 	cellText;

					//System.out.println(cellText);

				}



				return cellText.trim();
			}else if(headercell.getCellType()==Cell.CELL_TYPE_BLANK) {
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

*/}
