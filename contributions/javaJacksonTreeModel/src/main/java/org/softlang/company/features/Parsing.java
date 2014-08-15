package org.softlang.company.features;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parsing {

	/**
	 * Parse the company in the JSON-file file to a JSONTree
	 * 
	 * @param file
	 */
	public static JsonNode parseFromFile(File file) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = null;
		try {
			root = mapper.readTree(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return root;
	}

	/**
	 * 
	 * Parse the company from the String jsonString to a JSONTree
	 * 
	 */
	public static JsonNode parse(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = null;
		try {
			root = mapper.readTree(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return root;
	}
}
