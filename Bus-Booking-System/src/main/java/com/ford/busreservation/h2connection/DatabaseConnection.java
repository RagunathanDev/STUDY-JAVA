package com.ford.busreservation.h2connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.h2.Driver");// Load the native JDBC driver to classpath
			con = DriverManager.getConnection("jdbc:h2:mem:test", "sa", ""); // Get a connection
																				// that uses the
																				// native JDBC
																				// driver

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

}
