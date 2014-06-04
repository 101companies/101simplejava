package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import org.softlang.company.model.Company;
import org.softlang.company.features.Cut;
import org.softlang.company.features.Total;

import org.antlr.v4.runtime.RecognitionException;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

public class CutTest {

    private static String sampleCompany =
        "inputs"
        + File.separator
        + "sample.Company";

    @Test
    public void testCut()
            throws IOException, RecognitionException {
        Company c = parse(sampleCompany);
        new Cut().cut(c);
        double total = new Total().total(c);
        assertEquals(399747 / 2.0d, total, 0);
    }

}