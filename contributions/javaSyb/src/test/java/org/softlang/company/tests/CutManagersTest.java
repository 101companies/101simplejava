package org.softlang.company.tests;

import static org.softlang.company.features.Total.*;
import static org.softlang.company.features.CutManagers.*;
import static org.softlang.company.features.Parsing.*;
import org.softlang.company.model.Company;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class CutManagersTest {

    @Test
    public void testCutManagers() {
        Company c = readCompany("inputs" + File.separator + "sampleCompany.ser");
        cutManagers(c);
        double after = total(c);
        assertEquals(207835.0, after, 0);
    }

}