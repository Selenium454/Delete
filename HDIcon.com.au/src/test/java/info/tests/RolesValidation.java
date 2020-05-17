package info.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import info.common.Common;
import info.common.ExcelOperations;
import info.pages.CreateCustomerPage;
import info.pages.LoginPage;
import info.pages.PatientSearch;

public class RolesValidation extends Common{

	@Test(dataProvider="roles")
	public void customerIDSearch(String title,String username,String password,String createPatient,String editPatient,String placeHolder,String facilites,String charts,String CreateFacility, String createBusinessUnit)
	{
		
		LoginPage loginPage = new LoginPage(driver,extentTest);
		loginPage.performLogin(username, password);
		
		if(createPatient.equalsIgnoreCase("yes")) {
			CreateCustomerPage cusPage=new CreateCustomerPage(driver,extentTest);
			cusPage.createPatcient();
		}
		if(editPatient.equalsIgnoreCase("yes")) {
			PatientSearch search = new PatientSearch(driver,extentTest);
			search.searchPatientId();
		}
		
		
	}
	
	@DataProvider(name="roles")
	public Object[][] data(){
		XSSFSheet sheet = ExcelOperations.getDataFromExcel("./Excel Data/HDCustomer.xlsx","Roles");
		Object[][] testData= ExcelOperations.getCellData(sheet);
		return testData;
	}
	
}
