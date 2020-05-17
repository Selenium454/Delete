package info.common;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Common {

	public static ExtentReports extent;
	public WebDriver driver;
	public CommonActions actions = new CommonActions();
	public  ExtentTest extentTest;
	public String userName;
	public String password ;
	
	@BeforeSuite
	public void beforeSuite() {
		extent=new ExtentReports();
		ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(new File("./Extent/report.html"));
		extent.attachReporter(htmlReport);

	}
	@AfterSuite
	public void afterSuite() {
		extent.flush();
	}
	@BeforeMethod
	public void beforeMethod(Method method) {
		userName = actions.getPropertyValue("QAemail");
		password = actions.getPropertyValue("QApassword");
		
		extentTest = extent.createTest(method.getName(),method.getDeclaringClass().getName());
		
	//	 extentTest= extent.createTest(method.getName());
		CommonEngine commonEng = new CommonEngine();
		driver = commonEng.launchBrowser("chrome");		
		actions.navigateUrl(driver);
	}
	
//	@AfterMethod
//	public void getResult(ITestResult result)
//	{
//		if(result.getStatus() == ITestResult.FAILURE)
//		{
//			try {
//				extentTest.log(Status.FAIL, "The test case failed"   +result.getName());
//				extentTest.log(Status.FAIL, "The test case failed"   +result.getThrowable());
//				
//				extentTest.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\Images\\image.png" );
//				
// 
//				//extentTest.log(LogStatus.FAIL, extentTest.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\Images\\image.png" ));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//					
//		}
//		
//		actions.closeBrowser(driver);
//	}
/*	@AfterMethod
	public void afterMethod(ITestResult result) {
		try {
			if(result.getStatus() == ITestResult.FAILURE) {
				extentTest.log(Status.FAIL, "The test case failed :"   +result.getName());
				extentTest.log(Status.FAIL, "The test case failed :"   +result.getThrowable());
				
				 extentTest.log(Status.INFO,"Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(actions.getBase64Image(driver)).build());
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	actions.closeBrowser(driver);	
	}*/
	
	
	
	
	
}
