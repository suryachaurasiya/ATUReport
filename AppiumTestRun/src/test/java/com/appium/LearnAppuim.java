package com.appium;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.Pages;

public class LearnAppuim extends learnAppiumTest {

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void falseLoginTest() throws InterruptedException {
        new Pages(driver).invalidLogin();
    }

}