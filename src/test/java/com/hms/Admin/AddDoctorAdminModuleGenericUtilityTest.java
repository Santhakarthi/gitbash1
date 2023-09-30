package com.hms.Admin;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hms.genericUtility.DatabaseUtility;
import com.hms.genericUtility.ExcelUtility;
import com.hms.genericUtility.FileUtility;
import com.hms.genericUtility.JavaUtility;
import com.hms.genericUtility.WebdriverUtility;

public class AddDoctorAdminModuleGenericUtilityTest {
	public static void main(String[] args) throws Throwable {
		/*
		String DoctorName="Vasudevan";
		String clinicAddress="56,3rd cross near Mathaschool,Garabavepalaya";
		String fees="100";
		String contactno="7200785115";
		String email="vasu2495@gmail.com";
		String password="Vasu@2475";
		String confirmPassword="Vasu@2475";*/
WebDriver driver=null;
		//create object for all utility classes
        DatabaseUtility dlib=new DatabaseUtility();
        FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebdriverUtility wLib=new WebdriverUtility();
		
		//fetch the common data Using Property File
	/*	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		
		
		String BROWSER=pobj.getProperty("browser1");
		String URL=pobj.getProperty("url1");
		String USERNAME=pobj.getProperty("username1");
		String PASSWORD=pobj.getProperty("password1");*/
		
		String BROWSER=	flib.getPropertyKeyValue("browser1");
		String URL=flib.getPropertyKeyValue("url1");
		String USERNAME=	flib.getPropertyKeyValue("username1");
		String PASSWORD=flib.getPropertyKeyValue("password1");
		
		
		
		//read the data from ExcelSheet
	/*	FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestData002.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("AddDoctor");
		int lastRow=sh.getLastRowNum(); 
		*/
		elib.getRowCount("AddDoctor");
		
		
		if(BROWSER.equalsIgnoreCase("Chrome")) {
			 driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver =new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		wLib.maximizeTheBrowser(driver);
		//driver.manage().window().maximize();
		driver.get(URL);
		
		wLib.implicitWait(driver, 10);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//a[text()='Click Here'])[3]")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[text()=' Doctors ']")).click();
		driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[text()=' Add Doctor']")).click();
		driver.findElement(By.xpath("//select[@name='Doctorspecialization']")).click()	;
	    driver.findElement(By.xpath(" //option[@value='laproscopy']	")).click(); 
     /*   
        driver.findElement(By.xpath(" //input[@placeholder='Enter Doctor Name']")).sendKeys(DoctorName);
        driver.findElement(By.xpath(" //textarea[@placeholder='Enter Doctor Clinic Address']")).sendKeys(clinicAddress);
        driver.findElement(By.xpath("//input[@placeholder='Enter Doctor Consultancy Fees']")).sendKeys(fees);
        driver.findElement(By.xpath(" //input[@placeholder='Enter Doctor Contact no']")).sendKeys(contactno);
        driver.findElement(By.xpath(" //input[@placeholder='Enter Doctor Email id']")).sendKeys(email);
        driver.findElement(By.xpath(" //input[@placeholder='New Password']")).sendKeys(password);
        driver.findElement(By.xpath(" //input[@placeholder='Confirm Password']")).sendKeys( confirmPassword);
*/
        
   /*     HashMap<String,String> map=new HashMap<String,String>();
		for(int i=1;i<=lastRow;i++) {
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
		map.put(key, value);
		}
		for( Entry<String, String> ss:map.entrySet())
		{
		driver.findElement(By.xpath(ss.getKey())).sendKeys(ss.getValue());
				}*/
        
        elib.getMultipleDataFromExcel("AddDoctor", 0, 1, driver);
        
      
  
        
        
        
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		
		
		/* Alert a=driver.switchTo().alert();
        String text=a.getText();
        a.accept();
      System.out.println(text);*/
		wLib.acceptAlertPopup(driver, "Doctor info added Successfully","Doctor added successfully","Doctor not added successfully");
      String exceptedMsg="Doctor info added Successfully";
     
     
	
	}


}
