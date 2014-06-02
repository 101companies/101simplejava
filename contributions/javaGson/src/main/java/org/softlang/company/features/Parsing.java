package org.softlang.company.features;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;

public class Parsing {
	
	/**
	 * Method to parse a JSON file 
	 * @param file Path for JSON file
	 * @return	a JsonObject representing the JSON file
	 */
	public static JsonObject parseFromFile(String file) {
		JsonObject res = null;
		try {
			JsonStreamParser parser = new JsonStreamParser(new FileReader(file));
			if (parser.hasNext())
				res = parser.next().getAsJsonObject();
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
	public static JsonObject parse(String jsonString) {
		JsonObject res = null;
		JsonStreamParser parser = new JsonStreamParser(jsonString);
		if (parser.hasNext())
			res = parser.next().getAsJsonObject();
		return res;
	}
}
