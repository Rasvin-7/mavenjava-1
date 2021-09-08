package com.orange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase
{
	public HomePage(WebDriver driver) 
	{
		super(driver);
		
	}

//	@FindBy(xpath = "//a[@id='welcome']")
//	WebElement welcome_user;
	public By welcome_user = By.xpath("//a[@id='welcome']");
	
	public boolean check_WelcomeUser()
	{
		boolean check = checkElement(welcome_user);
		return check;
	}

}
