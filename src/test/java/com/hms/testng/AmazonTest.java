package com.hms.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) throws Throwable {
		String mobiles="iphone";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("http://www.amazon.in/");
        driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys(mobiles);
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
      WebElement  e = driver.findElement(By.xpath("//span[text()='Sponsored']/ancestor::div[@class='a-section']/descendant::span[text()='Apple iPhone 14 (128 GB) - Blue']/ancestor::div[@class='a-section']/descendant::span[@class='a-price-whole']"));
      
	
	
	
		System.out.println(e.getText());
	
      
      
	}

}
