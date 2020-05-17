package info.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import info.common.CommonActions;

public class ChartOrder extends CommonActions{

	
	WebDriver driver;
	ExtentTest extentTest;
	
	public ChartOrder(WebDriver driver,ExtentTest extentTest)
	{
		this.driver= driver;
		this.extentTest = extentTest;
	}
	public ChartOrder(WebDriver driver)
	{
		
		this.driver = driver;
	}
	
	By txt_link = By.xpath("//*[text()='Charts']");
	By link_takePhoto = By.xpath("//*[text()='Take Photo']");
	By txt_facility = By.xpath("//*[@id='facility']");
	By select_facility = By.xpath("//*[text()='St John Of God Hospital Murdoch']");
	
	By txt_URN = By.xpath("//*[@id='patientName']");
	By btn_find = By.xpath("//*[@id='find-urn']");
	By txt_patientName = By.xpath("//*[@class='search-full-name']");
	By txt_ward = By.xpath("//*[@id='ward']");
	By select_ward = By.xpath("//*[text()='Bridget Clancy']");
	By btn_camera = By.xpath("//*[@class='ion-camera']");
	By select_image = By.xpath("//*[@class='image-slider']");
	By btn_submitJob = By.xpath("//*[@id='submit-chart-job']");
	


public void createChartJob(String URN,String facility) throws InterruptedException
{
	clickObj(driver, txt_link, "Click on Charts",extentTest);	
	clickObj(driver, link_takePhoto, "Click on Take Photo",extentTest);
   
try {
	Thread.sleep(3000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
//clickObj(driver, txt_facility, "click on facility drop down",extentTest);
//clickObj(driver, txt_facility, "click on facility", extentTest);	
 selectElement(driver,txt_facility,"St John Of God Hospital Murdoch");
	//driver.switchTo().alert().accept();
	enterText(driver, txt_URN, URN, "Enter URN",extentTest);
	
	clickObj(driver, btn_find, "Cllick on find",extentTest);
	
	clickObj(driver,txt_patientName,"select patient",extentTest);
	selectElement(driver,txt_ward,"Bridget Clancy");
	clickObj(driver, btn_camera , "Cllick on camera",extentTest);
	
	jsClickObj(driver, select_image , "select on image",extentTest);
	
	clickObj(driver, btn_submitJob , "click on submit Job",extentTest);
}
}