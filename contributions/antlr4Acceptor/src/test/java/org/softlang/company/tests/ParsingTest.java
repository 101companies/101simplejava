package org.softlang.company.tests;

import org.softlang.company.features.Parsing;
import org.antlr.v4.runtime.RecognitionException;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class ParsingTest {

	private static String posSample = "inputs" + File.separator
			+ "sample.Company";
	private static String negSample = "inputs" + File.separator
			+ "nonSample.Company";

	@Test
	public void testPositive() throws IOException, RecognitionException {
		Parsing.parse(posSample);
		System.out.println("Positive test successful");
	}

	@Test
	public void testNegative() throws RecognitionException, IOException {

		System.out.println(Parsing.parse(negSample).getNumberOfSyntaxErrors()
				+ " Syntax Error(s)");

	}

}