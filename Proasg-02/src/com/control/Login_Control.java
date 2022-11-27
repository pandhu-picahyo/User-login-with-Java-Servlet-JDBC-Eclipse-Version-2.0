package com.control;

import com.dao.User_Dao;
import com.info.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Login_Control", value = "/login")
public class Login_Control extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	
    User_Dao userDao = new User_Dao();

    private User getUserCookie(HttpServletRequest request) {
        
    	// Get list cookies of the browser.
        Cookie[] cookies = request.getCookies();

        User user;
        String username = "";
        String password = "";
        
        for (Cookie cookie : cookies) 
        {
            if (cookie.getName().equals("username")) 
            {
                username = cookie.getValue();
            }
            if (cookie.getName().equals("password")) 
            {
                password = cookie.getValue();
            }
        }
        
        user = userDao.checkLoginUser(username, password);
        return user;
    }

    private void executeLogin(HttpServletRequest request, HttpServletResponse response, User user) throws IOException {
        
        HttpSession session = request.getSession();
        
        session.setAttribute("id", user.getId());
        session.setAttribute("name", user.getName());
        session.setAttribute("user", user);
        
        response.sendRedirect("user-home-page.jsp"); // ganti ganti
    }

    private void checkLoginUserFirstTime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	// Check status is typed wrong input or not.
        String status="";
        if (request.getParameter("status") != null) 
        {
            status = request.getParameter("status");
        }
        
        // Get the submitted username and password.
        String username = request.getParameter("username");
        String password = request.getParameter("password");
       

        // Check user in database.
        User user = userDao.checkLoginUser(username, password);
        if (user == null && status.equals("typed")) 
        {
            // An alert to send to login page.
            String alert = "<div class=\"alert alert-danger wrap-input100\">\n" +
                    " <p style=\"font-family: Ubuntu-Bold; font-size: 18px; margin: 0.25em 0; text-align: center\">\n" +
                    " Wrong username or password!\n" +
                    " </p>\n" +
                    " </div>";
            
            // Set attribute for alert tag in loginpagepage.
            request.setAttribute("alert", alert);
            
            // Resend to login page.
            request.getRequestDispatcher("login-page.jsp").forward(request, response);
        
        }
        
        else if (user != null && username.equals("adminath") && password.equals("athadmin"))
        {
        	response.sendRedirect("Admin_View");
        }
        
        else 
        {
            // Login when all information are correct.
            HttpSession session = request.getSession(true);
            session.setAttribute("id", user.getId());
        	executeLogin(request, response, user);
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        User user = getUserCookie(request);
        if (user == null) 
        {
            // Check if user login first time or not.
            checkLoginUserFirstTime(request, response);
        } 
        else 
        {
            // Execute login if exist user cookie.
            executeLogin(request, response, user);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        service(request, response);
    }
}