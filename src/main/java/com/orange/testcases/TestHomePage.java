package com.orange.testcases;

import java.net.SocketException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orange.pages.AddUsers;
import com.orange.pages.HomePage;
import com.orange.pages.LoginPage;
import com.orange.pages.Modules;
import com.orange.pages.UsersPage;
import com.orange.utils.TestUtils;

@Listeners(TestUtils.class)
public class TestHomePage extends TestBase
{
	public String user = prop.getProperty("login_username");
	public String pwd = prop.getProperty("login_passwd");
	public LoginPage object_LP;
	public HomePage HP_obj;
	public Modules Mod_obj;
	
	@BeforeMethod
	public void setUp()throws SocketException
	{
		System.out.println("Starting");
		initialize_driver();
		object_LP = new LoginPage(driver);
		HP_obj = object_LP.login(user,pwd); 

		
	}
	@Test(enabled =false)
	public void testLogin()
	{
		System.out.println("Test\n");
		
	}
	@Test
	public void testUsers()
	{
		Mod_obj = new Modules(driver);
		System.out.println("To Users\n");
		Mod_obj.admin_menu("users");
		
	}
	@DataProvider
	public Object[][] getAddUsers()throws Exception
	{
		Object[][] data= TestUtils.getTestData("AddUsers");
		return data;
	}
	
	@Test(dataProvider = "getAddUsers")
	public void add_users(String role, String emp, String user, String status,String pwd,String cpwd) throws InterruptedException
	{
		Mod_obj = new Modules(driver);
		Mod_obj.admin_menu("users");
		
		UsersPage usersPage = new UsersPage(driver);
		Thread.sleep(2000);
		AddUsers au = usersPage.click_AddUsers();
		Thread.sleep(2000);
		au.addUsers(role, emp, user, status, pwd, cpwd);
		Thread.sleep(2000);
		
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
}
