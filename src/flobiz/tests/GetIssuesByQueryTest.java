package flobiz.tests;

import org.testng.annotations.Test;
import flobiz.services.IssueService;
import io.restassured.response.Response;

import java.util.Iterator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class GetIssuesByQueryTest extends BaseTest {

	private IssueService issue;

	private GetIssuesByQueryTest() {
		issue = new IssueService();
	}

	@Test(dataProvider = "TestData")
	private void getIssueByQueryTest(String query, String description, String title, String status) {

		// Act
		Response response = issue.getIssueByQueryParam(query);

		// Assert
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("description[0]"), description);
		Assert.assertEquals(response.jsonPath().getString("title[0]"), title);
		Assert.assertEquals(response.jsonPath().getString("status[0]"), status);

	}

	// Retrieves Data from CSV and runs the test multiple times for every set or
	// combination of data
	@DataProvider(name = "TestData")
	private Iterator<Object[]> dataProvider() {
		return getTestData("General", "GetIssueByQueryTest");
	}
}
