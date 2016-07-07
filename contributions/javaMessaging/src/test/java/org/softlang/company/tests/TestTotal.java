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
import org.softlang.company.features.Total;
import org.softlang.company.model.Company;
import org.softlang.company.threads.CompanyThread;

public class TestTotal {
	private Company company;
	private String queueid;
	private String host = "vm://localhost";
	
	@Before
	public void setUp(){
		company = CompanyCreator.createCompany();
		queueid = company.getName();
	}

	@Test
	public void testSingleTotal() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		CompanyThread c = new CompanyThread(company, host);
		executor.execute(c);
		Future<Double> value = executor.submit(new Total(host, queueid));
		assertEquals(CompanyCreator.SALARY,value.get(), 1e-10);
		try {
			executor.shutdown();
			c.shutdown();
			executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTripleTotal() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		CompanyThread c = new CompanyThread(company, host);
		executor.execute(c);
		Future<Double> value1 = executor.submit(new Total(host, queueid));
		Future<Double> value2 = executor.submit(new Total(host, queueid));
		Future<Double> value3 = executor.submit(new Total(host, queueid));
		assertEquals(CompanyCreator.SALARY,value1.get(), 1e-10);
		assertEquals(CompanyCreator.SALARY,value2.get(), 1e-10);
		assertEquals(CompanyCreator.SALARY,value3.get(), 1e-10);
		try {
			executor.shutdown();
			c.shutdown();
			executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
