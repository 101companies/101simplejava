package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import org.softlang.company.features.Total;
import org.softlang.company.model.Company;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.*;

public class TotalTest {

    @Test
    public void testTotal() {
        Company c = readCompany("inputs" + File.separator + "sampleCompany.ser");
        Total total = new Total();
        assertEquals(399747, total.reduce(c), 0);
    }

}