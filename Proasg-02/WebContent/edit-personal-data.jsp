<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.dao.Edit_Personal_Dao" %>
<%@ page import="com.info.User" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name = "viewport" content ="width = device-width, initial-scale=1">
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
	
	.styled {
    		border: 1;
    		line-height: 4.5;
    		padding: 0 20px;
    		font-size: 1rem;
    		text-align: center;
    		color: #00008B;
    		border-radius: 10px;
    		background-color: #E5E4E2;
    
		}
		
		button {
  			width: 50%;
  			margin: 5px;
  			background-color: #7DF9FF;
		}
		
		.section{
			padding: 250px;
    		text-align: left;
			background: linear-gradient(#FFFFFF, #E6E6FA, #C3B1E1, #E0B0FF, #CF9FFF, #FFFFFF);
		}
	
</style>
<body>
	<%@ include file = "header-general.html" %>
	<br><br>
	<div class="section">
	<h3 align="center">Edit Personal Data</h3>

	<%  
		String id=request.getParameter("id");  
		User d=Edit_Personal_Dao.getRecordById(Integer.parseInt(id));  
	%>
	
	<form action="./editpersonaldata" method="post">
		<div class="container">	
			<input type=hidden name="id" value="<%=d.getId() %>">
			<label for="name">Name</label>
			<input type="text" id="name" name="name" placeholder="<%=d.getName() %>">
			<br>
			<label for="email">Email</label>
			<input type="text" id="email" name="email" placeholder="<%=d.getEmail() %>">
			<br>
			<label for="filename">File Name</label>
			<input type="text" id="filename" name="filename" placeholder="<%=d.getFilename() %>">
			<br>
			
			
			<br><br><br>
			<input type="submit" value="Submit" style="height:50px; width:150px">
			
		</div>
	</form>
	
	<br/>
		
		<a href="login-page.jsp" class="container-login100-form-btn m-t-17">
            <button type="submit" class="favorite styled">
            Back to Front Page
            </button></a><br><br>
		
		</div>
	
	<%@ include file = "footer-general.html" %>
</body>
</html>