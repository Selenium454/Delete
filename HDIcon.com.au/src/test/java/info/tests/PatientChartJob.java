package info.tests;

import org.testng.annotations.Test;

import info.common.Common;
import info.pages.ChartOrder;
import info.pages.LoginPage;

public class PatientChartJob extends Common{

	@Test
	public void chartJob() throws InterruptedException
	{
		
		LoginPage loginPage = new LoginPage(driver,extentTest);
		loginPage.performLogin("pharmacy.admin2@epichubqa.onmicrosoft.com", "EpicNPQA@987!");
		ChartOrder job = new ChartOrder(driver,extentTest);
	     job.createChartJob("12345","SJGM");
		
		
	}
	
}
