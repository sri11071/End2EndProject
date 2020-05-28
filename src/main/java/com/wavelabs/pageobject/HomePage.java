package com.wavelabs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);

	}

	@FindBy(xpath = "//h2[text()='Featured Courses']")
	private WebElement contenttitile;

	@FindBy(xpath = "//a[text()='Contact']")
	private WebElement contact_link;

	@FindBy(css = "div[class='sumome-react-svg-image-container']")
	private WebElement closepopup;

	@FindBy(css = "a[href*='sign_in']")
	private WebElement login_link;

	public WebElement closepopup() {
		return closepopup;
	}

	public WebElement ContactLink() {
		return contact_link;
	}

	public WebElement getContenttitile() {
		return contenttitile;
	}

	public LoginPage LoginClick() {
		login_link.click();
		return new LoginPage(driver, wait);

	}

}
