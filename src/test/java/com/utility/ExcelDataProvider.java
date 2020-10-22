package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ExcelDataProvider {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	
	public ExcelDataProvider(){
		
		File src=new File("./testdata/Registration.xlsx");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			
			System.out.println("Unable to read the excel" +e.getMessage());
		} 
	}
	
	public String getStringData(String sheetName,int row,int col){
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	
	public String getStringData(int index,int row,int col){
		return wb.getSheetAt(index).getRow(row).getCell(col).getStringCellValue();
	}
	
	public double getNumericData(String sheetName,int row,int col){
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
	
	/*public int getRowCount(String sheetName){
		return wb.getSheet(sheetName).getLastRowNum();
	}
	
	public int getColCount(String sheetName, int row){
		return wb.getSheet(sheetName).getRow(row).getLastCellNum();
	}*/
	

}
