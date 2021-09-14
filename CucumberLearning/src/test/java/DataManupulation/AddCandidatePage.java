package com.botsftool.dsg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.botsftool.dsg.utilities.CustomMethods;

public class AddCandidatePage extends CustomMethods {

	public AddCandidatePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//button[text()='Create Profile']")
	public WebElement CreateProfile;
	
	public String AddCandidateInputs = "//table[contains(@id,'layoutTbl')]//input | //table[contains(@id,'layoutTbl')]//select | //table[contains(@id,'layoutTbl')]//a[@role='radio']";
	public String InputLabel = "preceding::td[1]/label[1]";

}
