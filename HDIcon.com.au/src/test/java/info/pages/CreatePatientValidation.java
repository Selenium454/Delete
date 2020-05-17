package info.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import info.common.CommonActions;

public class CreatePatientValidation extends CommonActions {

	WebDriver driver;
	ExtentTest extentTest;

	public CreatePatientValidation(WebDriver driver) {
		this.driver = driver;
	}

	public CreatePatientValidation(WebDriver driver, ExtentTest extentTest) {
		this.driver = driver;
		this.extentTest = extentTest;
	}

	;

	By txt_FirstName = By.id("txt-firstname");
	By txt_errorMsg = By.xpath("//*[contains(text(),'Invalid characters or numbers found.')]");

	By txt_SurName = By.name("patient-surname");

	By txt_Dob = By.id("txt-dob");
	By dob_errorMsg = By.xpath("//*[contains(text(),'The Date Of Birth field is required')]");
	By radio_gender = By.xpath("//*[@name='patient-gender' and @value='male']");
	By gender_errorMsg = By.xpath("//span[contains(text(),'The Gender field is required')]");
	By txt_Street = By.name("street");

	By txt_Suburb = By.id("suburb");

	By ele_state = By.name("state-inner-input");
	By ele_stateSelect = By.xpath("//*[text()='Queensland']");

	By txt_PostCode = By.id("postCode");
	By txtPostErrormsg = By.xpath("//*[contains(text(),'The Postcode field must be numeric and contain exactly 4 digits')]");

	By btn_Next = By.xpath("//*[contains(text(),'Next')]");

	public void checkErrorMessage(String firstName, String surName, String dob, String street, String suburb,
			String postCode) {

		CommonActions actions = new CommonActions();
		enterText(driver, txt_FirstName, firstName, "FirstName", extentTest);
		String firstNameError = actions.getElementText(driver, txt_errorMsg);
		Assert.assertEquals("Invalid characters or numbers found.", firstNameError);

		enterText(driver, txt_SurName, surName, "LastName", extentTest);
		String surNameError= actions.getElementText(driver, txt_errorMsg);
		Assert.assertEquals("Invalid characters or numbers found11.", surNameError);
		enterText(driver, txt_Dob, dob, "DOB", extentTest);

		clickRadio(driver, radio_gender, "Gender", extentTest);

		enterText(driver, txt_Street, street, "Street", extentTest);
		pauseExecution(3000);
		clickObj(driver, txt_Suburb, "Suburb", extentTest);
		enterText(driver, txt_Suburb, suburb, "Suburb", extentTest);
		clickObj(driver, ele_state, "State", extentTest);

		clickObj(driver, ele_stateSelect, "SelectState", extentTest);
		enterText(driver, txt_PostCode, postCode, "PostCode", extentTest);
		String postCodeError= actions.getElementText(driver, txtPostErrormsg);
		Assert.assertEquals("The Postcode field must be numeric and contain exactly 4 digits", postCodeError);
		clickObj(driver, btn_Next, "NextButton", extentTest);

	}
	
	

}
