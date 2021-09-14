package DataManupulation;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;



public class PermissionRoles extends CustomMethods {

	public PermissionRoles(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//To define string objects
	public String permissions = "//ul[@class='permission_items_list']";
	public String permissionlist = "//ul[@class='permission_items_list']//li";
	public String Addutton="//button[text()='Done']";

	//public String permissionsDetailspane1 = "//div[@class='detailPane']//div[@class='ckrbList']";
	public String permissionsOptionType1 = "(//div[@class='detailPane']//input/following::label/span[1])";
	public String permissionsOptionType2 = "//div[@class='detailPane']//table[@class='userDataModelView']";
	public String permissionsOptionType3 = "//div[@class='detailPane']//div[@class='mdf_object_perm']";

	public String permissionsOptionType1Others = "(//div[@class='detailPane']//input/following::label/span[1])";

	@FindBy(xpath = "//input[@id='bizXSearchField-I']")
	public WebElement search;

	@FindBy(id = "utilityLinksMenuId")
	public WebElement proxyMenu;

	@FindBy(xpath = "//a[text()='Proxy Now']")
	public WebElement proxyNow;

	@FindBy(xpath = "//*[contains(text(),'Please enter target user name')]//following::input[1]")
	public WebElement targetUser;

	@FindBy(xpath = "//*[text()='OK']/ancestor::button[1]")
	public WebElement OK;

	@FindBy(id = "sap-ui-blocklayer-popup")
	public WebElement sapPopup;

	@FindBy(xpath = "//input[contains(@id,'searchTxt')]")
	public WebElement TypeRole;

	@FindBy(xpath = "//div[@class='searchMod_icon']")
	public WebElement SearchRole;

	@FindBy(xpath = "//button[text()='Permission...']")
	public WebElement Permission;

	@FindBy(xpath="//label[text()='Items per page']//following::select[1]")
	public WebElement itemsperpage;

	@FindBy(xpath = "//div[@class='detailPane']//div[@class='ckrbList']")
	public WebElement permissionsDetailspane1;

	@FindBy(xpath = "//div[@class='detailPane']//table[@class='userDataModelView']")
	public WebElement permissionsDetailspane2;

	@FindBy(xpath = "//div[@class='detailPane']//div[contains(@id,'mdfDetailPane')]")
	public WebElement permissionsDetailspane3;

	@FindBy(xpath = "//*[text()='Keep Working']/ancestor::button[1]")
	public WebElement keepWorking;

	@FindBy(xpath="//a[@title='Next Page']/parent::li")
	public WebElement NextArrow;
	@FindBy(xpath="//*[contains(@id,'index')]//parent::span")
	public WebElement NoofPageText;
	private ArrayList<WebElement> TotalNoofRoles;
	private ArrayList<String> StatusName;
	private ArrayList<WebElement> TotalNoofRolesEachPage;
	private ArrayList<String> StatusNameeachPage;
	private ArrayList<String> StatusononePage;





	//To proxy as different User
	public PermissionRoles ProxyNow(String proxyUser){

		wait(5000);
		try {
			//waitForClickable(sapPopup);
			executeJavaScript("arguments[0].click();",sapPopup);
			wait(1000);
		}
		catch(Exception noPopupBlocker) {
			wait(10);
		}
		waitForClickable(proxyMenu);
		click(proxyMenu);
		wait(500);
		waitForClickable(proxyNow);
		click(proxyNow);
		wait(500);
		pickEmployee(targetUser, proxyUser, "//*[contains(text(),'Please enter target user name')]//following::input[1]");
		wait(500);
		waitForClickable(OK);
		click(OK);
		wait(10000);
		return this;
	}


	//To Search for Manage Permission Roles Command
	public PermissionRoles searchManagePermisionRoles(){
		wait(8000);
		waitForClickable(search);
		pick(search, "Manage Permission Roles", "//input[@id='bizXSearchField-I']");
		wait(8000);
		return this;
	}

	//To Search for Manage Permission Roles Command
	public PermissionRoles SelectRole(String Role){
		waitForClickable(TypeRole);
		enterText(TypeRole, Role);
		wait(500);
		waitForClickable(SearchRole);
		click(SearchRole);
		wait(2000);
		return this;
	}

	//To Search for Manage Permission Roles Command
	public PermissionRoles ClickPermission(){
		waitForClickable(Permission);
		click(Permission);
		wait(2000);
		return this;
	}
	//To Fetch for Manage Permission Roles Command
	public  PermissionRoles selectItemsPerPage() {
		waitForClickable(itemsperpage);
		Select itemspetpage = new Select(this.itemsperpage);
		List<WebElement> ItemsNosPerpageList = itemspetpage.getOptions();
		if(ItemsNosPerpageList.size()>0)         
			itemspetpage.selectByIndex(ItemsNosPerpageList.size() - 1);

		return this;
	}







	//To Fetch for Manage Permission Roles Command
	public ArrayList<String> fetchRolesWebElementsString() {
		wait(2000);
		//FetchNoofitemstobedisplayed
		selectItemsPerPage();
		wait(5000);
		String  Textvalue= NoofPageText.getText();
		String NumberofPages = Textvalue.split( "of" )[1].trim().toString();
		int Pagescount = 0;
		try{
			Pagescount = Integer.parseInt(NumberofPages);
		}
		catch(Exception e) {
			System.out.println("Numberformatexception seen");
		}
		wait(2000);
		System.out.println();
		if(Pagescount<=1) {
			wait(5000);
			List<WebElement> NoofPermissionRooles = driver.findElements(By.xpath("//table[contains(@id,'tableBody')][1]//tr"));
			StatusononePage = new ArrayList<>();
			for(WebElement roles:NoofPermissionRooles) {
				if(roles.findElement(By.xpath("td[4]")).getText().equals("ACTIVE")) {
					StatusononePage.add(roles.findElement(By.xpath("td[1]")).getText().toString());
				}



			}

			System.out.println("Total No of roles are"+StatusononePage.size()+"and names are"+StatusononePage );
			return StatusononePage;	
		}
		else {
			//To Get Roles on Nextpage.
			int counter=1;
			StatusNameeachPage = new ArrayList<>();
			while(counter<=Pagescount) {
				wait(5000);
				List<WebElement>eachpageroles=driver.findElements(By.xpath("//table[contains(@id,'tableBody')][1]//tr"));
				for(WebElement roles:eachpageroles) {
					if(roles.findElement(By.xpath("td[4]")).getText().equals("ACTIVE")){
						StatusNameeachPage.add(roles.findElement(By.xpath("td[1]")).getText().toString());
					}
				}


				System.out.println();
				if(counter>=Pagescount) {
					break;
				}
				NextArrow.click();
				wait(5000);
				counter++;		

			}



			System.out.println("Total No of roles are"+StatusNameeachPage.size()+"and names are"+StatusNameeachPage );
			return StatusNameeachPage;

		}

	}
}






