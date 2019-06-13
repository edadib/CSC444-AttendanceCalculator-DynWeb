package meylis.dao;

import java.sql.Connection;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import java.time.*;


import meylis.connection.ConnectionManager;
import meylis.model.StaffBean;
import meylis.model.WorkingBean;

public class StaffDAO {

	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	int age;
	String id, name, department, email, password, address, grade, day,comments;
	int wid;
	float mon,tue,wed,thu,fri,sat,sun,total;
	
	
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

	public void createWork(WorkingBean work){
		wid = work.getW_ID();
		mon = 0;
		tue = 0;
		wed = 0;
		thu = 0;
		fri = 0;
		sat = 0;
		sun = 0;
		total = 0;

		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into work(w_id,mon,tue,wed,thu,fri,sat,sun,total)values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,wid);
			ps.setFloat(2,mon);
			ps.setFloat(3,tue);
			ps.setFloat(4,wed);
			ps.setFloat(5,thu);			
			ps.setFloat(6,fri);
			ps.setFloat(7,sat);
			ps.setFloat(8,sun);
			ps.setFloat(9,total);
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
	
	public void updateTime(WorkingBean work) {
		wid = work.getW_ID();
		mon = work.getMon();
		tue = work.getTue();
		wed = work.getWed();
		thu = work.getThu();
		fri = work.getFri();
		sat = work.getSat();
		sun = work.getSun();
		total = work.getTotal();
		day = work.getDay();
		comments = work.getComments();
		total=mon+tue+wed+thu+fri+sat+sun;
		System.out.println("this is"+total);
		
		
		String searchQuery;
		
		if(day.equalsIgnoreCase("mon")) {
			if(total<40)
			{
				comments = "You does not meet your required working hours for this week yet, please do so";
			}
			else if(total>=40)
			{
				comments = "You have met your required working hours for this week yet, Congratulation";
			}
			searchQuery = "UPDATE work SET mon ='"+mon+"', total='"+total+"', comments='"+comments+"' where w_id='"+wid+"'";
		}
		else if(day.equalsIgnoreCase("tue")) {
			if(total<40)
			{
				comments = "You does not meet your required working hours for this week yet, please do so";
			}
			else if(total>=40)
			{
				comments = "You have met your required working hours for this week yet, Congratulation";
			}
			searchQuery = "UPDATE work SET tue ='"+tue+"', total='"+total+"', comments='"+comments+"' where w_id='"+wid+"'";
		}
		else if(day.equalsIgnoreCase("wed")) {
			if(total<40)
			{
				comments = "You does not meet your required working hours for this week yet, please do so";
			}
			else if(total>=40)
			{
				comments = "You have met your required working hours for this week yet, Congratulation";
			}
			searchQuery = "UPDATE work SET wed ='"+wed+"', total='"+total+"', comments='"+comments+"' where w_id='"+wid+"'";
		}
		else if(day.equalsIgnoreCase("thu")) {
			if(total<40)
			{
				comments = "You does not meet your required working hours for this week yet, please do so";
			}
			else if(total>=40)
			{
				comments = "You have met your required working hours for this week yet, Congratulation";
			}
			searchQuery = "UPDATE work SET thu ='"+thu+"', total='"+total+"', comments='"+comments+"' where w_id='"+wid+"'";
		}
		else if(day.equalsIgnoreCase("fri")) {
			if(total<40)
			{
				comments = "You does not meet your required working hours for this week yet, please do so";
			}
			else if(total>=40)
			{
				comments = "You have met your required working hours for this week yet, Congratulation";
			}
			searchQuery = "UPDATE work SET fri ='"+fri+"', total='"+total+"', comments='"+comments+"' where w_id='"+wid+"'";
		}
		else if(day.equalsIgnoreCase("sat")) {
			if(total<40)
			{
				comments = "You does not meet your required working hours for this week yet, please do so";
			}
			else if(total>=40)
			{
				comments = "You have met your required working hours for this week yet, Congratulation";
			}
			searchQuery = "UPDATE work SET sat ='"+sat+"', total='"+total+"', comments='"+comments+"' where w_id='"+wid+"'";
		}
		else {
			if(total<40)
			{
				comments = "You does not meet your required working hours for this week yet, please do so";
			}
			else if(total>=40)
			{
				comments = "You have met your required working hours for this week yet, Congratulation";
			}
			searchQuery = "UPDATE work SET sun ='"+sun+"', total='"+total+"', comments='"+comments+"' where w_id='"+wid+"'";
		}
		
		try {
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);

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
	
	public void resetTable() {
		mon = 0;
		tue = 0;
		wed = 0;
		thu = 0;
		fri = 0;
		sat = 0;
		sun = 0;
		total = 0;
		comments = "";
		
		String searchQuery = "UPDATE work SET mon ='"+mon+"', tue ='"+tue+"', wed ='"+wed+"', thu ='"+thu+"', fri ='"+fri+"', total='"+total+"', comments='"+comments+"'";
		
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
			ResultSet rs = stmt.executeQuery("select * from staff ORDER BY grade");

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

	public WorkingBean getWorkLogById(int wid) {
		WorkingBean w = new WorkingBean();
		try {
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from work where w_id=?");

			ps.setInt(1, wid);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {	            
				w.setW_ID(rs.getInt("w_id"));
				w.setMon(rs.getFloat("mon"));
				w.setTue(rs.getFloat("tue"));
				w.setWed(rs.getFloat("wed"));
				w.setThu(rs.getFloat("thu"));
				w.setFri(rs.getFloat("fri"));
				w.setSat(rs.getFloat("sat"));
				w.setSun(rs.getFloat("sun"));
				w.setTotal(rs.getFloat("total"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return w;
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
