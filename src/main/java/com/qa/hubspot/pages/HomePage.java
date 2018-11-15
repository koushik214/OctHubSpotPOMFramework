package com.qa.hubspot.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.util.Constants;

public class HomePage extends BasePage{
	
	@FindBy(xpath = "//h1[text() = 'Sales Dashboard']")
	WebElement homePageHeader;
	
	@FindBy(className = "account-name")
	WebElement accountName;
	

	@FindBy(xpath = "//div[@class ='desktop-nav-left-container']//a[@id ='nav-primary-contacts-branch' ]")
	WebElement primaryContacts;
	
	@FindBy(xpath = "//div[@class ='desktop-nav-left-container']//a[contains(text() , 'Contacts') and (@id = 'nav-secondary-contacts')]")
	WebElement secondaryContacts;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyhomePageHeader()
	{   
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(homePageHeader));
				
		return homePageHeader.getText();
	}
	
	public String verifyaccountName()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(accountName));
		return accountName.getText();
	}
	
	public String getHomePageTitle()
	{
		WebDriverWait wait = new WebDriverWait(driver , 20);
		wait.until(ExpectedConditions.titleIs(Constants.Home_Page_Title));
		return driver.getTitle();
	}
	
	public ContactsPage clickonContactsPage()
	{   
		WebDriverWait wait = new WebDriverWait (driver ,30);
		wait.until(ExpectedConditions.visibilityOf(primaryContacts));
		//Actions actions = new Actions(driver);
		//actions.moveToElement(primaryContacts).click();
		primaryContacts.click();
		secondaryContacts.click();
		
		return new ContactsPage(driver);
		
		
	}

}
