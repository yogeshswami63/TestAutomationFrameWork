package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

/*
 * public class TestBase {
 * 
 * 
 * protected HomePage homePage; Logger
 * logger=LoggerUtility.getLogger(this.getClass());
 * 
 * @BeforeMethod(description = "Load home page of website") public void setUp()
 * { homePage = new HomePage(Browser.CHROME,true); }
 * 
 * public BrowserUtility getInstance() { return homePage; } }
 */

public class TestBase {
    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
   // private boolean isLambdaTest = true;
  // private boolean isHeadless;
    private boolean isLambdaTest;
    @Parameters({"browser","isLambdaTest","isHeadless"})
    @BeforeMethod(description = "Load the Homepage of the website")
    public void setup(
    		
    		@Optional("chrome") String browser,
    		@Optional("false") boolean isLambdaTest,
    		@Optional("chrome") boolean IsHeadless,ITestResult result) {
       
    	this.isLambdaTest=isLambdaTest;
    	WebDriver lambdaDriver;
       
        if (isLambdaTest) {
            lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);
        } else {
            // Running the test on local machine!!!
            logger.info("Load the Homepage of the website");
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), IsHeadless);
        }
    }

    public BrowserUtility getInstance() {
        return homePage;
    }

    @AfterMethod(description = "Tear Down the browser")
    public void tearDown() {
        if (isLambdaTest) {
            LambdaTestUtility.quitSession(); // quit Lambda session
        } else {
            homePage.quit(); // local
        }
    }
}
