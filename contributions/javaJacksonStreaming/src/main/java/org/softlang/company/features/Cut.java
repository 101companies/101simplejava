package org.softlang.company.features;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class Cut {
	/**
	 * Cut all salaries of the company in file input and write it to file output
	 * 
	 * @param input
	 * @param output
	 */
	public static void cut(File input, File output) {
		JsonFactory factory = new JsonFactory();
		JsonParser parser;
		JsonGenerator generator;
		output.getParentFile().mkdirs();
		try {
			parser = factory.createParser(input);
			generator = factory.createGenerator(new FileWriter(output));
			generator.useDefaultPrettyPrinter();
			generator.enable(JsonGenerator.Feature.AUTO_CLOSE_TARGET);
			for (JsonToken token = parser.nextToken(); token != null; token = parser
					.nextToken()) {
				if (token == JsonToken.VALUE_NUMBER_FLOAT) {
					if (parser.getCurrentName().equals("salary"))
						generator.writeNumber(parser.getDoubleValue() / 2);
				} else {
					generator.copyCurrentEvent(parser);
					// generator.copyCurrentStructure(parser);
				}
			}
			parser.close();
			generator.flush();
			generator.close();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cut all salaries of the company in file f and write it back to f
	 * 
	 * @param input
	 * @param output
	 */
	public static void cut(File f) {
		JsonFactory factory = new JsonFactory();
		JsonParser parser;
		JsonGenerator generator;
		f.getParentFile().mkdirs();
		try {
			parser = factory.createParser(f);
			generator = factory.createGenerator(new FileWriter(f));
			generator.useDefaultPrettyPrinter();
			generator.enable(JsonGenerator.Feature.AUTO_CLOSE_TARGET);
			for (JsonToken token = parser.nextToken(); token != null; token = parser
					.nextToken()) {
				if (token == JsonToken.VALUE_NUMBER_FLOAT) {
					if (parser.getCurrentName().equals("salary"))
						generator.writeNumber(parser.getDoubleValue() / 2);
				} else {
					generator.copyCurrentEvent(parser);
					// generator.copyCurrentStructure(parser);
				}
			}
			parser.close();
			generator.flush();
			generator.close();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
