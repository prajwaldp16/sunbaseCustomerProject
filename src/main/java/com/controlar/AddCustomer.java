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
import com.modules.Customer;

@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String street = req.getParameter("street");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String email = req.getParameter("email");
        long phone = Long.parseLong(req.getParameter("phone"));

        Customer c = new Customer(first_name, last_name, street, address, city, state, email, phone);
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();

        if (session.getAttribute("user") == null) {
            // User is not logged in, redirect to login page
            resp.sendRedirect("alogin.jsp?error=2");
            return; // Stop further execution
        } else {
            try {
                CustomerDaoImp cdi = new CustomerDaoImp();
                int i = cdi.addCustomer(c);

                if (i > 0) {
                    // Customer added successfully
                    session.setAttribute("message", "Customer added successfully!");
                } else {
                    // Failed to add customer
                	session.setAttribute("error", "Failed to add customer. Please try again.");
                }
                // Redirect to customer.jsp
                req.getRequestDispatcher("GetAll").forward(req, resp);

            } catch (Exception e) {
                // Handle exceptions
                e.printStackTrace();
                out.println("<html><body><p>An error occurred while processing your request.</p></body></html>");
            }
        }
    }
}
