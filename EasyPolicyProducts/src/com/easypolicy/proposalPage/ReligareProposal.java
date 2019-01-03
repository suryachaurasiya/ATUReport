package com.easypolicy.proposalPage;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.easypolicy.generic.ExtentManager;
import com.easypolicy.generic.UIMap;

public class ReligareProposal {
	ExtentHtmlReporter htmlReporter;
	Map<String, Object[]> TestNGResults;
	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	public UIMap uimap;
	public UIMap datafile;
	public String workingDir;
	public void proposerDetailsNameField() throws Exception {
		try {
			
			test = extent.createTest("Enter religare proposer name", "Proposaer name should be enter");
			test.assignCategory("Religare Proposal");
			driver.findElement(uimap.getLocator("Name1")).sendKeys(datafile.getData("Proposer_first_name"));
			if (driver.getTitle().contains("Easypolicy - Proposal")) {
				test.pass(driver.getTitle() + " contain " + "Easypolicy - Proposal");	
			}
			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Easypolicy - Proposal");	
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}
	}
		
	
	public void religareProposalEmailField() throws Exception {

		try {
			test = extent.createTest("Enter religare proposer email", "Proposer email should be enter");
			test.assignCategory("Religare Proposal");
			driver.findElement(uimap.getLocator("Email1")).sendKeys(datafile.getData("Proposer_emailid"));
			if (driver.getTitle().contains("Easypolicy - Proposal")) {
				test.pass(driver.getTitle() + " contain " + "Easypolicy - Proposal");
				
			}
			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Easypolicy - Proposal");	
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}
	}
	
	public void clickOnSubmitBtn() throws Exception {

		try {
			test = extent.createTest("Click on religare submit Button", "Submit button should be clicked");	
			test.assignCategory("Religare Proposal");
			driver.findElement(uimap.getLocator("Submit1")).click();
			if (driver.getTitle().contains("Easypolicy - Proposal")) {
				test.pass(driver.getTitle() + " contain " + "Easypolicy - Proposal");
				//test.log(Status.PASS, datafile.getData("CustomerEmailId")+" Input Is Correct");
				//test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./2.jpg"));
				//test.log(Status.INFO, test.addScreenCapture(ExtentManager.this(driver, "./Send")));
				
			}
			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Easypolicy - Proposal");	
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}
			
	}
	
	public void selectSalutation() throws Exception {

		try {
			test = extent.createTest("Click on religare salutation", "salutation should be selected");
			test.assignCategory("Religare Proposal");
			WebElement salut = driver.findElement(uimap.getLocator("Salutation1"));
			salut.sendKeys(datafile.getData("SalutionProposar"));
//		    driver.findElement(uimap.getLocator("Click_Salutation_Mr1")).click();
			if (driver.getTitle().equals("Easypolicy - Proposal")) {
				test.pass(driver.getTitle() + " contain " + "Easypolicy - Proposal");
				//test.log(Status.PASS, datafile.getData("CustomerEmailId")+" Input Is Correct");
				//test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./2.jpg"));
				//test.log(Status.INFO, test.addScreenCapture(ExtentManager.this(driver, "./Send")));
				
			}
			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Easypolicy - Proposal");	
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}
			
			
	}
	
	public void lastName() throws Exception {
		try {
			test = extent.createTest("Fill religare last name", "last name should be filled");
			test.assignCategory("Religare Proposal");
			WebElement mobileno = driver.findElement(uimap.getLocator("LastName1"));
			Thread.sleep(2000);
			mobileno.sendKeys(datafile.getData("Proposer_last_name"));
			if (datafile.getData("Proposer_last_name").equals("kumar")) {
				test.pass(datafile.getData("Proposer_last_name") + " is " + "kumar");
			} else
				test.log(Status.FAIL, datafile.getData("Proposer_last_name") + " is not " + "kumar");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}
	}
	
