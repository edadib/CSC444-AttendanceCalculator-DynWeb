<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<link href="css/style.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>STAFF DETAIL</title>
</head>
<body>
<%
   if(session.getAttribute("staff")== null) {
      response.sendRedirect("login.jsp");
   }
%> 
	<div class="navbar">
		<a href="memberProfile.jsp">Home</a>
		<a href="updateInfo.jsp">Update Profile</a>
		<a class="active" href="workingHourStaff.jsp">Working Hour</a>
		<a href="logout.jsp">Logout</a>
	</div>
	<div class="homepage">
		<div class="add">
			<table border="1" align="center">
				<tr>
					<td>MONDAY</td>
					<td>${work.mon}</td>
				</tr>
				<tr>
					<td>TUESDAY</td>
					<td>${work.tue}</td>
				</tr>
				<tr>
					<td>WEDNESDAY</td>
					<td>${work.wed}</td>
				</tr>
				<tr>
					<td>THUSDAY</td>
					<td>${work.thu}</td>
				</tr>
				<tr>
					<td>FRIDAY</td>
					<td>${work.fri}</td>
				</tr>
				<tr>
					<td>SATURDAY</td>
					<td>${work.sat}</td>
				</tr>
				<tr>
					<td>SUNDAY</td>
					<td>${work.sun}</td>
				</tr>
				<tr>
					<td>TOTAL</td>
					<td>${work.total}</td>
				</tr>
			</table>	
		</div>
	</div>

</body>
</html>