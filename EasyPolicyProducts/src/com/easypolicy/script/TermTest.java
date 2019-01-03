package com.easypolicy.script;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.easypolicy.customerpopup.CustomerPopup;
import com.easypolicy.generic.BaseLib;
import com.easypolicy.generic.UIMap;

public class TermTest extends BaseLib {
	public static WebDriver driver;
	public UIMap uimap;
	public UIMap datafile;
	public UIMap locator;
	public String workingDir;
	public static ExtentReports extent;
	public static ExtentTest test;
	ExtentHtmlReporter htmlReporter;
	
	
	@Test(description="Click on Term product link and fill the details")
	public void termProductJourney(){
		try {
			test = extent.createTest("Click on Term Link on top bar", "Term product page should be open with form");
			driver.findElement(uimap.getLocator("term_product")).click();
			Thread.sleep(1000);
			if (driver.getTitle().contains("Term Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Term Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Term Insurance");
			
			
			test = extent.createTest("Select member gender", "Value in numbers");
			driver.findElement(uimap.getLocator("term_gender")).click();
			Thread.sleep(1000);
			if (uimap.getLocator("term_gender").equals("Male")) {
				test.pass(uimap.getLocator("term_gender") + " equal " + "Male");
			} else
				test.log(Status.FAIL, uimap.getLocator("term_gender") + " doesn't equal " + "Male");
			
			
			test = extent.createTest("Select member gender", "Value in numbers");
			WebElement gender1 = driver.findElement(uimap.getLocator("term_tobacco"));
			gender1.click();
			Thread.sleep(1000);
			if (uimap.getLocator("term_tobacco").equals("No")) {
				test.pass(uimap.getLocator("term_tobacco") + " equal " + "No");
			} else
				test.log(Status.FAIL, uimap.getLocator("term_tobacco") + " doesn't equal " + "Male");
			
			
			test = extent.createTest("Input Annual Income", "Value in numbers");
			WebElement annualincome = driver.findElement(uimap.getLocator("annual_income"));
			annualincome.click();
			annualincome.sendKeys(datafile.getData("annual_income_term"));
			WebElement annualincomeselect = driver.findElement(uimap.getLocator("annual_income_select"));
			annualincomeselect.click();
			Thread.sleep(1000);
			if (datafile.getData("annual_income_term").equals("40")) {
				test.pass(datafile.getData("annual_income_term") + " equal " + "40");
			} else
				test.log(Status.FAIL, datafile.getData("annual_income_term") + " doesn't equal " + "40");
			
			
			test = extent.createTest("Enter value for DOB", "Value in numbers");
			WebElement DOBdate = driver.findElement(uimap.getLocator("term_dob_field_DD"));
			DOBdate.clear();
			DOBdate.sendKeys(datafile.getData("term_DOBD"));
			Thread.sleep(1000);

			WebElement DOBmonth = driver.findElement(uimap.getLocator("term_dob_field_MM"));
			DOBmonth.clear();
			DOBmonth.sendKeys(datafile.getData("term_DOBM"));
			Thread.sleep(1000);

			WebElement DOByear = driver.findElement(uimap.getLocator("term_dob_field_YYYY"));
			DOByear.clear();
			DOByear.sendKeys(datafile.getData("term_DOBY"));
			Thread.sleep(1000);
			Assert.assertEquals("1986", datafile.getData("term_DOBY"));
			if (driver.getTitle().contains("Health Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Health Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");
			
			
			WebElement city = driver.findElement(uimap.getLocator("term_city"));
			city.click();
			Thread.sleep(1000);
			city.sendKeys(datafile.getData("term_city"));
			WebElement cityclick = driver.findElement(uimap.getLocator("Click_city"));
			cityclick.click();
			test = extent.createTest("Select City From the List", "select by enter text");

			if (datafile.getData("term_city").equals("New Delhi, Delhi")) {
				test.pass(datafile.getData("term_city") + " equal " + "New Delhi, Delhi");
			} else
				test.log(Status.FAIL, datafile.getData("term_city") + " doesn't equal " + "New Delhi, Delhi");
			
			
			WebElement buttonlivequote = driver.findElement(uimap.getLocator("Get_live_quotes"));
			buttonlivequote.click();
			Thread.sleep(1000);
			test = extent.createTest("Click get live quotes button", "Value in numbers");

			if (driver.getTitle().contains("Easypolicy")) {
				test.pass(driver.getTitle() + " contain " + "Easypolicy");
			} else
				test.log(Status.FAIL, driver.getTitle() + " contain " + "Health Insurance");
			
			
			test = extent.createTest("Fill Name in Customer Popup", "Name Should be entered");
			WebElement Custname = driver.findElement(uimap.getLocator("Customer_Name"));
			Custname.sendKeys(datafile.getData("Customername"));
			// String title = driver.getTitle();
			Assert.assertEquals("Vijay Kumar", datafile.getData("Customername"));
			if (datafile.getData("Customername").equals("Vijay Kumar")) {
				test.pass(datafile.getData("Customername") + " contain " + "Vijay");
			} else
				test.log(Status.FAIL, datafile.getData("Customername") + " Input Is InCorrect");
			
			
			test = extent.createTest("Fill Email in Customer Popup", "Email Should be entered");
			WebElement Custemail = driver.findElement(uimap.getLocator("Customer_Email"));
			Custemail.sendKeys(datafile.getData("CustomerEmailId"));
			// String title = driver.getTitle();
			Assert.assertEquals("vijay.kumar@ep.com", datafile.getData("CustomerEmailId"));
			if (datafile.getData("CustomerEmailId").equals("vijay.kumar@ep.com")) {
				test.pass(datafile.getData("CustomerEmailId") + " contain " + "binny");
			} else
				test.log(Status.FAIL, datafile.getData("CustomerEmailId") + " Input Is InCorrect");
			
			
			test = extent.createTest("Fill Mobile No in Customer Popup", "Mobile No Should be entered");
			WebElement CustMobNo = driver.findElement(uimap.getLocator("Customer_Number"));
			CustMobNo.sendKeys(datafile.getData("CustomerMobileNo"));
			// String title = driver.getTitle();
			Assert.assertEquals("6789678967", datafile.getData("CustomerMobileNo"));
			if (datafile.getData("CustomerMobileNo").equals("6789678967")) {
				test.pass(datafile.getData("CustomerMobileNo") + " contain " + "6789678967");
			} else
				test.log(Status.FAIL, datafile.getData("CustomerMobileNo") + " Input Is InCorrect");
			
			
			test = extent.createTest("Click on proceed button",
					"Button Should be clicked and quotes page should be displayed");
			WebElement CustMobNo1 = driver.findElement(uimap.getLocator("Click_Proceed_Button"));
			CustMobNo1.click();
			if (driver.getTitle().contains("Claim Support")) {
				test.pass(driver.getTitle() + " contain " + "Claim Support");

			} else
				test.log(Status.FAIL, driver.getTitle() + "doesn't contain " + "Claim Support");
			
			
			String urlquotes = driver.getCurrentUrl();
			System.out.println(urlquotes);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			List<WebElement> buyNowElement = driver.findElements(By.xpath("//span[contains(text(),'BUY NOW')]"));
			String winScroll = "window.scrollBy(0,300)";
			RemoteWebDriver rwd = (RemoteWebDriver) driver;
			for (int i = 1; i <= buyNowElement.size()-8; i++) {
				Thread.sleep(10000);
				driver.findElement(By.xpath("(//span[contains(text(),'BUY NOW')])[" + i + "]")).click();
				
				Thread.sleep(10000);
				String url = driver.getCurrentUrl();
				System.out.println(url);
				Thread.sleep(5000);
				driver.navigate().to(urlquotes);
				Thread.sleep(5000);
				CustomerPopup cpp=new CustomerPopup();
				cpp.customerPopup();
				for (int j = 0; j < 1; j++) {
					Thread.sleep(1000);
					rwd.executeScript(winScroll);
				} 
			}
		}   catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}

	}
}
