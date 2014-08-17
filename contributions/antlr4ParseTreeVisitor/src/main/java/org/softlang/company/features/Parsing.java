package org.softlang.company.features;

import org.antlr.v4.runtime.*;
import org.softlang.company.antlr.CompanyLexer;
import org.softlang.company.antlr.CompanyParser;

import java.io.FileInputStream;
import java.io.IOException;

public class Parsing {

	public static CompanyParser parse(String s) throws IOException,
			RecognitionException {
		FileInputStream stream = new FileInputStream(s);
		ANTLRInputStream antlr = new ANTLRInputStream(stream);
		CompanyLexer lexer = new CompanyLexer(antlr);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CompanyParser parser = new CompanyParser(tokens);

		return parser;
	}

}