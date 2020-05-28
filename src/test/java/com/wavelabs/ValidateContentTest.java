package com.wavelabs;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wavelabs.pageobject.HomePage;

public class ValidateContentTest extends BaseTest {

	public static Logger log = org.apache.logging.log4j.LogManager.getLogger(ValidateContentTest.class.getName());
	public WebDriver driver;
	@BeforeMethod
	public void initi() {
		driver = initializeDriver();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test()
	public void validatecontent() {
		String URL = pos.getProperty("url");
		driver.get(URL);
		HomePage hp = new HomePage(driver, wait);
		Assert.assertEquals(hp.ContactLink().isDisplayed(), true);
		log.info("Element is displyed");
		Assert.assertEquals(hp.getContenttitile().getText(), "FEatured Courses");
		log.info("Comparing context ... ");
		hp.ContactLink().click();

	}

}
