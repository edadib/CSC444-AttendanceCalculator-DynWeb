package meylis.dao;

import java.sql.Connection;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import meylis.connection.ConnectionManager;
import meylis.model.StaffBean;

public class StaffDAO {

	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	int age;
	String id, name, department, email, password, address, grade;
	
	
	public void add(StaffBean bean){
		id = bean.getId();
		name = bean.getName();
		department = bean.getDepartment();
		age = bean.getAge();
		email = bean.getEmail();
		address = bean.getAddress();
		password = bean.getPassword();
		grade = bean.getGrade();
		
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into staff(id,name,age,department,email,address,password,grade)values(?,?,?,?,?,?,?,?)");
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setInt(3,age);
			ps.setString(4,department);
			ps.setString(5,email);			
			ps.setString(6,address);
			ps.setString(7,password);
			ps.setString(8,grade);
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

	public void deleteStaff(String id) {
	    try {
	    	currentCon = ConnectionManager.getConnection();
	    	ps=currentCon.prepareStatement("delete from STAFF where id=?");
	        ps.setString(1, id);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void updateStaff(StaffBean bean) {
		id = bean.getId();
		name = bean.getName();
		department = bean.getDepartment();
		age = bean.getAge();
		email = bean.getEmail();
		address= bean.getAddress();
		password= bean.getPassword();
		grade= bean.getGrade();
		
		String searchQuery = "UPDATE staff SET name= '" + name + "', department='" + department+ "', age='" + age + "', email='" + email + "', address='" + address + "', password='" + password + "', grade='" + grade + "' WHERE id= '" + id + "'";
		
		try {
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static List<StaffBean> getAllStaff() {
		List<StaffBean> staff = new ArrayList<StaffBean>();
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery("select * from staff");

			while (rs.next()) {
				StaffBean s = new StaffBean();
				s.setId(rs.getString("id"));
				s.setName(rs.getString("name"));
				s.setAge(rs.getInt("age"));
				s.setDepartment(rs.getString("department"));
				s.setEmail(rs.getString("email"));
				s.setAddress(rs.getString("address"));
				s.setPassword(rs.getString("password"));
				s.setGrade(rs.getString("grade"));
				staff.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staff;
	}
	
	public StaffBean getStaffById(String id) {
		StaffBean staff = new StaffBean();
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from staff where id=?");

			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {	            
				staff.setId(rs.getString("id"));
				staff.setName(rs.getString("name"));
				staff.setAge(rs.getInt("age"));
				staff.setDepartment(rs.getString("department"));
				staff.setEmail(rs.getString("email"));
				staff.setAddress(rs.getString("address"));
				staff.setPassword(rs.getString("password"));
				staff.setGrade(rs.getString("grade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staff;
	}
	
	//login
	public static StaffBean login(StaffBean bean) throws NoSuchAlgorithmException {
		
	    String id = bean.getId();
	    String password = bean.getPassword();
	    
	    String searchQuery = "select * from staff where id='" + id + "' AND password='" + password + "'"; 

	    System.out.println("Your Id is " + id);
	    System.out.println("Your Password is " + password);
	    System.out.println("Query: " + searchQuery);

	    try {
	        currentCon = ConnectionManager.getConnection();
	        stmt = currentCon.createStatement();
	        rs = stmt.executeQuery(searchQuery);
	        boolean more = rs.next();

	        // if user exists set the isValid variable to true
	        if (more) {
	        	String name = rs.getString("name");
	        	id = rs.getString("id");
	        	String grade = rs.getString("grade");
	       
	       		System.out.println("Welcome " + name);
	            bean.setId(id);
	            bean.setValid(true);
	            bean.setGrade(grade);
	       	}
	       
	        // if user does not exist set the isValid variable to false
	        else if (!more) {
	        	System.out.println("Sorry, you are not a registered user! Please sign up first");
	        	bean.setValid(false);
	        }
	       
	    }

	    catch (Exception ex) {
	        System.out.println("Log In failed: An Exception has occurred! " + ex);
	    }

	    finally {
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (Exception e) {
	            }
	            rs = null;
	        }

	        if (stmt != null) {
	            try {
	                stmt.close();
	            } catch (Exception e) {
	            }
	            stmt = null;
	        }

	        if (currentCon != null) {
	            try {
	                currentCon.close();
	            } catch (Exception e) {
	            }

	            currentCon = null;
	        }
	    }

	    return bean;
	}
}
