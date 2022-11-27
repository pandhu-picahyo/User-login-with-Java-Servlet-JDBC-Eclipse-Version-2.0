<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name = "viewport" content ="width = device-width, initial-scale=1">
<link rel="stylesheet" href="asset/style/style.css"></link>
<link rel="stylesheet" href="css/bootstrap.css"></link>
<style>
	body {font-family: Arial, Helvetica, sans-serif;}
			* {box-sizing: border-box;}
	
	input[type=text], select, textarea {
		width: 100%;
		padding: 12px;
		border: 1px solid #ccc; /* grey */
		border-radius: 4px;
		box-sizing: border-box;
		margin-top: 6px;
		margin-bottom: 16px;
		resize: vertical;
	}
	
	input[type=submit] {
		background-color : #af8b4c;
		color: white;
		padding: 12px 20px;
		border: none;
		border-radius: 4px;
		cursor: pointer;
	}
	
	input[type=submit] {
		background-color: #45a049;
	}
	
	input[type=submit]:hover {
  	background-color: #FFFFE0;
	}
	
	.container {
		border-radius: 5px;
		background-color: #ADD8E6; /* light blue */
		padding: 20px;
		width: 700px;
		margin-left: 150px;
	}
	
	.section{
		padding: 250px;
    	text-align: left;
		background: linear-gradient(#FFFFFF, #E6E6FA, #C3B1E1, #E0B0FF, #CF9FFF, #FFFFFF);
	}
	
	.btn-group a {
  			background-color: #4187f0; 
  			border: 1px solid blue; 
  			color: black; 
  			padding: 20px 48px; 
  			cursor: pointer; 
  			float: left; 
  			width: 50%;
  			margin: 20px;
	}

	.btn-group a:not(:last-child) {
  			border-right: none; /* Prevent double borders */
	}

	/* Clear floats (clearfix hack) */
	.btn-group:after {
  			content: "";
  			clear: both;
  			display: table;
	}

	/* Add a background color on hover */
	.btn-group a:hover {
  			background-color: yellow;
	}
	
</style>
</head>
<body>
<%@ include file = "header-general.html" %>

<div class="section">

	<br><br>
	<h3 align="center">Add New User</h3>

	
	<form action="./register" method="post" enctype="multipart/form-data">
		
		${alert}
		
		<div class="container">	
		
			<label for="name">Name</label>
			<input type="text" id="name" name="name">
			<br>
			<label for="email">Email</label>
			<input type="text" id="email" name="email">
			<br>
			<label for="usernames">Username</label>
			<input type="text" id="address" name="username">
			<br>
			<label for="password">Password</label>
			<input type="text" id="password" name="password">
			<br>
			<label for="confirmpassword">Confirm Password</label>
			<input type="text" id="confirmpassword" name="confirmpassword">
			<br>
			<label for="contactno">Contact No</label>
			<input type="text" id="contactno" name="contactno">
			
			<br>
			<br>
			<label for="photo">Photo</label>
			<input type="file" id="photo" name="photo" accept="image/jpeg, image/png, image/jpg">
			
			<br><br><br>
			<input type="submit" value="Submit">

		</div>
	</form>
	
	<br/> 
		<div class="btn-group">
		<a class="btn btn-outline-primary" href="login-page.jsp" role="button">Back to Login</a>
</div>
</div>
<%@ include file = "footer-general.html" %>

</body>
</html>