package com.wavelabs.testnglisterns;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentedReportsNG {

	static ExtentReports er;

	public static ExtentReports getExtentReports() {
		String reportsFile = System.getProperty("user.dir") + File.separator + "reports" +File.separator+ "index.html";
		ExtentSparkReporter esr = new ExtentSparkReporter(reportsFile);
		esr.config().setReportName("SeleniumWithCI results");
		esr.config().setDocumentTitle("SeliniumWithCI report");

		er = new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("Tester", "Srinivas");
		return er;
	}

}
