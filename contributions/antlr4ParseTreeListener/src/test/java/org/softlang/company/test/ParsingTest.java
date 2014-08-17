package org.softlang.company.test;

import static org.junit.Assert.assertTrue;
import static org.softlang.company.features.Parsing.*;

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
		// A graph of the parsetree in PostScript
		tree.save(parser, "outputs" + File.separator + "company.ps");
		System.out.println("Done.");
	}

	@Test
	public void testNegative() throws IOException {
		CompanyParser parser = parse(negSample);
		parser.company();
		assertTrue(parser.getNumberOfSyntaxErrors() > 0);
	}

}