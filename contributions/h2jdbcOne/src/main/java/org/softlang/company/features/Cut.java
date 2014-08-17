package org.softlang.company.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cut {
	public static void cut(Connection conn)
			throws SQLException {
		String query = "UPDATE employee SET salary = salary / 2 ;";
		PreparedStatement stm = conn.prepareStatement(query);
		stm.executeUpdate();
	}
}
