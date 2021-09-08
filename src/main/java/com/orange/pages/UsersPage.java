package com.orange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsersPage extends PageBase
{

	public UsersPage(WebDriver driver) 
	{
		super(driver);
	}
	public By add_users_btn = By.id("btnAdd");
	
	public  AddUsers click_AddUsers()
	{
		AddUsers au_object = new AddUsers(driver);
				
		clickOn(add_users_btn);
		
		return au_object;
		
	
	}

}
