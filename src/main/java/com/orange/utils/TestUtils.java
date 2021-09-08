package com.orange.utils;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.orange.testcases.TestBase;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestUtils extends TestBase implements ITestListener

{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "C:\\Users\\developer\\Desktop\\Eclipse Prgrms\\MavJava\\src\\main\\resources\\OrangeHRM TestData.xlsx";

	public static XSSFWorkbook book;
	public static XSSFSheet  sheet;
//	static Workbook book;
//	static Sheet  sheet;
	
//	To get the data from the Excel Sheet
	public static Object[][] getTestData(String sheetName)throws Exception
	{
		FileInputStream fin = new FileInputStream(new File(TESTDATA_SHEET_PATH));
		book = new XSSFWorkbook(fin);
		sheet = book.getSheet(sheetName);
		
		
		
		//FileInputStream file = null;
		
		
//		try 
//		{
//			file = new FileInputStream(TESTDATA_SHEET_PATH);
//		} 
//		catch (FileNotFoundException e) 
//		{
//			e.printStackTrace();
//		}
//		try 
//		{
//			book = WorkbookFactory.create(file);
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		} 
////		catch (IOException e) {
//			e.printStackTrace();
//		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int row = 0; row < sheet.getLastRowNum(); row++) 
		{
			for (int col = 0; col < sheet.getRow(0).getLastCellNum(); col++) 
			{
				data[row][col] = sheet.getRow(row + 1).getCell(col).toString();
				// System.out.println(data[row][col]);
			}
		}
		return data;
	}
	
	public static void get_screenshot_of_test(ITestResult result) throws IOException
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String testcaseName = result.getMethod().getMethodName();
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/"+testcaseName+"_"+ System.currentTimeMillis() + ".png"));
	

	}
	//http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=2427135
	// This Method called when test fails
	public void onTestFailure(ITestResult result) 
	{
		try {
			get_screenshot_of_test(result);
		} catch (IOException e) {
			
			e.printStackTrace();
		}		
		
	}
	
	
	
	
}
