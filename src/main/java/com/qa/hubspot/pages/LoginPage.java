package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	//1 define pagefactory (page elements -- Object repository)
	//1.a create a constructor of page class and initialize the page elements with driver
	//2 actions -- methods
	
	@FindBy(id = "username")
	WebElement loginName;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "loginBtn")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a/i18n-string[text()= 'Forgot my password']")
	WebElement forgotPassword;
	
	@FindBy(xpath = "//a/i18n-string[text()= 'Forgot my password']")
	WebElement signupLinkText;
	
	@FindBy(xpath = "//span[text()= 'Show Password']")
	WebElement forotPassword;
	
	@FindBy(className = "buttonText")
	WebElement buttonText;
	
	@FindBy(xpath = "//button/i18n-string[text()= 'Log in with SSO']")
    WebElement signWithSSO;
	
	@FindBy(xpath = "//footer/i18n-string[text()= 'All Rights Reserved.']")
	WebElement allRightsReservedText;
	
	@FindBy(xpath = "//a/i18n-string[text()= 'Privacy Policy']")
	WebElement privacyPolicy;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getloginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyforgotMyPasswordLink()
	{
		return forgotPassword.isDisplayed();
	}
	
	public HomePage doLogin(String username , String pwd)
	{
		loginName.sendKeys(username);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage(driver);
	}
	
	public boolean verifySignupLinkText()
	{
		 return signupLinkText.isDisplayed();
	}
    
	public boolean forgotPassword()
	{
		 return forgotPassword.isDisplayed();
	}
	
	public String signwithGoogle()
	{
		return buttonText.getText();
	}
	
	public String signWithSSO()
	{
		return signWithSSO.getText();
	}
	
	public String allRightsReservedText()
	{
		return allRightsReservedText.getText();
	}
	
	public boolean verifyprivacyPolicyText()
	{
		return privacyPolicy.isDisplayed();
	}
	
	
	
	
}
