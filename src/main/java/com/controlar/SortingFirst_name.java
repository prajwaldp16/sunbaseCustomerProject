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

@WebServlet("/SortingFirst_name")
public class SortingFirst_name extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sortBy = request.getParameter("first_name"); // Assuming the parameter is named "first_name"

        CustomerDaoImp dao = new CustomerDaoImp();
        List<Customer> sortedCustomerList = dao.getAllCustomerSort(sortBy);

        request.setAttribute("customerList", sortedCustomerList);
        request.getRequestDispatcher("/customerList.jsp").forward(request, response);
    }
}
