package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		
		BrowserUtility  browserUtility= new BrowserUtility(driver);	
		browserUtility.goToWebSite("http://www.automationpractice.pl/index.php?");
		
		browserUtility.maximizeWindow();
		
		By singInLocator=By.xpath("//a[contains(text(),'Sign in')]");
		browserUtility.clickOn(singInLocator);
		
		By userNameLocator=By.xpath("//input[@id='email']");
		browserUtility.enterText(userNameLocator,"gopas18827@iridales.com");
		
		
		By userPasswordLocator=By.id("passwd");
		browserUtility.enterText(userPasswordLocator,"gopas18827@iridales.com ");
		
		By userLoginLocator=By.xpath("//button[@id='SubmitLogin']");
		browserUtility.clickOn(singInLocator);

	
	}

}
