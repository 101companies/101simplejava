package org.softlang.company.tests;

import org.softlang.company.features.Total;

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
        Total total = new Total();
        total.parse(sampleCompany);
        assertEquals(399747, total.getTotal(), 0);
    }

}