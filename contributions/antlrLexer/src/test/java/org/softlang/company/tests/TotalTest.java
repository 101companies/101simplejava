package org.softlang.company.tests;

import org.softlang.company.antlr.Company;
import org.softlang.company.features.Total;

import org.antlr.runtime.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TotalTest {

    private static String posSample =
        "inputs"
        + File.separator
        + "sample.Company";
    private static String negSample =
        "inputs"
        + File.separator
        + "nonSample.Company";

    @Test
    public void testTotal()
            throws IOException, RecognitionException {
        double total = Total.total(posSample);
        assertEquals(399747, total, 0);
    }

}