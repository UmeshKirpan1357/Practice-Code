package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TaskPage;

public class TaskPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TaskPage tasksPage;

	// Fetch the properties
	public TaskPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();

		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		tasksPage = new TaskPage();
	}

	@Test
	public void validateDealsPageTitleTest() {
		Assert.assertEquals(tasksPage.validateTasksPageTitle(), "Tasks");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
