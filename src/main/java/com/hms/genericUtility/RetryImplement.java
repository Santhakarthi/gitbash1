package com.hms.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplement implements  IRetryAnalyzer  {
int count=0;
int upperlimit=3;
	@Override
	public boolean retry(ITestResult result) {
		if(count<upperlimit) {
			count++;
			return true;
		}
		return false;
	}

	

}
