package flobiz.tests;

import org.testng.annotations.Test;

import flobiz.services.IssueService;
import io.restassured.response.Response;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class GetIssueByIdTest extends BaseTest {

	private IssueService issue;

	private GetIssueByIdTest() {
		issue = new IssueService();
	}

	@Test(dataProvider = "TestData")
	private void getIssueByIdTest(String id, String fromemail) {

		// Act
		Response response = issue.getIssueById(id);

		// Assert
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("fromemail"), fromemail);

	}

	// Retrieves Data from CSV and runs the test multiple times for every set or
	// combination of data
	@DataProvider(name = "TestData")
	private Iterator<Object[]> dataProvider() {
		return getTestData("General", "GetIssueByIdTest");
	}
}
