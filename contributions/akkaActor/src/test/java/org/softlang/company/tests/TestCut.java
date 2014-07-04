package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.softlang.company.features.CompanyCreator;
import org.softlang.company.features.Cut;
import org.softlang.company.features.Total;
import org.softlang.company.model.Company;

public class TestCut {
	public Company c = CompanyCreator.createCompany();

	@Test
	public void testCut() {
		Cut.cut(c);
		assertEquals(CompanyCreator.SALARY, Total.total(c) * 2, 1e-10);
	}

}
