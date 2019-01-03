package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Pages extends BasePages {
    By userId = By.id("mobileNo");
    By password = By.id("et_password");
    By login_Button = By.id("btn_mlogin");
    By existingUser_login = By.id("btn_mlogin");

    public Pages(WebDriver driver) {
        super(driver);
    }

    public Pages invalidLogin1() {
        waitForVisibilityOf(existingUser_login);
        driver.findElement(existingUser_login).click();
        driver.findElement(userId).clear();
        driver.findElement(userId).sendKeys("someone@testvagrant.com");
        driver.findElement(password).sendKeys("testvagrant123");
        driver.findElement(login_Button).click();
        Assert.assertTrue(driver.findElement(By.id("pageLevelError")).getText().equalsIgnoreCase("Account does not exist"));
        return new Pages(driver);
    }

	public void invalidLogin() {
		// TODO Auto-generated method stub
		
	}
}