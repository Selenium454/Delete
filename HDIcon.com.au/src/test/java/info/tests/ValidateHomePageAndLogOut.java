package info.tests;

import org.testng.annotations.Test;

import info.common.Common;
import info.pages.LoginPage;
import info.pages.ValidateHomePage;

public class ValidateHomePageAndLogOut extends Common {

	@Test
	public void validateHomePage()
	{
		
		LoginPage loginPage = new LoginPage(driver,extentTest);
		loginPage.performLogin("pharmacy.admin2@epichub.onmicrosoft.com", "EpicNPDEV@987!");
		ValidateHomePage HDPage = new ValidateHomePage(driver,extentTest);
		HDPage.homePage();
		HDPage.logOut();
	}
	
	
}
