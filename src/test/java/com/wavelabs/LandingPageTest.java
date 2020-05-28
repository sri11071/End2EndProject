package com.wavelabs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wavelabs.pageobject.HomePage;
import com.wavelabs.pageobject.LoginPage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPageTest extends BaseTest {
	public static Logger log = org.apache.logging.log4j.LogManager.getLogger(LandingPageTest.class.getName());
	public WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void initi() {
		driver = initializeDriver();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	@Test(dataProvider = "getData")
	public void loginUser(String email, String password) {

		String URL = pos.getProperty("url");
		driver.get(URL);
		HomePage hp = new HomePage(driver, wait);
		LoginPage lp = hp.LoginClick();
		lp.getEmailId().sendKeys(email);
		lp.getPassword().sendKeys(password);
		lp.getLoginButton().click();

		log.info(driver.getCurrentUrl());
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		// fileInputStream argument

		String projectPath = System.getProperty("user.dir") + File.separator;
		String filePath = projectPath + "src" + File.separator + "test" + File.separator + "resources" + File.separator
				+ "data" + File.separator;
		String fileName = "DataDrivenDemo.xlsx";
		FileInputStream fis = new FileInputStream(filePath + fileName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet mySheet = workbook.getSheet("logindetails");
		log.info(mySheet.getSheetName());
		int rowCount = mySheet.getLastRowNum() + 1;
		log.debug("Row count is :" + rowCount);
		XSSFRow row = mySheet.getRow(0);
		int colCount = row.getLastCellNum();
		log.debug("Column Count : " + colCount);

		Object[][] data = new Object[rowCount][colCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i][j] = mySheet.getRow(i).getCell(j).getStringCellValue();
				log.info("Row details  " + i + " column details J:" + j);
				log.info(mySheet.getRow(i).getCell(j).getStringCellValue() + "\t");

			}
		}
		workbook.close();
		return data;

	}

}
