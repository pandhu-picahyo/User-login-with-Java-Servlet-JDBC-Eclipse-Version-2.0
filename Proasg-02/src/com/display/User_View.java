package com.display;

import java.io.IOException;  
import java.io.PrintWriter;

import java.util.List;
import com.info.User;
import com.dao.User_Dao;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/User_View")
public class User_View extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        
    	response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        out.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
        out.print("<br><br><br>");
        
        out.print("<center>");
        out.println("<h1>Personal Data</h1>");
          
        List<User> list = User_Dao.getAllUserDatas();
          
        out.println("<div style='margin:auto;width:900px;margin-top:100px;'>");
        out.println("<table class='table table-hover table-bordered'>");
        out.print(
        		"<tr><th>Id</th> "+ 
        		"<th>Name</th>" + 
        		"<th>Email</th>" + 
        		"<th>File</th>" +
        		"<th>Edit User</th>" +
        		"<th>Delete User</th></tr>");
        
        for(User e:list){  
         out.print(
        		 	"<tr><td>"+e.getId()+"</td>"
        		 		+ "<td>"+e.getName()+"</td>"
        		  		+ "<td>"+e.getEmail()+"</td>"
        		  		+ "<td>"+e.getFilename()+"</td>"
        		  		+ "<td><a href='edit-personal-data.jsp?id="+e.getId()+"'><button type=\"button\">Edit</button></a></td>"
        		  		+ "<td><a href='Delete_User?id="+e.getId()+"'><button type=\"button\">Delete</button></a></td></tr>"); 
         
        }  
        out.print("</table>");
        out.println("</div>");
        out.print("</center>");
        out.close();  
    }  
}  