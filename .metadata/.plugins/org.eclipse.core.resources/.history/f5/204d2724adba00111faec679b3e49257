package com.redbus.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils2 {
	
	public static Object[][] getData() throws Exception {
		
		 // Excel file location
        String path =
                "C:\\Users\\heman\\OneDrive\\Desktop\\application_Data\\Applicationdetails.xlsx";
        
      FileInputStream fi =  new FileInputStream(path);
      XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		int colms = sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data = new Object[rows-1][colms];
		
		for (int i=1;i<rows;i++) {
			for (int j=0;j<colms;j++) {
				data[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
			
//			data[0][0] → ZARA COAT 3
//			data[0][1] → email1
//			data[0][2] → password1
			
//			data[1][0] = iphone 13 pro
//			data[1][1] = email2
//			data[1][2] = password2
		}
		workbook.close();
		fi.close();
		
		return data;
		
		
		
	}
	
}
