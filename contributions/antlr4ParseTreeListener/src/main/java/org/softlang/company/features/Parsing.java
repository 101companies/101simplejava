package org.softlang.company.features;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.softlang.company.antlr.CompanyLexer;
import org.softlang.company.antlr.CompanyParser;

public class Parsing {

	public static CompanyParser parse(String s) throws IOException,
			RecognitionException {
		FileInputStream stream = new FileInputStream(s);
		ANTLRInputStream antlr = new ANTLRInputStream(stream);
		CompanyLexer lexer = new CompanyLexer(antlr);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CompanyParser parser = new CompanyParser(tokens);
		// parser.company();

		return parser;
	}

}