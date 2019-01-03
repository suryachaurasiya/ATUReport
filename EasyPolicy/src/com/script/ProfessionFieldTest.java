package com.script;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProfessionFieldTest {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://www.easypolicy.com/Application/Proposal/2816875");
	driver.findElement(By.xpath("//md-select[@ng-model='userprof']")).click();
	List<WebElement> txt = driver.findElements(By.xpath("//md-select-menu[contains(@class,'_md-overflow')]//div[text()='Student']"));
	int txt1 = txt.size();
	System.out.println(txt1);
	Random r=new Random();
	WebElement Check;    
	for(int i = 0; i < txt1; i++)
	{
	    Check = txt.get(r.nextInt(txt1));
	    if(Check.isDisplayed())
	    {
	    	Thread.sleep(3000);
	        Check.click();
	    }
	}
	
}
}
