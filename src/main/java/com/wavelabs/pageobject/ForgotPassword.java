package com.wavelabs.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassword extends BasePage {

	private WebElement driver;
	private WebDriverWait wait;

	public ForgotPassword(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	private By email = By.cssSelector("[id='user_email']");
	private By sendMeInstructions = By.cssSelector("[type='submit']");

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement sendMeInstructions() {
		return driver.findElement(sendMeInstructions);
	}

}
