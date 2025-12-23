package com.ecommerce.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.ecommerce.base.TestBase;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") 
            + "/src/main/resources/testdata/TutorialsNinjaTestData.xlsx";

    static Workbook book;
    static Sheet sheet;

    // This method returns a 2D Object Array (rows x columns) which TestNG expects
    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            // WorkbookFactory handles both .xls and .xlsx automatically
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);
        
        // Create a 2D array based on the number of rows and columns in the sheet
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        // Loop through rows and columns to fill the array
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                // We use (i+1) to skip the Header row (Row 0)
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
            }
        }
        return data;
    }
}