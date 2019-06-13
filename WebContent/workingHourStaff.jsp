<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="css/style.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<title>WORKING HOUR</title>
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
			<h2>WORKING HOUR DETAIL</h2>
			<form action="WorkingController" method="post">
				ID :<br>
				<input style="text-align: center;" type="text" name="id" value="<c:out value="${staff.id}"/>" readonly>
				<br><br>
				<select name="day">
				  	<option value="mon">MONDAY</option>
				    <option value="tue">TUESDAY</option>
				    <option value="wed">WEDNESDAY</option>
				    <option value="thu">THURSDAY</option>
				    <option value="fri">FRIDAY</option>
				    <option value="sat">SATURDAY</option>
				    <option value="sun">SUNDAY</option>
				</select><br><br>
				START TIME :<br>
				<input type="text" name="start" placeholder="24 hours format/0000">
				<br><br>
				END TIME :<br>
				<input type="text" name="end" placeholder="24 hours format/2400">
				<br><br>
				<input type="submit" value="Submit">
				<input type="reset" value="Reset">
			</form>
		</div>
	</div>
</body>
</html>