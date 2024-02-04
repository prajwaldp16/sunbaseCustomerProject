package com.controlar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dao.UserDaoImp;
import com.modules.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao = new UserDaoImp();
        User user = userDao.getUser(username, password);

        if (user != null) {
            // Valid user, create a session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("GetAll"); // Redirect to customer list page
        } else {
            // Invalid credentials, redirect back to login page with an error message
            response.sendRedirect("login.jsp?error=1");
        }
    }
}