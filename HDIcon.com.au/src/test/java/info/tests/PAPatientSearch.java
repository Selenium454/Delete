package info.tests;

import org.testng.annotations.Test;

import info.common.Common;
import info.common.Commons;
import info.pages.CreateCustomerPage;
import info.pages.LoginPage;
import info.pages.PatientSearch;

public class PAPatientSearch extends Common{

	
	@Test
	public void customerIDSearch()
	{
		
		//LoginPage loginPage = new LoginPage(driver);
		LoginPage loginPage = new LoginPage(driver,extentTest);
		loginPage.performLogin("pharmacy.admin2@epichubqa.onmicrosoft.com", "EpicNPQA@987!");
		CreateCustomerPage customer = new CreateCustomerPage(driver,extentTest);
	
		PatientSearch search = new PatientSearch(driver,extentTest);
		search.searchPatientId();
		
	}
	
}

