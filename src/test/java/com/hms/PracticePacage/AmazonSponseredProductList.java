package com.hms.PracticePacage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSponseredProductList {

	public static void main(String[] args) {
		
		
		String product="sofa set for living room";
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys(product);
        driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']")).click();
        
        List<WebElement> lib=driver.findElements(By.xpath("//span[.='Sponsored']/ancestor::div[@class='a-section a-spacing-none a-spacing-top-small s-title-instructions-style']"));
        
        
        for(WebElement wb:lib) {
        
 System.out.println(wb.getText());
        }
	}

}
