<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="css/style.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>ADD STAFF</title>
</head>
<body>
<%
   if(session.getAttribute("staff")== null) {
      response.sendRedirect("login.jsp");
   }
%> 
	<div class="navbar">
		<a href="adminProfile.jsp">Home</a>
		<a class="active" href="addStaff.jsp">Add Staff</a>
		<a href="updateStaff.jsp">Update Staff</a>
		<a href="listStaff.jsp">Staff Directory</a>
		<a href="logout.jsp">Logout</a>
	</div>
	<div class="homepage">
		<div class="add">
			<h2>ADD STAFF</h2>
			<form action="StaffController" method="post">
				NAME :<br>
				<input type="text" name="name" >
				<br><br>
				AGE :<br>
				<input type="text" name="age" >
				<br><br>
				DEPARTMENT :<br>
				<input type="text" name="department" >
				<br><br>
				EMAIL :<br>
				<input type="email" name="email" >
				<br><br>
				ADDRESS:<br>
				<textarea name="address" rows="5" cols="50"></textarea>
				<br><br>
				PASSWORD :<br>
				<input type="password" name="password" >
				<br><br>
				Grade :<br>
				<input type="text" name="grade" >
				<br><br>
				<input type="submit" value="Add">
				<input type="reset" value="Reset">
			</form>
		</div>
	</div>
</body>
</html>
