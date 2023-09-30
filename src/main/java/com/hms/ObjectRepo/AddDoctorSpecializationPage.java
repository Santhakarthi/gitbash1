package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDoctorSpecializationPage {
	@FindBy(xpath ="//input[@name='doctorspecilization']")
	 WebElement AddDoctorSpecialization;

	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submitButton;

	public AddDoctorSpecializationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// business libraries

	public WebElement getAddDoctorSpecialization() {
		return AddDoctorSpecialization;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void addDoctorSpecializationPage(String spc) {

		AddDoctorSpecialization.sendKeys(spc);
		submitButton.click();
	}


}
