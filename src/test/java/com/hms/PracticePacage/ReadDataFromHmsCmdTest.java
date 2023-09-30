package com.hms.PracticePacage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadDataFromHmsCmdTest {
	@Test
	public void cmdTest() {
		String BROWSER = System.getProperty("browser1");
		String URL = System.getProperty("url1");
		String USERNAME = System.getProperty("username1");
		String PASSWORD = System.getProperty("password1");

		// launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.xpath("(//a[text()='Click Here'])[3]")).click();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@name='submit']")).click();
		
	}	

}
