package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.softlang.company.features.CompanyCreator;
import org.softlang.company.features.Cut;
import org.softlang.company.features.Total;
import org.softlang.company.threads.CompanyThread;

public class TestCut {
	public CompanyThread c = new CompanyThread(CompanyCreator.createCompany(),
			"vm://localhost");
	public ExecutorService executor;

	@Before
	public void beforeTest() {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(c);
	}

	@After
	public void afterTest() {
		c.shutdown();
	}

	@Test
	public void testCut() {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(c);
		assertEquals(CompanyCreator.SALARY,
				Total.total(c.getDestination(), "vm://localhost"), 1e-10);
		Cut.cut(c.getDestination(), "vm://localhost");
		assertEquals(CompanyCreator.SALARY / 2,
				Total.total(c.getDestination(), "vm://localhost"), 1e-10);
	}

}
