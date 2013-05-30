package org.softlang.company.tests;

import static org.softlang.company.features.Unparsing.*;
import org.softlang.company.features.Total;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UnparsingTest {

    private static String sampleCompany =
        "inputs"
        + File.separator
        + "sample.Company";
    private static String outputCompany =
        "outputs"
        + File.separator
        + "unparsedSample.Company";

    @Test
    public void testCut() throws IOException {
        new File("outputs").mkdir();
        copy(sampleCompany,outputCompany);
        Total total = new Total(outputCompany);
        assertEquals(399747, total.getTotal(), 0);
    }

}