package com.health;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CignaProposal {
/*Proposer Details*/
	@FindBy(xpath="//md-select[@ng-model='usersalutation']")
	private WebElement salutation;
	@FindBy(xpath="(//div[contains(text(),'Mr.')])[2]")
	private WebElement salutationClick;
	@FindBy(xpath="//input[@ng-model='userfirstName']")
	private WebElement firstNameTxtField;
	@FindBy(xpath="//input[@placeholder='Enter last name']")
	private WebElement lastNameTxtField;
	@FindBy(xpath="//input[@ng-model='useremail']")
	private WebElement emailField;
	@FindBy(xpath="//div[@ng-show='Proposaldetails']//div[text()=' Mobile No.']/..//input[@ng-model='usermobile']")
	private WebElement mblTxtField;
	@FindBy(xpath="//md-select[@ng-model='userprof']")
	private WebElement professionTxtField;
	@FindBy(xpath="//md-select[@ng-model='userMaritalStatus']")
	private WebElement maritalStatusField;
	
/*Communication Address Details*/	
	@FindBy(xpath="//input[@placeholder='Enter your Address Line 1']")
	private WebElement addrLine1TxtField;
	@FindBy(xpath="//input[@placeholder='Enter your Address Line 2']")
	private WebElement addrLine2TxtField;
	@FindBy(id="input-103")
	private WebElement cityTxtField;
	@FindBy(xpath="//input[@placeholder='Enter your pin no.']")
	private WebElement pincodeTxtField;
	@FindBy(xpath="//button[@ng-click='submitdetails(2)']/span[text()='Save & Continue']")
	private WebElement saveAndContinue;
	
/*Member Details*/	
	@FindBy(xpath="//md-select[contains(@ng-model,'memberMaritalStatus')]")
	private WebElement maritalStatus;
	@FindBy(xpath="//input[@ng-model='item.Weight']")
	private WebElement weightTxtField;
	@FindBy(xpath="//md-select[contains(@ng-model,'htFeet')]")
	private WebElement heightDrpDwn;
	@FindBy(xpath="//button[@ng-click='submitdetails(6)']/span[text()='Save & Continue']")
	private WebElement saveAndContinueMembr;
	
/*Medical History*/	
	@FindBy(xpath="(//md-radio-button[@aria-label='No']//div[@class='_md-off'])[3]")
	private WebElement firstRadioBtns;
	@FindBy(xpath="(//md-radio-button[@aria-label='No']//div[@class='_md-off'])[5]")
	private WebElement secondRadioBtns;
	@FindBy(xpath="(//md-radio-button[@aria-label='No']//div[@class='_md-off'])[7]")
	private WebElement thirdRadioBtns;
	@FindBy(xpath="//button[@ng-click='submitdetails(7)']/span[text()='Save & Continue']")
	private WebElement saveAndContinueBtnMedHis;
	
/*Nominee Details*/	
	@FindBy(xpath="//input[@ng-model='nominame']")
	private WebElement nameTxtField;
	@FindBy(xpath="//md-select[@ng-model='nomirelation']")
	private WebElement relationDrpDwn;
	@FindBy(xpath="//button[contains(@ng-show,'cashfloatflag')]//span[text()='Proceed to ']")
	private WebElement proceedToPmntBtn;
	
    public CignaProposal(WebDriver driver){
    	PageFactory.initElements(driver, this);
    }
    public void clearProposerFields(){
    	firstNameTxtField.clear();
    	lastNameTxtField.clear();
    	emailField.clear();
    	mblTxtField.clear();
    }
    public void enterProposarDetail(WebDriver driver){
    	salutation.sendKeys("Mr.");
//    	salutationClick.click();
    	firstNameTxtField.sendKeys("abcdefg");
    	lastNameTxtField.sendKeys("opqr");
    	emailField.sendKeys("cigna@gmail.com");
    	mblTxtField.sendKeys("6789678967");
    	professionTxtField.click();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//md-select-menu[@class='ng-scope _md-overflow']//div[text()='Accountant']")).click();
    	maritalStatusField.sendKeys("Single");
//    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    	driver.findElement(By.xpath("//div[contains(@class,'_md-active')]//div[text()='Single']")).click();
    }
    public void clearCommAddrField(){
    	addrLine1TxtField.clear();
    	addrLine2TxtField.clear();
    	pincodeTxtField.clear();
    }
    public void commAddrsDetails(){
    	addrLine1TxtField.sendKeys("123 -A, New Delhi");
    	addrLine2TxtField.sendKeys("New Delhi");
    	pincodeTxtField.sendKeys("110096");
    }
    public void clickOnSaveAndContinue(){
    	saveAndContinue.click();
    }
    public void clearMembrDtails(){
    	weightTxtField.clear();
    }
    public void memberDetails(WebDriver driver){
    	maritalStatus.click();
    	driver.findElement(By.xpath("//div[contains(@class,'_md-clickable')]//div[text()='Single']")).click();
//    	weightTxtField.clear();
//    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    	weightTxtField.sendKeys("62");
    	heightDrpDwn.click();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//div[contains(@class,'_md-clickable')]//md-option[@ng-repeat='item in feetarray']/div[text()='2']")).click();
    	driver.findElement(By.xpath("//md-input-container[contains(@ng-show,'Inches')]")).click();
    	driver.findElement(By.xpath("//div[contains(@class,'_md-clickable')]//md-option[@ng-repeat='item in incharray']/div[text()='2']")).click();
    	saveAndContinueMembr.click();
    }
    public void clickOnRadioBtns(){
    	firstRadioBtns.click();
    	secondRadioBtns.click();
    	thirdRadioBtns.click();
    	saveAndContinueBtnMedHis.click();
    }
    public void nomineeDetails(WebDriver driver){
    	nameTxtField.clear();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	nameTxtField.sendKeys("xyz");
    	relationDrpDwn.click();
    	driver.findElement(By.xpath("//div[contains(@class,'_md-clickable')]//md-option[@ng-repeat='item in nomineerelation']/div[text()='Brother']")).click();
    	proceedToPmntBtn.click();
    }
    
}
