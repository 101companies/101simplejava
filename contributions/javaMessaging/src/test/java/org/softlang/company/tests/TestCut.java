package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.softlang.company.features.CompanyCreator;
import org.softlang.company.features.Cut;
import org.softlang.company.features.Total;
import org.softlang.company.model.Company;
import org.softlang.company.threads.CompanyThread;

public class TestCut {
	private Company company;
	private String queueid;
	private String host = "vm://localhost";
	
	@Before
	public void setUp(){
		company = CompanyCreator.createCompany();
		queueid = company.getName();
	}

	@Test
	public void testSingleCut() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		CompanyThread c = new CompanyThread(company, host);
		executor.execute(c);
		Future<Double> value = executor.submit(new Total(host, queueid));
		assertEquals(CompanyCreator.SALARY,value.get(), 1e-10);
		Cut cut = new Cut(host, queueid);
		executor.execute(cut);
		value = executor.submit(new Total(host, queueid));
		assertEquals(CompanyCreator.SALARY / 2,value.get(), 1e-10);
		try {
			executor.shutdown();
			c.shutdown();
			executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
