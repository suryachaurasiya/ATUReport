package HealthProduct;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.health.UIMap;

import extentReport.ExtentManager;

public class CignaProposal {
	public WebDriver driver;
	public UIMap uimap;
	public UIMap datafile;
	public String workingDir;
	public String name;
	public static ExtentReports extent;
	public static ExtentTest test;
	ExtentHtmlReporter htmlReporter;
	
	// Declare An Excel Work Book
		HSSFWorkbook workbook;
		// Declare An Excel Work Sheet
		HSSFSheet sheet;
		// Declare A Map Object To Hold TestNG Results
		Map<String, Object[]> TestNGResults;

		public void CignaProposalFill(String salutation1) throws Exception {

		try {
			test = extent.createTest("Click on drop down", "Drop Down should be selected");
			test.assignCategory("Cigna Proposal");
			WebElement salutation = driver.findElement(uimap.getLocator("Salution_text"));
			salutation.sendKeys(salutation1);
			TestNGResults.put("2", new Object[] { 1d, "Click on proceed button", "Button Should be clicked and quotes page should be displayed", "Pass" });
			if (driver.getTitle().contains("Claim Support")) {
				test.pass(driver.getTitle() + " contain " + "Claim Support");	
			}
			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Claim Support");	
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("2", new Object[] { 1d, "Click on proceed button", "Button Should be clicked and quotes page should be displayed", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public String CignaProposalFillName( String name) throws Exception {

		try {
			test = extent.createTest("Fill first name in proposal page", "Fill Name");
			test.assignCategory("Cigna Proposal");
			WebElement firstname = driver.findElement(uimap.getLocator("FirstName_text_field"));
			firstname.clear();
			firstname.sendKeys(name);
			
			TestNGResults.put("3", new Object[] { 2d, "Fill first name in proposal page", "Name should be filled in the input box", "Pass" });
			if (driver.getTitle().contains("Claim Support")) {
				test.pass(driver.getTitle() + " contain " + "Claim Support");
				//test.log(Status.PASS, datafile.getData("CustomerEmailId")+" Input Is Correct");
				//test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./2.jpg"));
				//test.log(Status.INFO, test.addScreenCapture(ExtentManager.this(driver, "./Send")));
				
			}
			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Claim Support");	
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("3", new Object[] { 2d, "Fill first name in proposal page", "Name should be filled in the input box", "Fail" });
			//Assert.assertTrue(false);
		}
		return name;
		
		
	}
	public void FillLastName(String lastName) throws Exception {

		try {
			test = extent.createTest("Fill last name in proposal page", "Fill Last name");	
			test.assignCategory("Cigna Proposal");
			WebElement lastname = driver.findElement(uimap.getLocator("LastName_text_field"));
			lastname.clear();
			lastname.sendKeys(lastName);
			TestNGResults.put("4", new Object[] { 3d, "Fill last name in proposal page", "Name should be filled in the input box", "Pass" });
			if (driver.getTitle().contains("Claim Support")) {
				test.pass(driver.getTitle() + " contain " + "Claim Support");
				//test.log(Status.PASS, datafile.getData("CustomerEmailId")+" Input Is Correct");
				//test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./2.jpg"));
				//test.log(Status.INFO, test.addScreenCapture(ExtentManager.this(driver, "./Send")));
				
			}
			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Claim Support");	
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("4", new Object[] { 3d, "Fill last name in proposal page", "Name should be filled in the input box", "Fail" });
			//Assert.assertTrue(false);
		}
			
	}
	public void EmailID(String emailID) throws Exception {

		try {
			test = extent.createTest("Fill Email Id in proposal page", "Fill Email Id");	
			WebElement emailid = driver.findElement(uimap.getLocator("EmailID_text_field"));
			emailid.clear();
			emailid.sendKeys(emailID);
			TestNGResults.put("5", new Object[] { 4d, "Fill Email Id in proposal page", "Email id should be filled in the input box", "Pass" });
			if (driver.getTitle().contains("Claim Support")) {
				test.pass(driver.getTitle() + " contain " + "Claim Support");
				//test.log(Status.PASS, datafile.getData("CustomerEmailId")+" Input Is Correct");
				//test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./2.jpg"));
				//test.log(Status.INFO, test.addScreenCapture(ExtentManager.this(driver, "./Send")));
				
			}
			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Claim Support");	
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("5", new Object[] { 4d, "Fill Email Id in proposal page", "Email Id should be filled in the input box", "Fail" });
			//Assert.assertTrue(false);
		}
			
			
	}
	public void MobileNo(String mblNo) throws Exception {
		try {
			test = extent.createTest("Fill Mobile no in proposal page", "Mobile no should be filled");
			WebElement mobileno = driver.findElement(uimap.getLocator("MobileNo_Input_field"));
			mobileno.clear();
			mobileno.sendKeys(mblNo);
			TestNGResults.put("6", new Object[] { 5d, "Fill Mobile no in proposal page", "Mobile no should be filled", "Pass" });
			
			if (datafile.getData("Proposer_mobileno").equals("testing, newdelhi")) {
				test.pass(datafile.getData("Proposer_mobileno") + " is " + "correct");
			} else
				test.log(Status.FAIL, datafile.getData("Proposer_mobileno") + " is not " + "correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("6", new Object[] { 5d, "Fill Mobile no in proposal page", "Mobile no should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void Profession(String profsn) throws Exception {

		try {
			test = extent.createTest("Select & fill Profession", "Profession should be selected");
			WebElement profession = driver.findElement(uimap.getLocator("Profession_DropDown_field"));
			Thread.sleep(5000);
			String professionField="Student";
			profession.sendKeys(professionField);
			TestNGResults.put("7", new Object[] { 6d, "Select & fill Profession", "Profession should be selected", "Pass" });
			
			if (datafile.getData("Profession_DropDown_select").equals("Private Service")) {
				test.pass(datafile.getData("Profession_DropDown_select") + " is " + "correct");
			} else
				test.log(Status.FAIL, datafile.getData("Profession_DropDown_select") + " is not " + "correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("7", new Object[] { 6d, "Select & fill Profession", "Profession should be selected", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void MaritalStatus(String maritalStatus) throws Exception {

		try {
			test = extent.createTest("Select marital status from drop down", "Marital status should be selected");
			WebElement maritalstatus = driver.findElement(uimap.getLocator("MaritalStatus_Dropdown_field"));
			maritalstatus.sendKeys(maritalStatus);
			TestNGResults.put("8", new Object[] { 7d, "Select marital status from drop down", "Marital status should be selected", "Pass" });
			
			if (datafile.getData("Proposer_marital_status").equals("testing, newdelhi")) {
				test.pass(datafile.getData("Proposer_marital_status") + " is " + "correct");
			} else
				test.log(Status.FAIL, datafile.getData("Proposer_marital_status") + " is not " + "correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("8", new Object[] { 7d, "Select marital status from drop down", "Marital status should be selected", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void AddressOne(String addr1) throws Exception {

		try {
			test = extent.createTest("Click on Address Input box & fill Value", "Address should be filled");
			WebElement address1 = driver.findElement(uimap.getLocator("Address_text_field1"));
			address1.clear();
			address1.sendKeys(addr1);
			TestNGResults.put("9", new Object[] { 8d, "Click on Address Input box & fill Value", "Address should be filled", "Pass" });
			
			if (datafile.getData("Addressline1").equals("testing, newdelhi")) {
				test.pass(datafile.getData("Addressline1") + " is " + "correct");
			} else
				test.log(Status.FAIL, datafile.getData("Addressline1") + " is not " + "correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("9", new Object[] { 8d, "Click on Address Input box & fill Value", "Address should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void AddressTwo(String addr2) throws Exception {

		try {
			test = extent.createTest("Click on Address Input box & fill Value", "Address should be filled");
			WebElement address2 = driver.findElement(uimap.getLocator("Address_text_field2"));
			address2.clear();
			address2.sendKeys(addr2);
			TestNGResults.put("10", new Object[] { 9d, "Click on Address Input box & fill Value", "Address should be filled", "Pass" });
			
			if (datafile.getData("Addressline2").equals("testing, newdelhi")) {
				test.pass(datafile.getData("Addressline2") + " is " + "correct");
			} else
				test.log(Status.FAIL, datafile.getData("Addressline2") + " is not " + "correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("10", new Object[] { 9d, "Click on Address Input box & fill Value", "Address should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void PinCode(String pinCode) throws Exception {

		try {
			test = extent.createTest("Click on Pincode Input box & fill Value", "Pincode should be filled");
			WebElement pincode = driver.findElement(uimap.getLocator("Pincode_text_field"));
			pincode.clear();
			pincode.sendKeys(pinCode);
			TestNGResults.put("11", new Object[] { 10d, "Click on Address Input box & fill Value", "Address should be filled", "Pass" });
			
			if (datafile.getData("Pincode").equals("testing, newdelhi")) {
				test.pass(datafile.getData("Pincode") + " is " + "correct");
			} else
				test.log(Status.FAIL, datafile.getData("Pincode") + " is not " + "correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("11", new Object[] { 10d, "Click on Address Input box & fill Value", "Address should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void ProposerSaveandContinue() throws Exception {

		try {
			test = extent.createTest("Click on Save & Continue Button", "Button should be clicked");
			WebElement savencontinue = driver.findElement(uimap.getLocator("Proposer_SaveandContinue_button"));
			savencontinue.click();
			TestNGResults.put("12", new Object[] { 11d, "Click on Save & Continue Button", "Button should be clicked", "Pass" });
			
			if (driver.getTitle().contains("Easypolicy")) {
				test.pass(driver.getTitle() + " contain " + "Easypolicy");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Easypolicy");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("12", new Object[] { 11d, "Click on Save & Continue Button", "Button should be clicked", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void AdultMaritalStatus(String adultMaritalStatus) throws Exception {

		try {
			test = extent.createTest("Fill Adult Marital status from drop down", "Marital Status should be filled");
			WebElement maritalstatusadult = driver.findElement(uimap.getLocator("MaritalStatus_dropdown_field_Adult"));
			maritalstatusadult.sendKeys(adultMaritalStatus);
			TestNGResults.put("13", new Object[] { 12d, "Fill Adult Marital status from drop down", "Marital Status should be filled", "Pass" });
			
			if (datafile.getData("Marital_status_adult").equals("Married")) {
				test.pass(datafile.getData("Marital_status_adult") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Marital_status_adult") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("13", new Object[] { 12d, "Fill Adult Marital status from drop down", "Marital Status should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void AdultWeight(String weight) throws Exception {

		try {
			test = extent.createTest("Fill Adult Weight in input box", "Weight should be filled");
			WebElement adultweight = driver.findElement(uimap.getLocator("Weight_text_field"));
			adultweight.clear();
			adultweight.sendKeys(weight);
			TestNGResults.put("14", new Object[] { 13d, "Fill Adult Weight in input box", "Weight should be filled", "Pass" });
			
			if (datafile.getData("Weight_adult").equals("68")) {
				test.pass(datafile.getData("Weight_adult") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Weight_adult") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("14", new Object[] { 13d, "Fill Adult Weight in input box", "Weight should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void AdultHeightFeet(String height) throws Exception {

		try {
			test = extent.createTest("Fill Adult Height from dropdown", "Adult Height In Feet should be filled");
			driver.findElement(uimap.getLocator("Height_Dropdown_feet")).click();
			if(Integer.parseInt(height)<=5){
			 	driver.findElement(By.xpath("//md-option[@ng-repeat='item in feetarray']/div[text()='"+height+"']")).click();
			 	}else if(Integer.parseInt(height)>5){
			 		driver.findElement(By.xpath("//md-option[@ng-repeat='item in feetarray']/div[text()='"+height+"']")).click();
			 	}
			TestNGResults.put("15", new Object[] { 14d, "Fill Adult Height from dropdown", "Adult Height In Feet should be filled", "Pass" });
			
			if (datafile.getData("Height_feet_adult").equals("5")) {
				test.pass(datafile.getData("Height_feet_adult") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Height_feet_adult") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("15", new Object[] { 14d, "Fill Adult Height from dropdown", "Adult Height In Feet should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void AdultHeightInches(String heightInches) throws Exception {

		try {
			test = extent.createTest("Fill Adult Height from dropdown", "Adult Height In inches should be filled");
			driver.findElement(uimap.getLocator("Height_Dropdown_inches")).click();
			if(Integer.parseInt(heightInches)<=4){
			 	driver.findElement(By.xpath("//md-option[@ng-repeat='item in incharray']/div[text()='"+heightInches+"']")).click();
			 	}else if(Integer.parseInt(heightInches)>4){
			 		driver.findElement(By.xpath("//md-option[@ng-repeat='item in incharray']/div[text()='"+heightInches+"']")).click();
			 	}
			TestNGResults.put("16", new Object[] { 15d, "Fill Adult Height from dropdown", "Adult Height In inches should be filled", "Pass" });
			
			if (datafile.getData("Height_inches_adult").equals("8")) {
				test.pass(datafile.getData("Height_inches_adult") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Height_inches_adult") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("16", new Object[] { 15d, "Fill Adult Height from dropdown", "Adult Height In inches should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void AdultSaveandContinue() throws Exception {

		try {
			test = extent.createTest("Click on Save & Continue Button", "Button should be clicked");
			WebElement savencontinue = driver.findElement(uimap.getLocator("Adult_SaveandContinue_button"));
			savencontinue.click();
			TestNGResults.put("12", new Object[] { 11d, "Click on Save & Continue Button", "Button should be clicked", "Pass" });
			
			if (driver.getTitle().contains("Easypolicy")) {
				test.pass(driver.getTitle() + " contain " + "Easypolicy");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Easypolicy");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("12", new Object[] { 11d, "Click on Save & Continue Button", "Button should be clicked", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void ChildSalutation() throws Exception {

		try {
			test = extent.createTest("Fill Child Salutation from dropdown", "Child Salutation should be filled");
			WebElement childsalutation = driver.findElement(uimap.getLocator("Child_salution_dropdown"));
			childsalutation.sendKeys(datafile.getData("Salution_child"));
			Thread.sleep(1000);
			TestNGResults.put("17", new Object[] { 16d, "Fill Child Salutation from dropdown", "Child Salutation should be filled", "Pass" });
			
			if (datafile.getData("Salution_child").equals("Mr.")) {
				test.pass(datafile.getData("Salution_child") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Salution_child") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("17", new Object[] { 16d, "Fill Child Salutation from dropdown", "Child Salutation should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void ChildFirstName() throws Exception {

		try {
			test = extent.createTest("Fill Child First Name In Input Box", "Child First Name should be filled");
			WebElement childfirstname = driver.findElement(uimap.getLocator("Child_Firstname_text_field"));
			childfirstname.sendKeys(datafile.getData("Firstname_child"));
			Thread.sleep(1000);
			TestNGResults.put("18", new Object[] { 17d, "Fill Child First Name In Input Box", "Child First Name should be filled", "Pass" });
			
			if (datafile.getData("Firstname_child").equals("satvik")) {
				test.pass(datafile.getData("Firstname_child") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Firstname_child") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("18", new Object[] { 17d, "Fill Child First Name In Input Box", "Child First Name should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void ChildLastName() throws Exception {

		try {
			test = extent.createTest("Fill Child Last Name In Input Box", "Child Last Name should be filled");
			WebElement childlastname = driver.findElement(uimap.getLocator("Child_Lastname_text_field"));
			childlastname.sendKeys(datafile.getData("Lastname_child"));
			Thread.sleep(1000);
			TestNGResults.put("19", new Object[] { 18d, "Fill Child Last Name In Input Box", "Child Last Name should be filled", "Pass" });
			
			if (datafile.getData("Lastname_child").equals("Kumar")) {
				test.pass(datafile.getData("Lastname_child") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Lastname_child") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("19", new Object[] { 18d, "Fill Child Last Name In Input Box", "Child Last Name should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void ChildDOB() throws Exception {

		try {
			test = extent.createTest("Enter value for DOB", "Value in numbers");
			WebElement DOBdate = driver.findElement(uimap.getLocator("Child_DOB_DD"));
			DOBdate.clear();
			DOBdate.sendKeys(datafile.getData("DOB_Child_DD"));
			Thread.sleep(1000);

			WebElement DOBmonth = driver.findElement(uimap.getLocator("Child_DOB_MM"));
			DOBmonth.clear();
			DOBmonth.sendKeys(datafile.getData("DOB_Child_MM"));
			Thread.sleep(1000);

			WebElement DOByear = driver.findElement(uimap.getLocator("Child_DOB_YYYY"));
			DOByear.clear();
			DOByear.sendKeys(datafile.getData("DOB_Child_YYYY"));
			Thread.sleep(1000);
			Assert.assertEquals("2014", datafile.getData("DOB_Child_YYYY"));
			TestNGResults.put("20", new Object[] { 19d, "Enter value for DOB", "Value in numbers", "Pass" });
			

			if (driver.getTitle().contains("Health Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Health Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("20", new Object[] { 19d, "Enter DOB detail", "Date of Birth", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void ChildWeight() throws Exception {

		try {
			test = extent.createTest("Fill Child Weight in input box", "Weight should be filled");
			WebElement childweight = driver.findElement(uimap.getLocator("Child_weight_text_field"));
			childweight.sendKeys(datafile.getData("Weight_Child"));
			Thread.sleep(1000);
			TestNGResults.put("21", new Object[] { 20d, "Fill Child Weight in input box", "Weight should be filled", "Pass" });
			
			if (datafile.getData("Weight_Child").equals("20")) {
				test.pass(datafile.getData("Weight_Child") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Weight_Child") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("21", new Object[] { 20d, "Fill Child Weight in input box", "Weight should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void ChildHeightFeet() throws Exception {

		try {
			test = extent.createTest("Fill Child Height from dropdown", "Child Height In Feet should be filled");
			WebElement childhieghtfeet = driver.findElement(uimap.getLocator("Child_height_feet"));
			childhieghtfeet.sendKeys(datafile.getData("Height_feet_child"));
			Thread.sleep(1000);
			TestNGResults.put("22", new Object[] { 21d, "Fill Child Height from dropdown", "Child Height In Feet should be filled", "Pass" });
			
			if (datafile.getData("Height_feet_child").equals("2")) {
				test.pass(datafile.getData("Height_feet_child") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Height_feet_child") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("22", new Object[] { 21d, "Fill Child Height from dropdown", "Child Height In Feet should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void ChildHeightInches() throws Exception {

		try {
			test = extent.createTest("Fill Child Height from dropdown", "Child Height In inches should be filled");
			WebElement childheightinches = driver.findElement(uimap.getLocator("Child_height_inches"));
			childheightinches.sendKeys(datafile.getData("Height_inches_child"));
			Thread.sleep(1000);
			TestNGResults.put("23", new Object[] { 22d, "Fill Child Height from dropdown", "Child Height In inches should be filled", "Pass" });
			
			if (datafile.getData("Height_inches_child").equals("10")) {
				test.pass(datafile.getData("Height_inches_child") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Height_inches_child") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("23", new Object[] { 22d, "Fill Child Height from dropdown", "Child Height In inches should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void MemberSaveAndContinue() throws Exception {

		try {
			test = extent.createTest("Click Save & continue button in member Details section", "Button should be clicked");
			WebElement membersavendcontinue = driver.findElement(uimap.getLocator("Memberdetails_saveandcontinue_button"));
			membersavendcontinue.click();
			Thread.sleep(1000);
			TestNGResults.put("24", new Object[] { 23d, "Click Save & continue button in member Details section", "Button should be clicked", "Pass" });
			
			if (driver.getTitle().contains("Health Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Health Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("24", new Object[] { 23d, "Click Save & continue button in member Details section", "Button should be clicked", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void MedicalHistory(String medicalHstry1, String medicalHstry2, String medicalHstry3) throws Exception {

		try {
			test = extent.createTest("Click Radio button in Medical History section", "Radio button should be clicked");
			driver.findElement(By.xpath("(//md-radio-button[@aria-label='"+medicalHstry1+"']//div[@class='_md-off'])[3]")).click();
			driver.findElement(By.xpath("(//md-radio-button[@aria-label='"+medicalHstry2+"']//div[@class='_md-off'])[5]")).click();
		    driver.findElement(By.xpath("(//md-radio-button[@aria-label='"+medicalHstry3+"']//div[@class='_md-off'])[7]")).click();
			TestNGResults.put("25", new Object[] { 24d, "Click Radio button in Medical History section", "Radio button should be clicked", "Pass" });
			
			if (driver.getTitle().contains("Health Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Health Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("25", new Object[] { 24d, "Click Radio button in Medical History section", "Radio button should be clicked", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void MedicalHistorySaveAndContinue() throws Exception {

		try {
			test = extent.createTest("Click Save & Continue in Medical History section", "button should be clicked");
			WebElement MedicalHistorySaveandContinue = driver.findElement(uimap.getLocator("MedicalHistory_SaveandContinue_button"));
			MedicalHistorySaveandContinue.click();
			Thread.sleep(1000);
			TestNGResults.put("27", new Object[] { 26d, "Click Save & Continue in Medical History section", "button should be clicked", "Pass" });
			
			if (driver.getTitle().contains("Health Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Health Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("27", new Object[] { 26d, "Click Save & Continue in Medical History section", "button should be clicked", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void NomineeName(String name) throws Exception {

		try {
			test = extent.createTest("Fill Nominee Name in Input Box", "Nominee Name should be filled");
			WebElement nomineename = driver.findElement(uimap.getLocator("Nomineename_text_field"));
			nomineename.clear();
			nomineename.sendKeys(name);
			TestNGResults.put("27", new Object[] { 26d, "Fill Nominee Name in Input Box", "Nominee Name should be filled", "Pass" });
			
			if (datafile.getData("Nominee_name").equals("qa")) {
				test.pass(datafile.getData("Nominee_name") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Nominee_name") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("27", new Object[] { 26d, "Fill Nominee Name in Input Box", "Nominee Name should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void NomineeRelation(String relation) throws Exception {

		try {
			test = extent.createTest("Fill Nominee Relation From Dropdown Box", "Nominee Relation should be filled");
			WebElement nomineerelation = driver.findElement(uimap.getLocator("Nominee_Relation_dropdown"));
			String rel=relation;
			nomineerelation.sendKeys(rel);
			TestNGResults.put("26", new Object[] { 27d, "Fill Nominee Relation From Dropdown Box", "Nominee Relation should be filled", "Pass" });
			
			if (datafile.getData("Nominee_relation").equals("Brother")) {
				test.pass(datafile.getData("Nominee_relation") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Nominee_relation") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("26", new Object[] { 27d, "Fill Nominee Relation From Dropdown Box", "Nominee Relation should be filled", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	public void ProceedToPayment() throws Exception {

		try {
			test = extent.createTest("Click on Proceed to payment", "Proposal page should be redirect on payment gateway");
			WebElement ProceedToPaymentbutton = driver.findElement(uimap.getLocator("Proceed_to_payment_button"));
			ProceedToPaymentbutton.click();
//			Thread.sleep(1000);
			TestNGResults.put("29", new Object[] { 29d, "Click on Proceed to payment", "Proposal page should be redirect on payment gateway", "Pass" });
			
			if (driver.getTitle().contains("Health Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Health Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");


		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("29", new Object[] { 29d, "Click on Proceed to payment", "Proposal page should be redirect on payment gateway", "Fail" });
			//Assert.assertTrue(false);
		}
	}
	// write Test Cases in to excel file
		@BeforeClass(alwaysRun = true)
		public void CignasuiteSetUp() {

			// create a new work book
			workbook = new HSSFWorkbook();
			// create a new work sheet
			sheet = workbook.createSheet("TestNG Result Summary");
			TestNGResults = new LinkedHashMap<String, Object[]>();
			// add test result excel file column header
			// write the header in the first row
			TestNGResults.put("1", new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output" });

			try {

				// Get current working directory and load the data file
				workingDir = System.getProperty("user.dir");
				datafile = new UIMap(workingDir + "\\datafile.properties");

				// Get the object map file
				uimap = new UIMap(workingDir + "\\locator1.properties");
				extent = ExtentManager.GetExtent();

			} catch (Exception e) {
				throw new IllegalStateException("Can't start the Firefox Web Driver", e);
			}

		}

		@AfterClass
		public void CignasuiteTearDown() throws Exception {
			// Create excel file and file name is SaveHealthTestNGResultToExcel.xls
			Set<String> keyset = TestNGResults.keySet();
			int rownum = 0;
			for (String key : keyset) {
				Row row = sheet.createRow(rownum++);
				Object[] objArr = TestNGResults.get(key);
				int cellnum = 0;
				for (Object obj : objArr) {
					Cell cell = row.createCell(cellnum++);
					if (obj instanceof Date)
						cell.setCellValue((Date) obj);
					else if (obj instanceof Boolean)
						cell.setCellValue((Boolean) obj);
					else if (obj instanceof String)
						cell.setCellValue((String) obj);
					else if (obj instanceof Double)
						cell.setCellValue((Double) obj);
				}
			}
			try {
				FileOutputStream out = new FileOutputStream(new File("D:\\surya\\EasyPolicy\\testNgCignaProposalResult\\CignaProposalTestNGResultToExcel.xls"));
				workbook.write(out);
				out.close();
				System.out.println("Successfully saved Selenium WebDriver TestNG result to Excel File!!!");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// close the browser
			 extent.flush();
			// driver.close();
			// driver.quit();
			// endreport();
			SendMailSSL.execute("HealthExtentReport1.html");
		}

		@AfterMethod
		public void getResult(ITestResult result) throws IOException {
			if (result.getStatus() == ITestResult.FAILURE) {
				String screenShotPath = HealthProductJourneyWithExcel.capture(driver, "screenShotName");
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:",
						ExtentColor.RED));
				test.fail(result.getThrowable());
				test.fail("Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			} else {
				test.log(Status.SKIP,
						MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.ORANGE));
				test.skip(result.getThrowable());
			}
			extent.flush();
		}
		/*@AfterMethod(alwaysRun=true)
		public void catchExceptions(ITestResult result){
		    Calendar calendar = Calendar.getInstance();
		    SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		    String methodName = result.getName();
		    if(!result.isSuccess()){
		        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        try {
		            FileUtils.copyFile(scrFile, new File((String) PathConverter.convert("failure_screenshots/"+methodName+"_"+formater.format(calendar.getTime())+".png")));
		        } catch (IOException e1) {
		            e1.printStackTrace();
		        }
		    }
		}*/

		@AfterTest
		public void endreport() {
			driver.close();
			// extent.flush();
			// extent.close();
		}
}
