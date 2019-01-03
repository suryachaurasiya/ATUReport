package com.script;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.health.CignaProposal;
import com.health.ReligareProposal;


public class CignaTest {
  @Test
  public void cignaJourney() throws Exception{
    WebDriver driver = new FirefoxDriver();  
//	  System.setProperty("webdriver.chrome.driver", "D:\\surya\\EasyPolicy\\exefiles\\chromedriver.exe");
//	  WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.easypolicy.com/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("(//a[text()='Health'])[1]")).click();
	driver.findElement(By.id("Tel4")).sendKeys("02");
	driver.findElement(By.id("Tel5")).sendKeys("05");
	driver.findElement(By.id("Tel6")).sendKeys("1986");
	driver.findElement(By.xpath("//input[contains(@aria-label,'City..')]")).sendKeys("New Delhi");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(text(),'Delhi')]")).click();
	driver.findElement(By.xpath("//input[@placeholder='Enter Mobile No.']")).sendKeys("7838272731");
	driver.findElement(By.xpath("//span[contains(text(),'Quotes')]")).click();
	Thread.sleep(10000);
//	driver.findElement(By.id("txtProposerName")).sendKeys("qa");
//	driver.findElement(By.id("txtEmailID")).sendKeys("qa@ep.com");
//	driver.findElement(By.id("txtMobileNumber")).sendKeys("6789678967");
//	driver.findElement(By.xpath("//p[text()='Proceed']")).click();
//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Thread.sleep(5000);
	String txt = driver.findElement(By.xpath("//div[@class='cardbox Com-box Com-box1']")).getText();
	System.out.println(txt);
	
	List<WebElement> cigna1 = driver.findElements(By.xpath("//span[text()='BUY NOW']"));
	String winScroll = "window.scrollBy(0,250)";
	RemoteWebDriver rwd=(RemoteWebDriver)driver;
	for (int i = 1; i <=cigna1.size()-19; i++) {
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//span[text()='BUY NOW'])["+i+"]")).click();
		Thread.sleep(10000);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Thread.sleep(5000);
		if(i==6){
			driver.findElement(By.id("txtProposerName")).sendKeys("qa");
			driver.findElement(By.xpath("//button[contains(@aria-label,'Proceed')]")).click();
			Thread.sleep(5000);
		    CignaProposal cp=new CignaProposal(driver);
		    cp.clearProposerFields();
		    Thread.sleep(5000);
		    cp.enterProposarDetail(driver);
		    Thread.sleep(3000);
		    cp.clearCommAddrField();
		    Thread.sleep(2000);
		    cp.commAddrsDetails();
		    cp.clickOnSaveAndContinue();
		    Thread.sleep(3000);
		    cp.memberDetails(driver);
		    Thread.sleep(3000);
		    cp.clickOnRadioBtns();
		    Thread.sleep(3000);
		    cp.nomineeDetails(driver);
			
		}if(i==3){
			ReligareProposal rp=new ReligareProposal(driver);
			rp.enterPopupDetail(driver);
			Thread.sleep(3000);
			rp.enterProposarDetails(driver);
			Thread.sleep(3000);
			rp.enterMemberDetails(driver);
		}
		driver.navigate().to("https://www.easypolicy.com/Application/Health?CPID=MjczNTA1Ng&instantleadpop=2");
		
		for (int j = 0; j < 1; j++) {
			Thread.sleep(1000);
			rwd.executeScript(winScroll);
		}
		driver.navigate().back();
		Thread.sleep(3000);
		WebElement buyNow = driver.findElement(By.xpath("(//h5[text()='ProHealth Plus']/../../../../..//span[text()='BUY NOW'])[1]"));
	    buyNow.click();	
	    break;
	}
	
//	driver.findElement(By.id("txtProposerName")).sendKeys("qa");
//	driver.findElement(By.xpath("//button[contains(@aria-label,'Proceed')]")).click();
//	Thread.sleep(5000);
//    CignaProposal cp=new CignaProposal(driver);
//    cp.clearProposerFields();
//    cp.enterProposarDetail(driver);
//    cp.clearCommAddrField();
//    Thread.sleep(2000);
//    cp.commAddrsDetails();
//    cp.clickOnSaveAndContinue();
//    Thread.sleep(3000);
//    cp.memberDetails(driver);
//    Thread.sleep(3000);
//    cp.clickOnRadioBtns();
//    Thread.sleep(3000);
//    cp.nomineeDetails(driver);
//    Thread.sleep(3000);
//    driver.navigate().to("https://www.easypolicy.com/Application/Health?CPID=MjczNTA1Ng&instantleadpop=2");
    }
  
}
