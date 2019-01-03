package com.easypolicy.script;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.easypolicy.generic.BaseLib;

public class HomePageTest extends BaseLib {
	// Open Easypolicy Website
			@Test(description = "Open Easypolicy Website for health Product Journey", priority = 1)
			public void LaunchWebsite() throws Exception {

				try {
					test = extent.createTest("Open URL, Navigate to website", "Easypolicy Website should be open");
					if (driver.getTitle().contains("Easypolicy")) {
						test.pass(driver.getTitle() + " contains " + "Easypolicy");
					}
					else
						test.log(Status.FAIL, driver.getTitle() + " doesn't contain " + "Easypolicy");
						test.fail("screenshot").addScreenCaptureFromPath("1.png");
				} catch (Exception e) {
					test.log(Status.ERROR, e.getMessage());
				
				}
			}

}
