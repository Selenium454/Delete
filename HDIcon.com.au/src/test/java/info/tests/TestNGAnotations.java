package info.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnotations {
	
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void afterSuit() {
		System.out.println("after Suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");	
	}
	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");	
	}
	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before Method");	
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
	}
	@Test
	public void test1()
	{
		System.out.println("Test1");
	}

}
