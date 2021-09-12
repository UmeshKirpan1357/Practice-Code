package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtil;

public class TaskPage extends TestBase{

	
	//Action objecty
	Actions action=TestUtil.actionMethod();
	// Page factory
	
	@FindBy(xpath = "//span[contains(text(), 'Tasks')]")
	WebElement Tasklink;
	
	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[1]")
	WebElement TaskPagetTitle;

	public TaskPage() {
		PageFactory.initElements(driver, this);

	}
	
	public String validateTasksPageTitle() {
		action.moveToElement(Tasklink).click().perform();
		
		System.out.println("validateTasksPageTitle method");
		return TaskPagetTitle.getText();

	}
}
