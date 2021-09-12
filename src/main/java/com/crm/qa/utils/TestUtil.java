package com.crm.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT_TIMEOUT = 10;
	public static String TEST_SHEET_PATH = System.getProperty("user.dir")+"\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMData.xlsx";

	public static Actions actionMethod() {
		Actions action = new Actions(driver);
		return action;

	}
	public static  WebDriverWait ExplicitWait() {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		return wait;
	}
	public void getData() throws Throwable {
		
		FileInputStream fis = new FileInputStream("D:\\AutomationPractice\\FreeCRMData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);


		int sheets = workbook.getNumberOfSheets();
	
		for (int l = 0; l < sheets; l++) {

			if (workbook.getSheetName(l).equalsIgnoreCase("Contacts")) 
			{
				XSSFSheet Excelsheet = workbook.getSheetAt(l);
				int rows=Excelsheet.getPhysicalNumberOfRows();
				int cols=Excelsheet.getRow(0).getPhysicalNumberOfCells();
				
				String data[][]=new String[rows][cols];
				
				XSSFCell cell;
				for(int i=1; i<rows; i++) 
				{
					for(int j=0; j<cols; j++) 
					{
						cell=Excelsheet.getRow(i).getCell(j);
						String cellcontent=cell.getStringCellValue();
						System.out.print(" " +cellcontent);
					}
					System.out.println();
				}
			}
		}
	
	}
}
