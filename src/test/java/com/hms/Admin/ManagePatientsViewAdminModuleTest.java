package com.hms.Admin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManagePatientsViewAdminModuleTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//a[text()='Click Here'])[3]")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[contains(text(),'Patients')]")).click();
		driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[contains(text(),' Manage Patients ')]")).click();
driver.findElement(By.xpath("//a[@href='view-patient.php?viewid=7']")).click();
 boolean patientdetails = driver.findElement(By.xpath("//td[contains(text(),'Patient Details')]")).isDisplayed();
 if(patientdetails==true) {
	 System.out.println("patient details displayed");
 }
 else {
	 System.out.println("patient details displayed"); 
 }
	}

}
