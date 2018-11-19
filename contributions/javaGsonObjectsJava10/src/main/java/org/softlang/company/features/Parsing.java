package org.softlang.company.features;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.softlang.company.model.Company;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Parsing {

	/**
	 * Method to parse a JSON file to a Company
	 * 
	 * @param path Path to the JSON file
	 * @return a Company representing the JSON file
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static Company parseFromFile(String path) throws FileNotFoundException, IOException {
		return parseFromFile(new File(path));
	}

	/**
	 * Method to parse a JSON file to a Company
	 * 
	 * @param file Path for JSON file
	 * @return a Company representing the JSON file
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static Company parseFromFile(File file) throws FileNotFoundException, IOException {
		Gson gson = new Gson();
		try (JsonReader read = new JsonReader(new FileReader(file))) {
			return gson.fromJson(read, Company.class);
		}
	}

	/**
	 * Method to parse a JSON String to a Company
	 * 
	 * @param jsonString String containing JSON
	 * @return a Company representing the JSON from the jsonString
	 */
	public static Company parse(String jsonString) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, Company.class);
	}
}
