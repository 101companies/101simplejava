package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.softlang.company.database.CompanyTables;
import org.softlang.company.database.DatabaseConnector;
import org.softlang.company.features.Total;

public class TestTotal {
	DatabaseConnector c;

	@Before
	public void setUp() {
		try {
			c = new DatabaseConnector("jdbc:h2:mem:acme", "sa", "");
			CompanyTables.createTables(c.getConnection());
			CompanyTables.executeScript(c.getConnection(), "scripts"
					+ File.separatorChar + "sampleCompany.sql");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	@Test
	public void testTotal() {
		try {
			assertEquals(399747.0,
					Total.total(c.getConnection()), 0.0);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void testTotalWithSum() {
		try {
			assertEquals(399747.0,
					Total.totalWithSum(c.getConnection()), 0.0);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@After
	public void tearDown() {
		try {
			CompanyTables.deleteTables(c.getConnection());
			c.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
