package info.tests;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import info.common.Common;
import info.common.CommonActions;
import info.common.CommonEngine;
import info.common.Commons;
import info.pages.CreateCustomerPage;
import info.pages.HomePage;
import info.pages.LoginPage;

public class PharmacyAdminLogin_Testng2 extends Common{

	
	
@Test
	public void TC1_validateCreateCusFunctionality() {
		
	
		
		//ExtentTest extentTest= extent.createTest("validateCreateCusFunctionality");
		
		
		// Pereform login
		LoginPage loginPage = new LoginPage(driver,extentTest);
	
		loginPage.performLogin("pharmacy.admin2@epichubqa.onmicrosoft.com", "EpicNPQA@987!");

		// Select create customer
		actions.clickObj(driver, HomePage.ele_CreateCustomer, "Create Csutomer",extentTest);

		// Perform Registraction
		/*
		 * CreateCustomerPage createCustomerPage = new CreateCustomerPage(driver);
		 * createCustomerPage.enterPersonalDetails("Joe", "Phillip", "01/01/2019",
		 * "13 Toorak Street", "TOOTGAROOK", "4069");
		 * createCustomerPage.enterMedicareInfo();
		 */
		//createCustomerPage.enterMedicalSeveces();

		
		
		
		
	}
	
	@Test
	public void TC2_validateCreateCusFunctionality() {
		
		
		// Pereform login
		LoginPage loginPage = new LoginPage(driver,extentTest);
		loginPage.performLogin("pharmacy.admin2@epichubqa.onmicrosoft.com", "EpicNPQA@987!");

		// Select create customer
		actions.clickObj(driver, HomePage.ele_CreateCustomer, "Create Csutomer",extentTest);

		// Perform Registraction
		/*
		 * CreateCustomerPage createCustomerPage = new CreateCustomerPage(driver);
		 * createCustomerPage.enterPersonalDetails("Joe", "Phillip", "01/01/2019",
		 * "13 Toorak Street", "TOOTGAROOK", "4069");
		 * createCustomerPage.enterMedicareInfo();
		 */
		//createCustomerPage.enterMedicalSeveces();

		
		
		
		
	}
	
	
}
