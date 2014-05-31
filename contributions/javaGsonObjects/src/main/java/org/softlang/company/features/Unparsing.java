package org.softlang.company.features;

import java.io.FileWriter;
import java.io.IOException;

import org.softlang.company.model.Company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Unparsing {
	public static void unparseToFile(Company c, String file) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			String json = gson.toJson(c);
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String unparse(Company c) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		String json = gson.toJson(c);
		return json;
	}

}
