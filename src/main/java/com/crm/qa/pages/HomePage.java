package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtil;

public class HomePage extends TestBase {

	// Page Factory

	@FindBy(xpath = "//span[contains(text(), 'Umesh Kirpan')]")
	WebElement loggedinusername;

	@FindBy(xpath = "//span[contains(text(), 'Calendar')]")
	WebElement Calenderlink;

	@FindBy(xpath = "//span[contains(text(), 'Contacts')]")
	WebElement Contactslink;

	@FindBy(xpath = "//span[contains(text(), 'Companies')]")
	WebElement Companieslink;

	@FindBy(xpath = "//span[contains(text(), 'Deals')]")
	WebElement Dealslink;

	@FindBy(xpath = "//span[contains(text(), 'Tasks')]")
	WebElement Taskslink;

	@FindBy(xpath = "//span[contains(text(), 'Cases')]")
	WebElement Caseslink;
	
	//Made action method static and accessing
	Actions action=TestUtil.actionMethod();
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}

	public String validateLoggedInUserName() {
		return loggedinusername.getText();
	}

	public CalenderPage validateCalenderPage() {
		//Actions action = new Actions(driver);
		action.moveToElement(Calenderlink).click().perform();
		return new CalenderPage();

	}

	public ContactPage validateContactPage() {
		//Actions action = new Actions(driver);
		action.moveToElement(Contactslink).click().perform();
		return new ContactPage();
	}

	public DealsPage validateDealsPage() {
//		Actions action = new Actions(driver);
		action.moveToElement(Dealslink).click().perform();
		return new DealsPage();
	}

	public TaskPage validateTaskPage() {
		//Actions action = new Actions(driver);
		action.moveToElement(Taskslink).click().perform();
		return new TaskPage();
	}

	public CasesPage validateCasesPage() {
		//Actions action = new Actions(driver);
		action.moveToElement(Caseslink).click().perform();
		return new CasesPage();
	}

	public CompaniesPage validateCompaniesPage() {
		//Actions action = new Actions(driver);
		action.moveToElement(Companieslink).click().perform();
		return new CompaniesPage();
	}
	
	public void clickContactCreateBtn() {
		
	}
}
