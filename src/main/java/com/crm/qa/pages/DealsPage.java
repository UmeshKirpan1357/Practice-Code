package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtil;

public class DealsPage extends TestBase{

	
	//Action object
	Actions action=TestUtil.actionMethod();
	
	// Page factory	
	@FindBy(xpath = "//span[contains(text(), 'Deals')]")
	WebElement Dealslink;
	
	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[1]")
	WebElement DealsPagetTitle;

	public DealsPage() {
		PageFactory.initElements(driver, this);

	}
	
	public String validateDealsPageTitle() {
		action.moveToElement(Dealslink).click().perform();
		
		System.out.println("validateDealsPageTitle  method");
		return DealsPagetTitle.getText();

	}
	
}
