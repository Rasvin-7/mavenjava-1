package com.orange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase
{
	public By username_field = By.id("txtUsername");
	public By passwd_field = By.id("txtPassword");
	public By login_btn = By.id("btnLogin");


	public LoginPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	public HomePage login(String username,String password)
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterField(username_field, username);
		lp.enterField(passwd_field, password);
		lp.clickOn(login_btn);
		
		// Creating and Return the HomePage Object since after logging in landing on home page.
		HomePage hp_obj = new HomePage(driver);
		return hp_obj;
		
		
	}
	
}
