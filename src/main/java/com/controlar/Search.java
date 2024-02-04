package com.controlar;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImp;
import com.modules.Customer;

@WebServlet("/Search")
public class Search extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchCriteria = request.getParameter("searchCriteria");
        String searchTerm = request.getParameter("searchTerm");
       
        // Call the DAO to perform the search based on the criteria and term
        CustomerDao customerDao = new CustomerDaoImp();
        List<Customer> searchResults;

        // If both criteria are provided, perform a combined search
        if (searchCriteria != null && searchTerm != null) {
            searchResults = customerDao.searchCustomers(searchCriteria, searchTerm);
        } else {
            // Handle the case where either criteria is not provided
            searchResults = Collections.emptyList();
        }

        // Set the search results in the request attribute
        request.setAttribute("customerList", searchResults);

        // Forward the request to the CustomerList.jsp to display the search results
        request.getRequestDispatcher("customerList.jsp").forward(request, response);
    }
}
