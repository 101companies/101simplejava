package org.softlang.company.test;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.softlang.company.antlr.*;
import static org.softlang.company.features.Parsing.parse;
import org.softlang.company.features.TotalListener;

public class TotalListenerTest {

	private static String sampleCompany = "inputs" + File.separator
			+ "sample.Company";

	@Test
	public void testTotal() throws RecognitionException, IOException {
		CompanyParser parser = parse(sampleCompany);
		parser.setBuildParseTree(true);
		ParseTree tree = parser.company();

		System.out.println("Parsing done");

		ParseTreeWalker walker = new ParseTreeWalker();
		TotalListener extractor = new TotalListener(parser);
		walker.walk(extractor, tree);
		System.out.println("Total = " + extractor.getTotal());
		assertEquals(399747, extractor.getTotal(), 0);
	}

}