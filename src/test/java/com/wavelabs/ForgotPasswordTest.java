package com.wavelabs;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wavelabs.pageobject.ForgotPassword;
import com.wavelabs.pageobject.HomePage;
import com.wavelabs.pageobject.LoginPage;

public class ForgotPasswordTest extends BaseTest {

	public static Logger log = org.apache.logging.log4j.LogManager.getLogger(ForgotPasswordTest.class.getName());
	WebDriver driver;

	@BeforeMethod
	public void initi() {
		driver = initializeDriver();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test()
	public void forGotPassword() {

		String URL = pos.getProperty("url");
		driver.get(URL);
		HomePage hp = new HomePage(driver, wait);
		LoginPage lp = hp.LoginClick();
		ForgotPassword fp = lp.forgotPassword();
		fp.getEmail().sendKeys("aasasdsad");
		fp.sendMeInstructions().click();

		log.info(driver.getCurrentUrl());
	}
}
