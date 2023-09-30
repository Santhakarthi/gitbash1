package com.hms.PracticePacage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMytripCalenderTest {

	public static void main(String[] args) throws InterruptedException {
		int date = 6;
		String monthAndYear = "January 2024";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");
		Actions a = new Actions(driver);
		a.doubleClick().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		Thread.sleep(2000);
		String actual = "//div[text()='" + monthAndYear
				+ "']/ancestor::div[@class='DayPicker-Months']/descendant::div[@class='DayPicker-Month']/preceding::div[@class='DayPicker-Body']/following::p[text()='"
				+ date + "']";
		for (;;) {
			try {
				driver.findElement(By.xpath(actual)).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

			}

		}

	}

}
