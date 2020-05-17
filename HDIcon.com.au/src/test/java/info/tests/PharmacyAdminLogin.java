package info.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import info.common.CommonActions;
import info.common.CommonEngine;
import info.pages.CreateCustomerPage;
import info.pages.HomePage;
import info.pages.LoginPage;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

public class PharmacyAdminLogin {

	public void homePage() {

		// Launch browser
		CommonEngine commonEng = new CommonEngine();
		WebDriver driver = commonEng.launchBrowser("chrome");

		CommonActions actions = new CommonActions();
		actions.navigateUrl(driver);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Pereform login
		LoginPage loginPage = new LoginPage(driver);
		loginPage.performLogin("pharmacy.admin2@epichubqa.onmicrosoft.com", "EpicNPQA@987!");

		// Select create customer
		actions.clickObj(driver, HomePage.ele_CreateCustomer, "Create Csutomer");

		// Perform Registraction
		CreateCustomerPage createCustomerPage = new CreateCustomerPage(driver);
		createCustomerPage.enterPersonalDetails("Joe", "Phillip", "01/01/2019", "13 Toorak Street", "TOOTGAROOK",
				"4069");
		createCustomerPage.enterMedicareInfo();
		//createCustomerPage.enterMedicalSeveces();

		/*
		 * actions.enterText(driver, By.cssSelector("#email"),
		 * "pharmacy.admin2@epichubqa.onmicrosoft.com","Email");
		 * actions.enterText(driver, By.id("password"), "EpicNPQA@987!","Password");
		 * actions.clickObj(driver, By.xpath("//button[text()='Sign in']"),"Sign in");
		 */

		/*
		 * actions.clickObj(driver,
		 * By.xpath("//input[@name='patient-title-inner-input']"), "Title");
		 * actions.clickObj(driver, By.xpath(
		 * "//form[@id='patient-details-form']/div/div[1]/div//span/div/div[1]/span"),
		 * "Select Title"); actions.enterText(driver,
		 * By.id("txt-firstname"),"Joe","FirstName");
		 * actions.enterText(driver,By.name("patient-surname"),"Philip","LastName");
		 * actions.enterText(driver, By.id("txt-dob"), "01/01/2019", "DOB");
		 * actions.clickObj(driver, By.name("patient-gender"),"Gender");
		 * actions.enterText(driver, By.name("street"),"13 Toorak Street","Street");
		 * actions.enterText(driver, By.id("suburb"), "TOOTGAROOK", "Suburb");
		 * actions.clickObj(driver,By.name("state-inner-input"),"State");
		 * actions.clickObj(driver,
		 * By.xpath("//div[@data-test-id='state']/div/span/div/div/span"),
		 * "SelectState"); actions.enterText(driver, By.id("postCode"), "4069",
		 * "PostCode"); actions.clickObj(driver,By.xpath(
		 * "//div[@class='inner-container']//button[@type='button']"), "NextButton");
		 * try { Thread.sleep(3000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } actions.clickObj(driver,
		 * By.
		 * xpath("//div[@class='el-col el-col-12 epic-column right-buttons']/child::*"),
		 * "MedicationNext"); actions.clickObj(driver,
		 * By.xpath("//div[@class='patient-creation-step']//button[@type='button']"),
		 * "ClickOnAddService"); actions.clickObj(driver,
		 * By.xpath("//input[@name='serviceType-inner-input']"), "ClickonService");
		 * actions.clickObj(driver,
		 * By.xpath("//div[@data-test-id='service-type']/div/span/div/div[1]"),
		 * "SelectService"); actions.clickObj(driver, By.name("facility-inner-input"),
		 * "ClickOnFacility"); actions.clickObj(driver,
		 * By.xpath("//div[@data-test-id='facility']/div/span/div/div[3]/span"),
		 * "SelectFacility"); actions.clickObj(driver,
		 * By.xpath("//input[@name='ward-inner-input']"), "ClickOnWard");
		 * actions.clickObj(driver,
		 * By.xpath("//div[@data-test-id='ward']/div/span/div/div[2]"), "SelectWard");
		 * actions.clickObj(driver,
		 * By.xpath("//div[@class='vue-dialog-footer']/button[2]"),"AddServiceButton");
		 * 
		 * 
		 * /* System.setProperty("webdriver.chrome.driver",
		 * "./DriverFiles/chromedriver1.exe"); WebDriver driver = new ChromeDriver();
		 * 
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * driver.get("https://qa.epicdigitalau.com/auth/login#/");
		 * driver.manage().window().maximize();
		 * 
		 * driver.findElement(By.cssSelector("#email")).sendKeys(
		 * "pharmacy.admin2@epichubqa.onmicrosoft.com");
		 * driver.findElement(By.id("password")).sendKeys("EpicNPQA@987!");
		 * driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		 * 
		 * String text =
		 * driver.findElement(By.xpath("//div[@class='circle__content']")).getText();
		 * //System.out.println(text);
		 * 
		 * if(text.equals("AM")) {
		 * 
		 * System.out.println("True"); }else { System.out.println("False"); }
		 * 
		 * String text1 =
		 * driver.findElement(By.cssSelector("#content .container h2")).getText();
		 * System.out.println(text1); Assert.assertEquals(text1,
		 * "Associated Business Units"); driver.quit();
		 */
		// actions.closeBrowser(driver);

	}

	public static void main(String[] args) {

		PharmacyAdminLogin pa = new PharmacyAdminLogin();
		pa.homePage();

	}

}
