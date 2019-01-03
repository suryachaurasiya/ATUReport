package com.zikher;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GetLendTech {

	WebDriver driver;
@Test
public void getLendTech() {
	try {
		
	
	System.setProperty("webdriver.chrome.driver", "D:\\surya\\FlowSportsLife\\exefiles\\chromedriver.exe");
	driver = new ChromeDriver();
//	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://web.dev.getlendtech.com/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("customer@staging.com");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("sk123456789");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[@href='/applications']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//h4[text()='New Application']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//h3[text()='AndrewTechnologyGroup v1.0']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[text()='Start Application']")).click();
	Thread.sleep(3000);
//	driver.findElement(By.xpath("//button[contains(text(),'E-mail copy')]")).click();
	driver.findElement(By.xpath("//button[text()='Accept']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@placeholder='Interest Rate (%)']")).sendKeys("10");
	WebElement contd = driver.findElement(By.xpath("//button[text()='Continue']"));
	for (int i = 1; i <= 15; i++) {
		contd.click();
		Thread.sleep(2000);
		if(i==3) {
			driver.findElement(By.xpath("//input[@value='Construction']")).click();
		} if(i==11 && i==14 || i==15){
			driver.findElement(By.xpath("//button[text()='Finish']")).click();
		}else {
		
			System.out.println("Element not found");
		}
	}
	
	
} catch (Exception e) {
		System.out.println("Error Message : "+e.getMessage());
	}
  }
}
