package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel file
 * @author Nithish
 *
 */
public class ExcelUtility {
	
	/**
	 * This method will read data from excel sheet based on sheet name, row no 
	 * and cell no given by caller
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return data
	 * @throws Throwable
	 */
	public String getDataFromExcelFile(String sheetName,int rowNum,int celNum) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\testdata\\testScriptdata.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * This method will give the total row count
	 * @param sheetName
	 * @return rowNum
	 * @throws Throwable
	 */
	
	public int getRowcount(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\testdata\\testScriptdata.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		 int rowNum = wb.getSheet(sheetName).getLastRowNum();
		 wb.close();
		return rowNum;
		        
	}
	
	/**
	 * This method will write data into the excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataIntoExcel(String sheetName,int rowNum,int celNum,String data) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\testdata\\testScriptdata.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(".\\testdata\\testScriptdata.xlsx");
		wb.write(fos);
		wb.close();
}
}