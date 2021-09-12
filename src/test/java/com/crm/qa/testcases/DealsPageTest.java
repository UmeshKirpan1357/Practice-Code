package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class DealsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;

	// Fetch the properties
	public DealsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();

		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		dealsPage = new DealsPage();
	}

	@Test
	public void validateDealsPageTitleTest() {
		Assert.assertEquals(dealsPage.validateDealsPageTitle(), "Deals");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
