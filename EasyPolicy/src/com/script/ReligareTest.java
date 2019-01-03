package com.script;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.health.ReligareProposal;

public class ReligareTest {
@Test
public void religareJourney() throws InterruptedException{
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.easypolicy.com/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	
	driver.findElement(By.xpath("//li/a[text()='Health']")).click();
	driver.findElement(By.id("Tel4")).sendKeys("02");
	driver.findElement(By.id("Tel5")).sendKeys("05");
	driver.findElement(By.id("Tel6")).sendKeys("1986");
	driver.findElement(By.xpath("//input[contains(@aria-label,'City..')]")).sendKeys("New Delhi");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(text(),'Delhi')]")).click();
	driver.findElement(By.xpath("//span[contains(text(),'Quotes')]")).click();
	driver.findElement(By.id("txtProposerName")).sendKeys("qa");
	driver.findElement(By.id("txtEmailID")).sendKeys("qa@ep.com");
	driver.findElement(By.id("txtMobileNumber")).sendKeys("6789678967");
	driver.findElement(By.xpath("//p[text()='Proceed']")).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	List<WebElement> cigna1 = driver.findElements(By.xpath("//span[text()='BUY NOW']"));
	String winScroll = "window.scrollBy(0,300)";
	RemoteWebDriver rwd=(RemoteWebDriver)driver;
	for (int i = 0; i <cigna1.size(); i++) {
		Thread.sleep(3000);
		cigna1.get(i).click();
		
		for (int j = 0; j < 3; j++) {
			Thread.sleep(1000);
			rwd.executeScript(winScroll);
		}
		driver.navigate().back();
		Thread.sleep(3000);
		WebElement buyNow = driver.findElement(By.xpath("(//h5[text()='ProHealth Plus']/../../../../..//span[text()='BUY NOW'])[1]"));
	    buyNow.click();	
	    break;
	}
	driver.findElement(By.id("txtProposerName")).sendKeys("qa");
	driver.findElement(By.xpath("//button[contains(@aria-label,'Proceed')]")).click();
	Thread.sleep(5000);
	ReligareProposal rp=new ReligareProposal(driver);
	rp.enterProposarDetails(driver);
}
}
