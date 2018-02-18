package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void switchFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	@FindBy(xpath="//div[@id='navmenu']//a[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath="//div[@id='navmenu']//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	public ContactsPage clickOnContacts() {
		contacts.click();
		return new ContactsPage();
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public void ClickOnNewContact() throws InterruptedException {
		Actions action=new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(contacts).build().perform();
		Thread.sleep(2000);
		newContact.click();
		
	}
	
}
