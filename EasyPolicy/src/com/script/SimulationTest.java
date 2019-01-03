package com.script;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.health.CignaProposal;
import com.health.UIMap;

public class SimulationTest {
@Test(dataProvider="verify",dataProviderClass=UIMap.class)
public void simulation(String salutation, String firstName,String lastName,String emailID, String mobileNo, String profession,
		               String maritalStatus, String addrLine1, String addrLine2, String city, String pinCode, String childDOBDate,
		               String childDOBMnth, String childDOBYer, String maritalStatusChild, String weight, String heightFeet,
		               String heightInches, String medicalHstry1, String medicalHstry2, String medicalHstry3, String nomineeName, String nomineeRelation  
		               ) throws Exception {
	UIMap uimapLocator=new UIMap("D:\\surya\\EasyPolicy\\locator.properties");
	UIMap uimapData=new UIMap("D:\\surya\\EasyPolicy\\datafile.properties");
//	
//	for (int i = 1; i <=30; i++) {
//         for (int j = 0; j <23; j++) {
//        	 String data=UIMap.readData("Sheet1", i, j);
//        		System.out.print(data+"\t");
//            }
//         System.out.println("");
//	   }
    WebDriver driver=new FirefoxDriver();
    driver.manage().window().maximize();
 	driver.get("https://www.easypolicy.com/");
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	driver.findElement(uimapLocator.getLocator("health_product")).click();
 	driver.findElement(uimapLocator.getLocator("DOB_text_fieldD")).sendKeys(uimapData.getData("DOBD"));
 	driver.findElement(uimapLocator.getLocator("DOB_text_fieldM")).sendKeys(uimapData.getData("DOBM"));
 	driver.findElement(uimapLocator.getLocator("DOB_text_fieldY")).sendKeys(uimapData.getData("DOBY"));
 	driver.findElement(uimapLocator.getLocator("City_Input")).sendKeys(uimapData.getData("City"));
 	
 	driver.findElement(uimapLocator.getLocator("Click_city")).click();
 	driver.findElement(uimapLocator.getLocator("Click_GetLiveQuotes")).click();
 	driver.findElement(uimapLocator.getLocator("Customer_Name")).sendKeys(uimapData.getData("Customername"));
 	driver.findElement(uimapLocator.getLocator("Customer_Email")).sendKeys(uimapData.getData("CustomerEmailId"));
 	driver.findElement(uimapLocator.getLocator("Customer_Number")).sendKeys(uimapData.getData("CustomerMobileNo"));
 	driver.findElement(uimapLocator.getLocator("Click_Proceed_Button")).click();
    Thread.sleep(3000);
 	driver.findElement(By.xpath("(//h5[text()='ProHealth Plus']/../../../..//span[text()='BUY NOW'])[1]")).click();
 	CignaProposal cp=new CignaProposal(driver);
 	cp.clearProposerFields();
 	cp.clearCommAddrField();
 	
 	driver.findElement(uimapLocator.getLocator("Salution")).sendKeys(salutation);
 	driver.findElement(uimapLocator.getLocator("FirstName_text_field")).sendKeys(firstName);
 	driver.findElement(uimapLocator.getLocator("LastName_text_field")).sendKeys(lastName);
 	driver.findElement(uimapLocator.getLocator("EmailID_text_field")).sendKeys(emailID);
 	driver.findElement(uimapLocator.getLocator("MobileNo_Input_field")).sendKeys(mobileNo);
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	driver.findElement(uimapLocator.getLocator("Profession_DropDown_field")).click();
 	Thread.sleep(3000);
// 	WebElement txt = driver.findElement(By.xpath("//md-select-menu[@class='ng-scope _md-overflow']//div[text()='"+profession+"']"));
// 	txt.click();
 	List<WebElement> txt = driver.findElements(By.xpath("//md-select-menu[contains(@class,'_md-overflow')]//div[text()='"+profession+"']"));
	int txt1 = txt.size();
	System.out.println(txt1);
	Random r=new Random();
	WebElement Check;    
	for(int i = 0; i < txt1; i++)
	{
	    Check = txt.get(r.nextInt(txt1));
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    if(Check.isDisplayed())
	    {
	    	Thread.sleep(3000);
	        Check.click();
	    }
	}
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	driver.findElement(uimapLocator.getLocator("MaritalStatus_Dropdown_field")).sendKeys(maritalStatus);
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	driver.findElement(uimapLocator.getLocator("Address_text_field1")).sendKeys(addrLine1);
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	driver.findElement(uimapLocator.getLocator("Address_text_field2")).sendKeys(addrLine2);
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	driver.findElement(uimapLocator.getLocator("Pincode_text_field")).sendKeys(pinCode);
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	WebElement doubleClick = driver.findElement(uimapLocator.getLocator("Proposer_SaveandContinue_button"));
 	Actions act=new Actions(driver);
 	act.doubleClick(doubleClick).perform();
 
 	WebElement day = driver.findElement(uimapLocator.getLocator("Child_DOB_Day"));
 	day.clear();
 	day.sendKeys(childDOBDate);
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	WebElement month = driver.findElement(uimapLocator.getLocator("Child_DOB_Month"));
 	month.clear();
 	month.sendKeys(childDOBMnth);
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	WebElement year = driver.findElement(uimapLocator.getLocator("Child_DOB_Year"));
 	year.clear();
 	year.sendKeys(childDOBYer);
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	WebElement status = driver.findElement(uimapLocator.getLocator("MaritalStatus_Child"));
 	status.sendKeys(maritalStatusChild);
 	cp.clearMembrDtails();
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	driver.findElement(uimapLocator.getLocator("Weight_text_field")).sendKeys(weight);
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	driver.findElement(uimapLocator.getLocator("Height_Dropdown_feet")).click();
 	if(Integer.parseInt(heightFeet)<=5){
 	driver.findElement(By.xpath("//md-option[@ng-repeat='item in feetarray']/div[text()='"+heightFeet+"']")).click();
 	}else if(Integer.parseInt(heightFeet)>5){
 		driver.findElement(By.xpath("//md-option[@ng-repeat='item in feetarray']/div[text()='"+heightFeet+"']")).click();
 	}
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	driver.findElement(uimapLocator.getLocator("Height_Dropdown_inches")).click();
 	if(Integer.parseInt(heightInches)<=4){
 	driver.findElement(By.xpath("//md-option[@ng-repeat='item in incharray']/div[text()='"+heightInches+"']")).click();
 	}else if(Integer.parseInt(heightInches)>4){
 		driver.findElement(By.xpath("//md-option[@ng-repeat='item in incharray']/div[text()='"+heightInches+"']")).click();
 	}
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	driver.findElement(uimapLocator.getLocator("Member_SaveAndContinue_Btn")).click();
 	
// 	driver.findElement(uimapLocator.getLocator("MedicalHistory_question_one_no")).click();
// 	driver.findElement(uimapLocator.getLocator("MedicalHistory_question_two_no")).click();
// 	driver.findElement(uimapLocator.getLocator("MedicalHistory_question_three_yes")).click();
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	driver.findElement(By.xpath("(//md-radio-button[@aria-label='"+medicalHstry1+"']//div[@class='_md-off'])[3]")).click();
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	driver.findElement(By.xpath("(//md-radio-button[@aria-label='"+medicalHstry2+"']//div[@class='_md-off'])[5]")).click();
 	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 	driver.findElement(By.xpath("(//md-radio-button[@aria-label='"+medicalHstry3+"']//div[@class='_md-off'])[7]")).click();
 	driver.findElement(uimapLocator.getLocator("Medical_SaveAndContinue_Btn")).click();
 	
 	driver.findElement(uimapLocator.getLocator("Nomineename_text_field")).sendKeys(nomineeName);
 	WebElement relation = driver.findElement(uimapLocator.getLocator("Nominee_Relation_dropdown"));
 	relation.click();
 	driver.findElement(By.xpath("(//div[text()='"+nomineeRelation+"'])[2]")).click();
 	driver.findElement(uimapLocator.getLocator("ProceedTo_Paymnt_Btn")).click();
// 	String actMsg = driver.findElement(uimapLocator.getLocator("erroe_Msg")).getText();
// 	String expMsg="Enter/Select all the fields Correctly";
// 	Assert.assertEquals(actMsg, expMsg,"Test case is fail");
// 	Reporter.log("Test case is pass",true);
//  UIMap.writeDataInExcel();
 	driver.quit();
   }

}
