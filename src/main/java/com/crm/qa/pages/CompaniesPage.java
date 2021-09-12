package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtil;

public class CompaniesPage extends TestBase {

	//Action object
	Actions action=TestUtil.actionMethod();
	
	// Page factory	
	@FindBy(xpath = "//span[contains(text(), 'Companies')]")
	WebElement Companieslink;
	
	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[1]")
	WebElement CompaniesPagetTitle;

	public CompaniesPage() {
		PageFactory.initElements(driver, this);

	}
	
	public String validateCompaniesPageTitle() {
		action.moveToElement(Companieslink).click().perform();
		
		System.out.println("CompaniesPagetTitle  method");
		return CompaniesPagetTitle.getText();

	}
}
