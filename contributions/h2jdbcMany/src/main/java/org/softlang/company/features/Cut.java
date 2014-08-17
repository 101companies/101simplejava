package org.softlang.company.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cut {
	public static void cut(Connection conn, String companyName)
			throws SQLException {
		String query = "UPDATE employee SET salary = salary / 2 "
				+ "WHERE cid = (SELECT id FROM company WHERE name = ?);";
		PreparedStatement stm = conn.prepareStatement(query);
		stm.setString(1, companyName);
		stm.executeUpdate();
	}
}
