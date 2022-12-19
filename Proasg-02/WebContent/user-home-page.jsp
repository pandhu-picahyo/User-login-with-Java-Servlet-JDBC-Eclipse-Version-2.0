<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	
		button {
  			width: 100%;
  			height: 100px;
  			margin: 15px;
  			background-color: #50C878;
		}
		
</style>

</head>
<body>
<%@ include file = "header-general.html" %>
 	
 	 <center>
 	 <h1>Welcome : <label for="name">${user.name}</label>
   
     <img class="icon" src="data:image/jpg;base64,${user.basephoto}"
            style="width: 70px; border-radius: 80%; margin-right: 10px; margin-bottom: 10px">
	 <a href="login-page.jsp" class="container-login100-form-btn m-t-17">
            <button type="submit" class="login100-form-btn" style="height:50px; width:150px; font-size:20px">
                  	LOG OUT </button></a>
	 </h1>
     </center>
       
       <div class="section">
       <br><br><br>
       <h2>
        <a href="user-add-record.jsp">
        	<button type="submit" class="login100-form-btn">
                    Add New Record</button></a>
        
        <a href="User_View">
        	<button type="submit" class="login100-form-btn">
                    View Previous Record</button></a>
		</h2>
		</div>
<%@ include file = "footer-general.html" %>		
</body>
</html>