package org.softlang.company.features;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Unparsing {

	/**
	 * Write the JsonTree root to file
	 * 
	 * @param root
	 * @param file
	 */
	public static void unparse(JsonNode root, File file) {
		ObjectMapper mapper = new ObjectMapper();
		PrettyPrinter printer = new DefaultPrettyPrinter();
		ObjectWriter writer = mapper.writer(printer);
		file.getParentFile().mkdirs();
		try {
			writer.writeValue(file, root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
