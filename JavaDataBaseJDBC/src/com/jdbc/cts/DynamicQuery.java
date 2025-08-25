package com.jdbc.cts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicQuery {

	Connection con;
	Scanner sc = new Scanner(System.in);

	public DynamicQuery() {
		try {
			con = JdbcConnection.getConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		} catch (SQLException s) {
			System.out.println("SQL error");
		}
	}

	public void insertIntoTable() throws SQLException {
		System.out.println("Enter the Student Id: ");
		int id = sc.nextInt();
		System.out.println("Enter the StudentName: ");
		String name = sc.next();
		System.out.println("Enetr the Age : ");
		int age = sc.nextInt();
		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, age);
		int z = ps.executeUpdate();
		System.out.println(z + "row(s) inserted");
	}

	public void updateTable() throws SQLException {
		System.out.println("Enter the Student Id to update: ");
		int id = sc.nextInt();
		System.out.println("Enter the new Student Name: ");
		String name = sc.next();
		System.out.println("Enter the new Age: ");
		int age = sc.nextInt();

		PreparedStatement ps = con.prepareStatement("UPDATE student SET sname = ?, sage = ? WHERE stuid = ?");
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setInt(3, id);

		int z = ps.executeUpdate();
		System.out.println(z + " row(s) updated");
	}

	public void deleteTable() throws SQLException {
		System.out.println("Enter the Student Id to delete: ");
		int id = sc.nextInt();

		PreparedStatement ps = con.prepareStatement("DELETE FROM student WHERE stuid = ?");
		ps.setInt(1, id);

		int z = ps.executeUpdate();
		System.out.println(z + " row(s) deleted");

	}

	public void searchTable() throws SQLException {
		System.out.println("Enter the Student Id to search: ");
		int id = sc.nextInt();

		PreparedStatement ps = con.prepareStatement("SELECT * FROM student WHERE stuid = ?");
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			System.out.println("Student Id: " + rs.getInt("stuid"));
			System.out.println("Student Name: " + rs.getString("sname"));
			System.out.println("Age: " + rs.getInt("sage"));
		} else {
			System.out.println("No student found with ID: " + id);
		}
	}

	public void showAllStudent() throws SQLException {
		Statement statement = con.createStatement();

		ResultSet rs = statement.executeQuery("select * from student");

		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getInt(3));
		}
	}
}
