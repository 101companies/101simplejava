package org.softlang.company.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CompanyTables {

	public static void createTables(Connection conn) throws SQLException {
		Statement s = conn.createStatement();
		s.execute("CREATE TABLE IF NOT EXISTS company "
				+ "(id INTEGER AUTO_INCREMENT PRIMARY KEY,"
				+ "name VARCHAR(100) UNIQUE NOT NULL);");
		s.execute("CREATE TABLE IF NOT EXISTS department ("
				+ "	id INTEGER AUTO_INCREMENT PRIMARY KEY,"
				+ "	name VARCHAR(100) NOT NULL," + "cid INTEGER NOT NULL,"
				+ "did INTEGER," + "FOREIGN KEY (cid) REFERENCES "
				+ "company(id) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY (did) REFERENCES "
				+ "department(id) ON DELETE CASCADE ON UPDATE CASCADE" + ");");
		s.execute("CREATE TABLE IF NOT EXISTS employee ("
				+ "id INTEGER AUTO_INCREMENT PRIMARY KEY,"
				+ "name VARCHAR(50) NOT NULL,"
				+ "address VARCHAR(50) NOT NULL,"
				+ "salary DOUBLE NOT NULL,"
				+ "manager BOOL NOT NULL,"
				+ "cid INTEGER NOT NULL,"
				+ "did INTEGER NOT NULL,"
				+ "FOREIGN KEY (cid) REFERENCES company(id) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY (did) REFERENCES department(id) ON DELETE CASCADE ON UPDATE CASCADE"
				+ ");");
	}

	public static void deleteTables(Connection conn) throws SQLException {
		Statement s = conn.createStatement();
		s.execute("DROP TABLE company");
		s.execute("DROP TABLE department");
		s.execute("DROP TABLE employee");
	}

	public static void executeScript(Connection conn, String file)
			throws SQLException {
		String sql = "RUNSCRIPT FROM ?";
		PreparedStatement s = conn.prepareStatement(sql);
		s.setString(1, file);
		s.execute();
	}

}
