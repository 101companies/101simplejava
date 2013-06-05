package org.softlang.company.tests;

import org.softlang.company.model.Company;

import static org.softlang.company.features.Cut.*;
import static org.softlang.company.features.Total.*;
import static org.softlang.company.features.Serialization.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class CutTest {

    @Test
    public void testCut() {
        Company c = deserializeCompany("inputs/sampleCompany.ser");
        cut(c);
        double total = total(c);		
        assertEquals(399747 / 2.0d, total, 0);
    }

}