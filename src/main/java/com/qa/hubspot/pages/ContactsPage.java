package com.qa.hubspot.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.util.Constants;

public class ContactsPage extends BasePage{
	
	@FindBy(xpath = "//h1/i18n-string[text() = 'Contacts']")
	WebElement contactsPageHeader;
	
	@FindBy(xpath = "//button//span[text() = 'Create contact']")
	WebElement createContactBtn;
	
	@FindBy(xpath = "//input[@id ='uid-ctrl-1']")
	WebElement emailTextField;
	
	@FindBy(xpath = "//input[@id ='uid-ctrl-2']")
	WebElement firstNameTextField;
	
	@FindBy(xpath = "//input[@id ='uid-ctrl-3']")
	WebElement lastNameTextField;
	
	@FindBy(xpath = "//li//span[text() = 'Create contact']")
	WebElement createContactBtn2;

	public  ContactsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String getContactsPageTitle()
	{   
		WebDriverWait wait = new WebDriverWait(driver , 20);
		wait.until(ExpectedConditions.titleIs(Constants.Contacts_Page_Title));
		return driver.getTitle();
	}
	
	public String getContactsPageHeader()
	{
		WebDriverWait wait = new WebDriverWait(driver , 20);
		wait.until(ExpectedConditions.visibilityOf(contactsPageHeader));
		return contactsPageHeader.getText();
	}
	
	public void createContact(String emailName , String firstName , String lastName) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver , 30);
		wait.until(ExpectedConditions.visibilityOf(createContactBtn));
		createContactBtn.click();
		Thread.sleep(10000);
		//List<WebElement> ll = driver.findElements(By.tagName("iframe"));
		//ll.size();
		//System.err.println("total frames size is " +ll.size());
		//driver.switchTo().frame(1);
		
		emailTextField.sendKeys(emailName);
		Thread.sleep(10000);
		firstNameTextField.sendKeys(firstName);
		Thread.sleep(10000);
		lastNameTextField.sendKeys(lastName);
		
		createContactBtn2.click();
		
	}
	
	
	

}
