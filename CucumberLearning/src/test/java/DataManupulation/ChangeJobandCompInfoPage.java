package com.botsftool.dsg.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.botsftool.dsg.utilities.CustomMethods;

public class ChangeJobandCompInfoPage extends CustomMethods {

	public ChangeJobandCompInfoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String InputLabels = "ancestor::div[3]/preceding::bdi[1]";
	public String allInputElements = "//div[contains(@class,'EditFormGenerator')]//input";
	public String ConfirmNo = "//bdi[text()='No']/ancestor::button[1]";
	public String InputLabel = "preceding::div[1]//span[1]";
	public String InputTableLabel = "preceding::div[2]//span[1]";
	
	@FindBy(xpath = "//*[text()='Cancel']/ancestor::button[1]")
	public WebElement Cancel;
	
	@FindBy(xpath = "//div[@role='alertdialog']")
	public WebElement dailogwindow;
	
	@FindBy(xpath = "//footer[@class='sapMPageFooter']//button[@title='Save']")
	public WebElement Save;
	
	@FindBy(xpath = "//*[text()='Close']/ancestor::button[1]")
	public WebElement ErrorDailog;
	
	@FindBy(xpath = "//*[text()=\"Don't Save\"]/ancestor::button[1]")
	public WebElement DontSave;
	
	@FindBy(xpath = "//*[text()='Confirm']/ancestor::button[1]")
	public WebElement confirm;
	
	@FindBy(xpath = "//*[text()='Proceed']/ancestor::button[1]")
	public WebElement proceed;
	
	public ChangeJobandCompInfoPage waitforload(){
		waitForClickable(Cancel);
		return this;
	}
	
	public ChangeJobandCompInfoPage ChangeTo(ArrayList<String> ChangeToList){
		for(int i=0;i<ChangeToList.size();i++) {
			WebElement element = driver.findElement(By.xpath("//div[@title='"+ChangeToList.get(i)+"']"));
			waitForClickable(element);
			click(element);
			waitForTime(1000);
		}
		return this;
	}
	
	public ChangeJobandCompInfoPage CancelTransfer(){
		waitForClickable(Cancel);
		click(Cancel);
		wait(3000);
		waitForClickable(DontSave);
		click(DontSave);
		wait(3000);
		return this;
	}

}
