package com.crm.qa.util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestExcel {

public static long PAGE_LOAD_TIMEOUT =30;
public static long IMPLICIT_WAIT=20;

@BeforeMethod
public void tes() {
	System.out.println("Test");
}


@Test
public void getTestData(String SheetName){

	String TEST_DATA_PATH="C:\\Users\\Lalitha\\Desktop\\PanduAutomation\\TestData.xlsx";
	FileInputStream fis = null;
	XSSFWorkbook wb;
    XSSFSheet sheet;
     
            try {
                fis = new FileInputStream(TEST_DATA_PATH);
                wb = new XSSFWorkbook(fis); 
                sheet=wb.getSheet("contatcs");
                System.out.println(sheet.getRow(2).getCell(2));
            } 
            catch (Exception e) {
                System.out.println(e.getMessage()); 
            }                   
        }  
         
	



@AfterMethod
public void tes1() {
	System.out.println("Test");
}

}
