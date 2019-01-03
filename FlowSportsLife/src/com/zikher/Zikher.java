package com.zikher;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class Zikher {
	WebDriver driver;
@Test
public void zikherSignUp() {
	driver=new FirefoxDriver();
//	System.setProperty("webdriver.chrome.driver", "D:\\surya\\FlowSportsLife\\exefiles\\chromedriver.exe");
//	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo1.zikher.com/login");
	driver.findElement(By.xpath("//input[@placeholder='Borrower Name*']")).sendKeys("abcd");
	driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("7011850676");
	driver.findElement(By.xpath("//div[text()='Entity*']")).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//div[text()='Individual']")).click();
	driver.findElement(By.xpath("//input[@placeholder='Email*']")).sendKeys("abc@gmail.com");
	driver.findElement(By.xpath("//input[contains(@placeholder,'Search address')]")).sendKeys("new");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//strong[text()='New Delhi']")).click();
	driver.findElement(By.xpath("//textarea[@placeholder='Additional Comments']")).sendKeys("Hello Mr.");
	driver.findElement(By.xpath("//button[text()='Submit']")).click();
}
}
