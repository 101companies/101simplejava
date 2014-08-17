package org.softlang.company.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class manages one database connection
 * 
 * @author Matthias Paul
 * 
 */
public class DatabaseConnector {

	private Connection conn;

	public DatabaseConnector() {

	}

	public DatabaseConnector(String url, String user, String password)
			throws ClassNotFoundException, SQLException {
		connect(url, user, password);
	}

	/**
	 * Connect to a H2-Database
	 * 
	 * @param url
	 *            url of the database
	 * @param user
	 *            username for login
	 * @param password
	 *            userpassword for login
	 * @return Connection to the H"-Database
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection connect(String url, String user, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public Connection getConnection() {
		return conn;
	}

	public void close() throws SQLException {
		if (conn != null)
			conn.close();
	}

}
