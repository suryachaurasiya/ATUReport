package com.appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class learnAppiumTest {
    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "3.3.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("deviceName", "Samsung Galaxy S7");
        capabilities.setCapability("app", "D:\\surya\\AppiumTestRun\\src\\test\\resources\\apps\\Flipkart Online Shopping App_v6.3_apkpure.com.apk");
        capabilities.setCapability("appPackage", "com.pages.android");
        capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}