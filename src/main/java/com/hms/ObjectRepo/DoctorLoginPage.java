package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorLoginPage {
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement UserNameDoctor;
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement PasswordNameDoctor;
	@FindBy(xpath="//button[@name='submit']")
	private WebElement LoginButtonDoctor;

	public DoctorLoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameDoctor() {
		return UserNameDoctor;
	}

	public WebElement getPasswordNameDoctor() {
		return PasswordNameDoctor;
	}

	public WebElement getLoginButtonDoctor() {
		return LoginButtonDoctor;
	}
	
	
	//Business Libraries

	public void DoctorLoginPage(String userName,String Password) {
		UserNameDoctor.sendKeys(userName);
		PasswordNameDoctor.sendKeys(Password);
		
		
	}
	
	public void ClickOnSubmittButton() {
		LoginButtonDoctor.click();
	}
	
	
	
	

}
