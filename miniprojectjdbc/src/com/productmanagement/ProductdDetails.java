package com.productmanagement;

public class ProductdDetails {

	private int    product_id;
	private String product_code;
	private String product_name;
	private double product_price;
	private String product_description;
	private int    product_quantity;
	private double product_rating;
	
	public ProductdDetails(int product_id, String product_code, String product_name, double product_price,
			String product_description, int product_quantity, double product_rating) {
		
		this.product_id = product_id;
		this.product_code = product_code;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_description = product_description;
		this.product_quantity = product_quantity;
		this.product_rating = product_rating;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public int getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}

	public double getProduct_rating() {
		return product_rating;
	}

	public void setProduct_rating(double product_rating) {
		this.product_rating = product_rating;
	}

	@Override
	public String toString() {
		return "ProductdDetails [product_id=" + product_id + ", product_code=" + product_code + ", product_name="
				+ product_name + ", product_price=" + product_price + ", product_description=" + product_description
				+ ", product_quantity=" + product_quantity + ", product_rating=" + product_rating + "]";
	}
	
	
	
}
