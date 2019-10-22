package flobiz.tests;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;

import flobiz.services.IssueService;

public class ModifyIssueTest extends BaseTest {

	private IssueService issue;

	private ModifyIssueTest() {
		issue = new IssueService();
	}

	@Test(dataProvider = "TestData")
	private void modifyIssueTest(String issueId, String title) {

		// Act
		Response response = issue.modifyIssue(issueId, title);

		// Assert
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("title"), title);
	}

	// Retrieves Data from CSV and runs the test multiple times for every set or
	// combination of data
	@DataProvider(name = "TestData")
	private Iterator<Object[]> dataProvider() {
		return getTestData("General", "ModifyIssueTest");
	}

}
