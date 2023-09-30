package com.hms.Doctor;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddPatientDoctorModuleTest {

	public static void main(String[] args) throws Throwable {
	/*	String username = "vasu2495@gmail.com";
		String password = "Vasu@2475";
		String patientname = "Govindachetty v.d";
		String patientcontactnumber = "9840382183";
		String pemail = "govind1415@gmail.com";
		String paddress = "1/115,Venkatampatti,Dharmapuri";
		String page = "85";
		String PatientMedicalhistory = "diabetics ,bp";*/
WebDriver driver=null;
		
		
		
		//fetch the common data Using Property File
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		
		String BROWSER=pobj.getProperty("browser1");
		String URL=pobj.getProperty("url1");
		String USERNAME=pobj.getProperty("username2");
		String PASSWORD=pobj.getProperty("password2");
		
		//read the data from ExcelSheet
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestData003.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("AddPatient");
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
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("(//a[text()='Click Here'])[2]")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[text()=' Patients ']"))
				.click();
		driver.findElement(
				By.xpath("//ul[@class='main-navigation-menu']/descendant::span[contains(text(),'Add Patient')]"))
				.click();
	/*	driver.findElement(By.xpath("//input[@placeholder='Enter Patient Name']")).sendKeys(patientname);
		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Contact no']")).sendKeys(patientcontactnumber);
		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Email id']")).sendKeys(pemail);*/
		driver.findElement(By.xpath("(//div[@class='clip-radio radio-primary']/descendant::label)[2]")).click();
	/*	driver.findElement(By.xpath("//textarea[@placeholder='Enter Patient Address']")).sendKeys(paddress);
		driver.findElement(By.xpath("//input[@placeholder='Enter Patient Age']")).sendKeys(page);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Patient Medical History(if any)']"))
				.sendKeys(PatientMedicalhistory);*/
		
		 HashMap<String,String> map=new HashMap<String,String>();
			for(int i=1;i<=lastRow;i++) {
				String key=sh.getRow(i).getCell(0).getStringCellValue();
				String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
			}
			for( Entry<String, String> ss:map.entrySet())
			{
			driver.findElement(By.xpath(ss.getKey())).sendKeys(ss.getValue());
					}
			
		
		
		
		
		
		
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		String PatientName="venkatappan vg";
		driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
		driver.findElement(
				By.xpath("//span[text()=' Patients ']/following::ul/descendant::span[text()=' Manage Patient ']"))
				.click();
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