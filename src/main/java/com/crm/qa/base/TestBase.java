package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop; 
	public static WebDriverEventListener  listner;
	public  static EventFiringWebDriver e_driver;
	public TestBase(){
		
		prop = new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//crm//qa//config//config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void intilizationMethod() {
		
		String BrowserName = prop.getProperty("browser");
		
		if (BrowserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lalitha\\Desktop\\PanduAutomation\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if (BrowserName.equalsIgnoreCase("chrome")) {
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		//listner = new WebDriverEventListener(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		listner = new WebEventListener();
		e_driver.register(listner);
		driver = e_driver;
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	
}
