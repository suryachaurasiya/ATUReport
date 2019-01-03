package com.flowSportsLife;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.genric.BaseLib;

public class FlowSportsLife extends BaseLib{

	@Test
	public void flowSportData() throws InterruptedException {
//		WebDriver driver=new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver", "D:\\surya\\FlowSportsLife\\exefiles\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://app.flowsportslife.com/#/registration");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@role='checkbox']")).click();
		driver.findElement(By.xpath("//p[text()='LOG-IN WITH GOOGLE']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Set<String> browserWins = driver.getWindowHandles();
		Iterator<String> it = browserWins.iterator();
		String parentID = it.next();
		System.out.println(parentID);
		String childID = it.next();
		System.out.println(childID);
		
		driver.switchTo().window(childID);
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("demoyadav39");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("niitmt@123");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@jsname='Njthtb']")).click();
		
		
		
		driver.switchTo().window(parentID);
		
		WebElement court = driver.findElement(By.xpath("//button[contains(@class,'borderedButtonCurveTextBlue button button-md button-default')]"));
		court.click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[contains(text(),'Find Players')]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'10')]/..")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement time = driver.findElement(By.xpath("//p[text()='10:00']/../.."));
		time.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[contains(text(),'SELECT CO-PLAYERS')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Aadish']/../../..")).click();
	}
}
