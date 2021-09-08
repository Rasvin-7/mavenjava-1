package com.orange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Modules extends PageBase
{
	public Actions action;
	public Modules(WebDriver driver) 
	{
		super(driver);
		action = new Actions(driver);
	
	}
	public By admin = By.xpath("//b[contains(text(),'Admin')]");
	public By user_mgmnt = By.xpath("//a[@id='menu_admin_UserManagement']");
	public By users = By.xpath("//a[@id='menu_admin_viewSystemUsers']");
	
	public void admin_menu(String menu)
	{
		if(menu == "admin")
		{
			action.moveToElement(driver.findElement(admin)).click().perform();
			
		}else if (menu.equalsIgnoreCase("user_management")) {
			action.moveToElement(driver.findElement(admin)).moveToElement(driver.findElement(user_mgmnt)).click().perform();
			
		}else if(menu.equalsIgnoreCase("users")) {
			action.moveToElement(driver.findElement(admin)).moveToElement(driver.findElement(user_mgmnt)).click().perform();
			action.moveToElement(driver.findElement(users)).click().perform();
			
		}
		
	}
	
	
	
	
}
