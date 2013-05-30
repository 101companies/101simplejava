package org.softlang.company.tests;

import static org.softlang.company.features.Total.*;
import org.softlang.company.model.Company;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TotalTest {

    @Test
    public void testTotal() {
        Company c = CompanyCreator.createCompany();
        assertEquals(CompanyCreator.SALARY, total(c), 0);
    }

    @Test
    public void testTotalWithThreads() {
        Company c1 = CompanyCreator.createCompany();

        Double t1 = totalWithThreads(c1);
        Double t2 = total(c1);

        assertEquals(t1, t2);
    }

}