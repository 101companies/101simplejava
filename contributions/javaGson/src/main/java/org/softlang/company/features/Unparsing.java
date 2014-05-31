package org.softlang.company.features;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Unparsing {
	public static void unparseToFile(JsonObject j, String file) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		try {
			FileWriter writer = new FileWriter(file);
			gson.toJson(j, writer);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String unparse(JsonObject o) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		String json = gson.toJson(o);
		return json;
	}

}
