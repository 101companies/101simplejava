package org.softlang.company.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.softlang.company.CompanyCreator;
import org.softlang.company.threads.CompanyManager;

public class TestTotal {

	public CompanyManager c;

	@Before
	public void setUp(){
		c = new CompanyManager(CompanyCreator.createCompany(),
				"vm://localhost");
	}
	
	@Test
	public void testTotal() {
		assertEquals(CompanyCreator.SALARY,c.total(),1e-10);
		c.shutdown();
	}
}
