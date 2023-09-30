package com.hms.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import com.hms.ObjectRepo.AddDoctorSpecializationPage;
import com.hms.ObjectRepo.AdminDashboardPage;
import com.hms.ObjectRepo.AdminLoginPage;
import com.hms.genericUtility.BaseClass;

import com.hms.genericUtility.DatabaseUtility;
import com.hms.genericUtility.ExcelUtility;
import com.hms.genericUtility.FileUtility;
import com.hms.genericUtility.JavaUtility;
import com.hms.genericUtility.WebdriverUtility;

@Listeners(com.hms.genericUtility.ListnerImplementClass.class)
public class AddDoctorSpecializationAdminModuleTest extends BaseClass {
	
	@Test(groups = "smoke")
	public void addDoctorSpecialization() throws Throwable {
		
	
		AdminDashboardPage adp = new AdminDashboardPage(driver);
		adp.clickOnDoctorLink();
		adp.clickOnDoctorSpecializationLinkLink();
		
		
			
		 String spc = elib.readDataFromExcelSheet("AddDoctorSpecializatiuon", 1,1);
			
		 AddDoctorSpecializationPage adsp=new AddDoctorSpecializationPage(driver);
		 //Thread.sleep(2000);
		 adsp.addDoctorSpecializationPage(spc+jLib.getRandomNumber());
			 //adsp.getAddDoctorSpecialization().click();
			// adsp.getSubmitButton().click();
			
			String expectedres =  driver.findElement(By.xpath("//p[contains(text(),'Doctor Specialization added successfully !!	')]")).getText();
			String actualres="Doctor Specialization added successfully !!";
//	if(actualres.contains(res))
//	{
//		System.out.println("DoctorSpecialization added");
//	}
//	
Assert.assertEquals(actualres, expectedres);
//else {
		//System.out.println("DoctorSpecialization not added");
//	}

	}

}
