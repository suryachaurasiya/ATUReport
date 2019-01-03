package com.health;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReligareProposal {
/*Pop-up*/	
	@FindBy(xpath="//input[@ng-model='usermobile']")
	private WebElement popUp;
	@FindBy(xpath="//span[text()='Submit']")
	private WebElement submitBtn;
/*Proposer Details*/	
	@FindBy(xpath="//md-select-value[@id='select_value_label_78']")
	private WebElement salutation;
	@FindBy(xpath="//input[@id='input_99']")
	private WebElement firstNameTxtField;
	@FindBy(xpath="//input[@id='input_100']")
	private WebElement lastNameTxtField;
	@FindBy(xpath="//input[@id='input_101']")
	private WebElement emailTxtField;
	@FindBy(xpath="//input[@id='input_102']")
	private WebElement mobileTxtField;
	@FindBy(xpath="(//span[text()='Save & Continue'])[1]")
	private WebElement saveAndContinue;
/*Member Details*/
	@FindBy(xpath="//span[text()='Please Select']")
	private WebElement profession;
	
  public ReligareProposal(WebDriver driver){
	  PageFactory.initElements(driver, this);
  }
  public void enterProposarDetails(WebDriver driver){
//	  salutation.click();
//	  driver.findElement(By.xpath("//md-option[@id='select_option_169']")).click();
//	  firstNameTxtField.clear();
//	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	  firstNameTxtField.sendKeys("mnop");
//	  lastNameTxtField.clear();
//	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	  lastNameTxtField.sendKeys("pqrs");
//	  emailTxtField.clear();
//	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	  emailTxtField.sendKeys("religare@ep.com");
//	  mobileTxtField.clear();
//	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	  mobileTxtField.sendKeys("7838272731");
	  saveAndContinue.click();
  }
  public void enterPopupDetail(WebDriver driver){
	 popUp.clear();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 popUp.sendKeys("7838272731");
	 submitBtn.click();
  }
  public void enterMemberDetails(WebDriver driver){
	  profession.click();
	  driver.findElement(By.xpath("(//div[text()='Private Service'])[2]")).click();
	  driver.findElement(By.xpath("(//span[text()='Save & Continue'])[4]")).click();
  }
}
