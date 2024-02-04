package com.dao;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.modules.Customer;



public class CustomerDaoImp  implements CustomerDao{
	
	private static final String url = "jdbc:mysql://localhost:3306/customer";
	private static final String username = "root";
	private static final String password = "root";
	Connection connection = null;
	PreparedStatement statement = null;
	static final String INSERT_QUERY = "INSERT INTO customer_info "
			+ "(first_name,last_name,street,address,city,state,email,phone) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	static final String DELETE_QUERY ="DELETE FROM customer_info WHERE id = ?;";
	
	static final String EDIT_QUERY = "UPDATE `customer_info` SET `first_name` = ?, `last_name` = ?, `street` = ?, "
	        + "`address` = ?, `city` = ?, `state` = ?, `email` = ?, `phone` = ? WHERE `id` = ?";
	static final String GETBYID = "select * from `customer_info` where `id` = ?";
	
//	constructor
	public CustomerDaoImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	
	@Override
	public int addCustomer(Customer c) {
		try {
			statement = connection.prepareStatement(INSERT_QUERY);
			
			statement.setString(1,c.getFirst_name());
			statement.setString(2,c.getLast_name());
			statement.setString(3,c.getStreet());
			statement.setString(4,c.getAddress());
			statement.setString(5,c.getCity());
			statement.setString(6,c.getState());
			statement.setString(7,c.getEmail());
			statement.setLong(8,c.getPhone());
			
			int i = statement.executeUpdate();
			return i ;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	

	
	
	
	
	@Override
		public  int updateCustomer(Customer c) {
		    try {
		        statement = connection.prepareStatement(EDIT_QUERY);

		        // Set the values for the columns in the SET clause
		        statement.setString(1, c.getFirst_name());
		        statement.setString(2, c.getLast_name());
		        statement.setString(3, c.getStreet());
		        statement.setString(4, c.getAddress());
		        statement.setString(5, c.getCity());
		        statement.setString(6, c.getState());
		        statement.setString(7, c.getEmail());
		        statement.setLong(8, c.getPhone());

		        // Set the value for the WHERE clause (customer ID)
		        statement.setInt(9, c.getId()); // Assuming getId() returns the customer ID

		        int i = statement.executeUpdate();
		        return i;

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return 0;
		}
		

	
	@Override
	public List<Customer> getAllCustomer() {
		 String SELECT_ALL_QUERY = "SELECT * FROM customer_info";
	        List<Customer> cl = new ArrayList<>();

	        try {
	            statement = connection.prepareStatement(SELECT_ALL_QUERY);
	            ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	            	int id = resultSet.getInt("id");
	            	String first_name = resultSet.getString("first_name");
	            	String last_name = resultSet.getString("last_name");
	            	String street = resultSet.getString("street");
	            	String address = resultSet.getString("address");
	            	String city = resultSet.getString("city");
	            	String state = resultSet.getString("state");
	            	String email = resultSet.getString("email"
	            			);
	                long phone = resultSet.getLong("phone");

	                cl.add(new Customer(id,first_name, last_name, street, address, city, state, email, phone));
	                
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }


		return cl;
	}
	
	

	@Override
	public List<Customer> getAllCustomerSort(String sortBy) {
	    String SELECT_ALL_QUERY = "SELECT * FROM customer_info ORDER BY " + sortBy;
	    List<Customer> cl = new ArrayList<>();

	    try {
	        statement = connection.prepareStatement(SELECT_ALL_QUERY);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String first_name = resultSet.getString("first_name");
	            String last_name = resultSet.getString("last_name");
	            String street = resultSet.getString("street");
	            String address = resultSet.getString("address");
	            String city = resultSet.getString("city");
	            String state = resultSet.getString("state");
	            String email = resultSet.getString("email");
	            long phone = resultSet.getLong("phone");

	            cl.add(new Customer(id, first_name, last_name, street, address, city, state, email, phone));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return cl;
	}


	
	@Override
	public List<Customer> getAllCustomerSortId(String sortBy) {
	    String SELECT_ALL_QUERY = "SELECT * FROM customer_info ORDER BY " + sortBy + " DESC";
	    List<Customer> cl = new ArrayList<>();

	    try {
	        statement = connection.prepareStatement(SELECT_ALL_QUERY);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String first_name = resultSet.getString("first_name");
	            String last_name = resultSet.getString("last_name");
	            String street = resultSet.getString("street");
	            String address = resultSet.getString("address");
	            String city = resultSet.getString("city");
	            String state = resultSet.getString("state");
	            String email = resultSet.getString("email");
	            long phone = resultSet.getLong("phone");

	            cl.add(new Customer(id, first_name, last_name, street, address, city, state, email, phone));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return cl;
	}

	
	
	
	@Override
	public Customer getCustomerById(int cid) {
		try {
			statement = connection.prepareStatement(GETBYID);
			statement.setInt(1, cid);
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				
				int id = resultSet.getInt("id");
	            String first_name = resultSet.getString("first_name");
	            String last_name = resultSet.getString("last_name");
	            String street = resultSet.getString("street");
	            String address = resultSet.getString("address");
	            String city = resultSet.getString("city");
	            String state = resultSet.getString("state");
	            String email = resultSet.getString("email");
	            long phone = resultSet.getLong("phone");

	            return new Customer(id, first_name, last_name, street, address, city, state, email, phone);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public int deleteCustomer(int id) {
		
		try {
			PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
			statement.setInt(1, id);
			
			int i = statement.executeUpdate();
			
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public List<Customer> searchCustomers(String searchCriteria, String searchTerm) {
	    List<Customer> searchResults = new ArrayList<>();

	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        String query = "SELECT * FROM customer_info WHERE " + getSearchCondition(searchCriteria);

	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            // Set the search term for the prepared statement
	            statement.setString(1, "%" + searchTerm + "%");

	            try (ResultSet resultSet = statement.executeQuery()) {
	                while (resultSet.next()) {
	                    Customer customer = new Customer();
	                    
	                    customer.setId(resultSet.getInt("id"));
	                    customer.setFirst_name(resultSet.getString("first_name"));
	                    customer.setLast_name(resultSet.getString("last_name"));
	                    customer.setStreet(resultSet.getString("street"));
	                    customer.setAddress(resultSet.getString("address"));
	                    customer.setCity(resultSet.getString("city"));
	                    customer.setState(resultSet.getString("state"));
	                    customer.setEmail(resultSet.getString("email"));
	                    // Corrected the phone parsing
	                    String phoneString = resultSet.getString("phone");
	                    long phone = phoneString != null ? Long.parseLong(phoneString) : 0;
	                    customer.setPhone(phone);

	                    searchResults.add(customer);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return searchResults;
	}

	private String getSearchCondition(String searchCriteria) {
	    switch (searchCriteria) {
	        case "firstName":
	            return "first_name LIKE ?";
	        case "lastName":
	            return "last_name LIKE ?";
	        case "city":
	            return "city LIKE ?";
	        // Add more cases for other search criteria if needed
	        default:
	            throw new IllegalArgumentException("Invalid search criteria: " + searchCriteria);
	    }
	}


	
	}
	


