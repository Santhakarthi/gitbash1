package com.hms.PracticePacage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonMobileBrandTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("http://www.amazon.in/");
		WebElement element = driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']"));
		element.sendKeys("Mobiles");
		element.submit();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='realme']")).click();
		driver.findElement(By.xpath("//input[@name='high-price']")).sendKeys("20000");
		driver.findElement(By.xpath("//span[@id='a-autoid-1']")).click();
		List<WebElement> mobiles = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println(mobiles.size());
		for (int i = 0; i < mobiles.size(); i++) {
			System.out.println(mobiles.get(i).getText());
		}
			}

}
