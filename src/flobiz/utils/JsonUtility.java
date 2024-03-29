package flobiz.utils;

import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;

public class JsonUtility {

	public Object createTemplate(String jsonModel) {
		try {
			Gson gson = new Gson();
			String jsonFilePath = "./src/flobiz/Templates/JSONTemplates/" + jsonModel + ".JSON";
			// Dynamically create reference of classes
			Class<?> classRef = Class.forName("flobiz.servicecontracts." + jsonModel);
			FileReader reader = new FileReader(jsonFilePath);
			Object object = gson.fromJson(reader, classRef);

			return object;
		} catch (ClassNotFoundException | IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
