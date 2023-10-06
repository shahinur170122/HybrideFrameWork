package com.tutorialsninja_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement enterFirstName;
	
	
	@FindBy(id="input-lastname")
	private WebElement enterLastName;
	
	
	@FindBy(id="input-email")
	private WebElement emailAddress;
	
	
	@FindBy(id="input-telephone")
	private WebElement enterTelephone;
	
	

	@FindBy(id="input-password")
	private WebElement enterPassword;
	
	
	@FindBy(id="input-confirm")
	private WebElement enterConfirmPassword;
	
	

	@FindBy(name="agree")
	private WebElement clickOnAgreeButton;
	
	
	@FindBy(css="input.btn.btn-primary")
	private WebElement clickOnEnterButton;
	
	
	@FindBy(xpath="//input[@name='newsletter' and @value='1']")
	private WebElement clickOnSubscribeButton;

	
	
	@FindBy(css="div.alert.alert-danger.alert-dismissible")
	private WebElement PrivacyWarningMessage;
	
	

	@FindBy(xpath="//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement firstNameWarningMessage;
	
	
	@FindBy(xpath="//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement lastNameWarningMessage;
	
	
	@FindBy(xpath="//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement emailAddressWarningMessage;
	
	

	@FindBy(xpath="//div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement telephoneWarningMessage;
	
	
	
	@FindBy(xpath="//div[text()='Password must be between 4 and 20 characters!']")
	private WebElement PasswordWarningMessage;
	
	
	
	@FindBy(css="div.alert.alert-danger.alert-dismissible")
	private WebElement existingEmailWarningMessage;
	
	
	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void enterFirstNameForRegister(String firstName) {
		enterFirstName.sendKeys(firstName);
	}
	
	
	
	public void enterLastNameForRegister(String lastName) {
		enterLastName.sendKeys(lastName);

}
	
	public void enterEmailAddressForRegister(String email) {
		emailAddress.sendKeys(email);
}
	
	public void enterTelephoneForRegister(String telephone) {
		enterTelephone.sendKeys(telephone);
}
	
	public void enterPasswordForRegister(String password) {
		enterPassword.sendKeys(password);
	}
	
	public void enterConfirmPasswordForRegister(String confirmPassword) {
		enterConfirmPassword.sendKeys(confirmPassword);
	
	}
	
	public void clickOnAgreeButtonForRegister() {
		clickOnAgreeButton.click();
	}
	
	public void clickOnEnterButtonForRegister() {
		clickOnEnterButton.click();
	}
	
	public void clickOnSubscribeButtonForRegister() {
		clickOnSubscribeButton.click();
	}
	
	
	
	public String PrivacyWarningMessageForRegister() {
		String getTextMethod = PrivacyWarningMessage.getText();
		return getTextMethod;
	}
	
	
	public String firstNameWarningMessageForRegister() {
		String getTextMethod = firstNameWarningMessage.getText();
		return getTextMethod;
	}
	
	
	public String lastNameWarningMessageForRegister() {
		String getTextMethod = lastNameWarningMessage.getText();
		return getTextMethod;
	}
	
	
	
	public String emailAddressWarningMessageForRegister() {
		String getTextMethod = emailAddressWarningMessage.getText();
		return getTextMethod;
	}
	
	
	

	public String telephoneWarningMessageForRegister() {
		String getTextMethod =telephoneWarningMessage.getText();
		return getTextMethod;
	}
	
	
	public String passwordWarningMessageForRegister() {
		String getTextMethod =PasswordWarningMessage.getText();
		return getTextMethod;
	}
	
	
	public String existingEmailWarningMessageForRegister() {
		String getTextMethod =existingEmailWarningMessage.getText();
		return getTextMethod;
	}
	
	
	public AccountPage registerMandatoryDetails(String firstName,String lastName,String email,String telephone,String password,String confirmPassword  ) {
		enterFirstName.sendKeys(firstName);
		enterLastName.sendKeys(lastName);
		emailAddress.sendKeys(email);
		enterTelephone.sendKeys(telephone);
		enterPassword.sendKeys(password);
		enterConfirmPassword.sendKeys(confirmPassword);
		clickOnAgreeButton.click();
		clickOnEnterButton.click();
		return new AccountPage(driver);
	}
	
	
	public AccountPage registerAllDetails(String firstName,String lastName,String email,String telephone,String password,String confirmPassword  ) {
		enterFirstName.sendKeys(firstName);
		enterLastName.sendKeys(lastName);
		emailAddress.sendKeys(email);
		enterTelephone.sendKeys(telephone);
		enterPassword.sendKeys(password);
		enterConfirmPassword.sendKeys(confirmPassword);
		clickOnSubscribeButton.click();
		clickOnAgreeButton.click();
		clickOnEnterButton.click();
		return new AccountPage(driver);
	}
	
	
	public boolean retrieveAllWarningMessageStatus(String expectedPrivacyWarningMessage,String expectedFirstNameWarningMessage,String expectedLastNameWarningMessage,String expectedEmailWarningMessage,String expectedTelephoneWarningMessage,String expectedPasswordWarningMessage) {
		boolean privacyWarningMessageStatus = PrivacyWarningMessage.getText().contains(expectedPrivacyWarningMessage);
		boolean firstNameWarningMessageStatus = firstNameWarningMessage.getText().contains(expectedFirstNameWarningMessage);
		boolean lastNameWarningMessageStatus = lastNameWarningMessage.getText().contains(expectedLastNameWarningMessage);
		boolean emailAddressWarningMessageStatus = emailAddressWarningMessage.getText().contains(expectedEmailWarningMessage);
		boolean telephoneWarningMessageStatus = telephoneWarningMessage.getText().contains(expectedTelephoneWarningMessage);
		boolean PasswordWarningMessageStatus = PasswordWarningMessage.getText().contains(expectedPasswordWarningMessage);
		return privacyWarningMessageStatus && firstNameWarningMessageStatus && lastNameWarningMessageStatus &&
				emailAddressWarningMessageStatus && telephoneWarningMessageStatus && PasswordWarningMessageStatus;
	}
	
	
	
	
}
