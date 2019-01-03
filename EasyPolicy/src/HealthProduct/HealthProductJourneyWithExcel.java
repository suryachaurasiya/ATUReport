package HealthProduct;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ATUReports.AUTreports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.health.UIMap;

import extentReport.ExtentBaseClass;
import extentReport.ExtentManager;
import HealthProduct.CignaProposal;
import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class HealthProductJourneyWithExcel extends ExtentBaseClass{
	public static WebDriver driver;
	public UIMap uimap;
	public UIMap datafile;
	public UIMap locator;
	public String workingDir;
	public AUTreports autReports;
//	public static ExtentReports extent;
//	public static ExtentTest test;
//	ExtentHtmlReporter htmlReporter;
	
	// Declare An Excel Work Book
	HSSFWorkbook workbook;
	// Declare An Excel Work Sheet
	HSSFSheet sheet;
	// Declare A Map Object To Hold TestNG Results
	Map<String, Object[]> TestNGResults;

	// Capture Screenshot in Folder
	public static String capture(WebDriver driver, String screenShotName) throws IOException {
		screenShotName = driver.getTitle();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\ErrorScreenshots\\" + screenShotName + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);

		return dest;
	}

	// Open Easypolicy Website
	@Test(description = "Open Easypolicy Website for health Product Journey", priority = 1)
	public void LaunchWebsite() throws Exception {

		try {
			test = extent.createTest("Open URL, Navigate to website", "Easypolicy Website should be open");
			driver.get("http://easypolicy.com/");
			driver.manage().window().maximize();
			String title = driver.getTitle();
			Assert.assertEquals("Easypolicy - #1 from Insurance Comparison to Claim Support", title);
			TestNGResults.put("2",
					new Object[] { 1d, "Open URL, Navigate to website", "Easypolicy Website should be open", "Pass" });

			if (driver.getTitle().contains("Easypolicy")) {
				test.pass(driver.getTitle() + " contain " + "Easypolicy");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Easypolicy");
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("2",
					new Object[] { 1d, "Open URL, Navigate to website", "Easypolicy Website should be open", "Fail" });
			Assert.assertTrue(false);
		}
		
	}

	// Click on Health Product link
	@Test(description = "Click on Health product link ", priority = 2)
	public void FillLoginDetails() throws Exception {

		try {
			test = extent.createTest("Click on Health Link on top bar", "Health product page should be open with form");
			WebElement health = driver.findElement(uimap.getLocator("health_product"));
			health.click();
			
			TestNGResults.put("3", new Object[] { 2d, "Click on Health Link on top bar",
					"Health product page should be open with form", "Pass" });

			if (driver.getTitle().contains("Health Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Health Insurance");
			    
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("3", new Object[] { 2d, "Click on Health Link on top bar",
					"Health product page should be open with form", "Fail" });
			Assert.assertTrue(false);
		}
		
	}

	// Fill value in Adult
	@Test(description = "Enter adult value 2", priority = 3)
	public void Adult() throws Exception {

		try {
			test = extent.createTest("Enter value 2 for adults", "Value in numbers");
			WebElement adultNo = driver.findElement(uimap.getLocator("adult_text_field"));
			adultNo.clear();
			adultNo.sendKeys(datafile.getData("adultTwo"));
			
//			Thread.sleep(1000);
			TestNGResults.put("4", new Object[] { 3d, "Enter value 2 for adults", "Value in numbers", "Pass" });

			if (datafile.getData("adultTwo").equals("2")) {
				test.pass(datafile.getData("adultTwo").equals("2") + " equals " + "2");
			} else
				test.log(Status.FAIL, datafile.getData("adultTwo").equals("2") + " doesn't equals " + "2");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("4", new Object[] { 3d, "Enter value 2 for adults", "Value in numbers", "Fail" });
			Assert.assertTrue(false);
		}
	}

	// Fill Value in Child
	@Test(description = "Enter Child value 1-4", priority = 4)
	public void Child() throws Exception {

		try {
			test = extent.createTest("Enter value 1 for Child", "Value in numbers");
			WebElement adultNo = driver.findElement(uimap.getLocator("child_text_field"));
			adultNo.clear();
			adultNo.sendKeys(datafile.getData("ChildOne"));
//			Thread.sleep(1000);
			
			TestNGResults.put("5", new Object[] { 4d, "Enter value 1 for Child", "Value in numbers", "Pass" });

			if (datafile.getData("ChildOne").equals("1")) {
				test.pass(datafile.getData("ChildOne") + " equal " + "one");
			} else
				test.log(Status.FAIL, datafile.getData("ChildOne") + "does not equal " + "one");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("5", new Object[] { 4d, "Enter value 1 for Child", "Value in numbers", "Fail" });
			Assert.assertTrue(false);
		}
	}

	// Enter Date of Birth
	@Test(description = "Enter DOB", priority = 5)
	public void DOB() throws Exception {

		try {
			test = extent.createTest("Enter value for DOB", "Value in numbers");
			WebElement DOBdate = driver.findElement(uimap.getLocator("DOB_text_fieldD"));
			DOBdate.clear();
			DOBdate.sendKeys(datafile.getData("DOBD"));
//			Thread.sleep(1000);
			
			WebElement DOBmonth = driver.findElement(uimap.getLocator("DOB_text_fieldM"));
			DOBmonth.clear();
			DOBmonth.sendKeys(datafile.getData("DOBM"));
//			Thread.sleep(1000);
			
			WebElement DOByear = driver.findElement(uimap.getLocator("DOB_text_fieldY"));
			DOByear.clear();
			DOByear.sendKeys(datafile.getData("DOBY"));
			
//			Thread.sleep(1000);
			Assert.assertEquals("1986", datafile.getData("DOBY"));
			TestNGResults.put("6", new Object[] { 5d, "Enter value for DOB", "Value in numbers", "Pass" });

			if (driver.getTitle().contains("Health Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Health Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("6", new Object[] { 5d, "Enter DOB detail", "Date of Birth", "Fail" });
			Assert.assertTrue(false);
		}
	}

	// Select Eldest Member Gender
	@Test(description = "Select Eldest Member Gender", priority = 6)
	public void EldestMember() throws Exception {

		try {
			test = extent.createTest("Select eldest member gender", "Value in numbers");
			WebElement gender = driver.findElement(uimap.getLocator("eldest_member_gender_male"));
			gender.click();
//			Thread.sleep(1000);
			
			TestNGResults.put("7", new Object[] { 6d, "Select eldest member gender", "select by click", "Pass" });

			if (datafile.getData("Elder_member_gender").equals("Female")) {
				test.pass(datafile.getData("Elder_member_gender") + " equal " + "Female");
			} else
				test.log(Status.FAIL, datafile.getData("Elder_member_gender") + " doesn't equal " + "Female");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("7", new Object[] { 6d, "Select eldest member gender", "Gender", "Fail" });
			Assert.assertTrue(false);
		}
	}

	// Select City from the list
	@Test(description = "Select City from list", priority = 7)
	public void City() throws Exception {

		try {
			WebElement city = driver.findElement(uimap.getLocator("City_Input"));
			city.click();
//			Thread.sleep(1000);
			city.sendKeys(datafile.getData("City"));
			WebElement cityclick = driver.findElement(uimap.getLocator("Click_city"));
			cityclick.click();
			
			TestNGResults.put("8", new Object[] { 7d, "Select City From the List", "select by click", "Pass" });
			test = extent.createTest("Select City From the List", "select by enter text");

			if (datafile.getData("City").equals("New Delhi, Delhi")) {
				test.pass(datafile.getData("City") + " equal " + "New Delhi, Delhi");
			} else
				test.log(Status.FAIL, datafile.getData("City") + " doesn't equal " + "New Delhi, Delhi");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("8", new Object[] { 7d, "Select City From the List", "select by click", "Fail" });
			Assert.assertTrue(false);
		}
		driver.findElement(By.xpath("//input[contains(@ng-blur,'(userMobile)')]")).sendKeys("7838272731");
//		Thread.sleep(3000);
//		driver.findElement(uimap.getLocator("Click_GetLiveQuotes")).click();
	}

	// Click On Get Live Quotes Button
	@Test(description = "Click Get Live Quotes Button", priority = 8)
	public void GetLiveQuotes() throws Exception {

		try {
			
		    driver.findElement(uimap.getLocator("Click_GetLiveQuotes")).click();
			test = extent.createTest("Click get live quotes button", "Value in numbers");

			if (driver.getTitle().contains("Easypolicy")) {
				test.pass(driver.getTitle() + " contain " + "Easypolicy");
			} else
				test.log(Status.FAIL, driver.getTitle() + " contain " + "Health Insurance");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("9", new Object[] { 8d, "Click get live quotes button", "Button", "Fail" });
			Assert.assertTrue(false);
		}
	}

	@Test(description = "Fill Customer Name in Customer Popup")
	public void CustomerPopup() throws Exception {

		try {
			Thread.sleep(5000);
			test = extent.createTest("Fill Name in Customer Popup", "Name Should be entered");
			WebElement Custname = driver.findElement(uimap.getLocator("Customer_Name"));
			Custname.sendKeys(datafile.getData("Customername"));
			// String title = driver.getTitle();
			Assert.assertEquals("Vijay Kumar", datafile.getData("Customername"));
			TestNGResults.put("10",
					new Object[] { 9d, "Fill The Customer name value", "Values should be entered", "Pass" });
			if (datafile.getData("Customername").equals("Vijay Kumar")) {
				test.pass(datafile.getData("Customername") + " contain " + "Vijay");
			} else
				test.log(Status.FAIL, datafile.getData("Customername") + " Input Is InCorrect");
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("10",
					new Object[] { 9d, "Fill The Customer name value", "Values should be entered", "Fail" });
			Assert.assertTrue(false);
		}
	}

	@Test(description = "Fill Customer Email in Customer Popup")
	public void CustomerEmail() throws Exception {

		try {
			test = extent.createTest("Fill Email in Customer Popup", "Email Should be entered");
			WebElement Custemail = driver.findElement(uimap.getLocator("Customer_Email"));
			Custemail.sendKeys(datafile.getData("CustomerEmailId"));
			// String title = driver.getTitle();
			Assert.assertEquals("vijay.kumar@ep.com", datafile.getData("CustomerEmailId"));
			TestNGResults.put("11",
					new Object[] { 10d, "Fill The Customer email value", "Values should be entered", "Pass" });
			if (datafile.getData("CustomerEmailId").equals("vijay.kumar@ep.com")) {
				test.pass(datafile.getData("CustomerEmailId") + " contain " + "binny");
			} else
				test.log(Status.FAIL, datafile.getData("CustomerEmailId") + " Input Is InCorrect");
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("10",
					new Object[] { 9d, "Fill The Customer email value", "Values should be entered", "Fail" });
			Assert.assertTrue(false);
		}
	}

//	@Test(description = "Fill Customer Mobile Number in Customer Popup", priority = 11)
//	public void CustomerMobno() throws Exception {
//
//		try {
//			test = extent.createTest("Fill Mobile No in Customer Popup", "Mobile No Should be entered");
//			WebElement CustMobNo = driver.findElement(uimap.getLocator("Customer_Number"));
//			CustMobNo.sendKeys(datafile.getData("CustomerMobileNo"));
//			// String title = driver.getTitle();
//			Assert.assertEquals("6789678967", datafile.getData("CustomerMobileNo"));
//			TestNGResults.put("11",
//					new Object[] { 10d, "Fill The Customer mobile no value", "Values should be entered", "Pass" });
//			if (datafile.getData("CustomerMobileNo").equals("6789678967")) {
//				test.pass(datafile.getData("CustomerMobileNo") + " contain " + "6789678967");
//			} else
//				test.log(Status.FAIL, datafile.getData("CustomerMobileNo") + " Input Is InCorrect");
//		} catch (Exception e) {
//			test.log(Status.ERROR, e.getMessage());
//			TestNGResults.put("11",
//					new Object[] { 10d, "Fill The Customer mobile no value", "Values should be entered", "Fail" });
//			Assert.assertTrue(false);
//		}
//	}

	@Test(description = "Click Proceed button on Customer Popup")
	public void CustomerProceed() throws Exception {

		try {
			test = extent.createTest("Click on proceed button",
					"Button Should be clicked and quotes page should be displayed");
			WebElement CustMobNo = driver.findElement(uimap.getLocator("Click_Proceed_Button"));
			CustMobNo.click();
			TestNGResults.put("12", new Object[] { 11d, "Click on proceed button",
					"Button Should be clicked and quotes page should be displayed", "Pass" });
			if (driver.getTitle().contains("Claim Support")) {
				test.pass(driver.getTitle() + " contain " + "Claim Support");

			} else
				test.log(Status.FAIL, driver.getTitle() + "doesn't contain " + "Claim Support");
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("12", new Object[] { 11d, "Click on proceed button",
					"Button Should be clicked and quotes page should be displayed", "Fail" });
			Assert.assertTrue(false);
		}
	}

	@Test(description = "Quotes page journey", priority = 13, dataProvider="verify",dataProviderClass=UIMap.class, invocationCount=2)
	public void QuotesBuyNow(String salutation, String firstName,String lastName,String emailID, String mobileNo, String profession,
            String maritalStatus, String addrLine1, String addrLine2, String city, String pinCode, String childDOBDate,
            String childDOBMnth, String childDOBYer, String maritalStatusChild, String weight, String heightFeet,
            String heightInches, String medicalHstry1, String medicalHstry2, String medicalHstry3, String nomineeName, String nomineeRelation  
            ) throws Exception {
		driver.findElement(By.xpath("(//span[text()='BUY NOW'])[1]")).click();
		CustomerPopup();
		CustomerEmail();
		CustomerProceed();
		String urlquotes = driver.getCurrentUrl();
		System.out.println(urlquotes);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> buyNowElement = driver.findElements(By.xpath("//span[text()='BUY NOW']"));
		String winScroll = "window.scrollBy(0,300)";
		RemoteWebDriver rwd = (RemoteWebDriver) driver;
		for (int i = 1; i <= buyNowElement.size(); i++) {
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//span[text()='BUY NOW'])[" + i + "]")).click();
			Thread.sleep(5000);
			String url = driver.getCurrentUrl();
			System.out.println(url);
			Thread.sleep(5000);
			if (i == 3) {
				CignaProposal cp = new CignaProposal();
//				cp.driver = driver;
//				cp.uimap = uimap;
//				cp.datafile = datafile;
//				cp.workingDir = workingDir;
//				String name = "abc";
//				cp.name = name;
				cp.CignasuiteSetUp();
				cp.CignaProposalFill(salutation);
				//cp.fetcheName();
				cp.CignaProposalFillName(firstName);				
				cp.FillLastName(lastName);
				cp.EmailID(emailID);
				cp.MobileNo(mobileNo);
				cp.Profession(profession);
				cp.MaritalStatus(maritalStatus);
				cp.AddressOne(addrLine1);
				cp.AddressTwo(addrLine2);
				cp.PinCode(pinCode);
				cp.ProposerSaveandContinue();
				cp.AdultMaritalStatus(maritalStatusChild);
				cp.AdultWeight(weight);
				cp.AdultHeightFeet(heightFeet);
				cp.AdultHeightInches(heightInches);
				cp.AdultSaveandContinue();
				cp.MedicalHistory(medicalHstry1, medicalHstry2, medicalHstry3);
				cp.MedicalHistorySaveAndContinue();
				cp.NomineeName(nomineeName);
				cp.NomineeRelation(nomineeRelation);
				cp.ProceedToPayment();
//				Thread.sleep(5000);
//				cp.CignasuiteTearDown();
			}
			/*
			 * if(i==3){ ReligareProposal rp=new ReligareProposal(driver);
			 * rp.enterPopupDetail(driver); Thread.sleep(3000);
			 * rp.enterProposarDetails(driver); Thread.sleep(3000);
			 * rp.enterMemberDetails(driver); }
			 */
			driver.navigate().to(urlquotes);

			for (int j = 0; j < i; j++) {
				Thread.sleep(1000);
				rwd.executeScript(winScroll);
			}
			 /*driver.navigate().back();
			 Thread.sleep(3000);
			 WebElement buyNow =
			 driver.findElement(By.xpath("(//h5[text()='ProHealthPlus']/../../../../..//span[text()='BUY NOW'])[1]"));
			 buyNow.click();
			 break;*/
		}
	}

	

	// write Test Cases in to excel file
	@BeforeClass(alwaysRun = true)
	public void suiteSetUp() {

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

			// Setting up FireFox driver path.
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile myprofile = profile.getProfile("TestAutomation");

			// Launching FireFox browser.
			driver = new FirefoxDriver(myprofile);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new IllegalStateException("Can't start the Firefox Web Driver", e);
		}

	}

	@AfterClass
	public void suiteTearDown() throws Exception {
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
			FileOutputStream out = new FileOutputStream(new File(".\\testNGHealthResult\\SaveHealthTestNGResultToExcel.xls"));
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
		SendMailSSL.execute("HealthExtentReport07-07-2017.html");
	}

	 
/*	@AfterTest
	public void endreport() {
		driver.close();
		// extent.flush();
		// extent.close();
	}*/

}

