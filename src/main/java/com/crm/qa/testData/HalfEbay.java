package com.crm.qa.testData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.utility.TestUtil;

public class HalfEbay {

	WebDriver driver;
	String baseURL;
	
	@BeforeMethod
	public void setUp() {
	System.setProperty("webdriver.chrome.driver", "F:\\softwares\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	baseURL="https://reg.ebay.in/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.in%2F";
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.get(baseURL);
	}
	
	@DataProvider
	public Iterator<Object[]> getdata() {
	ArrayList<Object[]> testdata=	TestUtil.getTestdata();
	return testdata.iterator();
	}
	@Test(dataProvider="getdata")
	public void halfebay(String firstname,String lastname, String email,String password) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("PASSWORD")).clear();
		driver.findElement(By.name("PASSWORD")).sendKeys(password);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
