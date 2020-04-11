package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		intilizationMethod();
		 loginpage=new LoginPage();
		homepage=loginpage.login();
	}
	
	@Test
	public void verifyTitle() {
		String actual = homepage.verifyHomePageTitle();
		Assert.assertEquals(actual, "crmd","Title not mathced");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
