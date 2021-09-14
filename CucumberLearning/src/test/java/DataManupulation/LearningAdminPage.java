package DataManupulation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LearningAdminPage extends CustomMethods {

	public LearningAdminPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//div[text()='Manage User Learning']//ancestor::li/span[1]")
	public WebElement manageUserLearning;
	@FindBy(xpath="//div[text()='Edit Learning History']//ancestor::li[1]")
		public WebElement editLearningHistory;
	@FindBy(xpath="(//iframe[contains(@name,'iframe')][@class='iframeLoader plateauIFrame'])[1]")
	public WebElement useridiframe;
	@FindBy(xpath="(//input[@name='Student'])[1]")
	public WebElement UserId;
	@FindBy(xpath="//input[@name='search']")
	public WebElement Searchbutton;
	@FindBy(xpath="//input[@name='OnOrBefore']")
	public WebElement Completeddate;
	@FindBy(xpath="//div[text()='People']//ancestor::li[1]/span[1]")
	public WebElement People;
	@FindBy(xpath="//div[text()='Merge Users']//ancestor::li[1]")
	public WebElement mergeUser;
	@FindBy(xpath="(//iframe[contains(@name,'iframe')][@class='iframeLoader plateauIFrame'])[1]")
	public WebElement manageuseriframe;
	@FindBy(xpath="//select[@name='ID_Match']")
	public WebElement useridselect;
	@FindBy(xpath="//input[@name='ID']")
	public	WebElement mergeuserid; 
	@FindBy(xpath="(//iframe[contains(@name,'iframe')][@class='iframeLoader plateauIFrame'])[1]")
	public	WebElement mergeuseridiframe;
	@FindBy(xpath="//div[text()='Users']//ancestor::li[1]")
	public	WebElement users;
	@FindBy(xpath="//iframe[@class='plateauIFrame ']")
	public	WebElement usersiframe;
	@FindBy(xpath="//input[@id='ID']")
	public	WebElement userside; 
	@FindBy(xpath="//li[text()='Approval Roles']")
	public	WebElement ApprovalRoles;
	@FindBy(xpath="//span[text()='Status:']//following::span[contains(@class,'sapUiIcon')][1]")
	public	WebElement ExpandHeader;
	@FindBy(xpath="//a[text()='add one or more from list'][1]")
	public	WebElement addoneormore;
	@FindBy(xpath="//*[@class='plateauIFrame sfUiEntityEditTabIframe']")
	public	WebElement approverolesiframe;
	@FindBy(xpath="//iframe[@class='plateauIFrame sfUiEntityEditTabIframe']")
	public	WebElement approveformframe;
	@FindBy(xpath="//span[text()='Approval Role ID:']//following::input[1]")
	public	WebElement roleid; 
	@FindBy(xpath="//input[@name='search']")
	public WebElement roleidSearchbutton;
	
	
	
	
	
	
	
	public void clickonManageuserLearning() {
		manageUserLearning.click();
	}
	public void clickonEditLearningHistory() {
		editLearningHistory.click();
		
	}
	public void clickonpeople() {
		People.click();
	}
	public void clickonMergeUser() {
		mergeUser.click();
	}
	
	public void clickontheUserID() {
		UserId.click();
	}
	public void switchtouseridframe() {
		driver.switchTo().frame(useridiframe);
	}
	public void clickonmergerID() {
		mergeuserid.click();
	}
	public void switchtomergeuseridframe() {
		driver.switchTo().frame(mergeuseridiframe);
	}
	public void clickonUsers() {
		users.click();
	}
	public void switchtousersiframe() {
		driver.switchTo().frame(usersiframe);
	}
	
	public void clickonUsersID() {
		userside.click();
	}
	
	
	
	

}
