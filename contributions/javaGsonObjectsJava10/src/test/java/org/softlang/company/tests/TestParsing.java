package org.softlang.company.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.softlang.company.features.Parsing;
import org.softlang.company.model.Company;

public class TestParsing {

	@Test
	public void testParseFromFile() {
		Company company;
		try {
			company = Parsing.parseFromFile("inputs" + File.separator + "sampleCompany.json");
		} catch (IOException e) {
			fail();
			return;
		}

		assertNotNull(company);
	}

	@Test
	public void testParseFromFileNonExisting() {
		assertThrows(FileNotFoundException.class, () -> Parsing.parseFromFile(""));
	}

	@Test
	public void testParseEmpty() {
		Company company = Parsing.parse("{}");
		assertNotNull(company);
		assertNull(company.getName());
		assertNull(company.getDepartments());
	}

	@Test
	public void testParseWithName() {
		Company company = Parsing.parse("{name=\"Test\"}");
		assertNotNull(company);
		assertEquals("Test", company.getName());
		assertNull(company.getDepartments());
	}
}
