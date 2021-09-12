package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.CustomListener;
import com.crm.qa.utils.Excel_Reader;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
@Listeners(CustomListener.class)
public class ContactPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	
	public ExtentTest logger;
	
	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage.validateContactPage();
		contactPage = new ContactPage();
	}

	@Test(enabled = true)
	public void validateContactPageTitleTest() {
		Assert.assertEquals(contactPage.validateContactPageTitle(), "Cont3acts");
		System.out.println("I am inside the contact test method");
		//logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	}

//	@DataProvider
//	public void getTestData() {
//			//Rows stands for how mmany diff data 	type test should run
//			//column stands for how many values per each test
//		Object [][] data=new Object[4][4];
//		
//	}

	@Test(enabled=false)
	public void validateCreateNewContactTest() throws InterruptedException {
		Excel_Reader reader = new Excel_Reader(
				"D:\\AutomationPractice\\FreeCRMTest\\src\\main\\resources\\FreeCRMData.xlsx");

		int rowCount = reader.getRowCount("Contacts");

		for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

			String FirstName = reader.getCellData("Contacts", "First_Name", rowNum);
			System.out.println(FirstName);

			String MiddleName = reader.getCellData("Contacts", "Middle_Name", rowNum);
			System.out.println(MiddleName);

			String LastName = reader.getCellData("Contacts", "Last_Name", rowNum);
			System.out.println(LastName);

			String Description = reader.getCellData("Contacts", "Last_Name", rowNum);
			System.out.println(Description);

			contactPage.validateCreateNewContact(FirstName, MiddleName, LastName, Description);
		}
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, "Test Case Fail name is "+result.getName());
			logger.log(LogStatus.FAIL, "Test  Case Fail "+ result.getThrowable());
			
			String screenShotPath=failed(result.getName());
		}
		driver.quit();
	}
}
