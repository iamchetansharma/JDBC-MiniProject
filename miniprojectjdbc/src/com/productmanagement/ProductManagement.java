package com.productmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import com.dbconnection.DBConnection;

public class ProductManagement {

	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("1  - Add new product category ");
		System.out.println("2  - Add new product under a category");
		System.out.println("3  - View specific product's description and other details ");
		System.out.println("4  - Listing of categories ");
		System.out.println("5  - Listing of all the products of a category ");
		System.out.println("6  - Display Average number of products among all categories ");
		System.out.println("7  - Display the product which has largest description");
		System.out.println("8  - Delete Category");
		System.out.println("9  - Delete Product ");
		System.out.println("10 - Display most recent 5 products  ");
		System.out.println("----------------------------------------");
		System.out.print("Enter Your Choice :");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		
		Queries statements = new Queries();
		Categories categories = new Categories();
		
		switch (choice) {
		case 1:
			
			statements.insertCatergories();
			break;
			
		case 2:
			
			statements.addProductes();
			break;
			
		case 3:
			
			statements.showProductDetails();
			break;
			
		case 4:
	
			statements.showCatergories();
			break;
	
		case 5:
	
			statements.showProducts();
			break;
	
		case 6:
	
			statements.showAvgProducts();
			break;
	
		case 7:
	
			statements.showHigestDescription();
			break;
	
		case 8:
	
			statements.deleteCategories();
			break;
	
		case 9:
	
			statements.deleteProducts();
			break;
	
		case 10:
	
			statements.displayProducts();
			break;

		default:
			System.out.println("Wrong Input..");
			break;
		}
		
	}

}
