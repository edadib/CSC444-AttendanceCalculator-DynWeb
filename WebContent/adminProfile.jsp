<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="meylis.model.StaffBean, meylis.dao.StaffDAO, java.sql.*, java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>My Profile</title>
</head>
<body>
<%
   if(session.getAttribute("staff")== null) {
      response.sendRedirect("login.jsp");
   }
%> 
	<div class="navbar">
			<a class="active" href="adminProfile.jsp">Home</a>
			<a href="addStaff.jsp">Add Staff</a>
			<a href="updateStaff.jsp">Update Staff</a>
			<a href="listStaff.jsp">Staff Directory</a>
			<a href="logout.jsp">Logout</a>
	</div>
	<div class="homepage">
		<div class="add">
			<table border="1" align="center">
				<h1 style="text-transform: uppercase;">WELCOME ${staff.name}</h1>
				<tr>
					<td>Id</td>
					<td>${staff.id}</td>
				</tr>
				<tr>
					<td>Name</td>
					<td>${staff.name}</td>
				</tr>
				<tr>
					<td>Age</td>
					<td>${staff.age}</td>
				</tr>
				<tr>
					<td>Department</td>
					<td>${staff.department}</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>${staff.email}</td>
				</tr>
				<tr>
					<td>Address</td>
					<td>${staff.address}</td>
				</tr>
				<tr>
					<td>Grade</td>
					<td>${staff.grade}</td>
				</tr>
				<tr>
					<td colspan="2"><a href="StaffController?action=update&id=${staff.id}">Update</a></td>
				</tr>
			</table>	
		</div>
	</div>
</body>
</html>
