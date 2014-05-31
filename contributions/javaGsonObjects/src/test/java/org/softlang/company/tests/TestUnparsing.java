package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import org.softlang.company.features.Parsing;
import org.softlang.company.features.Unparsing;
import org.softlang.company.model.Company;

public class TestUnparsing {

	@Test
	public void testUnparse() {
		String in = "inputs" + File.separator + "sampleCompany.json";
		Company c;
		try {
			c = Parsing.parseFromFile(in);
			String jsonOut = Unparsing.unparse(c);
			String jsonIn = "";
			BufferedReader input = new BufferedReader(new FileReader(new File(
					in)));
			if (input.ready()) // readLine deletes \n while reading
				jsonIn += input.readLine();
			while (input.ready())
				jsonIn += "\n" + input.readLine();
			assertEquals(0, jsonOut.compareTo(jsonIn));
			input.close();
		} catch (IOException e) {
			fail();
		}

	}

	@Test
	public void testUnparseToFile() {
		String in = "inputs" + File.separator + "sampleCompany.json";
		String out = "outputs" + File.separator + "outCompany.json";
		Company c;
		new File("outputs").mkdir();
		c = Parsing.parseFromFile(in);
		String jsonIn = "";
		String jsonOut = "";
		try {
			Unparsing.unparseToFile(c, out);
			BufferedReader input = new BufferedReader(new FileReader(new File(
					in)));
			BufferedReader output = new BufferedReader(new FileReader(new File(
					out)));
			while (output.ready())
				jsonOut += output.readLine();
			while (input.ready())
				jsonIn += input.readLine();
			assertEquals(0, jsonOut.compareTo(jsonIn));
			output.close();
			input.close();
		} catch (IOException e) {
			fail();
		}

	}
}
