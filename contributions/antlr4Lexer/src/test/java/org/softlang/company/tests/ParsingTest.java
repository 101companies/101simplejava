package org.softlang.company.tests;

import org.softlang.company.antlr.Company;
import org.softlang.company.features.Parsing;
import org.antlr.v4.runtime.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

public class ParsingTest {

    private static String posSample =
        "inputs"
        + File.separator
        + "sample.Company";
    private static String negSample =
        "inputs"
        + File.separator
        + "nonSample.Company";

    @Test
    public void testPositive()
            throws IOException, RecognitionException {
        Parsing.parse(posSample);
    }

    @Test
    public void testNegative()
            throws IOException, RecognitionException {
        Parsing.parse(negSample);
    }	

    @Test
    public void testTokenization()
            throws IOException {
        FileInputStream stream = new FileInputStream(posSample);
        ANTLRInputStream antlr = new ANTLRInputStream(stream);
        Company lexer = new Company(antlr);
        Token token;
        while ((token = lexer.nextToken()).getType()!=Token.EOF)
            System.out.println(token);
    }

}