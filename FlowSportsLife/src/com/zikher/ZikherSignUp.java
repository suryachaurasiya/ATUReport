package com.zikher;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ZikherSignUp {
	WebDriver driver;
@Test(priority=1)
public void zikherSignUp() throws InterruptedException {
	driver=new FirefoxDriver();
//	System.setProperty("webdriver.chrome.driver", "D:\\surya\\FlowSportsLife\\exefiles\\chromedriver.exe");
//	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo1.zikher.com");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()='OK']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[text()='Sign up']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()='OK']")).click();
	driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("surya");
	driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("prakash");
	driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9807039528");
	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("93mbps@gmail.com");
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("qwerty_123");
	driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys("qwerty_123");
	driver.findElement(By.xpath("//input[@id='tnc']")).click();
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.close();
}
@Test(priority=2)
public void verification() throws InterruptedException {
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.google.com/gmail/about/");
	driver.findElement(By.xpath("//a[text()='Sign In']")).click();
	driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("93mbps@gmail.com");
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("9693671011");
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	Thread.sleep(6000);
	driver.findElement(By.xpath("(//span[text()='info@zikher.com'])[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()='Verify your account']")).click();
	Set<String> browserWins = driver.getWindowHandles();
	Iterator<String> it = browserWins.iterator();
	String parentID = it.next();
	String childID = it.next();
	System.out.println(parentID);
	System.out.println(childID);
	driver.switchTo().window(childID);
   }
}

