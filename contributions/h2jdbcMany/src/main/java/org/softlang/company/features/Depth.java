package org.softlang.company.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Depth {
	public static int depth(Connection conn, String companyName)
			throws SQLException {
		String sql = "SELECT id FROM department WHERE did IS NULL AND ( cid =(SELECT id FROM company WHERE name = ?) );";
		PreparedStatement s = conn.prepareStatement(sql);
		s.setString(1, companyName);
		ResultSet departments = s.executeQuery();
		int max = 0;
		int temp = 0;
		while (departments.next()) {
			temp = depth(conn, departments.getInt("id"), 0);
			if (temp > max)
				max = temp;
		}
		return max;
	}

	private static int depth(Connection conn, int id, int result)
			throws SQLException {
		String sql = "SELECT id FROM department WHERE did = ?;";
		PreparedStatement s = conn.prepareStatement(sql);
		s.setInt(1, id);
		ResultSet departments = s.executeQuery();
		int max = result + 1;
		int temp = 0;
		while (departments.next()) {
			temp = depth(conn, departments.getInt("id"), result + 1);
			if (temp > max)
				max = temp;
		}
		return max;
	}
}
