package org.softlang.company.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Total {
	public static double total(Connection conn)
			throws SQLException {

		String sql = "SELECT salary FROM employee ;";
		PreparedStatement s = conn.prepareStatement(sql);
		ResultSet salaries = s.executeQuery();
		double result = 0.0;
		while (salaries.next())
			result += salaries.getDouble("salary");
		return result;
	}
	
	public static double totalWithSum(Connection conn)
			throws SQLException {

		String sql = "SELECT SUM(salary) FROM employee ;";
		PreparedStatement s = conn.prepareStatement(sql);
		ResultSet salary = s.executeQuery();
		double result = 0.0;
		if(salary.first())
			result = salary.getDouble(1);
		return result;
	}
}
