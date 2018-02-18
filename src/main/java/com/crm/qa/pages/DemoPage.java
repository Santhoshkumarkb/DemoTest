package com.crm.qa.pages;


import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class DemoPage extends TestBase {

	public DemoPage() {
		PageFactory.initElements(driver, this);
		
	}
}
