package com.botsftool.dsg.scripts;
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
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDataValidationConstraint;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.modules.thread.thread;
import org.testng.annotations.ExpectedExceptions;

import com.botsftool.dsg.pages.CareersiteBuilderPage;
import com.botsftool.dsg.pages.HomePage;
import com.botsftool.dsg.pages.LoginPage;
//import com.botsftool.dsg.pages.PermissionRoles;
import com.botsftool.dsg.utilities.CorehelperClass;
import com.botsftool.dsg.utilities.CustomMethods;
import com.botsftool.procauto.UserPermissionRole_MassUpdate;
import com.sun.org.apache.bcel.internal.generic.NEWARRAY;
import com.thoughtworks.selenium.webdriven.commands.AllowNativeXPath;

public class RMKpermissions_driver_withbrand extends CorehelperClass {

	// Global Variables
	static InputStream inpFile;
	static Workbook workbook;
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
	static Logger logger = Logger.getLogger(RMKpermissions_driver_withbrand.class.getName());
	private static WebElement Headertext;
	private static WebElement permissionele;
	private static String xpath;
	public static void main(String[] args)throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
		// TODO Auto-generated method stub
		executeScript("C:\\Users\\parag.borawake\\RESOURCES\\FMS","https://pmsalesdemo8.successfactors.com/login?company=SFPART050734","C:\\Users\\parag.borawake\\git\\sfautotoolcde\\Templates\\Template_RMKPermissions.xlsx","RMKPermissions", "RMKPermissions", "SFPART050734", "sfadmin", "SalesdemoDC8", "No", "Yes");

	}

	public static String executeScript(String filePath, String sURL, String templateFile, String sheetname,String templateSheet, String CompanyID, String userName, String password, String ExecuteinBackground,	String SavetoInstance)throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
		// To Add Variables
		String result = "";
		counterstyle=0;
		WebDriver driver=null;
		boolean testPassed=false;
		String errorMessage="";
		int totalrunrecords=0;
		String RoleName="";
		String OutputFileName="";
		boolean displayed =false;
		boolean enabled =false;
		boolean editable =false;
		String permissionLabel="";
		String permissionvalue="";
		String  PermissionHeader="";
		ArrayList<String>Permissionname= null; 
		int totalPassed=0;
		int totalFailed=0;
		ArrayList<String> value = null;
		boolean outputFileCreated = false;
		boolean status=false;
		boolean radioselected; 
		String Autofocustext="";
		String Status ="";
		String srno="";
		String textvalue="";
		String headertextstatus = "";
		ArrayList<String> PermissionValue=new ArrayList<String>();
		String outputTimeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		FileInputStream fis = new FileInputStream(new File(templateFile));
		//String bandname="EnhancementOfRPA";
		//String countryname="(en_US) English (United States)";
		

		// Code Starts
		try {
			// Initialize template
			testPassed = InitializeTemplate(templateFile, templateSheet);
			//write constants to the excel
			Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
			logger.info("constantdded in excel");
			for(int recordcounter = 1;recordcounter<=lastRow;recordcounter++) {
				String countryname= getCellData(templateFile,sheetname, "CountryName", recordcounter);
				String brandname=getCellData(templateFile,sheetname, "BrandName", recordcounter);

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
				CSB=HomePage.searchCareerSiteBuilder();
				Timestamp sitebuildertime = new Timestamp(System.currentTimeMillis());
				logger.info( "clicked on sitebuilder : " +sitebuildertime);
				WebDriverWait wait = new WebDriverWait(driver, 150);
				Actions act = new Actions(driver);
				Thread.sleep(1000);
				try {
					Pages = wait.until(ExpectedConditions.elementToBeClickable(CSB.Page));
				}
				catch (Exception e) {
					driver.navigate().refresh();
					Pages = driver.findElement(By.xpath("//div[@title='Pages']"));
					wait.until(ExpectedConditions.elementToBeClickable(CSB.Page));
					while(Pages.equals(null)){
						wait(10);
					}
				}
				Timestamp homepage = new Timestamp(System.currentTimeMillis());
				logger.info( "homepage is seen : " +homepage);

				Thread.sleep(3000);
				Pages.click();
				Thread.sleep(5000);
				CSB.Home.click();
				
				try {
					Region = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'"+countryname+"')]//parent::li"))));
				}
				catch (Exception e) {
					Region = driver.findElement(By.xpath("//span[contains(text(),'"+countryname+"')]//parent::li"));
					while(Region.equals(null)){
						wait(10);
					}
				}
				Thread.sleep(3000);
				Region.click();
				logger.info("clicked on Region element");
				Thread.sleep(5000);

				List<WebElement> Noofoptions = driver.findElements(By.xpath("//li[contains(@title,'"+countryname+"')]//following::span"));
				//List<WebElement> PermissionHeaders = driver.findElements(By.xpath("//span[contains(text(),'EnhancementOfRPA')]"));
				for(int optcounter=0;optcounter<Noofoptions.size();optcounter++) {
					xpath="";


					permissionTitle = Noofoptions.get(optcounter).getText();
					if(permissionTitle.equalsIgnoreCase(brandname)) {

						xpath= "//li[contains(@title,'"+countryname+"')]//following::span[text()='"+permissionTitle+"'][1]";
						permissionTitle=driver.findElement(By.xpath(xpath)).getText();
						permissionele = driver.findElement(By.xpath(xpath));
						act.moveToElement(permissionele).click().build().perform();

						//logger.info("clicked on "+permissionTitle+");"
						break;
					}


				}
				//WriteDatatoexcel(sfilePath+ "/" + RoleName + "_" +outputTimeStamp+ ".xlsx","Permission Roles" ,PermissionHeader, PermissionValue,new ArrayList<String>());
				outputFileCreated=false;
				PermissionHeader="";
				PermissionValue=new ArrayList<String>();
				PermissionHeader="HeaderSection";
				PermissionValue.add(permissionTitle);
				//write sectionHeader to the excel
				Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
				String xpathhome = "//li[contains(@title,'"+countryname+"')]//following::span[text()='"+permissionTitle+"'][1]//following::li[@title='Home'][1]";
				WebElement Home = driver.findElement(By.xpath(xpathhome));
				Thread.sleep(2000);	
				Home.click();
				Timestamp home = new Timestamp(System.currentTimeMillis());
				logger.info( "clicked on home : " +home);			
				logger.info("clicked on HomePage element");
				Thread.sleep(3000);	
				List<WebElement> PermissionLists = driver.findElements(By.xpath("//a[contains(@class,'sapMTBShrinkItem')]"));
				if(PermissionLists.size()==0) {
					List<WebElement> permisionliststatus = wait.until(ExpectedConditions.visibilityOfAllElements(PermissionLists));
					if(permisionliststatus.isEmpty()){
						//driver.navigate().refresh();
						logger.info("Page refresh is done");
						PermissionLists = driver.findElements(By.xpath("//a[contains(@class,'sapMTBShrinkItem')]"));
						permisionliststatus = wait.until(ExpectedConditions.visibilityOfAllElements(PermissionLists));
					}
				}
				System.out.println("Total Permissions under "+permissionTitle+" are "+PermissionLists.size());
				ArrayList PermissioncounterList = new ArrayList<>();
				int duplicatecounter = 0;
				ArrayList duplicatepermission= new ArrayList<>();
				for(int permissionCounter=1;permissionCounter<=PermissionLists.size();permissionCounter++) {
					WebElement elementper = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]"));
					WebElement perele;
					try{

						perele = wait.until(ExpectedConditions.elementToBeClickable(elementper));
						act.moveToElement(perele);
					}
					catch (Exception e) {
						perele=driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]"));

						while(perele.equals(null)) {
							Thread.sleep(100);

						}
					}
					permissionLabel=perele.getText();
					if(duplicatepermission.contains(permissionLabel)) {
						duplicatecounter++;
					}
					else {
						duplicatecounter=0;
					}

					//To Get Permission label

					if(!permissionLabel.isEmpty()) {
						PermissionHeader="";
						Permissionname = new ArrayList<String>();
						PermissionValue=new ArrayList<String>();
						PermissionHeader="Permissions";
						Permissionname.add(permissionLabel);
						PermissionValue.add(permissionLabel);
						counterstyle=0;
						countrbodytext=0;
						countheadertext=0;
						counterimage=0;
						counterimg=0;

						try {
							srno = Integer.toString(permissionCounter);
						}
						catch (Exception e) {
							logger.info(e.getStackTrace());
						}
						PermissionValue.add(srno);


					}
					if(permissionLabel.equalsIgnoreCase("Image Carousel")&&duplicatecounter==0) {
						logger.info("Image Carousel--executionstarted");
						try {						
							PermissioncounterList.add(permissionCounter);
							duplicatepermission.add(permissionLabel);
							radioselected = false;
							PermissionHeader="Permissions";	
							System.out.println("Permission " + permissionCounter+ " : "+permissionLabel);
							//add permissionton the excel			
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue,Permissionname);
							logger.info("Permissionis added in excel file");
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";

							counter=0;	
							List<WebElement> availablePermissions = driver.findElements(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
							ArrayList checkboxlist = new ArrayList<>();
							for(WebElement roleoptions : availablePermissions) {
								if(checkboxlist.size()==3) {
									break;
								}
								//driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')]["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
								permissionvalue="";
								permissionvalue=roleoptions.getText();



								if(permissionvalue.equalsIgnoreCase("Desktop")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][1]//ancestor::div[1]"));
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										checkboxlist.add(permissionvalue);
										counter++;

									}
									else {
										Status = "Off";
										counter=0;
										checkboxlist.add(permissionvalue);
										break;
									}


								}
								else if (permissionvalue.equalsIgnoreCase("Tablet")&&!checkboxlist.contains(permissionvalue)) {
									WebElement tabletcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][2]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = tabletcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;

									}

								}
								else if (permissionvalue.equalsIgnoreCase("Mobile")) {
									WebElement mobileCheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][3]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = mobileCheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;


									}

								}

								PermissionHeader="";
								PermissionValue=new ArrayList<String>();
								PermissionHeader="RoleOptions";
								PermissionValue.add(permissionvalue);
								PermissionValue.add(Status);

								//add allcheckboxstatus
								Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
								logger.info("Checbox value" +PermissionValue+" added in excel file");				
							}
							//To add settings value
							PermissionHeader="";
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";
							PermissionValue.add("Settings");
							PermissionValue.add(Status);
							//add settingscheckboxstatus
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							logger.info("Checbox value for settings added in excel file");


							WebElement Tile = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
							try {
								wait.until(ExpectedConditions.elementToBeClickable(Tile));
							}
							catch (Exception e) {
								Tile = driver.findElement(By.xpath("//a[text()='Image Carousel']//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
								while(Tile.equals(null)) {
									Thread.sleep(10);
								}
							}
							Tile.click();
							Thread.sleep(5000);
							try {
								Headertext = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//bdi[text()='Header Text']"))));
							}
							catch (Exception e) {
								Headertext=driver.findElement(By.xpath("//bdi[text()='Header Text']"));
								while(Headertext.equals(null)) {
									Thread.sleep(10);
								}
							}
							String label = driver.findElement(By.xpath("//bdi[text()='Header Text']")).getText();
							WebElement text = driver.findElement(By.xpath("//input[@class='sapMInputBaseInner']"));
							textvalue = text.getAttribute("value");			
							if(!textvalue.isEmpty()) {
								headertextstatus = "On";
							}
							else {
								headertextstatus="Off";
							}
							PermissionHeader="";
							PermissionValue=new ArrayList<String>();
							PermissionHeader="HeaderText";
							PermissionValue.add(headertextstatus);

							//AddHeadertextvalue
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							Thread.sleep(2000);
							PermissionValue=new ArrayList<String>();
							PermissionValue.add(textvalue);
							driver.findElement(By.xpath("//button[@title='Open Styling']")).click();
							List<WebElement> fontoptions = driver.findElements(By.xpath("//div[@class='sapMDialogScroll']//child::div[contains(@class,'sapUiRespGridMedia-Std-Phone')]/div/label"));
							ArrayList fonttextlist = new ArrayList<>();
							String headerinput="";
							String inputvalue ="";
							int hedertextno=0;
							for(WebElement fontopt:fontoptions) {
								String fontopttext = "";
								fontopttext = fontopt.getText();
								if(fontopttext.equalsIgnoreCase("Font")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement font = driver.findElement(By.xpath("//bdi[text()='Font']//following::div[1]//span[@class='sapMSelectListItemText']"));
									inputvalue = font.getText();
									headerinput = "Font";
									fonttextlist.add(fontopttext);
									countheadertext++;
								}
								else if (fontopttext.equalsIgnoreCase("Size")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement size = driver.findElement(By.xpath("//bdi[text()='Size']//following::div[3]//input[@name='headerTextSize']"));
									inputvalue = size.getAttribute("value");
									headerinput = "Size";
									fonttextlist.add(fontopttext);
								}
								else if (fontopttext.equalsIgnoreCase("Alignment")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement Alignment = driver.findElement(By.xpath("//bdi[text()='Alignment']//following::div[1]//input[@name='headerTextAlignment']"));
									inputvalue = Alignment.getAttribute("value");
									headerinput = "Alignment";
									fonttextlist.add(fontopttext);
									countheadertext++;

								}
								else if (fontopttext.equalsIgnoreCase("Color")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement color = fontopt.findElement(By.xpath("//bdi[text()='Color:']//following::div[2]//bdi[contains(@id,'colorPaletteControl')]"));
									inputvalue = color.getText();
									headerinput = "Color";
									fonttextlist.add(fontopttext);
									PermissionValue.add(headerinput+":"+inputvalue);
									countheadertext++;

								}
								else if (fontopttext.equalsIgnoreCase("Hide Header Text")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement Alignment = driver.findElement(By.xpath("//bdi[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));
									headerinput = "HideHeaderText";
									WebElement HideHeader = driver.findElement(By.xpath("//*[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));
									String HideHeaderstatus = HideHeader.getAttribute("aria-checked");
									if(HideHeaderstatus.equals("true")) {
										inputvalue = "Yes";
									}
									else {
										inputvalue = "No";
									}
									fonttextlist.add(fontopttext);
								}
								PermissionHeader="";

								PermissionHeader="HeaderText";

								PermissionValue.add(headerinput+":"+inputvalue);

								//add fontvalues;
								//Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

							}
							inputvalue = driver.findElement(By.xpath("//*[text()='Color:']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText();

							headerinput=driver.findElement(By.xpath("//bdi[text()='Color:']")).getText();
							PermissionHeader="";

							//add colour value
							PermissionHeader="HeaderText";
							PermissionValue.add(headerinput+":"+inputvalue);
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							Thread.sleep(3000);
							driver.findElement(By.xpath("//bdi[text()='Close']//ancestor::button[1]")).click();
							Thread.sleep(3000);
							//image section option
							List<WebElement> imageCarouseloptions = driver.findElements(By.xpath("//div[@role='tablist'][contains(@id,'Form--header-head')]/div/div/div/span"));
							int size=imageCarouseloptions.size();
							int columncounter=0;
							for(int optioncounter=0;optioncounter<imageCarouseloptions.size();optioncounter++) {

								String optionname = imageCarouseloptions.get(optioncounter).getText();

								if(optionname.equalsIgnoreCase("Details")) {
									columncounter=columncounter+1;
									WebElement optionelement = driver.findElement(By.xpath("//div[@role='tablist'][contains(@id,'Form--header-head')]/div/div/div/span["+columncounter+"]"));
									ArrayList<String>detailoptionlist = new ArrayList<>();
									List<WebElement> detailsoptions = optionelement.findElements(By.xpath("//div[@class='sapUiForm sapUiFormLblColon sapUiFormM sapUiFormEdit sapUiFormEdit-CTX']//following::span[contains(@id,'label')]/bdi"));
									int xpathcounter=0;
									for(int optcounter=0;optcounter<detailsoptions.size();optcounter++) {

										PermissionValue=new ArrayList<String>();
										String detailoptiontext = detailsoptions.get(optcounter).getText();
										if(detailoptiontext.equals("Display Interval")&&!detailoptionlist.contains(detailoptiontext)) {
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("//div[@class='sapUiForm sapUiFormLblColon sapUiFormM sapUiFormEdit sapUiFormEdit-CTX']//following::span[contains(@id,'label')]/bdi[text()='Display Interval']//following::span[contains(@class,'sapMTextBreakWord')][1]")).getText();
											detailoptionlist.add(detailoptiontext);
											PermissionHeader="";

											PermissionHeader="Detailsoptions";
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equals("Visible Images")) {
											xpathcounter= xpathcounter+1;
											detailoptionlist.add(detailoptiontext);
											//String detailoptiontextvalue = driver.findElement(By.xpath("(//span[contains(@class,'sapMTextBreakWord')])["+xpathcounter+"]")).getText();
											String detailoptiontextvalue =driver.findElement(By.xpath("//div[@class='sapUiForm sapUiFormLblColon sapUiFormM sapUiFormEdit sapUiFormEdit-CTX']//following::span[contains(@id,'label')]/bdi[text()='Visible Images']//following::span[contains(@class,'sapMTextBreakWord')][1]")).getText();
											PermissionHeader="";

											PermissionHeader="Detailsoptions";
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equals("Height")) {
											xpathcounter=xpathcounter+1;
											detailoptionlist.add(detailoptiontext);
											//String detailoptiontextvalue = driver.findElement(By.xpath("(//span[contains(@class,'sapMTextBreakWord')])["+xpathcounter+"]")).getText();
											String detailoptiontextvalue = driver.findElement(By.xpath("//div[@class='sapUiForm sapUiFormLblColon sapUiFormM sapUiFormEdit sapUiFormEdit-CTX']//following::span[contains(@id,'label')]/bdi[text()='Height']//following::span[contains(@class,'sapMTextBreakWord')][1]")).getText();
											PermissionHeader="";

											PermissionHeader="Detailsoptions";
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);

										}
										else if (detailoptiontext.equals("Move Per Page")) {
											xpathcounter=xpathcounter+1;
											detailoptionlist.add(detailoptiontext);
											String detailoptiontextvalue = driver.findElement(By.xpath("//div[@class='sapUiForm sapUiFormLblColon sapUiFormM sapUiFormEdit sapUiFormEdit-CTX']//following::span[contains(@id,'label')]/bdi[text()='Move Per Page']//following::span[contains(@class,'sapMTextBreakWord')][1]")).getText();
											PermissionHeader="";

											PermissionHeader="Detailsoptions";
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);



										}
										else if (detailoptiontext.equals("Space Between Images")) {

											xpathcounter=xpathcounter+1;
											detailoptionlist.add(detailoptiontext);
											//String detailoptiontextvalue = driver.findElement(By.xpath("(//span[contains(@class,'sapMTextBreakWord')])["+xpathcounter+"]")).getText();
											String detailoptiontextvalue = driver.findElement(By.xpath("//div[@class='sapUiForm sapUiFormLblColon sapUiFormM sapUiFormEdit sapUiFormEdit-CTX']//following::span[contains(@id,'label')]/bdi[text()='Space Between Images']//following::span[contains(@class,'sapMTextBreakWord')][1]")).getText();
											PermissionHeader="";


											PermissionHeader="Detailsoptions";
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);								
										}
										else if (detailoptiontext.equals("Auto Focus")) {
											String Autofocus_status = "";
											WebElement AutoFocus = driver.findElement(By.xpath("//*[text()='Auto Focus']//following::div[@role='switch']"));
											String hideattr=AutoFocus.getAttribute("aria-checked");
											if(hideattr.equalsIgnoreCase("false")) {
												Autofocus_status = "No";


											}
											else {
												Autofocus_status = "Yes";

											}
											//String autofocustext = driver.findElement(By.xpath("//bdi[contains(text(),'Auto Focus')]")).getText();
											PermissionHeader="";
											PermissionValue=new ArrayList<String>();
											PermissionHeader="Detailsoptions";
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(Autofocus_status);


										}
										if(!PermissionValue.isEmpty()) {
											//add options from displayinterval
											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
											logger.info("displayinterval value added in excel file");
										}
									}
									Thread.sleep(1000);
									System.out.println();

								}
								else if (optionname.equalsIgnoreCase("Images")) {
									columncounter=columncounter+1;
									String imagetextvalue="";
									WebElement imagetabelement = driver.findElement(By.xpath("//div[@role='tablist'][contains(@id,'Form--header-head')]//span[text()='Images']//ancestor::div[contains(@class,'sapMITBItem')]"));
									imagetabelement.click();
									List<WebElement> images = driver.findElements(By.xpath("//div[@class='sapMITBContent']//div[@class='sapUiFormResGrid sapUiFormBackgrTranslucent']"));
									int imagenocounter = 0;
									for(int imagecounter=0;imagecounter<images.size();imagecounter++) {
										boolean imageflag = images.get(imagecounter).isDisplayed();
										if(imagecounter>=1) {
											counterimg=0;
										}
										if(imageflag) {
											imagenocounter=imagenocounter+1;
											List<WebElement> imagesoptions = driver.findElements(By.xpath("(//div[@class='sapMITBContent']//following::div[@class='sapUiFormResGrid sapUiFormBackgrTranslucent'])["+imagenocounter+"]//span[@class='sapMLabelTextWrapper']/bdi"));
											for(int counter=0;counter<imagesoptions.size();counter++) {
												String imagetext = imagesoptions.get(counter).getText();
												if(counter>0) {

													counterimg=counterimg+1;

												}
												PermissionValue=new ArrayList<String>();

												if(imagetext.equalsIgnoreCase("Image")) {
													WebElement imagestatuse = null ;
													try {
														imagestatuse = driver.findElement(By.xpath("((//div[@class='sapMITBContent']//following::div[@class='sapUiFormResGrid sapUiFormBackgrTranslucent'])["+imagenocounter+"]//span[@class='sapMLabelTextWrapper']/bdi)[1]//following::div[1]"));
													}
													catch (Exception e) {
														imagetextvalue="Off";
													}
													if(imagestatuse.isDisplayed()) {
														imagetextvalue="On"	;
													}
													else {
														imagetextvalue="Off";
													}
													PermissionHeader="";


													PermissionHeader="imageoptions";
													PermissionValue.add("Image"+imagenocounter);
													PermissionValue.add(imagetext);
													PermissionValue.add(imagetextvalue);



												}
												else if (imagetext.equalsIgnoreCase("Image Type")) {
													PermissionHeader="";

													imagetextvalue=driver.findElement(By.xpath("(((//div[@class='sapMITBContent']//following::div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+imagenocounter+"]//span[@class='sapMLabelTextWrapper']/bdi)[2]//following::span[@class='sapMSelectListItemText'])[1]")).getText();

													PermissionHeader="imageoptions";
													PermissionValue.add("Image"+imagenocounter);
													PermissionValue.add(imagetext);
													PermissionValue.add(imagetextvalue);


												}
												else if (imagetext.equalsIgnoreCase("Image Position")) {
													imagetextvalue=driver.findElement(By.xpath("(((//div[@class='sapMITBContent']//following::div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+imagenocounter+"]//span[@class='sapMLabelTextWrapper']/bdi)[3]//following::span[@class='sapMSelectListItemText'])[1]")).getText();
													PermissionHeader="imageoptions";
													PermissionValue.add("Image"+imagenocounter);
													PermissionValue.add(imagetext);
													PermissionValue.add(imagetextvalue);


												}
												else if (imagetext.equalsIgnoreCase("Is Link")) {
													String isLinkStatus="";
													WebElement isLink = driver.findElement(By.xpath("((//div[@class='sapMITBContent']//following::div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+imagenocounter+"]//following::div[@class='sapMSwtCont'])[1]"));
													isLinkStatus=isLink.getAttribute("aria-checked");

													if(isLinkStatus.equalsIgnoreCase("true")) {

														imagetextvalue="Yes";
														
													}
													else {
														imagetextvalue="No";
													}
													PermissionHeader="imageoptions";
													PermissionValue.add("Image"+imagenocounter);
													PermissionValue.add(imagetext);
													PermissionValue.add(imagetextvalue);

												}
												Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);	
											}
											PermissionValue=new ArrayList<String>();
																						String LinkType = driver.findElement(By.xpath("((//div[@class='sapMITBContent']//following::div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+imagenocounter+"]//following::span[@class='sapMText sapUiSelectable'])[1]")).getText();
											if(LinkType.equalsIgnoreCase("Link Type:")) {
												String Linktypetext = driver.findElement(By.xpath("((//div[@class='sapMITBContent']//following::div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+imagenocounter+"]//following::span[@class='sapMText sapUiSelectable'])[1]//following::div[1]")).getText();
												PermissionHeader="imageoptions";
												PermissionValue.add("Image"+imagenocounter);
												PermissionValue.add(LinkType);
												PermissionValue.add(Linktypetext);

												Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
											}
											PermissionValue=new ArrayList<String>();
											String LinkText = driver.findElement(By.xpath("((//div[@class='sapMITBContent']//following::div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+imagenocounter+"]//following::span[@class='sapMText sapUiSelectable sapMTextMaxWidth'])[1]")).getText().trim();
											if(LinkText.equalsIgnoreCase("Link Text:")) {
												String linktextinput = driver.findElement(By.xpath("((//div[@class='sapMITBContent']//following::div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+imagenocounter+"]//following::span[@class='sapMText sapUiSelectable sapMTextMaxWidth'])[1]//following::div[1]")).getText();
												if(linktextinput.isEmpty()) {
													linktextinput="Not Applicable";
												}

												PermissionHeader="imageoptions";
												PermissionValue.add("Image"+imagenocounter);
												PermissionValue.add(LinkText);
												PermissionValue.add(linktextinput);								
												Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
											}
										}

									}
									Thread.sleep(1000);
									System.out.println();



								}
								else if (optionname.equalsIgnoreCase("Styles")) {
									columncounter=columncounter+1;
									WebElement optionelement = driver.findElement(By.xpath("(//div[@role='tablist'][contains(@id,'Form--header-head')]/div/div)["+columncounter+"]"));
									optionelement.click();
									List<WebElement> stylesoptions = optionelement.findElements(By.xpath("//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper']"));
									int xpathcounter = 0;
									for(int stylecounter=0;stylecounter<stylesoptions.size();stylecounter++) {
										if(stylecounter>0) {
											counterstyle=counterstyle+1;


										}


										PermissionValue=new ArrayList<String>();
										ArrayList<String>Styleoptionlist = new ArrayList<>();
										String detailoptiontext = stylesoptions.get(stylecounter).getText();
										if(detailoptiontext.equals("Content Background")&&!Styleoptionlist.contains(detailoptiontext)) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();


											PermissionHeader="";


											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);

										}
										else if (detailoptiontext.equalsIgnoreCase("Image Background")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Header Background")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);



										}
										else if (detailoptiontext.equalsIgnoreCase("Link Hover")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Chevron")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Chevron Hover")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Background Image")) {
											String imagestatus;
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											WebElement image = driver.findElement(By.xpath("//div[@class='sapMITBContainerContent']//bdi[text()='Background Image']//following::img[1]"));
											if(image.isDisplayed()&&image.isEnabled()) {
												imagestatus="On";
											}
											else {
												imagestatus="Off";
											}
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(imagestatus);


										}
										else if (detailoptiontext.equalsIgnoreCase("Image Type")) {	
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Image Position")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);

										}
										else if (detailoptiontext.equalsIgnoreCase("Enable Spacing:")) {
											String EnableSpacing="";
											xpathcounter=xpathcounter+1;
											Styleoptionlist.add(detailoptiontext);
											WebElement switchobj = driver.findElement(By.xpath("//*[text()='Enable Spacing:']/following::div[2]//div[@role='switch']"));
											String switchvalue = switchobj.getAttribute("aria-checked");
											if(switchvalue.equals("true")) {
												EnableSpacing = "On";
											}
											else {
												EnableSpacing = "Off";
											}

											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(EnableSpacing);


										}
										else if (detailoptiontext.equalsIgnoreCase("Top")) {
											List<WebElement> valueoptions = optionelement.findElements(By.xpath("//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper']"));
											PermissionValue=new ArrayList<String>();
											ArrayList<String>Styvalueleoptionlist1 = new ArrayList<>();

											int duplicatepermissionno=0;
											for(int approvetextcounter=0;approvetextcounter<valueoptions.size();approvetextcounter++) {

												String detailvaluetext = valueoptions.get(approvetextcounter).getText();
												if (detailvaluetext.equalsIgnoreCase("Top")) {
													xpathcounter=xpathcounter+1;
													PermissionValue=new ArrayList<>();

													String Topvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="ApprovedText";

													PermissionValue.add(detailoptiontext+":"+Topvalue);


												}
												else if (detailvaluetext.equalsIgnoreCase("Bottom")) {
													xpathcounter=xpathcounter+1;

													String Bottomvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Bottomvalue);

												}
												else if (detailvaluetext.equalsIgnoreCase("Right")) {
													xpathcounter=xpathcounter+1;

													String Rightvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Rightvalue);


												}
												else if (detailvaluetext.equalsIgnoreCase("Left")) {
													xpathcounter=xpathcounter+1;							 
													String Leftvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Leftvalue);


												}
											}

										}

										if(!PermissionValue.isEmpty()) {
											//add options from style
											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

										}


									}
									Thread.sleep(1000);
									System.out.println();


								}

							}
							boolean homeelement=helper.waitForClickable(CSB.HomeLink);
							if(homeelement) {


								CSB.HomeLink.click();
								Thread.sleep(3000);
								logger.info("Image Carousel execution completed");
							}




						} catch (Exception e) {
							logger.info(e.getStackTrace());
						}

					}
					else if (permissionLabel.equalsIgnoreCase("Search Bar for Enhancement of RPA tool-Search Bar")||permissionLabel.equalsIgnoreCase("Search Bar")&&duplicatecounter==0) {
						try {

							logger.info("Search Bar for Enhancement of RPA tool-Search Bar form- execution is started");
							duplicatepermission.add(permissionLabel);

							PermissioncounterList.add(permissionCounter);
							WebElement HelpWindow;
							String inputstatus="";

							radioselected = false;
							PermissionHeader="Permissions";	
							System.out.println("Permission " + permissionCounter+ " : "+permissionLabel);
							//add permissionton the excel			
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue,Permissionname);
							logger.info("Permission is added in excel file");
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";

							counter=0;	
							List<WebElement> availablePermissions = driver.findElements(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
							ArrayList checkboxlist = new ArrayList<>();
							for(WebElement roleoptions : availablePermissions) {
								if(checkboxlist.size()==3) {
									break;
								}
								//driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')]["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
								permissionvalue="";
								permissionvalue=roleoptions.getText();


								if(permissionvalue.equalsIgnoreCase("Desktop")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][1]//ancestor::div[1]"));
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										checkboxlist.add(permissionvalue);
										counter++;

									}
									else {
										Status = "Off";
										counter=0;
										checkboxlist.add(permissionvalue);
										break;
									}


								}
								else if (permissionvalue.equalsIgnoreCase("Tablet")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][2]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;

									}

								}
								else if (permissionvalue.equalsIgnoreCase("Mobile")) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][3]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;


									}

								}

								PermissionHeader="";
								PermissionValue=new ArrayList<String>();
								PermissionHeader="RoleOptions";
								PermissionValue.add(permissionvalue);
								PermissionValue.add(Status);

								//add allcheckboxstatus
								Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
								logger.info("Checbox value" +PermissionValue+" added in excel file");				
							}
							//To add settings value
							PermissionHeader="";
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";
							PermissionValue.add("Settings");
							PermissionValue.add(Status);
							//add settingscheckboxstatus
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							logger.info("Checbox value for settings added in excel file");

							/*boolean homeelement=helper.waitForClickable(CSB.HomeLink);
			if(homeelement) {
				CSB.HomeLink.click();
				Thread.sleep(3000);

			}*/







						} catch (Exception e) {
							logger.info("Search Bar for Enhancement of RPA tool-Search Bar form  execution Failed");
							logger.info(e.getStackTrace());

						}
					}


					else if (permissionLabel.equalsIgnoreCase("Text")&&duplicatecounter==0) {
						logger.info("Text1 execution started");
						try {
							duplicatepermission.add(permissionLabel);
							PermissioncounterList.add(permissionCounter);

							radioselected = false;
							PermissionHeader="Permissions";	
							System.out.println("Permission " + permissionCounter+ " : "+permissionLabel);
							//add permissionton the excel			
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue,Permissionname);
							logger.info("Permission is added in excel file");
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";

							counter=0;	
							List<WebElement> availablePermissions = driver.findElements(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
							ArrayList checkboxlist = new ArrayList<>();
							for(WebElement roleoptions : availablePermissions) {
								if(checkboxlist.size()==3) {
									break;
								}
								//driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')]["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
								permissionvalue="";
								permissionvalue=roleoptions.getText();


								if(permissionvalue.equalsIgnoreCase("Desktop")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][1]//ancestor::div[1]"));
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										checkboxlist.add(permissionvalue);
										counter++;

									}
									else {
										Status = "Off";
										counter=0;
										checkboxlist.add(permissionvalue);
										break;
									}


								}
								else if (permissionvalue.equalsIgnoreCase("Tablet")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][2]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;

									}

								}
								else if (permissionvalue.equalsIgnoreCase("Mobile")) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][3]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;


									}

								}

								PermissionHeader="";
								PermissionValue=new ArrayList<String>();
								PermissionHeader="RoleOptions";
								PermissionValue.add(permissionvalue);
								PermissionValue.add(Status);

								//add allcheckboxstatus
								Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
								logger.info("Checbox value" +PermissionValue+" added in excel file");				
							}
							//To add settings value
							PermissionHeader="";
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";
							PermissionValue.add("Settings");
							PermissionValue.add(Status);
							//add settingscheckboxstatus
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							logger.info("Checbox value for settings added in excel file");


							WebElement Tile = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
							try {
								wait.until(ExpectedConditions.elementToBeClickable(Tile));
							}
							catch (Exception e) {
								Tile = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
								while(Tile.equals(null)) {
									Thread.sleep(10);
								}
							}
							Tile.click();
							Thread.sleep(5000);
							try {
								Headertext = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//bdi[text()='Header Text']"))));
							}
							catch (Exception e) {
								//ifheaderText is not seen
								//driver.findElement(By.xpath("(//div[@role='tablist']/div/div/div/span[text()='Details'])[2]//ancestor::div[1]")).click();
								Headertext=driver.findElement(By.xpath("//bdi[text()='Header Text']"));
								while(Headertext.equals(null)) {
									Thread.sleep(10);
								}
							}
							String label = driver.findElement(By.xpath("//bdi[text()='Header Text']")).getText();
							WebElement text = driver.findElement(By.xpath("//input[@class='sapMInputBaseInner']"));
							textvalue = text.getAttribute("value");			
							if(!textvalue.isEmpty()) {
								headertextstatus = "On";
							}
							else {
								headertextstatus="Off";
							}
							PermissionHeader="";
							PermissionValue=new ArrayList<String>();
							PermissionHeader="HeaderText";
							PermissionValue.add(headertextstatus);

							//AddHeadertextvalue
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							Thread.sleep(2000);
							PermissionValue=new ArrayList<String>();
							PermissionValue.add(textvalue);
							driver.findElement(By.xpath("//button[@title='Open Styling']")).click();
							Thread.sleep(1000);
							List<WebElement> fontoptions = driver.findElements(By.xpath("//div[@class='sapMDialogScroll']//child::div[contains(@class,'sapUiRespGridMedia-Std-Phone')]/div/label"));
							ArrayList fonttextlist = new ArrayList<>();
							String headerinput="";
							String inputvalue ="";
							int hedertextno=0;
							for(WebElement fontopt:fontoptions) {
								String fontopttext = "";
								fontopttext = fontopt.getText();
								if(fontopttext.equalsIgnoreCase("Font")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement font = driver.findElement(By.xpath("//bdi[text()='Font']//following::div[1]//span[@class='sapMSelectListItemText']"));
									inputvalue = font.getText();
									headerinput = "Font";
									fonttextlist.add(fontopttext);
									countheadertext++;
								}
								else if (fontopttext.equalsIgnoreCase("Size")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement size = driver.findElement(By.xpath("//bdi[text()='Size']//following::div[3]//input[@name='headerTextSize']"));
									inputvalue = size.getAttribute("value");
									headerinput = "Size";
									fonttextlist.add(fontopttext);
									countheadertext++;
								}
								else if (fontopttext.equalsIgnoreCase("Alignment")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement Alignment = driver.findElement(By.xpath("//bdi[text()='Alignment']//following::div[1]//input[@name='headerTextAlignment']"));
									inputvalue = Alignment.getAttribute("value");
									headerinput = "Alignment";
									fonttextlist.add(fontopttext);
									countheadertext++;

								}
								else if (fontopttext.equalsIgnoreCase("Color")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement color = fontopt.findElement(By.xpath("//bdi[text()='Color:']//following::div[2]//bdi[contains(@id,'colorPaletteControl')]"));
									inputvalue = color.getText();
									headerinput = "Color";
									fonttextlist.add(fontopttext);
									PermissionValue.add(headerinput+":"+inputvalue);
									countheadertext++;

								}
								else if (fontopttext.equalsIgnoreCase("Hide Header Text")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement Alignment = driver.findElement(By.xpath("//bdi[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));
									headerinput = "HideHeaderText";
									WebElement HideHeader = driver.findElement(By.xpath("//*[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));
									String HideHeaderstatus = HideHeader.getAttribute("aria-checked");
									if(HideHeaderstatus.equals("true")) {
										inputvalue = "Yes";
									}
									else {
										inputvalue = "No";
									}
									fonttextlist.add(fontopttext);
									countheadertext++;
								}
								PermissionHeader="";

								PermissionHeader="HeaderText";

								PermissionValue.add(headerinput+":"+inputvalue);


							}
							inputvalue = driver.findElement(By.xpath("//*[text()='Color:']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText();

							headerinput=driver.findElement(By.xpath("//bdi[text()='Color:']")).getText();
							PermissionHeader="";

							//add colour value
							PermissionHeader="HeaderText";
							PermissionValue.add(headerinput+":"+inputvalue);
							countheadertext++;
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							Thread.sleep(3000);
							driver.findElement(By.xpath("//bdi[text()='Close']//ancestor::button[1]")).click();
							countheadertext=0;
							Thread.sleep(3000);

							PermissionHeader="";
							PermissionValue=new ArrayList<String>();


							List<WebElement> imageCarouseloptions = driver.findElements(By.xpath("//div[@role='tablist']/div/div/div/span"));
							int size=imageCarouseloptions.size();

							int columncounter=0;
							for(int optioncounter=0;optioncounter<imageCarouseloptions.size();optioncounter++) {

								String optionname = imageCarouseloptions.get(optioncounter).getText();

								if(optionname.equalsIgnoreCase("Details")) {

									columncounter=columncounter+1;
									WebElement optionelement = driver.findElement(By.xpath("(//div[@role='tablist']/div/div/div/span)["+columncounter+"]//ancestor::div[1]"));

									ArrayList<String>detailoptionlist = new ArrayList<>();
									List<WebElement> detailsoptions = optionelement.findElements(By.xpath("//span[@class='sapMLabelTextWrapper']//following::span[contains(@id,'label')]/bdi"));

									for(int optcounter=0;optcounter<detailsoptions.size();optcounter++) {

										String detailoptiontext = detailsoptions.get(optcounter).getText();
										if(detailoptiontext.equals("Body Text")&&!detailoptionlist.contains(detailoptiontext)) {
											WebElement bodytextframe;


											inputvalue = driver.findElement(By.xpath("//bdi[text()='Body Text']")).getText();

											try {
												bodytextframe=driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
											}
											catch (Exception e) {
												bodytextframe = driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor')]"));
											}

											driver.switchTo().frame(bodytextframe);
											String bodyparatextinput = driver.findElement(By.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke')]/p")).getText();



											if(!bodyparatextinput.isEmpty()) {
												headertextstatus = "On";
											}
											else {
												headertextstatus="Off";
											}
											PermissionHeader="";
											PermissionValue= new ArrayList<>();
											PermissionHeader="BodyText";
											PermissionValue.add(headertextstatus);
											countrbodytext=0;
											//Add body Text on off condition
											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
											bodyparatextinput = driver.findElement(By.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke')]/p")).getText();
											PermissionHeader="";
											PermissionValue=new ArrayList<String>();
											PermissionHeader="BodyText";
											PermissionValue.add(bodyparatextinput);
											Thread.sleep(3000);
											driver.switchTo().defaultContent();
											driver.findElement(By.xpath("(//*[text()='Body Text']/following::div[3]//following::span[5]//a[@class='cke_button cke_button__openstylebutton cke_button_off'])[1]")).click();
											Thread.sleep(5000);
											PermissionValue.add("Font:"+driver.findElement(By.xpath("//*[text()='Font']//following::div/div/span[@class='sapMSltLabel']//span[@class='sapMSelectListItemText']")).getText());
											PermissionValue.add("Size:"+driver.findElement(By.xpath("//*[text()='Size']//following::div[3]/input[@role='combobox']")).getAttribute("value"));
											Thread.sleep(2000);
											driver.findElement(By.xpath("//*[text()='Close']//parent::span//parent::span//parent::button")).click();
											Thread.sleep(3000);
											/*driver.findElement(By.xpath("(//*[text()='Body Text']//following::a[@title='Paragraph Format'])[1]")).click();									
										driver.findElement(By.xpath("//*[text()='Body Text']")).click();
											 */PermissionValue.add("Paragraph Format:"+driver.findElement(By.xpath("(//*[text()='Body Text']//following::a[@title='Paragraph Format'])[1]")).getText());
											 WebElement leftAlign=driver.findElement(By.xpath("(//a[@title='Align Left'])[1]"));
											 String alignLeft=leftAlign.getAttribute("class");
											 WebElement centerAlign=driver.findElement(By.xpath("(//a[@title='Center'])[1]"));
											 String alignCenter=centerAlign.getAttribute("class");
											 WebElement rightAlign=driver.findElement(By.xpath("(//a[@title='Align Right'])[1]"));
											 String alignRight=rightAlign.getAttribute("class");
											 WebElement justifyAlign=driver.findElement(By.xpath("(//a[@title='Justify'])[1]"));
											 String alignJustify=justifyAlign.getAttribute("class");
											 if(alignLeft.contains("button_on")) {
												 PermissionValue.add("Alignment:Left Align");
											 }
											 if(alignCenter.contains("button_on")) {
												 PermissionValue.add("Alignment:Center");
											 }
											 if(alignRight.contains("button_on")) {
												 PermissionValue.add("Alignment:Right Align");
											 }
											 if(alignJustify.contains("button_on")) {
												 PermissionValue.add("Alignment:Justify");
											 }
											 countrbodytext++;

											 //driver.switchTo().defaultContent();

											 Thread.sleep(1000);
											 //add body text in approve text with other options 
											 Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
											 logger.info("bodytext value with foint and size values added in excel file");

										}else if (detailoptiontext.equals("Show Button")&&!detailoptionlist.contains(detailoptiontext)) {
											PermissionValue=new ArrayList<String>();
											detailoptionlist.add(detailoptiontext);
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMSwtCont'])[1]")).getAttribute("aria-checked");
											PermissionHeader="";
											if(detailoptiontextvalue.equals("true")) {
												detailoptiontextvalue="On";
											}
											else {
												detailoptiontextvalue="Off";
											}
											PermissionHeader="Detailsoptions";
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										if(!PermissionValue.isEmpty()&&detailoptiontext.equalsIgnoreCase("BodyText")) {

											//add options from show button
											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
											logger.info("bodytext value with foint and size values added in excel file");
										}
									}

									//add options from show button
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									String detailoptiontext="";
									String inputstatus="";
									String buttontextstatus="";
									Thread.sleep(1000);
									countrbodytext=0;
									String Buttontext = driver.findElement(By.xpath("//span[text()='Button Text: ']")).getText();
									String Buttontextinput = driver.findElement(By.xpath("//span[text()='Button Text: ']//following::div[1]")).getText();
									Thread.sleep(1000);
									if(!Buttontextinput.isEmpty()) {
										Buttontextinput="On";
									}
									else {
										Buttontextinput="Off";
									}
									PermissionValue=new ArrayList<String>();
									PermissionHeader="Detailsoptions";
									PermissionValue.add(Buttontext);
									PermissionValue.add(Buttontextinput);
									// add buttontexttoexcel
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									Buttontextinput = driver.findElement(By.xpath("//span[text()='Button Text: ']//following::div[1]")).getText();
									PermissionValue=new ArrayList<String>();
									PermissionHeader="Detailsoptions";
									PermissionValue.add(Buttontextinput);
									String showbuttonstatus = driver.findElement(By.xpath("(//div[@class='sapMSwtCont'])[1]")).getAttribute("aria-checked");
									if(showbuttonstatus.equalsIgnoreCase("true")){
										wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='sapMBtnBase sapMBtn'])[2]"))).click();
										List<WebElement> Textbuttonstyling = driver.findElements(By.xpath("//div[@class='sapMDialogScrollCont']//bdi"));
										for(WebElement wb:Textbuttonstyling) {
											String fonttext = wb.getText();
											if(fonttext.equalsIgnoreCase("Font")){
												inputvalue = wb.findElement(By.xpath("(//span[@class='sapMSelectListItemText'])[1]")).getText();
												countrbodytext++;
											}
											else if (fonttext.equalsIgnoreCase("Size")) {
												inputvalue = wb.findElement(By.xpath("//input[@name='buttonTextSize']")).getAttribute("value");
												countrbodytext++;

											}

											PermissionHeader="";

											PermissionHeader="BodyText";

											PermissionValue.add(fonttext+":"+inputvalue);

										}
										Thread.sleep(2000);
										//close the Textbuttonstyling messagebox popup
										driver.findElement(By.xpath("(//button[@class='sapMBtnBase sapMBtn sapMBarChild'])[1]")).click();
										//add body text in approve text with other options 
										Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);


									}						
									PermissionValue=new ArrayList<String>();
									WebElement buttontype = driver.findElement(By.xpath("//span[@class='sapMText sapUiSelectable']"));
									detailoptiontext = buttontype.getText();
									String buttontypetext = driver.findElement(By.xpath("//span[@class='sapMText sapUiSelectable']//following::span[1]")).getText();
									PermissionHeader="Detailsoptions";
									PermissionValue.add(detailoptiontext);
									PermissionValue.add(buttontypetext);
									//add buttontypeoption			
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									PermissionValue=new ArrayList<String>();

									boolean buttonlinkstatus = driver.findElement(By.xpath("//bdi[text()='Edit Button']//ancestor::button[1]")).isEnabled();
									if(buttonlinkstatus) {
										inputstatus="On";
									}
									else {
										inputstatus="Off";
									}
									PermissionValue=new ArrayList<String>();
									PermissionHeader="Detailsoptions";
									PermissionValue.add("ButtonLink");
									PermissionValue.add( inputstatus);
									//Add buttonLink
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									if(buttonlinkstatus) {
										driver.findElement(By.xpath("//bdi[text()='Edit Button']//ancestor::button[1]")).click();
										wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Button Editor']")));
										List<WebElement> editorlist = driver.findElements(By.xpath("//div[@class='sapMDialogScrollCont']//bdi"));
										int xpathcounter = 0;
										for(WebElement wb:editorlist) {
											String eletext = wb.getText();
											if(eletext.equalsIgnoreCase("Type")) {
												permissionvalue="";
												permissionvalue= eletext;
												Status=wb.findElement(By.xpath("(//span[@class='sapMSelectListItemText'])[1]")).getText();

											}
											else if (eletext.equalsIgnoreCase("Title")) {
												xpathcounter=xpathcounter+1;
												permissionvalue= eletext;
												Status=wb.findElement(By.xpath("(//input[@class='sapMInputBaseInner'])["+xpathcounter+"]")).getAttribute("value");


											}
											else if (eletext.equalsIgnoreCase("Text")) {
												xpathcounter=xpathcounter+1;
												permissionvalue= eletext;
												Status=wb.findElement(By.xpath("(//input[@class='sapMInputBaseInner'])["+xpathcounter+"]")).getAttribute("value");

											}
											else if (eletext.equalsIgnoreCase("Source")) {
												xpathcounter=xpathcounter+1;
												permissionvalue= eletext;
												Status=wb.findElement(By.xpath("(//input[@class='sapMInputBaseInner'])["+xpathcounter+"]")).getAttribute("value");



											}
											else if (eletext.equalsIgnoreCase("New Session")) {
												permissionvalue= eletext;
												Status=wb.findElement(By.xpath("//div[@class='sapMSwt sapMSwtTrans sapMSwtOff sapMSwtDefault sapMSwtHoverable']")).getAttribute("class");
												if(Status.contains("sapMSwtOn")) {
													Status="On";
												}
												else {
													Status="Off";
												}


											}
											PermissionHeader="";
											PermissionValue=new ArrayList<String>();
											PermissionHeader="Detailsoptions";
											PermissionValue.add(permissionvalue);
											PermissionValue.add(Status);
											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);



										}
										Thread.sleep(2000);
										driver.findElement(By.xpath("(//bdi[text()='Cancel']//ancestor::button)[1]")).click();

									}
									else {

									}

								}else if (optionname.equalsIgnoreCase("Images")) {

								}
								else if (optionname.equalsIgnoreCase("Styles")) {
									int stylecount = 0;
									columncounter=columncounter+1;
									WebElement styleelement = driver.findElement(By.xpath("(//div[@role='tablist']/div/div/div/span)["+columncounter+"]//ancestor::div[1]"));
									styleelement.click();
									List<WebElement> stylesoptions = styleelement.findElements(By.xpath("//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper']"));
									int xpathcounter = 0;
									for(int stylecounter=0;stylecounter<stylesoptions.size();stylecounter++) {
										stylecount++;
										if(stylecounter>0) {
											counterstyle=counterstyle+1;


										}


										PermissionValue=new ArrayList<String>();
										ArrayList<String>Styleoptionlist = new ArrayList<>();
										String detailoptiontext = stylesoptions.get(stylecounter).getText();
										if(detailoptiontext.equals("Background")&&!Styleoptionlist.contains(detailoptiontext)) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											if(detailoptiontextvalue.isEmpty()) {
												detailoptiontextvalue="NotApplicable";										
											}


											PermissionHeader="";


											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);

										}
										else if (detailoptiontext.equalsIgnoreCase("Body Text")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											if(detailoptiontextvalue.isEmpty()) {
												detailoptiontextvalue="NotApplicable";										
											}
											if(detailoptiontextvalue.isEmpty()) {
												detailoptiontextvalue="NotApplicable";										
											}
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Link")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();

											PermissionHeader="";
											if(detailoptiontextvalue.isEmpty()) {
												detailoptiontextvalue="Off";
											}
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);



										}
										else if (detailoptiontext.equalsIgnoreCase("Link Hover")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											if(detailoptiontextvalue.isEmpty()) {
												detailoptiontextvalue="Off";
											}
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Chevron")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											if(detailoptiontextvalue.isEmpty()) {
												detailoptiontextvalue="NotApplicable";										
											}
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Chevron Hover")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											if(detailoptiontextvalue.isEmpty()) {
												detailoptiontextvalue="NotApplicable";										
											}
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Background Image")) {
											WebElement imagebutton = null;
											String imagestatus;
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;

											try {
												imagebutton = driver.findElement(By.xpath("//div[@class='sapMITBContainerContent']//bdi[text()='Background Image']//following::button[1]"));
											}
											catch (Exception e) {
												imagestatus="On";
											}
											if(imagebutton.isDisplayed()&&imagebutton.isEnabled()) {
												imagestatus="Off";
											}
											else {
												imagestatus="On";
											}
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(imagestatus);


										}
										else if (detailoptiontext.equalsIgnoreCase("Image Type")) {	
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Image Position")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);

										}
										else if (detailoptiontext.equalsIgnoreCase("Enable Spacing:")) {
											String EnableSpacing="";
											xpathcounter=xpathcounter+1;
											Styleoptionlist.add(detailoptiontext);
											WebElement switchobj = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::div[@class='sapMSwtCont'][1]"));
											String switchvalue = switchobj.getAttribute("aria-checked");
											if(switchvalue.equals("true")) {
												switchvalue="On";
											}
											else {
												switchvalue="Off";
											}


											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(switchvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Top")) {
											List<WebElement> valueoptions = driver.findElements(By.xpath("//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper']"));
											PermissionValue=new ArrayList<String>();
											ArrayList<String>Styvalueleoptionlist1 = new ArrayList<>();

											int duplicatepermissionno=0;
											for(int approvetextcounter=0;approvetextcounter<valueoptions.size();approvetextcounter++) {

												String detailvaluetext = valueoptions.get(approvetextcounter).getText();
												if (detailvaluetext.equalsIgnoreCase("Top")) {
													xpathcounter=xpathcounter+1;
													PermissionValue=new ArrayList<>();

													String Topvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="ApprovedText";

													PermissionValue.add(detailoptiontext+":"+Topvalue);


												}
												else if (detailvaluetext.equalsIgnoreCase("Bottom")) {
													xpathcounter=xpathcounter+1;

													String Bottomvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Bottomvalue);

												}
												else if (detailvaluetext.equalsIgnoreCase("Right")) {
													xpathcounter=xpathcounter+1;

													String Rightvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Rightvalue);


												}
												else if (detailvaluetext.equalsIgnoreCase("Left")) {
													xpathcounter=xpathcounter+1;							 
													String Leftvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Leftvalue);


												}
											}

										}

										if(!PermissionValue.isEmpty()) {
											//add options from style
											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

										}

									}


									Thread.sleep(2000);
									if(stylecount==stylesoptions.size()) {
										WebElement Detailele = null;
										try {
											Detailele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Details'])[1]//ancestor::div[1]")));
										}
										catch (Exception e) {
											act.moveToElement(Detailele);
										}
										Detailele.click();
										counterstyle=0;
										countrbodytext=0;
										countheadertext=0;

										xpathcounter=0;
									}



								}

							}

							boolean homeelement=helper.waitForClickable(CSB.HomeLink);
							if(homeelement) {

								CSB.HomeLink.click();
								Thread.sleep(3000);
								logger.info("Text1 execution completed");
							}

						} catch (Exception e) {
							logger.info("Text1 execution Failed");
							logger.info(e.getStackTrace());
						}

					}
					else if (permissionLabel.equalsIgnoreCase("Text")&&duplicatecounter>0) {
						logger.info("Text 2execution started");
						try {					
							duplicatepermission.add(permissionLabel);
							PermissioncounterList.add(permissionCounter);

							radioselected = false;
							PermissionHeader="Permissions";	
							System.out.println("Permission " + permissionCounter+ " : "+permissionLabel);
							//add permissionton the excel			
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue,Permissionname);
							logger.info("Permission is added in excel file");
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";

							counter=0;	
							List<WebElement> availablePermissions = driver.findElements(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
							ArrayList checkboxlist = new ArrayList<>();
							for(WebElement roleoptions : availablePermissions) {
								if(checkboxlist.size()==3) {
									break;
								}
								//driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')]["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
								permissionvalue="";
								permissionvalue=roleoptions.getText();


								if(permissionvalue.equalsIgnoreCase("Desktop")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][1]//ancestor::div[1]"));
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										checkboxlist.add(permissionvalue);
										counter++;

									}
									else {
										Status = "Off";
										counter=0;
										checkboxlist.add(permissionvalue);
										break;
									}


								}
								else if (permissionvalue.equalsIgnoreCase("Tablet")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][2]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;

									}

								}
								else if (permissionvalue.equalsIgnoreCase("Mobile")) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][3]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;


									}

								}

								PermissionHeader="";
								PermissionValue=new ArrayList<String>();
								PermissionHeader="RoleOptions";
								PermissionValue.add(permissionvalue);
								PermissionValue.add(Status);

								//add allcheckboxstatus
								Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
								logger.info("Checbox value" +PermissionValue+" added in excel file");				
							}
							//To add settings value
							PermissionHeader="";
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";
							PermissionValue.add("Settings");
							PermissionValue.add(Status);
							//add settingscheckboxstatus
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							logger.info("Checbox value for settings added in excel file");

							Thread.sleep(2000);
							WebElement Tile = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
							try {
								wait.until(ExpectedConditions.elementToBeClickable(Tile));
							}
							catch (Exception e) {
								Tile = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
								while(Tile.equals(null)) {
									Thread.sleep(10);
								}
							}
							Tile.click();
							Thread.sleep(2000);
							/*		WebElement Detailstab; 
				try {

				 Detailstab= driver.findElement(By.xpath("(//span[text()='Details'])[1]//ancestor::div[@role='tab']"));
				}
				catch (Exception e) {
					 Detailstab= driver.findElement(By.xpath("(//bdi[text()='Desktop']//following::span[text()='Details'])[2]//ancestor::div[3]"));

				}
				String tabstatus = Detailstab.getAttribute("aria-selected");
				if(tabstatus.equals("false")) {
					act.moveToElement(Detailstab).build().perform();

				}*/
							try {
								Headertext = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//span[text()='Details'])[1]//following::bdi[text()='Header Text']"))));
							}
							catch (Exception e) {
								//ifheaderText is not seen
								//driver.findElement(By.xpath("(//div[@role='tablist']/div/div/div/span[text()='Details'])[2]//ancestor::div[1]")).click();
								Headertext=driver.findElement(By.xpath("(//span[text()='Details'])[2]//following::bdi[text()='Header Text']"));
								while(Headertext.equals(null)) {
									Thread.sleep(10);
								}
							}
							String label = Headertext.getText();
							WebElement text = Headertext.findElement(By.xpath("//following::input[@placeholder='Header Text'][1]"));
							textvalue = text.getAttribute("value");			
							if(!textvalue.isEmpty()) {
								headertextstatus = "On";
							}
							else {
								headertextstatus="Off";
							}
							PermissionHeader="";
							PermissionValue=new ArrayList<String>();
							PermissionHeader="HeaderText";
							PermissionValue.add(headertextstatus);

							//AddHeadertextvalue
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							Thread.sleep(2000);
							PermissionValue=new ArrayList<String>();
							PermissionValue.add(textvalue);
							try {
								driver.findElement(By.xpath("//input[@placeholder='Header Text'][1]//following::button[@title='Open Styling'][1]")).click();
							}
							catch (Exception e) {
								driver.findElement(By.xpath("(//button[@title='Open Styling'])[4]")).click();
							}
							Thread.sleep(1000);
							List<WebElement> fontoptions = driver.findElements(By.xpath("//div[@class='sapMDialogScroll']//child::div[contains(@class,'sapUiRespGridMedia-Std-Phone')]/div/label"));
							ArrayList fonttextlist = new ArrayList<>();
							String headerinput="";
							String inputvalue ="";
							int hedertextno=0;
							for(WebElement fontopt:fontoptions) {
								String fontopttext = "";
								fontopttext = fontopt.getText();
								if(fontopttext.equalsIgnoreCase("Font")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement font = driver.findElement(By.xpath("//bdi[text()='Font']//following::div[1]//span[@class='sapMSelectListItemText']"));
									inputvalue = font.getText();
									headerinput = "Font";
									fonttextlist.add(fontopttext);
									countheadertext++;
								}
								else if (fontopttext.equalsIgnoreCase("Size")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement size = driver.findElement(By.xpath("//bdi[text()='Size']//following::div[3]//input[@name='headerTextSize']"));
									inputvalue = size.getAttribute("value");
									headerinput = "Size";
									fonttextlist.add(fontopttext);
									countheadertext++;
								}
								else if (fontopttext.equalsIgnoreCase("Alignment")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement Alignment = driver.findElement(By.xpath("//bdi[text()='Alignment']//following::div[1]//input[@name='headerTextAlignment']"));
									inputvalue = Alignment.getAttribute("value");
									headerinput = "Alignment";
									fonttextlist.add(fontopttext);
									countheadertext++;

								}
								else if (fontopttext.equalsIgnoreCase("Color")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement color = fontopt.findElement(By.xpath("//bdi[text()='Color:']//following::div[2]//bdi[contains(@id,'colorPaletteControl')]"));
									inputvalue = color.getText();
									headerinput = "Color";
									fonttextlist.add(fontopttext);
									PermissionValue.add(headerinput+":"+inputvalue);
									countheadertext++;

								}
								else if (fontopttext.equalsIgnoreCase("Hide Header Text")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement Alignment = driver.findElement(By.xpath("//bdi[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));
									headerinput = "HideHeaderText";
									WebElement HideHeader = driver.findElement(By.xpath("//*[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));
									String HideHeaderstatus = HideHeader.getAttribute("aria-checked");
									if(HideHeaderstatus.equals("true")) {
										inputvalue = "Yes";
									}
									else {
										inputvalue = "No";
									}
									fonttextlist.add(fontopttext);
									countheadertext++;
								}
								PermissionHeader="";

								PermissionHeader="HeaderText";

								PermissionValue.add(headerinput+":"+inputvalue);


							}
							inputvalue = driver.findElement(By.xpath("//*[text()='Color:']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText();

							headerinput=driver.findElement(By.xpath("//bdi[text()='Color:']")).getText();
							PermissionHeader="";

							//add colour value
							PermissionHeader="HeaderText";
							PermissionValue.add(headerinput+":"+inputvalue);
							countheadertext++;
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							Thread.sleep(3000);
							driver.findElement(By.xpath("//bdi[text()='Close']//ancestor::button[1]")).click();
							countheadertext=0;
							Thread.sleep(3000);

							PermissionHeader="";
							PermissionValue=new ArrayList<String>();


							List<WebElement> imageCarouseloptions = driver.findElements(By.xpath("//div[@role='tablist']/div/div/div/span"));
							int size=imageCarouseloptions.size();

							int columncounter=0;
							for(int optioncounter=0;optioncounter<imageCarouseloptions.size();optioncounter++) {

								String optionname = imageCarouseloptions.get(optioncounter).getText();

								if(optionname.equalsIgnoreCase("Details")) {

									columncounter=columncounter+1;
									WebElement optionelement = driver.findElement(By.xpath("(//div[@role='tablist']/div/div/div/span)["+columncounter+"]//ancestor::div[1]"));

									ArrayList<String>detailoptionlist = new ArrayList<>();
									List<WebElement> detailsoptions = optionelement.findElements(By.xpath("//span[@class='sapMLabelTextWrapper']//following::span[contains(@id,'label')]/bdi"));

									for(int optcounter=0;optcounter<detailsoptions.size();optcounter++) {

										String detailoptiontext = detailsoptions.get(optcounter).getText();
										if(detailoptiontext.equals("Body Text")&&!detailoptionlist.contains(detailoptiontext)) {


											inputvalue = driver.findElement(By.xpath("(//bdi[text()='Body Text'])[1]")).getText();

											WebElement bodytextframe;
											try {
												bodytextframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
											}
											catch (Exception e) {
												bodytextframe = driver.findElement(By.xpath("(//iframe[contains(@title,'Rich Text Editor')])[2]"));
											}
											driver.switchTo().frame(bodytextframe);
											String bodyparatextinput="";
											try {
												bodyparatextinput=driver.findElement(By.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke')]/p")).getText();
											}
											catch (Exception e) {
												// TODO: handle exception

												bodyparatextinput = driver.findElement(By.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke')]/p")).getText();
											}


											if(!bodyparatextinput.isEmpty()) {
												headertextstatus = "On";
											}
											else {
												headertextstatus="Off";
											}
											PermissionHeader="";
											PermissionValue= new ArrayList<>();
											PermissionHeader="BodyText";
											PermissionValue.add(headertextstatus);
											countrbodytext=0;
											//Add body Text on off condition
											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

											PermissionHeader="";
											PermissionValue=new ArrayList<String>();
											PermissionHeader="BodyText";
											PermissionValue.add(bodyparatextinput);
											Thread.sleep(3000);
											driver.switchTo().defaultContent();
											driver.findElement(By.xpath("(//bdi[text()='Body Text']//following::a[@title='Open Styling'])[1]")).click();
											Thread.sleep(5000);
											PermissionValue.add("Font:"+driver.findElement(By.xpath("(//*[text()='Font']//following::div/div/span[@class='sapMSltLabel']//span[@class='sapMSelectListItemText'])[1]")).getText());
											PermissionValue.add("Size:"+driver.findElement(By.xpath("//*[text()='Size']//following::div[3]/input[@role='combobox']")).getAttribute("value"));
											Thread.sleep(2000);
											driver.findElement(By.xpath("//*[text()='Close']//parent::span//parent::span//parent::button")).click();
											Thread.sleep(4000);
											PermissionValue.add("Paragraph Format:"+driver.findElement(By.xpath("(//*[text()='Body Text']//following::a[@title='Paragraph Format'])[1]")).getText());
											WebElement leftAlign=driver.findElement(By.xpath("(//a[@title='Align Left'])[1]"));
											String alignLeft=leftAlign.getAttribute("class");
											WebElement centerAlign=driver.findElement(By.xpath("(//a[@title='Center'])[1]"));
											String alignCenter=centerAlign.getAttribute("class");
											WebElement rightAlign=driver.findElement(By.xpath("(//a[@title='Align Right'])[1]"));
											String alignRight=rightAlign.getAttribute("class");
											WebElement justifyAlign=driver.findElement(By.xpath("(//a[@title='Justify'])[1]"));
											String alignJustify=justifyAlign.getAttribute("class");
											if(alignLeft.contains("button_on")) {
												PermissionValue.add("Alignment:Left Align");
											}
											if(alignCenter.contains("button_on")) {
												PermissionValue.add("Alignment:Center");
											}
											if(alignRight.contains("button_on")) {
												PermissionValue.add("Alignment:Right Align");
											}
											if(alignJustify.contains("button_on")) {
												PermissionValue.add("Alignment:Justify");
											}
											countrbodytext++;

											//driver.switchTo().defaultContent();

											Thread.sleep(1000);
											//add body text in approve text with other options 
											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
											logger.info("bodytext value with foint and size values added in excel file");

										}else if (detailoptiontext.equals("Show Button")&&!detailoptionlist.contains(detailoptiontext)) {
											PermissionValue=new ArrayList<String>();
											String detailoptiontextvalue = "";
											detailoptionlist.add(detailoptiontext);
											detailoptiontextvalue = driver.findElement(By.xpath("(//bdi[text()='Show Button']//following::div[1]/div/div/div)[1]")).getAttribute("aria-checked");
											PermissionHeader="";
											if(detailoptiontextvalue.equals("true")) {
												detailoptiontextvalue="On";
											}
											else {
												detailoptiontextvalue="Off";
											}
											PermissionHeader="Detailsoptions";
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										if(!PermissionValue.isEmpty()&&detailoptiontext.equalsIgnoreCase("BodyText")) {

											//add options from show button
											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
											logger.info("bodytext value with foint and size values added in excel file");
										}
									}

									//add options from show button
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									String detailoptiontext="";
									String inputstatus="";
									String buttontextstatus="";
									Thread.sleep(1000);
									countrbodytext=0;
									String Buttontextinput;
									String Buttontextvalue="";
									String Buttontext = driver.findElement(By.xpath("//span[text()='Button Text: ']")).getText();
									try {
										Buttontextvalue = driver.findElement(By.xpath("//span[text()='Button Text: ']//following::div[1]")).getText();
										//Buttontextinput="On";
									}
									catch (Exception e) {
										//Buttontextinput="Off";
									}
									if(!Buttontextvalue.isEmpty()) {
										Buttontextinput="On";
									}
									else {
										Buttontextinput="NotApplicable";
									}
									PermissionValue=new ArrayList<String>();
									PermissionHeader="Detailsoptions";
									PermissionValue.add(Buttontext);
									PermissionValue.add(Buttontextinput);
									// add buttontexttoexcel
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									Buttontextinput = driver.findElement(By.xpath("//span[text()='Button Text: ']//following::div[1]")).getText();
									String showbuttonstatus = driver.findElement(By.xpath("(//bdi[text()='Show Button']//following::div[1]/div/div/div)[1]")).getAttribute("aria-checked");
									if(showbuttonstatus.equalsIgnoreCase("false")) {/*
									PermissionValue=new ArrayList<String>();
									PermissionHeader="Refertext";
									//PermissionValue.add(Buttontext);
									PermissionValue.add("NotApplicable");
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

									 */}
									else {
										try {
											wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='sapMBtnBase sapMBtn'])[2]"))).click();
										}
										catch (Exception e) {
											driver.findElement(By.xpath("//span[text()='Button Text: ']//following::button[1]")).click();
										}
										List<WebElement> Textbuttonstyling = driver.findElements(By.xpath("//div[@class='sapMDialogScrollCont']//bdi"));
										for(WebElement wb:Textbuttonstyling) {
											String fonttext = wb.getText();
											if(fonttext.equalsIgnoreCase("Font")){
												inputvalue = wb.findElement(By.xpath("(//span[@class='sapMSelectListItemText'])[1]")).getText();
												countrbodytext++;
											}
											else if (fonttext.equalsIgnoreCase("Size")) {
												inputvalue = wb.findElement(By.xpath("//input[@name='buttonTextSize']")).getAttribute("value");
												countrbodytext++;

											}

											PermissionHeader="";

											PermissionHeader="BodyText";

											PermissionValue.add(fonttext+":"+inputvalue);

										}
										Thread.sleep(2000);
										//close the popup
										driver.findElement(By.xpath("(//button[@class='sapMBtnBase sapMBtn sapMBarChild'])[1]")).click();
										//add body text in approve text with other options 
										Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

									}




									PermissionValue=new ArrayList<String>();
									WebElement buttontype = driver.findElement(By.xpath("//span[@class='sapMText sapUiSelectable']"));
									detailoptiontext = buttontype.getText();
									String buttontypetext = driver.findElement(By.xpath("//span[@class='sapMText sapUiSelectable']//following::span[1]")).getText();
									PermissionHeader="Detailsoptions";
									PermissionValue.add(detailoptiontext);
									PermissionValue.add(buttontypetext);
									//add buttontypeoption			
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									PermissionValue=new ArrayList<String>();

									boolean buttonlinkstatus = driver.findElement(By.xpath("//bdi[text()='Edit Button']//ancestor::button[1]")).isEnabled();
									if(buttonlinkstatus) {
										inputstatus="On";
									}
									else {
										inputstatus="NotApplicable";
									}
									PermissionValue=new ArrayList<String>();
									PermissionHeader="Detailsoptions";
									PermissionValue.add("ButtonLink");
									PermissionValue.add( inputstatus);
									//Add buttonLink
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									if(inputstatus.equalsIgnoreCase("NotApplicable")) {

									}
									else {
										driver.findElement(By.xpath("//button[@class='sapMBtnBase sapMBtn sapMBtnInverted']")).click();
										wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Button Editor']")));
										List<WebElement> editorlist = driver.findElements(By.xpath("//div[@class='sapMDialogScrollCont']//bdi"));
										int xpathcounter = 0;
										for(WebElement wb:editorlist) {
											String eletext = wb.getText();
											if(eletext.equalsIgnoreCase("Type")) {
												permissionvalue="";
												permissionvalue= eletext;
												Status=wb.findElement(By.xpath("(//span[@class='sapMSelectListItemText'])[1]")).getText();

											}
											else if (eletext.equalsIgnoreCase("Title")) {
												xpathcounter=xpathcounter+1;
												permissionvalue= eletext;
												Status=wb.findElement(By.xpath("(//input[@class='sapMInputBaseInner'])["+xpathcounter+"]")).getAttribute("value");


											}
											else if (eletext.equalsIgnoreCase("Text")) {
												xpathcounter=xpathcounter+1;
												permissionvalue= eletext;
												Status=wb.findElement(By.xpath("(//input[@class='sapMInputBaseInner'])["+xpathcounter+"]")).getAttribute("value");

											}
											else if (eletext.equalsIgnoreCase("Source")) {
												xpathcounter=xpathcounter+1;
												permissionvalue= eletext;
												Status=wb.findElement(By.xpath("(//input[@class='sapMInputBaseInner'])["+xpathcounter+"]")).getAttribute("value");



											}
											else if (eletext.equalsIgnoreCase("New Session")) {
												permissionvalue= eletext;
												Status=wb.findElement(By.xpath("//div[@class='sapMSwt sapMSwtTrans sapMSwtOff sapMSwtDefault sapMSwtHoverable']")).getAttribute("class");
												if(Status.contains("sapMSwtOn")) {
													Status="On";
												}
												else {
													Status="Off";
												}


											}
											PermissionHeader="";
											PermissionValue=new ArrayList<String>();
											PermissionHeader="Detailsoptions";
											PermissionValue.add(permissionvalue);
											PermissionValue.add(Status);
											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);



										}
										Thread.sleep(2000);
										driver.findElement(By.xpath("(//bdi[text()='Cancel']//ancestor::button)[1]")).click();
										Thread.sleep(2000);


									}

								}else if (optionname.equalsIgnoreCase("Images")) {

								}
								else if (optionname.equalsIgnoreCase("Styles")) {
									int stylecount = 0;
									columncounter=columncounter+1;
									WebElement styleelement;
									try {
										styleelement=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@role='tablist'])[2]/div/div/div/span[text()='Styles']//ancestor::div[@role='tab']")));
									}
									catch (Exception e) {
										styleelement = driver.findElement(By.xpath("(//div[@role='tablist']/div/div/div/span[text()='Styles'])[1]//ancestor::div[contains(@class,'sapMITBItem sapMITBItemNoCount')]"));
									}

									styleelement.click();

									List<WebElement> stylesoptions = styleelement.findElements(By.xpath("//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper']"));
									int xpathcounter = 0;
									ArrayList<String>Styleoptionlist = new ArrayList<>();
									for(int stylecounter=0;stylecounter<stylesoptions.size();stylecounter++) {
										stylecount++;
										if(stylecounter>0) {
											counterstyle=counterstyle+1;


										}



										PermissionValue=new ArrayList<String>();						
										String detailoptiontext = stylesoptions.get(stylecounter).getText();
										/*if(Styleoptionlist.contains("Enable Spacing:")) {
										break;
									}*/
										if(detailoptiontext.equals("Background")&&!Styleoptionlist.contains(detailoptiontext)) {
											String detailoptiontextvalue = "";
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											try {
												detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent'])[2]//bdi[text()='Background']//following::bdi[1]")).getText();
											}
											catch (Exception e) {
												detailoptiontextvalue=driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent'])[1]//bdi[text()='Background']//following::bdi[1]")).getText();
											}



											PermissionHeader="";


											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);

										}
										else if (detailoptiontext.equalsIgnoreCase("Body Text")) {
											String detailoptiontextvalue;
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											try {
												detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent'])[2]//bdi[text()='Body Text']//following::bdi[1]")).getText();
											}
											catch (Exception e) {
												detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent'])[1]//bdi[text()='Body Text']//following::bdi[1]")).getText();
											}
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Link")) {
											String detailoptiontextvalue;
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											try {
												detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent'])[2]//bdi[text()='Link']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText();
											}
											catch (Exception e) {
												detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent'])[1]//bdi[text()='Link']//following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText();
											}
											PermissionHeader="";
											if(detailoptiontextvalue.isEmpty()) {
												detailoptiontextvalue="Off";
											}
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);



										}
										else if (detailoptiontext.equalsIgnoreCase("Link Hover")) {
											String detailoptiontextvalue="";
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											try {
												detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent'])[2]//bdi[text()='Link Hover']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText();

											}
											catch (Exception e) {
												detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent'])[1]//bdi[text()='Link Hover']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText();
											}
											if(detailoptiontextvalue.isEmpty()) {
												detailoptiontextvalue="Off";
											}
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Background Image")) {
											WebElement imagebutton = null;
											String imagestatus;
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String imagetext = null;
											String imagebuttonstatus = "";
											String imagvisiblestatus = "";

											try {
												//imagebutton = driver.findElement(By.xpath("(//bdi[text()='Background Image'])[2]//following::img"));
												try {
													imagvisiblestatus = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent'])[2]//span[@class='sapMLabelTextWrapper']//bdi[text()='Background Image']//following::img")).getAttribute("src");
												}
												catch (Exception e) {
													imagvisiblestatus = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent'])[1]//span[@class='sapMLabelTextWrapper']//bdi[text()='Background Image']//following::img")).getAttribute("src");
												}
												imagestatus="On"; 
											}
											catch (Exception e) {
												imagvisiblestatus="";
												imagestatus="Off";
											}

											if(imagvisiblestatus.isEmpty()) {
												imagestatus="Off";
											}
											else {
												imagestatus="On";
											}
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(imagestatus);


										}
										else if (detailoptiontext.equalsIgnoreCase("Image Type")) {	
											String detailoptiontextvalue="";
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											try {
												detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent'])[2]//span[@class='sapMLabelTextWrapper']/bdi[text()='Image Type']//following::span[@class='sapMSelectListItemText'][1]")).getText();
											}
											catch (Exception e) {
												detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent'])[1]//span[@class='sapMLabelTextWrapper']/bdi[text()='Image Type']//following::span[@class='sapMSelectListItemText'][1]")).getText();
											}
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Image Position")) {
											String detailoptiontextvalue ="";
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											try {
												detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent'])[2]//span[@class='sapMLabelTextWrapper']/bdi[text()='Image Position']//following::span[@class='sapMSelectListItemText'][1]")).getText();
											}
											catch (Exception e) {
												detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent'])[1]//span[@class='sapMLabelTextWrapper']/bdi[text()='Image Position']//following::span[@class='sapMSelectListItemText'][1]")).getText();
											}
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);

										}
										else if (detailoptiontext.equalsIgnoreCase("Enable Spacing:")) {
											String EnableSpacing="";
											xpathcounter=xpathcounter+1;
											Styleoptionlist.add(detailoptiontext);
											WebElement switchobj = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper']/bdi[text()='Enable Spacing:'])[1]//following::div[@class='sapMSwtCont'][1]"));
											String switchvalue = switchobj.getAttribute("aria-checked");
											if(switchvalue.equals("true")) {
												switchvalue="On";
											}
											else {
												switchvalue="Off";
											}


											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(switchvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Top")) {
											List<WebElement> valueoptions = driver.findElements(By.xpath("//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper']"));
											PermissionValue=new ArrayList<String>();
											ArrayList<String>Styvalueleoptionlist1 = new ArrayList<>();

											int duplicatepermissionno=0;
											for(int approvetextcounter=0;approvetextcounter<valueoptions.size();approvetextcounter++) {

												String detailvaluetext = valueoptions.get(approvetextcounter).getText();
												if (detailvaluetext.equalsIgnoreCase("Top")) {
													xpathcounter=xpathcounter+1;
													PermissionValue=new ArrayList<>();

													String Topvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="ApprovedText";

													PermissionValue.add(detailoptiontext+":"+Topvalue);


												}
												else if (detailvaluetext.equalsIgnoreCase("Bottom")) {
													xpathcounter=xpathcounter+1;

													String Bottomvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Bottomvalue);

												}
												else if (detailvaluetext.equalsIgnoreCase("Right")) {
													xpathcounter=xpathcounter+1;

													String Rightvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Rightvalue);


												}
												else if (detailvaluetext.equalsIgnoreCase("Left")) {
													xpathcounter=xpathcounter+1;							 
													String Leftvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Leftvalue);


												}
											}

										}

										if(!PermissionValue.isEmpty()) {
											//add options from style
											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

										}

									}


									Thread.sleep(2000);

									WebElement Detailele = null;
									try {
										Detailele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Details'])[2]//ancestor::div[@class='sapMITBText']")));

									}
									catch (Exception e) {
										Detailele=driver.findElement(By.xpath("(//div[@role='tablist']/div/div/div/span[text()='Details'])[1]//ancestor::div[contains(@class,'sapMITBItem sapMITBItemNoCount')]"));
										//act.moveToElement(Detailele);
									}
									Detailele.click();




								}

							}
							try {
								WebElement Homeink = driver.findElement(By.xpath("(//a[@class='sapMLnk sapMLnkMaxWidth'][text()='Home'])[2]"));
								Homeink.click();
							}
							catch (Exception e) {

								CSB.HomeLink.click();
								Thread.sleep(3000);

							}
							logger.info("Text2 execution comleted");
						} catch (Exception e) {
							logger.info("Text2 execution Failed");
							logger.info(e.getStackTrace());
						}
					}
					else if (permissionLabel.equalsIgnoreCase("Image and Text Carousel")&&duplicatecounter==0) {
						logger.info("Image and Image and Text Carousel execution started");
						try {						
							duplicatepermission.add(permissionLabel);
							PermissioncounterList.add(permissionCounter);
							WebElement HelpWindow;
							String inputstatus="";

							radioselected = false;
							PermissionHeader="Permissions";	
							System.out.println("Permission " + permissionCounter+ " : "+permissionLabel);
							//add permissionton the excel			
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue,Permissionname);
							logger.info("Permission is added in excel file");
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";

							counter=0;	
							List<WebElement> availablePermissions = driver.findElements(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
							ArrayList checkboxlist = new ArrayList<>();
							for(WebElement roleoptions : availablePermissions) {
								if(checkboxlist.size()==3) {
									break;
								}
								//driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')]["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
								permissionvalue="";
								permissionvalue=roleoptions.getText();


								if(permissionvalue.equalsIgnoreCase("Desktop")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][1]//ancestor::div[1]"));
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										checkboxlist.add(permissionvalue);
										counter++;

									}
									else {
										Status = "Off";
										counter=0;
										checkboxlist.add(permissionvalue);
										break;
									}


								}
								else if (permissionvalue.equalsIgnoreCase("Tablet")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][2]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;

									}

								}
								else if (permissionvalue.equalsIgnoreCase("Mobile")) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][3]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;


									}

								}

								PermissionHeader="";
								PermissionValue=new ArrayList<String>();
								PermissionHeader="RoleOptions";
								PermissionValue.add(permissionvalue);
								PermissionValue.add(Status);

								//add allcheckboxstatus
								Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
								logger.info("Checbox value" +PermissionValue+" added in excel file");				
							}
							//To add settings value
							PermissionHeader="";
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";
							PermissionValue.add("Settings");
							PermissionValue.add(Status);
							//add settingscheckboxstatus
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							logger.info("Checbox value for settings added in excel file");

							WebElement Tile = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
							try {
								wait.until(ExpectedConditions.elementToBeClickable(Tile));
							}
							catch (Exception e) {
								Tile = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
								while(Tile.equals(null)) {
									Thread.sleep(10);
								}
							}
							Tile.click();

							Thread.sleep(3000);
							//DisplayInterval
							String detailoptiontext = driver.findElement(By.xpath("//span[@class='sapMLabelTextWrapper']/bdi[contains(text(),'Display Interval')]")).getText();
							String detailoptiontextvalue = driver.findElement(By.xpath("//span[contains(@class,'sapMTextBreakWord')]")).getText();
							PermissionHeader="";
							PermissionValue= new ArrayList<>();
							PermissionHeader="Detailsoptions";
							PermissionValue.add(detailoptiontext);
							PermissionValue.add(detailoptiontextvalue);	
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							//Autofocus
							String autofocusstatus = "";
							String autofocustext = driver.findElement(By.xpath("//bdi[contains(text(),'Auto Focus')]")).getText();
							WebElement AutoFocus = driver.findElement(By.xpath("//*[text()='Auto Focus']//following::div[@role='switch']"));
							String hideattr=AutoFocus.getAttribute("aria-checked");
							if(hideattr.equalsIgnoreCase("false")) {
								autofocusstatus = "Off";
							}
							else {
								autofocusstatus = "On";

							}
							PermissionHeader="";
							PermissionValue=new ArrayList<String>();
							PermissionHeader="Detailsoptions";
							PermissionValue.add(autofocustext);
							PermissionValue.add(autofocusstatus);
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);



							List<WebElement> slidetabelements = driver.findElements(By.xpath("//div[@role='tablist'][contains(@id,'Form--header-head')]/div/div/div/span"));
							int size=slidetabelements.size();
							int columncounter=0;
							int slidecounter = 0;
							int framecounter = 0;
							for(int optioncounter=0;optioncounter<slidetabelements.size();optioncounter++) {

								String optionname = slidetabelements.get(optioncounter).getText();

								if(optionname.equalsIgnoreCase("Slides")) {

									columncounter=columncounter+1;
									String imagetextvalue="";
									WebElement imagetabelement = driver.findElement(By.xpath("(//div[@role='tablist'][contains(@id,'Form--header-head')]/div/div)["+columncounter+"]//parent::div[1]"));
									String statusslidetab = imagetabelement.getAttribute("aria-selected");
									if(statusslidetab.equals("false")) {
										imagetabelement.click();
									}

									List<WebElement> NoofSlides = driver.findElements(By.xpath("(//div[@class='sapMITBContent'][@role='tabpanel'])[1]//div[@class='sapMPanel']"));
									//no of images in page
									for(int imagecounter=0;imagecounter<NoofSlides.size();imagecounter++) {
										boolean imageflag = NoofSlides.get(imagecounter).isDisplayed();
										if(imagecounter>=1) {
											counterimg=0;
											ArrayList Slidelist = new ArrayList<>();
										}
										if(imageflag) {
											slidecounter=slidecounter+1;
											List<WebElement> slideoptions = driver.findElements(By.xpath("((//div[@class='sapMITBContent'][@role='tabpanel'])[1]//div[@class='sapMPanel'])["+slidecounter+"]//bdi"));
											int xpathcounter=0;
											//optionsperimage
											ArrayList Slidelist = new ArrayList<>();
											int Duplicateoptioncounter=0;
											for(int counter=0;counter<slideoptions.size();counter++) {
												String slidetext = slideoptions.get(counter).getText();

												if(Slidelist.contains(slidetext)) {

													Duplicateoptioncounter++;
												}
												if(counter>0) {

													counterimg=counterimg+1;

												}
												PermissionValue=new ArrayList<String>();
												if(slidetext.contains("Slide")&&Duplicateoptioncounter==0){
													Slidelist.add(slidetext);
													WebElement imagestatuse = null;
													try {
														imagestatuse = driver.findElement(By.xpath("((//div[@class='sapMITBContent'])[1]//div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+slidecounter+"]//bdi[contains(text(),'Slide')]//following::img[1]"));
													}
													catch (Exception e) {	imagetextvalue="Off";
													}
													if(imagestatuse.isDisplayed()) {
														imagetextvalue="On"	;
													}
													else {
														imagetextvalue="Off";
													}
													PermissionHeader="";


													PermissionHeader="Slideptions";
													PermissionValue.add("Slide"+slidecounter);
													PermissionValue.add("Image");
													PermissionValue.add(imagetextvalue);

													Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
												}
												else if (slidetext.equalsIgnoreCase("Image Type")&&Duplicateoptioncounter==0) {
													Slidelist.add(slidetext);
													imagetextvalue=driver.findElement(By.xpath("((//div[@class='sapMITBContent']//div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+slidecounter+"]//bdi[text()='Image Type'])[1]//following::span[@class='sapMSltLabel'][1]")).getText();
													PermissionHeader="Slideptions";
													PermissionValue.add("Slide"+slidecounter);
													PermissionValue.add(slidetext);
													PermissionValue.add(imagetextvalue);

													Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

												}
												else if(slidetext.equalsIgnoreCase("Header Text")&&Duplicateoptioncounter==0) {
													WebElement headertext; 
													Slidelist.add(slidetext);
													Thread.sleep(3000);
													try {
														headertext = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("((//div[@class='sapMITBContent'])[1]//div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+slidecounter+"]//bdi[text()='Header Text']"))));
													}
													catch (Exception e) {

														headertext = driver.findElement(By.xpath("((//div[@class='sapMITBContent'])[1]//div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+slidecounter+"]//bdi[text()='Header Text']"));
														while(headertext.equals(null)) {
															Thread.sleep(10);
														}
													}
													String label = headertext.getText();
													WebElement text = driver.findElement(By.xpath("((//div[@class='sapMITBContent'])[1]//div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+slidecounter+"]//bdi[text()='Header Text']//following::input[1]"));
													textvalue = text.getAttribute("value");			
													if(!textvalue.isEmpty()) {
														headertextstatus = "On";
													}
													else {
														headertextstatus="Off";
													}
													PermissionHeader="";
													PermissionValue=new ArrayList<String>();
													PermissionHeader="HeaderText";
													PermissionValue.add(headertextstatus);

													//AddHeadertextvalue
													Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
													Thread.sleep(2000);
													PermissionValue=new ArrayList<String>();
													PermissionValue.add(textvalue);
													driver.findElement(By.xpath("(//input[@class='sapMInputBaseInner'])["+slidecounter+"]//following::button[1]")).click();
													Thread.sleep(1000);
													List<WebElement> fontoptions = driver.findElements(By.xpath("//div[@class='sapMDialogScroll']//child::div[contains(@class,'sapUiRespGridMedia-Std-Phone')]/div/label"));
													ArrayList fonttextlist = new ArrayList<>();
													String headerinput="";
													String inputvalue ="";
													int hedertextno=0;
													for(WebElement fontopt:fontoptions) {
														String fontopttext = "";
														fontopttext = fontopt.getText();
														if(fontopttext.equalsIgnoreCase("Font")&&!fonttextlist.contains(fontopttext)) {
															inputvalue="";
															WebElement font = driver.findElement(By.xpath("//bdi[text()='Font']//following::div[1]//span[@class='sapMSelectListItemText']"));
															inputvalue = font.getText();
															headerinput = "Font";
															fonttextlist.add(fontopttext);
															countheadertext++;
														}
														else if (fontopttext.equalsIgnoreCase("Size")&&!fonttextlist.contains(fontopttext)) {
															inputvalue="";
															WebElement size1 = driver.findElement(By.xpath("//bdi[text()='Size']//following::input[1]"));
															inputvalue = size1.getAttribute("value");
															headerinput = "Size";
															fonttextlist.add(fontopttext);
															countheadertext++;
														}
														else if (fontopttext.equalsIgnoreCase("Alignment")&&!fonttextlist.contains(fontopttext)) {
															inputvalue="";
															WebElement Alignment = driver.findElement(By.xpath("//bdi[text()='Alignment']//following::input[1]"));
															inputvalue = Alignment.getAttribute("value");
															headerinput = "Alignment";
															fonttextlist.add(fontopttext);
															countheadertext++;

														}
														else if (fontopttext.equalsIgnoreCase("Color")&&!fonttextlist.contains(fontopttext)) {
															inputvalue="";
															WebElement color = fontopt.findElement(By.xpath("//bdi[text()='Color:']//following::div[2]//bdi[contains(@id,'colorPaletteControl')]"));
															inputvalue = color.getText();
															headerinput = "Color";
															fonttextlist.add(fontopttext);
															PermissionValue.add(headerinput+":"+inputvalue);
															countheadertext++;

														}
														else if (fontopttext.equalsIgnoreCase("Hide Header Text")&&!fonttextlist.contains(fontopttext)) {
															inputvalue="";
															WebElement Alignment = driver.findElement(By.xpath("//bdi[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));
															headerinput = "HideHeaderText";
															WebElement HideHeader = driver.findElement(By.xpath("//*[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));
															String HideHeaderstatus = HideHeader.getAttribute("aria-checked");
															if(HideHeaderstatus.equals("true")) {
																inputvalue = "Yes";
															}
															else {
																inputvalue = "No";
															}
															fonttextlist.add(fontopttext);
															countheadertext++;
														}
														PermissionHeader="";

														PermissionHeader="HeaderText";

														PermissionValue.add(headerinput+":"+inputvalue);


													}
													inputvalue = driver.findElement(By.xpath("//*[text()='Color:']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText();

													headerinput=driver.findElement(By.xpath("//bdi[text()='Color:']")).getText();
													PermissionHeader="";

													//add colour value
													PermissionHeader="HeaderText";
													PermissionValue.add(headerinput+":"+inputvalue);
													countheadertext++;
													Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
													Thread.sleep(3000);
													driver.findElement(By.xpath("//bdi[text()='Close']//ancestor::button[1]")).click();
													countheadertext=0;
													Thread.sleep(3000);


												}
												else if (slidetext.equalsIgnoreCase("Body Text")&&Duplicateoptioncounter==0) {
													Slidelist.add(slidetext);
													Thread.sleep(2000);
													String bodyparatextinput="";
													String bodytext="";
													WebElement bodytextframe = driver.findElement(By.xpath("(//iframe[contains(@title,'Rich Text Editor')])["+slidecounter+"]"));
													driver.switchTo().frame(bodytextframe);
													List<WebElement> noofbodies = driver.findElements(By.xpath("/html/body/p"));
													for(WebElement bodyele:noofbodies) {
														bodytext = bodyele.getText();
														if(framecounter==imagecounter) {
															bodytext=bodytext;
															framecounter++;
															break;
														}



													}

													if(!bodytext.isEmpty()) {
														headertextstatus = "On";
													}
													else {
														headertextstatus="Off";
													}
													PermissionHeader="";
													PermissionValue= new ArrayList<>();
													PermissionHeader="BodyText";
													PermissionValue.add(headertextstatus);
													countrbodytext=0;
													//Add body Text on off condition
													Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
													// bodyparatextinput = driver.findElement(By.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke')]/p")).getText();
													PermissionHeader="";
													PermissionValue=new ArrayList<String>();
													PermissionHeader="BodyText";
													PermissionValue.add(bodytext);
													Thread.sleep(3000);
													driver.switchTo().defaultContent();
													PermissionValue.add("Paragraph Format:"+driver.findElement(By.xpath("((//div[@class='sapMITBContent']//div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+slidecounter+"]//bdi[text()='Body Text'])[1]//following::a[@title='Paragraph Format'][1]")).getText());
													WebElement leftAlign=driver.findElement(By.xpath("((//div[@class='sapMITBContent']//div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+slidecounter+"]//bdi[text()='Body Text'])[1]//following::a[@title='Align Left'][1]"));
													String alignLeft=leftAlign.getAttribute("class");
													WebElement centerAlign=driver.findElement(By.xpath("((//div[@class='sapMITBContent']//div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+slidecounter+"]//bdi[text()='Body Text'])[1]//following::a[@title='Center'][1]"));
													String alignCenter=centerAlign.getAttribute("class");
													WebElement rightAlign=driver.findElement(By.xpath("((//div[@class='sapMITBContent']//div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+slidecounter+"]//bdi[text()='Body Text'])[1]//following::a[@title='Align Right'][1]"));
													String alignRight=rightAlign.getAttribute("class");
													WebElement justifyAlign=driver.findElement(By.xpath("((//div[@class='sapMITBContent']//div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+slidecounter+"]//bdi[text()='Body Text'])[1]//following::a[@title='Justify'][1]"));
													String alignJustify=justifyAlign.getAttribute("class");
													if(alignLeft.contains("button_on")) {
														PermissionValue.add("Alignment:Left Align");
													}
													if(alignCenter.contains("button_on")) {
														PermissionValue.add("Alignment:Center");
													}
													if(alignRight.contains("button_on")) {
														PermissionValue.add("Alignment:Right Align");
													}
													if(alignJustify.contains("button_on")) {
														PermissionValue.add("Alignment:Justify");
													}
													countrbodytext++;

													//driver.switchTo().defaultContent();

													Thread.sleep(1000);
													//add body text in approve text with other options 
													Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
													logger.info("bodytext value with font and size values added in excel file");


												}
												else if (slidetext.equalsIgnoreCase("Background Image")&&Duplicateoptioncounter==0) {
													String selectimagetext ="";

													Slidelist.add(slidetext);
													try {
														selectimagetext = driver.findElement(By.xpath("(//div[@class='sapMITBContent']//div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+slidecounter+"]//bdi[text()='Background Image']//following::span[text()='Select Image']")).getText();
													}
													catch (Exception e) {
														imagetextvalue="On";
													}

													if(selectimagetext.isEmpty()) {	
														imagetextvalue="On"	;
													}
													else {
														imagetextvalue="Off";
													}
													PermissionHeader="";


													PermissionHeader="Slideptions";
													PermissionValue.add("Slide"+slidecounter);
													PermissionValue.add(slidetext);
													PermissionValue.add(imagetextvalue);

													Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname); 

												}
												else if (slidetext.equalsIgnoreCase("Image Position")&&Duplicateoptioncounter==0) {
													Slidelist.add(slidetext);
													imagetextvalue=driver.findElement(By.xpath("((//div[@class='sapMITBContent']//div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+slidecounter+"]//bdi[text()='Image Position'])[1]//following::span[2]")).getText();
													PermissionHeader="Slideptions";
													PermissionValue.add("Slide"+slidecounter);
													PermissionValue.add(slidetext);
													PermissionValue.add(imagetextvalue);
													Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

												}
												else if (slidetext.equalsIgnoreCase("Image Type")&&Duplicateoptioncounter>0) {
													Slidelist.add(slidetext);
													imagetextvalue=driver.findElement(By.xpath("((//div[@class='sapMITBContent']//div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+slidecounter+"]//bdi[text()='Image Type'])[2]//following::span[2]")).getText();
													PermissionHeader="Slideptions";
													PermissionValue.add("Slide"+slidecounter);
													PermissionValue.add(slidetext);
													PermissionValue.add(imagetextvalue);

													Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);


												}
												else if (slidetext.equalsIgnoreCase("Image Position")&&Duplicateoptioncounter>0) {
													Slidelist.add(slidetext);

													imagetextvalue=driver.findElement(By.xpath("((//div[@class='sapMITBContent']//div[@class='sapMPanelContent sapMPanelBGTranslucent'])["+slidecounter+"]//bdi[text()='Image Position'])[2]//following::span[2]")).getText();
													PermissionHeader="Slideptions";
													PermissionValue.add("Slide"+slidecounter);
													PermissionValue.add(slidetext);
													PermissionValue.add(imagetextvalue);
													Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

												}


											}


										}

									}
									Thread.sleep(1000);
									System.out.println();




								}
								else if (optionname.equalsIgnoreCase("Styles")) {
									slidecounter=slidecounter+1;
									WebElement imagetabelement = driver.findElement(By.xpath("(//div[@role='tablist'][contains(@id,'Form--header-head')]/div/div)[2]//parent::div[1]"));
									imagetabelement.click();
									List<WebElement> stylesoptions = imagetabelement.findElements(By.xpath("//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper']"));
									int xpathcounter = 0;
									for(int stylecounter=0;stylecounter<stylesoptions.size();stylecounter++) {
										if(stylecounter>0) {
											counterstyle=counterstyle+1;


										}


										PermissionValue=new ArrayList<String>();
										ArrayList<String>Styleoptionlist = new ArrayList<>();
										detailoptiontext = stylesoptions.get(stylecounter).getText();
										if(detailoptiontext.equals("Text")&&!Styleoptionlist.contains(detailoptiontext)) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue1 = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();

											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue1);


										}
										else if (detailoptiontext.equals("Background")&&!Styleoptionlist.contains(detailoptiontext)) {
											Styleoptionlist.add(detailoptiontext);
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue1 = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();


											PermissionHeader="";


											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue1);

										}
										else if (detailoptiontext.equalsIgnoreCase("Chevron")) {
											Styleoptionlist.add(detailoptiontext);

											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue1 = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue1);


										}
										else if (detailoptiontext.equalsIgnoreCase("Chevron Hover")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue1 = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue1);



										}
										else if (detailoptiontext.equalsIgnoreCase("Active Slide")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue1 = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue1);


										}
										else if (detailoptiontext.equalsIgnoreCase("Chevron")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue1 = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue1);


										}
										else if (detailoptiontext.equalsIgnoreCase("Slide Indicator")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue1 = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue1);


										}
										else if (detailoptiontext.equalsIgnoreCase("Link")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue1 = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue1);


										}
										else if (detailoptiontext.equalsIgnoreCase("Link Hover")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue1 = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue1);

										}
										else if (detailoptiontext.equalsIgnoreCase("Background Image")) {
											String imagestatus;
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											WebElement image = null;
											try{
												image = driver.findElement(By.xpath("//div[@class='sapMITBContainerContent']//bdi[text()='Background Image']//following::img[1]"));
											}
											catch (Exception e) {
												imagestatus="Off";
											}
											if(image.isDisplayed()) {
												imagestatus="On";
											}
											else {
												imagestatus="Off";
											}
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(imagestatus);


										}
										else if (detailoptiontext.equalsIgnoreCase("Image Type")) {	
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue1 = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue1);


										}
										else if (detailoptiontext.equalsIgnoreCase("Image Position")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue1 = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue1);

										}
										else if (detailoptiontext.equalsIgnoreCase("Enable Spacing:")) {
											String EnableSpacing="";
											xpathcounter=xpathcounter+1;
											Styleoptionlist.add(detailoptiontext);
											WebElement switchobj = driver.findElement(By.xpath("//bdi[text()='Enable Spacing:'][1]/following::div[2]//div[@role='switch']"));
											String switchvalue = switchobj.getAttribute("aria-checked");
											if(switchvalue.equals("true")) {
												EnableSpacing = "On";
											}
											else {
												EnableSpacing = "Off";
											}

											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(EnableSpacing);
										}



										else if (detailoptiontext.equalsIgnoreCase("Top")) {
											Styleoptionlist.add(detailoptiontext);
											List<WebElement> valueoptions = imagetabelement.findElements(By.xpath("//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper']"));
											PermissionValue=new ArrayList<String>();
											ArrayList<String>Styvalueleoptionlist1 = new ArrayList<>();

											int duplicatepermissionno=0;
											for(int approvetextcounter=0;approvetextcounter<valueoptions.size();approvetextcounter++) {

												String detailvaluetext = valueoptions.get(approvetextcounter).getText();
												if (detailvaluetext.equalsIgnoreCase("Top")) {
													xpathcounter=xpathcounter+1;
													PermissionValue=new ArrayList<>();

													String Topvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="ApprovedText";

													PermissionValue.add(detailoptiontext+":"+Topvalue);


												}
												else if (detailvaluetext.equalsIgnoreCase("Bottom")) {
													xpathcounter=xpathcounter+1;

													String Bottomvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Bottomvalue);

												}
												else if (detailvaluetext.equalsIgnoreCase("Right")) {
													xpathcounter=xpathcounter+1;

													String Rightvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Rightvalue);


												}
												else if (detailvaluetext.equalsIgnoreCase("Left")) {
													xpathcounter=xpathcounter+1;							 
													String Leftvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Leftvalue);


												}
											}

										}

										if(!PermissionValue.isEmpty()) {
											//add options from style
											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

										}


									}
									Thread.sleep(1000);
									System.out.println();





								}




							}
							boolean homeelement=helper.waitForClickable(CSB.HomeLink);
							if(homeelement) {


								CSB.HomeLink.click();
								Thread.sleep(3000);
								logger.info("Image and Text Carousel execution completed");

							}


						} catch (Exception e) {
							logger.info("Image and Text Carousel execution Failed");
							logger.info(e.getStackTrace());
						}
					}

					else if (permissionLabel.equalsIgnoreCase("Custom Plugin")&&duplicatecounter==0) {
						logger.info("Custom Plugin execution started");
						try {					
							duplicatepermission.add(permissionLabel);
							PermissioncounterList.add(permissionCounter);
							WebElement HelpWindow;

							radioselected = false;
							PermissionHeader="Permissions";	
							System.out.println("Permission " + permissionCounter+ " : "+permissionLabel);
							//add permissionton the excel			
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue,Permissionname);
							logger.info("Permission is added in excel file");
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";

							counter=0;	
							List<WebElement> availablePermissions = driver.findElements(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
							ArrayList checkboxlist = new ArrayList<>();
							for(WebElement roleoptions : availablePermissions) {
								if(checkboxlist.size()==3) {
									break;
								}
								//driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')]["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
								permissionvalue="";
								permissionvalue=roleoptions.getText();


								if(permissionvalue.equalsIgnoreCase("Desktop")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][1]//ancestor::div[1]"));
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										checkboxlist.add(permissionvalue);
										counter++;

									}
									else {
										Status = "Off";
										counter=0;
										checkboxlist.add(permissionvalue);
										break;
									}


								}
								else if (permissionvalue.equalsIgnoreCase("Tablet")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][2]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;

									}

								}
								else if (permissionvalue.equalsIgnoreCase("Mobile")) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][3]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;


									}

								}

								PermissionHeader="";
								PermissionValue=new ArrayList<String>();
								PermissionHeader="RoleOptions";
								PermissionValue.add(permissionvalue);
								PermissionValue.add(Status);

								//add allcheckboxstatus
								Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
								logger.info("Checbox value" +PermissionValue+" added in excel file");				
							}
							//To add settings value
							PermissionHeader="";
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";
							PermissionValue.add("Settings");
							PermissionValue.add(Status);
							//add settingscheckboxstatus
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							logger.info("Checbox value for settings added in excel file");

							WebElement Tile = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
							try {
								wait.until(ExpectedConditions.elementToBeClickable(Tile));
							}
							catch (Exception e) {
								Tile = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
								while(Tile.equals(null)) {
									Thread.sleep(10);
								}
							}
							Tile.click();
							Thread.sleep(5000);




							try {
								HelpWindow=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Help Window']")));


							}
							catch (Exception e) {
								HelpWindow=null;
							}
							if(!HelpWindow.equals(null)) {
								driver.findElement(By.xpath("//bdi[text()='Ok']//ancestor::button[1]")).click();
							}
							String inputvalue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@name='customText']"))).getText();

							PermissionHeader="";
							PermissionHeader="Refertext";

							PermissionValue.add(inputvalue);
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							boolean homeelement=helper.waitForClickable(CSB.HomeLink);
							if(homeelement) {

								CSB.HomeLink.click();
								Thread.sleep(3000);
								logger.info("Custom Plugin execution completed");
							}





						} catch (Exception e) {
							logger.info("Custom Plugin execution Failed");
							logger.info(e.getStackTrace());
						}
					}
					else if (permissionLabel.equalsIgnoreCase("Large Image")&&duplicatecounter==0) {
						try {

							logger.info("Large Image executionstarted");
							duplicatepermission.add(permissionLabel);
							PermissioncounterList.add(permissionCounter);
							WebElement HelpWindow;

							radioselected = false;
							PermissionHeader="Permissions";	
							System.out.println("Permission " + permissionCounter+ " : "+permissionLabel);
							//add permissionton the excel			
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue,Permissionname);
							logger.info("Permission is added in excel file");
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";

							counter=0;	
							List<WebElement> availablePermissions = driver.findElements(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
							ArrayList checkboxlist = new ArrayList<>();
							for(WebElement roleoptions : availablePermissions) {
								if(checkboxlist.size()==3) {
									break;
								}
								//driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')]["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
								permissionvalue="";
								permissionvalue=roleoptions.getText();


								if(permissionvalue.equalsIgnoreCase("Desktop")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][1]//ancestor::div[1]"));
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										checkboxlist.add(permissionvalue);
										counter++;

									}
									else {
										Status = "Off";
										counter=0;
										checkboxlist.add(permissionvalue);
										break;
									}


								}
								else if (permissionvalue.equalsIgnoreCase("Tablet")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][2]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;

									}

								}
								else if (permissionvalue.equalsIgnoreCase("Mobile")) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][3]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;


									}

								}

								PermissionHeader="";
								PermissionValue=new ArrayList<String>();
								PermissionHeader="RoleOptions";
								PermissionValue.add(permissionvalue);
								PermissionValue.add(Status);

								//add allcheckboxstatus
								Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
								logger.info("Checbox value" +PermissionValue+" added in excel file");				
							}
							//To add settings value
							PermissionHeader="";
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";
							PermissionValue.add("Settings");
							PermissionValue.add(Status);
							//add settingscheckboxstatus
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							logger.info("Checbox value for settings added in excel file");

							WebElement Tile = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
							try {
								wait.until(ExpectedConditions.elementToBeClickable(Tile));
							}
							catch (Exception e) {
								Tile = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
								while(Tile.equals(null)) {
									Thread.sleep(10);
								}
							}
							Tile.click();
							Thread.sleep(5000);
							List<WebElement> differntopt = driver.findElements(By.xpath("//span[@class='sapMLabelTextWrapper']"));
							PermissionValue= new ArrayList<>();
							int valuecounter = 0;
							int xpathcounter = 0;
							for(WebElement wb:differntopt) {
								if(valuecounter==5) {
									break;
								}
								String detailoptiontext = wb.getText();

								if(detailoptiontext.equalsIgnoreCase("Background Image")) {
									PermissionValue= new ArrayList<>();
									String detailoptiontextvalue = "";
									String backgroundimgstatus = wb.findElement(By.xpath("//following::img[1]")).getAttribute("src");
									if(backgroundimgstatus.isEmpty()) {
										detailoptiontextvalue = "Off";
									}
									else {
										detailoptiontextvalue="On";
									}
									PermissionHeader="";
									PermissionHeader="Detailsoptions";
									PermissionValue.add(detailoptiontext);
									PermissionValue.add(detailoptiontextvalue);
									valuecounter++;

								}
								else if (detailoptiontext.equalsIgnoreCase("Image Type")) {
									PermissionValue= new ArrayList<>();
									String detailoptiontextvalue = driver.findElement(By.xpath("(//span[@class='sapMSelectListItemText'])[1]")).getText();
									PermissionHeader="";
									PermissionHeader="Detailsoptions";
									PermissionValue.add(detailoptiontext);
									PermissionValue.add(detailoptiontextvalue);
									valuecounter++;


								}
								else if (detailoptiontext.equalsIgnoreCase("Image Position")) {
									PermissionValue= new ArrayList<>();
									String detailoptiontextvalue = driver.findElement(By.xpath("(//span[@class='sapMSelectListItemText'])[2]")).getText();
									PermissionHeader="";
									PermissionHeader="Detailsoptions";
									PermissionValue.add(detailoptiontext);
									PermissionValue.add(detailoptiontextvalue);
									valuecounter++;



								}
								else if (detailoptiontext.equalsIgnoreCase("Max Height of Image")) {
									PermissionValue= new ArrayList<>();
									String detailoptiontextvalue = driver.findElement(By.xpath("//input[@name='height']")).getAttribute("value");
									PermissionHeader="";
									PermissionHeader="Detailsoptions";
									PermissionValue.add(detailoptiontext);
									PermissionValue.add(detailoptiontextvalue);
									valuecounter++;


								}
								else if (detailoptiontext.equalsIgnoreCase("Enable Spacing:")) {
									PermissionValue= new ArrayList<>();
									String detailoptiontextvalue = driver.findElement(By.xpath("//div[@class='sapMSwt sapMSwtTrans sapMSwtOff sapMSwtDefault sapMSwtHoverable']")).getAttribute("class");
									if(detailoptiontextvalue.contains("sapMSwtOn")) {
										detailoptiontextvalue="On";
									}
									else {
										detailoptiontextvalue="Off";
									}
									PermissionHeader="";
									PermissionHeader="Detailsoptions";
									PermissionValue.add(detailoptiontext);
									PermissionValue.add(detailoptiontextvalue);
									valuecounter++;


								}
								else if (detailoptiontext.equalsIgnoreCase("Top")) {
									List<WebElement> valueoptions = driver.findElements(By.xpath("//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper']"));
									PermissionValue=new ArrayList<String>();
									ArrayList<String>Styvalueleoptionlist1 = new ArrayList<>();

									int duplicatepermissionno=0;
									for(int approvetextcounter=0;approvetextcounter<valueoptions.size();approvetextcounter++) {

										String detailvaluetext = valueoptions.get(approvetextcounter).getText();
										if (detailvaluetext.equalsIgnoreCase("Top")) {
											xpathcounter=xpathcounter+1;
											PermissionValue=new ArrayList<>();

											String Topvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
											PermissionHeader="";
											PermissionHeader="ApprovedText";

											PermissionValue.add(detailoptiontext+":"+Topvalue);


										}
										else if (detailvaluetext.equalsIgnoreCase("Bottom")) {
											xpathcounter=xpathcounter+1;

											String Bottomvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
											PermissionHeader="";
											PermissionHeader="Refertext";

											PermissionValue.add(detailvaluetext+":"+Bottomvalue);

										}
										else if (detailvaluetext.equalsIgnoreCase("Right")) {
											xpathcounter=xpathcounter+1;

											String Rightvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
											PermissionHeader="";
											PermissionHeader="Refertext";

											PermissionValue.add(detailvaluetext+":"+Rightvalue);


										}
										else if (detailvaluetext.equalsIgnoreCase("Left")) {
											xpathcounter=xpathcounter+1;							 
											String Leftvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
											PermissionHeader="";
											PermissionHeader="Refertext";

											PermissionValue.add(detailvaluetext+":"+Leftvalue);


										}
									}

								}

								if(!PermissionValue.isEmpty()) {
									//add options from style
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

								}


							}
							boolean homeelement=helper.waitForClickable(CSB.HomeLink);
							if(homeelement) {

								CSB.HomeLink.click();
								Thread.sleep(3000);
								logger.info("Large Image executioncompleted");

							}




						} catch (Exception e) {
							logger.info("Large Image execution Failed");
							logger.info(e.getStackTrace());
						}
					}
					else if (permissionLabel.equalsIgnoreCase("Two Columns")&&duplicatecounter==0) {
						try {

							logger.info("Info and Two Columns executionstarted");
							duplicatepermission.add(permissionLabel);
							PermissioncounterList.add(permissionCounter);
							WebElement HelpWindow;

							radioselected = false;
							PermissionHeader="Permissions";	
							System.out.println("Permission " + permissionCounter+ " : "+permissionLabel);
							//add permissionton the excel			
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue,Permissionname);
							logger.info("Permission is added in excel file");
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";

							counter=0;	
							List<WebElement> availablePermissions = driver.findElements(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
							ArrayList checkboxlist = new ArrayList<>();
							for(WebElement roleoptions : availablePermissions) {
								if(checkboxlist.size()==3) {
									break;
								}
								//driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')]["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
								permissionvalue="";
								permissionvalue=roleoptions.getText();


								if(permissionvalue.equalsIgnoreCase("Desktop")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][1]//ancestor::div[1]"));
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										checkboxlist.add(permissionvalue);
										counter++;

									}
									else {
										Status = "Off";
										counter=0;
										checkboxlist.add(permissionvalue);
										break;
									}


								}
								else if (permissionvalue.equalsIgnoreCase("Tablet")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][2]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;

									}

								}
								else if (permissionvalue.equalsIgnoreCase("Mobile")) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][3]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;


									}

								}

								PermissionHeader="";
								PermissionValue=new ArrayList<String>();
								PermissionHeader="RoleOptions";
								PermissionValue.add(permissionvalue);
								PermissionValue.add(Status);

								//add allcheckboxstatus
								Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
								logger.info("Checbox value" +PermissionValue+" added in excel file");				
							}
							//To add settings value
							PermissionHeader="";
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";
							PermissionValue.add("Settings");
							PermissionValue.add(Status);
							//add settingscheckboxstatus
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							logger.info("Checbox value for settings added in excel file");

							WebElement Tile = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
							try {
								wait.until(ExpectedConditions.elementToBeClickable(Tile));
							}
							catch (Exception e) {
								Tile = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
								while(Tile.equals(null)) {
									Thread.sleep(10);
								}
							}
							Tile.click();

							Thread.sleep(5000);
							try {
								WebElement headertext = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//bdi[text()='Header Text']"))));
							}
							catch (Exception e) {
								//ifheaderText is not seen
								//driver.findElement(By.xpath("(//div[@role='tablist']/div/div/div/span[text()='Details'])[2]//ancestor::div[1]")).click();
								WebElement headertext = driver.findElement(By.xpath("//bdi[text()='Header Text']"));
								while(headertext.equals(null)) {
									Thread.sleep(10);
								}
							}

							String label = driver.findElement(By.xpath("//bdi[text()='Header Text']")).getText();
							PermissionHeader="";
							PermissionValue=new ArrayList<String>();
							PermissionHeader="AddHeaderText";			
							PermissionValue.add("Details");
							PermissionValue.add(label);


							WebElement text = driver.findElement(By.xpath("//input[@class='sapMInputBaseInner']"));
							textvalue = text.getAttribute("value");			
							if(!textvalue.isEmpty()) {
								headertextstatus = "On";
							}
							else {
								headertextstatus="Off";
							}
							PermissionValue.add(headertextstatus);

							//AddHeadertextvalue
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							Thread.sleep(2000);
							PermissionValue=new ArrayList<String>();
							PermissionValue.add(textvalue);
							driver.findElement(By.xpath("//button[@title='Open Styling']")).click();
							List<WebElement> fontoptions = driver.findElements(By.xpath("//div[@class='sapMDialogScroll']//child::div[contains(@class,'sapUiRespGridMedia-Std-Phone')]/div/label"));
							ArrayList fonttextlist = new ArrayList<>();
							String headerinput="";
							String inputvalue ="";
							int hedertextno=0;
							for(WebElement fontopt:fontoptions) {
								String fontopttext = "";
								fontopttext = fontopt.getText();
								if(fontopttext.equalsIgnoreCase("Font")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement font = driver.findElement(By.xpath("//bdi[text()='Font']//following::div[1]//span[@class='sapMSelectListItemText']"));
									inputvalue = font.getText();
									headerinput = "Font";
									fonttextlist.add(fontopttext);
									countheadertext++;
								}
								else if (fontopttext.equalsIgnoreCase("Size")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement size = driver.findElement(By.xpath("//bdi[text()='Size']//following::div[3]//input[@name='headerTextSize']"));
									inputvalue = size.getAttribute("value");
									headerinput = "Size";
									fonttextlist.add(fontopttext);
								}
								else if (fontopttext.equalsIgnoreCase("Alignment")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement Alignment = driver.findElement(By.xpath("//bdi[text()='Alignment']//following::div[1]//input[@name='headerTextAlignment']"));
									inputvalue = Alignment.getAttribute("value");
									headerinput = "Alignment";
									fonttextlist.add(fontopttext);
									countheadertext++;

								}
								else if (fontopttext.equalsIgnoreCase("Color")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement color = fontopt.findElement(By.xpath("//bdi[text()='Color:']//following::div[2]//bdi[contains(@id,'colorPaletteControl')]"));
									inputvalue = color.getText();
									headerinput = "Color";
									fonttextlist.add(fontopttext);
									PermissionValue.add(headerinput+":"+inputvalue);
									countheadertext++;

								}
								else if (fontopttext.equalsIgnoreCase("Hide Header Text")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement Alignment = driver.findElement(By.xpath("//bdi[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));
									headerinput = "HideHeaderText";
									WebElement HideHeader = driver.findElement(By.xpath("//*[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));
									String HideHeaderstatus = HideHeader.getAttribute("aria-checked");
									if(HideHeaderstatus.equals("true")) {
										inputvalue = "Yes";
									}
									else {
										inputvalue = "No";
									}
									fonttextlist.add(fontopttext);
								}
								PermissionHeader="";

								PermissionHeader="HeaderText";

								PermissionValue.add(headerinput+":"+inputvalue);

								//add fontvalues;
								//Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

							}
							inputvalue = driver.findElement(By.xpath("//*[text()='Color:']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText();

							headerinput=driver.findElement(By.xpath("//bdi[text()='Color:']")).getText();
							PermissionHeader="";

							//add colour value
							PermissionHeader="HeaderText";
							PermissionValue.add(headerinput+":"+inputvalue);
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							Thread.sleep(3000);
							driver.findElement(By.xpath("//bdi[text()='Close']//ancestor::button[1]")).click();
							Thread.sleep(3000);
							//image section option			
							List<WebElement> imageCarouseloptions = driver.findElements(By.xpath("//div[@role='tablist']/div/div/div/span"));
							int size=imageCarouseloptions.size();
							int columncounter=0;
							for(int optioncounter=0;optioncounter<imageCarouseloptions.size();optioncounter++) {
								String optionname = imageCarouseloptions.get(optioncounter).getText();
								if(optionname.equalsIgnoreCase("Details")) {
									columncounter=columncounter+1;

									inputvalue = driver.findElement(By.xpath("//bdi[text()='Body Text']")).getText();


									WebElement bodytextframe = driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor')]"));
									driver.switchTo().frame(bodytextframe);
									String bodyparatextinput = driver.findElement(By.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke')]/h3")).getText();
									if(!bodyparatextinput.isEmpty()) {
										headertextstatus = "On";
									}
									else {
										headertextstatus="Off";
									}
									PermissionHeader="";
									PermissionValue= new ArrayList<>();
									PermissionHeader="BodyText";
									PermissionValue.add(headertextstatus);
									countrbodytext=0;
									//Add body Text on off condition
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									bodyparatextinput = driver.findElement(By.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke')]/h3")).getText();
									PermissionHeader="";
									PermissionValue=new ArrayList<String>();
									PermissionHeader="BodyText";
									PermissionValue.add(bodyparatextinput);
									Thread.sleep(3000);
									driver.switchTo().defaultContent();
									driver.findElement(By.xpath("(//*[text()='Body Text']/following::div[3]//following::span[5]//a[@class='cke_button cke_button__openstylebutton cke_button_off'])[1]")).click();
									Thread.sleep(5000);
									PermissionValue.add("Font:"+driver.findElement(By.xpath("//*[text()='Font']//following::div/div/span[@class='sapMSltLabel']//span[@class='sapMSelectListItemText']")).getText());
									PermissionValue.add("Size:"+driver.findElement(By.xpath("//*[text()='Size']//following::div[3]/input[@role='combobox']")).getAttribute("value"));
									Thread.sleep(2000);
									driver.findElement(By.xpath("//*[text()='Close']//parent::span//parent::span//parent::button")).click();
									Thread.sleep(3000);
									PermissionValue.add("Paragraph Format:"+driver.findElement(By.xpath("(//*[text()='Body Text']//following::a[@title='Paragraph Format'])[1]")).getText());
									WebElement leftAlign=driver.findElement(By.xpath("(//a[@title='Align Left'])[1]"));
									String alignLeft=leftAlign.getAttribute("class");
									WebElement centerAlign=driver.findElement(By.xpath("(//a[@title='Center'])[1]"));
									String alignCenter=centerAlign.getAttribute("class");
									WebElement rightAlign=driver.findElement(By.xpath("(//a[@title='Align Right'])[1]"));
									String alignRight=rightAlign.getAttribute("class");
									WebElement justifyAlign=driver.findElement(By.xpath("(//a[@title='Justify'])[1]"));
									String alignJustify=justifyAlign.getAttribute("class");
									if(alignLeft.contains("button_on")) {
										PermissionValue.add("Alignment:Left Align");
									}
									if(alignCenter.contains("button_on")) {
										PermissionValue.add("Alignment:Center");
									}
									if(alignRight.contains("button_on")) {
										PermissionValue.add("Alignment:Right Align");
									}
									if(alignJustify.contains("button_on")) {
										PermissionValue.add("Alignment:Justify");
									}
									countrbodytext++;

									//driver.switchTo().defaultContent();

									Thread.sleep(1000);
									//add body text in approve text with other options 
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									logger.info("bodytext value with foint and size values added in excel file");



								}
								else if (optionname.equalsIgnoreCase("Styles")) {
									counterstyle=0;
									columncounter=columncounter+1;
									WebElement optionelement = driver.findElement(By.xpath("(//div[@class='sapMITBHead'])[1]/div[@class='sapMITBItem sapMITBItemNoCount sapMITBVertical sapMITBFilter sapMITBFilterDefault']"));
									optionelement.click();
									List<WebElement> stylesoptions = optionelement.findElements(By.xpath("//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper']"));
									int xpathcounter = 0;
									for(int stylecounter=0;stylecounter<stylesoptions.size();stylecounter++) {
										if(stylecounter>0) {
											counterstyle=counterstyle+1;


										}


										PermissionValue=new ArrayList<String>();
										ArrayList<String>Styleoptionlist = new ArrayList<>();
										String detailoptiontext = stylesoptions.get(stylecounter).getText();
										if(detailoptiontext.equals("Background")&&!Styleoptionlist.contains(detailoptiontext)) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();


											PermissionHeader="";


											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);

										}
										else if (detailoptiontext.equalsIgnoreCase("Body Text")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Link")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);



										}
										else if (detailoptiontext.equalsIgnoreCase("Link Hover")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Background Image")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											WebElement imageele;
											String imagevalue = "";
											try {
												imageele = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])[5]//following::img[1]"));
											}
											catch (Exception e) {
												imageele=null;
											}
											if(imageele.isDisplayed()&&!imageele.equals(null)) {
												imagevalue="On";
											}
											else {
												imagevalue="Off";
											}
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(imagevalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Image Type")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])[6]//following::span[@class='sapMSelectListItemText'][1]")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Image Position")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											String detailoptiontextvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);

										}
										else if (detailoptiontext.equalsIgnoreCase("Refine Image Alignment:")) {
											String RefineImageAlignment = "";
											String switchvalue="";
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											try {
												WebElement switchobj = driver.findElement(By.xpath("//bdi[text()='Refine Image Alignment:']/following::div[2][@role='switch']"));
												switchvalue = switchobj.getAttribute("aria-checked");
											}
											catch (Exception e) {
												switchvalue="Off";
											}
											if(switchvalue.equals("true")) {
												RefineImageAlignment = "On";
											}
											else {
												RefineImageAlignment = "Off";
											}
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(RefineImageAlignment);


										}
										else if (detailoptiontext.equalsIgnoreCase("Enable Spacing:")) {
											String EnableSpacing="";
											xpathcounter=xpathcounter+1;
											Styleoptionlist.add(detailoptiontext);
											WebElement switchobj = driver.findElement(By.xpath("(//*[text()='Enable Spacing:']/following::div[2]//div[@role='switch'])[1]"));
											String switchvalue = switchobj.getAttribute("aria-checked");
											if(switchvalue.equals("true")) {
												EnableSpacing = "On";
											}
											else {
												EnableSpacing = "Off";
											}

											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(EnableSpacing);


										}
										else if (detailoptiontext.equalsIgnoreCase("Top")) {
											List<WebElement> valueoptions = optionelement.findElements(By.xpath("//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper']"));
											PermissionValue=new ArrayList<String>();
											ArrayList<String>Styvalueleoptionlist1 = new ArrayList<>();

											int duplicatepermissionno=0;
											for(int approvetextcounter=0;approvetextcounter<valueoptions.size();approvetextcounter++) {

												String detailvaluetext = valueoptions.get(approvetextcounter).getText();
												if (detailvaluetext.equalsIgnoreCase("Top")) {
													xpathcounter=xpathcounter+1;
													PermissionValue=new ArrayList<>();

													String Topvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="ApprovedText";

													PermissionValue.add(detailoptiontext+":"+Topvalue);


												}
												else if (detailvaluetext.equalsIgnoreCase("Bottom")) {
													xpathcounter=xpathcounter+1;

													String Bottomvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Bottomvalue);

												}
												else if (detailvaluetext.equalsIgnoreCase("Right")) {
													xpathcounter=xpathcounter+1;

													String Rightvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Rightvalue);


												}
												else if (detailvaluetext.equalsIgnoreCase("Left")) {
													xpathcounter=xpathcounter+1;							 
													String Leftvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Leftvalue);


												}
											}

										}

										if(!PermissionValue.isEmpty()) {
											//add options from style
											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

										}


									}
									Thread.sleep(1000);
									System.out.println();




								}



							}

							boolean homeelement=helper.waitForClickable(CSB.HomeLink);
							if(homeelement) {

								CSB.HomeLink.click();
								Thread.sleep(3000);
								logger.info("Info and Two Columns executioncompleted");

							}

						} catch (Exception e) {
							logger.info("Info and Two Columns execution Failed");
							logger.info(e.getStackTrace());
						}
					}
					else if (permissionLabel.equalsIgnoreCase("Subscribe Form")&&duplicatecounter==0) {
						PermissioncounterList.add(permissionCounter);
						logger.info("Subscribe form execution started");
						try {
							WebElement subscribeForm=driver.findElement(By.xpath("//*[text()='Subscribe Form']//following::div[10]//img[@role='button']"));//Subscribe Form Tile
							subscribeForm.click();
							Thread.sleep(10000);
							WebElement subscribeFormHeader=driver.findElement(By.xpath("//*[text()='Header Text']//following::div[3]//input[@placeholder='Header Text']"));//Header Text
							ArrayList<String> subscribeHeader=new ArrayList<String>();
							ArrayList<String>subscribeFormTopics=new ArrayList<String>();
							subscribeFormTopics.add("Subscribe Form Header");
							subscribeFormTopics.add("Subscribe Form Header Text");
							subscribeFormTopics.add("Subscribe Form Body Text");
							subscribeFormTopics.add("Subscribe Form Show Email Label");
							subscribeFormTopics.add("Subscribe Form Label Text");
							subscribeFormTopics.add("Subscribe Form Show PlaceHolder Text");
							subscribeFormTopics.add("Subscribe Form Button Text");
							String SubSrno = Integer.toString(permissionCounter);
							ArrayList<String>checkboxSubscribe=new ArrayList<String>();
							checkboxSubscribe.add(SubSrno);
							checkboxSubscribe.add(driver.findElement(By.xpath("//*[text()='Subscribe Form']//following::div[@role='checkbox'][1]")).getAttribute("aria-checked"));
							checkboxSubscribe.add(driver.findElement(By.xpath("//*[text()='Subscribe Form']//following::div[@role='checkbox'][2]")).getAttribute("aria-checked"));
							checkboxSubscribe.add(driver.findElement(By.xpath("//*[text()='Subscribe Form']//following::div[@role='checkbox'][3]")).getAttribute("aria-checked"));
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "Subscribe Form Header", checkboxSubscribe, subscribeFormTopics);
							subscribeHeader.add(subscribeFormHeader.getAttribute("value"));
							Thread.sleep(5000);
							driver.findElement(By.xpath("//*[text()='Header Text']//following::div[4]//button[@title='Open Styling']")).click();//Open Styling of Header Text
							Thread.sleep(5000);
							WebElement subscribeFormHeaderfont=driver.findElement(By.xpath("//*[text()='Font']/following::div[1]//span[@class='sapMSelectListItemText']"));//Font inside Header Text Styling
							subscribeHeader.add("Font:"+subscribeFormHeaderfont.getText());
							WebElement subscribeFormHeaderSize=driver.findElement(By.xpath("//*[text()='Size']//following::div[3]//input[@name='headerTextSize']"));//Size inside Header Text Styling
							subscribeHeader.add("Size:"+subscribeFormHeaderSize.getAttribute("value"));
							WebElement subscribeFormHeaderAlignment=driver.findElement(By.xpath("//*[text()='Alignment']/following::div[1]//input[@name='headerTextAlignment']"));//Alignment inside Header Text Styling
							subscribeHeader.add("Alignment:"+subscribeFormHeaderAlignment.getAttribute("value"));
							WebElement subscribeFormHeaderColor=driver.findElement(By.xpath("//*[text()='Color:']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]"));//Color inside Header Text Styling
							subscribeHeader.add("Color:"+subscribeFormHeaderColor.getText());
							WebElement subscribeFormHeaderHide=driver.findElement(By.xpath("//*[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));//Hide Header Text button inside Header Text Styling
							String hideattr=subscribeFormHeaderHide.getAttribute("aria-checked");
							String switchRes="";
							if(hideattr.equalsIgnoreCase("false"))
								switchRes="No";
							else
								switchRes="Yes";
							subscribeHeader.add("Hide Header Text:"+switchRes);
							System.out.println(subscribeHeader);
							driver.findElement(By.xpath("//*[text()='Close']//ancestor::button")).click();
							Thread.sleep(5000);
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "Subscribe Form Header Text", subscribeHeader, subscribeFormTopics);


							WebElement subscribeFormBodyText=driver.findElement(By.xpath("//*[text()='Body Text']//following::div[4]//iframe"));
							driver.switchTo().frame(subscribeFormBodyText);
							Thread.sleep(8000);
							ArrayList<String>subscribeBodyText=new ArrayList<String>();
							subscribeBodyText.add(driver.findElement(By.xpath("/html/body/p")).getText());
							driver.switchTo().parentFrame();
							Thread.sleep(8000);
							driver.findElement(By.xpath("//*[text()='Body Text']/following::div[3]//following::span[5]//a[@class='cke_button cke_button__openstylebutton cke_button_off']")).click();
							Thread.sleep(10000);
							subscribeBodyText.add("Font:"+driver.findElement(By.xpath("//*[text()='Font']//following::div/div/span[@class='sapMSltLabel']//span[@class='sapMSelectListItemText']")).getText());
							subscribeBodyText.add("Size:"+driver.findElement(By.xpath("//*[text()='Size']//following::div[3]/input[@role='combobox']")).getAttribute("value"));
							driver.findElement(By.xpath("//*[text()='Close']//parent::span//parent::span//parent::button")).click();
							Thread.sleep(5000);
							subscribeBodyText.add("Paragraph Format:"+driver.findElement(By.xpath("//*[text()='Body Text']//following::div//following::span[@role='presentation']//a[@title='Paragraph Format']//span[@class='cke_combo_text']")).getText());
							WebElement leftAlign=driver.findElement(By.xpath("//*[text()='Body Text']//following::div//following::span[@role='presentation']//span[@role='presentation'][@class='cke_toolgroup']//a[@title='Align Left']"));
							String alignLeft=leftAlign.getAttribute("class");
							WebElement centerAlign=driver.findElement(By.xpath("//*[text()='Body Text']//following::div//following::span[@role='presentation']//span[@role='presentation'][@class='cke_toolgroup']//a[@title='Center']"));
							String alignCenter=centerAlign.getAttribute("class");
							WebElement rightAlign=driver.findElement(By.xpath("//*[text()='Body Text']//following::div//following::span[@role='presentation']//span[@role='presentation'][@class='cke_toolgroup']//a[@title='Align Right']"));
							String alignRight=rightAlign.getAttribute("class");
							WebElement justifyAlign=driver.findElement(By.xpath("//*[text()='Body Text']//following::div//following::span[@role='presentation']//span[@role='presentation'][@class='cke_toolgroup']//a[@title='Justify']"));
							String alignJustify=justifyAlign.getAttribute("class");
							if(alignLeft.contains("button_on")) {
								subscribeBodyText.add("Alignment:Left Align");
							}
							if(alignCenter.contains("button_on")) {
								subscribeBodyText.add("Alignment:Center");
							}
							if(alignRight.contains("button_on")) {
								subscribeBodyText.add("Alignment:Right Align");
							}
							if(alignJustify.contains("button_on")) {
								subscribeBodyText.add("Alignment:Justify");
							}
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "Subscribe Form Body Text", subscribeBodyText, subscribeFormTopics);
							System.out.println(subscribeBodyText);
							Thread.sleep(5000);
							WebElement subscribeFormShowEmailLabel=driver.findElement(By.xpath("//*[text()='Show E-mail Label']//following::div[@role='switch'][1]"));//Show E-mail Label
							ArrayList<String>subscribeShowEmailLabel=new ArrayList<String>();
							subscribeShowEmailLabel.add(subscribeFormShowEmailLabel.getAttribute("aria-checked"));
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "Subscribe Form Show Email Label", subscribeShowEmailLabel, subscribeFormTopics);
							System.out.println(subscribeShowEmailLabel);
							WebElement subscribeFormLabelText=driver.findElement(By.xpath("//*[text()='Label Text']//following::div//input[@placeholder='Label Text']"));//Label Text
							ArrayList<String>subscribeLabelText=new ArrayList<String>();
							subscribeLabelText.add(subscribeFormLabelText.getAttribute("value"));
							driver.findElement(By.xpath("//*[text()='Label Text']//following::div[4]/button[@title='Open Styling']")).click();//Clicking on open styling in Label Text
							Thread.sleep(5000);
							String subscribeLabelStylingFont=driver.findElement(By.xpath("//*[text()='Font']//following::div/span[@class='sapMSltLabel']//following::span")).getText();//Font inside Label Text Styling
							subscribeLabelText.add("Font:"+subscribeLabelStylingFont);
							String subscribeLabelStylingSize=driver.findElement(By.xpath("//*[text()='Size']//following::div/input[@name='emailLabelTextSize']")).getAttribute("value");//Size inside Label Text Styling
							subscribeLabelText.add("Size:"+subscribeLabelStylingSize);
							driver.findElement(By.xpath("//*[text()='Close']//ancestor::button")).click();
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "Subscribe Form Label Text", subscribeLabelText, subscribeFormTopics);
							Thread.sleep(5000);
							WebElement subscribeFormPlaceHolderText=driver.findElement(By.xpath("//*[text()='Placeholder Text']//ancestor::div[2]//input[@placeholder='Placeholder Text']"));//PlaceHolder Text
							ArrayList<String>subscribePlaceHolderText=new ArrayList<String>();
							subscribePlaceHolderText.add(subscribeFormPlaceHolderText.getAttribute("value"));
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "Subscribe Form Show PlaceHolder Text", subscribePlaceHolderText, subscribeFormTopics);
							System.out.println(subscribePlaceHolderText);
							ArrayList<String>subscribeButtonText=new ArrayList<String>();
							WebElement subscribeFormButtonText=driver.findElement(By.xpath("//*[text()='Button Text']//ancestor::div[1]//following::div//input[@placeholder='Button Text']"));//Button Text
							subscribeButtonText.add(subscribeFormButtonText.getAttribute("value"));
							driver.findElement(By.xpath("//*[text()='Button Text']//ancestor::div//div[last()]/button[@title='Open Styling']")).click();//Button Text styling
							Thread.sleep(5000);
							String subscribeButtonTextStylingFont=driver.findElement(By.xpath("//*[text()='Font']//following::div[@role='combobox'][1]//span[@class='sapMSltLabel'][1]//following::input[@name='buttonTextFont']")).getAttribute("value");//Font inside Button Text styling
							String subscribeButtonTextStylingSize=driver.findElement(By.xpath("//*[text()='Size']//following::div//input[@role='combobox']")).getAttribute("value");//Size inside Button Text styling
							subscribeButtonText.add("Font:"+subscribeButtonTextStylingFont);
							subscribeButtonText.add("Size:"+subscribeButtonTextStylingSize);
							System.out.println(subscribeButtonText);
							driver.findElement(By.xpath("//*[text()='Close']//ancestor::button")).click();
							Thread.sleep(5000);
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "Subscribe Form Button Text", subscribeButtonText, subscribeFormTopics);
							ArrayList<String> subscribeStyle=new ArrayList<String>();
							driver.findElement(By.xpath("//*[text()='Styles']//following::div[@class='sapMITBHead']/div[@role='tab'][2]//span[text()='Styles']")).click();
							Thread.sleep(5000);
							subscribeStyle.add(driver.findElement(By.xpath("//*[text()='Body Background']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText());
							subscribeStyle.add(driver.findElement(By.xpath("//*[text()='Background']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText());
							subscribeStyle.add(driver.findElement(By.xpath("//*[text()='Body Text']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText());
							String lh="";
							lh=driver.findElement(By.xpath("//*[text()='Link Hover']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText();
							if(lh.length()>2) {
								subscribeStyle.add(lh);
							}
							else {
								subscribeStyle.add("Off");
							}

							try {
								String val=driver.findElement(By.xpath("//*[text()='Background Image']//following::div[1]//img")).getAttribute("src");
								subscribeStyle.add("On");
							}
							catch(Exception e) {
								subscribeStyle.add("Off");
							}

							subscribeStyle.add(driver.findElement(By.xpath("//*[text()='Image Type']//following::div[1]//span[1]//span[2]")).getText());
							subscribeStyle.add(driver.findElement(By.xpath("//*[text()='Image Position']//following::div[1]//span[1]//span[2]")).getText());
							WebElement enableSpacing=driver.findElement(By.xpath("//*[text()='Enable Spacing:']/following::div[2]//div[@role='switch']"));//Hide Header Text button inside Header Text Styling
							String esLarge=enableSpacing.getAttribute("aria-checked");
							String switchResults="";
							if(esLarge.equalsIgnoreCase("false"))
								switchResults="Off";
							else
								switchResults="On";
							subscribeStyle.add(switchResults);

							ArrayList<String> subscribeStyleTopics=new ArrayList<String>();
							subscribeStyleTopics.add("Body Background");
							subscribeStyleTopics.add("Background");
							subscribeStyleTopics.add("Body Text");
							subscribeStyleTopics.add("Link Hover");
							subscribeStyleTopics.add("Background Image");
							subscribeStyleTopics.add("Image Type");
							subscribeStyleTopics.add("Image Position");
							subscribeStyleTopics.add("Enable Spacing");
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "SubscribeMainStyle", subscribeStyle, subscribeStyleTopics);

							logger.info("Subscribe form completed");
							boolean homeelement=helper.waitForClickable(CSB.HomeLink);
							if(homeelement) {

								CSB.HomeLink.click();
								Thread.sleep(3000);
							}

						}
						catch(Exception E) {
							logger.info(E);
						}
					}
					else if(permissionLabel.equalsIgnoreCase("Video")&&duplicatecounter==0) {
						duplicatepermission.add(permissionLabel);
						PermissioncounterList.add(permissionCounter);
						logger.info("videoform--executionstarted");
						try {
							Thread.sleep(5000);
							ArrayList<String> vid=new ArrayList<>();
							String VidSrno = Integer.toString(permissionCounter);
							ArrayList<String>checkboxVid=new ArrayList<String>();
							checkboxVid.add(VidSrno);
							checkboxVid.add(driver.findElement(By.xpath("//*[text()='Video']//following::div[@role='checkbox'][1]")).getAttribute("aria-checked"));
							checkboxVid.add(driver.findElement(By.xpath("//*[text()='Video']//following::div[@role='checkbox'][2]")).getAttribute("aria-checked"));
							checkboxVid.add(driver.findElement(By.xpath("//*[text()='Video']//following::div[@role='checkbox'][3]")).getAttribute("aria-checked"));
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions","Video", checkboxVid, vid);
							/*driver.findElement(By.xpath("//*[@role='toolbar'][2]/nav/ol/li[3]/a")).click();
		Thread.sleep(10000);*/
							WebElement video=driver.findElement(By.xpath("//*[text()='Video']//following::div[10]//img[@role='button']"));
							video.click();
							Thread.sleep(6000);
							ArrayList<String> videoURL=new ArrayList<String>();
							Thread.sleep(5000);
							videoURL.add(driver.findElement(By.xpath("//*[text()='Video URL or ID']//following::div[3]//input[@placeholder='Enter Video URL']")).getAttribute("value"));
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "VideoUrl", videoURL, vid);
							ArrayList<String> videoType=new ArrayList<String>();
							videoType.add(driver.findElement(By.xpath("//*[text()='Video Type']//following::div[1]//div//span//span[2]")).getText());
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "VideoType", videoType, vid);
							ArrayList<String> videoLayout=new ArrayList<String>();
							videoLayout.add(driver.findElement(By.xpath("//*[text()='Layout']//following::div[1]//div//span//span[2]")).getText());
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "VideoLayout", videoLayout, vid);
							ArrayList<String> videoHeaderText=new ArrayList<String>();
							videoHeaderText.add(driver.findElement(By.xpath("//*[text()='Header Text']//following::div[@class='sapMInputBaseContentWrapper']/input[@placeholder='Header Text']")).getText());
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "VideoHeaderText", videoHeaderText, vid);
							ArrayList<String> videoBodyText=new ArrayList<String>();
							WebElement vidiframe=driver.findElement(By.xpath("//*[text()='Body Text']//following::div[4]//iframe"));
							driver.switchTo().frame(vidiframe);
							Thread.sleep(5000);
							videoBodyText.add(driver.findElement(By.xpath("/html/body/p")).getText());
							driver.switchTo().parentFrame();
							Thread.sleep(5000);
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions","VideoBodyText", videoBodyText, vid);
							ArrayList<String> autoStartVideo=new ArrayList<String>();
							autoStartVideo.add(driver.findElement(By.xpath("//*[text()='Auto Start Video']//following::div/input")).getAttribute("value"));
							WebElement videoAutoStart=driver.findElement(By.xpath("//*[text()='Auto Start Video']/following::div[1]/div[@role='switch']"));
							String autoStart=videoAutoStart.getAttribute("aria-checked");
							if(autoStart.equalsIgnoreCase("false"))
								autoStartVideo.add("Off");
							else
								autoStartVideo.add("On");
							System.out.println(autoStartVideo);
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions","VideoAutoStart", autoStartVideo, vid);
							ArrayList<String> alternativeText=new ArrayList<String>();
							alternativeText.add(driver.findElement(By.xpath("//*[text()='Alternative Text']//following::div[3]/textarea")).getText());
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "VideoAlternative", alternativeText, vid);
							driver.findElement(By.xpath("//*[text()='Styles']//following::div[@class='sapMITBHead']/div[@role='tab'][2]//span[text()='Styles']")).click();
							Thread.sleep(6000);

							ArrayList<String> bodyTextVideo=new ArrayList<String>();
							bodyTextVideo.add(driver.findElement(By.xpath("//*[text()='Body Text']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText());
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "VideoMainStyle", bodyTextVideo, vid);
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "BodyTextVideo", bodyTextVideo, vid);


							ArrayList<String> backgroundVideo=new ArrayList<String>();
							backgroundVideo.add(driver.findElement(By.xpath("//*[text()='Background']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText());
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "BackgroundVideo", backgroundVideo, vid);


							ArrayList<String> linkVideo=new ArrayList<String>();
							linkVideo.add(driver.findElement(By.xpath("//*[text()='Link']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText());
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "Link", linkVideo, vid);

							ArrayList<String> linkHoverVideo=new ArrayList<String>();
							linkHoverVideo.add(driver.findElement(By.xpath("//*[text()='Link Hover']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText());
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions","Link Hover", linkHoverVideo, vid);

							ArrayList<String> enableSpacingVideo=new ArrayList<String>();
							enableSpacingVideo.add(driver.findElement(By.xpath("//*[text()='Enable Spacing:']/following::div[2]//div[@role='switch']")).getAttribute("aria-checked"));
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "Enable Spacing", enableSpacingVideo, vid);
							logger.info("videoformcompleted");
							boolean homeelement=helper.waitForClickable(CSB.HomeLink);
							if(homeelement) {

								CSB.HomeLink.click();
								Thread.sleep(3000);
							}

						}
						catch(Exception E) {
							System.out.println(E);
						}
					}
					else if(permissionLabel.equalsIgnoreCase("Featured Jobs")&&!PermissioncounterList.contains(permissionCounter)) {
						PermissioncounterList.add(permissionCounter);
						logger.info("Featured Jobs--executionstarted");
						try {
							Thread.sleep(10000);
							ArrayList<String> vid=new ArrayList<>();
							String VidSrno = Integer.toString(permissionCounter);
							ArrayList<String>checkboxFeatured=new ArrayList<String>();
							checkboxFeatured.add(VidSrno);
							checkboxFeatured.add(driver.findElement(By.xpath("//*[text()='Featured Jobs']//following::div[@role='checkbox'][1]")).getAttribute("aria-checked"));
							checkboxFeatured.add(driver.findElement(By.xpath("//*[text()='Featured Jobs']//following::div[@role='checkbox'][2]")).getAttribute("aria-checked"));
							checkboxFeatured.add(driver.findElement(By.xpath("//*[text()='Featured Jobs']//following::div[@role='checkbox'][3]")).getAttribute("aria-checked"));
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions","FeaturedJobs", checkboxFeatured, vid);
							WebElement FeaturedJobs=driver.findElement(By.xpath("//*[text()='Featured Jobs']//following::div[10]//img[@role='button']"));
							FeaturedJobs.click();
							Thread.sleep(6000);
							ArrayList<String> FeaturedHeader=new ArrayList<String>();
							Thread.sleep(5000);
							FeaturedHeader.add(driver.findElement(By.xpath("//*[text()='Header Text']//following::div[3]//input[@placeholder='Header Text']")).getAttribute("value"));//header text
							Thread.sleep(5000);
							driver.findElement(By.xpath("//*[text()='Header Text']//following::div[4]//button[@title='Open Styling']")).click();//Open Styling of Header Text
							Thread.sleep(5000);
							WebElement FeaturedFont=driver.findElement(By.xpath("//*[text()='Font']/following::div[1]//span[@class='sapMSelectListItemText']"));//Font inside Header Text Styling
							FeaturedHeader.add("Font:"+FeaturedFont.getText());
							WebElement FeaturedSize=driver.findElement(By.xpath("//*[text()='Size']//following::div[3]//input[@name='headerTextSize']"));//Size inside Header Text Styling
							FeaturedHeader.add("Size:"+FeaturedSize.getAttribute("value"));
							WebElement FeaturedAlignment=driver.findElement(By.xpath("//*[text()='Alignment']/following::div[1]//input[@name='headerTextAlignment']"));//Alignment inside Header Text Styling
							FeaturedHeader.add("Alignment:"+FeaturedAlignment.getAttribute("value"));
							WebElement FeaturedColor=driver.findElement(By.xpath("//*[text()='Color:']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]"));//Color inside Header Text Styling
							FeaturedHeader.add("Color:"+FeaturedColor.getText());
							WebElement FeaturedHeaderHide=driver.findElement(By.xpath("//*[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));//Hide Header Text button inside Header Text Styling
							String hideattri=FeaturedHeaderHide.getAttribute("aria-checked");
							String switchRes="";
							if(hideattri.equalsIgnoreCase("false"))
								switchRes="No";
							else
								switchRes="Yes";
							FeaturedHeader.add("Hide Header Text:"+switchRes);
							driver.findElement(By.xpath("//*[text()='Close']//ancestor::button")).click();
							Thread.sleep(5000);
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "FeaturedHeader", FeaturedHeader, vid);
							ArrayList<String> FeaturedShow=new ArrayList<String>();
							WebElement FeaturedShowButton=driver.findElement(By.xpath("//*[text()='Show Button']/following::div[1]/div/div/div[@role='switch']"));
							String featuredShowBtn=FeaturedShowButton.getAttribute("aria-checked");
							String switchRes1="";
							if(featuredShowBtn.equalsIgnoreCase("false"))
								switchRes1="No";
							else
								switchRes1="Yes";
							FeaturedShow.add("Show Button:"+switchRes1);
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "FeaturedShowButton", FeaturedShow, vid);

							ArrayList<String> FeaturedButtonType=new ArrayList<String>();
							FeaturedButtonType.add(driver.findElement(By.xpath("//*[text()='Button Type: ']//following::div[1]/span[1]")).getText());
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "FeaturedButtonType", FeaturedButtonType, vid);


							ArrayList<String> FeaturedButtonText=new ArrayList<String>();
							FeaturedButtonText.add(driver.findElement(By.xpath("//*[text()='Button Text: ']//following::div[1]/span[1]")).getText());
							driver.findElement(By.xpath("//*[text()='Button Text: ']//following::div//button[@title='Open Styling']")).click();
							Thread.sleep(5000);
							logger.info("Button text");
							FeaturedButtonText.add("Font:"+driver.findElement(By.xpath("//*[text()='Font']/following::div[1]//span[@class='sapMSelectListItemText']")).getText());
							logger.info("font");
							FeaturedButtonText.add("Size:"+driver.findElement(By.xpath("//*[text()='Size']//following::div[3]//input")).getAttribute("value"));
							logger.info("size");
							driver.findElement(By.xpath("//*[text()='Close']//ancestor::button")).click();
							logger.info("close");
							Thread.sleep(5000);
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "FeaturedButtonText", FeaturedButtonText, vid);
							driver.findElement(By.xpath("//*[text()='Edit Button']//ancestor::button")).click();
							Thread.sleep(5000);

							ArrayList<String>FeaturedEdit=new ArrayList<String>();
							Thread.sleep(5000);
							FeaturedEdit.add(driver.findElement(By.xpath("//*[text()='Type']//ancestor::span//following::td[1]//span[1]//span[2]")).getText());
							FeaturedEdit.add(driver.findElement(By.xpath("//*[text()='Title']//ancestor::span//following::td[1]//input")).getAttribute("value"));
							FeaturedEdit.add(driver.findElement(By.xpath("//*[text()='Text']//ancestor::span//following::td[1]//input")).getAttribute("value"));
							FeaturedEdit.add(driver.findElement(By.xpath("//*[text()='Source']//ancestor::span//following::td[1]//input")).getAttribute("value"));
							WebElement featuredNewSession=driver.findElement(By.xpath("//*[text()='New Session']/following::div[1][@role='switch']"));//Hide Header Text button inside Header Text Styling
							String newSession=featuredNewSession.getAttribute("aria-checked");
							String switchResult="";
							if(newSession.equalsIgnoreCase("false"))
								switchResult="No";
							else
								switchRes="Yes";
							FeaturedEdit.add(switchResult);
							driver.findElement(By.xpath("//*[text()='Ok']//ancestor::button")).click();
							ArrayList<String> editBtnTopics=new ArrayList<String>();
							editBtnTopics.add("Type");
							editBtnTopics.add("Title");
							editBtnTopics.add("Text");
							editBtnTopics.add("Source");
							editBtnTopics.add("New Session");
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "FeaturedEditBtn", FeaturedEdit	, editBtnTopics);


							driver.findElement(By.xpath("//*[text()='Styles']//following::div[@class='sapMITBHead']/div[@role='tab'][2]")).click();
							Thread.sleep(6000);
							List<WebElement> myList=driver.findElements(By.xpath("//div[@role='tabpanel']/div/ul/li"));
							int menuSize=myList.size();
							ArrayList<String> menu=new ArrayList<String>();
							ArrayList<String> menuTopics=new ArrayList<String>();
							menuTopics.add(" ");
							menuTopics.add("Type");
							menuTopics.add("Title");
							menuTopics.add("Text");
							menuTopics.add("Category Link");
							for(int i=0;i<menuSize;i++) {
								Thread.sleep(5000);
								int pos=i+1;
								driver.findElement(By.xpath("//div[@role='tabpanel']/div/ul/li["+pos+"]/button[@title='Edit']")).click();
								Thread.sleep(5000);
								String num=Integer.toString(i+1);
								menu.add(num);
								menu.add(driver.findElement(By.xpath("//*[text()='Type']//..//../..//..//td[2]//div[1]//span[1][@aria-live='polite']//span[2]")).getText());
								menu.add(driver.findElement(By.xpath("//*[text()='Title']//..//../..//..//td[2]//div//div//input")).getAttribute("value"));
								menu.add(driver.findElement(By.xpath("//*[text()='Text']//..//../..//..//td[2]//div//div//input")).getAttribute("value"));
								menu.add(driver.findElement(By.xpath("//*[text()='Category Link']//..//../..//..//tr//td//following::div[2]//input")).getAttribute("value"));
								driver.findElement(By.xpath("//*[text()='Close']//ancestor::button")).click();
								Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", "FeaturedMenu", menu, menuTopics);
								menu.clear();
							}
							logger.info("FeaturedJobscompleted");
							boolean homeelement=helper.waitForClickable(CSB.HomeLink);
							if(homeelement) {

								CSB.HomeLink.click();
								Thread.sleep(3000);
							}

						}
						catch(Exception E) {
							System.out.println(E);
						}


					}
					else if(permissionLabel.equalsIgnoreCase("Three Column Images with Caption")&&!PermissioncounterList.contains(permissionCounter)) {
						logger.info("Three Column Images with Caption execution started");
						PermissioncounterList.add(permissionCounter);
						logger.info("Three Column Images with Caption--executionstarted");
						try {
							ArrayList<String> vid=new ArrayList<>();
							String ThrSrno = Integer.toString(permissionCounter);
							ArrayList<String>checkboxFeatured=new ArrayList<String>();
							checkboxFeatured.add(ThrSrno);
							checkboxFeatured.add(driver.findElement(By.xpath("//*[text()='Three Column Images with Caption']//following::div[@role='checkbox'][1]")).getAttribute("aria-checked"));
							checkboxFeatured.add(driver.findElement(By.xpath("//*[text()='Three Column Images with Caption']//following::div[@role='checkbox'][2]")).getAttribute("aria-checked"));
							checkboxFeatured.add(driver.findElement(By.xpath("//*[text()='Three Column Images with Caption']//following::div[@role='checkbox'][3]")).getAttribute("aria-checked"));
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions","Three Column Images with Caption checkbox", checkboxFeatured, vid);
							driver.findElement(By.xpath("//*[text()='Three Column Images with Caption']//following::div[10]//img[@role='button']")).click();
							Thread.sleep(10000);
							ArrayList<String>threeColumn=new ArrayList<String>();
							ArrayList<String>threeColumnTopics=new ArrayList<String>();
							threeColumnTopics.add("abcd");
							threeColumnTopics.add("Header Text 1");
							threeColumnTopics.add("Treat Image as Link");
							threeColumnTopics.add("Show Link");
							threeColumnTopics.add("Link Type");
							threeColumnTopics.add("Link Text");
							threeColumnTopics.add("Category/ Content Link");
							threeColumnTopics.add("Title");
							threeColumnTopics.add("Image");
							threeColumnTopics.add("Body Text");
							for(int i=1;i<=3;i++) {
								if(i!=1) {
									driver.findElement(By.xpath("//*[text()='Column "+i+"']//ancestor::div[@role='tab']")).click();
								}
								threeColumn.add("Column"+i);
								ArrayList<String>threeColumnHeader=new ArrayList<String>();
								threeColumnHeader.add(driver.findElement(By.xpath("//*[text()='Header Text']//following::div[3]//input[@placeholder='Header Text']")).getAttribute("value"));
								driver.findElement(By.xpath("//*[text()='Header Text']//following::div[4]//button[@title='Open Styling']")).click();
								Thread.sleep(5000);
								threeColumnHeader.add("Font:"+driver.findElement(By.xpath("//*[text()='Font']/following::div[1]//span[@class='sapMSelectListItemText']")).getText());
								threeColumnHeader.add("Size:"+driver.findElement(By.xpath("//*[text()='Size']//following::div[3]//input[@role='combobox']")).getAttribute("value"));
								threeColumnHeader.add("Alignment:"+driver.findElement(By.xpath("//*[text()='Alignment']/following::div[1]//input[@role='combobox']")).getAttribute("value"));
								threeColumnHeader.add("Color:"+driver.findElement(By.xpath("//*[text()='Color:']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText());
								String sw=driver.findElement(By.xpath("//*[text()='Hide Header Text']/following::div[1]/div[@role='switch']")).getAttribute("aria-checked");
								if(sw.equalsIgnoreCase("false")) {
									threeColumnHeader.add("Hide Header Text:No");
								}
								if(sw.equalsIgnoreCase("true")) {
									threeColumnHeader.add("Hide Header Text:Yes");
								}
								String headertextexcel=String.join(" ", threeColumnHeader);
								threeColumn.add(headertextexcel);
								System.out.println(headertextexcel);
								driver.findElement(By.xpath("//*[text()='Close']//ancestor::button")).click();
								Thread.sleep(5000);
								String hht=driver.findElement(By.xpath("//*[text()='Treat Image as Link']/following::div[1]//div[@role='switch']")).getAttribute("aria-checked");
								if(hht.equalsIgnoreCase("false")) {
									threeColumn.add("No");
								}
								if(hht.equalsIgnoreCase("true")) {
									threeColumn.add("Yes");
								}
								String sl=driver.findElement(By.xpath("//*[text()='Show Link']/following::div[1]//div[@role='switch']")).getAttribute("aria-checked");
								if(sl.equalsIgnoreCase("false")) {
									threeColumn.add("No");
								}
								if(sl.equalsIgnoreCase("true")) {
									threeColumn.add("Yes");
								}


								threeColumn.add(driver.findElement(By.xpath("//*[text()='Link Type: ']/following::div[1]//span")).getText());
								threeColumn.add(driver.findElement(By.xpath("//*[text()='Link Text: ']/following::div[1]//span")).getText());
								driver.findElement(By.xpath("//*[text()='Edit Link']//ancestor::button")).click();
								Thread.sleep(5000);
								try {
									threeColumn.add("Font"+driver.findElement(By.xpath("//*[text()='Category Link']//..//../..//..//tr//td//following::div[2][@class='sapMInputBaseContentWrapper']//input[@role='combobox']")).getAttribute("value"));
								}
								catch(Exception e){
									threeColumn.add("");
								}
								try {

									threeColumn.add(driver.findElement(By.xpath("//*[text()='Title']//..//..//..//following::td[1]//div//div[@class='sapMInputBaseContentWrapper']//input[1]")).getAttribute("value"));	
								}

								catch(Exception e){
									threeColumn.add("");
								}



								driver.findElement(By.xpath("//*[text()='Cancel']//ancestor::button[1]")).click();

								Thread.sleep(5000);
								try {
									String val=driver.findElement(By.xpath("//*[text()='Image']//following::div[1]//img")).getAttribute("src");
									threeColumn.add("On");
								}
								catch(Exception e) {
									threeColumn.add("Off");
								}
								logger.info("image done");
								WebElement threeColBodyText=driver.findElement(By.xpath("//*[text()='Body Text']//following::div[4]//iframe"));
								driver.switchTo().frame(threeColBodyText);
								logger.info("inside bodytext");
								Thread.sleep(8000);
								ArrayList<String>btxt=new ArrayList<String>();
								btxt.add(driver.findElement(By.xpath("html/body/p")).getText());
								driver.switchTo().parentFrame();
								logger.info("bodytext done");
								Thread.sleep(5000);
								if((btxt.get(0)).length()>1) {
									driver.findElement(By.xpath("(//*[text()='Body Text']//following::a[@title='Paragraph Format'])[1]")).click();
									btxt.add("Paragraph Format:"+driver.findElement(By.xpath("(//*[text()='Body Text']//following::a[@title='Paragraph Format'])[1]")).getText());
									driver.findElement(By.xpath("//*[text()='Body Text']")).click();
									logger.info("paragraph done");
									WebElement leftAlign=driver.findElement(By.xpath("(//a[@title='Align Left'])[1]"));
									String alignLeft=leftAlign.getAttribute("class");
									WebElement centerAlign=driver.findElement(By.xpath("(//a[@title='Center'])[1]"));
									String alignCenter=centerAlign.getAttribute("class");
									WebElement rightAlign=driver.findElement(By.xpath("(//a[@title='Align Right'])[1]"));
									String alignRight=rightAlign.getAttribute("class");
									WebElement justifyAlign=driver.findElement(By.xpath("(//a[@title='Justify'])[1]"));
									String alignJustify=justifyAlign.getAttribute("class");
									if(alignLeft.contains("button_on")) {
										btxt.add("Alignment:Left Align");
									}
									if(alignCenter.contains("button_on")) {
										btxt.add("Alignment:Center");
									}
									if(alignRight.contains("button_on")) {
										btxt.add("Alignment:Right Align");
									}
									if(alignJustify.contains("button_on")) {
										btxt.add("Alignment:Justify");
									}
									logger.info("alignment done");
								}
								String bodyTextexcel=String.join(" ", btxt);
								threeColumn.add(bodyTextexcel);
								logger.info("writing to excel body text done");

								//videoBodyText.add(driver.findElement(By.xpath("/html/body/p")).getText());//content inside iframe
								logger.info(threeColumn.size()+"  "+threeColumnTopics.size());
								System.out.println(threeColumn);
								System.out.println(threeColumnTopics);
								Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions","Three Column Images with Caption",threeColumn , threeColumnTopics);
								threeColumn.clear();

							}
							threeColumn.clear();
							threeColumnTopics.clear();
							threeColumnTopics.add("Body Background Colour");
							threeColumnTopics.add("Header Colour");
							threeColumnTopics.add("Body Text Colour");
							threeColumnTopics.add("Link Colour");
							threeColumnTopics.add("Link Hover Colour");
							threeColumnTopics.add("Background Image");
							threeColumnTopics.add("Image Type");
							threeColumnTopics.add("Image Position");
							threeColumnTopics.add("Enable Spacing");
							threeColumnTopics.add("Body Font");
							threeColumnTopics.add("Link Font");
							threeColumnTopics.add("Body Font Size");
							threeColumnTopics.add("Link Font Size");
							logger.info("styles");
							driver.findElement(By.xpath("//*[text()='Styles']//ancestor::div[@role='tab']")).click();
							Thread.sleep(5000);
							threeColumn.add(driver.findElement(By.xpath("//*[text()='Body Background']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText());
							threeColumn.add(driver.findElement(By.xpath("//*[text()='Header Background']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText());
							threeColumn.add(driver.findElement(By.xpath("//*[text()='Body Text']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText());
							threeColumn.add(driver.findElement(By.xpath("//*[text()='Link']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText());
							String lhc=driver.findElement(By.xpath("//*[text()='Link Hover']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText();
							if(lhc.length()>1) {
								threeColumn.add(lhc);
							}
							else {
								threeColumn.add("No");
							}
							try {
								String val=driver.findElement(By.xpath("//*[text()='Background Image']//following::div[1]//img")).getAttribute("src");
								threeColumn.add("On");
							}
							catch(Exception e) {
								threeColumn.add("Off");
							}


							threeColumn.add(driver.findElement(By.xpath("//*[text()='Image Type']//following::div[1]//span[1]//span[2]")).getText());
							threeColumn.add(driver.findElement(By.xpath("//*[text()='Image Position']//following::div[1]//span[1]//span[2]")).getText());
							String es=driver.findElement(By.xpath("//*[text()='Enable Spacing:']/following::div[2]//div[@role='switch'][1]")).getAttribute("aria-checked");
							if(es.equalsIgnoreCase("false")) {
								threeColumn.add("No");
							}
							if(es.equalsIgnoreCase("true")) {
								threeColumn.add("Yes");
							}



							driver.findElement(By.xpath("//*[text()='Font Styles']//ancestor::div[@role='tab']")).click();
							Thread.sleep(5000);
							threeColumn.add(driver.findElement(By.xpath("//*[text()='Body Font']//following::div[1]//span[1]//span[2]")).getText());
							threeColumn.add(driver.findElement(By.xpath("//*[text()='Link Font']//following::div[1]//span[1]//span[2]")).getText());
							threeColumn.add(driver.findElement(By.xpath("//*[text()='Body Font Size']//following::div[1]//input")).getAttribute("value"));
							threeColumn.add(driver.findElement(By.xpath("//*[text()='Link Font Size']//following::div[1]//input")).getAttribute("value"));

							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions","Three Column Images with Caption Styles", threeColumn, threeColumnTopics);






							logger.info("Three Column Images with Caption completed");
							boolean homeelement=helper.waitForClickable(CSB.HomeLink);
							if(homeelement) {

								CSB.HomeLink.click();
								Thread.sleep(3000);
								logger.info("Google Enhancement of RPA Tool-Google Job Map execution completed");
							}
						}
						catch(Exception E) {
							System.out.println(E);
						}
					}
					else if(permissionLabel.equalsIgnoreCase("Google Enhancement of RPA Tool-Google Job Map")||permissionLabel.equalsIgnoreCase("Google Job Map")&&duplicatecounter==0) {
						logger.info("Google Enhancement of RPA Tool-Google Job Map execution started");
						PermissioncounterList.add(permissionCounter);
						logger.info("Google Job Map--executionstarted");
						try {
							ArrayList<String> vid=new ArrayList<>();
							ArrayList<String>checkboxFeatured=new ArrayList<String>();
							String GooSrno = Integer.toString(permissionCounter);
							checkboxFeatured.add(GooSrno);
							checkboxFeatured.add(driver.findElement(By.xpath("//a[contains(text(),'Google Job Map')]//following::div[@role='checkbox'][1]")).getAttribute("aria-checked"));
							checkboxFeatured.add(driver.findElement(By.xpath("//a[contains(text(),'Google Job Map')]//following::div[@role='checkbox'][2]")).getAttribute("aria-checked"));
							checkboxFeatured.add(driver.findElement(By.xpath("//a[contains(text(),'Google Job Map')]//following::div[@role='checkbox'][2]")).getAttribute("aria-checked"));
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions","GoogleJobMap", checkboxFeatured, vid);
							driver.findElement(By.xpath("//*[contains(text(),'Google Job Map')]//following::div[10]//img[@role='button']")).click();
							Thread.sleep(10000);
							//driver.findElement(By.xpath("//*[text()='Details']")).click();
							Thread.sleep(5000);
							List<WebElement> myList=driver.findElements(By.xpath("//*[text()='Predefined Map Center Options']//following::div[1]//div//div"));
							int menuSize=myList.size();
							ArrayList<String> googleMap=new ArrayList<String>();

							ArrayList<String> googleMapTopics=new ArrayList<String>();
							googleMapTopics.add("Zoom Level");
							googleMapTopics.add("Map Center Latitude");
							googleMapTopics.add("Map Center Longitude");
							googleMapTopics.add("Pre-Defined Map Centre Options:");
							googleMapTopics.add("Search Filtered by Locale:");
							googleMapTopics.add("Max Height of Job Map:");
							googleMapTopics.add("Region Code");
							googleMapTopics.add("Show Heading");
							googleMapTopics.add("Body of the Water");
							googleMapTopics.add("Enable Spacing");
							for(int i=0;i<menuSize;i++) {
								driver.findElement(By.xpath("//*[text()='Predefined Map Center Options']//following::div[1]//div//div["+(i+1)+"]")).click();
								Thread.sleep(5000);
								googleMap.add(driver.findElement(By.xpath("//*[text()='Zoom Level']//following::div[1]//div//span[1]//span[2]")).getText());
								logger.info("Zoom");
								googleMap.add(driver.findElement(By.xpath("//*[text()='Map Center Latitude']//following::div[1]//span[1][@role='slider']")).getAttribute("title"));
								logger.info("map center");
								googleMap.add(driver.findElement(By.xpath("//*[text()='Map Center Longitude']//following::div[1]//span[1][@role='slider']")).getAttribute("title"));
								logger.info("map center longitude");
								googleMap.add(driver.findElement(By.xpath("//*[text()='Predefined Map Center Options']//following::div[1]//div//div["+(i+1)+"]//a")).getText());
								logger.info("map predefined");
								WebElement SearchFiltered=driver.findElement(By.xpath("//*[text()='Search Filtered by Locale']/following::div[1]/div/div/div[@role='switch']"));//Hide Header Text button inside Header Text Styling
								String esLarge=SearchFiltered.getAttribute("aria-checked");
								String switchResults="";
								if(esLarge.equalsIgnoreCase("false"))
									switchResults="Off";
								else
									switchResults="On";
								googleMap.add(switchResults);
								logger.info("search filter");

								googleMap.add(driver.findElement(By.xpath("//*[text()='Max Height of Job Map']/following::div[1]//input")).getAttribute("value"));
								logger.info("max height");
								googleMap.add(driver.findElement(By.xpath("//*[text()='Region Code']/following::div[1]//input")).getAttribute("value"));
								logger.info("Region");
								WebElement ShowHeading=driver.findElement(By.xpath("//*[text()='Show Heading']/following::div[1]/div/div/div[@role='switch']"));//Hide Header Text button inside Header Text Styling
								String showHead=ShowHeading.getAttribute("aria-checked");
								String switchResult="";
								if(showHead.equalsIgnoreCase("false"))
									switchResult="Off";
								else
									switchResult="On";
								googleMap.add(switchResult);
								logger.info("show heading");
								driver.findElement(By.xpath("//*[text()='Styles']//following::div[@role='tab'][2]//div//div//span[1]")).click();
								Thread.sleep(5000);
								googleMap.add(driver.findElement(By.xpath("//*[text()='Body of Water']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText());
								logger.info("Body of water");
								WebElement enableSpacing=driver.findElement(By.xpath("//*[text()='Enable Spacing:']/following::div[1]//div[@role='switch']"));
								String enableSpac=enableSpacing.getAttribute("aria-checked");
								String switchRes="";
								if(enableSpac.equalsIgnoreCase("false"))
									switchRes="Off";
								else
									switchRes="On";
								googleMap.add(switchRes);
								logger.info("Enable spacing");
								Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions","GoogleMapDetails", googleMap, googleMapTopics);
								googleMap.clear();
								driver.findElement(By.xpath("//*[text()='Details']")).click();
							}



							logger.info("GoogleJobMapcompleted");
							boolean homeelement=helper.waitForClickable(CSB.HomeLink);
							if(homeelement) {

								CSB.HomeLink.click();
								Thread.sleep(3000);
								logger.info("Google Enhancement of RPA Tool-Google Job Map execution completed");
							}


						}
						catch(Exception E) {
							System.out.println(E);
						}
					}

					else if (permissionLabel.equalsIgnoreCase("Info and Subscribe Form")&&duplicatecounter==0) {
						logger.info("Info and Subscribe Form executionstarted");
						try {
							duplicatepermission.add(permissionLabel);
							PermissioncounterList.add(permissionCounter);
							WebElement HelpWindow;
							String inputstatus="";

							radioselected = false;
							PermissionHeader="Permissions";	
							System.out.println("Permission " + permissionCounter+ " : "+permissionLabel);
							//add permissionton the excel			
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue,Permissionname);
							logger.info("Permission is added in excel file");
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";

							counter=0;	
							List<WebElement> availablePermissions = driver.findElements(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
							ArrayList checkboxlist = new ArrayList<>();
							for(WebElement roleoptions : availablePermissions) {
								if(checkboxlist.size()==3) {
									break;
								}
								//driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')]["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper']"));
								permissionvalue="";
								permissionvalue=roleoptions.getText();


								if(permissionvalue.equalsIgnoreCase("Desktop")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][1]//ancestor::div[1]"));
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										checkboxlist.add(permissionvalue);
										counter++;

									}
									else {
										Status = "Off";
										counter=0;
										checkboxlist.add(permissionvalue);
										break;
									}


								}
								else if (permissionvalue.equalsIgnoreCase("Tablet")&&!checkboxlist.contains(permissionvalue)) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][2]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;

									}

								}
								else if (permissionvalue.equalsIgnoreCase("Mobile")) {
									WebElement desktopcheckbox = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::span[@class='sapMLabelTextWrapper'][3]//ancestor::div[1]"));
									counter=0;
									String checkboxstatus = desktopcheckbox.getAttribute("aria-checked");
									if(checkboxstatus.equals("true")) {
										Status = "On";
										counter++;
										checkboxlist.add(permissionvalue);

									}
									else {
										Status = "Off";
										checkboxlist.add(permissionvalue);
										counter=0;


									}

								}

								PermissionHeader="";
								PermissionValue=new ArrayList<String>();
								PermissionHeader="RoleOptions";
								PermissionValue.add(permissionvalue);
								PermissionValue.add(Status);

								//add allcheckboxstatus
								Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
								logger.info("Checbox value" +PermissionValue+" added in excel file");				
							}
							//To add settings value
							PermissionHeader="";
							PermissionValue=new ArrayList<String>();
							PermissionHeader="RoleOptions";
							PermissionValue.add("Settings");
							PermissionValue.add(Status);
							//add settingscheckboxstatus
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							logger.info("Checbox value for settings added in excel file");

							WebElement Tile = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
							try {
								wait.until(ExpectedConditions.elementToBeClickable(Tile));
							}
							catch (Exception e) {
								Tile = driver.findElement(By.xpath("(//a[contains(@class,'sapMTBShrinkItem')])["+permissionCounter+"]//following::div[contains(@class,'sapMFlexItemAlignAuto')][1]"));
								while(Tile.equals(null)) {
									Thread.sleep(10);
								}
							}
							Tile.click();

							Thread.sleep(3000);
							try {
								WebElement headertext = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//bdi[text()='Header Text']"))));
							}
							catch (Exception e) {
								//ifheaderText is not seen
								//driver.findElement(By.xpath("(//div[@role='tablist']/div/div/div/span[text()='Details'])[2]//ancestor::div[1]")).click();
								WebElement headertext = driver.findElement(By.xpath("//bdi[text()='Header Text']"));
								while(headertext.equals(null)) {
									Thread.sleep(10);
								}
							}
							String label = driver.findElement(By.xpath("//bdi[text()='Header Text']")).getText();
							WebElement text = driver.findElement(By.xpath("//input[@class='sapMInputBaseInner']"));
							textvalue = text.getAttribute("value");			
							if(!textvalue.isEmpty()) {
								headertextstatus = "On";
							}
							else {
								headertextstatus="Off";
							}
							PermissionHeader="";
							PermissionValue=new ArrayList<String>();
							PermissionHeader="HeaderText";
							PermissionValue.add(headertextstatus);

							//AddHeadertextvalue
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							Thread.sleep(2000);
							PermissionValue=new ArrayList<String>();
							PermissionValue.add(textvalue);
							driver.findElement(By.xpath("//button[@title='Open Styling']")).click();
							Thread.sleep(1000);
							List<WebElement> fontoptions = driver.findElements(By.xpath("//div[@class='sapMDialogScroll']//child::div[contains(@class,'sapUiRespGridMedia-Std-Phone')]/div/label"));
							ArrayList fonttextlist = new ArrayList<>();
							String headerinput="";
							String inputvalue ="";
							int hedertextno=0;
							for(WebElement fontopt:fontoptions) {
								String fontopttext = "";
								fontopttext = fontopt.getText();
								if(fontopttext.equalsIgnoreCase("Font")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement font = driver.findElement(By.xpath("//bdi[text()='Font']//following::div[1]//span[@class='sapMSelectListItemText']"));
									inputvalue = font.getText();
									headerinput = "Font";
									fonttextlist.add(fontopttext);
									countheadertext++;
								}
								else if (fontopttext.equalsIgnoreCase("Size")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement size = driver.findElement(By.xpath("//bdi[text()='Size']//following::div[3]//input[@name='headerTextSize']"));
									inputvalue = size.getAttribute("value");
									headerinput = "Size";
									fonttextlist.add(fontopttext);
									countheadertext++;
								}
								else if (fontopttext.equalsIgnoreCase("Alignment")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement Alignment = driver.findElement(By.xpath("//bdi[text()='Alignment']//following::div[1]//input[@name='headerTextAlignment']"));
									inputvalue = Alignment.getAttribute("value");
									headerinput = "Alignment";
									fonttextlist.add(fontopttext);
									countheadertext++;

								}
								else if (fontopttext.equalsIgnoreCase("Color")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement color = fontopt.findElement(By.xpath("//bdi[text()='Color:']//following::div[2]//bdi[contains(@id,'colorPaletteControl')]"));
									inputvalue = color.getText();
									headerinput = "Color";
									fonttextlist.add(fontopttext);
									PermissionValue.add(headerinput+":"+inputvalue);
									countheadertext++;

								}
								else if (fontopttext.equalsIgnoreCase("Hide Header Text")&&!fonttextlist.contains(fontopttext)) {
									inputvalue="";
									WebElement Alignment = driver.findElement(By.xpath("//bdi[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));
									headerinput = "HideHeaderText";
									WebElement HideHeader = driver.findElement(By.xpath("//*[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));
									String HideHeaderstatus = HideHeader.getAttribute("aria-checked");
									if(HideHeaderstatus.equals("true")) {
										inputvalue = "Yes";
									}
									else {
										inputvalue = "No";
									}
									fonttextlist.add(fontopttext);
									countheadertext++;
								}
								PermissionHeader="";

								PermissionHeader="HeaderText";

								PermissionValue.add(headerinput+":"+inputvalue);


							}
							inputvalue = driver.findElement(By.xpath("//*[text()='Color:']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]")).getText();

							headerinput=driver.findElement(By.xpath("//bdi[text()='Color:']")).getText();
							PermissionHeader="";

							//add colour value
							PermissionHeader="HeaderText";
							PermissionValue.add(headerinput+":"+inputvalue);
							countheadertext++;
							Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
							Thread.sleep(3000);
							driver.findElement(By.xpath("//bdi[text()='Close']//ancestor::button[1]")).click();
							countheadertext=0;
							Thread.sleep(3000);

							PermissionHeader="";
							PermissionValue=new ArrayList<String>();


							List<WebElement> imageCarouseloptions = driver.findElements(By.xpath("//div[@role='tablist']/div/div/div/span"));
							int size=imageCarouseloptions.size();

							int columncounter=0;
							for(int optioncounter=0;optioncounter<imageCarouseloptions.size();optioncounter++) {

								String optionname = imageCarouseloptions.get(optioncounter).getText();

								if(optionname.equalsIgnoreCase("Details")) {

									columncounter=columncounter+1;
									WebElement optionelement = driver.findElement(By.xpath("(//div[@role='tablist']/div/div/div/span)["+columncounter+"]//ancestor::div[1]"));

									ArrayList<String>detailoptionlist = new ArrayList<>();
									List<WebElement> detailsoptions = optionelement.findElements(By.xpath("//span[@class='sapMLabelTextWrapper']//following::span[contains(@id,'label')]/bdi"));
									int valuecounter = 0;
									PermissionValue=new ArrayList<String>();
									for(WebElement opt:detailsoptions) {
										if(detailoptionlist.contains("Treat Image as Link")){
											break;
										}
										String Detailopttext = opt.getText();
										if(Detailopttext.equalsIgnoreCase("Image")) {
											detailoptionlist.add(Detailopttext);
											String detailoptiontextvalue="";
											WebElement backgroundimg = opt.findElement(By.xpath("//following::img[1]"));
											if(backgroundimg.isDisplayed()) {
												detailoptiontextvalue = "On";
											}
											else {
												detailoptiontextvalue="Off";
											}
											PermissionHeader="";
											PermissionValue= new ArrayList<>();
											PermissionHeader="Detailsoptions";
											PermissionValue.add("Image");
											PermissionValue.add(detailoptiontextvalue);
											valuecounter++;
											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);	
										}
										else if (Detailopttext.equalsIgnoreCase("Treat Image as Link")) {
											detailoptionlist.add(Detailopttext);
											WebElement imagelink = opt.findElement(By.xpath("(//span[@class='sapMLabelTextWrapper']//following::span[contains(@id,'label')]/bdi)[7]//following::div[@class='sapMSwtCont'][1]"));
											String imageoptstatus = imagelink.getAttribute("aria-checked");
											String imagestatus = "";
											if(imageoptstatus.equals("true")) {
												imagestatus="Yes";
											}
											else {
												imagestatus="No";
											}
											PermissionHeader="";
											PermissionValue= new ArrayList<>();
											PermissionHeader="Detailsoptions";
											PermissionValue.add("Treat Image as Link");
											PermissionValue.add(imagestatus);
											valuecounter++;

											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
										}


									}
									boolean buttonlinkstatus = driver.findElement(By.xpath("//bdi[text()='Edit Link']//ancestor::button")).isEnabled();
									if(buttonlinkstatus) {
										inputstatus="Yes";
									}
									else {
										inputstatus="No";
									}
									PermissionValue=new ArrayList<String>();
									PermissionHeader="Detailsoptions";
									PermissionValue.add("ShowLink");
									PermissionValue.add( inputstatus);
									//Add ShowLink
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);


									driver.findElement(By.xpath("//button[@class='sapMBtnBase sapMBtn sapMBtnInverted']")).click();
									List<WebElement> editorlist = driver.findElements(By.xpath("//div[@class='sapMDialogScrollCont']//bdi"));
									int xpathcounter = 0;
									permissionvalue="";
									Status="";
									for(WebElement wb:editorlist) {
										String detailoptiontext;

										String editlinktext = wb.getText();
										if(editlinktext.equalsIgnoreCase("Type")) {
											permissionvalue="";
											permissionvalue= "LinkType";
											Status=wb.findElement(By.xpath("(//span[@class='sapMSelectListItemText'])[1]")).getText();

										}
										else if (editlinktext.equalsIgnoreCase("Title")) {
											xpathcounter=xpathcounter+1;
											permissionvalue= "LinkTitle";
											Status=wb.findElement(By.xpath("(//input[@class='sapMInputBaseInner'])["+xpathcounter+"]")).getAttribute("value");


										}
										else if (editlinktext.equalsIgnoreCase("Text")) {
											xpathcounter=xpathcounter+1;
											permissionvalue= "LinkText";;
											Status=wb.findElement(By.xpath("(//input[@class='sapMInputBaseInner'])["+xpathcounter+"]")).getAttribute("value");

										}
										PermissionHeader="";
										PermissionValue=new ArrayList<String>();
										PermissionHeader="Detailsoptions";
										PermissionValue.add(permissionvalue);
										PermissionValue.add(Status);								
										Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

									}
									Thread.sleep(2000);
									driver.findElement(By.xpath("(//bdi[text()='Cancel']//ancestor::button)[1]")).click();
									Thread.sleep(2000);
									WebElement bodytextframe = driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor')]"));
									driver.switchTo().frame(bodytextframe);
									String bodyparatextinput = driver.findElement(By.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke')]/p")).getText();
									if(!bodyparatextinput.isEmpty()) {
										headertextstatus = "On";
									}
									else {
										headertextstatus="Off";
									}
									PermissionHeader="";
									PermissionValue= new ArrayList<>();
									PermissionHeader="BodyText";
									PermissionValue.add(headertextstatus);
									countrbodytext=0;
									//Add body Text on off condition
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									bodyparatextinput = driver.findElement(By.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke')]/p")).getText();
									PermissionHeader="";
									PermissionValue=new ArrayList<String>();
									PermissionHeader="BodyText";
									PermissionValue.add(bodyparatextinput);
									Thread.sleep(3000);
									driver.switchTo().defaultContent();
									driver.findElement(By.xpath("(//*[text()='Body Text']/following::div[3]//following::span[5]//a[@class='cke_button cke_button__openstylebutton cke_button_off'])[1]")).click();
									Thread.sleep(5000);
									PermissionValue.add("Font:"+driver.findElement(By.xpath("//*[text()='Font']//following::div/div/span[@class='sapMSltLabel']//span[@class='sapMSelectListItemText']")).getText());
									PermissionValue.add("Size:"+driver.findElement(By.xpath("//*[text()='Size']//following::div[3]/input[@role='combobox']")).getAttribute("value"));
									Thread.sleep(2000);
									driver.findElement(By.xpath("//*[text()='Close']//parent::span//parent::span//parent::button")).click();
									Thread.sleep(3000);
									PermissionValue.add("Paragraph Format:"+driver.findElement(By.xpath("(//*[text()='Body Text']//following::a[@title='Paragraph Format'])[1]")).getText());
									WebElement leftAlign=driver.findElement(By.xpath("(//a[@title='Align Left'])[1]"));
									String alignLeft=leftAlign.getAttribute("class");
									WebElement centerAlign=driver.findElement(By.xpath("(//a[@title='Center'])[1]"));
									String alignCenter=centerAlign.getAttribute("class");
									WebElement rightAlign=driver.findElement(By.xpath("(//a[@title='Align Right'])[1]"));
									String alignRight=rightAlign.getAttribute("class");
									WebElement justifyAlign=driver.findElement(By.xpath("(//a[@title='Justify'])[1]"));
									String alignJustify=justifyAlign.getAttribute("class");
									if(alignLeft.contains("button_on")) {
										PermissionValue.add("Alignment:Left Align");
									}
									if(alignCenter.contains("button_on")) {
										PermissionValue.add("Alignment:Center");
									}
									if(alignRight.contains("button_on")) {
										PermissionValue.add("Alignment:Right Align");
									}
									if(alignJustify.contains("button_on")) {
										PermissionValue.add("Alignment:Justify");
									}
									countrbodytext++;

									//driver.switchTo().defaultContent();

									Thread.sleep(1000);
									//add body text in approve text with other options 
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									logger.info("bodytext value with font and size values added in excel file");
									String showbuttontext = driver.findElement(By.xpath("//span[@class='sapMLabelTextWrapper']//following::span[contains(@id,'label')]/bdi[text()='Show Button']")).getText();
									PermissionValue=new ArrayList<String>();
									detailoptionlist.add(showbuttontext);
									String showbuttontextvalue = driver.findElement(By.xpath("(//div[@class='sapMSwt sapMSwtTrans sapMSwtOn sapMSwtDefault sapMSwtHoverable'])[1]//parent::div[1]")).getAttribute("aria-checked");
									PermissionHeader="";
									if(showbuttontextvalue.equals("true")) {
										PermissionValue=new ArrayList<String>();
										showbuttontextvalue="On";
									}
									else {
										showbuttontextvalue="Off";
									}
									PermissionHeader="Detailsoptions";
									PermissionValue.add(showbuttontext);
									PermissionValue.add(showbuttontextvalue);
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									driver.findElement(By.xpath("//bdi[text()='Edit Button']//ancestor::button")).click();
									List<WebElement> buttontypes = driver.findElements(By.xpath("//div[@class='sapMDialogScrollCont']//bdi"));

									for(WebElement bt:buttontypes) {
										String buttontypetext = bt.getText();
										if(buttontypetext.equalsIgnoreCase("Type")) {
											PermissionValue=new ArrayList<String>();
											permissionvalue="";
											permissionvalue= "ButtonType";
											Status=bt.findElement(By.xpath("(//span[@class='sapMSelectListItemText'])[1]")).getText();

										}
										else if (buttontypetext.equalsIgnoreCase("Title")) {
											xpathcounter=xpathcounter+1;
											permissionvalue= "ButtonTitle";;
											Status=bt.findElement(By.xpath("(//input[@class='sapMInputBaseInner'])[1]")).getAttribute("value");


										}
										else if (buttontypetext.equalsIgnoreCase("Text")) {
											PermissionValue=new ArrayList<String>();
											xpathcounter=xpathcounter+1;
											permissionvalue= "ButtonText";
											Status=bt.findElement(By.xpath("(//input[@class='sapMInputBaseInner'])[2]")).getAttribute("value");

										}
										PermissionHeader="";
										PermissionValue=new ArrayList<String>();
										PermissionHeader="Detailsoptions";
										PermissionValue.add(permissionvalue);
										PermissionValue.add(Status);

										Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);


									}
									Thread.sleep(2000);
									driver.findElement(By.xpath("(//bdi[text()='Cancel']//ancestor::button)[1]")).click();
									Thread.sleep(2000);
									WebElement subscribeheader = driver.findElement(By.xpath("//bdi[text()='Subscribe Header']"));
									String textvaluesubscribe = subscribeheader.getText();
									WebElement subscribeinput =driver.findElement(By.xpath("//bdi[text()='Subscribe Header']//following::input[1]"));
									textvalue = subscribeinput.getAttribute("value");			
									if(!textvalue.isEmpty()) {
										headertextstatus = "On";
									}
									else {
										headertextstatus="Off";
									}
									PermissionHeader="";
									PermissionValue=new ArrayList<String>();
									PermissionHeader="OtherHeader";
									PermissionValue.add(textvaluesubscribe);
									PermissionValue.add(headertextstatus);

									//AddHeadertextvalue
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									Thread.sleep(2000);
									PermissionValue=new ArrayList<String>();
									ArrayList subscribefonttextlist = new ArrayList<>();
									PermissionValue.add(textvalue);

									driver.findElement(By.xpath("//bdi[text()='Subscribe Header']//following::button[1]")).click();		
									List<WebElement> subscribeheadersopts = driver.findElements(By.xpath("//div[@class='sapMDialogScroll']//child::div[contains(@class,'sapUiRespGridMedia-Std-Phone')]/div/label"));
									for(WebElement subscribeele:subscribeheadersopts) {
										String subscribeformtext = "";
										subscribeformtext=subscribeele.getText();
										if(subscribeformtext.equalsIgnoreCase("font")&&!subscribefonttextlist.contains(subscribeformtext)) {
											inputvalue="";
											WebElement font = driver.findElement(By.xpath("//bdi[text()='Font']//following::div[1]//span[@class='sapMSelectListItemText']"));
											inputvalue = font.getText();
											headerinput = "Font";
											subscribefonttextlist.add(subscribeformtext);
											countheadertext++;
										}
										else if (subscribeformtext.equalsIgnoreCase("Size")&&!subscribefonttextlist.contains(subscribeformtext)) {
											inputvalue="";
											WebElement size1 = driver.findElement(By.xpath("//bdi[text()='Size']//following::input[1]"));
											inputvalue = size1.getAttribute("value");
											headerinput = "Size";
											subscribefonttextlist.add(subscribeformtext);
											countheadertext++;
										}
										else if (subscribeformtext.equalsIgnoreCase("Alignment")&&!subscribefonttextlist.contains(subscribeformtext)) {
											inputvalue=driver.findElement(By.xpath("//bdi[text()='Alignment']//following::input[1]")).getAttribute("value");
											subscribefonttextlist.add(subscribeformtext);
										}
										else if (subscribeformtext.equalsIgnoreCase("Color")&&!fonttextlist.contains(subscribeformtext)) {
											inputvalue="";
											WebElement color = subscribeele.findElement(By.xpath("//bdi[text()='Color:']//following::div[2]//bdi[contains(@id,'colorPaletteControl')]"));
											inputvalue = color.getText();
											headerinput = "Color";
											fonttextlist.add(subscribeformtext);
											PermissionValue.add(headerinput+":"+inputvalue);
											subscribefonttextlist.add(subscribeformtext);
											countheadertext++;

										}
										else if (subscribeformtext.equalsIgnoreCase("Hide Header Text")&&!fonttextlist.contains(subscribeformtext)) {
											inputvalue="";
											WebElement Alignment = driver.findElement(By.xpath("//bdi[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));
											headerinput = "HideHeaderText";
											WebElement HideHeader = driver.findElement(By.xpath("//*[text()='Hide Header Text']/following::div[1]/div[@role='switch']"));
											String HideHeaderstatus = HideHeader.getAttribute("aria-checked");
											if(HideHeaderstatus.equals("true")) {
												inputvalue = "Yes";
											}
											else {
												inputvalue = "No";
											}
											subscribefonttextlist.add(subscribeformtext);
											countheadertext++;
										}

										PermissionHeader="";
										PermissionHeader="OtherHeader";
										PermissionValue.add(headerinput+":"+inputvalue);


									}
									WebElement colourinputvalueele = driver.findElement(By.xpath("//*[text()='Color:']/following::div[2]//bdi[contains(@id,'colorPaletteControl')]"));
									inputvalue=colourinputvalueele.getText();
									moveToElement(driver, colourinputvalueele);

									headerinput=driver.findElement(By.xpath("//bdi[text()='Color:']")).getText();
									PermissionHeader="";

									//add colour value
									PermissionHeader="OtherHeader";
									PermissionValue.add(headerinput+":"+inputvalue);
									countheadertext++;
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									Thread.sleep(3000);
									WebElement closebutton = driver.findElement(By.xpath("//bdi[text()='Close']//ancestor::button[1]"));	
									moveToElement(driver, closebutton);
									closebutton.click();
									Thread.sleep(5000);	
									//subscribebody
									countheadertext=0;

									WebElement subscribebody = driver.findElement(By.xpath("//bdi[text()='Subscribe Body']"));
									moveToElement(driver, subscribebody);
									String textvaluesubscribebody = subscribebody.getText();
									WebElement subscribebodyinput =driver.findElement(By.xpath("//bdi[text()='Subscribe Body']//following::input[1]"));
									moveToElement(driver, subscribebodyinput);
									textvalue = subscribebodyinput.getAttribute("value");		
									if(!textvalue.isEmpty()) {
										headertextstatus = "On";
									}
									else {
										headertextstatus="Off";
									}
									PermissionHeader="";
									PermissionValue=new ArrayList<String>();
									PermissionHeader="OtherHeader";
									PermissionValue.add(textvaluesubscribebody);
									PermissionValue.add(headertextstatus);

									//AddHeadertextvalue
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									Thread.sleep(2000);
									PermissionValue=new ArrayList<String>();
									ArrayList subscribebodylist = new ArrayList<>();
									PermissionValue.add(textvalue);

									WebElement SubscribeBodystylebutton = driver.findElement(By.xpath("//bdi[text()='Subscribe Body']//following::button[1]"));
									moveToElement(driver, SubscribeBodystylebutton);
									SubscribeBodystylebutton.click();
									Thread.sleep(5000);
									List<WebElement> subscribeheaderbodyopts = driver.findElements(By.xpath("//div[@class='sapMDialogScroll']//child::div[contains(@class,'sapUiRespGridMedia-Std-Phone')]/div/label"));

									for(WebElement subscribbodyele:subscribeheaderbodyopts) {
										String subscribeformtext = "";

										subscribeformtext = subscribbodyele.getText();
										if(subscribeformtext.equalsIgnoreCase("font")&&!subscribebodylist.contains(subscribeformtext)) {
											inputvalue="";
											WebElement font = driver.findElement(By.xpath("//bdi[text()='Font']//following::div[1]//span[@class='sapMSelectListItemText']"));
											moveToElement(driver, font);
											inputvalue = font.getText();
											headerinput = "Font";
											subscribebodylist.add(subscribeformtext);
											countheadertext++;
										}
										else if (subscribeformtext.equalsIgnoreCase("Size")&&!subscribebodylist.contains(subscribeformtext)) {
											inputvalue="";
											WebElement Sizesubscribebody = driver.findElement(By.xpath("//bdi[text()='Size']//following::input[1]"));
											moveToElement(driver, Sizesubscribebody);
											inputvalue = Sizesubscribebody.getAttribute("value");
											headerinput = "Size";
											subscribebodylist.add(subscribeformtext);
											countheadertext++;
										}

										PermissionHeader="";									
										PermissionHeader="OtherHeader";
										PermissionValue.add(headerinput+":"+inputvalue);


									}
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

									WebElement closesubscribebodystyle = driver.findElement(By.xpath("//bdi[text()='Close']//ancestor::button[1]"));	
									//moveToElement(driver, closesubscribebodystyle);
									closesubscribebodystyle.click();
									Thread.sleep(5000);		
									//showemaillabel value
									countheadertext=0;
									WebElement EmailLabel = driver.findElement(By.xpath("//bdi[text()='Show E-mail Label']"));
									moveToElement(driver, EmailLabel);
									String EmailLabeltext = EmailLabel.getText();
									WebElement EmailStatusele = EmailLabel.findElement(By.xpath("//bdi[text()='Show E-mail Label']//following::div[1]/div"));
									moveToElement(driver, EmailStatusele);
									String EmailStatus= EmailStatusele.getAttribute("aria-checked");
									if(EmailStatus.equals("true")) {
										Status="On";
									}
									else {
										Status="Off";
									}
									PermissionHeader="";
									PermissionValue=new ArrayList<String>();
									PermissionHeader="Detailsoptions";
									PermissionValue.add(EmailLabeltext);
									PermissionValue.add(Status);

									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									//EmailAdressLabel

									WebElement EmailAddressLabel = driver.findElement(By.xpath("//bdi[text()='E-mail Address Label']"));
									moveToElement(driver, EmailAddressLabel);
									String EmailAddressLabeltext = EmailAddressLabel.getText();
									Thread.sleep(1000);
									WebElement emailladresslabelinputele = driver.findElement(By.xpath("//bdi[text()='E-mail Address Label']//following::input[1]"));
									moveToElement(driver, emailladresslabelinputele);
									String emailladresslabelinput = emailladresslabelinputele.getAttribute("value");
									Thread.sleep(1000);
									String emailladresslabelstatus="";
									countheadertext=0;
									if(!emailladresslabelinput.isEmpty()) {
										emailladresslabelstatus="On";
									}
									else {
										emailladresslabelstatus="Off";
									}
									PermissionHeader="";
									PermissionValue=new ArrayList<String>();
									PermissionHeader="OtherHeader";
									PermissionValue.add(EmailAddressLabeltext);
									PermissionValue.add(emailladresslabelstatus);
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									Thread.sleep(2000);
									PermissionValue=new ArrayList<String>();
									ArrayList emaillabellist = new ArrayList<>();
									PermissionValue.add(emailladresslabelinput);

									WebElement emailadresslabelstylecloseele = driver.findElement(By.xpath("//bdi[text()='E-mail Address Label']//following::button[1]"));
									moveToElement(driver, emailadresslabelstylecloseele);
									emailadresslabelstylecloseele.click();	
									Thread.sleep(5000);
									List<WebElement> EmailAdressLabelopt = driver.findElements(By.xpath("//div[@class='sapMDialogScroll']//child::div[contains(@class,'sapUiRespGridMedia-Std-Phone')]/div/label"));

									for(WebElement EmailAdressLabelele:EmailAdressLabelopt) {
										String subscribeformtext = "";							
										subscribeformtext = EmailAdressLabelele.getText();
										if(subscribeformtext.equalsIgnoreCase("font")&&!emaillabellist.contains(subscribeformtext)) {
											inputvalue="";
											WebElement font = driver.findElement(By.xpath("//bdi[text()='Font']//following::div[1]//span[@class='sapMSelectListItemText']"));
											moveToElement(driver, font);
											inputvalue = font.getText();
											headerinput = "Font";
											emaillabellist.add(subscribeformtext);
											countheadertext++;
										}
										else if (subscribeformtext.equalsIgnoreCase("Size")&&!emaillabellist.contains(subscribeformtext)) {
											inputvalue="";
											WebElement adresslabelsize = driver.findElement(By.xpath("//bdi[text()='Size']//following::input[1]"));
											moveToElement(driver, adresslabelsize);
											inputvalue = adresslabelsize.getAttribute("value");
											headerinput = "Size";
											emaillabellist.add(subscribeformtext);
											countheadertext++;
										}
										PermissionHeader="";

										PermissionHeader="OtherHeader";
										PermissionValue.add(headerinput+":"+inputvalue);


									}
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									Thread.sleep(3000);
									WebElement adresslabelcloseele = driver.findElement(By.xpath("//bdi[text()='Close']//ancestor::button[1]"));
									moveToElement(driver, adresslabelcloseele);
									adresslabelcloseele.click();
									Thread.sleep(5000);
									//String EmailAddressPlaceholderstatus
									String EmailAddressPlaceholderstatus="";
									WebElement EmailAddressPlaceholderelement  = driver.findElement(By.xpath("//bdi[text()='E-mail Address Placeholder']"));
									moveToElement(driver, EmailAddressPlaceholderelement);
									String EmailAddressPlaceholdertext = EmailAddressPlaceholderelement.getText();
									WebElement EmailAddressPlaceholderinputele = driver.findElement(By.xpath("//bdi[text()='E-mail Address Placeholder']//following::input[1]"));
									moveToElement(driver, EmailAddressPlaceholderinputele);
									String EmailAddressPlaceholderinput = EmailAddressPlaceholderinputele.getText();
									if(!EmailAddressPlaceholderinput.isEmpty()) {
										EmailAddressPlaceholderstatus = "On";
									}
									else {
										EmailAddressPlaceholderstatus="Off";
									}
									PermissionHeader="";
									PermissionValue=new ArrayList<String>();
									PermissionHeader="Detailsoptions";
									PermissionValue.add(EmailAddressPlaceholdertext);
									PermissionValue.add(EmailAddressPlaceholderstatus);								
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									//Subscribe Button values
									Thread.sleep(1000);
									WebElement SubscribeButton = driver.findElement(By.xpath("//bdi[text()='Subscribe Button']"));
									moveToElement(driver, SubscribeButton);
									String SubscribeButtontext = SubscribeButton.getText();
									String SubscribeButtoninput = driver.findElement(By.xpath("//bdi[text()='Subscribe Button']//following::input[1]")).getAttribute("value");
									String SubscribeButtonstatus="";
									countheadertext=0;
									if(!SubscribeButtoninput.isEmpty()) {
										emailladresslabelstatus="On";
									}
									else {
										emailladresslabelstatus="Off";
									}
									PermissionHeader="";
									PermissionValue=new ArrayList<String>();
									PermissionHeader="OtherHeader";
									PermissionValue.add(SubscribeButtontext);
									PermissionValue.add(emailladresslabelstatus);
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									Thread.sleep(2000);
									PermissionValue=new ArrayList<String>();
									ArrayList SubscribeButtonlist = new ArrayList<>();
									PermissionValue.add(SubscribeButtoninput);
									WebElement SubscribeButtonstyle = driver.findElement(By.xpath("//bdi[text()='Subscribe Button']//following::button[1]"));
									moveToElement(driver, SubscribeButtonstyle);
									SubscribeButtonstyle.click();
									Thread.sleep(5000);
									List<WebElement> SubscribeButtonopt = driver.findElements(By.xpath("//div[@class='sapMDialogScroll']//child::div[contains(@class,'sapUiRespGridMedia-Std-Phone')]/div/label"));
									for(WebElement EmailAdressLabelele:SubscribeButtonopt) {
										String subscribeformtext = "";
										SubscribeButtontext = EmailAdressLabelele.getText();
										if(SubscribeButtontext.equalsIgnoreCase("font")&&!SubscribeButtonlist.contains(SubscribeButtontext)) {
											inputvalue="";
											WebElement font = driver.findElement(By.xpath("//bdi[text()='Font']//following::div[1]//span[@class='sapMSelectListItemText']"));
											moveToElement(driver, font);
											inputvalue = font.getText();
											headerinput = "Font";
											SubscribeButtonlist.add(SubscribeButtontext);
											countheadertext++;
										}
										else if (SubscribeButtontext.equalsIgnoreCase("Size")&&!SubscribeButtonlist.contains(SubscribeButtontext)) {
											inputvalue="";
											WebElement SubscribeButtonsize = driver.findElement(By.xpath("//bdi[text()='Size']//following::input[1]"));
											moveToElement(driver, SubscribeButtonsize);
											inputvalue = SubscribeButtonsize.getAttribute("value");
											headerinput = "Size";
											SubscribeButtonlist.add(SubscribeButtontext);
											countheadertext++;
										}
										PermissionHeader="";
										PermissionHeader="OtherHeader";
										PermissionValue.add(headerinput+":"+inputvalue);


									}
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									Thread.sleep(3000);
									WebElement SubscribeButtonstyleclose = driver.findElement(By.xpath("//bdi[text()='Close']//ancestor::button[1]"));
									moveToElement(driver, SubscribeButtonstyleclose);
									SubscribeButtonstyleclose.click();	
									Thread.sleep(5000);
									//Subscribe Already Member Link values
									WebElement SubscribeAlreadyMemberLinkbutton = driver.findElement(By.xpath("//bdi[text()='Subscribe Already Member Link']"));
									moveToElement(driver, SubscribeAlreadyMemberLinkbutton);
									String SubscribeAlreadyMemberLinktext = SubscribeAlreadyMemberLinkbutton.getText();
									WebElement SubscribeAlreadyMemberLinkinputele = driver.findElement(By.xpath("//bdi[text()='Subscribe Already Member Link']//following::input[1]"));
									moveToElement(driver, SubscribeAlreadyMemberLinkinputele);
									String SubscribeAlreadyMemberLinkbuttoninput = SubscribeAlreadyMemberLinkinputele.getAttribute("value");
									String SubscribeAlreadyMemberLinkbuttonstatus="";
									countheadertext=0;
									if(!SubscribeButtoninput.isEmpty()) {
										SubscribeAlreadyMemberLinkbuttonstatus="On";
									}
									else {
										SubscribeAlreadyMemberLinkbuttonstatus="Off";
									}
									PermissionHeader="";
									PermissionValue=new ArrayList<String>();
									PermissionHeader="OtherHeader";
									PermissionValue.add(SubscribeAlreadyMemberLinktext);
									PermissionValue.add(SubscribeAlreadyMemberLinkbuttonstatus);
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									Thread.sleep(2000);
									PermissionValue=new ArrayList<String>();
									ArrayList SubscribeAlreadyMemberLinklist = new ArrayList<>();
									PermissionValue.add(SubscribeAlreadyMemberLinkbuttoninput);

									WebElement SubscribeAlreadyMemberLinkstyleclose = driver.findElement(By.xpath("//bdi[text()='Subscribe Already Member Link']//following::button[1]"));
									moveToElement(driver, SubscribeAlreadyMemberLinkstyleclose);
									SubscribeAlreadyMemberLinkstyleclose.click();
									Thread.sleep(5000);
									List<WebElement> SubscribeAlreadyMemberLink = driver.findElements(By.xpath("//div[@class='sapMDialogScroll']//child::div[contains(@class,'sapUiRespGridMedia-Std-Phone')]/div/label"));
									for(WebElement EmailAdressLabelele:SubscribeAlreadyMemberLink) {
										String subscribeformtext = "";
										String SubscribeAlreadyMemberLinklisttext = EmailAdressLabelele.getText();
										if(SubscribeAlreadyMemberLinklisttext.equalsIgnoreCase("font")&&!SubscribeAlreadyMemberLinklist.contains(SubscribeAlreadyMemberLinklisttext)) {
											inputvalue="";
											WebElement font = driver.findElement(By.xpath("//bdi[text()='Font']//following::div[1]//span[@class='sapMSelectListItemText']"));
											moveToElement(driver, font);
											inputvalue = font.getText();
											headerinput = "Font";
											SubscribeAlreadyMemberLinklist.add(SubscribeAlreadyMemberLinklisttext);
											countheadertext++;
										}
										else if (SubscribeAlreadyMemberLinklisttext.equalsIgnoreCase("Size")&&!SubscribeAlreadyMemberLinklist.contains(SubscribeAlreadyMemberLinklisttext)) {
											inputvalue="";
											WebElement subscribeAlreadyMemberLinksize = driver.findElement(By.xpath("//bdi[text()='Size']//following::input[1]"));
											moveToElement(driver, subscribeAlreadyMemberLinksize);
											inputvalue = subscribeAlreadyMemberLinksize.getAttribute("value");
											headerinput = "Size";
											SubscribeAlreadyMemberLinklist.add(SubscribeAlreadyMemberLinklisttext);
											countheadertext++;
										}
										PermissionHeader="";
										PermissionHeader="OtherHeader";
										PermissionValue.add(headerinput+":"+inputvalue);


									}
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									Thread.sleep(3000);
									WebElement subscribeAlreadyMemberstleclose = driver.findElement(By.xpath("//bdi[text()='Close']//ancestor::button[1]"));
									moveToElement(driver, subscribeAlreadyMemberstleclose);
									subscribeAlreadyMemberstleclose.click();
									Thread.sleep(500);
									//View Profile Link values
									WebElement ViewProfileLink = driver.findElement(By.xpath("//bdi[text()='View Profile Link']"));
									moveToElement(driver, ViewProfileLink);
									String ViewProfileLinktext = ViewProfileLink.getText();
									String ViewProfileLinkinput = driver.findElement(By.xpath("//bdi[text()='View Profile Link']//following::input[1]")).getAttribute("value");
									String ViewProfileLinkstatus="";
									countheadertext=0;
									if(!SubscribeButtoninput.isEmpty()) {
										ViewProfileLinkstatus="On";
									}
									else {
										ViewProfileLinkstatus="Off";
									}
									PermissionHeader="";
									PermissionValue=new ArrayList<String>();
									PermissionHeader="OtherHeader";
									PermissionValue.add(ViewProfileLinktext);
									PermissionValue.add(ViewProfileLinkstatus);
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									Thread.sleep(2000);
									PermissionValue=new ArrayList<String>();
									ArrayList ViewProfileLinklist = new ArrayList<>();
									PermissionValue.add(ViewProfileLinkinput);

									WebElement ViewProfileLinkstyleele = driver.findElement(By.xpath("//bdi[text()='View Profile Link']//following::button[1]"));
									moveToElement(driver, ViewProfileLinkstyleele);
									ViewProfileLinkstyleele.click();
									Thread.sleep(5000);
									List<WebElement> ViewProfileLinkopt = driver.findElements(By.xpath("//div[@class='sapMDialogScroll']//child::div[contains(@class,'sapUiRespGridMedia-Std-Phone')]/div/label"));
									for(WebElement ViewProfileLinkele:ViewProfileLinkopt) {
										String subscribeformtext = "";
										String viewProfileLinkopttext = ViewProfileLinkele.getText();
										if(viewProfileLinkopttext.equalsIgnoreCase("font")&&!ViewProfileLinklist.contains(viewProfileLinkopttext)) {
											inputvalue="";
											WebElement font = driver.findElement(By.xpath("//bdi[text()='Font']//following::div[1]//span[@class='sapMSelectListItemText']"));
											moveToElement(driver, font);
											inputvalue = font.getText();
											headerinput = "Font";
											ViewProfileLinklist.add(viewProfileLinkopttext);
											countheadertext++;
										}
										else if (viewProfileLinkopttext.equalsIgnoreCase("Size")&&!ViewProfileLinklist.contains(viewProfileLinkopttext)) {
											inputvalue="";
											WebElement viewProfileLinksize = driver.findElement(By.xpath("//bdi[text()='Size']//following::input[1]"));
											moveToElement(driver, viewProfileLinksize);
											inputvalue = viewProfileLinksize.getAttribute("value");
											headerinput = "Size";
											ViewProfileLinklist.add(viewProfileLinkopttext);
											countheadertext++;
										}
										PermissionHeader="";
										PermissionHeader="OtherHeader";
										PermissionValue.add(headerinput+":"+inputvalue);


									}
									Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);
									Thread.sleep(3000);
									WebElement viewProfileLinkstyleclose = driver.findElement(By.xpath("//bdi[text()='Close']//ancestor::button[1]"));
									moveToElement(driver, viewProfileLinkstyleclose);
									viewProfileLinkstyleclose.click();	
									Thread.sleep(8000);
								}else if (optionname.equalsIgnoreCase("Images")) {

								}else if (optionname.equalsIgnoreCase("Styles")) {
									String switchvalue="";
									counterstyle=0;
									columncounter=columncounter+1;
									WebElement optionelement = null;
									try {
										optionelement=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Styles']//ancestor::div[@role='tab'])[1]")));
									}
									catch (Exception e) {
										optionelement = driver.findElement(By.xpath("((//div[@class='sapMITBHead'])[1]//following::span[text()='Styles']//ancestor::div[@role='tab'])[1]"));
									}


									optionelement.click();
									PermissionHeader="";
									PermissionValue=new ArrayList<String>();
									Thread.sleep(5000);
									List<WebElement> stylesoptions = optionelement.findElements(By.xpath("//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper']"));
									int xpathcounter = 0;
									for(int stylecounter=0;stylecounter<stylesoptions.size();stylecounter++) {
										if(stylecounter>0) {
											counterstyle=counterstyle+1;


										}


										PermissionValue=new ArrayList<String>();
										ArrayList<String>Styleoptionlist = new ArrayList<>();
										String detailoptiontext = stylesoptions.get(stylecounter).getText();
										if(detailoptiontext.equalsIgnoreCase("Text")&&!Styleoptionlist.contains(detailoptiontext)) {
											WebElement textele = driver.findElement(By.xpath("//bdi[text()='Text']"));
											moveToElement(driver, textele);
											String Textoptionlabel=textele.getText();
											Thread.sleep(1000);
											WebElement textoptionvaluele = driver.findElement(By.xpath("(//bdi[text()='Text']//following::bdi)[1]"));
											moveToElement(driver, textoptionvaluele);
											String Textoptionvalue = textoptionvaluele.getText();
											Thread.sleep(1000);
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(Textoptionlabel);
											PermissionValue.add(Textoptionvalue);
											xpathcounter=xpathcounter+1;


										}
										else if(detailoptiontext.equals("Background")&&!Styleoptionlist.contains(detailoptiontext)) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											WebElement backgroundele = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi"));
											moveToElement(driver, backgroundele);
											String detailoptiontextvalue = backgroundele.getText();


											PermissionHeader="";


											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);

										}
										else if (detailoptiontext.equalsIgnoreCase("Link")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											WebElement linkele = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi"));
											moveToElement(driver, linkele);
											String detailoptiontextvalue = linkele.getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);



										}
										else if (detailoptiontext.equalsIgnoreCase("Link Hover")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											WebElement linkhoverele = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]/bdi[1]//following::span[contains(@id,'colorPaletteControl')][2]/bdi"));
											moveToElement(driver, linkhoverele);
											String detailoptiontextvalue =linkhoverele.getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Background Image")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											WebElement imageele;
											String imagevalue = "";
											try {
												imageele = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::img[1]"));
												moveToElement(driver, imageele);
											}
											catch (Exception e) {
												imageele=null;
											}


											if(imageele.isDisplayed()&&!imageele.equals(null)) {
												imagevalue="On";
											}
											else {
												imagevalue="Off";
											}
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(imagevalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Image Type")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											WebElement detailoptiontextele = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]"));
											moveToElement(driver, detailoptiontextele);
											String detailoptiontextvalue =detailoptiontextele.getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);


										}
										else if (detailoptiontext.equalsIgnoreCase("Image Position")) {
											Styleoptionlist.add(detailoptiontext);
											xpathcounter=xpathcounter+1;
											WebElement detailoptiontextvalueele = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]"));
											moveToElement(driver, detailoptiontextvalueele);
											String detailoptiontextvalue = detailoptiontextvalueele.getText();
											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(detailoptiontextvalue);

										}
										else if (detailoptiontext.equalsIgnoreCase("Enable Spacing:")) {
											String EnableSpacing="";

											xpathcounter=xpathcounter+1;
											Styleoptionlist.add(detailoptiontext);
											WebElement switchobj = driver.findElement(By.xpath("(//bdi[text()='Enable Spacing:'])[1]//following::div[@role='switch']"));
											moveToElement(driver, switchobj);
											switchvalue = switchobj.getAttribute("aria-checked");
											if(switchvalue.equals("true")) {
												EnableSpacing = "On";
											}
											else {
												EnableSpacing = "Off";
											}

											PermissionHeader="";
											PermissionHeader="Styleoptions";
											PermissionValue.add("Style");
											PermissionValue.add(detailoptiontext);
											PermissionValue.add(EnableSpacing);


										}
										else if (detailoptiontext.equalsIgnoreCase("Top")) {
											List<WebElement> valueoptions = optionelement.findElements(By.xpath("//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper']"));
											PermissionValue=new ArrayList<String>();
											ArrayList<String>Styvalueleoptionlist1 = new ArrayList<>();

											int duplicatepermissionno=0;
											for(int approvetextcounter=0;approvetextcounter<valueoptions.size();approvetextcounter++) {

												String detailvaluetext = valueoptions.get(approvetextcounter).getText();
												if (detailvaluetext.equalsIgnoreCase("Top")) {
													xpathcounter=xpathcounter+1;
													PermissionValue=new ArrayList<>();

													String Topvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="ApprovedText";

													PermissionValue.add(detailoptiontext+":"+Topvalue);


												}
												else if (detailvaluetext.equalsIgnoreCase("Bottom")) {
													xpathcounter=xpathcounter+1;

													String Bottomvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Bottomvalue);

												}
												else if (detailvaluetext.equalsIgnoreCase("Right")) {
													xpathcounter=xpathcounter+1;

													String Rightvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Rightvalue);


												}
												else if (detailvaluetext.equalsIgnoreCase("Left")) {
													xpathcounter=xpathcounter+1;							 
													String Leftvalue = driver.findElement(By.xpath("(//div[@class='sapMITBContainerContent']//span[@class='sapMLabelTextWrapper'])["+xpathcounter+"]//following::span[@class='sapMSelectListItemText'][1]")).getText();
													PermissionHeader="";
													PermissionHeader="Refertext";

													PermissionValue.add(detailvaluetext+":"+Leftvalue);


												}
											}

										}

										if(!PermissionValue.isEmpty()) {
											//add options from style
											Writetoexcel(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx", "RMKPermissions", PermissionHeader, PermissionValue, Permissionname);

										}


									}
									Thread.sleep(1000);
									System.out.println();




								}
							}
							boolean homeelement=helper.waitForClickable(CSB.HomeLink);
							if(homeelement) {

								CSB.HomeLink.click();
								Thread.sleep(3000);
								logger.info("Info and Subscribe Form executioncompleted");
							}




						} catch (Exception e) {
							logger.info("Info and Subscribe Form execution Failed");
						}
					}

				}
			}
			componenetStyle(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx");
			EnhancOfRPAStyle(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx");
			grayColorStyle(filePath + "/" + "RMKRoles"  + "_" + outputTimeStamp + ".xlsx");

			Timestamp endTime = new Timestamp(System.currentTimeMillis());
	        System.out.println("End Time of Execution : " +endTime);

			driver.close();
			logger.info("driver is closed");
		}
		catch (Exception e) {
			logger.info(e.getMessage());
			driver.close();	
		}

		return result;
	}





	private static String getCellData(String filePath, String sheetname, String colName, int rowNum) {
		Cell headercell = null;
		Row headerrow;

		try{
			File file= new File(filePath);
			FileInputStream fis= new FileInputStream(file);
			XSSFWorkbook Workbook = new XSSFWorkbook(fis);
			int col_Num=0;		
			XSSFSheet inputsheet = Workbook.getSheet(sheetname);
			Row inputrow = inputsheet.getRow(0);


			for(int i=0;i<inputrow.getLastCellNum();i++){
				//System.out.println(row.getCell(i).getStringCellValue().trim());
				String inputvalue = inputrow.getCell(i).getStringCellValue().trim();
				String value = colName.trim();

				if(inputvalue.equals(colName.trim())) {
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
			if(headercell.getCellType()==Cell.CELL_TYPE_STRING) {
				return headercell.getStringCellValue();
			}
			else if(headercell.getCellType()==Cell.CELL_TYPE_NUMERIC || headercell.getCellType()==Cell.CELL_TYPE_FORMULA ){

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

	public static void grayColorStyle(String pth) throws IOException{
		String path=pth;
	FileInputStream fis = new FileInputStream(path);
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet("RMKPermissions");//name of the sheet
	System.out.println(sheet.getSheetName());
	System.out.println(sheet.getLastRowNum());
	System.out.println(sheet.getRow(2).getCell(2));
	int count=0;
	for(int i=2;i<=sheet.getLastRowNum();i++) {
		 XSSFCell ss=sheet.getRow(i).getCell(1);
		 try {
		 CellStyle cellStyle = ss.getCellStyle();
		 String color=cellStyle.getFillForegroundColorColor().toString();
		// System.out.println(color);
		 if((color.equalsIgnoreCase("org.apache.poi.xssf.usermodel.XSSFColor@1f2abf39"))||(color.equalsIgnoreCase("org.apache.poi.xssf.usermodel.XSSFColor@1f5662d9"))) {
		 int rowNo=ss.getRowIndex();
		/* System.out.println(rowNo);*/
		 Row toColor=sheet.getRow(rowNo);
		 for(int j=0;j<=6;j++) {
			 CellStyle xssfStyles=workbook.createCellStyle();
				Font font=workbook.createFont();
				font.setColor(IndexedColors.BLACK.getIndex());
				//XSSFColor red=new XSSFColor(new java.awt.Color(111,140,222));
				xssfStyles.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
				xssfStyles.setFillPattern(CellStyle.SOLID_FOREGROUND);
				//xssfStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				xssfStyles.setFont(font);
			 if(j==1) {
				 Cell c=toColor.getCell(j);
				 c.setCellStyle(xssfStyles);
				 continue;}
			 Cell newCell=toColor.createCell(j);
			 newCell.setCellStyle(xssfStyles);
		 }
		 
		 }
		 }
		 catch(Exception e) {
			 continue;
		 }
		
		 count+=1;
		 
		// System.out.println(count);
	}


	FileOutputStream fos1 = new FileOutputStream(path);
		workbook.write(fos1);
		fos1.flush();
		fos1.close();
		workbook.close();
		}


	private static void EnhancOfRPAStyle(String pth) throws IOException {
		String path=pth;
	    FileInputStream fis = new FileInputStream(path);
	    XSSFWorkbook workbook=new XSSFWorkbook(fis);
	    XSSFSheet sheet=workbook.getSheet("RMKPermissions");//name of the sheet
	    System.out.println(sheet.getSheetName());
	    System.out.println(sheet.getLastRowNum());
	    CellStyle xssfStyles=workbook.createCellStyle();
		Font font=workbook.createFont();
		font.setColor(IndexedColors.BLACK.getIndex());
		XSSFColor red=new XSSFColor(new java.awt.Color(111,140,222));
		xssfStyles.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		xssfStyles.setFillPattern(CellStyle.SOLID_FOREGROUND);
		//xssfStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		xssfStyles.setFont(font);
	    for(int i=0;i<=6;i++) {
	  	  XSSFCell ss=sheet.getRow(0).getCell(i);
	  	  if(i==0||i==2||i==3||i==4||i==5||i==6) {
	  		XSSFCell newCell=sheet.getRow(1).createCell(i);
			newCell.setCellStyle(xssfStyles);
			continue; 
	  	  }
	  	XSSFCell styl=sheet.getRow(1).getCell(i);
	  	styl.setCellStyle(xssfStyles);
	  	/*if(ss!=null) {
				CellStyle xssfStyles=workbook.createCellStyle();
				Font font=workbook.createFont();
				font.setColor(IndexedColors.BLACK.getIndex());
				XSSFColor red=new XSSFColor(new java.awt.Color(111,140,222));
				xssfStyles.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
				xssfStyles.setFillPattern(CellStyle.SOLID_FOREGROUND);
				//xssfStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				xssfStyles.setFont(font);
				for(int j=0;j<=6;j++) {
					
					XSSFCell styl=sheet.getRow(i).getCell(j);
					if(j==6) {
						XSSFCell newCell=sheet.getRow(i).createCell(j);
						newCell.setCellStyle(xssfStyles);
						continue;
					}
					styl.setCellStyle(xssfStyles);
				}
				
	  	 }*/
	  	 
	    }
	    System.out.println(sheet.getRow(2).getCell(2));
	    FileOutputStream fos1 = new FileOutputStream(path);
			workbook.write(fos1);
			fos1.flush();
			fos1.close();
			workbook.close();
			}

	private static void componenetStyle(String pth) throws IOException {

	      String path=pth;
	      FileInputStream fis = new FileInputStream(path);
	      XSSFWorkbook workbook=new XSSFWorkbook(fis);
	      XSSFSheet sheet=workbook.getSheet("RMKPermissions");//name of the sheet
	      System.out.println(sheet.getSheetName());
	      System.out.println(sheet.getLastRowNum());
	      for(int i=0;i<13;i++)
	    	  sheet.autoSizeColumn(i);
	      for(int i=1;i<=sheet.getLastRowNum();i++) {
	    	  XSSFCell ss=sheet.getRow(i).getCell(0);
	    	  
	    	  
	    	 if(ss!=null) {
	 			CellStyle xssfStyles=workbook.createCellStyle();
	 			Font font=workbook.createFont();
	 			font.setColor(IndexedColors.BLACK.getIndex());
	 			XSSFColor red=new XSSFColor(new java.awt.Color(111,140,222));
	 			xssfStyles.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
	 			xssfStyles.setFillPattern(CellStyle.SOLID_FOREGROUND);
	 			//xssfStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	 			xssfStyles.setFont(font);
	 			for(int j=0;j<=6;j++) {
	 				
	 				XSSFCell styl=sheet.getRow(i).getCell(j);
	 				if(j==6) {
	 					XSSFCell newCell=sheet.getRow(i).createCell(j);
	 					newCell.setCellStyle(xssfStyles);
	 					continue;
	 				}
	 				styl.setCellStyle(xssfStyles);
	 			}
	 			
	    	 }
	    	 
	      }
	      System.out.println(sheet.getRow(2).getCell(2));
	      FileOutputStream fos1 = new FileOutputStream(path);
			workbook.write(fos1);
			fos1.flush();
			fos1.close();
			workbook.close();
	}

	// Method to initialize the template and get the row object
	public static boolean InitializeTemplate(String ExcelPath, String Sheet)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		boolean result = false;
		try {
			inpFile = new FileInputStream(new File(ExcelPath));
			workbook = WorkbookFactory.create(inpFile);
			sheet = workbook.getSheet(Sheet);
			lastRow = sheet.getLastRowNum();
			row = sheet.getRow(templateCounter);
			result = true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorMessage = errorMessage + " Template File Issue - Please Validate Excel File Name or Sheet Name" + "\n";
			result = false;
		}
		return result;
	}

	// Method to get the cellvalue by columnname
	public static String getcellValue(String Columnname)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		String returnValue = "";

		try {
			int destCol = findCol(sheet, Columnname);
			if (destCol != -1) {
				Cell cel = row.getCell(destCol);
				cel.setCellType(Cell.CELL_TYPE_STRING);
				returnValue = cel.toString();
			} else {

			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			returnValue = "";
		}
		return returnValue;
	}

	public static Sheet getInputSheet(String InputexcelPath, String Sheet)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		boolean result = false;
		try {
			inpFile = new FileInputStream(new File(InputexcelPath));
			workbook = WorkbookFactory.create(inpFile);
			sheet = workbook.getSheet(Sheet);

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			errorMessage = errorMessage + " Template File Issue - Please Validate Excel File Name or Sheet Name" + "\n";
			result = false;
		}
		return sheet;
	}

	// reruns the total number of rows
	public static int getRowCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum() + 1;
			short cellvalue = sheet.getRow(0).getFirstCellNum();
			return number;
		}
	}

	public static int getColumnCount(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			sheet = workbook.getSheetAt(index);
			int number = sheet.getRow(0).getLastCellNum();
			return number;
		}
	}

	public static String getCellContain(String sheetName, int rownumber) {
		int index = workbook.getSheetIndex(sheetName);
		sheet = workbook.getSheetAt(index);
		String value = sheet.getRow(rownumber).getCell(1).getStringCellValue();
		return value;

	}

	// Method to get the column index
	public static int findCol(Sheet sheet, String colName) {
		Row row = null;
		int colCount = 0;
		row = sheet.getRow(0);
		if (!(row == null)) {
			colCount = row.getLastCellNum();
		}
		for (int j = 0; j < colCount; j++) {
			if (!(row.getCell(j) == null)) {
				if (row.getCell(j).toString().trim().equalsIgnoreCase(colName)) {
					return j;
				}
			}
		}
		return -1;
	}

	// Method to hault the driver
	public static void waitForTime(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// failureReason = e.getMessage();
			e.printStackTrace();
		}
	}

	//==================================================================================================

	//=========================================================================================================

	public static boolean Writetoexcel(String filepath, String SheetName,String  header,ArrayList<String> value, ArrayList<String> permissionname) throws FileNotFoundException {
		boolean result = false;
		int lastrownosettings = 0;
		try {

			File file = new File(filepath);
			XSSFWorkbook wb = null;
			XSSFSheet sheet;
			Row headerrow = null;
			int RowCount = 0;
			Cell headercell;
			String rowstatus;
			if(!file.exists()) {
				String[] header_constants=new String[]{"SL.No","Homepage(English)","Settings","Desktop","Tablet","Mobile","Internal","External","Approved Text, Images or Copy \r\n" + "(if applicable)"};
				wb=new XSSFWorkbook();
				sheet = wb.createSheet(SheetName);
				CellStyle xssfStyle=wb.createCellStyle();
				Font font=wb.createFont();
				font.setColor(IndexedColors.WHITE.getIndex());
				XSSFColor red=new XSSFColor(new java.awt.Color(255,0,0));
				xssfStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
				xssfStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
				//xssfStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				xssfStyle.setFont(font);
				XSSFRow rowheader;


				Row row=sheet.createRow(0);
				for(int i=0;i<header_constants.length;i++) {
					Cell cell=row.createCell(i);
					cell.setCellValue(header_constants[i]);
					cell.setCellStyle(xssfStyle);
					//cell.setCellStyle((CellStyle) fontStyle);

				}

				FileOutputStream fos = new FileOutputStream(filepath);
				fos=new FileOutputStream(filepath);
				wb.write(fos);
				fos.flush();
				fos.close();
				wb.close();
				result=true;

			}else {
				FileInputStream fis = new FileInputStream(filepath);
				wb=new XSSFWorkbook(fis);
				sheet=wb.getSheet(SheetName);

				//XSSFColor red=new XSSFColor(new java.awt.Color(128,128,128));
				int lastrowcount = sheet.getLastRowNum();
				if(header.equalsIgnoreCase("HeaderSection")) {
					XSSFRow rowcount = sheet.getRow(0);
					int noofcolumncount = rowcount.getPhysicalNumberOfCells();

					/*Cell cellheader = rowheader.createCell(1);
					String inputvalue = value.get(0);
					cellheader.setCellValue(inputvalue);*/
					String header1 = "";
					for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
						String headersection = sheet.getRow(0).getCell(cellnum).toString().trim();
						XSSFCellStyle styleheader = wb.createCellStyle();
						styleheader.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
						styleheader.setFillPattern(CellStyle.SOLID_FOREGROUND);

						if(headersection.contains("Homepage(English)")) {
							headerrow=sheet.createRow(lastrowcount+1);
							headercell=headerrow.createCell(cellnum);
							String inputvalue1 = value.get(0);
							headercell.setCellValue(inputvalue1);
							headercell.setCellStyle(styleheader);
							break;
						}
					}

				}
				else if (header.equalsIgnoreCase("Permissions")) {

					XSSFRow rowcount = sheet.getRow(0);
					int noofcolumncount = rowcount.getPhysicalNumberOfCells();

					/*Cell cellheader = rowheader.createCell(1);
					String inputvalue = value.get(0);
					cellheader.setCellValue(inputvalue);
					cellheader.setCellStyle(style);
					 */String header1 = "";
					 CellStyle stylepermissionheader=wb.createCellStyle();
					 stylepermissionheader.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
					 stylepermissionheader.setFillPattern(CellStyle.SOLID_FOREGROUND);		
					 for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
						 String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();

						 if(headerpermission.contains("Homepage(English)")) {
							 XSSFRow rowheader = sheet.createRow(lastrowcount+1);
							 headercell=rowheader.createCell(cellnum);
							 String inputvalue1 = value.get(0);
							 headercell.setCellValue(inputvalue1);
							 headercell.setCellStyle(stylepermissionheader);
							 XSSFRow srnorow = sheet.getRow(lastrowcount+1);
							 XSSFCell srnocell = srnorow.createCell(0);
							 srnocell.setCellValue(value.get(1));

							 break;
						 }
					 }



				}
				else if (header.equalsIgnoreCase("Detailsoptions")) {

					XSSFRow rowcount = sheet.getRow(0);
					int noofcolumncount = rowcount.getPhysicalNumberOfCells();
					flag= false;


					for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
						String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();
						if(headerpermission.contains("Homepage(English)")) {
							XSSFRow rowheader = sheet.createRow(lastrowcount+1);
							headercell=rowheader.createCell(cellnum);
							String valuedetailoption = value.get(0);
							//valuedetailoption=valuedetailoption.replaceAll("[^a-zA-Z0-9]", " ").trim();
							headercell.setCellValue(valuedetailoption);

							break;

						}


					}
					for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
						String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();
						if(headerpermission.contains("Settings")) {

							XSSFRow rowheader = sheet.getRow(lastrowcount+1);

							if(rowheader.equals(null)) {
								sheet.createRow(lastrowcount+1);
							}									
							headercell=rowheader.createCell(cellnum);
							String valuedetailoption = value.get(1);
							//valuedetailoption=valuedetailoption.replaceAll("[^a-zA-Z0-9]", " ").trim();
							headercell.setCellValue(valuedetailoption);
							break;
						}

					}




				}
				else if (header.equalsIgnoreCase("RoleOptions")) {
					XSSFRow rowcount = sheet.getRow(0);
					lastrowcount = sheet.getLastRowNum();
					int noofcolumncount = rowcount.getPhysicalNumberOfCells();
					//settings options
					for(int cellnum=3;cellnum<noofcolumncount;cellnum++) {

						String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();
						if(value.get(0).toString().contains("Settings")) {
							if(cellnum>3) {
								break;
							}
							int rowsNum = sheet.getPhysicalNumberOfRows();
							lastrownosettings=sheet.getLastRowNum();
							String permissiontext = permissionname.get(0).toString();							
							XSSFRow rowheader = sheet.getRow(lastrownosettings);
							if(rowheader.equals(null)) {
								sheet.createRow(lastrownosettings);
							}									
							headercell=rowheader.createCell(2);
							String valuedetailoption = value.get(1);
							//valuedetailoption=valuedetailoption.replaceAll("[^a-zA-Z0-9]", " ").trim();
							if(counter<=0) {
								headercell.setCellValue("Off");
								break;
							}
							else {
								headercell.setCellValue(valuedetailoption);
								break;
							}



						}
						//tablet,Desktop and Mobile
						else if (headerpermission.equalsIgnoreCase(value.get(0).toString())) {
							int rowsNum = sheet.getPhysicalNumberOfRows();
							int lastrowchecbox = sheet.getLastRowNum();
							XSSFRow rowheader = sheet.getRow(lastrowchecbox);
							if(rowheader.equals(null)) {
								sheet.createRow(lastrowchecbox);
							}									
							headercell=rowheader.createCell(cellnum);
							String valuedetailoption = value.get(1);
							valuedetailoption=valuedetailoption.replaceAll("[^a-zA-Z0-9]", " ").trim();
							headercell.setCellValue(valuedetailoption);

						}








					}

				}
				else if (header.equalsIgnoreCase("OtherHeader")) {
					XSSFRow rowheader = null;
					int Lastrowno = sheet.getPhysicalNumberOfRows();
					XSSFRow rowcount = sheet.getRow(0);
					int noofcolumncount = rowcount.getPhysicalNumberOfCells();					

					if(header.equalsIgnoreCase("OtherHeader")&&countheadertext<=0) {
						for(int colno=0;colno<noofcolumncount;colno++) {
							String headerpermission = sheet.getRow(0).getCell(colno).toString().trim();

							if(headerpermission.equalsIgnoreCase("Homepage(English)")) {
								XSSFRow headertextrow = sheet.createRow(Lastrowno);
								XSSFCell headertextcell = headertextrow.createCell(colno);

								headertextcell.setCellValue(value.get(0));
								XSSFCell headertextcellvalue = headertextrow.createCell(colno+1);
								headertextcellvalue.setCellValue(value.get(1));

								break;
							}

						}	
					}
					if(countheadertext>0)
						for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
							XSSFRow headertextrow;
							Lastrowno = sheet.getPhysicalNumberOfRows();
							noofcolumncount = rowcount.getPhysicalNumberOfCells();					


							String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();

							if(headerpermission.contains("Approved Text")) {
								try {
									headertextrow = sheet.getRow(Lastrowno-1);
								}
								catch (Exception e) {
									headertextrow=null;
								}
								if(headertextrow==null) {

									headertextrow=sheet.createRow(Lastrowno);

								}
								XSSFCell headertextcell = headertextrow.createCell(cellnum);
								String headertextexcel=String.join("\n", value);
								headertextcell.setCellValue(headertextexcel);
								//headercell.setCellValue(valuedetailoption);
								//XSSFCell headercellsettings = rowheader.createCell(cellnum);
								//String valuestyleoption = value.get(2);
								//headercellsettings.setCellValue(valuestyleoption);
								break;

							}


						}

				}
				else if (header.equalsIgnoreCase("HeaderText")) {
					XSSFRow rowheader = null;
					int Lastrowno = sheet.getPhysicalNumberOfRows();
					XSSFRow rowcount = sheet.getRow(0);
					int noofcolumncount = rowcount.getPhysicalNumberOfCells();					

					if(header.equalsIgnoreCase("HeaderText")&&countheadertext<=0) {
						for(int colno=0;colno<noofcolumncount;colno++) {
							String headerpermission = sheet.getRow(0).getCell(colno).toString().trim();

							if(headerpermission.equalsIgnoreCase("Homepage(English)")) {
								XSSFRow headertextrow = sheet.createRow(Lastrowno);
								XSSFCell headertextcell = headertextrow.createCell(colno);

								headertextcell.setCellValue(header);
								XSSFCell headertextcellvalue = headertextrow.createCell(colno+1);
								headertextcellvalue.setCellValue(value.get(0));

								break;
							}

						}	
					}
					if(countheadertext>0)
						for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
							XSSFRow headertextrow;
							Lastrowno = sheet.getPhysicalNumberOfRows();
							noofcolumncount = rowcount.getPhysicalNumberOfCells();					


							String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();

							if(headerpermission.contains("Approved Text")) {
								try {
									headertextrow = sheet.getRow(Lastrowno-1);
								}
								catch (Exception e) {
									headertextrow=null;
								}
								if(headertextrow==null) {

									headertextrow=sheet.createRow(Lastrowno);

								}
								XSSFCell headertextcell = headertextrow.createCell(cellnum);
								String headertextexcel=String.join("\n", value);
								headertextcell.setCellValue(headertextexcel);
								//headercell.setCellValue(valuedetailoption);
								//XSSFCell headercellsettings = rowheader.createCell(cellnum);
								//String valuestyleoption = value.get(2);
								//headercellsettings.setCellValue(valuestyleoption);
								break;

							}


						}

				}
				else if (header.equalsIgnoreCase("BodyText")) {
					XSSFRow rowheader = null;
					int Lastrowno = sheet.getPhysicalNumberOfRows();
					XSSFRow rowcount = sheet.getRow(0);
					int noofcolumncount = rowcount.getPhysicalNumberOfCells();					

					if(header.equalsIgnoreCase("BodyText")&&countrbodytext<=0) {
						for(int colno=0;colno<noofcolumncount;colno++) {
							String headerpermission = sheet.getRow(0).getCell(colno).toString().trim();

							if(headerpermission.equalsIgnoreCase("Homepage(English)")) {
								XSSFRow headertextrow = sheet.createRow(Lastrowno);
								XSSFCell headertextcell = headertextrow.createCell(colno);

								headertextcell.setCellValue(header);
								XSSFCell headertextcellvalue = headertextrow.createCell(colno+1);
								headertextcellvalue.setCellValue(value.get(0));

								break;
							}

						}	
					}
					if(countrbodytext>0)
						for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
							XSSFRow headertextrow;
							Lastrowno = sheet.getPhysicalNumberOfRows();
							noofcolumncount = rowcount.getPhysicalNumberOfCells();					


							String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();

							if(headerpermission.contains("Approved Text")) {
								try {
									headertextrow = sheet.getRow(Lastrowno-1);
								}
								catch (Exception e) {
									headertextrow=null;
								}
								if(headertextrow==null) {

									headertextrow=sheet.createRow(Lastrowno);

								}
								XSSFCell headertextcell = headertextrow.createCell(cellnum);
								String headertextexcel=String.join("\n", value);
								headertextcell.setCellValue(headertextexcel);
								break;

							}


						}					
				}else if (header.equalsIgnoreCase("Fontoptions")) {
					XSSFRow rowheader = null;
					int Lastrowno = sheet.getLastRowNum();
					XSSFRow rowcount = sheet.getRow(0);
					int noofcolumncount = rowcount.getPhysicalNumberOfCells();

					for(int cellnum=1;cellnum<noofcolumncount;cellnum++) {
						String headersection = sheet.getRow(0).getCell(cellnum).toString().trim();	

						if(headersection.contains("Approved Text")) {
							int Lastrowno1 = sheet.getPhysicalNumberOfRows();
							for(int rownum=0;rownum<Lastrowno1;rownum++) {
								String rowinput = sheet.getRow(rownum).getCell(1).getStringCellValue();
								if(rowinput.equalsIgnoreCase("HeaderText")) {
									rowheader=sheet.getRow(rownum);
									headercell=rowheader.getCell(cellnum);
									String valuedetailoption = value.get(0);							
									headercell.setCellValue(valuedetailoption);
									break;

								}

							}



						}


					}


				}
				else if (header.equalsIgnoreCase("Styleoptions")) {
					XSSFRow rowheader = null;
					int Lastrowno = sheet.getPhysicalNumberOfRows();
					XSSFRow rowcount = sheet.getRow(0);
					int noofcolumncount = rowcount.getPhysicalNumberOfCells();					
					XSSFCellStyle styleheaderstyopt = wb.createCellStyle();
					styleheaderstyopt.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
					styleheaderstyopt.setFillPattern(CellStyle.SOLID_FOREGROUND);

					if(value.get(0).toString().equals("Style")&&counterstyle==0&&permissionname.get(0).toString().equals("Image Carousel")) {
						for(int colno=0;colno<noofcolumncount;colno++) {
							String headerpermission = sheet.getRow(0).getCell(colno).toString().trim();

							if(headerpermission.equalsIgnoreCase("Homepage(English)")) {
								XSSFRow stylerow = sheet.createRow(Lastrowno);
								XSSFCell stylecell = stylerow.createCell(colno);
								stylecell.setCellValue(value.get(0).toString());
								stylecell.setCellStyle(styleheaderstyopt);
								break;
							}

						}
						for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
							Lastrowno = sheet.getPhysicalNumberOfRows();
							noofcolumncount = rowcount.getPhysicalNumberOfCells();					


							String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();

							if(headerpermission.contains("Homepage(English)")) {
								try {
									rowheader = sheet.getRow(Lastrowno+1);
								}
								catch (Exception e) {
									rowheader=null;
								}
								if(rowheader==null) {

									rowheader=sheet.createRow(Lastrowno);

								}
								headercell=rowheader.createCell(cellnum);
								String valuedetailoption = value.get(1);
								headercell.setCellValue(valuedetailoption);
								XSSFCell headercellsettings = rowheader.createCell(cellnum+1);
								String valuestyleoption = value.get(2);
								headercellsettings.setCellValue(valuestyleoption);
								break;

							}


						}

					}
					else if (value.get(0).toString().equals("Style")&&counterstyle==0&&permissionname.get(0).toString().equals("Two Columns")) {
						for(int colno=0;colno<noofcolumncount;colno++) {
							String headerpermission = sheet.getRow(0).getCell(colno).toString().trim();

							if(headerpermission.equalsIgnoreCase("Homepage(English)")) {
								XSSFRow stylerow = sheet.createRow(Lastrowno);
								XSSFCell stylecell = stylerow.createCell(colno);
								stylecell.setCellValue(value.get(0).toString());
								stylecell.setCellStyle(styleheaderstyopt);
								break;
							}

						}
						for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
							Lastrowno = sheet.getPhysicalNumberOfRows();
							noofcolumncount = rowcount.getPhysicalNumberOfCells();					


							String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();

							if(headerpermission.contains("Homepage(English)")) {
								try {
									rowheader = sheet.getRow(Lastrowno+1);
								}
								catch (Exception e) {
									rowheader=null;
								}
								if(rowheader==null) {

									rowheader=sheet.createRow(Lastrowno);

								}
								headercell=rowheader.createCell(cellnum);
								String valuedetailoption = value.get(1);
								headercell.setCellValue(valuedetailoption);
								XSSFCell headercellsettings = rowheader.createCell(cellnum+1);
								String valuestyleoption = value.get(2);
								headercellsettings.setCellValue(valuestyleoption);
								break;

							}


						}




					}
					else if (value.get(0).toString().equals("Style")&&counterstyle==0&&permissionname.get(0).toString().equals("Info and Subscribe Form")) {
						for(int colno=0;colno<noofcolumncount;colno++) {
							String headerpermission = sheet.getRow(0).getCell(colno).toString().trim();

							if(headerpermission.equalsIgnoreCase("Homepage(English)")) {
								XSSFRow stylerow = sheet.createRow(Lastrowno);
								XSSFCell stylecell = stylerow.createCell(colno);
								stylecell.setCellValue(value.get(0).toString());
								stylecell.setCellStyle(styleheaderstyopt);
								break;
							}

						}
						for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
							Lastrowno = sheet.getPhysicalNumberOfRows();
							noofcolumncount = rowcount.getPhysicalNumberOfCells();					


							String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();

							if(headerpermission.contains("Homepage(English)")) {
								try {
									rowheader = sheet.getRow(Lastrowno+1);
								}
								catch (Exception e) {
									rowheader=null;
								}
								if(rowheader==null) {

									rowheader=sheet.createRow(Lastrowno);

								}
								headercell=rowheader.createCell(cellnum);
								String valuedetailoption = value.get(1);
								headercell.setCellValue(valuedetailoption);
								XSSFCell headercellsettings = rowheader.createCell(cellnum+1);
								String valuestyleoption = value.get(2);
								headercellsettings.setCellValue(valuestyleoption);
								break;

							}


						}




					}
					else if (value.get(0).toString().equals("Style")&&counterstyle==0&&permissionname.get(0).toString().equals("Image and Text Carousel")) {

						for(int colno=0;colno<noofcolumncount;colno++) {
							String headerpermission = sheet.getRow(0).getCell(colno).toString().trim();

							if(headerpermission.equalsIgnoreCase("Homepage(English)")) {
								XSSFRow stylerow = sheet.createRow(Lastrowno);
								XSSFCell stylecell = stylerow.createCell(colno);
								stylecell.setCellValue(value.get(0).toString());
								stylecell.setCellStyle(styleheaderstyopt);
								break;
							}

						}
						for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
							Lastrowno = sheet.getPhysicalNumberOfRows();
							noofcolumncount = rowcount.getPhysicalNumberOfCells();					


							String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();

							if(headerpermission.contains("Homepage(English)")) {
								try {
									rowheader = sheet.getRow(Lastrowno+1);
								}
								catch (Exception e) {
									rowheader=null;
								}
								if(rowheader==null) {

									rowheader=sheet.createRow(Lastrowno);

								}
								headercell=rowheader.createCell(cellnum);
								String valuedetailoption = value.get(1);
								headercell.setCellValue(valuedetailoption);
								XSSFCell headercellsettings = rowheader.createCell(cellnum+1);
								String valuestyleoption = value.get(2);
								headercellsettings.setCellValue(valuestyleoption);
								break;

							}


						}

					}
					else {
						for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
							Lastrowno = sheet.getPhysicalNumberOfRows();
							noofcolumncount = rowcount.getPhysicalNumberOfCells();					


							String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();

							if(headerpermission.contains("Homepage(English)")) {
								try {
									rowheader = sheet.getRow(Lastrowno+1);
								}
								catch (Exception e) {
									rowheader=null;
								}
								if(rowheader==null) {

									rowheader=sheet.createRow(Lastrowno);

								}
								headercell=rowheader.createCell(cellnum);
								String valuedetailoption = value.get(1);
								headercell.setCellValue(valuedetailoption);
								XSSFCell headercellsettings = rowheader.createCell(cellnum+1);
								String valuestyleoption = value.get(2);
								headercellsettings.setCellValue(valuestyleoption);
								break;

							}


						}


					}



				}
				/*else if (header.equalsIgnoreCase("Styleoptionstwocol")) {
					XSSFRow rowheader = null;
					int Lastrowno = sheet.getPhysicalNumberOfRows();
					XSSFRow rowcount = sheet.getRow(0);
					int noofcolumncount = rowcount.getPhysicalNumberOfCells();					
					XSSFCellStyle styleheaderstyopt = wb.createCellStyle();
					styleheaderstyopt.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
					styleheaderstyopt.setFillPattern(CellStyle.SOLID_FOREGROUND);

					if(value.get(0).toString().equals("Style")&&counterstyle==0&&permissionname.get(0).toString().equals("Two Columns")) {
						for(int colno=0;colno<noofcolumncount;colno++) {
							String headerpermission = sheet.getRow(0).getCell(colno).toString().trim();

							if(headerpermission.equalsIgnoreCase("Homepage(English)")) {
								XSSFRow stylerow = sheet.createRow(Lastrowno);
								XSSFCell stylecell = stylerow.createCell(colno);
								stylecell.setCellValue(value.get(0).toString());
								stylecell.setCellStyle(styleheaderstyopt);
								break;
							}

						}	
					}

						for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
							 Lastrowno = sheet.getPhysicalNumberOfRows();
							 noofcolumncount = rowcount.getPhysicalNumberOfCells();					


							String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();

							if(headerpermission.contains("Homepage(English)")) {
								 try {
								rowheader = sheet.getRow(Lastrowno+1);
								 }
								 catch (Exception e) {
									rowheader=null;
								}
								if(rowheader==null) {

									rowheader=sheet.createRow(Lastrowno);

								}
								headercell=rowheader.createCell(cellnum);
								String valuedetailoption = value.get(1);
								headercell.setCellValue(valuedetailoption);
								XSSFCell headercellsettings = rowheader.createCell(cellnum+1);
								 String valuestyleoption = value.get(2);
								headercellsettings.setCellValue(valuestyleoption);
								break;

							}


						}




				}





				 */				else if (header.equalsIgnoreCase("imageoptions")) {
					 XSSFRow rowheader = null;
					 int Lastrowno = sheet.getPhysicalNumberOfRows();
					 XSSFRow rowcount = sheet.getRow(0);
					 int noofcolumncount = rowcount.getPhysicalNumberOfCells();					
					 XSSFCellStyle styleheaderstyopt = wb.createCellStyle();
					 styleheaderstyopt.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
					 styleheaderstyopt.setFillPattern(CellStyle.SOLID_FOREGROUND);

					 if(value.get(0).toString().contains("Image")&&counterimg<=0) {
						 for(int colno=0;colno<noofcolumncount;colno++) {
							 String headerpermission = sheet.getRow(0).getCell(colno).toString().trim();

							 if(headerpermission.equalsIgnoreCase("Homepage(English)")) {
								 XSSFRow stylerow = sheet.createRow(Lastrowno);
								 XSSFCell stylecell = stylerow.createCell(colno);
								 stylecell.setCellValue(value.get(0).toString());
								 stylecell.setCellStyle(styleheaderstyopt);
								 break;
							 }

						 }	
					 }

					 for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
						 Lastrowno = sheet.getPhysicalNumberOfRows();
						 noofcolumncount = rowcount.getPhysicalNumberOfCells();					


						 String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();

						 if(headerpermission.contains("Homepage(English)")) {
							 try {
								 rowheader = sheet.getRow(Lastrowno+1);
							 }
							 catch (Exception e) {
								 rowheader=null;
							 }
							 if(rowheader==null) {

								 rowheader=sheet.createRow(Lastrowno);

							 }
							 headercell=rowheader.createCell(cellnum);
							 String valuedetailoption = value.get(1);
							 headercell.setCellValue(valuedetailoption);
							 XSSFCell headercellsettings = rowheader.createCell(cellnum+1);
							 String valuestyleoption = value.get(2);
							 headercellsettings.setCellValue(valuestyleoption);
							 break;

						 }

					 }




				 }
				 else if (header.equalsIgnoreCase("Slideptions")) {
					 XSSFRow rowheader = null;
					 int Lastrowno = sheet.getPhysicalNumberOfRows();
					 XSSFRow rowcount = sheet.getRow(0);
					 int noofcolumncount = rowcount.getPhysicalNumberOfCells();					
					 XSSFCellStyle styleheaderstyopt = wb.createCellStyle();
					 styleheaderstyopt.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
					 styleheaderstyopt.setFillPattern(CellStyle.SOLID_FOREGROUND);

					 if(value.get(0).toString().contains("Slide")&&counterimg<=0) {
						 for(int colno=0;colno<noofcolumncount;colno++) {
							 String headerpermission = sheet.getRow(0).getCell(colno).toString().trim();

							 if(headerpermission.equalsIgnoreCase("Homepage(English)")) {
								 XSSFRow stylerow = sheet.createRow(Lastrowno);
								 XSSFCell stylecell = stylerow.createCell(colno);
								 stylecell.setCellValue(value.get(0).toString());
								 stylecell.setCellStyle(styleheaderstyopt);
								 break;
							 }

						 }	
					 }

					 for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
						 Lastrowno = sheet.getPhysicalNumberOfRows();
						 noofcolumncount = rowcount.getPhysicalNumberOfCells();					


						 String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();

						 if(headerpermission.contains("Homepage(English)")) {
							 try {
								 rowheader = sheet.getRow(Lastrowno+1);
							 }
							 catch (Exception e) {
								 rowheader=null;
							 }
							 if(rowheader==null) {

								 rowheader=sheet.createRow(Lastrowno);

							 }
							 headercell=rowheader.createCell(cellnum);
							 String valuedetailoption = value.get(1);
							 headercell.setCellValue(valuedetailoption);
							 XSSFCell headercellsettings = rowheader.createCell(cellnum+1);
							 String valuestyleoption = value.get(2);
							 headercellsettings.setCellValue(valuestyleoption);
							 break;

						 }

					 }
				 }

				 else if (header.equalsIgnoreCase("Refertext")) {
					 XSSFRow rowcount = sheet.getRow(0);
					 XSSFRow headertextrow;
					 int noofcolumncount = rowcount.getPhysicalNumberOfCells();
					 int Lastrowno = sheet.getPhysicalNumberOfRows();
					 for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
						 XSSFRow headertextrow1;
						 Lastrowno = sheet.getPhysicalNumberOfRows();



						 String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();

						 if(headerpermission.contains("Approved Text")) {
							 try {
								 headertextrow1 = sheet.getRow(Lastrowno-1);
							 }
							 catch (Exception e) {
								 headertextrow1=null;
							 }
							 if(headertextrow1==null) {

								 headertextrow1=sheet.createRow(Lastrowno);

							 }
							 XSSFCell headertextcell = headertextrow1.createCell(cellnum);
							 String headertextexcel=String.join("\n", value);
							 headertextcell.setCellValue(headertextexcel);
							 //headercell.setCellValue(valuedetailoption);
							 //XSSFCell headercellsettings = rowheader.createCell(cellnum);
							 //String valuestyleoption = value.get(2);
							 //headercellsettings.setCellValue(valuestyleoption);
							 break;

						 }


					 }









				 }




				 else if(header.equalsIgnoreCase("GoogleJobMap")) {
					 CellStyle xssfStyle=wb.createCellStyle();
					 Font font=wb.createFont();
					 font.setColor(IndexedColors.BLACK.getIndex());
					 //XSSFColor red=new XSSFColor(new java.awt.Color(255,0,0));
					 xssfStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
					 xssfStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 xssfStyle.setFont(font);
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=0;
					 headercell = headerrow.createCell(i);
					 i+=1;
					 //headercell.setCellStyle(xssfStyle);
					headercell.setCellValue(value.get(0));
					 headercell = headerrow.createCell(i);
					 headercell.setCellStyle(xssfStyle);
					 headercell.setCellValue("Google Job Map - Detail and Styles");
					 i+=1;
					 headercell = headerrow.createCell(i);
					 String settingCheckbox="";
					 for(int k=1;k<4;k++) {
						 if(value.get(k).equalsIgnoreCase("true")) {
							 settingCheckbox="On";
							 break;
						 }
					 }
					 if(settingCheckbox.length()>0) {
						 headercell.setCellValue("On");
						 i+=1;
					 }
					 else {
						 headercell.setCellValue("Off");
						 i+=1;
					 }
					 headercell = headerrow.createCell(i);
					 i+=1;
					 for(int k=0;k<3;k++) {
						 if(value.get(k).equalsIgnoreCase("false")) {
							 headercell.setCellValue("Off");

						 }
						 else {
							 headercell.setCellValue("On");

						 }
						 headercell = headerrow.createCell(i);
						 i+=1;
					 }
				 }
				 else if(header.equalsIgnoreCase("GoogleMapDetails")) {
					 int size=permissionname.size();
					 int k=1;
					 CellStyle xssfStyle=wb.createCellStyle();
					 Font font=wb.createFont();
					 font.setColor(IndexedColors.BLACK.getIndex());
					 //XSSFColor red=new XSSFColor(new java.awt.Color(255,0,0));
					 xssfStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
					 xssfStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 xssfStyle.setFont(font);
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i+=1;
					 headercell.setCellValue("Google Job Map - Detail and Styles");
					 headercell.setCellStyle(xssfStyle);
					 for(int j=0;j<size;j++) {
						 lastrowcount = sheet.getLastRowNum();
						 headerrow=sheet.createRow((lastrowcount+1));
						 k=1;
						 headercell = headerrow.createCell(k);
						 k++;
						 headercell.setCellValue(permissionname.get(j));
						 headercell = headerrow.createCell(k);
						 k++;
						 headercell.setCellValue(value.get(j));
					 }
				 }
				 else if(header.equalsIgnoreCase("Subscribe Form Header")) {
					 CellStyle xssfStyle=wb.createCellStyle();
					 Font font=wb.createFont();
					 font.setColor(IndexedColors.BLACK.getIndex());
					 //XSSFColor red=new XSSFColor(new java.awt.Color(255,0,0));
					 xssfStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
					 xssfStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 xssfStyle.setFont(font);
					 int i=0;
					 headerrow=sheet.createRow((lastrowcount+1));
					 headercell = headerrow.createCell(i);
					 i+=1;
					 //headercell.setCellStyle(xssfStyle);
					 headercell.setCellValue(value.get(0));
					 headercell = headerrow.createCell(i);
					 headercell.setCellStyle(xssfStyle);
					 headercell.setCellValue("Subscribe Form");
					 i+=1;
					 headercell = headerrow.createCell(i);
					 String settingCheckbox="";
					 for(int k=1;k<4;k++) {
						 if(value.get(k).equalsIgnoreCase("true")) {
							 settingCheckbox="On";
							 break;
						 }
					 }
					 if(settingCheckbox.length()>0) {
						 headercell.setCellValue("On");
						 i+=1;
					 }
					 else {
						 headercell.setCellValue("Off");
						 i+=1;
					 }
					 headercell = headerrow.createCell(i);
					 i+=1;
					 for(int k=0;k<3;k++) {
						 if(value.get(k).equalsIgnoreCase("false")) {
							 headercell.setCellValue("Off");

						 }
						 else {
							 headercell.setCellValue("On");

						 }
						 headercell = headerrow.createCell(i);
						 i+=1;
					 }

				 }
				 else if(header.equalsIgnoreCase("Subscribe Form Header Text")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Header Text");
					 headercell = headerrow.createCell(i);
					 i++;
					 if(value.get(0).length()>0) {
						 headercell.setCellValue("On");
					 }
					 else {
						 headercell.setCellValue("Off");
					 }
					 i+=3;
					 headercell = headerrow.createCell(i);
					 i++;
					 String headertextexcel=String.join("\n", value);
					 headercell.setCellValue(headertextexcel);
				 }


				 else if(header.equalsIgnoreCase("Subscribe Form Body Text")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Body Text");
					 headercell = headerrow.createCell(i);
					 i++;
					 if(value.get(0).length()>0) {
						 headercell.setCellValue("On");
					 }
					 else {
						 headercell.setCellValue("Off");
					 }
					 i+=3;
					 headercell = headerrow.createCell(i);
					 i++;
					 String headertextexcel=String.join("\n", value);
					 headercell.setCellValue(headertextexcel);
				 }

				 else if(header.equalsIgnoreCase("Subscribe Form Show Email Label")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i+=1;
					 headercell.setCellValue("Show Email Label");
					 headercell = headerrow.createCell(i);
					 String headertextexcel=value.get(0);
					 String res="";
					 if(headertextexcel.equalsIgnoreCase("false"))
						 res="No";
					 else
						 res="Yes";
					 headercell.setCellValue(res);
				 }
				 else if(header.equalsIgnoreCase("Subscribe Form Label Text")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Label Text");
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue(value.get(0));
					 i+=3;
					 headercell = headerrow.createCell(i);
					 i++;
					 value.remove(0);
					 String headertextexcel=String.join("\n", value);
					 headercell.setCellValue(headertextexcel);
				 }
				 else if(header.equalsIgnoreCase("Subscribe Form Show PlaceHolder Text")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Show Place Holder Text");
					 headercell = headerrow.createCell(i);
					 String headertextexcel=String.join("", value);
					 headercell.setCellValue(headertextexcel);
				 }
				 else if(header.equalsIgnoreCase("Subscribe Form Button Text")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Button Text");
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue(value.get(0));
					 i+=3;
					 headercell = headerrow.createCell(i);
					 i++;
					 value.remove(0);
					 String headertextexcel=String.join("\n", value);
					 headercell.setCellValue(headertextexcel);
				 }
				 else if(header.equalsIgnoreCase("SubscribeMainStyle")) {
					 int size=permissionname.size();
					 int k=1;
					 lastrowcount = sheet.getLastRowNum();
					 CellStyle xssfStyle=wb.createCellStyle();
					 Font font=wb.createFont();
					 font.setColor(IndexedColors.BLACK.getIndex());
					 //XSSFColor red=new XSSFColor(new java.awt.Color(255,0,0));
					 xssfStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
					 xssfStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 xssfStyle.setFont(font);
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i+=1;
					 headercell.setCellValue("Styles");
					 headercell.setCellStyle(xssfStyle);
					 for(int j=0;j<size;j++) {
						 lastrowcount = sheet.getLastRowNum();
						 headerrow=sheet.createRow((lastrowcount+1));
						 k=1;
						 headercell = headerrow.createCell(k);
						 k++;
						 headercell.setCellValue(permissionname.get(j));
						 headercell = headerrow.createCell(k);
						 k++;
						 headercell.setCellValue(value.get(j));
					 }
				 }

				 else if(header.equalsIgnoreCase("Three Column Images with Caption checkbox")) {
					 CellStyle xssfStyle=wb.createCellStyle();
					 Font font=wb.createFont();
					 font.setColor(IndexedColors.BLACK.getIndex());
					 //XSSFColor red=new XSSFColor(new java.awt.Color(255,0,0));
					 xssfStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
					 xssfStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 xssfStyle.setFont(font);
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=0;
					 headercell = headerrow.createCell(i);
					 i+=1;
					 //headercell.setCellStyle(xssfStyle);
					 headercell.setCellValue(value.get(0));
					 headercell = headerrow.createCell(i);
					 headercell.setCellStyle(xssfStyle);
					 headercell.setCellValue("Three Column Images with Caption");
					 i+=1;
					 headercell = headerrow.createCell(i);
					 String settingCheckbox="";
					 for(int k=1;k<4;k++) {
						 if(value.get(k).equalsIgnoreCase("true")) {
							 settingCheckbox="On";
							 break;
						 }
					 }
					 if(settingCheckbox.length()>0) {
						 headercell.setCellValue("On");
						 i+=1;
					 }
					 else {
						 headercell.setCellValue("Off");
						 i+=1;
					 }
					 headercell = headerrow.createCell(i);
					 i+=1;
					 for(int k=0;k<3;k++) {
						 if(value.get(k).equalsIgnoreCase("false")) {
							 headercell.setCellValue("Off");

						 }
						 else {
							 headercell.setCellValue("On");

						 }
						 headercell = headerrow.createCell(i);
						 i+=1;
					 }
				 }
				 else if(header.equalsIgnoreCase("Three Column Images with Caption")) {
					 int size=value.size();
					 lastrowcount = sheet.getLastRowNum();
					 int k=1;
					 CellStyle xssfStyle=wb.createCellStyle();
					 Font font=wb.createFont();
					 font.setColor(IndexedColors.BLACK.getIndex());
					 //XSSFColor red=new XSSFColor(new java.awt.Color(255,0,0));
					 xssfStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
					 xssfStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 xssfStyle.setFont(font);
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i+=1;
					 headercell.setCellValue(value.get(0));
					 headercell.setCellStyle(xssfStyle);
					 for(int j=1;j<size;j++) {
						 if(permissionname.get(j).equalsIgnoreCase("Header Text 1")||permissionname.get(j).equalsIgnoreCase("Body Text")||permissionname.get(j).equalsIgnoreCase("Link Text")) {
							 lastrowcount = sheet.getLastRowNum();
							 headerrow=sheet.createRow((lastrowcount+1));
							 k=1;
							 headercell = headerrow.createCell(k);
							 k++;
							 headercell.setCellValue(permissionname.get(j));
							 headercell = headerrow.createCell(k);
							 k++;
							 String a=value.get(j);
							 String[] ary = a.split(" ");
							 if(ary[0].length()>1) {
								 headercell.setCellValue("On");
								 k=k+3;
								 headercell = headerrow.createCell(k);
								 k++;
								 headercell.setCellValue(value.get(j));
								 continue;
							 }
							 else {
								 headercell.setCellValue("Off");
								 continue;
							 }

						 }
						 System.out.println(j);
						 System.out.println(value.get(j));
						 System.out.println(permissionname.get(j));
						 lastrowcount = sheet.getLastRowNum();
						 headerrow=sheet.createRow((lastrowcount+1));
						 k=1;
						 headercell = headerrow.createCell(k);
						 k++;
						 headercell.setCellValue(permissionname.get(j));
						 headercell = headerrow.createCell(k);
						 k++;
						 headercell.setCellValue(value.get(j));
					 }
				 }
				 else if(header.equalsIgnoreCase("Three Column Images with Caption Styles")) {
					 int size=permissionname.size();
					 int k=1;
					 CellStyle xssfStyle=wb.createCellStyle();
					 Font font=wb.createFont();
					 font.setColor(IndexedColors.BLACK.getIndex());
					 //XSSFColor red=new XSSFColor(new java.awt.Color(255,0,0));
					 xssfStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
					 xssfStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 xssfStyle.setFont(font);
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i+=1;
					 headercell.setCellValue("Styles and Font");
					 headercell.setCellStyle(xssfStyle);
					 for(int j=0;j<size;j++) {
						 lastrowcount = sheet.getLastRowNum();
						 headerrow=sheet.createRow((lastrowcount+1));
						 k=1;
						 headercell = headerrow.createCell(k);
						 k++;
						 headercell.setCellValue(permissionname.get(j));
						 headercell = headerrow.createCell(k);
						 k++;
						 headercell.setCellValue(value.get(j));
					 }
				 }




				 else if(header.equalsIgnoreCase("VideoUrl")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Video URL or ID");
					 headercell = headerrow.createCell(i);
					 i++;
					 String videoUrl=String.join("",value);
					 headercell.setCellValue(videoUrl);
				 }

				 else if(header.equalsIgnoreCase("Video")) {
					 CellStyle xssfStyle=wb.createCellStyle();
					 Font font=wb.createFont();
					 font.setColor(IndexedColors.BLACK.getIndex());
					 //XSSFColor red=new XSSFColor(new java.awt.Color(255,0,0));
					 xssfStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
					 xssfStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 xssfStyle.setFont(font);
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=0;
					 headercell = headerrow.createCell(i);
					 i+=1;
					 //headercell.setCellStyle(xssfStyle);
					headercell.setCellValue(value.get(0));
					 headercell = headerrow.createCell(i);
					 headercell.setCellStyle(xssfStyle);
					 headercell.setCellValue("Video");
					 i+=1;
					 headercell = headerrow.createCell(i);
					 String settingCheckbox="";
					 for(int k=1;k<4;k++) {
						 if(value.get(k).equalsIgnoreCase("true")) {
							 settingCheckbox="On";
							 break;
						 }
					 }
					 if(settingCheckbox.length()>0) {
						 headercell.setCellValue("On");
						 i+=1;
					 }
					 else {
						 headercell.setCellValue("Off");
						 i+=1;
					 }
					 headercell = headerrow.createCell(i);
					 i+=1;
					 for(int k=0;k<3;k++) {
						 if(value.get(k).equalsIgnoreCase("false")) {
							 headercell.setCellValue("Off");

						 }
						 else {
							 headercell.setCellValue("On");

						 }
						 headercell = headerrow.createCell(i);
						 i+=1;
					 }
				 }

				 else if(header.equalsIgnoreCase("VideoType")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Video Type");
					 headercell = headerrow.createCell(i);
					 i++;
					 String videoType=String.join("",value);
					 headercell.setCellValue(videoType);
				 }




				 else if(header.equalsIgnoreCase("VideoLayout")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Layout");
					 headercell = headerrow.createCell(i);
					 i++;
					 String videoLayout=String.join("",value);
					 headercell.setCellValue(videoLayout);
				 }



				 else if(header.equalsIgnoreCase("VideoHeaderText")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Header Text");
					 headercell = headerrow.createCell(i);
					 i++;
					 if(value.get(0).length()>0) {
						 headercell.setCellValue("Yes");
					 }
					 else {
						 headercell.setCellValue("No");
					 }
					 i+=3;
					 headercell = headerrow.createCell(i);
					 i++;
					 String videoHeader=String.join("",value);
					 headercell.setCellValue(videoHeader);
				 }


				 else if(header.equalsIgnoreCase("VideoBodyText")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Body Text");
					 headercell = headerrow.createCell(i);
					 i++;
					 if(value.get(0).length()>0) {
						 headercell.setCellValue("Yes");
					 }
					 else {
						 headercell.setCellValue("No");
					 }
					 i+=3;
					 headercell = headerrow.createCell(i);
					 i++;
					 String bodyText=String.join("\n", value);
					 headercell.setCellValue(bodyText);
				 }


				 else if(header.equalsIgnoreCase("VideoAutoStart")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Auto Start Video");
					 headercell = headerrow.createCell(i);
					 i++;
					 String autoStart=value.get(0);
					 headercell.setCellValue(autoStart);
				 }


				 else if(header.equalsIgnoreCase("VideoAlternative")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Alternate Text");
					 headercell = headerrow.createCell(i);
					 i++;
					 if(value.get(0).length()>0) {
						 headercell.setCellValue("On");
					 }
					 else {
						 headercell.setCellValue("Off");
					 }
					 i+=3;
					 headercell = headerrow.createCell(i);
					 i++;
					 String alternativeText=String.join("\n", value);
					 headercell.setCellValue(alternativeText);
				 }



				 else if(header.equalsIgnoreCase("VideoMainStyle")) {
					 CellStyle xssfStyle=wb.createCellStyle();
					 Font font=wb.createFont();
					 font.setColor(IndexedColors.BLACK.getIndex());
					 //XSSFColor red=new XSSFColor(new java.awt.Color(255,0,0));
					 xssfStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
					 xssfStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 xssfStyle.setFont(font);
					 headerrow=sheet.createRow((lastrowcount+1));
					 headercell = headerrow.createCell(1);
					 headercell.setCellStyle(xssfStyle);
					 headercell.setCellValue("Styles and Font");
				 }


				 else if(header.equalsIgnoreCase("BodyTextVideo")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Body Text");
					 headercell = headerrow.createCell(i);
					 headercell = headerrow.createCell(i);
					 String headertextexcel=String.join("", value);
					 headercell.setCellValue(headertextexcel);
				 }


				 else if(header.equalsIgnoreCase("BackgroundVideo")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Background");
					 headercell = headerrow.createCell(i);
					 headercell = headerrow.createCell(i);
					 String headertextexcel=String.join("", value);
					 headercell.setCellValue(headertextexcel);
				 }


				 else if(header.equalsIgnoreCase("Link")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Link");
					 headercell = headerrow.createCell(i);
					 String linkVideo=value.get(0);
					 if(linkVideo.length()>1)
						 headercell.setCellValue("On");
					 else
						 headercell.setCellValue("Off");
				 }



				 else if(header.equalsIgnoreCase("Link Hover")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Link Hover");
					 headercell = headerrow.createCell(i);
					 String linkHoverVideo=value.get(0);
					 if(linkHoverVideo.length()>1)
						 headercell.setCellValue("On");
					 else
						 headercell.setCellValue("Off");
				 }

				 else if(header.equalsIgnoreCase("Enable Spacing")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Enable Spacing");
					 headercell = headerrow.createCell(i);
					 String headertextexcel=value.get(0);
					 if(headertextexcel.equalsIgnoreCase("false"))
						 headercell.setCellValue("Off");
					 else
						 headercell.setCellValue("On");
				 }
				 else if(header.equalsIgnoreCase("FeaturedJobs")) {
					 CellStyle xssfStyle=wb.createCellStyle();
					 Font font=wb.createFont();
					 font.setColor(IndexedColors.BLACK.getIndex());
					 //XSSFColor red=new XSSFColor(new java.awt.Color(255,0,0));
					 xssfStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
					 xssfStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 xssfStyle.setFont(font);
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=0;
					 headercell = headerrow.createCell(i);
					 i+=1;
					 //headercell.setCellStyle(xssfStyle);
					headercell.setCellValue(value.get(0));
					 headercell = headerrow.createCell(i);
					 headercell.setCellStyle(xssfStyle);
					 headercell.setCellValue("Featured Jobs");
					 i+=1;
					 headercell = headerrow.createCell(i);
					 String settingCheckbox="";
					 for(int k=1;k<4;k++) {
						 if(value.get(k).equalsIgnoreCase("true")) {
							 settingCheckbox="On";
							 break;
						 }
					 }
					 if(settingCheckbox.length()>0) {
						 headercell.setCellValue("On");
						 i+=1;
					 }
					 else {
						 headercell.setCellValue("Off");
						 i+=1;
					 }
					 headercell = headerrow.createCell(i);
					 i+=1;
					 for(int k=0;k<3;k++) {
						 if(value.get(k).equalsIgnoreCase("false")) {
							 headercell.setCellValue("Off");

						 }
						 else {
							 headercell.setCellValue("On");

						 }
						 headercell = headerrow.createCell(i);
						 i+=1;
					 }
				 }
				 else if(header.equalsIgnoreCase("FeaturedHeader")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Header Text");
					 headercell = headerrow.createCell(i);
					 i++;
					 if(value.get(0).length()>0) {
						 headercell.setCellValue("On");
					 }
					 else {
						 headercell.setCellValue("Off");
					 }
					 i+=3;
					 headercell = headerrow.createCell(i);
					 i++;
					 String headertextexcel=String.join("\n", value);
					 headercell.setCellValue(headertextexcel);
				 }
				 else if(header.equalsIgnoreCase("FeaturedShowButton")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Show Button");
					 headercell = headerrow.createCell(i);
					 i++;
					 if(value.get(0).length()>0) {
						 headercell.setCellValue("Yes");
					 }
					 else {
						 headercell.setCellValue("No");
					 }
				 }

				 else if(header.equalsIgnoreCase("FeaturedButtonType")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Button Type");
					 headercell = headerrow.createCell(i);
					 i++;
					 if(value.get(0).length()>0) {
						 headercell.setCellValue("Yes");
						 i+=3;
						 headercell = headerrow.createCell(i);
						 i++;
						 String headertextexcel=String.join("\n", value);
						 headercell.setCellValue(headertextexcel);
					 }
					 else {
						 headercell.setCellValue("No");
					 }

				 }

				 else if(header.equalsIgnoreCase("FeaturedButtonText")) {
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 int i=1;
					 headercell = headerrow.createCell(i);
					 i++;
					 headercell.setCellValue("Button Text");
					 headercell = headerrow.createCell(i);
					 i++;
					 if(value.get(0).length()>0) {
						 headercell.setCellValue("Yes");
					 }
					 else {
						 headercell.setCellValue("No");
					 }
					 i+=3;
					 headercell = headerrow.createCell(i);
					 i++;
					 String headertextexcel=String.join("\n", value);
					 headercell.setCellValue(headertextexcel);
				 }

				 else if(header.equalsIgnoreCase("FeaturedEditBtn")) {
					 /*lastrowcount = sheet.getLastRowNum();
					headerrow=sheet.createRow((lastrowcount+1));*/
					 //lastrowcount+=1;
					 int size=permissionname.size();

					 for(int j=0;j<size;j++) {
						 int i=1;
						 lastrowcount = sheet.getLastRowNum();
						 headerrow=sheet.createRow((lastrowcount+1));
						 headercell = headerrow.createCell(i);
						 i++;
						 headercell.setCellValue(permissionname.get(j));
						 headercell = headerrow.createCell(i);
						 i++;
						 headercell.setCellValue(value.get(j));
					 }
				 }
				/*	else if(header.equalsIgnoreCase("FeaturedEditBtn")) {
					lastrowcount = sheet.getLastRowNum();
					headerrow=sheet.createRow((lastrowcount+1));
					int size=value.size();
					int i=1;
					for(int j=0;j<size;j++) {
						headercell = headerrow.createCell(i);
						i++;
						headercell.setCellValue(arlo.get(0));
						i++;
						headercell.setCellValue(value.get(0));
						lastrowcount+=1;
						headerrow=sheet.createRow((lastrowcount+1));
					}
				}*/
				 else if(header.equalsIgnoreCase("FeaturedMenu")) {
					 CellStyle xssfStyle=wb.createCellStyle();
					 Font font=wb.createFont();
					 font.setColor(IndexedColors.BLACK.getIndex());
					 //XSSFColor red=new XSSFColor(new java.awt.Color(255,0,0));
					 xssfStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
					 xssfStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
					 xssfStyle.setFont(font);
					 int size=permissionname.size();
					 int k=1;
					 lastrowcount = sheet.getLastRowNum();
					 headerrow=sheet.createRow((lastrowcount+1));
					 headercell = headerrow.createCell(k);
					 k++;
					 headercell.setCellValue("Menu "+value.get(0));
					 headercell.setCellStyle(xssfStyle);
					 for(int j=1;j<value.size();j++) {
						 lastrowcount = sheet.getLastRowNum();
						 headerrow=sheet.createRow((lastrowcount+1));
						 k=1;
						 headercell = headerrow.createCell(k);
						 k++;
						 headercell.setCellValue(permissionname.get(j));
						 headercell = headerrow.createCell(k);
						 k++;
						 headercell.setCellValue(value.get(j));
						 /*	lastrowcount = sheet.getLastRowNum();
						headerrow=sheet.createRow((lastrowcount+1));*/
					 }
				 }








				 else if (header.contains("AddHeaderText")) {

					 XSSFRow rowheader = null;
					 int Lastrowno = sheet.getPhysicalNumberOfRows();
					 XSSFRow rowcount = sheet.getRow(0);
					 int noofcolumncount = rowcount.getPhysicalNumberOfCells();					
					 XSSFCellStyle styleheaderstyopt = wb.createCellStyle();
					 styleheaderstyopt.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
					 styleheaderstyopt.setFillPattern(CellStyle.SOLID_FOREGROUND);

					 if(value.get(0).toString().equals("Style")&&counterstyle<=0&&permissionname.get(0).toString().equals("Image Carousel")||permissionname.get(0).toString().equals("Two Columns")) {
						 for(int colno=0;colno<noofcolumncount;colno++) {
							 String headerpermission = sheet.getRow(0).getCell(colno).toString().trim();

							 if(headerpermission.equalsIgnoreCase("Homepage(English)")) {
								 XSSFRow stylerow = sheet.createRow(Lastrowno);
								 XSSFCell stylecell = stylerow.createCell(colno);
								 stylecell.setCellValue(value.get(0).toString());
								 stylecell.setCellStyle(styleheaderstyopt);
								 break;
							 }

						 }	
					 }

					 for(int cellnum=0;cellnum<noofcolumncount;cellnum++) {
						 Lastrowno = sheet.getPhysicalNumberOfRows();
						 noofcolumncount = rowcount.getPhysicalNumberOfCells();					


						 String headerpermission = sheet.getRow(0).getCell(cellnum).toString().trim();

						 if(headerpermission.contains("Homepage(English)")) {
							 try {
								 rowheader = sheet.getRow(Lastrowno+1);
							 }
							 catch (Exception e) {
								 rowheader=null;
							 }
							 if(rowheader==null) {

								 rowheader=sheet.createRow(Lastrowno);

							 }
							 headercell=rowheader.createCell(cellnum);
							 String valuedetailoption = value.get(1);
							 headercell.setCellValue(valuedetailoption);
							 XSSFCell headercellsettings = rowheader.createCell(cellnum+1);
							 String valuestyleoption = value.get(2);
							 headercellsettings.setCellValue(valuestyleoption);
							 break;

						 }


					 }




				 }

				FileOutputStream fos = new FileOutputStream(filepath);
				wb.write(fos);
				fos.flush();
				fos.close();
				wb.close();
				result=true;				

			}
		}catch (Exception e) {
			// TODO: handle exception
			result = false;
		}

		return result;
	}


	private static int getRowCount(Row headerrow) {
		int result = headerrow.getRowNum();
		return result;

	}

	public static boolean WriteOptions(String filepath, String header, ArrayList<String> value)
			throws FileNotFoundException {
		boolean result = true;
		try {
			// XSSFWorkbook wb = null;
			XSSFSheet sheet;
			Row headerrow;
			Cell headercell;
			FileInputStream fis = new FileInputStream(filepath);
			// wb=new XSSFWorkbook(fis);
			if (wb.getSheet("Permission Mapping") == null) {
				sheet = wb.createSheet("Permission Mapping");
				sheet.setDefaultColumnWidth(75);
				headerrow = sheet.createRow(0);
				CellStyle style = wb.createCellStyle();
				style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
				style.setFillPattern(CellStyle.SOLID_FOREGROUND);
				int columncell = headerrow.getLastCellNum() + 1;
				headercell = headerrow.createCell(columncell);
				headercell.setCellValue(header);
				headercell.setCellStyle(style);
				for (int i = 0; i < value.size(); i++) {
					headerrow = sheet.createRow(i + 1);
					headercell = headerrow.createCell(columncell);
					headercell.setCellValue(value.get(i));
				}
			} else {
				sheet = wb.getSheet("Permission Mapping");
				sheet.setDefaultColumnWidth(75);
				headerrow = sheet.getRow(0);
				CellStyle style = wb.createCellStyle();
				style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
				style.setFillPattern(CellStyle.SOLID_FOREGROUND);
				int columncell = headerrow.getLastCellNum();
				headercell = headerrow.createCell(columncell);
				headercell.setCellValue(header);
				headercell.setCellStyle(style);
				for (int i = 0; i < value.size(); i++) {
					headerrow = sheet.getRow(i + 1);
					if (headerrow == null) {
						headerrow = sheet.createRow(i + 1);
					}
					headercell = headerrow.createCell(columncell);
					headercell.setCellValue(value.get(i));
				}
			}
			/*
			 * sheet.protectSheet("Test123"); sheet.enableLocking();
			 * sheet.lockSelectLockedCells(true); sheet.lockSelectUnlockedCells(true);
			 */
			FileOutputStream fos = new FileOutputStream(filepath);
			wb.write(fos);
			fos.close();
			// wb.close();
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			result = false;
		}
		return result;
	}

	public static StringBuilder getexcelColumnName(int columnNumber) {
		// To store result (Excel column name)
		StringBuilder columnName = new StringBuilder();

		while (columnNumber > 0) {
			// Find remainder
			int rem = columnNumber % 26;

			// If remainder is 0, then a
			// 'Z' must be there in output
			if (rem == 0) {
				columnName.append("Z");
				columnNumber = (columnNumber / 26) - 1;
			} else // If remainder is non-zero
			{
				columnName.append((char) ((rem - 1) + 'A'));
				columnNumber = columnNumber / 26;
			}
		}

		// Reverse the string and print result
		return columnName;
	}

	public static int getTableHeaderList(ArrayList<String> TableHeaderList){


		return 0;

	}

	public  static String getCellColor(XSSFCell cell) {
		String color = new String();
		if(cell != null)
		{
			if (cell.getCellStyle().getFillForegroundColorColor() != null) {
				color = cell.getCellStyle().getFillForegroundColorColor().getARGBHex();
			}
		}
		return color;
	}

	//Method to get the value property of the element
	public static void moveToElement(WebDriver driver,WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
