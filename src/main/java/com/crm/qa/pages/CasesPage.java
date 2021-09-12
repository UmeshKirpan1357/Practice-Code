package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtil;

public class CasesPage extends TestBase{

	//Action objecty
	Actions action=TestUtil.actionMethod();
	// Page factory
	
	@FindBy(xpath = "//span[contains(text(), 'Cases')]")
	WebElement Caseslink;
	
	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[1]")
	WebElement CasesPagetTitle;

	public CasesPage() {
		PageFactory.initElements(driver, this);

	}
	
	public String validateCasesPageTitle() {
		action.moveToElement(Caseslink).click().perform();
		
		System.out.println("ContactPage Titel method");
		return CasesPagetTitle.getText();

	}
}
