package flobiz.tests;

import java.util.Iterator;
import flobiz.utils.ExtentReportsUtility;
import flobiz.utils.FileUtility;

public class BaseTest {

	public FileUtility file;
	public ExtentReportsUtility report;

	public BaseTest() {
		beforeTest();
	}

	public void beforeTest() {
		System.out.println("TEST RUN STARTED");
		file = new FileUtility();
		file.loadConfigFile();
		report = new ExtentReportsUtility();
		report.setExtentReportsConfig(FileUtility.configFile.getProperty("reportsFilePath"),
				FileUtility.configFile.getProperty("reportsConfigFile"));
	}

	// Retrieves Data from CSV based on the Section and CSV FileName
	public Iterator<Object[]> getTestData(String section, String csvFileName) {
		FileUtility file = new FileUtility();
		return file.readCSVFile(section, csvFileName);
	}
}
