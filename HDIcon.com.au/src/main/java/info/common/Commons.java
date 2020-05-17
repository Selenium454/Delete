package info.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class Commons {

	public WebDriver driver ;
	public CommonActions actions = new CommonActions();
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser) {
		//Launch and navigate
		CommonEngine commonEng = new CommonEngine();
		driver = commonEng.launchBrowser(browser);		
		actions.navigateUrl(driver);
	}
	@AfterMethod
	public void afterMethod() {
		//Close browser
		actions.closeBrowser(driver);
	}
}
