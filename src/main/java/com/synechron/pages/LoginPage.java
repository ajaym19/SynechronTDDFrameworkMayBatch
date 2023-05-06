package com.synechron.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.synechron.base.TestBase;

public class LoginPage extends TestBase {
	

	public String getTitle() {
		String acttitle =  driver.getTitle();
		return acttitle;
	}
	
	public void login() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		captureScreenshot("login");
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
	}
	

}
