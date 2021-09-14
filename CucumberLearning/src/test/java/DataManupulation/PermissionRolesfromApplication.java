package com.botsftool.dsg.pages;

import java.io.IOException;
import java.text.ParseException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.botsftool.dsg.utilities.CustomMethods;

public class PermissionRolesfromApplication extends CustomMethods {
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
	
	@FindBy(xpath = "//div[@class='detailPane']//div[@class='ckrbList']")
	public WebElement permissionsDetailspane1;
	
	@FindBy(xpath = "//div[@class='detailPane']//table[@class='userDataModelView']")
	public WebElement permissionsDetailspane2;
	
	@FindBy(xpath = "//div[@class='detailPane']//div[contains(@id,'mdfDetailPane')]")
	public WebElement permissionsDetailspane3;
	
	@FindBy(xpath = "//*[text()='Keep Working']/ancestor::button[1]")
	public WebElement keepWorking;
	


	public PermissionRolesfromApplication(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
