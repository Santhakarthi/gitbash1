package com.hms.PracticePacage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JioMartGroceriesTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.jiomart.com/");
	WebElement we=	driver.findElement(By.xpath("//a[text()='Groceries']"));
		Actions a=new  Actions(driver);
		a.moveToElement(we).perform();
		
		WebElement fruits = driver.findElement(By.xpath("//a[text()='Fruits & Vegetables']"));
		
Actions a1=new Actions(driver);
a1.moveToElement(fruits).perform();
List<WebElement> fresh = driver.findElements(By.xpath("//a[text()='Fruits & Vegetables']/ancestor::li[@id='nav_sub_cat_219']/descendant::li"));
for(WebElement d: fresh)
{
	System.out.println(d.getText());
}
	}

}
