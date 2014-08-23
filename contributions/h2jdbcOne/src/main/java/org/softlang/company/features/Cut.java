package org.softlang.company.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cut {

	/**
	 * Cut all salaries in half for employees of a given company.
	 */
	public static void cut(Connection connection, String name) {
		try {
			String sqlCut = "UPDATE employee SET salary = salary / 2 ;";
			PreparedStatement stm = connection.prepareStatement(sqlCut);
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
