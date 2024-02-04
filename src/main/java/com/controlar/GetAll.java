package com.controlar;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CustomerDaoImp;
import com.modules.Customer;

/**
 * Servlet implementation class GetAll
 */
@WebServlet("/GetAll")
public class GetAll extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final int RECORDS_PER_PAGE = 4;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerDaoImp dai = new CustomerDaoImp();

        // Get current page number from the request parameter
        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        List<Customer> customerList = dai.getAllCustomer();

        // Calculate the total number of pages
        int totalRecords = customerList.size();
        int totalPages = (int) Math.ceil((double) totalRecords / RECORDS_PER_PAGE);

        // Calculate the starting record index for the current page
        int startIndex = (page - 1) * RECORDS_PER_PAGE;

        // Get a sublist of customers for the current page
        List<Customer> currentPageList = customerList.subList(startIndex, Math.min(startIndex + RECORDS_PER_PAGE, totalRecords));

        // Set attributes in request
        request.setAttribute("customerList", currentPageList);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", page);

        // Forward the request to the JSP page for displaying customers with pagination
        request.getRequestDispatcher("/customerList.jsp").forward(request, response);
    }
}
