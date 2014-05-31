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

import com.google.gson.JsonObject;

public class TestUnparsing {

	@Test
	public void testUnparse() {
		String in = "inputs" + File.separator + "sampleCompany.json";
		JsonObject o;
		try {
			o = Parsing.parseFromFile(in);
			String jsonOut = Unparsing.unparse(o);
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
		JsonObject o;
		o = Parsing.parseFromFile(in);
		String jsonIn = "";
		String jsonOut = "";
		try {
			new File("outputs").mkdir();
			Unparsing.unparseToFile(o, out);
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
