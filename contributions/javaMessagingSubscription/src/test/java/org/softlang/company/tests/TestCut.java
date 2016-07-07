package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.softlang.company.CompanyCreator;
import org.softlang.company.threads.CompanyManager;

public class TestCut {
	
	public CompanyManager c;

	@Before
	public void setUp(){
		c = new CompanyManager(CompanyCreator.createCompany(),
				"vm://localhost");
	}
	
	@Test
	public void testCut() {
		assertEquals(CompanyCreator.SALARY,c.total(),1e-10);
		c.cut();
		assertEquals(CompanyCreator.SALARY/2,c.total(),1e-10);
		c.shutdown();
	}

}
