package com.orange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PageBase 
{
	public WebDriver driver;
	
	
	public PageBase(WebDriver driver)
	{
		this.driver = driver;		
	}
	
	public void enterField(By locator, String text)
	{
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
		
	}
	public void clickOn(By locator)
	{
		driver.findElement(locator).click();
		
	}
	@SuppressWarnings("deprecation")
	public boolean checkElement(By locator)
	{		
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element.isDisplayed();
		
	}
	
	public void move_to(By locator)
	{
		Actions action = new Actions(driver); 
		
		WebElement elem = driver.findElement(locator);
		action.moveToElement(elem).perform();
		//action.moveToElement(null).moveToElement(null).perform();
		//action.moveToElement(null).click().perform();
		
	}
	public void move_to_click(By locator)
	{
		Actions action = new Actions(driver); 
		
		WebElement elem = driver.findElement(locator);
		action.moveToElement(elem).click().perform();
		//action.moveToElement(elem).perform();
		//action.moveToElement(null).moveToElement(null).perform();
		
		
	}
	
	public void dropDownSelect(By locator,String text)
	{
		WebElement elem = driver.findElement(locator);
		Select select = new Select(elem);
		select.selectByVisibleText(text);
			
	}
	
	
	

}
