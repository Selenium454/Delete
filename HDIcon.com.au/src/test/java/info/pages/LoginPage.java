package info.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import info.common.CommonActions;

public class LoginPage extends CommonActions{
	WebDriver driver;
	ExtentTest extentTest;
	//public static String text;
	
	public LoginPage(WebDriver driver,ExtentTest extentTest) {
		this.driver=driver;
		this.extentTest=extentTest;
	}
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
		
	By txt_Email = By.cssSelector("#email");
	By txt_Pwd =By.id("password");
	By btn_SignIn = By.xpath("//button[text()='Sign in']");
	By ele_ErrorMsg =By.xpath("//*[@class='alert alert-danger']");
		
	
	
	public void performLogin(String userName,String pwd) {
		CommonActions actions=new CommonActions();
		actions.enterText(driver, txt_Email, userName, "Email",extentTest);
		actions.enterText(driver, txt_Pwd, pwd,"Password",extentTest);
		actions.clickObj(driver, btn_SignIn,"Sign in",extentTest);
	}
	
	public void validateErrorMessage(String errorMessage)
	{
		String text =getElementText(driver, ele_ErrorMsg);
		//text =  driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText();
		System.out.println(text);
		
		Assert.assertEquals("Error! Invalid username or password, please try again.", text);
	}
//	public void performLogin(String userName,String pwd) {
//		CommonActions actions=new CommonActions();
//		actions.enterText(driver, txt_Email, userName, "Email");
//		actions.enterText(driver, txt_Pwd, pwd,"Password");
//		actions.clickObj(driver, btn_SignIn,"Sign in");
//	}

	
}

