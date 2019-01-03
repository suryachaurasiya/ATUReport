package com.sikuliTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EasyPolicyTest {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://uat.easypolicy.com:8989/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[contains(text(),'Health')])[3]")).click();
		driver.findElement(By.xpath("(//input[@placeholder='dd'])[1]")).sendKeys("05");
        driver.findElement(By.xpath("(//input[@placeholder='mm'])[1]")).sendKeys("07");
        driver.findElement(By.xpath("(//input[@placeholder='yyyy'])[1]")).sendKeys("1991");
        driver.findElement(By.xpath("(//input[contains(@aria-label,'Type and select')])[3]")).sendKeys("new delhi");
        driver.findElement(By.xpath("//span[contains(text(),'Delhi')]")).click();
        driver.findElement(By.xpath("(//input[@ng-model='usermobile'])[5]")).sendKeys("9807039528");
        driver.findElement(By.xpath("//button[contains(@ng-click,'gethealthquotespop')]")).click();
        Thread.sleep(3000);
        for (int i = 0; i <=100; i++) {
        	  driver.navigate().refresh();
		}
	}
}
