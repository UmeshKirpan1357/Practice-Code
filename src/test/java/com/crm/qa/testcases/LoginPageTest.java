package com.crm.qa.testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import jdk.internal.org.jline.utils.Log;

public class LoginPageTest extends TestBase {
	//initiate log object
	public static Logger log=LogManager.getLogger(LoginPageTest.class);
	// to call superclass constructor to call properties
	public LoginPageTest() {
		super();
		log.info("Fetching Base Driver Constructor --super() can be used to call parent class' constructors only.");
	}

	LoginPage loginPage;
	HomePage homePage;
	@BeforeMethod
	public void setUp() {
		initialization(); 
		log.info("calling chrome driver");//will call the chrome dirver and site url
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		Assert.assertEquals(loginPage.validatePageTitle(), "#1x`Free CRM customer relationship management software cloud");
		log.info("Verifying Ligin Page Title");
		log.error("Error in page title reading");
		log.debug("Page title");
	}
	
	@Test
	public void validateLoginBtnTest() {
		Assert.assertTrue(loginPage.validateLoginBtn());
	}
	
	@Test
	public void validateLoginBtnDisplayedTest() {
		
	Assert.assertTrue(loginPage.validateLoginBtnDisplayed());	
	}
	
	@Test(priority = 2)
	public void loginTest() {
	homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
		
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}

}
