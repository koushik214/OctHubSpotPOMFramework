package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class LoginTest {
	
	/*@BeforeMethod
	@Test
	@AfterMethod
	
	*/
	
	public WebDriver driver;
	public BasePage basePage;
	public Properties prop;
	public LoginPage loginPage;
	
	@BeforeMethod
	public void setUp()
	{    
		basePage = new BasePage();
	   driver =  basePage.init_driver();
	   prop =  basePage.init_Prop();
	   driver.get(prop.getProperty("url"));
	   loginPage = new LoginPage(driver);
	}
	
	
	@Test(priority = 1)
	public void  verifyLoginPageTitleTest()
	{
		String title = loginPage.getloginPageTitle();
		System.out.println("login page title is " +title);
		Assert.assertEquals(title, Constants.Login_Page_Title);
	}
	
	@Test(priority = 2)
	public void verifyForgotasswordLinkTest()
	{
		Assert.assertTrue(loginPage.verifyforgotMyPasswordLink());
	}
	
	@Test(priority= 3)
	public void signUpLinkText()
	{
		Assert.assertTrue(loginPage.verifySignupLinkText());
	}
	
	@Test(priority =4)
	public void forgotPasswordLinkTest()
	{
		Assert.assertTrue(loginPage.forgotPassword());
	}	
	
	@Test(priority = 5)
	public void verifySignWithGoogletest()
	{
		String text = loginPage.signwithGoogle();
		System.out.println(text);
		Assert.assertEquals(text, Constants.Signup_With_Google);
	}
	
	@Test(priority = 6)
	public void signWithSSOTest() 
	{
		String ssoText = loginPage.signWithSSO();
		System.out.println(ssoText);
		Assert.assertEquals(ssoText, Constants.Signup_With_SSO);
	}
	
	@Test(priority = 7)
	public void allRightsReservedTest()
	{
		String allRightsReserved = loginPage.allRightsReservedText();
		System.out.println(allRightsReserved);
		Assert.assertEquals(allRightsReserved, Constants.All_Rights_Reserved);
	}
	
	@Test(priority= 8)
	public void privacyPolicyTest()
	{
		Assert.assertTrue(loginPage.verifyprivacyPolicyText());
	}
		
	@Test(priority = 9)	
	public void loginTest()
	{
		loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
	
	@AfterMethod
	public void tearDowm()
	{
		driver.quit();
	}
	
	

}
