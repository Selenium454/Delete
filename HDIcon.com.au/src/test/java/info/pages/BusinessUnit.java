package info.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import info.common.CommonActions;

public class BusinessUnit extends CommonActions{

	WebDriver driver;
	ExtentTest extentTest;
	
	public BusinessUnit(WebDriver driver) {
		this.driver = driver;
	}
	
	public BusinessUnit(WebDriver driver,ExtentTest extentTest) {
		this.driver = driver;
		this.extentTest = extentTest;
	}
	
	By txt_link = By.xpath("//*[text()='Add B.Unit']");
	By txt_name = By.xpath("//*[@name='business unit name']");
	By txt_sitID = By.name("site ID");
	By txt_entity = By.name("//*[@name='entity-inner-input']");
	By txt_entityName = By.xpath("//*[text()='SG Pharmacies Pty Ltd']");
	By txt_email = By.name("email address");
	By txt_phNumber = By.name("phone number");
	By txt_country = By.name("country-inner-input");
	By txt_selectCountry = By.xpath("//*[text()='Australia']");
	By txt_street = By.id("street");
//	By txt_option = By.xpath("//*[@id='suggestion_0']");
	By txt_suburb = By.id("suburb");
	
     By ele_state = By.name("state-inner-input");
	
	By ele_stateSelect = By.xpath("//*[text()='Queensland']");
	By txt_postCode = By.id("postCode");
	By btn_add = By.xpath("//button[contains(text(),'Add')]");
	By txt_dashboard = By.xpath("//*[text()='Dashboard']");
	By list_BU = By.xpath("//*[@class='table table-striped cf']/tbody/tr/td[1]");
	By business_UnitText = By.xpath("//*[text()='Business Unit Details']");
	By ele_Loader = By.xpath("//*[@class='loader-backdrop']");
	
	public String text = null;
	
	public void addBU(String name,String siteID,String emailID,String contactNo,String street,String suburb,String postCode)
	{
		CommonActions actions = new CommonActions();
		clickObj(driver, txt_link, "CLick on business unit",extentTest);
		enterText(driver, txt_name, name,"Business unit name",extentTest);
		enterText(driver, txt_sitID, siteID,"Business unit name",extentTest);
//		clickObj(driver, txt_entity, "click on entity",extentTest);
//		clickObj(driver, txt_entityName, "select entity",extentTest);
		enterText(driver, txt_email, emailID,"Enter email id",extentTest);
		enterText(driver, txt_phNumber, contactNo,"Enter contact no",extentTest);
		
		//clickObj(driver,  txt_country, "conuntry",extentTest);
		//clickObj(driver, txt_selectCountry, "Select conutry",extentTest);
	
		//new Actions(driver).moveToElement(driver.findElement(btn_add)).build().perform();
		
		enterText(driver, txt_street, street,"Enter street",extentTest);
		pauseExecution(3000);				
		clickObj(driver, txt_phNumber, "Select phone number",extentTest);		
		
		enterText(driver, txt_suburb, suburb,"Enter suburb",extentTest);
		
		clickObj(driver,  ele_state, "State",extentTest);
		clickObj(driver, ele_stateSelect, "Select state",extentTest);
		
		enterText(driver, txt_postCode, postCode,"Enter street",extentTest);
		
		clickObj(driver, btn_add, "Click on add button",extentTest);
	   text = actions.getElementText(driver, business_UnitText);
	   Assert.assertEquals(text, "Business Unit Details");
		//actions.pauseExecution(5000);
		
	    waitForElementNotVisable(driver, ele_Loader);
		clickObj(driver, txt_dashboard, "Click on DashBoard");
		
		List<WebElement>lst_Elements= actions.getListElements(driver, list_BU);
		
		boolean flag=false;
		for (WebElement ele : lst_Elements) {
			if(ele.getText().equalsIgnoreCase("AUDI")) {
				flag=true;
				break;
			}
		}
		org.testng.Assert.assertTrue(flag, "Business unit not created");
		
		
//		String text = actions.getElements(driver,list_BU);
//		System.out.println(text);
//		
//		if(text.equalsIgnoreCase("CoreKL"))
//		{
//			Assert.assertTrue(true);
//		}
//	
//	
		}
	
	
	}

