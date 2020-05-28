package com.wavelabs.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {

	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);

	}
	
	@FindBy(xpath="//h2[text()='Featured Courses']")
	WebElement contenttitile;
	
	@FindBy(xpath="//a[text()='Contact']")
	WebElement contact_link;

	@FindBy(css = "div[class='sumome-react-svg-image-container']")
	WebElement closepopup;

	@FindBy(css = "a[href*='sign_in']")
	WebElement login_link;

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
