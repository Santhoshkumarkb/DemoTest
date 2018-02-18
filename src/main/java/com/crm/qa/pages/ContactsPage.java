package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "title")
	WebElement title;

	@FindBy(name = "first_name")
	WebElement firstname;

	@FindBy(name = "surname")
	WebElement lastname;

	@FindBy(name = "email")
	WebElement email;
	@FindBy(name = "email_alt")
	WebElement emailaltr;

	public void createNewContact(String title1, String ftName, String ltName, String email1, String pass) {
		Select select = new Select(title);
		select.selectByVisibleText(title1);

		firstname.sendKeys(ftName);
		lastname.sendKeys(ltName);
		email.sendKeys(email1);
		emailaltr.sendKeys(pass);

	}
}
