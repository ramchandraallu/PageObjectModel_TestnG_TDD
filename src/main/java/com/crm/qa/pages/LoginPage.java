package com.crm.qa.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name="username")
	WebElement username;
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	@FindBy(xpath="//button[conatins(text(),'Sign Up']")
	WebElement signupbtn;
	@FindBy(xpath="//img[contains(@class,'img-responsive') and contains(@src,'logo.png')]")
	WebElement crmlogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo(){
		return crmlogo.isDisplayed();
	}
	
	public HomePage login() {
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginButton.click();
		return new HomePage();
	}
	
}
