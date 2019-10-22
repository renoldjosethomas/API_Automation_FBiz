package flobiz.utils;

import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsUtility {

	private ExtentReports extent;
	private static ExtentTest test;
	private ExtentHtmlReporter htmlReporter;

	public void setExtentReportsConfig(String pathHTML, String fileXML) {
		htmlReporter = new ExtentHtmlReporter(new File(pathHTML));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("CASMEX Test Automation Report");
		htmlReporter.config().setReportName("End to End Test Scenario");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void testPass(String details) {
		test.pass(details);
	}

	public void testFail(String testName) {
		test.fail("TEST FAILED: " + testName);
	}

	public void logTestCase(String testName) {
		// Log PASS in Extent Report with the Pass Message
		test = extent.createTest(testName);
	}

	public void endExtentReports() {
		extent.flush();
	}
}