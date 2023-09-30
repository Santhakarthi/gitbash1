package com.hms.PracticePacage;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFileTest {

	public static void main(String[] args) throws Throwable{
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData001.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		Sheet  sh= wb.getSheet("Cricket");
	//	String value=sh.getRow(1).getCell(0).getStringCellValue();
	//	System.out.println(value);
	//	wb.close();
	  // int count=sh.getLastRowNum();
		//for(int i=1;i<=count;i++)
		//{
			//String value=sh.getRow(i).getCell(0).getStringCellValue();
			//System.out.println(value);
		//}
	//*	int count=sh.getLastRowNum();
		//*for(int i=1;i<=count;i++)
		//*{
		//*	String CountriesName=sh.getRow(i).getCell(0).getStringCellValue();
		//*	String PlayerName=sh.getRow(i).getCell(1).getStringCellValue();
		//*	String TeamRanking=sh.getRow(i).getCell(2).getStringCellValue();
		//*	System.out.println(CountriesName+"-----"+PlayerName+"-----" + TeamRanking);
		//*}
		int count=sh.getLastRowNum();
		int lastCell=sh.getRow(1).getLastCellNum();
		for(int i=1;i<=count;i++)//row
		{
			for(int j=0;j<lastCell;j++)//cell
			{
				String value=sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value +"---"  );
			}System.out.println();
			
		}
		
		
		
	}

}
