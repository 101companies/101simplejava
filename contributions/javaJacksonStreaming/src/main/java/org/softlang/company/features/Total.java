package org.softlang.company.features;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class Total {
	/**
	 * Get total of the company in JSON-file company
	 * 
	 * @param company
	 */
	public static double total(File company) {
		JsonFactory factory = new JsonFactory();
		JsonParser parser;
		double result = 0.0;
		try {
			parser = factory.createParser(company);
			for (JsonToken token = parser.nextToken(); token != null; token = parser
					.nextToken()) {
				if (token == JsonToken.VALUE_NUMBER_FLOAT)
					if (parser.getCurrentName().equals("salary"))
						result += parser.getDoubleValue();
			}
			parser.close();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
