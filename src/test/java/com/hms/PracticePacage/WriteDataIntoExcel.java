package com.hms.PracticePacage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws Throwable {
		String CountriesName="Scotland";
		String PlayerName="Richee Berington";
		int a=50;
		String str = Integer.toString(a);	
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData001.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Cricket");
		
		sh.createRow(10).createCell(0).setCellValue(CountriesName);
		sh.getRow(10).createCell(1).setCellValue(PlayerName);
		sh.getRow(10).createCell(2).setCellValue(str);
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData001.xlsx");
		wb.write(fos);
		wb.close();
	}

}
