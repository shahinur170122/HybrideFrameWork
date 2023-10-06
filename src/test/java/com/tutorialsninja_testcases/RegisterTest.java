package com.tutorialsninja_testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja_pages.AccountPage;
import com.tutorialsninja_pages.LandingPage;
import com.tutorialsninja_pages.RegisterPage;
import com.tutorialsninja_testbase.TestBase;
import com.tutorialsninja_utilities.Utilities;

public class RegisterTest extends TestBase{ 
		
	


public RegisterTest() throws Exception {
		super();
		
	}


public WebDriver driver;
public LandingPage landingPage;
public RegisterPage registerpage;
public AccountPage accountPage;


	
	@BeforeMethod
	public void RegisterSetup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		landingPage = new LandingPage(driver);
		registerpage = landingPage.navigateToRegisterPage();
		
	}
	
	@Test(priority=1)
	public void registerAccountWithMandatoryDetails() {
		accountPage = registerpage.registerMandatoryDetails(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"),Utilities.generateEmailWithDateTimeStamp(),
				dataprop.getProperty("telephone"), prop.getProperty("validPassword"), 
				prop.getProperty("validPassword"));
		
		Assert.assertTrue(accountPage.getDisplayOfAccountCreatedInfo());
		
		}
	
	@Test(priority=2)
	public void registerAccountWithAllDetails() {
		accountPage = registerpage.registerAllDetails(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"),
				Utilities.generateEmailWithDateTimeStamp(), dataprop.getProperty("telephone"), 
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		
	
		Assert.assertTrue(accountPage.getDisplayOfAccountCreatedInfo());
	}
	
	
	
	@Test(priority=3)
	public void registerAccountWithNoDetails() {
		registerpage.clickOnEnterButtonForRegister();
		
		Assert.assertTrue(registerpage.retrieveAllWarningMessageStatus(dataprop.getProperty("privacyWarningMessage"), 
				dataprop.getProperty("firstNameWarningMessage"),dataprop.getProperty("lastNameWarningMessage"),
				dataprop.getProperty("emailWarningMessage"), dataprop.getProperty("telephoneWarningMessage"), 
				dataprop.getProperty("passwordWarningMessage")));
	}
		
	
	
	@Test(priority=4)
	public void registerAccountExistingEmail() {
		registerpage.registerAllDetails(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"),
				prop.getProperty("validEmail"), dataprop.getProperty("telephone"), 
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		
		
	
		Assert.assertTrue(registerpage.existingEmailWarningMessageForRegister().contains(dataprop.getProperty("existingEmailWarningMessage")));

	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

