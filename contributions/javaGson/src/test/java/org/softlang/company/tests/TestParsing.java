package org.softlang.company.tests;

import java.io.File;

import org.junit.Test;
import org.softlang.company.features.Parsing;

public class TestParsing {

	@Test
	public void testParseFromFile() {
		String in = "inputs" + File.separator + "sampleCompany.json";
		Parsing.parseFromFile(in);
	}

}
