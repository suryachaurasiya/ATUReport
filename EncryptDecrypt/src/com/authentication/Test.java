package com.authentication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test{
	public static String Password = null;
	public static WebDriver driver = null;
public static void main(String[] args) throws Exception{
    Unfold de =new Unfold();
    CardDetails cardData =  SqlConnection.getCardDetails();
    CardDetails cardData1 = StrSplit.splitStr();
//    System.out.println("Decrypted word is : " +   cardData.getPassword());
    driver=new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get("https://www.easypolicy.com/");
    Thread.sleep(3000);
    driver.findElement(By.xpath("(//div[contains(text(),'Health')])[3]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("(//input[@ng-model='usermobile'])[4]")).sendKeys(cardData1.getCardNumber1());
  }
}