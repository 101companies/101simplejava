package org.softlang.company.tests;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.softlang.company.features.Cut;

public class CutTest {

	private static Connection conn;
	public static final String NAME = "Acme Corporation";

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
	public void testCut() throws SQLException {
		List<Double> salariesBefore = getSalaries();
		List<Double> expected = new ArrayList<Double>();
		for (Double s : salariesBefore) {
			expected.add(s / 2.0);
		}

		Cut.cut(conn, NAME);

		List<Double> salariesAfter = getSalaries();
		assertEquals(expected, salariesAfter);
	}

	private List<Double> getSalaries() throws SQLException {
		ResultSet salarySet = queryAllEmployees();
		List<Double> salaries = new ArrayList<Double>();
		while (salarySet.next()) {
			salaries.add(salarySet.getDouble("salary"));
		}
		return salaries;
	}

	public ResultSet queryAllEmployees() throws SQLException {
		String select = "SELECT * FROM employee;";
		PreparedStatement stm = conn.prepareStatement(select);
		return stm.executeQuery();
	}

}
