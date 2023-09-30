package com.hms.Admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddDoctorSpecializationAdminModuleTest {

	public static void main(String[] args) throws Throwable {
		/* click on Admin Module Admin login Page displayed
		 * enter valid credential and login after that Admin Dashboard page will open and 
		 * click on Doctor link and AddDoctorSpecialization,AddDoctor,ManageDoctor,DeleteDoctor
*/
		WebDriver driver=null;
		
		
		
		//fetch the common data Using Property File
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		
		String BROWSER=pobj.getProperty("browser1");
		String URL=pobj.getProperty("url1");
		String USERNAME=pobj.getProperty("username1");
		String PASSWORD=pobj.getProperty("password1");
		
		//read the data from ExcelSheet
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestData002.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("AddDoctorSpecialization");
		int lastRow=sh.getLastRowNum();
		
		
		
		
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			 driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver =new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("(//a[text()='Click Here'])[3]")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[text()=' Doctors ']")).click();
		driver.findElement(By.xpath("//span[text()=' Doctor Specialization ']")).click();
	//	driver.findElement(By.xpath("//input[@name='doctorspecilization']")).sendKeys(Specialization);
		
		HashMap<String,String> map=new HashMap<String,String>();
		for(int i=1;i<=lastRow;i++) {
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
		map.put(key, value);
		}
		for( Entry<String, String> ss:map.entrySet())
		{
		driver.findElement(By.name(ss.getKey())).sendKeys(ss.getValue());
		}
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		
		String res = driver.findElement(By.xpath("//p[contains(text(),'Doctor Specialization added successfully !!	')]")).getText();
		String actualres="Doctor Specialization added successfully !!";
if(actualres.contains(res))
{
	System.out.println("DoctorSpecialization added");
}
else {
	System.out.println("DoctorSpecialization not added");
}

	}

}
