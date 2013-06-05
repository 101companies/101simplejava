package org.softlang.company.tests;

import static org.softlang.company.features.Total.*;
import static org.softlang.company.features.Cut.*;
import static org.softlang.company.features.Serialization.*;
import org.softlang.company.model.Company;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class CutTest {

    @Test
    public void testCut() {
        Company c = deserializeCompany("inputs" + File.separator + "sampleCompany.ser");
        double before = total(c);
        cut(c);
        double after = total(c);
        assertEquals(before / 2.0d, after, 0);
    }

    @Test
    public void testCutManagers() {
        Company c = deserializeCompany("inputs" + File.separator + "sampleCompany.ser");
        cutManagers(c);
        double after = total(c);
        assertEquals(207835.0, after, 0);
    }

}