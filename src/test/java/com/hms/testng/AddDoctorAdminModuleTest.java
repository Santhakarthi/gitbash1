package com.hms.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hms.ObjectRepo.AddDoctorPage;
import com.hms.ObjectRepo.AdminDashboardPage;
import com.hms.ObjectRepo.AdminLoginPage;
import com.hms.genericUtility.BaseClass;
import com.hms.genericUtility.DatabaseUtility;
import com.hms.genericUtility.ExcelUtility;
import com.hms.genericUtility.FileUtility;
import com.hms.genericUtility.JavaUtility;
import com.hms.genericUtility.WebdriverUtility;
@Listeners(com.hms.genericUtility.ListnerImplementClass.class)
public class AddDoctorAdminModuleTest extends BaseClass {
@Test(groups="smoke")
public void addDoctorPage() throws Throwable {
	AdminDashboardPage adp=new AdminDashboardPage(driver);
	adp.clickOnDoctorLink();
   adp.getAddDoctorLink().click();
   
   AddDoctorPage adp1=new AddDoctorPage(driver);
	adp1.getSelectDoctorSpecialization().click();
	driver.findElement(By.xpath("//option[contains(text(),'Medicine12345689')]")).click(); 
	  elib.getMultipleDataFromExcel("AddDoctor", 0, 1, driver);
	  String Email="abc123@gmail.com";
		String[] str=Email.split("@");
		String Name=str[1];
		 
 adp1.getEnterDoctorEmail().sendKeys(Name+jLib.getRandomNumber()+str[0]);
	  
	  
	  
     adp1.getSubmitButton().click();
   wLib.acceptAlertPopup(driver, "Doctor info added Successfully","Doctor added successfully","Doctor not added successfully");
   String actualMsg="Doctor info added Successfully";
    String exceptedMsg="Doctor info added Successfully";
   Assert.assertEquals(exceptedMsg, exceptedMsg);
}

	

	


    


 


}
