package com.hms.PracticePacage;


import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("https://www.epfindia.gov.in/site_en/index.php");
        Thread.sleep(3000);
        List<WebElement> anchorLinks = driver.findElements(By.tagName("//a"));
        System.out.println("Total Links are: " + anchorLinks.size());
        Thread.sleep(3000);
        ArrayList<String> al = new ArrayList<String>();
        for (int i = 0; i < anchorLinks.size(); i++) {
        String singleLink = anchorLinks.get(i).getAttribute("href");
        URL url = null;
        int statusCode=0;
        try {
        	 url = new URL(singleLink);
        	 HttpsURLConnection  HUC=  (HttpsURLConnection) url.openConnection();
        	 statusCode=HUC.getResponseCode();
        	 if(statusCode>=400) {
        		 al.add(singleLink+"---> "+statusCode);
        		 System.out.println(singleLink+" --->"+statusCode);
        	 }
        }
        	 catch(Exception e) {
        		 al.add(singleLink);
	}
	
}
	} 
}
