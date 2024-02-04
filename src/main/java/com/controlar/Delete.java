package com.controlar;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDaoImp;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	// Retrieve the customer ID from the request
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	
        // Check if the user is logged in
        HttpSession session = request.getSession();
        
        if (session.getAttribute("user") == null) {
            // User is not logged in, redirect to login page
            response.sendRedirect("alogin.jsp?error=2"); // Use a different error code to indicate unauthorized access
            return; // Stop further execution
        }else {
        	

        // Perform the delete operation using your DAO or service class
        CustomerDaoImp dao = new CustomerDaoImp();
        int result = dao.deleteCustomer(id);

        if (result > 0) {
            // Customer deleted successfully
            request.setAttribute("message", "Customer deleted successfully");
        } else {
            // Failed to delete customer
            request.setAttribute("error", "Failed to delete customer");
        }
        // Redirect to customer.jsp
        request.getRequestDispatcher("GetAll").forward(request, response);
       }
    }
}
