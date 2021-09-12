package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class CalenderPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	CalenderPage calenderPage;
	
	public CalenderPageTest() {
	super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		calenderPage= new CalenderPage();
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage.validateCalenderPage();
	}
	
	@Test
	public void validateCalenderTest() {
		Assert.assertEquals(calenderPage.validateCalenderPageTitle(), "Calendar");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
