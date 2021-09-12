package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory or Object Repository

	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	WebElement LoginBtn;

	@FindBy(name = "email")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//div[contains(text(), 'Login')]")
	WebElement signinbtn;

	// Initilization page objects
	public LoginPage() {
		// PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLoginBtn() {
		return LoginBtn.isDisplayed();
	}
	
	public boolean validateLoginBtnDisplayed() {
		return LoginBtn.isEnabled();
	}

	public HomePage validateLogin(String un, String pwd) {
		LoginBtn.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		signinbtn.click();

		return new HomePage();
	}

}
