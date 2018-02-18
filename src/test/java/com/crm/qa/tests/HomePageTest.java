package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class HomePageTest extends TestBase {
LoginPage loginPage;
TestUtil testUtil;
HomePage homePage;
ContactsPage contactsPage;
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void Setup() {
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=3)
	public void verifyHomePageTitleTest() {
	String title=	homePage.verifyHomePageTitle();
	Assert.assertEquals(title, "CRMPRO","homePage title is not matchng");
	}
	
	@Test(priority=4)
	public void clickOnContacts() throws InterruptedException {
		homePage.switchFrame();
		
		contactsPage= homePage.clickOnContacts();
		Thread.sleep(2000);
	}
	
	@Test
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
