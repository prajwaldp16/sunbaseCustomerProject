package com.dao;

import java.util.List; 

import com.modules.Customer;

public interface CustomerDao {
	
	
	int addCustomer(Customer c);
	int deleteCustomer(int id);
	List<Customer> getAllCustomer();
	int updateCustomer(Customer customer);
	Customer getCustomerById(int id);
	
	 List<Customer> searchCustomers(String searchCriteria, String searchTerm);
	 List<Customer> getAllCustomerSort(String sortBy);
	 List<Customer> getAllCustomerSortId(String sortById);
	 
	
	
}
