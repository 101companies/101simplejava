package org.softlang.company.tests;

import static org.softlang.company.features.Cut.*;
import static org.softlang.company.features.Total.*;
import static org.softlang.company.features.Parsing.*;
import org.softlang.company.model.Company;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class CutTest {

    @Test
    public void testCut() {
        Company c = deserializeCompany("inputs" + File.separator + "sampleCompany.ser");
        cut(c);
        double total = total(c);        
        assertEquals(399747 / 2.0d, total, 0);
    }

}