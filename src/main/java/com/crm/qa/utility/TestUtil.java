package com.crm.qa.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class TestUtil extends  TestBase {

	public static long page_load_timeout = 30;
	public static long implicit_wait = 10;
	public static Xls_Reader reader;
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
}
	public static ArrayList<Object[]> getTestdata() {
		ArrayList<Object[]> mydata= new ArrayList<Object[]>();
		try {
		reader = new Xls_Reader("C:\\Users\\santhu\\BDDSelenium\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testData\\regTestData.xlsx");
		}catch (Exception e) {
			// TODO: handle exception
		}
		for (int rowcnt = 2; rowcnt <= reader.getRowCount("regTestData"); rowcnt++) {
			String title= reader.getCellData("regTestData", "title", rowcnt);
			String firstname= reader.getCellData("regTestData", "firstname", rowcnt);
			String lastname= reader.getCellData("regTestData", "lastname", rowcnt);
			String email= reader.getCellData("regTestData", "email", rowcnt);
			String password= reader.getCellData("regTestData", "password", rowcnt);
			
			Object ob[]= {title,firstname,lastname,email,password};
			mydata.add(ob);
		}
		return mydata;
		}
}
