package info.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import info.common.Common;
import info.common.Commons;
import info.common.ExcelOperations;
import info.pages.BillingTab;
import info.pages.LoginPage;
import info.pages.PatientSearch;

public class PatientBillingDetails extends Common{

	
	@Test(dataProvider="billing")
	public void billingDetails(String firstName,String lastName,String ph,String mobile,String emailID,String street,String suburb,String postCode,String bankName,String acName,String bsb,String acNumber)
	{
		LoginPage login = new LoginPage(driver,extentTest);
		login.performLogin("pharmacy.admin2@epichub.onmicrosoft.com", "EpicNPDEV@987!");
		PatientSearch ps = new PatientSearch(driver,extentTest);
		ps.searchPatientId();
		BillingTab bt = new BillingTab(driver,extentTest);
		bt.patientBillingDetails(firstName, lastName, ph, mobile,emailID, street, suburb, postCode, bankName, acName, bsb, acNumber);
		
		
	}
	@DataProvider(name="billing")
	public Object[][] data(){
		XSSFSheet sheet = ExcelOperations.getDataFromExcel("./Excel Data/HDCustomer.xlsx","BillingTab");
		Object[][] testData= ExcelOperations.getCellData(sheet);
		return testData;
	}
	
	
}
