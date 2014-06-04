package org.softlang.company.features;

import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.Token;
import org.softlang.company.antlr.Company;

/*
 *    Implementation of the feature Parsing
 *    using an ANTLR-generated Lexer
 */

public class Parsing {

	public static void parse(String s) throws IOException {
		FileInputStream stream = new FileInputStream(s);
		ANTLRInputStream antlr = new ANTLRInputStream(stream);
		Company lexer = new Company(antlr);
		Token token;
		while ((token = lexer.nextToken()) != Token.EOF_TOKEN) {
		}
	}

}