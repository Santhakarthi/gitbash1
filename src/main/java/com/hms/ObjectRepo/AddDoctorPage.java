package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.genericUtility.ExcelUtility;
import com.hms.genericUtility.JavaUtility;

public class AddDoctorPage  {
	@FindBy(xpath = "//select[@name='Doctorspecialization']")

	private WebElement SelectDoctorSpecialization;
	
	
	@FindBy(xpath="//input[@placeholder='Enter Doctor Name']")
	private WebElement EnterDoctorName;
	
	
	@FindBy(xpath="//textarea[@placeholder='Enter Doctor Clinic Address']")
	private WebElement EnterDoctorClinicAddress;
	
	@FindBy (xpath="//input[@placeholder='Enter Doctor Consultancy Fees']")
	private WebElement EnterDoctorConsultancyFees;
	
	@FindBy (xpath="//input[@placeholder='Enter Doctor Contact no']")
	private WebElement EnterDoctorContactNumber;
	
	@FindBy(xpath="//input[@placeholder='Enter Doctor Email id']")
	private WebElement EnterDoctorEmail;
	
	
	@FindBy (xpath="//input[@placeholder='New Password']")
	private WebElement  EnterNewPassword;
	
	@FindBy(xpath="//input[@placeholder='Confirm Password']")
	private WebElement EnterConfirmPassword;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement submitButton;
	@FindBy(xpath = "//a[@class='dropdown-toggle']")

	private WebElement ProfileIcon;

	@FindBy(xpath = "//a[contains(text(),'Change Password')]")

	private WebElement ChangePassword;

	@FindBy(xpath = "//a[contains(text(),'Log Out')]")

	private WebElement LogOut;

	
	
	public WebElement getProfileIcon() {
		return ProfileIcon;
	}




	public WebElement getChangePassword() {
		return ChangePassword;
	}




	public WebElement getLogOut() {
		return LogOut;
	}




	public WebElement getSubmitButton() {
		return submitButton;
	}




	public AddDoctorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}




	public WebElement getSelectDoctorSpecialization() {
		return SelectDoctorSpecialization;
	}




	public WebElement getEnterDoctorName() {
		return EnterDoctorName;
	}




	public WebElement getEnterDoctorClinicAddress() {
		return EnterDoctorClinicAddress;
	}




	public WebElement getEnterDoctorConsultancyFees() {
		return EnterDoctorConsultancyFees;
	}




	public WebElement getEnterDoctorContactNumber() {
		return EnterDoctorContactNumber;
	}




	public WebElement getEnterDoctorEmail() {
		return EnterDoctorEmail;
	}




	public WebElement getEnterNewPassword() {
		return EnterNewPassword;
	}




	public WebElement getEnterConfirmPassword() {
		return EnterConfirmPassword;
	}
	
	//bussinee libraries
	public void addDoctorPage(String Specialization,String DoctorName,String DoctorClinicaddress,String Fees,String contactNumber,String Email,String NewPassword,String ConfirmPassword ) {
		SelectDoctorSpecialization.sendKeys(Specialization);
		EnterDoctorName.sendKeys(DoctorName);
		EnterDoctorClinicAddress.sendKeys(DoctorClinicaddress);
		EnterDoctorConsultancyFees.sendKeys(Fees);
		EnterDoctorContactNumber.sendKeys(contactNumber);
		
	    EnterDoctorEmail.sendKeys(Email);
		EnterNewPassword.sendKeys(NewPassword);
		EnterConfirmPassword.sendKeys(ConfirmPassword);
		submitButton.click();
		ProfileIcon.click();
		LogOut.click();
		
	}
	
	
	
	
}
