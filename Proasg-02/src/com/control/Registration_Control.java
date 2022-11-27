package com.control;

import com.dao.User_Dao;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class Registration_Control extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	
    User_Dao userDao = new User_Dao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String name = request.getParameter("name");
        String email = request.getParameter("email");
    	String username = request.getParameter("username");
        String password = request.getParameter("password");
        String contactno = request.getParameter("contactno");
        String confirmpassword = request.getParameter("confirmpassword");
        
        Part part = request.getPart("photo");
        InputStream photo = part.getInputStream();

        // Check password and confirmpassword are the same
        if (!password.equals(confirmpassword)) {
            String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
                    " <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                    " <h1>Please input correct confirm password!</h1>\n" +
                    " </p>\n" +
                    " </div>";
            request.setAttribute("alert", alert);
            request.getRequestDispatcher("registration-page.jsp").forward(request, response);
        }
        
        // Check username is existed or not from database.
        if (userDao.checkUsernameExists(username)) 
        {
            String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
                    " <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                    " <h1>Username already exist!</h1>\n" +
                    " </p>\n" +
                    " </div>";
            request.setAttribute("alert", alert);
            request.getRequestDispatcher("registration-page.jsp").forward(request, response);
        }
        // Insert username, password to database and create account.
        else 
        {
            userDao.createUserAccount(name, email, username, password, contactno, photo);
            String alert = "<div class=\"alert alert-success wrap-input100\">\n" +
                    " <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                    " <h1>Your data is successfully inserted</h1>\n" +
                    " </p>\n" +
                    " </div>";
            request.setAttribute("alert", alert);
            request.getRequestDispatcher("login-page.jsp").forward(request, response);
        }
    }
}