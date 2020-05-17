package info.tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import info.common.Common;
import info.common.ExcelOperations;
import info.pages.BusinessUnit;
import info.pages.CreateCustomerPage;
import info.pages.LoginPage;
import info.pages.PatientSearch;


public class CreateBusinessUnit extends Common{

	
	
	@Test(dataProvider="Buniess")
	public void createBusinessUnit(String title,String username,String password,String createPatient,String editPatient,String placeHolder,String facilites,String charts,String CreateFacility, String createBusinessUnit,String name,String siteID,String email,String Contactno,String street,String suburb,String postCode)
	{
		LoginPage loginPage = new LoginPage(driver,extentTest);
		loginPage.performLogin(username, password);
		
		if(CreateFacility.equalsIgnoreCase("yes")) {
			BusinessUnit BU=new BusinessUnit(driver,extentTest);
			BU.addBU(name,siteID, email,Contactno,street,suburb,postCode);
			
		//	 Assert.assertEquals(BU.text, "Business Unit Details");
			 
		}
		
		
	}
	
	@DataProvider(name="Buniess")
	public Object[][] data() throws FileNotFoundException, IOException{
		XSSFSheet sheet = ExcelOperations.getDataFromExcel("./Excel Data/HDCustomer.xlsx","BusinessUnit");
		Object[][] testData= ExcelOperations.getCellData(sheet);
		return testData;
		
	}
}
