package org.softlang.company.tests;

import static org.softlang.company.features.Total.*;
import static org.softlang.company.features.Serialization.*;
import org.softlang.company.model.Company;

import java.io.File;

import static org.junit.Assert.*;
import org.junit.Test;

public class TotalTest {

    @Test
    public void testTotal() {
        Company c = readCompany("inputs" + File.separator + "sampleCompany.ser");
        double total = total(c);
        assertEquals(399747, total, 0);
    }
}