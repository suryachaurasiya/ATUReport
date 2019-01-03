package com.easypolicy.script;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.easypolicy.generic.BaseLib;

public class FlowSportsLife extends BaseLib{

	@Test
	public void flowSportData() {
		try {
		driver.findElement(uimap.getLocator("clickOnCheckBox")).click();
		driver.findElement(uimap.getLocator("loginWithGoogle")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Set<String> browserWins = driver.getWindowHandles();
		Iterator<String> it = browserWins.iterator();
		String parentID = it.next();
		String childID = it.next();
		System.out.println(parentID);
		System.out.println(childID);
		driver.switchTo().window(childID);
		
		driver.findElement(uimap.getLocator("userID")).sendKeys("demoyadav39");
		driver.findElement(uimap.getLocator("nextButton")).click();
		Thread.sleep(3000);
		driver.findElement(uimap.getLocator("userPass")).sendKeys("niitmt@123");
		Thread.sleep(5000);
		driver.findElement(uimap.getLocator("nextButton1")).click();
		Thread.sleep(5000);
		driver.switchTo().window(parentID);
//		driver.findElement(uimap.getLocator("bookCourt")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Book Court')]")).click();
//		Thread.sleep(5000);
		WebElement findPlayer = driver.findElement(uimap.getLocator("findPlayers"));
		findPlayer.click();
//		Thread.sleep(3000);
		driver.findElement(uimap.getLocator("date")).click();
		Thread.sleep(3000);
//		driver.findElement(uimap.getLocator("time")).click();
		driver.findElement(By.xpath("//p[contains(text(),'10:00')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(uimap.getLocator("coPlayers")).click();
		}catch (Exception e) {
//			test.log(Status.ERROR, e.getMessage());
			
		}
	}
	
}

