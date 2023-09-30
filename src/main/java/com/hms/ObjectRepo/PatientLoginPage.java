package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientLoginPage {
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement UserNamePatient;
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement PasswordNamePatient;
	@FindBy(xpath="//button[@name='submit']")
	private WebElement LoginButtonPatient;
	@FindBy(xpath="//a[contains(text(),'Create an account')]")
	private WebElement CreateAccountLink;
	
	public PatientLoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

	public WebElement getUserNamePatient() {
		return UserNamePatient;
	}

	public WebElement getPasswordNamePatient() {
		return PasswordNamePatient;
	}

	public WebElement getLoginButtonPatient() {
		return LoginButtonPatient;
	}

	public WebElement getCreateAccountLink() {
		return CreateAccountLink;
	}

	//Business Libraries

		public void PatientLoginPage(String userName,String Password) {
			UserNamePatient.sendKeys(userName);
			PasswordNamePatient.sendKeys(Password);
			LoginButtonPatient.click();
			
		}

}
