package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		;

	}

	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else {
			System.err.println("Invalid browser selected...!");
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadLess) {
		if (browserName == Browser.CHROME) {
			if (isHeadLess) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--headless=new"); // open browser in headless mode
				option.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(option));
			} else {
				driver.set(new ChromeDriver());

			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadLess) {
				EdgeOptions option = new EdgeOptions();
				option.addArguments("--headless=old"); // open browser in headless mode
				option.addArguments("disable-gpu");
				driver.set(new EdgeDriver(option));
			} else {
				driver.set(new EdgeDriver());

			}

			
		} else if (browserName == Browser.FIREFOX) {
			
			if (isHeadLess) {
				FirefoxOptions option = new FirefoxOptions();
				option.addArguments("--headless=old"); // open browser in headless mode
				option.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(option));
			} else {
				driver.set(new FirefoxDriver());

			}
			
		}
	}

	public void goToWebSite(String url) {
		driver.get().get(url);
	}

	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		WebElement element = driver.get().findElement(locator);
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(textToEnter);
	}

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();

	}

	public String takeScreenShot(String name) {
		TakesScreenshot ts = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = System.getProperty("user.dir") + "//screenshots//" + name + " - " + timeStamp + ".png";
		File outPutScreenShot = ts.getScreenshotAs(OutputType.FILE);
		File screenShot = new File(path);

		try {
			FileUtils.copyFile(outPutScreenShot, screenShot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
