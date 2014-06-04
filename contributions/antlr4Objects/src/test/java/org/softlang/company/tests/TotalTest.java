package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import org.softlang.company.model.Company;
import org.softlang.company.features.Total;

import org.antlr.v4.runtime.RecognitionException;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

public class TotalTest {

    private static String sampleCompany =
        "inputs"
        + File.separator
        + "sample.Company";

    @Test
    public void testTotal()
            throws IOException, RecognitionException {
        Company c = parse(sampleCompany);
        double total = new Total().total(c);		
        assertEquals(399747, total, 0);
    }

}