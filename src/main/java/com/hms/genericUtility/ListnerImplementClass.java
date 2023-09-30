package com.hms.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementClass implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		//actual testscript execution starts from here
				String MethodName=result.getMethod().getMethodName();
				test=report.createTest(MethodName);
				Reporter.log(MethodName+"===>Execution starts");
		
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
	String MethodName=result.getMethod().getMethodName();
	test.log(Status.PASS, MethodName+"=====Passed");
	Reporter.log(MethodName+"===>Test Script Executed successfully");
	
	
	}
	@Override
	public void onTestFailure(ITestResult result) {
	TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dst=new File("./Screenshot/Failedscript.png");
	try {
		FileUtils.copyFile(src, dst);
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	String MethodName=result.getMethod().getMethodName();
	
	 
	try {
		String	FailedScript = WebdriverUtility.getScreenshot(BaseClass.sdriver,MethodName);
		test.addScreenCaptureFromPath(FailedScript);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	test.log(Status.FAIL, result.getThrowable());
	test.log(Status.FAIL,MethodName+"=====>Failed");
	Reporter.log(MethodName+"=====>FAiled");
	
	
	
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, MethodName+"=====Skipped");
		Reporter.log(MethodName+"===>Skipped");
		
	}



	@Override
	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./Extendreport/report.html");
		htmlreport.config().setDocumentTitle("SDET-51");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Royal-Free-Hospital");
		
		
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("os", "windows-10");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-Browser", "http://rmgtestingserver/domain/Hospital_Management_System/");
		report.setSystemInfo("Reporter-Name", "KARTHIKEYAN V.H");
		
		
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
		report.flush();
		
	}

	
		
	
	
	
	

	
	

	
}
