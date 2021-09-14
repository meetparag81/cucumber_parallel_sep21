package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsPage {
	
	private WebDriver driver;
	By accountsections=By.cssSelector("div#center_column span");
	By ContactUS=By.xpath("//a[@title='Contact Us']");
	
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
	}

	public int getAccountSectionsCount(){
		return driver.findElements(accountsections).size()-1;
		
	}
	
	public List<String> getAccountSectionsList(){
		List<WebElement> AccountheaderList = driver.findElements(accountsections);
		List<String> accountList= new ArrayList<>();
		
		
		for (WebElement e : AccountheaderList) {
			String text = e.getText();
			accountList.add(text);
			
		}
		return accountList;
		
		
	}
	public String AccountsPageTitle(){
		return driver.getTitle();
	}
	public contactUsPage ClickonContactUS(){
		driver.findElement(ContactUS).click();
		
		return new contactUsPage(driver);
		
	}
	

}
