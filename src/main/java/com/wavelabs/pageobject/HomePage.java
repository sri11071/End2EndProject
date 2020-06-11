package com.wavelabs.pageobject;

import java.util.List;

import org.openqa.selenium.By;
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

	@FindBy(xpath = "//button[text()='NO THANKS']")
	private WebElement pop_up;

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

	public List<WebElement> getPopUpElements() {
		return driver.findElements(By.xpath("//button[text()='NO THANKS']"));
	}

	public WebElement getPopUp() {
		return pop_up;
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
