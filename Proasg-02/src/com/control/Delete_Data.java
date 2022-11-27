package com.control;

import java.io.IOException;
import com.dao.User_Dao;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/Delete_Data")  
public class Delete_Data extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        
    	String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        User_Dao.delete(id);  
        response.sendRedirect("Admin_View");  
    }  
}  