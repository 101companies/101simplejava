package org.softlang.company.test;

import static org.junit.Assert.assertEquals;
import static org.softlang.company.features.Parsing.parse;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;
import org.softlang.company.antlr.CompanyParser;
import org.softlang.company.features.CutListener;
import org.softlang.company.features.TotalListener;

public class cutListenerTest {
	private static String sampleCompany = "inputs" + File.separator
			+ "sample.Company";
	private static String cutCompany = "outputs" + File.separator
			+ "cut.Company";

	@Test
	public void testcut() throws RecognitionException, IOException {
		CompanyParser parser = parse(sampleCompany);
		parser.setBuildParseTree(true);
		ParseTree tree = parser.company();

		System.out.println("Parsing done");

		// setup the tree walker and print the result
		ParseTreeWalker walker = new ParseTreeWalker();
        new File("outputs").mkdir();
		PrintStream out = new PrintStream(cutCompany);
		CutListener cutter = new CutListener(out);
		walker.walk(cutter, tree);

		// total the cutted salaries by rereading
		parser = parse(cutCompany);
		parser.setBuildParseTree(true);
		tree = parser.company();
		TotalListener totaler = new TotalListener(parser);
		walker.walk(totaler, tree);
		assertEquals(399747 / 2.0f, totaler.getTotal(), 0);
	}

}
