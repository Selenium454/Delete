package info.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import info.common.CommonActions;
import info.common.Commons;

public class ValidateHomePage extends Commons {

	
	WebDriver driver;
	ExtentTest extentTest;
	public String text  ;
	public ValidateHomePage(WebDriver driver,ExtentTest extentTest)
	{
		this.driver = driver;
		this.extentTest = extentTest;
	}
	public ValidateHomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By txt_btn = By.xpath("//*[@id='searchSettings']/span");
	By txt_box = By.id("patientSearchInput");
	By btn_search = By.xpath("//*[text()='Search']");
	By link_dashBoard = By.xpath("//*[text()='Dashboard']");
	By link_charts = By.xpath("//*[text()='Charts']");
	By txt_header = By.className("header-title");
	By txt_name = By.xpath("//*[@class='vuetable-th-name']");
	By txt_phone = By.xpath("//*[@class='vuetable-th-phone_number']");
	By txt_details = By.xpath("//*[@class='vuetable-th-details_link']");
	By btn_logout = By.xpath("//*[@class='circle__content']");
	By btn_clickLogout = By.xpath("//*[text()=' Logout']");
	By txt_login = By.xpath("//*[text()='Login']");
			
	
			//   Associated Business Units
    
	 public void homePage()
	   {
		
		 CommonActions actions = new CommonActions();
	     actions.validateElementsDisplayed(driver, txt_btn, "Name Search displayed", extentTest);
		
		 actions.validateElementsDisplayed(driver, txt_box, "Search text box displayed", extentTest);
		 actions.validateElementsDisplayed(driver, btn_search, "Search button displayed", extentTest);
		 String attributeVal =actions.getAttributeValue(driver, btn_search, "disabled", extentTest);
		 Assert.assertEquals(attributeVal, "disabled");
		 // is displayed and enabled 
		 
		 actions.validateElementsEnabled(driver, btn_search, "Search button displayed", extentTest);
		 actions.validateElementsDisplayed(driver, link_dashBoard, "Search button displayed", extentTest);
		 actions.validateElementsDisplayed(driver, link_charts, "Search button displayed", extentTest);
		 actions.getElementText(driver, txt_header);
		 //Assert.assertEquals(text, expected);
		 actions.validateElementsDisplayed(driver, txt_name, "Search button displayed", extentTest);
		 actions.validateElementsDisplayed(driver, txt_phone, "Search button displayed", extentTest);
		   
		 
	   }
	 
	
	public void logOut()
	{
		actions.clickObj(driver, btn_logout, "Click on SW",extentTest);
		actions.clickObj(driver, btn_clickLogout, "Click on Logout",extentTest);
		//actions.getElementText(driver,txt_login);
		text = driver.findElement(By.xpath("//*[text()='Login']")).getText();
		 System.out.println(text);
		 Assert.assertEquals("Login", text);
		
	}
}
  