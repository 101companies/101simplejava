package org.softlang.company.features;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.softlang.company.model.Company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Unparsing {

	/**
	 * Method to parse a Company to a JSON File
	 * 
	 * @param company Company to be parsed to a JSON File
	 * @param path    Destination Path for the JSON File
	 * @throws IOException
	 */
	public static void unparseToFile(Company comapny, String path) throws IOException {
		unparseToFile(comapny, new File(path));
	}

	/**
	 * Method to parse a Company to a JSON File
	 * 
	 * @param company Company to be parsed to a JSON File
	 * @param file    Destination File for the JSON File
	 * @throws IOException
	 */
	public static void unparseToFile(Company company, File file) throws IOException {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		try (FileWriter writer = new FileWriter(file)) {
			gson.toJson(company, writer);
		}
	}

	/**
	 * Method to parse a Company to a JSON String
	 * 
	 * @param company Company to be parsed to a JSON File
	 * @return a String representing the JSON File of the company
	 */
	public static String unparse(Company company) {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		Gson gson = builder.create();
		return gson.toJson(company);
	}

}
