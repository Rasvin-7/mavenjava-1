package com.orange.testcases;


import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase 
{
	public static WebDriver driver;
	public  static Properties prop;
	public static FileInputStream fin;
//	 private static String propertyFilePath = "C:\\Users\\developer\\Desktop\\Eclipse Prgrms\\MavJava\\src\\main\\resources\\configuration.propertie";
	
	public TestBase()
	{
		
		try 
		{
			prop = new Properties();
			FileInputStream fin = new FileInputStream("C:\\Users\\developer\\Desktop\\Eclipse Prgrms\\MavJava\\src\\main\\java\\com"+"\\orange\\config\\config.properties");
			prop.load(fin);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	 public static void initialize_driver()
	{
		 String chrome_path = "C:\\Users\\developer\\Desktop\\CMT\\WebDrivers\\chromedriver.exe";        
		 String fox_path = "C:\\Users\\developer\\Desktop\\CMT\\WebDrivers\\geckodriver.exe";
		 
		 String browser = prop.getProperty("browser");
		 String url = prop.getProperty("url");
//		 System.setProperty("webdriver.chrome.driver",chrome_path);
//		 driver = new ChromeDriver();
//		 driver.get(prop.getProperty("url"));
		 
		 if(browser.equalsIgnoreCase("chrome"))
		 {
			 System.setProperty("webdriver.chrome.driver",chrome_path);
			 driver = new ChromeDriver();
//			 driver.get(prop.getProperty("url"));
		 }
		 else if(browser.equalsIgnoreCase("firefox"))
		 {
			 System.setProperty("webdriver.chrome.driver",fox_path);
			 driver = new FirefoxDriver();
//			 driver.get(prop.getProperty("url"));
		 }
		 
        
		 driver.get(url);
//       driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}
	
        
}
	
		
	


