package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility{
	
	private static final By USERNAME_TEXTBOX_LOCATOR=By.xpath("//input[@id='email']");
	private static final By PASSWORD_TEXTBOX_LOCATOR=By.id("passwd");
	private static final By LOGIN_BUTTON_LOCATOR=By.xpath("//button[@id='SubmitLogin']");

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	public MyAccountPage doLoginWith(String emailAddress,String Password) {
		enterText(USERNAME_TEXTBOX_LOCATOR,emailAddress);
		enterText(PASSWORD_TEXTBOX_LOCATOR,Password);
		clickOn(LOGIN_BUTTON_LOCATOR);
		MyAccountPage myaccountPage=new MyAccountPage(getDriver());
		return myaccountPage;

	}
 
}
