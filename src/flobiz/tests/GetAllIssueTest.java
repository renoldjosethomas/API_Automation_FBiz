package flobiz.tests;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import flobiz.services.IssueService;
import io.restassured.response.Response;

public class GetAllIssueTest extends BaseTest {

	private IssueService issue;

	private GetAllIssueTest() {
		issue = new IssueService();
	}

	@Test(dataProvider = "TestData")
	private void getAllIssuesTest(String id001, String id002, String id003, String id004, String id005) {

		// Act
		Response response = issue.getAllIssue();

		// Assert

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.jsonPath().getString("_id[0]"), id001);
		Assert.assertEquals(response.jsonPath().getString("_id[1]"), id002);
		Assert.assertEquals(response.jsonPath().getString("_id[2]"), id003);
		Assert.assertEquals(response.jsonPath().getString("_id[3]"), id004);
		Assert.assertEquals(response.jsonPath().getString("_id[4]"), id005);
	}

	// Retrieves Data from CSV and runs the test multiple times for every set or
	// combination of data
	@DataProvider(name = "TestData")
	private Iterator<Object[]> dataProvider() {
		return getTestData("General", "GetAllIssueTest");
	}

}
