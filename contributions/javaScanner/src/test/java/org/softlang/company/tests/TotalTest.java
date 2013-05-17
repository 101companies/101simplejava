package org.softlang.company.tests;

import static org.softlang.company.features.Total.*;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TotalTest {

    private static String sampleCompany =
        "inputs"
        + File.separator
        + "sample.Company";

    @Test
    public void testTotal() throws FileNotFoundException {
        double total = total(sampleCompany);
        assertEquals(399747, total, 0);
    }

}