package com.easypolicy.generic;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	public static void implicitWaitForSecond(WebDriver driver, int duration){
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}
	public static void implicitWaitForMinutes(WebDriver driver, int duration){
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.MINUTES);
	}
	public static void explicitWaitForClickable(WebDriver driver, int time, WebElement element){
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void explicitWaitForVisibility(WebDriver driver, int time, WebElement element){
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
	public void scrollDownUsingBy(WebDriver driver){
		String scrollBy="window.scrollBy(0,500)";
		RemoteWebDriver rwd=(RemoteWebDriver) driver;
		rwd.executeScript(scrollBy);
	}
	public void scrollDownUsingTo(WebDriver driver){
		String scrollTo="window.scrollBy(0,document.body.scrollHeight)";
		JavascriptExecutor je=(JavascriptExecutor) driver;
		je.executeScript(scrollTo);
	}
	public void windowHandlesParent(WebDriver driver){
		Set<String> browserWins = driver.getWindowHandles();
		Iterator<String> it = browserWins.iterator();
		String parentID = it.next();
		String childID = it.next();
		System.out.println(parentID);
		System.out.println(childID);
		driver.switchTo().window(childID);
	}
	public void windowHandlesChild(WebDriver driver){
		Set<String> browserWins = driver.getWindowHandles();
		Iterator<String> it = browserWins.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(parentID);
	}
	public void switchToParentFrame(WebDriver driver){
		driver.switchTo().parentFrame();
	}
	public void switchToDefaultContent(WebDriver driver){
		driver.switchTo().defaultContent();
	}
	public void switchToFrame(WebDriver driver, String frameName){
		driver.switchTo().frame(frameName);
	}
}
