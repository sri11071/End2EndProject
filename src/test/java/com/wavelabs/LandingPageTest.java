package com.wavelabs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wavelabs.pageobject.HomePage;
import com.wavelabs.pageobject.LoginPage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPageTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void loginUser(String email, String password) {
		driver = initializeDriver();
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

		FileInputStream fis = new FileInputStream("C://Users//vnalla//Desktop//DataDrivenDemo.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet mySheet = workbook.getSheet("logindetails");
		log.info(mySheet.getSheetName());
		int rowCount = mySheet.getLastRowNum()+1;
		log.debug("Row count is :" + rowCount);
		XSSFRow row = mySheet.getRow(0);
		int colCount = row.getLastCellNum();
		log.debug("Column Count : " + colCount);

		Object[][] data = new Object[rowCount][colCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				data[i][j] = mySheet.getRow(i).getCell(j).getStringCellValue();
				log.info("Row details  "+i +" column details J:"+j);
				log.info(mySheet.getRow(i).getCell(j).getStringCellValue() + "\t");	

			}
		}
		workbook.close();
		return data;

	}

}
