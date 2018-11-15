package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class ContactsPageTest{
	
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;
	
	@BeforeMethod
	public void setUp() 
	{
		basePage = new BasePage();
		driver = basePage.init_driver();
		prop = basePage.init_Prop();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickonContactsPage();
		
	}
	
	@Test
	public void getContactsPageTitleTest()
	{
		String text = contactsPage.getContactsPageTitle();
		System.out.println(text);
		Assert.assertEquals(text, Constants.Contacts_Page_Title);
	}
	
	@Test
	public void getContactsPageHeaderTest()
	{
		String headerText = contactsPage.getContactsPageHeader();
		System.out.println(headerText);
		Assert.assertEquals(headerText, Constants.Contacts_Page_Header);
	}
	
	@Test
	public void createContactsTest() throws InterruptedException
	{
		contactsPage.createContact(prop.getProperty("emailtextfiled"), prop.getProperty("firstname"), prop.getProperty("lastname"));
	}
	
	@AfterMethod	
	public void tearDown()
	{
		//driver.quit();
	}
	
	
	

}
