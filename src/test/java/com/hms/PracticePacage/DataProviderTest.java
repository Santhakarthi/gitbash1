package com.hms.PracticePacage;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
@DataProvider
public Object[][] mobiles(){
	Object[][] obj = new Object[2][3];
	
	obj[0][0]="Samsung";
	obj[0][1]=50000;
	obj[0][2]="8 inch";
	
	obj[1][0]="Redmi";
	obj[1][1]=10000;
	obj[1][2]="9inch";
	
	return obj;
}
@DataProvider
public Object[][] tv(){
	Object[][] obj = new Object[2][3];
	
	obj[0][0]="Lg";
	obj[0][1]=50000;
	obj[0][2]="45 inch";
	
	obj[1][0]="Sony";
	obj[1][1]=12000;
	
	obj[1][2]="55 inch";
	
	return obj;
}
}
