package com.hms.Doctor;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hms.ObjectRepo.AddPatientDoctorModulePage;
import com.hms.ObjectRepo.DoctorDashboardPage;
import com.hms.ObjectRepo.DoctorLoginPage;
import com.hms.genericUtility.DatabaseUtility;
import com.hms.genericUtility.ExcelUtility;
import com.hms.genericUtility.FileUtility;
import com.hms.genericUtility.JavaUtility;
import com.hms.genericUtility.WebdriverUtility;

public class AddPatientDoctorModulePomTest {

	public static void main(String[] args) throws Throwable {
		String PatientMedicalhistory = "backpain";
		WebDriver driver = null;
//create object for all utility classes
		DatabaseUtility dlib = new DatabaseUtility();
		FileUtility flib = new FileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebdriverUtility wLib = new WebdriverUtility();

		// fetch the common data Using Property File
		/*
		 * FileInputStream fis=new
		 * FileInputStream(".\\src\\test\\resources\\CommonData.properties"); Properties
		 * pobj=new Properties(); pobj.load(fis);
		 * 
		 * String BROWSER=pobj.getProperty("browser1"); String
		 * URL=pobj.getProperty("url1"); String USERNAME=pobj.getProperty("username2");
		 * String PASSWORD=pobj.getProperty("password2");
		 * 
		 * //read the data from ExcelSheet FileInputStream fi=new
		 * FileInputStream(".\\src\\test\\resources\\TestData002.xlsx"); Workbook wb =
		 * WorkbookFactory.create(fi); Sheet sh=wb.getSheet("AddPatient"); int
		 * lastRow=sh.getLastRowNum();
		 */

		elib.getRowCount("AddPatient");

		String BROWSER = flib.getPropertyKeyValue("browser1");
		String URL = flib.getPropertyKeyValue("url1");
		String USERNAME = flib.getPropertyKeyValue("username2");
		String PASSWORD = flib.getPropertyKeyValue("password2");

		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser");
		}
		wLib.maximizeTheBrowser(driver);
		// driver.manage().window().maximize();
		driver.get(URL);

		wLib.implicitWait(driver, 10);

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("(//a[text()='Click Here'])[2]")).click();
		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		dlp.DoctorLoginPage(USERNAME, PASSWORD);
		dlp.ClickOnSubmittButton();
		// driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		// driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		// driver.findElement(By.xpath("//button[@name='submit']")).click();

		DoctorDashboardPage ddp = new DoctorDashboardPage(driver);
		ddp.getPatientlink().click();
		ddp.getAddPatientLink().click();
		// driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[text()='
		// Patients ']"))
		// .click();
		// driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[contains(text(),'Add
		// Patient')]"))
		// .click();
		/*
		 * driver.findElement(By.xpath("//input[@placeholder='Enter Patient Name']")).
		 * sendKeys(patientname); driver.findElement(By.
		 * xpath("//input[@placeholder='Enter Patient Contact no']")).sendKeys(
		 * patientcontactnumber);
		 * driver.findElement(By.xpath("//input[@placeholder='Enter Patient Email id']")
		 * ).sendKeys(pemail);
		 */
		driver.findElement(By.xpath("(//div[@class='clip-radio radio-primary']/descendant::label)[2]")).click();
		/*
		 * driver.findElement(By.
		 * xpath("//textarea[@placeholder='Enter Patient Address']")).sendKeys(paddress)
		 * ; driver.findElement(By.xpath("//input[@placeholder='Enter Patient Age']")).
		 * sendKeys(page); driver.findElement(By.
		 * xpath("//textarea[@placeholder='Enter Patient Medical History(if any)']"))
		 * .sendKeys(PatientMedicalhistory);
		 */

		/*
		 * HashMap<String,String> map=new HashMap<String,String>(); for(int
		 * i=1;i<=lastRow;i++) { String
		 * key=sh.getRow(i).getCell(0).getStringCellValue(); String
		 * value=sh.getRow(i).getCell(1).getStringCellValue(); map.put(key, value); }
		 * for( Entry<String, String> ss:map.entrySet()) {
		 * driver.findElement(By.xpath(ss.getKey())).sendKeys(ss.getValue()); }
		 */

		elib.getMultipleDataFromExcel("AddPatient", 0, 1, driver);

		AddPatientDoctorModulePage apdmp = new AddPatientDoctorModulePage(driver);
		apdmp.getSubmitButton().click();
		// driver.findElement(By.xpath("//button[@name='submit']")).click();
		String PatientName = "Nelson";
		DoctorDashboardPage ddp1 = new DoctorDashboardPage(driver);
		ddp1.getPatientlink().click();
		// driver.findElement(By.xpath("//span[text()=' Patients ']")).click();

		ddp1.getManagePatient().click();
		// driver.findElement(By.xpath("//span[text()=' Patients
		// ']/following::ul/descendant::span[text()=' Manage Patient ']"))
		// .click();
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
