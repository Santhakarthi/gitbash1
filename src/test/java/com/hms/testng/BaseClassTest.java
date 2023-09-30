package com.hms.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClassTest {

	
	@BeforeSuite
	public void configBS()  {
System.out.println(" BeforeSuiteconnect to database");
	}
	
	@BeforeTest
	public void configBT() {
		System.out.println("BeforeTest");
	}
	@BeforeClass
	public void configBC() {
		System.out.println("beforeclass for open the browser");
	}
	@BeforeMethod
	public void configBM() {
		System.out.println("beforeMethods for Login the app");
	}
	@BeforeMethod
	public void configBM1() {
		System.out.println("beforeMethods1 for Login the app");
	}
	
	@BeforeMethod
	public void configBM2() {
		System.out.println("beforeMethods2 for Login the app");
	}
	@AfterMethod
	public void configAm() {
		System.out.println("AfterMethod for Logout");

	}
	@BeforeMethod
	public void configBM3() {
		System.out.println("beforeMethods for Login the app");
	}
	@BeforeMethod
	public void configBM4() {
		System.out.println("beforeMethods1 for Login the app");
	}
	
	@BeforeMethod
	public void configBM5() {
		System.out.println("beforeMethods2 for Login the app");
	}
	
	
	@AfterMethod
	public void configAm1() {
		System.out.println("AfterMethod1 for Logout");

	}
	
	@BeforeClass
	public void configBC1() {
		System.out.println("beforeclass 1for open the browser");
	}
	@AfterTest
	public void configAT() {
		System.out.println("AfterTest ");
	}
	
	@AfterSuite
	public void configAs() {
		System.out.println("close the database");
	}
	
	
	
}
