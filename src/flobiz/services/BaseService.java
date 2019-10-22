package flobiz.services;

import java.io.FileReader;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import flobiz.utils.FileUtility;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	protected RequestSpecification request;
	
	public void initializeRequest() {
		RestAssured.baseURI = FileUtility.configFile.getProperty("url");
		request = RestAssured.given()
				.header("Cache-Control","no-cache")
				.header("Content-Type","application/json")
				.header("x-apikey", "5da6fb5d3cbe87164d4bb35d")
				.when();
	}

	protected String getAPI(String section, String name) {
		initializeRequest();
		
		JSONParser parser = new JSONParser();
		String API = "";

		try {
			Reader reader = new FileReader(FileUtility.configFile.getProperty("apiPathFile"));
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			JSONObject module = (JSONObject) jsonObject.get(section);
			API = (String) module.get(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return API;
	}
}
