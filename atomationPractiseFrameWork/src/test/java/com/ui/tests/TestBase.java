package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class TestBase {

	
	protected HomePage homePage;
    Logger logger=LoggerUtility.getLogger(this.getClass());
    
	@BeforeMethod(description = "Load home page of website")
	public void setUp() {
		homePage = new HomePage(Browser.CHROME,true);
	}
	
	public  BrowserUtility getInstance() {
		return homePage;
	}
}
