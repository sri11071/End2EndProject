package com.wavelabs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wavelabs.pageobject.HomePage;
import com.wavelabs.pageobject.LoginPage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageTest extends BaseTest {

	@Test()
	public void loginUser() {
		driver = initializeDriver();
		String URL = pos.getProperty("url");
		driver.get(URL);
		HomePage hp = new HomePage(driver, wait);
		Assert.assertEquals(hp.ContactLink().isDisplayed(), true);
		hp.ContactLink().click();

	}

	

}
