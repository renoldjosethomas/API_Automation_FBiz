package flobiz.tests;

import org.testng.annotations.Test;

import flobiz.services.IssueService;
import io.restassured.response.Response;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class CreateIssueTest extends BaseTest {

	private IssueService issue;

	private CreateIssueTest() {
		issue = new IssueService();
	}

	@Test(dataProvider = "TestData")
	private void createIssueTest(String description, String fromEmail, String title) {

		// Act
		Response response = issue.createIssue(description, fromEmail, title);

		// Assert
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(response.jsonPath().getString("description"), description);
		Assert.assertEquals(response.jsonPath().getString("fromEmail"), fromEmail);
		Assert.assertEquals(response.jsonPath().getString("title"), title);
	}

	// Retrieves Data from CSV and runs the test multiple times for every set or
	// combination of data
	@DataProvider(name = "TestData")
	private Iterator<Object[]> dataProvider() {
		return getTestData("General", "CreateIssueTest");
	}
}
