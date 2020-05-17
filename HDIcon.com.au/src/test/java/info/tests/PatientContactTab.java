package info.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import info.common.Common;
import info.common.Commons;
import info.common.ExcelOperations;
import info.pages.ContactsTab;
import info.pages.LoginPage;
import info.pages.PatientSearch;

public class PatientContactTab extends Common{

	@Test(dataProvider="contact")
	public void patientConatctTab(String firstName,String lastName)
	{
		
		LoginPage loginPage = new LoginPage(driver,extentTest);
		loginPage.performLogin("pharmacy.admin2@epichub.onmicrosoft.com", "EpicNPDEV@987!");
	
		
		PatientSearch ps = new PatientSearch(driver,extentTest);
		ps.searchPatientId();
		ContactsTab contact = new ContactsTab(driver,extentTest);
		contact.getContacts(firstName, lastName);
		
	}
	@DataProvider(name="contact")
	public Object[][] data(){
		XSSFSheet sheet = ExcelOperations.getDataFromExcel("./Excel Data/HDCustomer.xlsx","ContactTab");
		Object[][] testData= ExcelOperations.getCellData(sheet);
		return testData;
	}
	
	
}


