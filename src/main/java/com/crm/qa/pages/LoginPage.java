package com.crm.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
static Logger log=Logger.getLogger(LoginPage.class);

	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	// PageFactory

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement login;
	
	public String  validateLoginpageTitle() {
		return driver.getTitle();

	}
	
	public HomePage login(String un,String pass) {
		username.sendKeys(un);
		log.info("username is sent ");
		password.sendKeys(pass);
		log.info("password is sent ");
		login.submit();
		log.info("submitt button is clicked ");
		return new HomePage();
		
	}
}
