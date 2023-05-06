package com.synechron.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.synechron.pages.DashboardPage;
import com.synechron.pages.LoginPage;

public class DashboardPageTest {
	
	LoginPage lp;
	DashboardPage dp;

	@BeforeMethod
	public void browserConfig() {
		lp = new LoginPage();
		lp.initialization();
	}
	
	@Test
	public void validateTimeAtWorkSection() {
		lp.login();
		dp = new DashboardPage();
		Assert.assertTrue(dp.timeWorkSectionPresence());
		
	}
	
	@AfterMethod
	public void closeSetup() {
		lp.tearDown();
	}
}
