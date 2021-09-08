package com.orange.testcases;

import java.net.SocketException;

import org.testng.Assert;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orange.pages.HomePage;
import com.orange.pages.LoginPage;
import com.orange.utils.TestUtils;

@Listeners(TestUtils.class)
public class TestLoginPage extends TestBase
{
	
	@BeforeMethod
	public void setUp()throws SocketException 
	{
		System.out.println("Starting");
		initialize_driver();
		
	}
	
	@Test(priority = 1)
	public void testLogin()
	{
		System.out.println("Login Test\n");
		LoginPage object_LP = new LoginPage(driver);
		String user = prop.getProperty("login_username");
		String pwd = prop.getProperty("login_passwd");
		HomePage HP_obj = object_LP.login(user,pwd);   // Calling log in method and returning home page object
		// checking the welcome user element present in home page to verify successful login.
		try
		{
			Assert.assertTrue(HP_obj.check_WelcomeUser());
		}
		catch(Exception e)
		{
			Assert.fail("Login Failed");
		}
//		if(HP_obj.check_WelcomeUser())
//		{
//			Assert.assertTrue(HP_obj.check_WelcomeUser());
//		}
//		else 
//		{
//			Assert.assertFalse(HP_obj.check_WelcomeUser());
//		}
//			
	}
	
	@AfterMethod
	public void tearDown() 
	{
		System.out.println("Ending");
		driver.close();
	}
}
