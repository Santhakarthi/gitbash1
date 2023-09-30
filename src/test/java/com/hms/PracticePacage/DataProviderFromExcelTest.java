package com.hms.PracticePacage;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.hms.genericUtility.ExcelUtility;
import com.hms.genericUtility.Ipathconstants;

public class DataProviderFromExcelTest {
@DataProvider
public Object[][] dataFromExcel()throws Throwable{
	ExcelUtility elib=new ExcelUtility();
	Object[][] value = elib.getMultipleSetofData("DataProvider");
	return value;
}


}
