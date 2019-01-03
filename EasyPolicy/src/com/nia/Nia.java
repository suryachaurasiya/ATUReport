package com.nia;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Nia {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://b2b.newindia.co.in/omnidocs/integration/foldView/viewDocsMain.jsp?Application=IIMSONLINE&FolderName=31130031170100000383&DocumentIdToView");
		driver.switchTo().frame("frametop");
		driver.findElement(By.xpath("//a[@id='283071704']")).click();
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("framebottom");
		driver.switchTo().frame("innerFrame");
		driver.findElement(By.xpath("//button[@id='download']")).click();
//		try {
//			Runtime.getRuntime().exec(".\\exefiles\\moto.exe");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		Robot r=new Robot();
		r.mouseMove(760, 480);
		Thread.sleep(3000);
		r.mousePress(InputEvent.BUTTON1_MASK); 
		r.mouseRelease(InputEvent.BUTTON1_MASK);

	}

}



