package com.hms.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class consists of excel sheet related methods
 * 
 * @author Karthi
 * 
 * 
 * 
 */
public class ExcelUtility {
/**
 * This method is used to fetch data from excelSheet
 * @param sheetName
 * @param rowNo
 * @param cellNo
 * @return
 * @throws Throwable 
 * @throws encryptedException
 * @throws FileNotFoundException
 * @throws IOException
 * 
 * 
 * 
 */
	public String readDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws Throwable {
	Workbook wb = WorkbookFactory.create(new FileInputStream(Ipathconstants.excelFilePath));
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNo);
		Cell cell=row.getCell(cellNo);
		String data=cell.getStringCellValue();
		return data;
		
	}
	/**
	 * This method is used to write data from excelSheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @
	 * @throws Throwable 
	 * @throws encryptedException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * 
	 * 
	 * 
	 */
	
	public void writeDataIntoExcel(String sheetName,int rowNo,int cellNo,String value) throws Throwable, FileNotFoundException, IOException
	{
		Workbook wb = WorkbookFactory.create(new FileInputStream(Ipathconstants.excelFilePath));
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.createRow(rowNo);
		Cell cell=row.createCell(cellNo);
		cell.setCellValue(value);
		
		FileOutputStream  fos=new FileOutputStream((Ipathconstants.excelFilePath));
		wb.write(fos);
		wb.close();
		
	}
	
	/**
	 * This method will fetch count rows created in excel sheet data from excelSheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException 
	 * @
	 * @
	 * @
	 * @throws Throwable 
	 * @throws encryptedException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * 
	 * 
	 * 
	 */

	public int getRowCount(String sheetName) throws Throwable {
		
		
		Workbook wb=WorkbookFactory.create(new FileInputStream(Ipathconstants.excelFilePath));
		Sheet sh=wb.getSheet(sheetName);
		int row =sh.getLastRowNum();
		return row;
		
	}
	/**
	 * This method is used to get multiple data from excel
	 * @param sheetName
	 * @param keyCellNo
	 * @param valueCelNo
	 * @return 
	 * @return
	 * @throws IOException
	 * @throws EncryptedDocumentException 
	 * @throws Throwable
	 * 
	 * 
	 * 
	 * 
	 */
	
	public HashMap<String, String> getMultipleDataFromExcel(String sheetName,int keyColumn,int valueColumn,WebDriver driver) throws Throwable{
		//fetching data from excel
		FileInputStream fi=new FileInputStream((Ipathconstants.excelFilePath));
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet(sheetName);
		int count =sh.getLastRowNum();
		
		HashMap<String,String>  map=new HashMap<String,String>();
		for(int i=1;i<=count;i++)
		{
			String key=sh.getRow(i).getCell(keyColumn).getStringCellValue();
			String value=sh.getRow(i).getCell(valueColumn).getStringCellValue();
			map.put(key, value);
			
			}
		
		for(Entry<String,String> s:map.entrySet())
		{
			
		driver.findElement(By.xpath(s.getKey())).sendKeys(s.getValue());
		}
		
		return map;
	}
	
	public Object[][] getMultipleSetofData(String sheetName) throws Throwable, IOException {
		{
			FileInputStream fis=new FileInputStream(Ipathconstants.excelFilePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("DataProvider");
			int lastRow=sh.getLastRowNum();
			int lastCell=sh.getRow(0).getLastCellNum();
			Object[][] obj=new Object[lastRow+1][lastCell];
			for(int i=0;i<=lastRow;i++) {
				for(int j=0;j<lastCell;j++) {
					obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				}
			}
			
			return obj;

}
		
//	public Object[][] dataprovider(String SheetName) throws Throwable{
//		FileInputStream fis=new FileInputStream(Ipathconstants.excelFilePath);
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet(SheetName);
//		int lastRow=sh.getLastRowNum();
//		int lastCell=sh.getRow(0).getLastCellNum();
//		Object[][] obj=new Object[lastRow+1][lastCell];
//		for(int i=0;i<=lastRow;i++) {
//			for(int j=0;j<lastCell;j++) {
//				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
//			}
//		}
//		
//		return obj;
//
//	}
	
	
	}
	
	
}
