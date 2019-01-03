package com.easypolicy.customerpopup;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.easypolicy.generic.ExtentManager;
import com.easypolicy.generic.UIMap;


public class CustomerPopup {
	ExtentHtmlReporter htmlReporter;
	Map<String, Object[]> TestNGResults;
	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	public UIMap uimap;
	public UIMap datafile;
	public String workingDir;
	
	public void customerPopup() {

		try {
			test = extent.createTest("Fill Name in Customer Popup", "Name Should be entered");
			driver.findElement(uimap.getLocator("Customer_Name")).sendKeys(datafile.getData("Customername"));
			if (datafile.getData("Customername").equals("Vijay Kumar")) {
				test.pass(datafile.getData("Customername") + " contain " + "Vijay");
			} else
				test.log(Status.FAIL, datafile.getData("Customername") + " Input Is InCorrect");
			
			
			
			test = extent.createTest("Fill Email in Customer Popup", "Email Should be entered");
			driver.findElement(uimap.getLocator("Customer_Email")).sendKeys(datafile.getData("CustomerEmailId"));
			if (datafile.getData("CustomerEmailId").equals("vijay.kumar@ep.com")) {
				test.pass(datafile.getData("CustomerEmailId") + " contain " + "binny");
			} else
				test.log(Status.FAIL, datafile.getData("CustomerEmailId") + " Input Is InCorrect");
			
			
			
			test = extent.createTest("Fill mobile no in customer popup","Mobile no shoud be enter");
			driver.findElement(uimap.getLocator("Customer_Number")).sendKeys(datafile.getData("CustomerMobileNo"));
			if (driver.getTitle().contains("Claim Support")) {
				test.pass(driver.getTitle() + " contain " + "Claim Support");

			} else
				test.log(Status.FAIL, driver.getTitle() + "doesn't contain " + "Claim Support");
		
			
			
			test = extent.createTest("Click on proceed button","Button Should be clicked and quotes page should be displayed");
			driver.findElement(uimap.getLocator("Click_Proceed_Button")).click();
			if (driver.getTitle().contains("Claim Support")) {
				test.pass(driver.getTitle() + " contain " + "Claim Support");

			} else
				test.log(Status.FAIL, driver.getTitle() + "doesn't contain " + "Claim Support");
			
			
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			
		}
	}
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
}

