package com.abc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Abc {
@Test
public void abcTest(){
	WebDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://accounts.google.com/");
}
}
