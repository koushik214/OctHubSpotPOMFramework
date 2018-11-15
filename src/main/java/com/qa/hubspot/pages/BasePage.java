package com.qa.hubspot.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.hubspot.util.Constants;

public class BasePage {
	
	public WebDriver  driver;
	public Properties prop;
	
	public WebDriver init_driver()
	{
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(Constants.Page_Load_TimeOut, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		return driver;
	}
	
	public Properties init_Prop()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("D:/javaautomation/FrameworkPOM/src/main/java/com/qa/hubspot/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
	

}
