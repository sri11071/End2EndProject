package com.wavelabs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	WebDriverWait wait;
	WebDriver driver;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);

	}

	@FindBy(id = "user_email")
	WebElement emailId;
	
	@FindBy(id = "user_password")
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Log In']")
	WebElement LoginButton;
	
	public WebElement getLoginButton() {
		return LoginButton;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getPassword() {
		return Password;
	}
	
	

}
