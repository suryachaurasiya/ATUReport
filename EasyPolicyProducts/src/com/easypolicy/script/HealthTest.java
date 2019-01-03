package com.easypolicy.script;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.easypolicy.customerpopup.CustomerPopup;
import com.easypolicy.generic.BaseLib;
import com.easypolicy.generic.LocatorHandler;
import com.easypolicy.generic.WebDriverCommonLib;
import com.easypolicy.proposalPage.CignaProposal;
import com.easypolicy.proposalPage.ReligareProposal;

import org.openqa.selenium.remote.RemoteWebDriver;


public class HealthTest extends BaseLib {

		// Click on Health Product link
		@Test(description = "Click on Health product link and fill the details", priority = 2)
		public void FillLoginDetails() {
        driver.manage().deleteAllCookies();
			try {
				test = extent.createTest("Click on Health Link on top bar", "Health product page should be open with form");
				driver.findElement(uimap.getLocator("compareAndBuy")).click();
				if (driver.getCurrentUrl().equals("health insurance")) {
					test.pass(driver.getCurrentUrl() + " contain " + "health insurance");
				} else
					test.log(Status.FAIL, driver.getCurrentUrl() + " doesn't contain " + "Health Insurance");
			
			
				test = extent.createTest("Click on Health Link on top bar", "Health product page should be open with form");
				driver.findElement(uimap.getLocator("Health_Offline")).click();
				if (driver.getCurrentUrl().equals("health insurance")) {
					test.pass(driver.getCurrentUrl() + " contain " + "health insurance");
				} else
					test.log(Status.FAIL, driver.getCurrentUrl() + " doesn't contain " + "Health Insurance");
				
				
				test = extent.createTest("Enter value 2 for adults", "Value in numbers");
				WebElement adultNo = driver.findElement(uimap.getLocator("adult_text_fieldFor_1"));
				adultNo.click();
//				adultNo.sendKeys(datafile.getData("adultTwo"));
				if (uimap.getLocator("adult_text_fieldFor_1").equals("1")) {
					test.pass(datafile.getData("adultTwo").equals("1") + " equals " + "1");
				} else
					test.log(Status.FAIL, uimap.getLocator("adult_text_fieldFor_2").equals("2") + " doesn't equals " + "2");
				
				
				test = extent.createTest("Enter value 1 for Child", "Value in numbers");
				WebElement childNo = driver.findElement(uimap.getLocator("child_text_fieldFor_0"));
				childNo.click();
//				childNo.sendKeys(datafile.getData("ChildOne"));
				if (uimap.getLocator("child_text_fieldFor_0").equals("0")) {
					test.pass(datafile.getData("ChildOne") + " equal " + "Zero");
				} else
					test.log(Status.FAIL, uimap.getLocator("child_text_fieldFor_1").equals("1") + "does not equal " + "one");
				
				
				test = extent.createTest("Enter value for DOB", "Value in numbers");
				WebElement DOBdate = driver.findElement(uimap.getLocator("DOB_text_fieldD"));
				DOBdate.clear();
				DOBdate.sendKeys(datafile.getData("DOBD"));
				WebElement DOBmonth = driver.findElement(uimap.getLocator("DOB_text_fieldM"));
				DOBmonth.clear();
				DOBmonth.sendKeys(datafile.getData("DOBM"));
				WebElement DOByear = driver.findElement(uimap.getLocator("DOB_text_fieldY"));
				DOByear.clear();
				DOByear.sendKeys(datafile.getData("DOBY"));
				if (driver.getTitle().contains("Health Insurance")) {
					test.pass(driver.getTitle() + " contain " + "Health Insurance");
				} else
					test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Health Insurance");
				
				
				test = extent.createTest("Select eldest member gender", "Value in numbers");
				WebElement gender = driver.findElement(uimap.getLocator("Gender_male"));
				gender.click();
				if (datafile.getData("Elder_member_gender").equals("male")) {
					test.pass(datafile.getData("Elder_member_gender") + " equal " + "male");
				} else
					test.log(Status.FAIL, datafile.getData("Elder_member_gender") + " doesn't equal " + "Female");

				
				test = extent.createTest("Select City From the List", "select by enter text");
				driver.findElement(uimap.getLocator("city_Compare")).sendKeys(datafile.getData("City"));
				WebElement clickOnCity = driver.findElement(uimap.getLocator("Click_city"));
				clickOnCity.click();
				if (datafile.getData("City").equals("New Delhi, Delhi")) {
					test.pass(datafile.getData("City") + " equal " + "New Delhi, Delhi");
				} else
					test.log(Status.FAIL, datafile.getData("City") + " doesn't equal " + "New Delhi, Delhi");
				
				
//				test = extent.createTest("Insert mobile no in mobile no input box", "Input mobile number");
//				driver.findElement(uimap.getLocator("User_MobileNo")).sendKeys(datafile.getData("MobileNo"));
//				if (datafile.getData("MobileNo").equals("9873008200")) {
//					test.pass(datafile.getData("MobileNo") + " equal " + "9873008200");
//				} else
//					test.log(Status.FAIL, datafile.getData("MobileNo") + " doesn't equal " + "9873008200");
				
				Thread.sleep(5000);
				test = extent.createTest("Click get live quotes button");
				driver.findElement(uimap.getLocator("Click_GetLiveQuotes_Compare")).click();
				if (driver.getTitle().contains("Health Insurance")) {
					test.pass(driver.getTitle() + " contain " + "Health Insurance");
				} else
					test.log(Status.FAIL, driver.getTitle() + " contain " + "Easypolicy");
				Thread.sleep(8000);
				String url = driver.getCurrentUrl();
				driver.findElement(By.xpath("(//span[text()='BUY NOW'])[1]")).click();
				Thread.sleep(6000);
				CustomerPopup cpp=new CustomerPopup();
				cpp.driver = driver;
				cpp.uimap = uimap;
				cpp.datafile = datafile;
				cpp.workingDir = workingDir;
				cpp.suiteSetUp();
				cpp.customerPopup();
				Thread.sleep(5000);
				driver.navigate().to(url);
			
				test = extent.createTest("Click on Buy Now Button","Button Should be clicked");
				Thread.sleep(1000);
				String winScroll = "window.scrollBy(0,200)";
				RemoteWebDriver rwd=(RemoteWebDriver)driver;
				Thread.sleep(5000);
				List<WebElement> buyNow = driver.findElements(By.xpath("//span[contains(text(),'BUY NOW')]"));
				for (int i = 2; i <=buyNow.size(); i++) {
					WebElement btnClick = driver.findElement(By.xpath("(//span[contains(text(),'BUY NOW')])["+i+"]"));
//					Thread.sleep(5000);
					btnClick.click();
					Thread.sleep(8000);
					String url1 = driver.getCurrentUrl();
					System.out.println(url1);
	
				if (i==3||i==7) {
						CignaProposal cp=new CignaProposal();
						cp.driver = driver;
						cp.uimap = uimap;
						cp.datafile = datafile;
						cp.workingDir = workingDir;
						cp.suiteSetUp();
						Thread.sleep(5000);
						cp.proposerDetailsNameField();		
						cp.cignaProposalEmailField();
						cp.clickOnSubmitBtn();
						Thread.sleep(3000);
						cp.selectSalutation();
						cp.lastName();
						cp.Profession();
						cp.MaritalStatus();
						cp.qualification();
						cp.clickOnSaveAndContinue();
						Thread.sleep(3000);
						cp.address1();
						cp.address2();
						cp.pincode();
						cp.ProposerSaveandContinue();
						Thread.sleep(3000);
//						cp.AdultMaritalStatus();
						cp.AdultWeight();
						cp.AdultHeightFeet();
						cp.AdultHeightInches();
						cp.AdultSaveandContinue();
						Thread.sleep(3000);
						cp.MedicalHistory();
						cp.MedicalHistorySaveAndContinue();
						Thread.sleep(3000);
						cp.NomineeName();
						cp.NomineeRelation();
						cp.saveAndContinue();
						Thread.sleep(3000);
						cp.proceedToPayment();
						Thread.sleep(10000);
					
					}else if(i==4||i==6){
						ReligareProposal rp=new ReligareProposal();
						rp.driver = driver;
						rp.uimap = uimap;
						rp.datafile = datafile;
						rp.workingDir = workingDir;
						rp.suiteSetUp();
						Thread.sleep(3000);
						rp.proposerDetailsNameField();
						rp.religareProposalEmailField();
						rp.clickOnSubmitBtn();
						Thread.sleep(3000);
						rp.selectSalutation();
						rp.lastName();
						rp.proposerDetailsSaveandContinue();
						Thread.sleep(3000);
						rp.address1();
						rp.address2();
						rp.pincode();
						rp.ProposerSaveandContinue();
						Thread.sleep(3000);
						rp.Profession();
						rp.MaritalStatus();
						rp.AdultWeight();
						rp.AdultHeightFeet();
						rp.AdultHeightInches();
						rp.AdultSaveandContinue();
						Thread.sleep(3000);
						rp.MedicalHistory();
						rp.MedicalHistorySaveAndContinue();
						Thread.sleep(3000);
//						rp.NomineeSalutation();
						rp.NomineeName();
						rp.NomineeRelation();
						rp.saveAndContinue();
						Thread.sleep(3000);
						rp.proceedToPayment();
						Thread.sleep(10000);
					}
					Thread.sleep(5000);
					driver.navigate().to(url);
					for (int j = 0; j<i; j++) {
						Thread.sleep(1000);
						rwd.executeScript(winScroll);
					}
				}
					
					if (driver.getTitle().equals("Easypolicy - Health Insurance")) {
						test.pass(driver.getTitle() + " contain " + "Easypolicy - Health Insurance");
					} else
						test.log(Status.FAIL, driver.getTitle() + "doesn't contain " + "Easypolicy - Health Insurance");
			
				
			} catch (Exception e) {
				test.log(Status.ERROR, e.getMessage());
				
			}
			
			
		}

}
