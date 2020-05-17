package info.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;


import info.common.CommonActions;

public class BillingTab extends CommonActions {

	
	WebDriver driver;
	ExtentTest extentTest;
	
	public BillingTab(WebDriver driver,ExtentTest extentTest)
	{
		this.driver= driver;
		this.extentTest = extentTest;
	}
	public BillingTab(WebDriver driver)
	{
		
		this.driver = driver;
	}
	
	By txt_billingTab = By.xpath("//*[@id='collapseProfileMenu']//*[contains(@data-label,'Billing')]");
	By txt_firstName = By.name("First Name");
	By txt_lastName = By.name("Last Name");
	By txt_phoneNumber = By.name("Phone Number");
	By txt_mobileNumber = By.name("Mobile Number");
	By txt_emailID = By.name("Email Address");
	By txt_street = By.id("street");
	By txt_suburb = By.id("suburb");
	By txt_postCode = By.id("postCode");
	By txt_bankName = By.id("bank-name");
	By txt_acName = By.id("bank-account-name");
	By txt_bsb = By.id("bank-bsb");
	By txt_acNumber = By.id("bank-account-number");
	By btn = By.xpath("(//*[contains(text(),'Save')])[2]");
	
	
	public void patientBillingDetails(String firstName,String lastName,String ph,String mobile,String emailID,String street,String suburb,String postCode,String bankName,String acName,String bsb,String acNumber)
	{
		
		clickObj(driver, txt_billingTab, "Click on Billing tab",extentTest);
		enterText(driver, txt_firstName, firstName, "Enter firstName",extentTest);
		enterText(driver, txt_lastName, lastName, "Enter lastName",extentTest);
		enterText(driver, txt_phoneNumber, ph, "Enter lastName",extentTest);
		enterText(driver, txt_mobileNumber, mobile, "Enter lastName",extentTest);
		enterText(driver, txt_emailID, emailID, "Enter lastName",extentTest);
				
	enterText(driver, txt_street, street, "Enter street",extentTest);
	enterText(driver, txt_suburb, suburb, "Enter suburb",extentTest);
	enterText(driver, txt_postCode, postCode, "Enter postCode",extentTest);
	enterText(driver, txt_bankName, bankName, "Enter bankName",extentTest);
	enterText(driver, txt_acName, acName, "Enter acName",extentTest);
	enterText(driver, txt_bsb, bsb, "Enter BSB",extentTest);
	enterText(driver, txt_acNumber, acNumber, "Enter acNumber",extentTest);
	clickObj(driver, btn, "Click on Save button in billing tab",extentTest);
	
	
	}	
}


