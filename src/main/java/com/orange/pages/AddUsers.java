package com.orange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddUsers extends PageBase 
{

	public AddUsers(WebDriver driver) 
	{
		super(driver);
	}
	
	public By userRole = By.xpath("//select[@id='systemUser_userType']");
	public By empName  = By.xpath("//input[@id='systemUser_employeeName_empName']");
	public By userName = By.xpath("//input[@id='systemUser_userName']");
	public By status = By.xpath("//select[@id='systemUser_status']");
	public By pswd = By.xpath("//input[@id='systemUser_password']");
	public By cpswd = By.xpath("//input[@id='systemUser_confirmPassword']");
	
	public WebElement user_role,emp_name,user_name,user_status,passwd,cfmPassed;
	
	public void addUsers(String role, String emp, String user, String stat,String pwd,String cpwd)
	{
		dropDownSelect(userRole, role);
		enterField(empName, emp);
		enterField(userName, user);
		dropDownSelect(status, stat);
		enterField(pswd, pwd);
		enterField(cpswd, cpwd);
		
	}
	

}
