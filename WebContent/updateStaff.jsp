<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<link href="css/style.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>UPDATE STAFF</title>
</head>
<body>
<%
   if(session.getAttribute("staff")== null) {
      response.sendRedirect("login.jsp");
   }
%>  
	<div class="navbar">
		<a href="listStaff.jsp">Home</a>
		<a href="addStaff.jsp">Add Staff</a>
		<a class="active" href="updateStaff.jsp">Update Staff</a>
		<a href="listStaff.jsp">Staff Directory</a>
		<a href="logout.jsp">Logout</a>
	</div>
	<div class="homepage">
		<div class="add">
			<h2>UPDATE STAFF</h2>
			<form action="StaffController" method="post">
				ID :<br>
				<input type="text" name="id" value="<c:out value="${staff.id}"/>" readonly>
				<br><br>
				NAME :<br>
				<input type="text" name="name" value="<c:out value="${staff.name}"/>" >
				<br><br>
				AGE :<br>
				<input type="text" name="age" value="<c:out value="${staff.age}"/>" >
				<br><br>
				DEPARTMENT :<br>
				<input type="text" name="department" value="<c:out value="${staff.department}"/>" >
				<br><br>
				EMAIL :<br>
				<input type="email" name="email" value="<c:out value="${staff.email}"/>" >
				<br><br>
				ADDRESS:<br>
				<textarea name="address" rows="5" cols="50"><c:out value="${staff.address}"/></textarea>
				<br><br>
				PASSWORD :<br>
				<input type="password" name="password" value="<c:out value="${staff.password}"/>" >
				<br><br>
				GRADE :<br>
				<input type="text" name="grade" value="<c:out value="${staff.grade}"/>" >
				<br><br>
				<input type="submit" value="Add">
				<input type="reset" value="Reset">
			</form>
		</div>
	</div>
</body>
</html>
