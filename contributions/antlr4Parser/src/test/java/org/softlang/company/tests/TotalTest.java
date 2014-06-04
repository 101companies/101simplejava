package org.softlang.company.tests;

import org.softlang.company.features.Total;

import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TotalTest {

    private static String posSample =
        "inputs"
        + File.separator
        + "sample.Company";

    @Test
    public void testPositive()
            throws IOException, RecognitionException {
        double total = Total.total(posSample);
        assertEquals(399747, total, 0);
    }

}