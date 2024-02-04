package com.controlar;

// SecuredResourceServlet.java
import java.io.IOException;

import javax.annotation.security.RolesAllowed;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/securedResource")
@RolesAllowed("USER")
public class SecuredResourceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("This is a secured resource. Only authenticated users can access it.");
        response.getWriter().flush();
    }
}
