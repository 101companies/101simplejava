package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.softlang.company.features.Total;

public class TotalTest {

	private static Connection conn;

	@Before
	public void setUp() throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		System.out.println(System.getProperty("user.dir"));
		conn = DriverManager
				.getConnection(
						"jdbc:h2:mem:company;INIT=runscript from 'src/test/resources/Company.sql'\\;runscript from 'src/test/resources/sampleCompany.sql'",
						"sa", "");
	}

	@After
	public void tearDown() throws SQLException {
		conn.close();
	}

	@Test
	public void testTotal() {
		double expected = 399747.0;
		double total = Total.total(conn);
		assertEquals(expected, total, 10e-10);
	}

}
