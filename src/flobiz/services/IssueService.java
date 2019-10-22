package flobiz.services;

import flobiz.utils.JsonUtility;
import flobiz.servicecontracts.CreateIssueModel;
import flobiz.servicecontracts.ModifyIssueModel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IssueService extends BaseService {

	private JsonUtility model;

	public IssueService() {
		model = new JsonUtility();
	}

	public Response getAllIssue() {
		String url = getAPI("General", "GetAllIssue");
		Response response = (Response) request.get(url).then().contentType(ContentType.JSON).extract();

		return response;
	}

	public Response getIssueById(String issueId) {
		String url = String.format(getAPI("General", "GetIssueById"), issueId);
		Response response = (Response) request.get(url).then().contentType(ContentType.JSON).extract();

		return response;
	}

	public Response getIssueByQueryParam(String queryParam) {
		String url = String.format(getAPI("General", "GetIssueByQueryParam"), queryParam);
		Response response = (Response) request.get(url).then().contentType(ContentType.JSON).extract();

		return response;
	}

	public Response createIssue(String description, String fromEmail, String title) {
		String url = String.format(getAPI("General", "CreateIssue"));

		CreateIssueModel issue = (CreateIssueModel) model.createTemplate("CreateIssueModel");
		issue.setDescription(description);
		issue.setEmail(fromEmail);
		issue.setTitle(title);

		request.body(issue);

		Response response = (Response) request.post(url).then().contentType(ContentType.JSON).extract();

		return response;
	}

	public Response modifyIssue(String issueId, String title) {
		String url = String.format(getAPI("General", "ModifyIssue"), issueId);

		ModifyIssueModel issue = (ModifyIssueModel) model.createTemplate("ModifyIssueModel");
		issue.setTitle(title);

		request.body(issue);

		Response response = (Response) request.put(url).then().contentType(ContentType.JSON).extract();

		return response;
	}
}
