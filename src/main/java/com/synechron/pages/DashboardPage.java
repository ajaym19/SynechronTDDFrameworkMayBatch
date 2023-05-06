package com.synechron.pages;

import org.openqa.selenium.By;

import com.synechron.base.TestBase;

public class DashboardPage extends TestBase {

	public boolean timeWorkSectionPresence() {
		return driver.findElement(By.xpath("//p[text()='Time at Work']")).isDisplayed();
	}
}
