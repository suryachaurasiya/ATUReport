package com.easypolicy.generic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.easypolicy.generic.ExtentManager;
import com.easypolicy.generic.UIMap;

public class LocatorHandler {
	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	public UIMap uimap;
	public UIMap datafile;
	public String workingDir;
	
	@BeforeClass(alwaysRun = true)
	public void suiteSetUp() {

		try {
			
			// Get current working directory and load the data file
			workingDir = System.getProperty("user.dir");
			datafile = new UIMap(workingDir + "\\datafile.properties");

			// Get the object map file
			uimap = new UIMap(workingDir + "\\locator.properties");
			extent = ExtentManager.GetExtent();

		} catch (Exception e) {
			throw new IllegalStateException("Can't start the Firefox Web Driver", e);
		}

	}

	@AfterClass
	public void suiteTearDown() throws Exception {
		
		extent.flush();
		// driver.close();
		// driver.quit();
		// endreport();
		SendMailSSL.execute("health-report.html");
		
	}
}
