package com.hms.PracticePacage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class goibboTest1 {

	public static void main(String[] args) {
		int date=25;
		String monthAndYear="March 2024";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[.='Departure']")).click();
  String actual="(//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Months']/descendant::div[@class='DayPicker-Month'])[2]/preceding::div[@class='DayPicker-Body']/following::p[text()='"+date+"']";
  for (;;) {
		try {
			driver.findElement(By.xpath(actual)).click();
			break;
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();

		}

	}

	}

}
