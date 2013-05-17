package org.softlang.company.tests;

import static org.softlang.company.features.Parsing.*;
import org.softlang.company.model.Company;
import org.softlang.company.features.*;

import java.io.File;

import org.junit.Test;
import static org.junit.Assert.*;

public class TotalTest {

    @Test
    public void testTotal() {
        Company c = readCompany("inputs" + File.separator + "sampleCompany.ser");
        double total = c.accept(new Total());
        assertEquals(399747, total, 0);
    }

}