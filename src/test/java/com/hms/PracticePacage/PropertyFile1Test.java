package com.hms.PracticePacage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertyFile1Test {

	public static void main(String[] args) throws Throwable {
		Properties prop=new Properties();
prop.setProperty("username", "admin");
prop.setProperty("password", "Test@12345");
prop.setProperty("url", "http://rmgtestingserver/domain/Hospital_Management_System/");
prop.setProperty("browser", "Chrome");
  FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\commondata1.properties");
  prop.store(fos,"write data");
  fos.close();
  
  FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commondata1.properties");
  prop.load(fis);
	
	
String USERNAME=prop.getProperty("username");
String PASSWORD=prop.getProperty("password");
String URL=prop.getProperty("url");
String BROWSER=prop.getProperty("browser");



WebDriver driver=new ChromeDriver();
driver.get("http://rmgtestingserver/domain/Hospital_Management_System/");
driver.findElement(By.xpath("(//a[text()='Click Here'])[3]")).click();
driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
driver.findElement(By.xpath("//button[@name='submit']")).click();


}
}