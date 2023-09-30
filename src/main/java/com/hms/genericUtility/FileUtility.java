package com.hms.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class consists of methods to fetch common data from property file
 * @author Karthi
 * 
 * 
 * 
 * 
 * 
 */
public class FileUtility {
/**
 * This method is used to fetch common data present inside property file
 * @param key
 * @return
 * 
 * @throws IOException
 * 
 * 
 */
	public String getPropertyKeyValue(String Key) throws IOException{
		
		FileInputStream fileInputStream=new FileInputStream(Ipathconstants.propertiesFilePath);
		Properties prop=new Properties();
		prop.load(fileInputStream);
		
		return prop.getProperty(Key);
		
	}
	
	
	
	
	
}
