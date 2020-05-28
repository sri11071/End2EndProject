package com.wavelabs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wavelabs.pageobject.HomePage;
import com.wavelabs.pageobject.LoginPage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPageTest extends BaseTest {

	@BeforeTest
	public void init() {
		driver = initializeDriver();

	}

	@Test(dataProvider = "getData")
	public void loginUser(String email, String password) {

		String URL = pos.getProperty("url");
		driver.get(URL);
		HomePage hp = new HomePage(driver, wait);
		hp.LoginClick();
		LoginPage lp = new LoginPage(driver, wait);
		lp.getEmailId().sendKeys(email);
		lp.getPassword().sendKeys(password);
		lp.getLoginButton().click();

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

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
