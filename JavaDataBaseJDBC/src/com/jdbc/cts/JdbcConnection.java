package com.jdbc.cts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver class loaded");

		// obtain the connection

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cts", "root", "Pranab");

		System.out.println("i got the connection");
		return con;
	}
}
