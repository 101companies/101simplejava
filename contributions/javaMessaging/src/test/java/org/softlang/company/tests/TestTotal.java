package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.softlang.company.features.CompanyCreator;
import org.softlang.company.features.Total;
import org.softlang.company.threads.CompanyThread;

public class TestTotal {

	public CompanyThread c = new CompanyThread(CompanyCreator.createCompany(),
			"vm://localhost");

	@Test
	public void testTotal() {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(c);
		assertEquals(CompanyCreator.SALARY,
				Total.total(c.getDestination(), "vm://localhost"), 1e-10);
		try {
			executor.shutdown();
			c.shutdown();
			executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
