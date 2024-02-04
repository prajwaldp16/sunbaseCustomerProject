<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" integrity="sha384-4LISF5TTJX/fLmGSxO53rV4miRxdg84mZsxmO8Rx5jGtp/LbrixFETvWa5a6sESd" crossorigin="anonymous">
    <link rel="stylesheet" href="assest/customerList.css">
    <!-- Add your CSS styles or link to an external stylesheet here -->
</head>

<body>
    <div class="header">
        <button class="button" onclick="location.href='addCustomer.html'">Add Customer</button>
	

        <h2>Welcome to the Customer List Page</h2>
        <a href="LogoutServlet" class="login-btn">Logout</a>
    </div>

    <h2>Customer List</h2>
    	<form action="SyncCustomers" method="post">
		    <!-- Sync Customers button -->
		    <button type="submit" class="login-btn sync">Sync Customers</button>
		</form>
    
       <%-- Display success message --%>
    <c:if test="${not empty message}">
        <div class="success-message" style="color: green; font-size: 18px;  font-weight: bold;">${message}</div>
    </c:if>	 
    
    <%-- Display error message --%>
    <c:if test="${not empty error}">
        <div class="error-message"  style="color:red; font-size: 18px;  font-weight: bold;">${error}</div>
    </c:if>
    

    <form action="Search" method="post">
        <label for="searchCriteria">Search By:</label>
        <select id="searchCriteria" name="searchCriteria">
            <option value="firstName">First Name</option>
            <option value="lastName">Last Name</option>
            <option value="city">City</option>
        </select>

        <label for="searchTerm">Search:</label>
        <input type="text" id="searchTerm" name="searchTerm">
        <button type="submit" class="login-btn">Submit</button>
    </form>

    <table>
        <thead>
            <tr>
                <th>
                    id
                    <form action="SortingId" method="post">
                        <input type="hidden" name="id" value="id" />
                        <button type="submit" class=""><i class="bi bi-sort-up"></i></button>
                    </form>
                </th>
                <th>
                    First Name
                    <form action="SortingFirst_name" method="post">
                        <input type="hidden" name="first_name" value="first_name" />
                        <button type="submit" class=""><i class="bi bi-sort-up"></i></button>
                    </form>
                </th>
                <th>Last Name</th>
                <th>Street</th>
                <th>Address</th>
                <th>City <i class="bi bi-sort-up"></i></th>
                <th>State</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Delete</th>
                <th>Edit</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${customerList}">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.first_name}</td>
                    <td>${customer.last_name}</td>
                    <td>${customer.street}</td>
                    <td>${customer.address}</td>
                    <td>${customer.city}</td>
                    <td>${customer.state}</td>
                    <td>${customer.email}</td>
                    <td><c:out value="${customer.phone}" /></td>
                    <td>
                        <form action="Delete" method="get">
                            <input type="hidden" name="id" value="${customer.id}" />
                            <button type="submit" class="button delete">Del</button>
                        </form>
                    </td>
                    <td>
                        <button class="button edit" onclick="window.location.href='edit.jsp?cid=${customer.id}'">Edit</button>

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<div class="pagination-container">
    <c:if test="${totalPages > 1}">
        <span>Page ${currentPage} of ${totalPages}</span>
        <c:forEach begin="1" end="${totalPages}" var="i">
            <c:url value="GetAll" var="url">
                <c:param name="page" value="${i}" />
            </c:url>
            <a href="${url}">${i}</a>
        </c:forEach>
    </c:if>
</div>




</body>

</html>
