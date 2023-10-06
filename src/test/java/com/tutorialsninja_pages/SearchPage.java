package com.tutorialsninja_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	public WebDriver driver;
	
	
	@FindBy(xpath="//a[text()='HP LP3065']")
	private WebElement validproductAssertion;
	

	@FindBy(xpath="//p[text()='There is no product that matches the search criteria.']")
	private WebElement invalidproductAssertion;
	
	
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean assertionForValidProduct() {
		boolean displayStatus = validproductAssertion.isDisplayed();
		return displayStatus;
	}
	
	
	public boolean assertionForinValidProduct() {
		boolean displayStatus =invalidproductAssertion.isDisplayed();
		return displayStatus;
		
	}

}
