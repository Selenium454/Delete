package info.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import info.common.CommonActions;

public class ContactsTab extends CommonActions{

	WebDriver driver;
	ExtentTest extentTest;
	
	public ContactsTab(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public ContactsTab(WebDriver driver,ExtentTest extentTest)
	{
		this.driver = driver;
		this.extentTest= extentTest;
	}
	
	
  By txt_ContactTab = By.xpath("//section[@id='customer-profile-navbar']/ul[2]/li[4]/a");
  By txt_AddContact = By.xpath("//div[@class='header primary']/div[2]/a");
  By txt_FirstName = By.xpath("//input[@name='firstName']");
  By txt_LastName = By.xpath("//input[@name='lastName']");
  By txt_IsMainContact = By.id("isMainContact");
  By txt_SaveButton = By.xpath("//div[@class='bottom-bar']/button[2]");		  
  
	public void getContacts(String firstName,String lastName)
	{
	
		clickObj(driver, txt_ContactTab, "Click on Contact Tab",extentTest);
		clickObj(driver, txt_AddContact, "Click on Add Contact Tab",extentTest);
		enterText(driver, txt_FirstName, firstName, "Enter FirstName",extentTest);
		enterText(driver, txt_LastName, lastName, "Enter lastName",extentTest);
		clickObj(driver, txt_IsMainContact, "Checkbox",extentTest);
		clickObj(driver, txt_SaveButton, "Save button",extentTest);
		
 	}
	
	
}

