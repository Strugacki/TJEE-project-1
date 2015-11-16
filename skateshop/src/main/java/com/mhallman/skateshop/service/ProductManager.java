package com.mhallman.skateshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mhallman.skateshop.domain.Product;

public class ProductManager {

	
	/**
	 * Initialization of variables used in ProductManager class
	 */
	private PreparedStatement addProductStmt;
	private PreparedStatement deleteProductStmt;
	private PreparedStatement deleteAllProductsStmt;
	private PreparedStatement getAllProductsStmt;
	private dbConnect dbconn = new dbConnect();
	private Connection conn = dbconn.getConnection();
	private Statement statement;
	private ResultSet rs;
	private String createTableProduct = "CREATE TABLE Product(id_product bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, product_name varchar(20), brand_name varchar(20), price double)";
	
	
	/**
	 * Basic constructor for ProductManager class
	 * - creates table Product if not exists
	 * - prepares statements 
	 */
	public ProductManager(){
		try {
			if(conn!=null){
				System.out.print("Connected to database\n");
			}
			rs = conn.getMetaData().getTables(null, null, null,null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Product".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}
			if (!tableExists){
				statement = conn.createStatement();
				statement.executeUpdate(createTableProduct);
			}

			addProductStmt = conn.prepareStatement("INSERT INTO Product (product_name,brand_name,price) VALUES (?, ?, ?)");
			deleteAllProductsStmt = conn.prepareStatement("DELETE FROM Product");
			deleteProductStmt = conn.prepareStatement("DELETE FROM Product WHERE id_product=?");
			getAllProductsStmt = conn.prepareStatement("SELECT id_product, product_name,brand_name, price FROM Product");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * Method deleting all Products form Database
	 */
	public void deleteProducts(){
		try {
			deleteAllProductsStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method adding Product to Database
	 * @param product
	 * @return count
	 */
	public int addProduct(Product product){
		int count=0;
		try {
			addProductStmt.setString(1, product.getProduct_name());
			addProductStmt.setString(2, product.getBrand_name());
			addProductStmt.setDouble(3, product.getPrice());
			count=addProductStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;	
	}
	
	
	public void deleteProduct(Product product){

		try {
			deleteProductStmt.setLong(1, product.getId_product());
			deleteProductStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	/**
	 * Method getting all existing Products from Database
	 * @return Products
	 */
	public List<Product> getAllProducts(){
		ArrayList<Product> Products = new ArrayList<Product>();
		
		try {
			ResultSet rs = getAllProductsStmt.executeQuery();
			while(rs.next()){
				Product product = new Product();
				product.setId_product(rs.getLong("id_product"));
				product.setProduct_name(rs.getString("product_name"));
				product.setBrand_name(rs.getString("brand_name"));
				product.setPrice(rs.getDouble("price"));
				Products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return Products;
		
		
	}
	
	
}
