package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

public class CalenderPage extends TestBase{

	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[1]")
	WebElement CalenderPagetTitle;
	
	
	@FindBy(xpath = "//span[contains(text(), 'Umesh Kirpan')]")
	WebElement loggedinusername;
	
	//Initilization page objects
	public CalenderPage() {
		//PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, this);  
	}
	
	//Actions
	public String validateCalenderPageTitle() {
		loggedinusername.click();
		return CalenderPagetTitle.getText();
	}
}
