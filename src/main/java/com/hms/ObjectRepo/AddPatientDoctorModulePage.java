package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPatientDoctorModulePage {
@FindBy(xpath="//input[@placeholder='Enter Patient Name']")
private WebElement addPatientName;
@FindBy(xpath="//input[@placeholder='Enter Patient Contact no']")
private WebElement addPatientContactNumber;
@FindBy (xpath="//input[@placeholder='Enter Patient Email id']")
private WebElement addPatientEmailid;
@FindBy (xpath="//textarea[@placeholder='Enter Patient Address']")
private WebElement addPatientAddress;
@FindBy(xpath="//input[@placeholder='Enter Patient Age']")
private WebElement addPatientAge;
@FindBy(xpath="//textarea[@placeholder='Enter Patient Medical History(if any)']")
private WebElement addPatientMedicalHistory;
@FindBy(xpath="//button[@name='submit']")
private WebElement submitButton;


public AddPatientDoctorModulePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getAddPatientName() {
	return addPatientName;
}


public WebElement getAddPatientContactNumber() {
	return addPatientContactNumber;
}


public WebElement getAddPatientEmailid() {
	return addPatientEmailid;
}


public WebElement getAddPatientAddress() {
	return addPatientAddress;
}


public WebElement getAddPatientAge() {
	return addPatientAge;
}


public WebElement getAddPatientMedicalHistory() {
	return addPatientMedicalHistory;
}


public WebElement getSubmitButton() {
	return submitButton;
}
//business libraries
public void addPatientDoctorModulePage(String pname,String pco,String pemail,String paddress,String page,String medicalhistory) {
	addPatientName.sendKeys(pname);
	addPatientContactNumber.sendKeys(pco);
	addPatientEmailid.sendKeys(pemail);
	addPatientAddress.sendKeys(paddress);
	addPatientAge.sendKeys(page);
	addPatientMedicalHistory.sendKeys(medicalhistory);
	submitButton.click();
}



}