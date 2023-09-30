package com.hms.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

public class AnnotationTest {
	
	@BeforeSuite
	public void configBs() {
		System.out.println("connect to database");
	}
	@BeforeClass
	public void configBc() {
		System.out.println("launch the browser");
		
	}
	@BeforeMethod
	public void loginBrowser() {
		System.out.println("login to application");
	}
	@Test(dependsOnMethods ="demo")
	public void sample() {
		System.out.println("TestScript1");
	}
	
	@AfterMethod
	public void logoutBrowser() {
		System.out.println("logout to application");
	}
	@AfterClass
	public void closeBrowser() {
		System.out.println("close the browser");
	}
	@AfterSuite
	public void closeTheDataBase() {
		System.out.println("close the  database");
	}
	@Test
	public void demo() {
		System.out.println("TestScript2");

	}
}

