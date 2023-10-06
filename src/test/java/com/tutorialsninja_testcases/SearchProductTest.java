package com.tutorialsninja_testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja_pages.LandingPage;
import com.tutorialsninja_pages.SearchPage;
import com.tutorialsninja_testbase.TestBase;

public class SearchProductTest extends TestBase {

public SearchProductTest() throws Exception {
		super();
		
	}


public WebDriver driver;
public LandingPage landingpage;
public SearchPage searchpage;
	
	@BeforeMethod
	public void searchProductsSetup() {
		
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
	}
	
	
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		landingpage = new LandingPage(driver);
		searchpage = landingpage.navigateToSearchPage(dataprop.getProperty("validProduct"));
		
		
		Assert.assertTrue(searchpage.assertionForValidProduct());
		
		
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		landingpage = new LandingPage(driver);
		searchpage = landingpage.navigateToSearchPage(dataprop.getProperty("inValidProduct"));
		
		
		Assert.assertTrue(searchpage.assertionForinValidProduct());
	
	}
	
	
	
	@Test(priority=2)
	public void verifySearchNoProduct() {
		landingpage = new LandingPage(driver);
		searchpage = landingpage.clickOnSearchButton();
		
		Assert.assertTrue(searchpage.assertionForinValidProduct());
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
	
	
	
	
	
	

