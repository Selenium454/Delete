package HDIcon.com.au.HDIcon.com.au;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

public class PharmacyAdminLogin {

	public void homePage() {

		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get("https://qa.epicdigitalau.com/auth/login#/");
		driver.get("https://dev-fe-ingress.healthdir-dev.com/auth/login#/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#email")).sendKeys("pharmacy.admin2@epichub.onmicrosoft.com");
		driver.findElement(By.id("password")).sendKeys("EpicNPDEV@987!");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		String text = driver.findElement(By.xpath("//div[@class='circle__content']")).getText();
		//System.out.println(text);
		
		if(text.equals("AM")) {
			
			System.out.println("True");
		}else {
			System.out.println("False");
		}

		String text1 = driver.findElement(By.cssSelector("#content .container h2")).getText();
		System.out.println(text1);
		Assert.assertEquals(text1, "Associated Business Units");
		driver.quit();
	}

	public static void main(String[] args) {

		PharmacyAdminLogin pa = new PharmacyAdminLogin();
		pa.homePage();

	}

}
