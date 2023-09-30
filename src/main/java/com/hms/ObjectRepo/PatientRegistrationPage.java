package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientRegistrationPage {
	@FindBy(xpath="//input[@placeholder='Full Name']")
	private WebElement   FullNamePatient;
	
	@FindBy(xpath="//input[@placeholder='Address']")
	private WebElement AddressPatient;
	
	@FindBy(xpath="//input[@placeholder='City']")
	private WebElement CityPatient;
	
	@FindBy(xpath="//label[contains(text(),'Male')]")
	private WebElement GenderPatient;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	private WebElement EmailPatient;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement EmailPasswordPatient;
	
	@FindBy(xpath="//input[@placeholder='Password Again']")
	private WebElement EmailPasswordAgainPatient;
	
	@FindBy(xpath="//button[@name='submit']	")
	private WebElement SubmitButtonPatientregistration;
	
	public PatientRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubmitButtonPatientregistration() {
		return SubmitButtonPatientregistration;
	}

	public WebElement getFullNamePatient() {
		return FullNamePatient;
	}

	public WebElement getAddressPatient() {
		return AddressPatient;
	}

	public WebElement getCityPatient() {
		return CityPatient;
	}

	public WebElement getGenderPatient() {
		return GenderPatient;
	}

	public WebElement getEmailPatient() {
		return EmailPatient;
	}

	public WebElement getEmailPasswordPatient() {
		return EmailPasswordPatient;
	}

	public WebElement getEmailPasswordAgainPatient() {
		return EmailPasswordAgainPatient;
	}
	
	//Business Libraries

	public void PatientRegistrationPage(String FullName,String Address,String City,String Gender,String Email,String EmailPassword,String EmailPasswordAgain) {
		FullNamePatient.sendKeys(FullName);
		AddressPatient.sendKeys(Address);
		CityPatient.sendKeys(City);
		GenderPatient.sendKeys(Gender);
		EmailPatient.sendKeys(Email);
		EmailPasswordPatient.sendKeys(EmailPassword);
		EmailPasswordAgainPatient.sendKeys(EmailPasswordAgain);
		
	}
	
	
	
}

