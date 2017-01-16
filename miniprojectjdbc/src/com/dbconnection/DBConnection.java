package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {

	Connection con;
	Statement st;

	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_management", "root", "password");

			if (con != null) {
				System.out.println("-----------------Connected------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection(){
		return con;
	}
}
