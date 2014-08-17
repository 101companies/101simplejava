package org.softlang.company.test;

import static org.junit.Assert.assertEquals;
import static org.softlang.company.features.Parsing.parse;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import javax.print.PrintException;

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import org.softlang.company.antlr.CompanyParser;
import org.softlang.company.features.CutVisitor;
import org.softlang.company.features.PrintVisitor;
import org.softlang.company.features.TotalVisitor;

public class CutVisitorTest {

	private static String sampleCompany = "inputs" + File.separator
			+ "sample.Company";
	private static String cutCompany = "outputs" + File.separator
			+ "cut.Company";

	@Test
	public void testTotal() throws RecognitionException, IOException,
			PrintException {
		CompanyParser parser = parse(sampleCompany);
		parser.setBuildParseTree(true);
		ParseTree tree = parser.company();

		System.out.println("Parsing done");
        new File("outputs").mkdir();
		((RuleContext) tree).save(parser, "outputs" + File.separator
				+ "company.ps");

		CutVisitor c = new CutVisitor();
		// Cuttign visit
		c.visit(tree);
        new File("outputs").mkdir();
		PrintStream out = new PrintStream(cutCompany);
		// print the result
		PrintVisitor p = new PrintVisitor(out);
		p.visit(tree);
		out.close();
		// we total the cut salaries again
		parser = parse(cutCompany);
		TotalVisitor t = new TotalVisitor();
		Float salary = t.visit(tree);
		System.out.println(salary);

		assertEquals(399747 / 2.0, t.visit(tree), 0);

	}
}
