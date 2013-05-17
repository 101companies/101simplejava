package org.softlang.company.tests;

import org.softlang.company.antlr.Company;
import org.softlang.company.features.Parsing;

import org.antlr.runtime.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
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

    @Test(expected=IllegalArgumentException.class)
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
        while ((token = lexer.nextToken())!=Token.EOF_TOKEN)
            System.out.println(token);
    }

}