package com.jdbc.cts;

import java.sql.SQLException;
import java.util.Scanner;

public class OperationDatabase {

	public static void main(String[] args) throws SQLException {
		DynamicQuery db = new DynamicQuery();
		Scanner sc = new Scanner(System.in);
		System.out.println("#######~~~~~~~~~Student Data Manupulation~~~~~~~~~~########");

		int choice;
		do {
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Search");
			System.out.println("5.showTable");
			System.out.println("0. exit");

			System.out.println("#######~~~~~~~~~#######~~~~~~~~~~########");

			System.out.println("Enter Your Choice: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				db.insertIntoTable();
				break;
			case 2:
				db.updateTable();
				break;
			case 3:
				db.deleteTable();
				break;
			case 4:
				db.searchTable();
				break;
			case 5:
				db.showAllStudent();
				break;
			}

		} while (choice != 0);
		sc.close();
		System.out.println("Exit");

	}

}
