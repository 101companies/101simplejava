package org.softlang.company.features;

import java.io.File;
import java.io.IOException;

import org.softlang.company.model.Company;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Parsing {

	/**
	 * Parse a JSON-file containing a 101companies-structure to a POJO company
	 * representation
	 * 
	 */
	public static Company parse(File file) {
		ObjectMapper mapper = new ObjectMapper();
		Company company = null;
		try {
			company = mapper.readValue(file, Company.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return company;
	}

}
