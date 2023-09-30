package com.hms.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	
	
	
	//declaration
@FindBy(xpath="//input[@placeholder='Username']")
private WebElement UserNameAdmin;
@FindBy(xpath="//input[@placeholder='Password']")
private WebElement PasswordNameAdmin;
@FindBy(xpath="//button[@name='submit']")
private WebElement LoginButtonAdmin;
//initialization
public AdminLoginPage(WebDriver driver) {
PageFactory.initElements(driver, this);
}
//utilization
public WebElement getUserNameAdmin() {
	return UserNameAdmin;
}

public WebElement getPasswordNameAdmin() {
	return PasswordNameAdmin;
}

public WebElement getLoginButtonAdmin() {
	return LoginButtonAdmin;
}
//Business Libraries

public void AdminLoginPage(String userName,String Password) {
	UserNameAdmin.sendKeys(userName);
	PasswordNameAdmin.sendKeys(Password);
	LoginButtonAdmin.click();
	
}


}
