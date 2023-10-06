package com.tutorialsninja_testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja_pages.AccountPage;
import com.tutorialsninja_pages.LandingPage;
import com.tutorialsninja_pages.LoginPage;
import com.tutorialsninja_testbase.TestBase;
import com.tutorialsninja_testdata.ExcelSheetCode;
import com.tutorialsninja_utilities.Utilities;

public class LoginTest extends TestBase {
	
	


	public LoginTest() throws Exception {
		super();
		
	}


	public WebDriver driver;
	public LandingPage landingPage;
	public LoginPage loginpage;
	public AccountPage accountpage;
	
	
	
	@BeforeMethod
	public void loginSetup() {
		
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		landingPage = new LandingPage(driver);
		loginpage = landingPage.navigateToLoginPage();
		}
	
	
	
	@Test(priority=1,dataProvider="TNDATA",dataProviderClass=ExcelSheetCode.class)
	public void verifyLoginWithValidCredentials(String email, String password) {
		
		accountpage = loginpage.navigateToAccountPage(email, password) ;
		Assert.assertTrue(accountpage.getDisplayOfAccountInfo());
		}
		
		
	@Test(priority=2)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
			
		loginpage.navigateToAccountPage(prop.getProperty("validEmail"), dataprop.getProperty("inValidPassword"));
		Assert.assertTrue(loginpage.invalidPasswordWarningMessage().contains(dataprop.getProperty("loginwarningMessage")));
		}
		
		
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndvalidPassword() {
			
		loginpage.navigateToAccountPage(Utilities.generateEmailWithDateTimeStamp(),prop.getProperty("validPassword"));
		Assert.assertTrue(loginpage.invalidPasswordWarningMessage().contains(dataprop.getProperty("loginwarningMessage")));
		}
		
		
	@Test(priority=4)
	public void verifyLoginWithInvalidCredentials() {
			
		loginpage.navigateToAccountPage(Utilities.generateEmailWithDateTimeStamp(), dataprop.getProperty("inValidPassword"));
		Assert.assertTrue(loginpage.invalidPasswordWarningMessage().contains(dataprop.getProperty("loginwarningMessage")));
        }
		
		
    @Test(priority=5)
	public void verifyLoginWithNoCredentials() {
			
		loginpage.clickOnLoginButton();	
		Assert.assertTrue(loginpage.invalidPasswordWarningMessage().contains( dataprop.getProperty("loginwarningMessage")));		
		}
		
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
		}
}
		
		
		
