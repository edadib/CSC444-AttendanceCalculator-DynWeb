package meylis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import meylis.model.StaffBean;
import meylis.connection.StaffConnection;
import meylis.model.StaffBean;

public class StaffDAO {

	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	int age;
	String id, name, department, email, address, password;
	
	
	public void add(StaffBean bean){
		id = bean.getId();
		name = bean.getName();
		department = bean.getDepartment();
		age = bean.getAge();
		email = bean.getEmail();
		address = bean.getAddress();
		password = bean.getPassword();
		
		try {
			currentCon = StaffConnection.getConnection();
			ps=currentCon.prepareStatement("insert into staff(id,name,email,department,age,password,address)values(?,?,?,?,?,?,?)");
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3,email);
			ps.setString(4,department);
			ps.setInt(5,age);
			ps.setString(6,password);
			ps.setString(7,address);
			ps.executeUpdate();
		}
		catch (Exception ex) {
			System.out.println("failed: An Exception has occurred! " + ex);
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
		}
	
	/*public void deleteProduct(int productId) {
	    try {
	    	currentCon = ConnectionManager.getConnection();
	    	ps=currentCon.prepareStatement("delete from STAFF where Id=?");
	        ps.setInt(1, Id);
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void updateProduct(ProductBean bean) {

		productId = bean.getProductId();
		productName = bean.getProductName();
		price = bean.getPrice();
		quantity = bean.getQuantity();
		rating = bean.getRating();
		description = bean.getDescription();
		
		String searchQuery = "UPDATE product SET productName= '" + productName + "', price='" + price + "', quantity='" + quantity + "', rating='" + rating + "', description='" + description + "' WHERE productId= '" + productId + "'";
		
		try {

	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static List<ProductBean> getAllProduct() {
	    List<ProductBean> products = new ArrayList<ProductBean>();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	    	stmt = currentCon.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from product");
	        
	        while (rs.next()) {
	            ProductBean product = new ProductBean();
	            product.setProductId(rs.getInt("productId"));
	            product.setProductName(rs.getString("productName"));
	            product.setPrice(rs.getDouble("price"));
	            product.setQuantity(rs.getInt("quantity"));
	            product.setRating(rs.getInt("rating"));
	            product.setDescription(rs.getString("description"));
	            products.add(product);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return products;
	}
	
	public ProductBean getProductById(int productId) {
		ProductBean product = new ProductBean();
	    try {
	    	currentCon = ConnectionManager.getConnection();
	        ps=currentCon.prepareStatement("select * from product where productId=?");
	        
	        ps.setInt(1, productId);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {	            
	            product.setProductId(rs.getInt("productId"));
	            product.setProductName(rs.getString("productName"));
	            product.setPrice(rs.getDouble("price"));
	            product.setQuantity(rs.getInt("quantity"));
	            product.setRating(rs.getInt("rating"));
	            product.setDescription(rs.getString("description"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return product;
	}*/
}
