package org.softlang.company.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import javax.print.PrintException;

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import org.softlang.company.antlr.CompanyParser;
import org.softlang.company.features.*;

public class TotalVisitorTest {
	
	private static String sampleCompany = "inputs" + File.separator
			+ "sample.Company";
	
	@Test
	public void testTotal() throws RecognitionException, IOException, PrintException {
		CompanyParser parser = Parsing.parse(sampleCompany);
		parser.setBuildParseTree(true);
		ParseTree tree = parser.company(); // top rule
		// Print the parsetree as Postscript graphics
        new File("outputs").mkdir();
		((RuleContext)tree).save(parser, "outputs"+File.separator+"company.ps");
		// Create the visitor, whoch totals
		TotalVisitor t= new TotalVisitor();
		// start the visit and colloct result
		Float salary=t.visit(tree);
		System.out.println("Total salaries: "+salary);

		assertEquals(399747, t.visit(tree) , 0); 
		
	}

}
