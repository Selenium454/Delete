package info.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonEngine {
	//WebDriver driver=null;

	public WebDriver launchBrowser(String browser) {
		WebDriver driver=null;
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver1.exe");
				
				 ChromeOptions options = new ChromeOptions();
				    options.addArguments("use-fake-device-for-media-stream");
				    options.addArguments("use-fake-ui-for-media-stream");
				    
				driver = new ChromeDriver(options);
				
			} else if (browser.equalsIgnoreCase("firefox")) {
				// System.setProperty("webdriver.chrome.driver",
				// "./DriverFiles/chromedriver1.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
				driver = new EdgeDriver();
			}
			System.out.println("Successfully launch brwser "+browser);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("Failure to launch browser "+browser);
		}
		return driver;
	}

}
