package com.zikher;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GetLendTech1 {

	WebDriver driver;

	@Test(enabled = false)
	public void getLendTech() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\surya\\FlowSportsLife\\exefiles\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://web.dev.getlendtech.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("tristyn+superlo@getlendtech.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("test123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='/received']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Type name of borrower to search']")).sendKeys("shalini");
		driver.findElement(By.xpath("//select[@placeholder='Loan Type']")).click();
		driver.findElement(By.xpath("//option[text()='Purchase']")).click();
		driver.findElement(By.xpath("//select[@placeholder='Status']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//option[text()='Incomplete']")).click();
		driver.findElement(By.xpath("(//button[text()='Incomplete'])[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Requested Transaction Terms']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Borrower Information']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Guarantor Profile Information']")).click();
		String winScroll = "window.scrollBy(0,150)";
		RemoteWebDriver rwd = (RemoteWebDriver) driver;
		rwd.executeScript(winScroll);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Assign Application']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//option[text()='None']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//option[text()='Andy Loan Officer']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Confirm Assignment']")).click();
	}

	@Test(alwaysRun = true)
	public void changePassword() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\surya\\FlowSportsLife\\exefiles\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://web.dev.getlendtech.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("tristyn+superlo@getlendtech.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("test123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("(//a[@href='/settings'])[1]")).click();
		driver.findElement(By.xpath("//input[@name='oldPassword']")).sendKeys("test123");
		driver.findElement(By.xpath("//input[@name='newPassword']")).sendKeys("shalini123");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("shalini123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
	}
}
