package com.display;

import java.io.IOException;  
import java.io.PrintWriter;  

import com.info.User;
import com.dao.User_Dao;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/Edit_User_Data")  
public class Edit_User_Data extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        
        out.println("<link rel='stylesheet' href='css/bootstrap.css'></link>");
        out.println("<h1>Update User</h1>"); 
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        User e = User_Dao.getEmployeeById(id);  
          
        out.print("<form action='./editdata' method='post'>");  
        out.print("<table class='table table-hover table-bordered'>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
        out.print("<tr><td>Username:</td><td><input type='username' name='username' value='"+e.getUsername()+"'/></td></tr>");
        out.print("<tr><td>Contact No:</td><td><input type='contactno' name='contactno' value='"+e.getContactno()+"'/></td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");
          
        out.close();  
    }  
}  