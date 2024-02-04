	// UserDaoImp.java
	package com.dao;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	
	import com.modules.User;
	
	public class UserDaoImp implements UserDao {
	
	    private static final String url = "jdbc:mysql://localhost:3306/customer";
	    private static final String username = "root";
	    private static final String password = "root";
	    private Connection connection = null;
	    private PreparedStatement statement = null;
	
	    public UserDaoImp() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(url, username, password);
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	    @Override
	    public User getUser(String username, String password) {
	        User user = null;
	        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
	
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, username);
	            statement.setString(2, password);
	
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    // User found, create a User object
	                    user = new User();
	                    user.setUsername(resultSet.getString("username"));
	                    user.setPassword(resultSet.getString("password"));
	                    
	                    
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	
	        return user;
	    }
	    
	}
