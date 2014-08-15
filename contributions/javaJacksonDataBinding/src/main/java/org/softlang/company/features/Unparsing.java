package org.softlang.company.features;

import java.io.File;
import java.io.IOException;

import org.softlang.company.model.Company;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Unparsing {

	/**
	 * Write company c to file f in JSON-format
	 * 
	 * 
	 */
	public static void unparse(Company c, File f) {
		ObjectMapper mapper = new ObjectMapper();

		PrettyPrinter printer = new DefaultPrettyPrinter();

		ObjectWriter writer = mapper.writer(printer);

		f.getParentFile().mkdirs();
		try {
			writer.writeValue(f, c);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
