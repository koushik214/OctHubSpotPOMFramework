package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {
	
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	
	@BeforeMethod
	public void setUp() 
	{
		basePage = new BasePage();
		driver = basePage.init_driver();
		prop = basePage.init_Prop();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test(priority= 1)
	public void verifyHomePageTitleTest()
	{
		String title = homePage.getHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.Home_Page_Title);
	}
	
	@Test(priority = 2)
	public void verifyHomePageHeaderTest()
	{
		String header = homePage.verifyhomePageHeader();
		System.out.println(header);
		Assert.assertEquals(header, Constants.Home_Page_Header);
	}
	
	@Test(priority = 3)
	public void verifyAccountLoggedInNameTest()
	{
		String accountName = homePage.verifyaccountName();
		System.out.println(accountName);
		Assert.assertEquals(accountName, prop.getProperty("accountname"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
