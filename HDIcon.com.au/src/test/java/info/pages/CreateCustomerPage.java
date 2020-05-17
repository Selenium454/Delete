package info.pages;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;

import com.aventstack.extentreports.ExtentTest;

import info.common.CommonActions;
import junit.framework.Assert;

public class CreateCustomerPage extends CommonActions {
	WebDriver driver;
	ExtentTest extentTest;
	
	public CreateCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public CreateCustomerPage(WebDriver driver,ExtentTest extentTest) {
		this.driver = driver;
		this.extentTest = extentTest;
	}
	
	public static String HubID ;
	public static String PatientHubID;
	public static String Hub[];
	
	By txt_Title = By.name("patient-title-inner-input");
	By txt_TitleSelect = By.xpath("//*[text()='Mr']");
	By txt_FirstName = By.id("txt-firstname");
	By txt_SurName = By.name("patient-surname");
	By txt_Dob = By.id("txt-dob");
	By radio_gender = By.xpath("//*[@name='patient-gender' and @value='male']");
	By txt_Street = By.name("street");
	By ele_state = By.name("state-inner-input");
	
	By ele_stateSelect = By.xpath("//*[text()='Queensland']");
	 
	
	By txt_PostCode = By.id("postCode");
	By btn_Next = By.xpath("//*[contains(text(),'Next')]");
	
	
	By link_facilities = By.xpath("//*[text()='Facilities']");
	By txt_unSaved = By.xpath("//*[contains(text(),'There are unsaved changes.')]");
	By btn_goBack = By.xpath("//*[contains(text(),'Go Back')]");
	
	
	By txt_Suburb = By.id("suburb");
	By btn_Back = By.xpath("//*[contains(text(),'Back')]");
	By file_upload = By.xpath("//*[@type='file']");
	By txt_MedicareNumber = By.name("patient-medicare");
	By txt_RoomNumber = By.name("Room Number");
	By txt_BedNumber = By.name("Bed Number");
	By txt_URNumber = By.name("Ur Number");
	By txt_HealthFundBy = By.name("healthfundId");
	
	By txt_SelectHealthFund = By.xpath("//*[contains(text(),'Bupa HI Pty Ltd')]");
	By text_Date = By.xpath("//input[@class='el-input__inner']");
	By txt_SelectDate = By.xpath("//table[@class='el-date-table']/tbody/tr[3]/td[1]/div");
	
	By txt_Btn = By.xpath("//*[contains(text(),'Next')]");
	//By txt_Aboriginal = By.xpath("//div[@data-test-id='indigenous-status-input']/div/input");
	By txt_Aboriginal = By.name("patient-identification-inner-input");
	By txt_SelectAboriginal = By.xpath("//div[@data-test-id='indigenous-status']//div//span/div/div[1]/span");
	
//	By txt_SelectAboriginal = By.xpath("(//INPUT[@data-v-9a3f3636=''])[4]");
	By txt_IslanderStatus = By.xpath("//input[@name='patient-islanderStatus-inner-input']");

	By txt_SelectIslanderStatus = By.xpath("//div[@data-test-id='islander-status']/div/span/div/div[1]");
//	By txt_SelectIslanderStatus = By.xpath("(//INPUT[@data-v-9a3f3636=''])[5]");
	By txt_SaveProfile = By.xpath("//button[contains(text(),'Save Profile')]");
	By txt_GotoPatientProfile = By.xpath("//a[@class='btn btn-action']");
	public By txt_compare = By.xpath("//*[text()='Medical Services']");
	public String text =null ;
    
	public void enterPersonalDetails(String firstName, String surName, String dob, String street, String suburb,
			String postCode) {
		CommonActions actions = new CommonActions();
		clickObj(driver, txt_Title, "Title",extentTest);
		clickObj(driver, txt_TitleSelect, "Select Title",extentTest);
		enterText(driver, txt_FirstName, firstName, "FirstName",extentTest);
		enterText(driver, txt_SurName, surName, "LastName",extentTest);
		enterText(driver, txt_Dob, dob, "DOB",extentTest);

		clickRadio(driver, radio_gender, "Gender",extentTest);

		enterText(driver, txt_Street, street, "Street",extentTest);		
		pauseExecution(3000);
		clickObj(driver, txt_Suburb, "Suburb",extentTest);
		enterText(driver, txt_Suburb, suburb, "Suburb",extentTest);
		clickObj(driver, ele_state, "State",extentTest);
		
		clickObj(driver, ele_stateSelect, "SelectState",extentTest);
		enterText(driver, txt_PostCode, postCode, "PostCode",extentTest);
		clickObj(driver, link_facilities, "Click on facilities link",extentTest);
		actions.getElementText(driver,txt_unSaved);
		clickObj(driver, btn_goBack, "click on go back button");
		
		
		clickObj(driver, btn_Next, "NextButton",extentTest);

	}

