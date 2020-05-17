package info.common;

import static org.testng.Assert.assertFalse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class CommonActions {


	public void navigateUrl(WebDriver driver) {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("./Config.properties"));

			String environment = prop.getProperty("environment");
			String url = null;
			String email = null;
			String password = null;
			if (environment.equalsIgnoreCase("QA")) {
				url = prop.getProperty("Qa_Url");
				
			} else {
				url = prop.getProperty("Dev_Url");
				email = prop.getProperty("DevEmail");
				password = prop.getProperty("DevPassword");
			}
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Successfully navigate url");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Failure to navigate url");
		}

	}

	public void closeBrowser(WebDriver driver) {
		try {

			driver.quit();
			System.out.println("Successfully close browser");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Failure to close browser");
		}

	}
	
	public String getPropertyValue(String property) {
		String property_Value=null;
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("./Config.properties"));

			property_Value = prop.getProperty(property);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return property_Value;
	}

	public void enterText(WebDriver driver, By locator, String input, String msg, ExtentTest extentTest) {
		try {
			waitForElement(driver, locator);
			WebElement ele = driver.findElement(locator);
			hilightElement(driver, ele);
			ele.clear();
			ele.sendKeys(input);
			System.out.println("Sucessfully data entered" + msg);
			extentTest.log(Status.PASS, "Sucessfully data entered" + msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("failure to entered" + msg);
			extentTest.log(Status.FAIL, "Failure data entered" + msg);
			// takeScreenshot(driver, extentTest);
			Assert.fail("Failure data entered" + msg);

		}

	}

	public void enterText(WebDriver driver, By locator, String input, String msg) {
		try {
			waitForElement(driver, locator);
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(input);
			System.out.println("Sucessfully data entered" + msg);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("failure to entered" + msg);

		}

	}

	public void validateElementsDisplayed(WebDriver driver, By locator, String msg, ExtentTest extentTest) {

		try {
			
			driver.findElement(locator).isDisplayed();
			Assert.assertTrue(true);

			extentTest.log(Status.PASS, "Successfully Displayed  " + msg);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

			extentTest.log(Status.FAIL, "FAilure to Display  " + msg);
			Assert.fail("Failure to display  " + msg);
		}

	}

	public void validateElementsEnabled(WebDriver driver, By locator, String msg, ExtentTest extentTest) {

		try {
			
			// waitForElement(driver,locator);
			driver.findElement(locator).isEnabled();

			extentTest.log(Status.PASS, "Successfully enabled  " + msg);
			Assert.assertTrue(true);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Failure to click " + msg);
			extentTest.log(Status.FAIL, "FAilure to enabled  " + msg);

			Assert.fail("Failure to Click  " + msg);
		}

	}

	public void clickObj(WebDriver driver, By locator, String msg) {
		try {
			waitForElement(driver, locator);
			driver.findElement(locator).click();
			System.out.println("Successfully Click  " + msg);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Failure to click " + msg);
		}
	}

	public void clickObj(WebDriver driver, By locator, String msg, ExtentTest extentTest) {
		try {

			waitForElement(driver, locator);
			WebElement ele = driver.findElement(locator);
			hilightElement(driver, ele);
			ele.click();
			System.out.println("Successfully Click  " + msg);
			extentTest.log(Status.PASS, "Successfully Click  " + msg);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Failure to click " + msg);
			extentTest.log(Status.FAIL, "FAilure to Click  " + msg);
			// takeScreenshot(driver, extentTest);

			Assert.fail("FAilure to Click  " + msg);
		}
	}
	
	public void jsClickObj(WebDriver driver, By locator, String msg, ExtentTest extentTest) {
		try {

			waitForElement(driver, locator);
			WebElement ele = driver.findElement(locator);
			hilightElement(driver, ele);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", ele);
			//ele.click();
			System.out.println("Successfully Click  " + msg);
			extentTest.log(Status.PASS, "Successfully Click  " + msg);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Failure to click " + msg);
			extentTest.log(Status.FAIL, "FAilure to Click  " + msg);
			// takeScreenshot(driver, extentTest);

			Assert.fail("FAilure to Click  " + msg);
		}
	}

	public void clickRadio(WebDriver driver, By locator, String msg, ExtentTest extentTest) {
		try {
			// waitForElement(driver,locator);
			driver.findElement(locator).click();

			extentTest.log(Status.PASS, "Successfully Click  " + msg);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			System.out.println("Failure to click " + msg);
			extentTest.log(Status.FAIL, "FAilure to Click  " + msg);
		}
	}

	public String getElementText(WebDriver driver, By locator) {
		try {
			waitForElement(driver, locator);
			String text =  driver.findElement(locator).getText();
			 return text;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void waitForElement(WebDriver driver, By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			

		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e.getMessage());

		}
	}
	
	public void waitForElementNotVisable(WebDriver driver, By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			

		} catch (Exception e) {
			// TODO: handle exception
			// System.out.println(e.getMessage());

		}
	}
	
	public String randomString() {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 5;
		Random random = new Random();

		String randomString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return randomString;
	}

	public void hilightElement(WebDriver driver, WebElement ele) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].style.border='3px solid red'", ele);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void takeScreenshot(WebDriver driver, ExtentTest extentTest) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		Date d = new Date();
		String timeStamp = sf.format(d);

		TakesScreenshot screenShot = (TakesScreenshot) driver;
		// File s = screenShot.getScreenshotAs(OutputType.FILE);
		String s = screenShot.getScreenshotAs(OutputType.BASE64);
		try {
			// FileUtils.copyFile(s, new File("./Images/image"+timeStamp+".png" ));
			// extentTest.addScreenCaptureFromPath(System.getProperty("user.dir") +
			// "\\Images\\image"+timeStamp+".png" );
			extentTest.log(Status.INFO, "Screenshot",
					MediaEntityBuilder.createScreenCaptureFromBase64String(s).build());

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public String getBase64Image(WebDriver driver) {
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		// File s = screenShot.getScreenshotAs(OutputType.FILE);
		return screenShot.getScreenshotAs(OutputType.BASE64);
	}

	public void pauseExecution(int milleSec) {
		try {
			Thread.sleep(milleSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getAttributeValue(WebDriver driver, By by,String attribute,ExtentTest extentTest) {
	try {
		waitForElement(driver, by);
		String text=driver.findElement(by).getAttribute(attribute);
		extentTest.log(Status.PASS, "Successfully get attribut value  " + attribute);
		return text;
	} catch (Exception e) {
		// TODO: handle exception
		extentTest.log(Status.FAIL, "Failure to get attribut value  " + attribute);
		// takeScreenshot(driver, extentTest);
		return null;
	}	
	}
	
	public void selectElement(WebDriver driver,By by,String text)
	{
		waitForElement(driver, by);
		Select ele = new Select(driver.findElement(by));
		ele.selectByVisibleText(text);
		
	}

	public String getElements(WebDriver driver, By locator) {

		List<WebElement> list = driver.findElements(locator);
		for (int i = 0; i < list.size(); i++) {
			String text = list.get(i).getText();
			return text;
		}
		return null;

	}
	
	public List<WebElement> getListElements(WebDriver driver, By locator) {
		waitForElement(driver, locator);
		return driver.findElements(locator);	
	}
}


