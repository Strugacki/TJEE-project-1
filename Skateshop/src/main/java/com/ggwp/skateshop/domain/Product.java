package com.ggwp.skateshop.domain;

public class Product {

	private long product_id;
	private String product_name;
	private String product_category;
	private boolean available;
	
	
	
	
	public Product(long product_id, String product_name, String product_category, boolean available){
		this.product_id=product_id;
		this.product_name=product_name;
		this.product_category=product_category;
		this.available=available;
		
	}
	
	
	
	
}
