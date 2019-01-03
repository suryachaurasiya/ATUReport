package com.zikher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.sun.org.apache.xml.internal.resolver.readers.TR9401CatalogReader;

public class ZikherTest {
	WebDriver driver;
@Test
public void zikherSignUp() throws InterruptedException {
	driver=new FirefoxDriver();
//	System.setProperty("webdriver.chrome.driver", "D:\\surya\\FlowSportsLife\\exefiles\\chromedriver.exe");
//	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo1.zikher.com");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()='OK']")).click();
	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Shalinianandd91@gmail.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("zikher234");
	driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//i[@class='icon icon-nav-profile']")).click();
	driver.findElement(By.xpath("//div[text()='Personal Information']/following-sibling::div[text()='Edit']")).click();
	driver.findElement(By.xpath("//div[contains(text(),'Select')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[text()='Single']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@placeholder='Search address...']")).sendKeys("Indirapuram");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='ssn']")).sendKeys("123456789");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='street']")).sendKeys("shipraMall");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Noida");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Uttar Pradesh");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("20130");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[text()='Save']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[text()='OK']")).click();
 }
}