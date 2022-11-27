package com.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import com.info.User;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;  
import javax.servlet.annotation.MultipartConfig;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;  

@WebServlet("/editdata")
@MultipartConfig(maxFileSize = 16177216) 
public class Edit_Data extends HttpServlet {  
	private static final long serialVersionUID = 102831973239L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {   
        
    	int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String contactno = request.getParameter("contactno");     
          
        User e=new User();  
        e.setName(name);
        e.setEmail(email);
        e.setUsername(username);
        e.setContactno(contactno);
        
        Connection con=null;  
        try
        {  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/asignment2", "root", "root");  
                     
            PreparedStatement ps=con.prepareStatement(  
                    "update userdata set name=?, email=?, "
                    + "username=?, contactno=? where id=?");  
                    
            ps.setString(1, e.getName());  
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getUsername());
            ps.setString(4, e.getContactno());
                      
            ps.executeUpdate();  
            ps.close();
            con.close();
            
            request.getRequestDispatcher("login-page.jsp").include(request, response);
        }
        catch(Exception ex)
        {
        	ex.printStackTrace();
        }  

       
    }  
  
}  