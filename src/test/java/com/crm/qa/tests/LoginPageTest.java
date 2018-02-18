package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void SetUp() {
		initialization();
	 loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void TitleTest() {
		String title = loginpage.validateLoginpageTitle();
		Assert.assertEquals(title,"#1 Free CRM for Any Business: Online Customer Relationship Software" );
	}
	
	@Test(priority=2)
	public void login() {
		homePage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
