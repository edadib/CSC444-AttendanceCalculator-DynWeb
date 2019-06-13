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
</body>
</html>