package org.softlang.company.features;

import java.io.FileReader;
import java.io.IOException;

import org.softlang.company.model.Company;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Parsing {
	/**
	 * 
	 * Method to parse a JSON file 
	 * @param file Path for JSON file
	 * @return	a JsonObject representing the JSON file
	 */
	public static Company parseFromFile(String file) {
		Gson gson = new Gson();
		JsonReader read;
		Company res = new Company("");
		try {
			read = new JsonReader(new FileReader(file));

			res = gson.fromJson(read, res.getClass());
			read.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	/**
	 * 
	 * @param jsonString String containing JSON
	 * @return a JsonObject representing the JSON from the string
	 */
	public static Company parse(String jsonString) {
		Gson gson = new Gson();
		Company res = new Company("");
		gson.fromJson(jsonString, res.getClass());
		return res;
	}
}
