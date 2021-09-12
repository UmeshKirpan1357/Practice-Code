package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	DealsPage dealsPage;
	CompaniesPage companiesPage;
	TaskPage taskPage;
	CasesPage casesPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();

		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void validateLoggedInUserNameTest() {
		Assert.assertEquals(homePage.validateLoggedInUserName(), "Umesh Kirpan", "Logged In User name is not matched");
		System.out.println("User Name Test");
	}

	@Test(priority = 2)
	public void validateContactPageLinkTest() {
		contactPage = homePage.validateContactPage();
		System.out.println("Contact Page Test");
	}

	@Test(priority = 3)
	public void validateDealsPageLinkTest() {
		dealsPage = homePage.validateDealsPage();
		System.out.println("Deals Page Test");
	}
	
	@Test(priority = 4)
	public void validateCompaniesPageLinkTest() {
		companiesPage = homePage.validateCompaniesPage();
		System.out.println("Companies Page Test");
	}
	
	@Test(priority = 5)
	public void validateTaskPageLinkTest() {
		taskPage = homePage.validateTaskPage();
		System.out.println("Task Page Test");
	}
	
	@Test(priority = 6)
	public void validateCasesPageLinkTest() {
		casesPage = homePage.validateCasesPage();
		System.out.println("Cases Page Test");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
