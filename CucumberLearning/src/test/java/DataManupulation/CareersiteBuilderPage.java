package com.botsftool.dsg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.botsftool.dsg.utilities.CustomMethods;

public class CareersiteBuilderPage extends CustomMethods {

	public CareersiteBuilderPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//div[@title='Pages']")
	public WebElement Page;
	@FindBy(xpath = "//li[@title='Home']")
	 public WebElement Home;
	@FindBy(xpath="//span[contains(text(),'United States')]//parent::li")
	public WebElement Region;
	@FindBy(xpath="//li[@id='homePage_node_en_US_EnhancementOfRPA_home']")
	public WebElement Homepage;
	@FindBy(xpath="//a[text()='Home']")
	public WebElement HomeLink;
	
	
	
	

}
