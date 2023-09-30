package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	//declaration
@FindBy(xpath="(//a[text()='Click Here'])[3]")
private WebElement AdminModule;
@FindBy(xpath="(//a[text()='Click Here'])[2]")
private WebElement DoctorModule;
@FindBy(xpath="\"(//a[text()='Click Here'])[1]")
private WebElement PatientModule;
//initialization
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
//utilization
public WebElement getAdminModule() {
	return AdminModule;
}

public WebElement getDoctorModule() {
	return DoctorModule;
}

public WebElement getPatientModule() {
	return PatientModule;
}


//business Libraries
public void HomePage() {
	AdminModule.click();
	DoctorModule.click();
	PatientModule.click();
}

}
