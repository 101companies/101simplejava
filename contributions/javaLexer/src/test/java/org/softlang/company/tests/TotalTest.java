package org.softlang.company.tests;

import org.softlang.company.features.Total;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class TotalTest {

    private static String sampleCompany =
        "inputs"
        + File.separator
        + "sample.Company";

    @Test
    public void testTotal() throws FileNotFoundException {
        Total total = new Total(sampleCompany);
        assertEquals(399747, total.getTotal(), 0);
    }

}