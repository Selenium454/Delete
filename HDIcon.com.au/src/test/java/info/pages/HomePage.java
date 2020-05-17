package info.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import info.common.CommonActions;

public class HomePage {

WebDriver driver;
ExtentTest extentTest;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	

	
	public HomePage(WebDriver driver,ExtentTest extentTest) {
		this.driver=driver;
		this.extentTest=extentTest;
	}
	
	public static By ele_CreateCustomer = By.xpath("//*[@class='epic-sidebar-menu']//*[@class ='link-create-customer']");
	
	
}

