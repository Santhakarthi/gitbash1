package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorDashboardPage {
@FindBy(xpath="//ul[@class='main-navigation-menu']/descendant::span[text()='Dashboard']")
private WebElement DashboardLink;
@FindBy(xpath="//ul[@class='main-navigation-menu']/descendant::span[contains(text(),'Appointment History')]")
private WebElement AppointmentLink;
@FindBy(xpath="//ul[@class='main-navigation-menu']/descendant::span[contains(text(),'Patients')]")
private WebElement patientlink;
@FindBy(xpath="//ul[@class='main-navigation-menu']/descendant::span[contains(text(),'Add Patient')]")
private WebElement AddPatientLink;
@FindBy(xpath="//ul[@class='main-navigation-menu']/descendant::span[contains(text(),'Manage Patient')]")
private WebElement ManagePatient;
@FindBy(xpath="//ul[@class='main-navigation-menu']/descendant::span[contains(text(),'Search ')]")
private WebElement Searchlink;
@FindBy(xpath = "//a[@class='dropdown-toggle']")
private WebElement ProfileIcon;

@FindBy(xpath = "//a[contains(text(),'Change Password')]")

private WebElement ChangePassword;

@FindBy(xpath = "//a[contains(text(),'Log Out')]")

private WebElement LogOut;



public DoctorDashboardPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}



public WebElement getProfileIcon() {
	return ProfileIcon;
}



public WebElement getChangePassword() {
	return ChangePassword;
}



public WebElement getLogOut() {
	return LogOut;
}



public WebElement getDashboardLink() {
	return DashboardLink;
}



public WebElement getAppointmentLink() {
	return AppointmentLink;
}



public WebElement getPatientlink() {
	return patientlink;
}



public WebElement getAddPatientLink() {
	return AddPatientLink;
}



public WebElement getManagePatient() {
	return ManagePatient;
}



public WebElement getSearchlink() {
	return Searchlink;
}

public void DoctorDashboardPage() {
	DashboardLink.click();
	AppointmentLink.click();
	patientlink.click();
	 AddPatientLink.click();
	 ManagePatient.click();
	 Searchlink.click();
	 ProfileIcon.click();
	 LogOut.click();
	 
}

}
