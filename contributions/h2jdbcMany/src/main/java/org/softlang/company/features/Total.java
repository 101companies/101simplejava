package org.softlang.company.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Total {
	public static double total(Connection conn, String companyName)
			throws SQLException {

		String sql = "SELECT salary FROM employee WHERE cid = ("
				+ "SELECT id FROM company WHERE name = ?)";
		PreparedStatement s = conn.prepareStatement(sql);
		s.setString(1, companyName);
		ResultSet salaries = s.executeQuery();
		double result = 0.0;
		while (salaries.next())
			result += salaries.getDouble("salary");
		return result;
	}
}
