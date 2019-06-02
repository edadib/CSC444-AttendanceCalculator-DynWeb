<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="meylis.model.StaffBean, meylis.dao.StaffDAO, java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staff Directory</title>
</head>
<body>
<% List<StaffBean> staff = StaffDAO.getAllStaff();
   
%>
<h1>List of Staff</h1>
<table border="1">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Age</th>
		<th>Department</th>
		<th>Email</th>
		<th>Address</th>
		<th>Password</th>
		<th>Grade</th>
		<th colspan="2">Action</th>
	</tr>
	<% for(StaffBean s:staff){%>
	<tr> 
		<td><%= s.getId() %></td>
		<td><%= s.getName() %></td>
		<td><%= s.getAge() %></td>
		<td><%= s.getDepartment() %></td>
		<td><%= s.getEmail() %></td>
		<td><%= s.getAddress() %></td>
		<td><%= s.getPassword() %></td>
		<td><%= s.getGrade() %></td>
		<td><a href="StaffController?action=delete&Id=<%= s.getId() %>">Delete</a></td>
		<td><a href="StaffController?action=update&Id=<%= s.getId() %>">Update</a></td>
	<%}%>
	</tr>
</table>
</body>
</html>
