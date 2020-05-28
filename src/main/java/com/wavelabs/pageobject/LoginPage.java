package com.wavelabs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);

	}

	@FindBy(id = "user_email")
	private WebElement emailId;

	@FindBy(id = "user_password")
	private WebElement Password;

	@FindBy(xpath = "//input[@value='Log In']")
	private WebElement LoginButton;

	@FindBy(css = "[href*='password/new']")
	private WebElement forgotPassword;

	public WebElement getLoginButton() {
		return LoginButton;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getPassword() {
		return Password;
	}

	public ForgotPassword forgotPassword() {
		forgotPassword.click();
		return new ForgotPassword(driver, wait);

	}

}
