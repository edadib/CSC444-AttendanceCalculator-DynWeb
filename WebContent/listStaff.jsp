<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="meylis.model.StaffBean, meylis.dao.StaffDAO, java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<link href="css/style.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>Staff Directory</title>
</head>
<body>
	<div class="navbar">
		<a href="listStaff.jsp">Home</a>
		<a href="addStaff.jsp">Add Staff</a>
		<a href="updateStaff.jsp">Update Staff</a>
		<a class="active" href="listStaff.jsp">Staff Directory</a>
		<a href="login.jsp">Logout</a>
	</div>
	<div class="homepage">
		<div class="add">
			<% List<StaffBean> staff = StaffDAO.getAllStaff();

			%>
			<h1>List of Staff</h1>
			<table border="1" align="center">
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
					<td><a href="StaffController?action=view&id=<%= s.getId() %>"><%= s.getId() %></a></td>
					<td><%= s.getName() %></td>
					<td><%= s.getAge() %></td>
					<td><%= s.getDepartment() %></td>
					<td><%= s.getEmail() %></td>
					<td><%= s.getAddress() %></td>
					<td><%= s.getPassword() %></td>
					<td><%= s.getGrade() %></td>
					<td><a href="StaffController?action=delete&id=<%= s.getId() %>">Delete</a></td>
					<td><a href="StaffController?action=update&id=<%= s.getId() %>">Update</a></td>
					<%}%>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
