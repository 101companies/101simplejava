package org.softlang.company.features;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;

public class Parsing {

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

	public static JsonObject parse(String jsonString) {
		JsonObject res = null;
		JsonStreamParser parser = new JsonStreamParser(jsonString);
		if (parser.hasNext())
			res = parser.next().getAsJsonObject();
		return res;
	}
}
