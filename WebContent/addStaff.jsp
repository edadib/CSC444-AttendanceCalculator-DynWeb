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
	<div class="navbar">
		<a class="active" href="#home">Home</a>
		<a href="#news">News</a>
		<a href="#contact">Contact</a>
	</div>
	<div class="homepage">
		<div class="add">
			<h2>ADD STAFF</h2>
			<form action="StaffController" method="post">
				STAFF ID :<br>
				<input type="text" name="id" >
				<br><br>
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
				LEVEL :
				<input type="text" name="level" >
				<br><br>
				<input type="submit" value="Add">
				<input type="reset" value="Reset">
			</form>
		</div>
	</div>
</body>
</html>
