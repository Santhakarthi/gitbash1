package com.hms.testng;

import org.testng.annotations.Test;

public class DataProviderExcelExecutionTest {
	
	
	
	@Test(dataProviderClass=DataProviderFromExcelTest.class,dataProvider="dataFromExcel")
public void getData(String pName,String price,String size) {
	System.out.println(pName+"====>"+price+"===>"+size);
}
}
