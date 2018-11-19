package org.softlang.company.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.softlang.company.features.Parsing;
import org.softlang.company.features.Unparsing;
import org.softlang.company.model.Company;

public class TestUnparsing {

	private static String jsonIn;
	private final Path outputFilePath = Paths.get("outputs" + File.separator + "sampleCompany.json");

	@BeforeAll
	public static void setup() {
		try (Stream<String> stream = Files.lines(Paths.get("inputs" + File.separator + "sampleCompany.json"))) {
			jsonIn = stream.collect(Collectors.joining("\n"));
		} catch (IOException e) {
			fail(e);
			return;
		}
	}

	@Test
	public void testUnparse() {
		Company company = Parsing.parse(jsonIn);
		assertEquals(jsonIn, Unparsing.unparse(company));
	}

	@Test
	public void testUnparseNull() {
		assertEquals("null", Unparsing.unparse(null));
	}

	@Test
	public void testUnparseEmptyCompany() {
		assertEquals("{}", Unparsing.unparse(new Company(null, null)));
	}

	@Test
	public void testUnparseToFile() {
		Company company = Parsing.parse(jsonIn);
		File outputDir = new File("outputs");
		outputDir.mkdir();

		try {
			Unparsing.unparseToFile(company, outputFilePath.toFile());
		} catch (IOException e) {
			fail(e);
		}

		String jsonOut;
		try (Stream<String> stream = Files.lines(outputFilePath)) {
			jsonOut = stream.collect(Collectors.joining("\n"));
		} catch (IOException e) {
			fail(e);
			return;
		}

		assertEquals(jsonIn, jsonOut);
	}
}
