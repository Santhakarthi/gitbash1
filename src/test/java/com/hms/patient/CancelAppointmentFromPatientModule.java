package com.hms.patient;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CancelAppointmentFromPatientModule {

	public static void main(String[] args) {
		String username="23rdsep@gmail.com";
		String password="9876543210";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("(//a[text()='Click Here'])[1]")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		driver.findElement(By.xpath("//ul[@class='main-navigation-menu']/descendant::span[contains(text(),'Appointment History')]")).click();
driver.findElement(By.xpath("(//div[@class='visible-md visible-lg hidden-sm hidden-xs']/descendant::a[text()='Cancel'])[1]")).click();
Alert a=driver.switchTo().alert();
a.accept();
String appointment =driver.findElement(By.xpath("//p[contains(text(),'Your appointment canceled')]")).getText();
String canceled="Your appointment canceled";
if(appointment.equals(canceled))
{
	System.out.println("your appointment cancelled Successfully");
	
}
else {
	System.out.println("your appointment not  cancelled Successfully");
}
	}

}
