package info.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import info.common.Common;
import info.common.ExcelOperations;
import info.pages.CreatePatientValidation;
import info.pages.HomePage;
import info.pages.LoginPage;

public class ValidatePatientCreationErrorMessage extends Common {

	
	@Test(dataProvider="data")
	public void verifyPatientErrorMsg(String firstName, String surName, String dob, String street, String suburb,String postCode)
	{
	LoginPage loginPage = new LoginPage(driver, extentTest);
	loginPage.performLogin(userName, password);
	actions.clickObj(driver, HomePage.ele_CreateCustomer, "Create Csutomer",extentTest);
	CreatePatientValidation validations = new CreatePatientValidation(driver,extentTest);
	
	
	validations.checkErrorMessage(firstName,surName, dob, street, suburb,postCode);
	
	
}
	@DataProvider(name="data")
	public Object[][] data(){
		XSSFSheet sheet = ExcelOperations.getDataFromExcel("./Excel Data/HDCustomer.xlsx","Error");
		Object[][] testData= ExcelOperations.getCellData(sheet);
		return testData;
	}
	
}	
