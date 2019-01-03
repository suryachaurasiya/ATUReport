package com.easypolicy.proposalPage;



import java.util.Map;

import org.openqa.selenium.By;
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

public class CignaProposal {
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
			
			test = extent.createTest("Enter proposer name", "Proposaer name should be enter");
			test.assignCategory("Cigna Proposal");
			WebElement name = driver.findElement(uimap.getLocator("Name"));
			name.clear();
			name.sendKeys(datafile.getData("Proposer_first_name"));
			if (driver.getTitle().contains("Easypolicy - Proposal")) {
				test.pass(driver.getTitle() + " contain " + "Easypolicy - Proposal");	
			}
			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Easypolicy - Proposal");	
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}
	}
		
	
	public void cignaProposalEmailField() throws Exception {

		try {
			test = extent.createTest("Enter proposer email", "Proposer email should be enter");
			test.assignCategory("Cigna Proposal");
			WebElement email = driver.findElement(uimap.getLocator("Email"));
			email.clear();
			email.sendKeys(datafile.getData("Proposer_emailid"));
			if (driver.getTitle().contains("Easypolicy - Proposal")) {
				test.pass(driver.getTitle() + " contain " + "Easypolicy - Proposal");
				
			}
			else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Easypolicy - Proposal");	
		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}
	}
	
	public void cignaProposalPhoneField() throws Exception {

		try {
			test = extent.createTest("Enter proposer mobile no", "Proposer mobile no. should be enter");
			test.assignCategory("Cigna Proposal");
			WebElement mobile = driver.findElement(uimap.getLocator("mobile_no"));
			mobile.clear();
			mobile.sendKeys(datafile.getData("Proposer_mobileno"));
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
			test = extent.createTest("Click on submit Button", "Submit button should be clicked");	
			test.assignCategory("Cigna Proposal");
			driver.findElement(uimap.getLocator("Submit")).click();
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
			test = extent.createTest("Click on salutation", "salutation should be selected");
			test.assignCategory("Cigna Proposal");
			driver.findElement(uimap.getLocator("Salutation")).click();
		    driver.findElement(uimap.getLocator("Click_Salutation_Mr")).click();
			Thread.sleep(1000);
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
			test = extent.createTest("Fill last name", "last name should be filled");
			test.assignCategory("Cigna Proposal");
			WebElement mobileno = driver.findElement(uimap.getLocator("LastName"));
			mobileno.sendKeys(datafile.getData("Proposer_last_name"));
			Thread.sleep(1000);
			if (datafile.getData("Proposer_last_name").equals("kumar")) {
				test.pass(datafile.getData("Proposer_last_name") + " is " + "kumar");
			} else
				test.log(Status.FAIL, datafile.getData("Proposer_last_name") + " is not " + "kumar");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}
	}
	
	public void Profession() throws Exception {

		try {
			test = extent.createTest("Select & fill Profession", "Profession should be selected");
			test.assignCategory("Cigna Proposal");
			WebElement profession = driver.findElement(uimap.getLocator("Profession_DropDown_field"));
			profession.click();
			WebElement professionSelect = driver.findElement(uimap.getLocator("Profession_click"));
			professionSelect.click();
			Thread.sleep(1000);
			
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
			test.assignCategory("Cigna Proposal");
			WebElement maritalStatus = driver.findElement(uimap.getLocator("MaritalStatus_Dropdown_field"));
			maritalStatus.sendKeys(datafile.getData("Proposer_marital_status"));
//			driver.findElement(uimap.getLocator("Maritalstatus_click")).click();
			Thread.sleep(1000);
			if (datafile.getData("Maritalstatus_click").equals("testing, newdelhi")) {
				test.pass(datafile.getData("Maritalstatus_click") + " is " + "correct");
			} else
				test.log(Status.FAIL, datafile.getData("Maritalstatus_click") + " is not " + "correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}
	}
	
	public void qualification() throws Exception {

		try {
			test = extent.createTest("Qualification", "Qualification selected");
			test.assignCategory("Cigna Proposal");
			WebElement qualification = driver.findElement(uimap.getLocator("Qualification_Dropdown"));
			qualification.click();
			WebElement qualification1 = driver.findElement(uimap.getLocator("Qualification_click"));
			qualification1.click();
			Thread.sleep(1000);
			if (datafile.getData("Qualification_click").equals("testing, class X")) {
				test.pass(datafile.getData("Qualification_click") + " is " + "correct");
			} else
				test.log(Status.FAIL, datafile.getData("Qualification_click") + " is not " + "correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		}
	}
	
	public void clickOnSaveAndContinue() throws Exception {

		try {
			test = extent.createTest("Click on save and continue", "Btn should be clicked");
			test.assignCategory("Cigna Proposal");
			WebElement address2 = driver.findElement(uimap.getLocator("clickOn_Save&Continue"));
			address2.click();
			if (driver.getTitle().equals("testing, Easypolicy - Proposal")) {
				test.pass(driver.getTitle() + " is " + "correct");
			} else
				test.log(Status.FAIL, driver.getTitle() + " is not " + "correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			
		}
	}
	
	public void address1() throws Exception {

		try {
			test = extent.createTest("Enter value in address text box", "Address1 should be filled");
			test.assignCategory("Cigna Proposal");
			WebElement pincode = driver.findElement(uimap.getLocator("Address_text_field1"));
			pincode.clear();
			pincode.sendKeys(datafile.getData("Addressline1"));
			Thread.sleep(1000);
			
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
			test = extent.createTest("Enter value in address text box", "Address2 should be filled");
			test.assignCategory("Cigna Proposal");
			WebElement pincode = driver.findElement(uimap.getLocator("Address_text_field2"));
			pincode.clear();
			pincode.sendKeys(datafile.getData("Addressline2"));
			Thread.sleep(1000);
			
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
			test = extent.createTest("Enter valu in pincode box", "pincode should be filled");
			test.assignCategory("Cigna Proposal");
			WebElement pincode = driver.findElement(uimap.getLocator("Pincode_text_field"));
			pincode.clear();
			pincode.sendKeys(datafile.getData("Pincode"));
			Thread.sleep(1000);
			
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
			test.assignCategory("Cigna Proposal");
			WebElement savencontinue = driver.findElement(uimap.getLocator("Proposer_SaveandContinue_button"));
			savencontinue.click();
			Thread.sleep(1000);
		
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
	
	public void AdultMaritalStatus() throws Exception {

		try {
			test = extent.createTest("Fill Adult Marital status from drop down", "Marital Status should be filled");
			test.assignCategory("Cigna Proposal");
			WebElement maritalstatusadult = driver.findElement(uimap.getLocator("MaritalStatus_Child"));
			maritalstatusadult.sendKeys(datafile.getData("Marital_status_adult"));
			driver.findElement(uimap.getLocator("MaritalStatus_click")).click();
			if (driver.getTitle().equals("Easypolicy - Proposal")) {
				test.pass(driver.getTitle() + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, driver.getTitle() + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
		
		}
	}
	
	public void AdultWeight() throws Exception {

		try {
			test = extent.createTest("Fill Adult Weight in input box", "Weight should be filled");
			test.assignCategory("Cigna Proposal");
			WebElement adultweight = driver.findElement(uimap.getLocator("Weight_text_field"));
			adultweight.clear();
			adultweight.sendKeys(datafile.getData("Weight_adult"));
			Thread.sleep(1000);
		
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
			test.assignCategory("Cigna Proposal");
			WebElement adultheight = driver.findElement(uimap.getLocator("Height_Dropdown_feet"));
			adultheight.sendKeys(datafile.getData("Height_feet_adult"));
//			driver.findElement(uimap.getLocator("height_Feet_click")).click();
			Thread.sleep(1000);
		
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
			test.assignCategory("Cigna Proposal");
			WebElement adultheightinches = driver.findElement(uimap.getLocator("Height_Dropdown_inches"));
			adultheightinches.sendKeys(datafile.getData("Height_inches_adult"));
//	        driver.findElement(uimap.getLocator("height_Inches_click")).click();
			Thread.sleep(1000);
	
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
			test.assignCategory("Cigna Proposal");
			WebElement savencontinue = driver.findElement(uimap.getLocator("Member_SaveAndContinue_Btn"));
			savencontinue.click();
			Thread.sleep(1000);
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
	
	public void ChildSalutation() throws Exception {

		try {
			test = extent.createTest("Fill Child Salutation from dropdown", "Child Salutation should be filled");
			test.assignCategory("Cigna Proposal");
			WebElement childsalutation = driver.findElement(uimap.getLocator("Child_salution_dropdown"));
			childsalutation.sendKeys(datafile.getData("Salution_child"));
			Thread.sleep(1000);
		
			if (datafile.getData("Salution_child").equals("Mr.")) {
				test.pass(datafile.getData("Salution_child") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Salution_child") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			
		}
	}
	
	public void ChildFirstName() throws Exception {

		try {
			test = extent.createTest("Fill Child First Name In Input Box", "Child First Name should be filled");
			test.assignCategory("Cigna Proposal");
			WebElement childfirstname = driver.findElement(uimap.getLocator("Child_Firstname_text_field"));
			childfirstname.sendKeys(datafile.getData("Firstname_child"));
			Thread.sleep(1000);
			
			if (datafile.getData("Firstname_child").equals("satvik")) {
				test.pass(datafile.getData("Firstname_child") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Firstname_child") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			
		}
	}
	
	public void ChildLastName() throws Exception {

		try {
			test = extent.createTest("Fill Child Last Name In Input Box", "Child Last Name should be filled");
			test.assignCategory("Cigna Proposal");
			WebElement childlastname = driver.findElement(uimap.getLocator("Child_Lastname_text_field"));
			childlastname.sendKeys(datafile.getData("Lastname_child"));
			Thread.sleep(1000);
			
			if (datafile.getData("Lastname_child").equals("Kumar")) {
				test.pass(datafile.getData("Lastname_child") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Lastname_child") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			
		}
	}
	
	public void ChildDOB() throws Exception {

		try {
			test = extent.createTest("Enter value for DOB", "Value in numbers");
			test.assignCategory("Cigna Proposal");
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
		    if (driver.getTitle().contains("Health Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Health Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			}
	}
	
	public void ChildWeight() throws Exception {

		try {
			test = extent.createTest("Fill Child Weight in input box", "Weight should be filled");
			test.assignCategory("Cigna Proposal");
			WebElement childweight = driver.findElement(uimap.getLocator("Child_weight_text_field"));
			childweight.sendKeys(datafile.getData("Weight_Child"));
			Thread.sleep(1000);
			if (datafile.getData("Weight_Child").equals("20")) {
				test.pass(datafile.getData("Weight_Child") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Weight_Child") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			}
	}
	
	public void ChildHeightFeet() throws Exception {

		try {
			test = extent.createTest("Fill Child Height from dropdown", "Child Height In Feet should be filled");
			test.assignCategory("Cigna Proposal");
			WebElement childhieghtfeet = driver.findElement(uimap.getLocator("Child_height_feet"));
			childhieghtfeet.sendKeys(datafile.getData("Height_feet_child"));
			Thread.sleep(1000);
				if (datafile.getData("Height_feet_child").equals("2")) {
				test.pass(datafile.getData("Height_feet_child") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Height_feet_child") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			}
	}
	
	public void ChildHeightInches() throws Exception {

		try {
			test = extent.createTest("Fill Child Height from dropdown", "Child Height In inches should be filled");
			test.assignCategory("Cigna Proposal");
			WebElement childheightinches = driver.findElement(uimap.getLocator("Child_height_inches"));
			childheightinches.sendKeys(datafile.getData("Height_inches_child"));
			Thread.sleep(1000);
			if (datafile.getData("Height_inches_child").equals("10")) {
				test.pass(datafile.getData("Height_inches_child") + " is " + "Correct");
				test.log(Status.INFO, "Snapshot" + test.addScreenCaptureFromPath("./1.jpg"));
			}

			else
				test.log(Status.FAIL, datafile.getData("Height_inches_child") + " is not " + "Correct");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			}
	}
	
	public void MemberSaveAndContinue() throws Exception {

		try {
			test = extent.createTest("Click Save & continue button in member Details section", "Button should be clicked");
			test.assignCategory("Cigna Proposal");
			WebElement membersavendcontinue = driver.findElement(uimap.getLocator("Memberdetails_saveandcontinue_button"));
			membersavendcontinue.click();
			Thread.sleep(1000);
			if (driver.getTitle().contains("Health Insurance")) {
				test.pass(driver.getTitle() + " contain " + "Health Insurance");
			} else
				test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");

		} catch (Exception e) {
			test.log(Status.ERROR, e.getMessage());
			}
	}
	
	public void MedicalHistory() throws Exception {

		try {
			test = extent.createTest("Click Radio button in Medical History section", "Radio button should be clicked");
			test.assignCategory("Cigna Proposal");
			WebElement questionone = driver.findElement(uimap.getLocator("MedicalHistory_question_one_no"));
			questionone.click();
//			Thread.sleep(1000);
			WebElement questiontwo = driver.findElement(uimap.getLocator("MedicalHistory_question_two_no"));
			questiontwo.click();
//			Thread.sleep(1000);
			WebElement questionthree = driver.findElement(uimap.getLocator("MedicalHistory_question_three_no "));
			questionthree.click();
//			Thread.sleep(1000);
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
			WebElement MedicalHistorySaveandContinue = driver.findElement(uimap.getLocator("Medical_SaveAndContinue_Btn"));
			MedicalHistorySaveandContinue.click();
			Thread.sleep(1000);
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
			test.assignCategory("Cigna Proposal");
			WebElement nomineename = driver.findElement(uimap.getLocator("Nominee_Relation_dropdown"));
			nomineename.click();
			WebElement nomineename1 = driver.findElement(uimap.getLocator("nominee_click"));
			nomineename1.click();
			Thread.sleep(1000);
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
			test.assignCategory("Cigna Proposal");
			WebElement nomineename = driver.findElement(uimap.getLocator("Nomineename_text_field"));
			nomineename.clear();
			nomineename.sendKeys(datafile.getData("Nominee_name"));
			Thread.sleep(1000);
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
			test.assignCategory("Cigna Proposal");
			WebElement nomineerelation = driver.findElement(uimap.getLocator("Nominee_Relation_dropdown"));
			nomineerelation.sendKeys(datafile.getData("Nominee_relation"));
//			driver.findElement(uimap.getLocator("nominee_click")).click();
			Thread.sleep(1000);
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
			test.assignCategory("Cigna Proposal");
			WebElement saveAndCont = driver.findElement(uimap.getLocator("Save_And_Continue"));
			saveAndCont.click();
			Thread.sleep(1000);
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
			test.assignCategory("Cigna Proposal");
			WebElement ProceedToPaymentbutton = driver.findElement(uimap.getLocator("Proceed_To_Payment"));
			ProceedToPaymentbutton.click();
			Thread.sleep(1000);
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
