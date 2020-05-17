package info.tests;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import info.common.Common;
import info.common.CommonActions;
import info.common.CommonEngine;
import info.common.Commons;
import info.common.ExcelOperations;
import info.pages.CreateCustomerPage;
import info.pages.HomePage;
import info.pages.LoginPage;
import info.pages.PatientSearch;

public class PharmacyAdminLogin_Testng extends Common {
	/*
	 * WebDriver driver ; CommonActions actions = new CommonActions();
	 * 
	 * @BeforeMethod public void beforeMethod() { //Launch and navigate CommonEngine
	 * commonEng = new CommonEngine(); driver = commonEng.launchBrowser("chrome");
	 * actions.navigateUrl(driver); }
	 * 
	 * @AfterMethod public void afterMethod() { //Close browser
	 * actions.closeBrowser(driver); }
	 */
	// @Test
/*	public void validateCreateCusFunctionality() {		

		// Get data from Exvel
		XSSFSheet sheet = ExcelOperations.getDataFromExcel("./Excel Data/HDCustomer.xlsx","Personal Details");
		
		int totalRows = sheet.getLastRowNum();
		
		for(int i=1;i<totalRows;i++) {
			XSSFRow  row = sheet.getRow(i);
			
			String dob = row.getCell(0).getStringCellValue();
			// String surName= row.getCell(1).getStringCellValue();
			String street = row.getCell(1).getStringCellValue();
			String subrub = row.getCell(2).getStringCellValue();
			String postcode = row.getCell(3).getStringCellValue();

			String randomFirstName = actions.randomString();
			String randomLastName = actions.randomString();
			
			// Pereform login
			LoginPage loginPage = new LoginPage(driver);
			loginPage.performLogin("pharmacy.admin2@epichub.onmicrosoft.com", "EpicNPDEV@987!");

			// Select create customer
			actions.clickObj(driver, HomePage.ele_CreateCustomer, "Create Csutomer");

			// Perform Registraction
			CreateCustomerPage createCustomerPage = new CreateCustomerPage(driver);
			createCustomerPage.enterPersonalDetails(randomFirstName, randomLastName, dob, street, subrub, postcode);

			createCustomerPage.enterMedicareInfo();
			createCustomerPage.enterMedicalServices("12345", "2345", "999", "Bupa HI Pty Ltd");
//			createCustomerPage.enterAdditionalInfo();
//			createCustomerPage.gotoPatientProfile();
			
		}
	}
*/
	@Test(dataProvider="data")
	public void validateCreateCusFunctionalityWithDataProvider(String dob,String street, String subrub, String postcode,String roomNumber,String bedNumber,String URN,String healthFund) {

		String randomFirstName = actions.randomString();
		String randomLastName = actions.randomString();
		
		// Pereform login
		LoginPage loginPage = new LoginPage(driver,extentTest);
	loginPage.performLogin("pharmacy.admin2@epichubqa.onmicrosoft.com", "EpicNPQA@987!");
		
		// Select create customer
		actions.clickObj(driver, HomePage.ele_CreateCustomer, "Create Csutomer",extentTest);

		// Perform Registraction
		CreateCustomerPage createCustomerPage = new CreateCustomerPage(driver,extentTest);
		createCustomerPage.enterPersonalDetails(randomFirstName, randomLastName, dob, street, subrub, postcode);

		createCustomerPage.enterMedicareInfo();
		createCustomerPage.enterMedicalServices(roomNumber, bedNumber, URN,healthFund);
		createCustomerPage.enterAdditionalInfo();
		createCustomerPage.gotoPatientProfile();
	    actions.waitForElement(driver, PatientSearch.btn_Search);
        Assert.assertEquals("Medical Services",createCustomerPage.text);
//actions.pauseExecution(5000);
	}
	
	@DataProvider(name="data")
	public Object[][] data(){
		XSSFSheet sheet = ExcelOperations.getDataFromExcel("./Excel Data/HDCustomer.xlsx","Personal Details");
		Object[][] testData= ExcelOperations.getCellData(sheet);
		return testData;
	}
	
	
	//@Test(dataProvider="data1")
/*	public void validateCreateCusFunctionalityWithDataProvider1(String run,String dob,String street, String subrub, String postcode,String roomNumber,String bedNumber,String URN,String healthFund) {

		
		if(run.equalsIgnoreCase("yes")){
		String randomFirstName = actions.randomString();
		String randomLastName = actions.randomString();
		
		// Pereform login
		LoginPage loginPage = new LoginPage(driver);
		loginPage.performLogin("pharmacy.admin2@epichub.onmicrosoft.com", "EpicNPDEV@987!");

		// Select create customer
		actions.clickObj(driver, HomePage.ele_CreateCustomer, "Create Csutomer");

		// Perform Registraction
		CreateCustomerPage createCustomerPage = new CreateCustomerPage(driver);
		createCustomerPage.enterPersonalDetails(randomFirstName, randomLastName, dob, street, subrub, postcode);

		createCustomerPage.enterMedicareInfo();
		createCustomerPage.enterMedicalServices(roomNumber, bedNumber, URN,healthFund);
//		createCustomerPage.enterAdditionalInfo();
//		createCustomerPage.gotoPatientProfile();
		}else {
			System.out.println("run is fals");
		}

	}
	
	@DataProvider(name="data1")
	public Object[][] data1(){
		XSSFSheet sheet = ExcelOperations.getDataFromExcel("./Excel Data/HDCustomer.xlsx","MultiData");
		Object[][] testData= ExcelOperations.getCellData(sheet);
		return testData;
	}
	*/

	
}
