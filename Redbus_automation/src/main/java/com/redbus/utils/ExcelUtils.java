package com.redbus.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Object[][] getData() throws Exception {

        // Excel file location
        String path =
                "C:\\Users\\heman\\OneDrive\\Desktop\\application_Data\\Applicationdetails.xlsx";

        // Open Excel
        FileInputStream file =
                new FileInputStream(path);

        // Open workbook
        XSSFWorkbook workbook =
                new XSSFWorkbook(file);

        // Open Sheet1
        XSSFSheet sheet =
                workbook.getSheet("Sheet1");

        // Number of rows
        int rows =
                sheet.getPhysicalNumberOfRows();

        // Number of columns
        int columns =
                sheet.getRow(0).getPhysicalNumberOfCells();

        System.out.println("Rows: " + rows);
        System.out.println("Columns: " + columns);

        // Create array
        Object[][] data =
                new Object[rows - 1][columns];

        // Read Excel
        for (int i = 1; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                data[i - 1][j] =
                        sheet.getRow(i)
                             .getCell(j)
                             .getStringCellValue();
            }
        }

        workbook.close();
        file.close();

        return data;
    }
}