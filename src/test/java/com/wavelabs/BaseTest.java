package com.wavelabs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.utils.FileUtil;

public class BaseTest {

	WebDriverWait wait;
	WebDriver driver;
	Properties pos = new Properties();

	public static Logger log = org.apache.logging.log4j.LogManager.getLogger(BaseTest.class.getName());

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
		String browserType = System.getProperty("browser");
		// String browserType=pos.getProperty("browser");
		log.info("exectuion in browser   :" + browserType);
		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", dir + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserType.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", dir + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserType.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", dir + "\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Driver is started");
		return driver;
	}

	public String getScreenShot(String testcaseName, WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String screenshotfile = System.getProperty("user.dir") + File.separator + "reports" + File.separator
				+ testcaseName + ".png";
		log.info("Failed Screenshot file:" + screenshotfile);
		try {
			FileUtils.copyFile(source, new File(screenshotfile));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return screenshotfile;

	}

}