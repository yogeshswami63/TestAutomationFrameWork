package com.ui.tests;

import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pojo.User;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;


@Listeners({com.ui.listeners.TestListeners.class})

public class LoginTest3 extends TestBase{

	
    Logger logger=LoggerUtility.getLogger(this.getClass());
	
	// HomePage homePage = new HomePage("chrome");
	@Test(description = "Verifies login functionality with vaid credentias", groups = { "e2e", "sanity" },
			dataProviderClass=com.ui.dataProvider.LoginDataProvider.class,dataProvider="LoginTestDataProvider" )
	public void loginTest(User user){
	

		String userName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName();
		Assert.assertEquals(userName, "Yogesh Test");
	}
	

	@Test(description = "Verifies login functionality with vaid credentias", groups = { "e2e", "sanity" },
			dataProviderClass=com.ui.dataProvider.LoginDataProvider.class,dataProvider="loginCSVDataProvider" )
	
	public void loginTestCSVData(User user){
		

		String userName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName();
		Assert.assertEquals(userName, "Yogesh Test");
	}

	@Test(description = "Verifies login functionality with vaid credentias", groups = { "e2e", "sanity" },
			dataProviderClass=com.ui.dataProvider.LoginDataProvider.class,dataProvider="loginExcelDataProvider", retryAnalyzer=com.ui.listeners.MyRetryAnalyzer.class )
	
	public void loginTestExcelData(User user){
		
		String userName = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName();
		Assert.assertEquals(userName, "Yogesh Tes");
		
	}	
	
}
