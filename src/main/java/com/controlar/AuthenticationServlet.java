package com.controlar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dao.UserDaoImp;
import com.fasterxml.jackson.databind.ser.AnyGetterWriter;
import com.modules.User;

@WebServlet("/authenticate")
public class AuthenticationServlet extends HttpServlet {

    private UserDao userDao = new UserDaoImp(); // Instantiate your UserDao

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate username and password against the database
        User user = userDao.getUser(username, password);

        if (user != null) {
            // Authentication successful, generate JWT
            String token = JwtUtil.generateToken(username);
            System.out.println(token);
            // Create a session and store user information
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            session.setAttribute("message", "Login successful");
            	
            	response.sendRedirect("GetAll"); // Redirect to customer list page
				
				
			
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            try {
            	response.sendRedirect("alogin.jsp");
            	
			} catch (java.io.IOException e) {
				e.printStackTrace();
			}
        }
    }
}
