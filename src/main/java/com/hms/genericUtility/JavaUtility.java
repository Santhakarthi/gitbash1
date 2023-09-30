package com.hms.genericUtility;


import java.util.Date;

import java.util.Random;
/**
 * 
 * This class consists of java related methods
 * @author Karthi
 * 
 * 
 * 
 */
public class JavaUtility {
/**
 * 
 * This method is used to get the random number
 * 
 * @return
 * 
 */
	public int getRandomNumber() {
		Random ran=new Random();
		int randNum=ran.nextInt(1000);
		return randNum;
		
	}
	/**
	 * This Method will fetch System date in IST Format
	 * 
	@return
	 * 
	 */
	
	public String getSystemDate()
	{
		Date d=new  Date();
		String date=d.toString();
		return date;
	}
	/**
	 * This Method will fetch System date in required Format
	 * 
	@return
	 * 
	 */
	public String getSystemDateInFormat()
	{
		Date dateTime=new  Date();
	String[] d=dateTime.toString().split(" ");
	String day=d[0];
	String month=d[1];
	String date=d[2];
	String year=d[5];
	String dateFormat=year+"-"+month+"-"+date;
	return dateFormat;
	
	}
}
