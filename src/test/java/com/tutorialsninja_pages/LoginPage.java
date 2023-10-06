package com.tutorialsninja_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	
	@FindBy(id="input-email")
	private WebElement emailAddress;
	
	
	@FindBy(id="input-password")
	private WebElement loginPassword;
	
	
	@FindBy(css="input.btn.btn-primary")
	private WebElement loginButton;
	
	
	@FindBy(css="div.alert.alert-danger.alert-dismissible")
	private WebElement passwordWarningMessage;
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
	
	
	
	
	
	public void enterEmailAddress(String emailText) {
		emailAddress.sendKeys(emailText);
	}
	
	
	public void enterLoginPassword(String passwordText) {
		loginPassword.sendKeys(passwordText);
		
	}	
		public AccountPage clickOnLoginButton() {
			loginButton.click();
			return new AccountPage(driver);
	
		}
		
	public AccountPage navigateToAccountPage(String emailText,String passwordText) {
		emailAddress.sendKeys(emailText);
		loginPassword.sendKeys(passwordText);
		loginButton.click();
		return new AccountPage(driver);
	}
		
		
		
		
		
	public String invalidPasswordWarningMessage()	{
		String gettextMethod = passwordWarningMessage.getText();
		return gettextMethod;
	}
	
	
}