	public void proposerDetailsSaveandContinue() throws Exception {

		try {
			test = extent.createTest("Click on Save & Continue Button", "Button should be clicked");
			test.assignCategory("Religare Proposal");
			WebElement savencontinue = driver.findElement(uimap.getLocator("clickOnSaveAndContinue"));
			savencontinue.click();
		
			if (driver.getTitle().contains("Easypolicy - Proposal")) {
				test.pass(driver.getTitle() + " contain " + "Easypolicy - Proposal");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Easypolicy - Proposal");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			
		}
	}
	
	public void address1() throws Exception {

		try {
			test = extent.createTest("Enter value in religare address text box1", "Address1 should be filled");
			test.assignCategory("Religare Proposal");
			WebElement pincode = driver.findElement(uimap.getLocator("Address1_text_field1"));
			pincode.clear();
			pincode.sendKeys(datafile.getData("Addressline1"));
			
			if (datafile.getData("Addressline1").equals("testing, newdelhi")) {
				test.pass(datafile.getData("Addressline1") + " is " + "correct");
			} else
				test.log(Status.FAIL, datafile.getData("Addressline1") + " is not " + "correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			
		}
	}
	public void address2() throws Exception {

		try {
			test = extent.createTest("Enter value in religare address text box2", "Address2 should be filled");
			test.assignCategory("Religare Proposal");
			WebElement pincode = driver.findElement(uimap.getLocator("Address1_text_field2"));
			pincode.clear();
			pincode.sendKeys(datafile.getData("Addressline2"));
			if (datafile.getData("Addressline2").equals("testing, newdelhi")) {
				test.pass(datafile.getData("Addressline2") + " is " + "correct");
			} else
				test.log(Status.FAIL, datafile.getData("Addressline2") + " is not " + "correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			
		}
	}
	public void pincode() throws Exception {

		try {
			test = extent.createTest("Enter valu in religare pincode box", "pincode should be filled");
			test.assignCategory("Religare Proposal");
			WebElement pincode = driver.findElement(uimap.getLocator("Pincode_text_field1"));
			pincode.clear();
			pincode.sendKeys(datafile.getData("Pincode"));
			
			if (datafile.getData("Pincode").equals("110092")) {
				test.pass(datafile.getData("Pincode") + " is " + "correct");
			} else
				test.log(Status.FAIL, datafile.getData("Pincode") + " is not " + "correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			
		}
	}
	
	public void ProposerSaveandContinue() throws Exception {

		try {
			test = extent.createTest("Click on Save & Continue Button", "Button should be clicked");
			test.assignCategory("Religare Proposal");
			WebElement savencontinue = driver.findElement(uimap.getLocator("Proposer_SaveandContinue_button1"));
			savencontinue.click();
		
			if (driver.getTitle().contains("Easypolicy - Proposal")) {
				test.pass(driver.getTitle() + " contain " + "Easypolicy - Proposal");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Easypolicy - Proposal");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			
		}
	}
	
	public void Profession() throws Exception {

		try {
			test = extent.createTest("Select & fill Profession", "Profession should be selected");
			test.assignCategory("Religare Proposal");
			WebElement profession = driver.findElement(uimap.getLocator("Profession_DropDown_field1"));
			profession.sendKeys(datafile.getData("Proposer_profession"));
//			WebElement professionSelect = driver.findElement(uimap.getLocator("Profession_click1"));
//			professionSelect.click();
			
			if (datafile.getData("Profession_click").equals("Private Service")) {
				test.pass(datafile.getData("Profession_click") + " is " + "correct");
			} else
				test.log(Status.FAIL, datafile.getData("Profession_click") + " is not " + "correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}
	}
	
	public void MaritalStatus() throws Exception {

		try {
			test = extent.createTest("Select marital status from drop down", "Marital status should be selected");
			WebElement maritalstatus = driver.findElement(uimap.getLocator("MaritalStatus_Dropdown_field1"));
			maritalstatus.sendKeys(datafile.getData("Marital_status_adult"));
//			WebElement maritalstatusSelect  = driver.findElement(uimap.getLocator("Maritalstatus_click1"));
//			maritalstatusSelect.click();
			if (datafile.getData("Maritalstatus_click").equals("testing, newdelhi")) {
				test.pass(datafile.getData("Maritalstatus_click") + " is " + "correct");
			} else
				test.log(Status.FAIL, datafile.getData("Maritalstatus_click") + " is not " + "correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}
	}
	public void AdultWeight() throws Exception {

		try {
			test = extent.createTest("Fill Adult Weight in input box", "Weight should be filled");
			test.assignCategory("Religare Proposal");
			WebElement adultweight = driver.findElement(uimap.getLocator("Weight_text_field1"));
			adultweight.clear();
			adultweight.sendKeys(datafile.getData("Weight_adult"));
		
			if (datafile.getData("Weight_adult").equals("68")) {
				test.pass(datafile.getData("Weight_adult") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Weight_adult") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		
		}
	}
	
	public void AdultHeightFeet() throws Exception {

		try {
			test = extent.createTest("Fill Adult Height from dropdown", "Adult Height In Feet should be filled");
			test.assignCategory("Religare Proposal");
			WebElement adultheight = driver.findElement(uimap.getLocator("Height_Dropdown_feet1"));
			adultheight.sendKeys(datafile.getData("Height_feet_adult"));
//			driver.findElement(uimap.getLocator("height_Feet_click1")).click();
		
			if (datafile.getData("Height_feet_adult").equals("5")) {
				test.pass(datafile.getData("Height_feet_adult") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Height_feet_adult") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		
		}
	}
	
	public void AdultHeightInches() throws Exception {

		try {
			test = extent.createTest("Fill Adult Height from dropdown", "Adult Height In inches should be filled");
			test.assignCategory("Religare Proposal");
			WebElement adultheightinches = driver.findElement(uimap.getLocator("Height_Dropdown_inches1"));
			adultheightinches.sendKeys(datafile.getData("Height_inches_adult"));
//	        driver.findElement(uimap.getLocator("height_Inches_click1")).click();
	
			if (datafile.getData("Height_inches_adult").equals("8")) {
				test.pass(datafile.getData("Height_inches_adult") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Height_inches_adult") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		
		}
	}
	
	public void AdultSaveandContinue() throws Exception {

		try {
			test = extent.createTest("Click on Save & Continue Button", "Button should be clicked");
			test.assignCategory("Religare Proposal");
			WebElement savencontinue = driver.findElement(uimap.getLocator("Member_SaveAndContinue_Btn1"));
			savencontinue.click();
		    if (driver.getTitle().contains("Easypolicy")) {
				test.pass(driver.getTitle() + " contain " + "Easypolicy");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Easypolicy");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			
		}
	}
	public void MedicalHistory() throws Exception {

		try {
			test = extent.createTest("Click Radio button in Medical History section", "Radio button should be clicked");
			test.assignCategory("Religare Proposal");
			WebElement questionone = driver.findElement(uimap.getLocator("MedicalHistory_question_one_no1"));
			questionone.click();
			WebElement questiontwo = driver.findElement(uimap.getLocator("MedicalHistory_question_two_no1"));
			questiontwo.click();
			WebElement questionthree = driver.findElement(uimap.getLocator("MedicalHistory_question_three_no1 "));
			questionthree.click();
			WebElement questionFour = driver.findElement(uimap.getLocator("MedicalHistory_question_four_no1"));
			questionFour.click();
			WebElement questionFive = driver.findElement(uimap.getLocator("MedicalHistory_question_five_no1 "));
			questionFive.click();
			if (driver.getTitle().contains("Health Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Health Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}
	}
	
	public void MedicalHistorySaveAndContinue() throws Exception {

		try {
			test = extent.createTest("Click Save & Continue in Medical History section", "button should be clicked");
			test.assignCategory("Religare Proposal");
			WebElement MedicalHistorySaveandContinue = driver.findElement(uimap.getLocator("Medical_SaveAndContinue_Btn1"));
			MedicalHistorySaveandContinue.click();
			if (driver.getTitle().contains("Health Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Health Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			}
	}
	
	public void NomineeSalutation() throws Exception {

		try {
			test = extent.createTest("Nominee salutation", "Nominee salutation clicked");
			test.assignCategory("Religare Proposal");
			WebElement nomineename = driver.findElement(uimap.getLocator("Nominee_Relation_dropdown1"));
			nomineename.click();
			WebElement nomineename1 = driver.findElement(uimap.getLocator("nominee_click1"));
			nomineename1.click();
			if (driver.getTitle().equals("Easypolicy - Proposal")) {
				test.pass(driver.getTitle() + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL,driver.getTitle() + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			}
	}
	
	
	public void NomineeName() throws Exception {

		try {
			test = extent.createTest("Fill Nominee Name in Input Box", "Nominee Name should be filled");
			test.assignCategory("Religare Proposal");
			WebElement nomineename = driver.findElement(uimap.getLocator("Nomineename_text_field1"));
			nomineename.clear();
			nomineename.sendKeys(datafile.getData("Nominee_name"));
			if (datafile.getData("Nominee_name").equals("qa")) {
				test.pass(datafile.getData("Nominee_name") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Nominee_name") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			}
	}
	
	public void NomineeRelation() throws Exception {

		try {
			test = extent.createTest("Fill Nominee Relation From Dropdown Box", "Nominee Relation should be filled");
			test.assignCategory("Religare Proposal");
			WebElement nomineerelation = driver.findElement(uimap.getLocator("Nominee_Relation_dropdown1"));
			nomineerelation.sendKeys(datafile.getData("Nominee_relation"));
//			driver.findElement(uimap.getLocator("nominee_click1")).click();
			if (datafile.getData("Nominee_relation").equals("Brother")) {
				test.pass(datafile.getData("Nominee_relation") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Nominee_relation") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			}
	}
	public void saveAndContinue() throws Exception {

		try {
			test = extent.createTest("Click on save and continue", "Button should be clicked");
			test.assignCategory("Religare Proposal");
			WebElement saveAndCont = driver.findElement(uimap.getLocator("Save_And_Continue1"));
			saveAndCont.click();
			if (driver.getTitle().contains("Health Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Health Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			}
	}
	
	public void proceedToPayment() throws Exception {

		try {
			test = extent.createTest("Click on proceed to payment", "Button should be clicked");
			test.assignCategory("Religare Proposal");
			WebElement ProceedToPaymentbutton = driver.findElement(uimap.getLocator("Proceed_To_Payment1"));
			ProceedToPaymentbutton.click();
			if (driver.getTitle().contains("Health Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Health Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");


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
