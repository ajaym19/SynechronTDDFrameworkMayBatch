package com.synechron.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.synechron.pages.LoginPage;

public class LoginPageTest {

	LoginPage lp;
	
	@BeforeMethod
	public void browserConfig() {
		lp = new LoginPage();
		lp.initialization();
	}
	
	@Test
	public void validateTitle() {
		String acttitle = lp.getTitle();
		String exptitle = "OrangeHRM";
		Assert.assertEquals(acttitle, exptitle);
	}
	
	@Test
	public void validateLogin() {
		lp.login();
	}
	
	@AfterMethod
	public void closeSetup() {
		lp.tearDown();
	}
	
	
}
