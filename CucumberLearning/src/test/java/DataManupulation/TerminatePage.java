package com.botsftool.dsg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.botsftool.dsg.utilities.CustomMethods;

public class TerminatePage extends CustomMethods {

	public TerminatePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//footer[@class='sapMPageFooter']//button[@title='Cancel']")
	public WebElement Cancel;
	
	@FindBy(xpath = "//footer[@class='sapMPageFooter']//button[@title='Save']")
	public WebElement Save;
	
	@FindBy(xpath = "//div[contains(@class,'BusyIndicator')]")
	public WebElement BusyIndicator;
	
	@FindBy(xpath = "//*[text()=\"Don't Save\"]/ancestor::button[1]")
	public WebElement DontSave;
	
	@FindBy(xpath = "//*[text()='Close']/ancestor::button[1]")
	public WebElement ErrorDailog;
	
	@FindBy(xpath = "//*[text()='Confirm']/ancestor::button[1]")
	public WebElement confirm;
	
	@FindBy(xpath = "//*[text()='Proceed']/ancestor::button[1]")
	public WebElement proceed;
	
	public String allInputElements = "//div[contains(@class,'sapMPanelContent')]//input";
	public String InputLabel = "preceding::div[1]//span[1]";
	public String InputTableLabel = "preceding::div[2]//span[1]";
	
	
	public TerminatePage waitforload(){
		waitForClickable(Cancel);
		return this;
	}
	
	public TerminatePage CancelPosition(){
		waitForClickable(Cancel);
		click(Cancel);
		wait(3000);
		waitForClickable(DontSave);
		click(DontSave);
		wait(3000);
		return this;
	}
}
