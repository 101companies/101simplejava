package org.softlang.company.test;

import static org.junit.Assert.*;
import static org.softlang.company.features.Parsing.parse;

import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.print.PrintException;

import org.junit.Test;
import org.softlang.company.antlr.CompanyParser;

public class ParsingTest {

	private static String posSample = "inputs" + File.separator
			+ "sample.Company";
	private static String negSample = "inputs" + File.separator
			+ "nonSample.Company";

	@Test
	public void testPositive() throws RecognitionException, IOException,
			InterruptedException, ExecutionException, PrintException {
		CompanyParser parser = parse(posSample);
		System.out.println(parser.getBuildParseTree());
		parser.setBuildParseTree(true);
		RuleContext tree = parser.company();
		System.out.println("Showing");
        new File("outputs").mkdir();
		tree.save(parser, "outputs" + File.separator + "company.ps");
		// Future<JDialog> dia = tree.inspect(parser);
		// dia.get();
		System.out.println("Done.");
	}

	@Test
	public void testNegative() throws IOException {
		CompanyParser parser = parse(negSample);
		parser.company();
		assertTrue(parser.getNumberOfSyntaxErrors() > 0);
	}

}