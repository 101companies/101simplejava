package org.softlang.company.features;

import org.softlang.company.antlr.Company;

import org.antlr.runtime.*;

import java.io.FileInputStream;
import java.io.IOException;

/*
 *    Implementation of the feature Parsing
 *    using an ANTLR-generated Lexer
 */

public class Parsing {

    public static void parse(String s)
            throws IOException {
        FileInputStream stream = new FileInputStream(s);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        Company lexer = new Company(antlr);
        Token token;
        while ((token = lexer.nextToken()) != Token.EOF_TOKEN) {}
    }

}