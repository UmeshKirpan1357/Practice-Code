package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class CasesPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	CalenderPage calenderPage;
	CasesPage casePage;
	public CasesPageTest() {
	super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		calenderPage= new CalenderPage();
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		casePage=new CasesPage();
	}
	
	@Test
	public void validateCasesPageTitleTest() {
		Assert.assertEquals(casePage.validateCasesPageTitle(), "Cases");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
