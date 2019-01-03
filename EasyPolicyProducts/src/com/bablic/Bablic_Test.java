package com.bablic;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class Bablic_Test {
	
WebDriver driver;

@Test
public void bablicEasypolicy() throws InterruptedException, FindFailed {
	
		System.setProperty("webdriver.chrome.driver", "D:\\surya\\FlowSportsLife\\exefiles\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
//		driver=new FirefoxDriver();
		driver.get("https://www.bablic.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='login' and text()='Log In']")).click();
//		Thread.sleep(3000);
		driver.findElement(By.xpath("(//p[text()='Email:']/following-sibling::input[@name='email'])[2]")).sendKeys("himanshu.jain@easypolicy.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//p[text()='Password:']/following-sibling::input[@name='password'])[2]")).sendKeys("Easypolicy@101");
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Visual Editor']")).click();
		Thread.sleep(10000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//div[contains(text(),'स्वास्थ्य')])[3]")).click();
        driver.findElement(By.xpath("(//input[@placeholder='डीडी'])[1]")).sendKeys("05");
        driver.findElement(By.xpath("(//input[@placeholder='मिमी'])[1]")).sendKeys("07");
        driver.findElement(By.xpath("(//input[@placeholder='yyyy'])[1]")).sendKeys("1991");
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//input[contains(@aria-label,'Type and select')])[3]")).sendKeys("new delhi");
        driver.findElement(By.xpath("//span[contains(text(),'Delhi')]")).click();
        driver.findElement(By.xpath("(//input[@ng-model='usermobile'])[5]")).sendKeys("9807039528");
        driver.findElement(By.xpath("//button[contains(@ng-click,'gethealthquotespop')]")).click();
}
}
