package com.crm.qa.tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class ContactsPageTest extends TestBase{
LoginPage loginPage;
HomePage homePage;
ContactsPage contactsPage;
TestUtil testUtil;

	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.switchFrame();
		//contactsPage=homePage.clickOnContacts();
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
	ArrayList<Object[]> data=TestUtil.getTestdata();
			return data.iterator();
	}
	@Test(dataProvider="getTestData")
	public void createNewContactTest(String title, String ftName, String ltName, String email,String pass) throws InterruptedException {
		homePage.ClickOnNewContact();
		Thread.sleep(2000);
		contactsPage.createNewContact(title, ftName, ltName, email, pass);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
