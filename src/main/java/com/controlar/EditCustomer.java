package com.controlar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDaoImp;
import com.modules.Customer;

@WebServlet("/EditCustomer")
public class EditCustomer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        int id = Integer.parseInt(request.getParameter("id"));
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String street = request.getParameter("street");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String email = request.getParameter("email");
        long phone = Long.parseLong(request.getParameter("phone"));

        // Check if the user is logged in
        HttpSession session = request.getSession();
        
        if (session.getAttribute("user") == null) {
            // User is not logged in, redirect to login page
            response.sendRedirect("alogin.jsp?error=2"); // Use a different error code to indicate unauthorized access
            return; // Stop further execution
        }else {
        	
        
        
        // Create a Customer object with the updated values
        Customer up = new Customer(id, first_name, last_name, street, address, city, state, email, phone);

        // Use your DAO to update the customer
        CustomerDaoImp dao = new CustomerDaoImp();
        int i = dao.updateCustomer(up);
    
        if (i > 0) {
            // Customer updated successfully
        	session.setAttribute("message", "Customer updated successfully");
        } else {
            // Failed to update customer
        	session.setAttribute("error", "Failed to update customer");
        }
        // Redirect back to the customer list page after update
        response.sendRedirect(request.getContextPath() + "/GetAll");
    }
}

}