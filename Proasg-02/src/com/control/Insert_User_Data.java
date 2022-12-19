package com.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.info.Data_Connect;
import com.info.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(maxFileSize = 16177216)
public class Insert_User_Data extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// getting request value from form page -3
		String name = request.getParameter ("name");
		String email = request.getParameter ("email");
		Part file = request.getPart("file");
		String filename = file.getSubmittedFileName();
		String comment = request.getParameter ("comment");
		
		InputStream fileContent = file.getInputStream();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));
	    StringBuilder fileContents = new StringBuilder();
	    String line;
	    while ((line = reader.readLine()) != null) {
	      fileContents.append(line).append("\n");
	    }
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = Data_Connect.getConnection();
			PreparedStatement ps = con.prepareStatement ("insert into userdata2 (name, email, file, filename, comment) values(?, ?, ?, ?, ?)");

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, fileContents.toString());
			ps.setString(4, filename);
			ps.setString(5, comment);
			ps.executeUpdate() ;
			
			ps.close();
			con.close();
			
			PrintWriter out = response.getWriter();
			out.println ("<html><body><b>Successfully Inserted"	+ "</b></body></html>") ;
			response.sendRedirect("user-home-page.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}		

}