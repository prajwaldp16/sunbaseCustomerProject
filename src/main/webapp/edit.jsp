<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.dao.CustomerDaoImp, com.modules.Customer" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Customer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .box-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 50%;
            margin-top: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }

        input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-columns {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }

        .form-column {
            width: 48%;
        }

        button {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            background-color: #3498db;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <% 
        int cid = Integer.parseInt(request.getParameter("cid"));
        CustomerDaoImp cimpl = new CustomerDaoImp();
        Customer customer = cimpl.getCustomerById(cid);
    %>

    <div class="box-container">
        <h2>Edit Customer</h2>
        <form action="EditCustomer" method="post">
            <!-- Hidden input to store the customer ID -->
            <input type="hidden" name="id" value="<%= customer.getId() %>" />

            <!-- Form fields -->
            <div class="form-columns">
                <div class="form-column">
                    <div class="form-group">
                        <label for="first_name">First Name:</label>
                        <input type="text" id="first_name" name="first_name" value="<%= customer.getFirst_name() %>" required>
                    </div>

                    <div class="form-group">
                        <label for="last_name">Last Name:</label>
                        <input type="text" id="last_name" name="last_name" value="<%= customer.getLast_name() %>" required>
                    </div>
                </div>

                <div class="form-column">
                    <div class="form-group">
                        <label for="street">Street:</label>
                        <input type="text" id="street" name="street" value="<%= customer.getStreet() %>" required>
                    </div>

                    <div class="form-group">
                        <label for="address">Address:</label>
                        <input type="text" id="address" name="address" value="<%= customer.getAddress() %>" required>
                    </div>
                </div>
            </div>

            <div class="form-columns">
                <div class="form-column">
                    <div class="form-group">
                        <label for="city">City:</label>
                        <input type="text" id="city" name="city" value="<%= customer.getCity() %>" required>
                    </div>

                    <div class="form-group">
                        <label for="state">State:</label>
                        <input type="text" id="state" name="state" value="<%= customer.getState() %>" required>
                    </div>
                </div>

                <div class="form-column">
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" value="<%= customer.getEmail() %>" required>
                    </div>

                    <div class="form-group">
                        <label for="phone">Phone:</label>
                        <input type="tel" id="phone" name="phone" value="<%= customer.getPhone() %>" required>
                    </div>
                </div>
            </div>

            <button type="submit">Edit Customer</button>
        </form>
    </div>
</body>
</html>
