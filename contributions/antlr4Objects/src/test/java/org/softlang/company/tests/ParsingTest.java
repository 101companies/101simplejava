package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;

import org.antlr.v4.runtime.*;

import java.io.File;
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
        parse(posSample);
    }

    @Test(expected=RecognitionException.class)
    public void testNegative()
            throws IOException, RecognitionException {
        parse(negSample);
    }

}