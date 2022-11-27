<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="asset/style/style.css"></link>
	<link rel="stylesheet" href="css/bootstrap.css"></link>
<style>
		body {font-family: Arial, Helvetica, sans-serif;}
			* {box-sizing: border-box;}
			
		.section{
			padding: 250px;
    		text-align: left;
			background: linear-gradient(#FFFFFF, #E6E6FA, #C3B1E1, #E0B0FF, #CF9FFF, #FFFFFF);
		}
	
		
</style>
</head>
<body>
<%@ include file = "header-general.html" %>

	 <div class="section">
	 <div class="limiter">
	 <div class="container-login100">
	 <div class="wrap-login100 p-t-50 p-b-90">
     <form action="login?status=typed" method="post" class="login100-form validate-form flex-sb flex-w">
           	<h3 align="center">Login</h3>

           	${alert}

         	<label for="usernames">Username</label>
			<input type="text" id="address" name="username">
			<br><br>
			<label for="password">Password</label>
			<input type="text" id="password" name="password">
			<br><br><br>

	<div class="container-login100-form-btn m-t-17">
    		<button type="submit" class="login100-form-btn">
            Login
     		</button>
	</div>
    </form>
	</div>

    <div class="text-center">
    <p class="txt1" style="color: #07010d">
			Don't have an account?
            <a href="registration-page.jsp" class="container-login100-form-btn m-t-17">
            <button type="submit" class="login100-form-btn">
            SIGN UP
            </button></a></p>
    </div>
    </div>
	</div>
    </div>
    

<%@ include file = "footer-general.html" %>
</body>
</html>