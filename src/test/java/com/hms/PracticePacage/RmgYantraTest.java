package com.hms.PracticePacage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class RmgYantraTest {

	public static void main(String[] args) throws Throwable {
		Connection con=null;
		String expdata="TY_PROJ_SDET";
		Random r=new Random();
		int rn=r.nextInt(20000);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://rmgtestingserver:8084/");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rmgyantra");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("rmgy@9999");
        driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        driver.findElement(By.xpath("//a[.='Projects']")).click();
        driver.findElement(By.xpath("//span[text()='Create Project']")).click();
        driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(expdata+rn);
        driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Karthi");
        WebElement ele=driver.findElement(By.xpath("//select[@name='status']"));
        Select sel=new Select(ele);
        sel.selectByVisibleText("Created");
        driver.findElement(By.xpath("//input[@value='Add Project']")).click();
        
        Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		
		con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root" );
		
		 Statement state = con.createStatement();
		 String query="select * from project;";
		 ResultSet res = state.executeQuery(query);
boolean flag=false;
while (res.next()) {
	String actual=res.getString(4);
	if(actual.equalsIgnoreCase(expdata+rn)) {
		flag=true;
		break;
	}
}
if(flag==true)
{
	System.out.println("project is created");
}
	else {
		System.out.println("project is not created");
	}
}

	}


