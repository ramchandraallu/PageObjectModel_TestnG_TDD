package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ConatctsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ConatctsPageTest extends TestBase{
	public LoginPage loginpage;
	public HomePage homepage;
	public ConatctsPage conatcpage;
	public TestUtil testUtil = new TestUtil();;
	public ConatctsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		intilizationMethod();
		loginpage= new LoginPage();
		homepage= new HomePage();
		
		conatcpage= new ConatctsPage();
		
		homepage=	loginpage.login();
		testUtil.switchToFrame();
		
		//conatcpage= homepage.clickOnContactsLink();
		
	}
	
//	@Test
	//public void verifyconatctsdisplayed() {	
		//Assert.assertTrue(conatcpage.verifyContactsLabel());
	//}
	
	@DataProvider()
		public Object[][] getTestdata() {
		 Object[][] obj=testUtil.getDataObject("contacts");	
		return obj;
		}
	
	
	@Test(dataProvider="getTestdata")
	public void createNewContact(String title,String firstname,String last) {
		System.out.println();
		homepage.clickOnNewContactLink();
		conatcpage.createNewContact(title,firstname, last, "test");
	}
	@AfterMethod
	public void end() {
		driver.quit();
	}
	
}