	public void enterMedicareInfo() {

		waitForElement(driver, txt_MedicareNumber);
		clickObj(driver, btn_Next, "MedicationNext",extentTest);
	}

	public void enterMedicalServices(String roomNumber,String bedNumber,String urNumber,String healthFund) {
		String user = driver.findElement(By.cssSelector(".row .patient-service-info .font-weight-bold")).getText();
		System.out.println(user);
		//HubID = driver.findElement(By.xpath("//div[@class ='patient-creation-step']/div/div[2]/div[1]//span[2]/span")).getText();
		HubID= driver.findElement(By.xpath("//*[contains(text(),'- Hub ID:')]")).getText();
		System.out.println(HubID);
	     Hub = HubID.trim().split(":");
         PatientHubID = Hub[1].trim();	
         System.out.println("PatientHubID: " + PatientHubID);
		
		
		clickObj(driver, By.xpath("//div[@class='patient-creation-step']//button[@type='button']"),
				"ClickOnAddService",extentTest);
		
		//By.name("")
		////*[text()='Medical Oncology Treatment']
		////div[@data-test-id='service-type']/div/span/div/div[1
		clickObj(driver, By.xpath("//input[@name='serviceType-inner-input']"), "ClickonService",extentTest);
		clickObj(driver, By.xpath("//*[text()='Hospital']"), "SelectService",extentTest);
		
		clickObj(driver, By.name("facility-inner-input"), "ClickOnFacility",extentTest);
	//	clickObj(driver, By.xpath("//div[@data-test-id='facility']/div/span/div/div[4]/span"), "SelectFacility");
		clickObj(driver,By.xpath("//*[text()='Hollywood Private Hospital']"),"SelectFacility",extentTest);
		clickObj(driver, By.xpath("//input[@name='ward-inner-input']"), "ClickOnWard",extentTest);
	//	clickObj(driver, By.xpath("//div[@data-test-id='ward']/div/span/div/div[3]/span"), "SelectWard",extentTest);
		clickObj(driver,By.xpath("//*[text()='The Hollywood Clinic']"),"SelectWard",extentTest);
		clickObj(driver, By.xpath("//*[text()='Add']"), "AddServiceButton",extentTest);
		//enterText(driver, file_upload, filePath, "upload file");
		//driver.findElement(By.xpath("//*[@type='file']")).sendKeys("C:\\SHOW WHAT YOU KNOW.pdf");
		enterText(driver,txt_RoomNumber,roomNumber,"RoomNumber",extentTest);
		enterText(driver,txt_BedNumber,bedNumber,"BedNumber",extentTest);
		enterText(driver,txt_URNumber,urNumber,"URNumber",extentTest);
		enterText(driver,txt_HealthFundBy,healthFund,"HealthFund",extentTest);
		clickObj(driver, txt_SelectHealthFund, "SelectHealthFund",extentTest);
		
		//clickObj(driver, text_Date, "Date",extentTest);
		//clickObj(driver, txt_SelectDate, "SelectDate",extentTest);
		
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		String date=sdf.format(d);
		enterText(driver, text_Date, date, "Date", extentTest);
		
		clickObj(driver, txt_Btn, "ClickNextButton",extentTest);
		
			
	}

	public void enterAdditionalInfo() {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,-250)");
	    WebElement element = driver.findElement(By.xpath("//div[@data-test-id='indigenous-status-input']/div/input"));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(element).click().build().perform();
		 clickObj(driver, txt_SelectAboriginal, "SelectAboriginal",extentTest);
		 clickObj(driver, txt_IslanderStatus, "ClickIslander",extentTest);
		 clickObj(driver, txt_SelectIslanderStatus, "SelectIslander",extentTest);
		 clickObj(driver, txt_SaveProfile, "Save Patient Profile",extentTest); 
		
	}
	public void gotoPatientProfile() {
		CommonActions actions = new CommonActions();
		clickObj(driver, txt_GotoPatientProfile, "Goto patient profile",extentTest);
		text = actions.getElementText(driver, txt_compare)	;
//			Assert.assertEquals("Medical Services", text);
	}
	
	public void createPatcient() {
		String randomFirstName = randomString();
		String randomLastName = randomString();
		String dob="09/09/2019";
		String street ="13 Toorak Street";
		String subrub="TOOTGAROOK";
		String postcode="4069";
		String roomNumber="12345";
		String bedNumber ="134";
		String URN="987";
		String healthFund="Bupa HI Pty Ltd";
	//	String filePath = "C:\\SHOW WHAT YOU KNOW.pdf";
		
				
		// Select create customer
				clickObj(driver, HomePage.ele_CreateCustomer, "Create Csutomer",extentTest);

				// Perform Registraction
				
				enterPersonalDetails(randomFirstName, randomLastName, dob, street, subrub, postcode);

				enterMedicareInfo();
				enterMedicalServices(roomNumber, bedNumber, URN,healthFund);
				enterAdditionalInfo();
				gotoPatientProfile();
				
				

	}
	
}

