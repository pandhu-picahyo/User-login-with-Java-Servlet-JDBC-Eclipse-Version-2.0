package com.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.dao.User_Dao;
import com.info.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig(maxFileSize = 16177216) 
public class Edit_Personal_Dao extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter ("id"));
		String name = request.getParameter ("name");
		String email = request.getParameter ("email");
		String filename = request.getParameter ("filename");		
		
		try {
			
			Connection con = User_Dao.getConnection();  
			PreparedStatement st = con.prepareStatement("update userdata2 set name=?, email=?, filename=? where id=?");
			
			st.setString(1, name);
			st.setString(2, email);
			st.setString(3, filename);
			st.setInt(4, id);
			
			st.executeUpdate () ;
			
			st.close();
			con.close();
			PrintWriter out = response.getWriter();
			out.println ("<html><body><b>Successfully Updated"	+ "</b></body></html>") ;
			response.sendRedirect("login-page.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static User getRecordById(int id){  
	    User d=null;  
	    try{  
	    	Connection con = User_Dao.getConnection(); 
	        PreparedStatement ps=con.prepareStatement("select * from userdata2 where id=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            d=new User();  
	            d.setId(rs.getInt("id"));
	            d.setName(rs.getString("name"));
	            d.setEmail(rs.getString("email"));
	            d.setFilename(rs.getString("filename"));

	        }  
	    }catch(Exception e){System.out.println(e);}  
	    	return d;  
	}  

}