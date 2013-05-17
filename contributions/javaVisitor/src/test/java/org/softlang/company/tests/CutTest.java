package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import org.softlang.company.model.Company;
import org.softlang.company.features.*;

import java.io.File;

import org.junit.Test;
import static org.junit.Assert.*;

public class CutTest {

    @Test
    public void testCut() {
        Company c = readCompany("inputs" + File.separator + "sampleCompany.ser");
        c.accept(new Cut());
        double total = c.accept(new Total());
        assertEquals(399747 / 2.0d, total, 0);
    }

}