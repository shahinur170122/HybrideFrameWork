package com.tutorialsninja_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	
	public WebDriver driver;
	
	
	@FindBy(linkText="My Account")
	private WebElement MyAccountDropDown;
	
	
	@FindBy(linkText="Login")
	private WebElement LoginOption;
	
	
	@FindBy(partialLinkText="Register")
	private WebElement registerOption;
	
	
	@FindBy(css="input.form-control.input-lg")
	private WebElement searchProduct;
	
	
	
	@FindBy(css="i.fa.fa-search")
	private WebElement clickOnSearch;
	
	
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	public void clickOnMyAccountDropDown() {
		MyAccountDropDown.click();
	}
	
	public LoginPage selectLoginOption() {
		LoginOption.click();
		return new LoginPage(driver);
		
	}
	
	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	
	public LoginPage navigateToLoginPage() {
		MyAccountDropDown.click();
		LoginOption.click();
		return new LoginPage(driver);
		
	}
	
	public RegisterPage navigateToRegisterPage() {
		MyAccountDropDown.click();
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	
	
	
	public void SearchOption(String Product) {
		searchProduct.sendKeys(Product);
	}
	
	public SearchPage clickOnSearchButton() {
		clickOnSearch.click();
		return new SearchPage(driver);
	 }
	
	public SearchPage navigateToSearchPage(String Product) {
		searchProduct.sendKeys(Product);
		clickOnSearch.click();
		return new SearchPage(driver);
		
	}
	
	
	
}
