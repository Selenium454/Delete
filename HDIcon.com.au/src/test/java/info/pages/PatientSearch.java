package info.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import info.common.CommonActions;
import info.tests.PharmacyAdminLogin_Testng;

public class PatientSearch extends CommonActions{

WebDriver driver;
ExtentTest extentTest;

public PatientSearch(WebDriver driver) 
{
	
	this.driver = driver;
}

public PatientSearch(WebDriver driver,ExtentTest extentTest) {
	
	this.driver=driver;
	this.extentTest=extentTest;
}

  // By txt_Arrow = By.xpath("//div[@id='searchSettings']/i[2]");

    By txt_Arrow= By.className("ion-arrow-right-b");
 //   By txt_SearchList = By.xpath("//div[@class='input-group form-group open']/form/li[4]//input");
    By txt_SearchList = By.xpath("//*[@class='patientSearchByOptionsGroup']//*[text()='Customer ID']");
	By txt_ID = By.id("patientSearchInput");
	public static By btn_Search = By.xpath("//*[text()='Search']");
	By txt_CustomerID = By.xpath("//div[@class='searchResultTable']/div//table/tbody/tr/td[2]");
	By ele_PatientId = By.xpath("(//*[@class='epic-form-group__field'])[2]");
	
	
  public void searchPatientId() {
		CreateCustomerPage customer = new CreateCustomerPage(driver,extentTest);
		
			clickObj(driver,txt_Arrow, "Arrow",extentTest);
			clickObj(driver, txt_SearchList, "CustomerID",extentTest);
			clickObj(driver, txt_ID, "Enter Patient ID",extentTest);
		    enterText(driver, txt_ID, customer.PatientHubID, "Search with HubId",extentTest);
		    clickObj(driver, btn_Search, "Click on Search Button",extentTest);
		    clickObj(driver,txt_CustomerID,"Click on CustomerID/Name",extentTest);
		    
		    String parentWindow=driver.getWindowHandle();
		    Set<String> windows=driver.getWindowHandles();
		    String childWindow=null;
		    
		    for (String window : windows) {
				if(!window.equals(parentWindow)) {
					childWindow=window;
				}
			}
		    
		    driver.switchTo().window(childWindow);
		    waitForElement(driver, ele_PatientId);
		    String patientId=getElementText(driver, ele_PatientId);
		    
		    Assert.assertEquals(patientId, customer.PatientHubID);
		  
		}
	
  
}

