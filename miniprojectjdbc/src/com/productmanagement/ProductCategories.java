package com.productmanagement;

public class ProductCategories {

	private String product_code;
	private String product_category;

	public ProductCategories(String product_code, String product_category) {
		this.product_code = product_code;
		this.product_category = product_category;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getProduct_category() {
		return product_category;
	}

	public void setProduct_category(String product_category) {
		this.product_category = product_category;
	}

	@Override
	public String toString() {
		return "ProductCategories [product_code=" + product_code + ", product_category=" + product_category + "]";
	}

}
