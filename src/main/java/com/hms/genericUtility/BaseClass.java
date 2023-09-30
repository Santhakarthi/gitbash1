package com.hms.genericUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.hms.ObjectRepo.AdminDashboardPage;
import com.hms.ObjectRepo.AdminLoginPage;
import com.hms.ObjectRepo.DoctorDashboardPage;
import com.hms.ObjectRepo.DoctorLoginPage;

public class BaseClass {

	public DatabaseUtility dlib = new DatabaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebdriverUtility wLib = new WebdriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun=true)
	public void configBS() throws Throwable {
		dlib.connectToDB();

		System.out.println("===connect to database=======");
	}

	@BeforeClass(alwaysRun=true)
	public void configBc() throws Throwable {
		String BROWSER = flib.getPropertyKeyValue("browser1");
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser");
		}
		
		sdriver=driver;
		wLib.maximizeTheBrowser(driver);

	}

	@BeforeMethod(alwaysRun=true)
	public void configBM() throws Throwable {
		String URL = flib.getPropertyKeyValue("url1");
		String USERNAME = flib.getPropertyKeyValue("username1");
		String PASSWORD = flib.getPropertyKeyValue("password1");
		
		
		driver.get(URL);
		wLib.implicitWait(driver, 10);
		driver.findElement(By.xpath("(//a[text()='Click Here'])[3]")).click();

		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.AdminLoginPage(USERNAME, PASSWORD);
		alp.getLoginButtonAdmin().click();
		
	/*	String URL1 = flib.getPropertyKeyValue("url1");
		String USERNAME1 = flib.getPropertyKeyValue("username2");
		String PASSWORD1 = flib.getPropertyKeyValue("password2");
		driver.get(URL1);
3		wLib.implicitWait(driver, 10);
		
		driver.findElement(By.xpath("(//a[text()='Click Here'])[2]")).click();

		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		dlp.DoctorLoginPage(USERNAME1, PASSWORD1);
		dlp.ClickOnSubmittButton();
		System.out.println("=====Login to application=======");*/

	}

	@AfterMethod(alwaysRun=true)
	public void configAM() {
		AdminDashboardPage adp = new AdminDashboardPage(driver);
		adp.getProfileIcon().click();
		adp.getLogOut().click();
		System.out.println("======Logout the Application======");
		
		
		
	/*	DoctorDashboardPage ddp = new DoctorDashboardPage(driver);
		ddp.getProfileIcon().click();
		ddp.getLogOut().click();
		
		
		System.out.println("======Logout the Application======");*/
	}

	@AfterClass(alwaysRun=true)
	public void configAC() {
	driver.quit();
		System.out.println("=======close the browser=======");
	}

	@AfterSuite(alwaysRun=true)
	public void configAS() throws Throwable {
		dlib.closeDB();
		System.out.println("====close the DatabaseConnection====");
	}

}
