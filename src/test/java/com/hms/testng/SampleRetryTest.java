package com.hms.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hms.genericUtility.BaseClass;



public class SampleRetryTest  extends BaseClass{
	@Test(retryAnalyzer=com.hms.genericUtility.RetryImplement.class)
public void retrytest() {
	Assert.assertEquals("A", "B");
}
}
