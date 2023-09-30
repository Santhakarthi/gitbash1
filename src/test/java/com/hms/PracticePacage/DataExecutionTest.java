package com.hms.PracticePacage;

import org.testng.annotations.Test;

public class DataExecutionTest {
	
	
	@Test(dataProviderClass=DataProviderTest.class,dataProvider="mobiles")
public void getData(String pName,int price,String size) {
	System.out.println(pName+"===>"+price+"==>"+size);
}
}
