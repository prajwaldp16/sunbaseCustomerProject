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

@WebServlet("/SortingId")
public class SortingId extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sortBy = request.getParameter("id"); 

        CustomerDaoImp dao = new CustomerDaoImp();
        List<Customer> sortedCustomerList = dao.getAllCustomerSort(sortBy);

        request.setAttribute("customerList", sortedCustomerList);
        request.getRequestDispatcher("/customerList.jsp").forward(request, response);
    }
}
