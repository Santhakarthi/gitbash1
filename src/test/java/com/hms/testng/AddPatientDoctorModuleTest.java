package com.hms.testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hms.ObjectRepo.AddPatientDoctorModulePage;
import com.hms.ObjectRepo.DoctorDashboardPage;
import com.hms.ObjectRepo.DoctorLoginPage;
import com.hms.genericUtility.BaseClass;

public class AddPatientDoctorModuleTest extends BaseClass {
	
	@Test
public void addPatientDoctorModulePage() throws Throwable {
		String PatientMedicalhistory = "backpain";
		elib.getRowCount("AddPatient");
		DoctorDashboardPage ddp = new DoctorDashboardPage(driver);
		ddp.getPatientlink().click();
		ddp.getAddPatientLink().click();
		driver.findElement(By.xpath("(//div[@class='clip-radio radio-primary']/descendant::label)[2]")).click();
		elib.getMultipleDataFromExcel("AddPatient", 0, 1, driver);

		AddPatientDoctorModulePage apdmp = new AddPatientDoctorModulePage(driver);
		apdmp.getSubmitButton().click();
		String PatientName = "Mandella123456";
		DoctorDashboardPage ddp1 = new DoctorDashboardPage(driver);
		ddp1.getPatientlink().click();
		ddp1.getManagePatient().click();
		
		List<WebElement> pname = driver.findElements(By.xpath("//td[@class='hidden-xs']"));
		{
			for (WebElement pn : pname) {
				String notp = pn.getText();

				if (notp.equals(PatientName)) {
					System.out.println("patient added successfully");

				}

			}
		}

	}

		
}
	

