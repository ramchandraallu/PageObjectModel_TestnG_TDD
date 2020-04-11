package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	static Workbook book;
	static Sheet sheet;
	public static long PAGE_LOAD_TIMEOUT =30;
	public static long IMPLICIT_WAIT=20;
	public static String TEST_DATA_PATH="C:\\Users\\Lalitha\\Desktop\\PanduAutomation\\";
	public static List<HashMap<String,String>> datamap=new ArrayList<HashMap<String,String>>();
	public static HashMap<String,String> datahash= new HashMap<String,String>();
	
    
    
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static XSSFSheet GetSheet(String sheetName) {
		 FileInputStream fis = null;
		 XSSFWorkbook wb = null;
	     XSSFSheet sheet;
	     try {
			fis = new FileInputStream(TEST_DATA_PATH+"TestData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
         sheet=wb.getSheet(sheetName);
         return sheet;
	}
	
	public static List<HashMap<String,String>> getTestDataListHash(String SheetName){
	     		XSSFSheet sheet;
		 
	            try {
	            	sheet=GetSheet(SheetName);
	                System.out.println(sheet.getRow(1).getCell(1));
	                int irow = sheet.getPhysicalNumberOfRows();
	                for(int i=0;i<irow;i++) {
	                	int jcol=sheet.getRow(i).getPhysicalNumberOfCells();
	                	for(int j=0;j<jcol;j++) {
	                		datahash.put(sheet.getRow(0).getCell(j).toString(),sheet.getRow(i).getCell(j).toString());
	                	
	                	}
	                	datamap.add(datahash);
	                	
	                }
	                
	            } 
	            catch (Exception e) {
	                System.out.println(e.getMessage()); 
	            }
	            System.out.println(datamap);
				return datamap;                   
	        }  
	
	public Object[][] getDataObject(String sheetname){
		XSSFSheet sheet;
        	sheet=GetSheet(sheetname);

        	
        	Object [][] data = new Object[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getLastCellNum()];
            
        	int irow = sheet.getPhysicalNumberOfRows();
            for(int i=1;i<irow;i++) {
            	int jcol=sheet.getRow(i).getPhysicalNumberOfCells();
            	for(int j=0;j<jcol;j++) {
            		
            		
            		//datahash.put(sheet.getRow(0).getCell(j).toString(),sheet.getRow(i).getCell(j).toString());
            		data[i][j]=sheet.getRow(i).getCell(j).toString();
            		System.out.println(data[i][j]);
            	}
            }         	
		
        return data;
		
	}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	

}