package org.softlang.company.tests;

import static org.softlang.company.features.Cut.*;
import static org.softlang.company.features.Total.*;
import org.softlang.company.model.Company;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CutTest {

    @Test
    public void testCut() {
        Company c = CompanyCreator.createCompany();
        cut(c);
        assertEquals(CompanyCreator.SALARY / 2.0d, total(c), 0);
    }

    @Test
    public void testCutWithThreads() {
        Company c1 = CompanyCreator.createCompany();
        Company c2 = CompanyCreator.createCompany();

        // Precondition
        assertEquals(total(c1), total(c2));

        // Sequential cut
        cut(c1);

        // Concurrent cut
        cutWithThreads(c2);
        
        // Postcondition
        assertEquals(total(c1), total(c2));
    }

}