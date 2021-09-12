package com.crm.qa.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.utils.TestUtil;

public class ContactPage extends TestBase {

	//Action objecty
	Actions action=TestUtil.actionMethod();
	// Page factory
	
	@FindBy(xpath = "//span[contains(text(), 'Contacts')]")
	WebElement Contactslink;
	
	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[1]")
	WebElement ContactPagetTitle;

	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/a/button")
	WebElement CreateBtn;
	
	@FindBy(name="first_name")
	WebElement First_Name;
	
	@FindBy(name="middle_name")
	WebElement Middle_Name;
	
	@FindBy(name="last_name")
	WebElement Last_Name;
	
	@FindBy(name="description")
	WebElement Description;
	
	@FindBy(xpath="//input[@name='value' and @placeholder='Email address']")
	WebElement Email;
	
	@FindBy(xpath="//div[@class='item']/button[2] //i[@class='save icon']")
	WebElement SaveBtn;
	
	//Made action object reference  static and accessing
		WebDriverWait wait=TestUtil.ExplicitWait();
		
	public ContactPage() {
	
		PageFactory.initElements(driver, this);
	
	}

	public String validateContactPageTitle() {
		action.moveToElement(Contactslink).click().perform();
		
		System.out.println("ContactPage Titel method");
		return ContactPagetTitle.getText();

	}
	public void validateCreateNewContact(String FirstName, String MiddleName, String LastName, String Desc) throws InterruptedException {
	
		wait.until(ExpectedConditions.visibilityOf(CreateBtn));
		
		CreateBtn.click();
		
		First_Name.sendKeys(FirstName);
		
		Middle_Name.sendKeys(MiddleName);
		
		Last_Name.sendKeys(LastName);
		
		Description.sendKeys(Desc);
		
		SaveBtn.click();
		Thread.sleep(3000);
		action.moveToElement(Contactslink).build().perform();
		Contactslink.click();
		Thread.sleep(3000);
		
	}
}
