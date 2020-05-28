package com.wavelabs.testnglisterns;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.wavelabs.BaseTest;

public class Listernes extends BaseTest implements ITestListener {

	ExtentReports extentedReportsNG = ExtentedReportsNG.getExtentReports();
	ExtentTest test;

	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extentedReportsNG.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test is passed");
	}

	public void onTestFailure(ITestResult result) {
		extentTest.get().log(Status.FAIL, result.getThrowable());
		extentTest.get().fail(result.getThrowable());

		WebDriver driver = null;
		String testcaseName = result.getMethod().getMethodName();

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
			String imagePath = getScreenShot(testcaseName, driver);
			extentTest.get().addScreenCaptureFromPath(imagePath, testcaseName);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		extentedReportsNG.flush();
	}

}
