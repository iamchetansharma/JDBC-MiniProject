package com.productmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import com.dbconnection.DBConnection;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class Queries {

	DBConnection connect = new DBConnection();
	Connection connection = connect.getConnection();
	Scanner input = new Scanner(System.in);

	// Step 1
	public void insertCatergories() throws SQLException {

		System.out.print("Enter the name Category :");
		String category = input.nextLine();
		PreparedStatement ps1 = connection.prepareStatement("INSERT INTO Categories (product_category) VALUES (?)");
		ps1.setString(1, category);

		try {
			ps1.executeUpdate();
			System.out.println("Record is inserted into Categories..!");
		} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {

			System.out.println("This category is already in Database");
		}

	}

	// Step 2
	public void addProductes() throws SQLException {

		System.out.print("Enter the name of category in which you want to add you product :");
		String category = input.nextLine();
		System.out.print("Enter the name of product:");
		String product = input.nextLine();
		product.toUpperCase();
		PreparedStatement ps1 = connection
				.prepareStatement("INSERT INTO ProductCategories (product_code, product_category) VALUES (?,?)");
		ps1.setString(1, product);
		ps1.setString(2, category);

		try {
			ps1.executeUpdate();
			System.out.println("Record is inserted into product table..!");
		} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {

			System.out.println("This category does not exist Database");
		}

	}

	// Step 3
	public void showProductDetails() throws SQLException {

		System.out.print("Enter the name of product:");
		String product = input.nextLine();

		PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM ProductdDetails WHERE product_name = ?");
		ps1.setString(1, product);
		ResultSet rs = ps1.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();

		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.println(rsmd.getColumnName(i) + " : " + rs.getString(i));
			}
		}

	}

	// Step 4
	public void showCatergories() throws SQLException {

		PreparedStatement ps1 = connection.prepareStatement("select * from Categories");
		ResultSet rs = ps1.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();

		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.println(rs.getString(i));
			}
		}

	}

	// Step 5
	public void showProducts() throws SQLException {

		PreparedStatement ps1 = connection.prepareStatement("select * from ProductCategories");
		ResultSet rs = ps1.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();

		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.println("Products :" + rs.getString(i));
				i = i + 1;
			}
		}

	}

	// Step 6
	public void showAvgProducts() throws SQLException {

		PreparedStatement ps1 = connection
				.prepareStatement("SELECT count(product_name) FROM ProductdDetails group by product_code");
		ResultSet rs = ps1.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();

		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.println("Products :" + rs.getString(i));
			}
		}
	}
	
	//Step 7
	public void showHigestDescription() throws SQLException {

		PreparedStatement ps1 = connection
				.prepareStatement("select product_name, length(product_description) from ProductdDetails where length( product_description ) = ( select max( length( product_description ) ) from ProductdDetails )");
		ResultSet rs = ps1.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		String name = "Products";
		while (rs.next()) {
			
			for (int i = 1; i <= columnCount; i++) {
				System.out.println(name+" :" + rs.getString(i));
				name = "Length";
			}
			
		}

	}
	// Step 8
	public void deleteCategories() throws SQLException {

		System.out.print("Enter the name of Category:");
		String category = input.nextLine();
		try {
			PreparedStatement ps1 = connection.prepareStatement("DELETE FROM Categories WHERE product_category = ?");
			ps1.setString(1, category);
			ps1.execute();
			System.out.println("Categories : " + category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------------------");
		PreparedStatement ps2 = connection.prepareStatement("select * from Categories");
		ResultSet rs = ps2.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();

		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.println("Category :" + rs.getString(i));
			}
		}
	}

	// Step 9
	public void deleteProducts() throws SQLException {

		System.out.print("Enter the name of product:");
		String product = input.nextLine();
		
		try {
			PreparedStatement ps1 = connection.prepareStatement("DELETE FROM ProductCategories WHERE product_code = ?");
			ps1.setString(1, product);
			ps1.execute();
			System.out.println("Categories : " + product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------------------");
		PreparedStatement ps2 = connection.prepareStatement("select * from ProductCategories");
		ResultSet rs = ps2.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();

		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.println("Products :" + rs.getString(i));
				i = i + 1;
			}
		}

	}
	
	//Step 10 SELECT product_name FROM ProductdDetails WHERE LENGTH(product_description)>=20; 
	public void displayProducts() throws SQLException {

		PreparedStatement ps1 = connection.prepareStatement("select * from ProductdDetails order by product_id desc limit 5");
		ResultSet rs = ps1.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();

		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.println(rsmd.getColumnName(i)  + ":" + rs.getString(i));
				
			}
			System.out.println("------------------");
		}
		
		

	}

}
