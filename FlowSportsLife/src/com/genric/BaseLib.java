package com.genric;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseLib {
	// final driver
	public WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;

	@BeforeMethod
	@Parameters(value = "browser")
	public void preCondition(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			Reporter.log("Firefox launched", true);
		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\exefiles\\chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("Chrome launched", true);
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", ".\\exefiles\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			Reporter.log("IE launched", true);
		}
		driver.manage().window().maximize();
		driver.get(GetPropertyValues.getPropertyValue("testURL1"));
		Reporter.log("Navigating to the test URL");
	}

	@AfterMethod
	public void postCondition(ITestResult result) throws Exception {
		if (result.isSuccess()) {
			Reporter.log("Script is pass", true);
		} else {
			Reporter.log("Script failed", true);
			String fileName = result.getMethod().getMethodName();
			ScreenshotLib sLib = new ScreenshotLib();
			sLib.getScreenshot(driver, fileName);
			Reporter.log("Screenschot has been taken", true);
		}
		
		Thread.sleep(15000);
		driver.close();
		Reporter.log("Browser closed", true);
	}

}
