package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		intilizationMethod();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitileTest() {
		String actualtitle =loginpage.validatePageTitle();
		Assert.assertEquals(actualtitle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmlogoImageTest() {
		Assert.assertTrue(loginpage.validateCRMLogo());
	}
	
	@Test(priority=3)
	public void loginTest() {
		homepage=loginpage.login();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
