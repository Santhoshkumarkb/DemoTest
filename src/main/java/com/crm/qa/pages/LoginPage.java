package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

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
		password.sendKeys(pass);
		login.submit();
		return new HomePage();
		
	}
}
