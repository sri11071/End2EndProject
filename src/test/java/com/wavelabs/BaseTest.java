package com.wavelabs;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BaseTest {

	WebDriverWait wait;
	WebDriver driver;
	Properties pos = new Properties();

	public static Logger log = org.apache.logging.log4j.LogManager.getLogger(BaseTest.class.getName());

	@Test
	public WebDriver initializeDriver() {

		String dir = System.getProperty("user.dir");
		String datafile = dir + "\\src\\test\\resources\\data.properties";
		log.info(datafile);
		FileInputStream fis;
		try {
			fis = new FileInputStream(datafile);

			pos.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}
		String browserType = pos.getProperty("browser");

		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserType.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Selenium\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

}