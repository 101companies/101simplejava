package org.softlang.company.tests;

import org.softlang.company.features.Total;
import org.softlang.company.features.Cut;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CutTest {

    private static String sampleCompany =
        "inputs"
        + File.separator
        + "sample.Company";
    private static String outputCompany =
        "build"
        + File.separator
        + "outputs"
        + File.separator
        + "cutSample.Company";

    @Test
    public void testCut() throws IOException {
        new File("build" + File.separator + "outputs").mkdir();
        new Cut(sampleCompany,outputCompany);
        Total total = new Total(outputCompany);
        assertEquals(399747 / 2.0d, total.getTotal(), 0);
    }

}