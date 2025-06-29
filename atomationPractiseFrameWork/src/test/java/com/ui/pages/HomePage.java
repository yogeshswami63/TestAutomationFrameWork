package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.JsonUtility;
import com.utility.LoggerUtility;
import com.utility.PropertiesUtil;

// Page Object Design pattern

public final class HomePage extends BrowserUtility{
	
	Logger logger=LoggerUtility.getLogger(this.getClass());
	/*
	 * public HomePage(Browser browserName) { super(browserName);
	 * goToWebSite(PropertiesUtil.readProperties(Env.QA, "URL"));
	 * 
	 * }
	 */
	
	public HomePage(Browser browserName,boolean isHeadLess) {
		super(browserName,isHeadLess);
		goToWebSite(JsonUtility.readJson(Env.QA).getUrl());
		
	}

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebSite(PropertiesUtil.readProperties(Env.QA, "URL"));
	}



	private static final By SIGN_IN_LINK_LOCATOR=By.xpath("//a[contains(text(),'Sign in')]");
	
	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage=new LoginPage(getDriver());
		return loginPage;
	}

	
	public void quit() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }


}
