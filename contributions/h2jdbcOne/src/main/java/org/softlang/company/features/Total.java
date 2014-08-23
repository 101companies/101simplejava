package org.softlang.company.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Total {

	/**
	 * Total all salaries of a given company.
	 */
	public static double total(Connection connection) {
		double total = 0;
		try {
			//
			// We could be using the SUM aggregator of SQL.
			// However, we use this example to illustrate iteration over result
			// sets.
			//
			String query = "SELECT salary FROM employee ;";
			PreparedStatement stm = connection.prepareStatement(query);
			ResultSet salaries = stm.executeQuery();
			while (salaries.next())
				total += salaries.getDouble("salary");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
}