package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import org.softlang.company.features.parsing.Recognizer;
import org.softlang.company.features.parsing.RecognitionException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/**
 * Try to consume all input with the lexer.
 * There is a positive and a negative test case.
 */
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
    public void testPos() throws FileNotFoundException, IOException {
        Recognizer lexer = recognizeCompany(posSample);
        lexer.lexall();
    }

    @Test(expected=RecognitionException.class)
    public void testNeg() throws FileNotFoundException, IOException {
        Recognizer lexer = recognizeCompany(negSample);
        lexer.lexall();
    }

}