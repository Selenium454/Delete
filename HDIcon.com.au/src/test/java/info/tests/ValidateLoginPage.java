package info.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import info.common.Common;
import info.pages.LoginPage;

public class ValidateLoginPage extends Common {

	@Test(priority = 0)
	public void invalidEmailAddress() {
		
		LoginPage loginPage = new LoginPage(driver, extentTest);
		loginPage.performLogin(userName, password);

		//loginPage.invalidEmailAddress();
		loginPage.validateErrorMessage("Error! Invalid username or password, please try again.");
		//Assert.assertEquals("Error! Invalid username or password, please try again.", LoginPage.text);

	}
	
	@Test(priority = 1)
	public void invalidPassword() {
		LoginPage loginPage = new LoginPage(driver, extentTest);
		loginPage.performLogin("pharmacy.admin2@epichub.onmicrosoft.com", "EpicNPDEV@987!@@@");

		loginPage.validateErrorMessage("Error! Invalid username or password, please try again.");

		

	}
    
}
