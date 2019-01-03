package investmentProduct;

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
import org.openqa.selenium.Alert;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import extentReport.ExtentManager;
import healthProduct.UIMap;

public class InvestmentProductJourney {

	public static WebDriver driver;
	public UIMap uimap;
	public UIMap datafile;
	public UIMap locator;
	public String workingDir;
	public static ExtentReports extent;
	public static ExtentTest test;
	ExtentHtmlReporter htmlReporter;

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

	@BeforeTest
	public void config() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/HealthExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	// Open Easypolicy Website
	@Test(description = "Open Easypolicy Website for Pension Product Journey", priority = 1)
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
	@Test(description = "Click on Investment product link ", priority = 2)
	public void FillLoginDetails() throws Exception {

		try {
			test = extent.createTest("Click on Investment Link on top bar", "Investment product page should be open with form");
			WebElement child = driver.findElement(uimap.getLocator("investment_product"));
			child.click();
			Thread.sleep(1000);
			TestNGResults.put("3", new Object[] { 2d, "Click on Health Link on top bar",
					"Investment product page should be open with form", "Pass" });

			if (driver.getTitle().contains("Investment Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Investment Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Investment Insurance");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("3", new Object[] { 2d, "Click on Investment Link on top bar",
					"Investment product page should be open with form", "Fail" });
			Assert.assertTrue(false);
		}
	}
	
	// Select Eldest Member Gender
		@Test(description = "Select Member Gender", priority = 3)
		public void EldestMember() throws Exception {

			try {
				test = extent.createTest("Select member gender", "Value in numbers");
				WebElement gender = driver.findElement(uimap.getLocator("Gender_investment"));
				gender.click();
				Thread.sleep(1000);

				TestNGResults.put("4", new Object[] { 3d, "Select gender", "select by click", "Pass" });

				if (uimap.getLocator("Gender_investment").equals("Male")) {
					test.pass(uimap.getLocator("Gender_investment") + " equal " + "Male");
				} else
					test.log(Status.FAIL, uimap.getLocator("Gender_investment") + " doesn't equal " + "Male");

			} catch (Exception e) {
				test.log(Status.ERROR, e.getMessage());
				TestNGResults.put("4", new Object[] { 3d, "Select gender", "Gender", "Fail" });
				Assert.assertTrue(false);
			}
		}
	// Enter child Date of Birth
	@Test(description = "Enter DOB", priority = 4)
	public void ChildDOB() throws Exception {

		try {
			test = extent.createTest("Enter value for DOB", "Value in numbers");
			WebElement DOBdate = driver.findElement(uimap.getLocator("investment_dob_field_DD"));
			DOBdate.clear();
			DOBdate.sendKeys(datafile.getData("investment_DOBD"));
			Thread.sleep(1000);

			WebElement DOBmonth = driver.findElement(uimap.getLocator("investment_dob_field_MM"));
			DOBmonth.clear();
			DOBmonth.sendKeys(datafile.getData("investment_DOBM"));
			Thread.sleep(1000);

			WebElement DOByear = driver.findElement(uimap.getLocator("investment_dob_field_YYYY"));
			DOByear.clear();
			DOByear.sendKeys(datafile.getData("investment_DOBY"));
			Thread.sleep(1000);
			Assert.assertEquals("1986", datafile.getData("investment_DOBY"));
			TestNGResults.put("5", new Object[] { 4d, "Enter value for DOB", "Value in numbers", "Pass" });

			if (driver.getTitle().contains("Health Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Health Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("5", new Object[] { 4d, "Enter DOB detail", "Date of Birth", "Fail" });
			Assert.assertTrue(false);
		}
	}
	@Test(description = "Input Invest amount", priority = 5)
	public void InvestAmount() throws Exception {

		try {
			test = extent.createTest("Input Invest amount", "Value in numbers");
			WebElement investamount = driver.findElement(uimap.getLocator("invest_amount"));
			investamount.click();
			investamount.sendKeys(datafile.getData("invest_amount_investment"));
			Thread.sleep(1000);

			TestNGResults.put("6", new Object[] { 5d, "Invest amount", "Input in invest amount", "Pass" });

			if (datafile.getData("invest_amount_investment").equals("40000")) {
				test.pass(datafile.getData("invest_amount_investment") + " equal " + "40000");
			} else
				test.log(Status.FAIL, datafile.getData("invest_amount_investment") + " doesn't equal " + "40000");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("6", new Object[] { 5d, "Input Invest amount", "amount not input", "Fail" });
			Assert.assertTrue(false);
		}
	}
	@Test(description = "Insert mobile no in input box ", priority = 6)
	public void mobilenoinvestment() throws Exception {

		try {
			test = extent.createTest("Insert mobile no in input box", "Value in numbers");
			WebElement investamount = driver.findElement(uimap.getLocator("mobilenoinvestment"));
			investamount.click();
			investamount.sendKeys(datafile.getData("input_mobilenoinvestment"));
			Thread.sleep(1000);

			TestNGResults.put("6", new Object[] { 5d, "Insert mobile no in input box", "Insert mobile no in input box", "Pass" });

			if (datafile.getData("input_mobilenoinvestment").equals("9873008200")) {
				test.pass(datafile.getData("input_mobilenoinvestment") + " equal " + "9873008200");
			} else
				test.log(Status.FAIL, datafile.getData("input_mobilenoinvestment") + " doesn't equal " + "9873008200");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("6", new Object[] { 5d, "Insert mobile no in input box", "Insert mobile no in input box", "Fail" });
			Assert.assertTrue(false);
		}
	}

	// Click On Get Live Quotes Button
	@Test(description = "Click Get Live Quotes Button", priority = 7)
	public void GetLiveQuotes() throws Exception {

		try {
			WebElement buttonlivequote = driver.findElement(uimap.getLocator("GetLiveButton"));
			buttonlivequote.click();
			Thread.sleep(1000);
			TestNGResults.put("7",
					new Object[] { 6d, "Click get live quotes button", "click Get Live Quotes", "Pass" });
			test = extent.createTest("Click get live quotes button", "Value in numbers");

			if (driver.getTitle().contains("Easypolicy")) {
				test.pass(driver.getTitle() + " contain " + "Easypolicy");
			} else
				test.log(Status.FAIL, driver.getTitle() + " contain " + "Health Insurance");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("7", new Object[] { 6d, "Click get live quotes button", "Button", "Fail" });
			Assert.assertTrue(false);
		}
	}

	@Test(description = "Fill Customer Name in Customer Popup")
	public void CustomerPopup() throws Exception {

		try {
			Thread.sleep(8000);
			test = extent.createTest("Fill Name in Customer Popup", "Name Should be entered");
			WebElement Custname = driver.findElement(uimap.getLocator("Customer_Name"));
			Custname.sendKeys(datafile.getData("Customername"));
			// String title = driver.getTitle();
			Assert.assertEquals("Vijay Kumar", datafile.getData("Customername"));
			TestNGResults.put("8",
					new Object[] { 7d, "Fill The Customer name value", "Values should be entered", "Pass" });
			if (datafile.getData("Customername").equals("Vijay Kumar")) {
				test.pass(datafile.getData("Customername") + " contain " + "Vijay");
			} else
				test.log(Status.FAIL, datafile.getData("Customername") + " Input Is InCorrect");
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("8",
					new Object[] { 7d, "Fill The Customer name value", "Values should be entered", "Fail" });
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
			TestNGResults.put("9",
					new Object[] { 8d, "Fill The Customer email value", "Values should be entered", "Pass" });
			if (datafile.getData("CustomerEmailId").equals("vijay.kumar@ep.com")) {
				test.pass(datafile.getData("CustomerEmailId") + " contain " + "binny");
			} else
				test.log(Status.FAIL, datafile.getData("CustomerEmailId") + " Input Is InCorrect");
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("9",
					new Object[] { 8d, "Fill The Customer email value", "Values should be entered", "Fail" });
			Assert.assertTrue(false);
		}
	}

	/*@Test(description = "Fill Customer Mobile Number in Customer Popup")
	public void CustomerMobno() throws Exception {

		try {
			test = extent.createTest("Fill Mobile No in Customer Popup", "Mobile No Should be entered");
			WebElement CustMobNo = driver.findElement(uimap.getLocator("Customer_Number"));
			CustMobNo.sendKeys(datafile.getData("CustomerMobileNo"));
			// String title = driver.getTitle();
			Assert.assertEquals("6789678967", datafile.getData("CustomerMobileNo"));
			TestNGResults.put("10",
					new Object[] { 9d, "Fill The Customer mobile no value", "Values should be entered", "Pass" });
			if (datafile.getData("CustomerMobileNo").equals("6789678967")) {
				test.pass(datafile.getData("CustomerMobileNo") + " contain " + "6789678967");
			} else
				test.log(Status.FAIL, datafile.getData("CustomerMobileNo") + " Input Is InCorrect");
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("10",
					new Object[] { 9d, "Fill The Customer mobile no value", "Values should be entered", "Fail" });
			Assert.assertTrue(false);
		}
	}
*/
	@Test(description = "Click Proceed button on Customer Popup")
	public void CustomerProceed() throws Exception {

		try {
			test = extent.createTest("Click on proceed button",
					"Button Should be clicked and quotes page should be displayed");
			WebElement CustMobNo = driver.findElement(uimap.getLocator("Click_Proceed_Button"));
			CustMobNo.click();
			TestNGResults.put("11", new Object[] { 10d, "Click on proceed button",
					"Button Should be clicked and quotes page should be displayed", "Pass" });
			if (driver.getTitle().contains("Claim Support")) {
				test.pass(driver.getTitle() + " contain " + "Claim Support");

			} else
				test.log(Status.FAIL, driver.getTitle() + "doesn't contain " + "Claim Support");
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			TestNGResults.put("11", new Object[] { 10d, "Click on proceed button",
					"Button Should be clicked and quotes page should be displayed", "Fail" });
			Assert.assertTrue(false);
		}
	}

	@Test(description = "Quotes page journey", priority = 8)
	public void QuotesBuyNow() throws Exception {
		String urlquotes = driver.getCurrentUrl();
		System.out.println(urlquotes);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> buyNowElement = driver.findElements(By.xpath(".//*[@id='imgbtntermbuynow']"));
		
		String winScroll = "window.scrollBy(0,300)";
		RemoteWebDriver rwd = (RemoteWebDriver) driver;
		for (int i = 1; i <= buyNowElement.size()-119; i+=4) {
			driver.findElement(By.xpath("(.//*[@id='imgbtntermbuynow'])[" + i + "]")).click();
			String urlBajaj="https://life.bajajallianz.com";
			
			if(driver.findElement(By.xpath("//input[@placeholder='Please enter full name']")).isDisplayed()){
			CustomerPopup();
			CustomerEmail();
			CustomerProceed();
			
			}if(driver.getCurrentUrl().contains(urlBajaj)){
				Alert confirmationAlert = driver.switchTo().alert();
				Thread.sleep(5000);
				confirmationAlert.accept();
				String url = driver.getCurrentUrl();
				System.out.println(url);
				Thread.sleep(8000);
				driver.navigate().to(urlquotes);
				}else{
			String url = driver.getCurrentUrl();
			System.out.println(url);
			Thread.sleep(8000);
			driver.navigate().to(urlquotes);
			Thread.sleep(8000);
			for (int j = 0; j < 1; j++) {
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
			datafile = new UIMap(workingDir + "\\Resources\\investmentdatafile.properties");

			// Get the object map file
			uimap = new UIMap(workingDir + "\\Resources\\investmentlocator.properties");
			extent = ExtentManager.GetExtentInvestment();

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
			FileOutputStream out = new FileOutputStream(new File("InvestmentTestNGResultToExcel.xls"));
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
		InvestmentSendMail.execute("InvestmentExtentReport.html");
	}

	/*@AfterMethod
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
	}*/
	
	/*@AfterMethod(alwaysRun = true)
	public void catchExceptions(ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = result.getName();
		if (!result.isSuccess()) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File((String)PathConverter.convert("failure_screenshots/" + methodName + "_" + formater.format(calendar.getTime()) + ".png")));
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
