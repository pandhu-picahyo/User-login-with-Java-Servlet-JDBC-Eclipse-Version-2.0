package com.control;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Image_Data")
public class Image_Data extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
        System.out.println("Successfully retrive image with ID no : "+id);
        Connection con = null;
        
	    try {
	    	
	    	Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/asignment2", "root", "root");
	        PreparedStatement ps = con.prepareStatement("select * from userdata where id=?");
	        ps.setString(1, id);
	        
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) 
	        {
	            Blob blob = rs.getBlob("photo");
	            byte byteArray[] = blob.getBytes(1, (int) blob.length());
	            response.setContentType("photo/jpg");
	            OutputStream os = response.getOutputStream();
	            os.write(byteArray);
	            os.flush();
	            os.close();
	        } 
	        else {
	            System.out.println("No image found with this id.");
	        }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		
	}

}