package com.ATUReports;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
MethodListener.class })
public class AUTreports {
{ System.setProperty("atu.reporter.config", "D:\\surya\\EasyPolicy\\atu.properties"); }

public WebDriver driver;

//@BeforeMethod
//public void setUp() throws Exception {
//driver = new FirefoxDriver();
//driver.navigate().to("https://www.easypolicy.com/");
//driver.manage().window().maximize();
// ATU Reports
//ATUReports.setWebDriver(driver);
//ATUReports.indexPageDescription = "My_EasyPolicy_Project";
//}

//@Test
//public void EasyPolicy() throws Exception, SQLException {
//
//Actions ToolTip1 = new Actions(driver);
//WebElement googleLogo = driver.findElement(By.xpath("//h2[text()=' #1 in Service']"));
//ToolTip1.clickAndHold(googleLogo).perform();
//
//String ToolTipText = googleLogo.getAttribute("header");
//Assert.assertEquals(ToolTipText,"#1 in Service");
//System.out.println("Tooltip value is: " + ToolTipText);
//}

// ATU Reports Method
//@Test
public void testNewLogs(WebElement element) throws AWTException, IOException, InterruptedException {
ATUReports.setWebDriver(driver);
ATUReports.indexPageDescription = "My_EasyPolicy_Project";
ATUReports.add("Info Step", LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
Thread.sleep(2500);
ATUReports.add("Warning Step", LogAs.WARNING,new CaptureScreen(element));
ATUReports.add("Fail step", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
}

//@AfterClass
//public void tearDown() throws Exception {
//driver.quit();
//}
}