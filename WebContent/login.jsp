<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Log In</title>
</head>
<div class="homepage">
	<div class="login">
		<img src="img/Logo222.png" alt="logo" width="300" height="75">
		<h2>Log In</h2>
		<form action="LoginController" method="get">
		  STAFF ID :<br>
		  <input type="text" name="id" >
		   <br><br>
		  PASSWORD :<br>
		  <input type="password" name="password" >
		  <br><br>
		  <input type="submit" value="Enter">
		   <input type="reset" value="Reset">
		</form> 
	</div>
</div>
</body>
</html>
