package com.tutorialsninja_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//a[text()='Edit your account information']")
	private WebElement accountInfo;
	
	

	@FindBy(xpath="//p[text()='Congratulations! Your new account has been successfully created!']")
	private WebElement accountCreatedInfo;
	
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
	
	
	public boolean getDisplayOfAccountInfo() {
		boolean displayStatus = accountInfo.isDisplayed();
		return displayStatus;
		
	}
	
	

	public boolean getDisplayOfAccountCreatedInfo() {
		boolean displayStatus = accountCreatedInfo.isDisplayed();
		return displayStatus;
	}
	
	
	
	
	
	
	
	
	
	
}
