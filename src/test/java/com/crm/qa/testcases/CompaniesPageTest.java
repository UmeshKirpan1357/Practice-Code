package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalenderPage;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class CompaniesPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	CompaniesPage companiesPage;
	
	//Fetch the properties
	public CompaniesPageTest() {
	super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		companiesPage=new CompaniesPage();
	}
	
	@Test
	public void validateCompaniesPageTitleTest() {
		Assert.assertEquals(companiesPage.validateCompaniesPageTitle(), "Companies");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
