package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import org.softlang.company.features.Cut;
import org.softlang.company.features.Total;
import org.softlang.company.model.Company;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.*;

public class CutTest {

    @Test
    public void testCut() {
        Company c = readCompany("inputs" + File.separator + "sampleCompany.ser");
        Total total = new Total();
        Cut cut = new Cut();
        double before = total.reduce(c);
        cut.walk(c);
        double after = total.reduce(c);
        assertEquals(before / 2.0d, after, 0);
    }

}