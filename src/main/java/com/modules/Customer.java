package com.modules;

public class Customer {
	private int id;
	private String first_name;
	private String last_name;
	private String street;
	private String address;
	private String city;
	private String state;
	private String email;
	private long phone;
	
	/**
	 * @param id
	 * @param first_name
	 * @param last_name
	 * @param street
	 * @param address
	 * @param city
	 * @param state
	 * @param email
	 * @param phone
	 */
	public Customer(String first_name, String last_name, String street, String address, String city,
			String state, String email, long phone) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.street = street;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.phone = phone;
	}

	public Customer(int id,String first_name, String last_name, String street, String address, String city,
			String state, String email, long phone) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.street = street;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.phone = phone;
	}
	
	
	
	

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id ;
	}
	public void setId(int id) {
		this.id = id;
		
	}


	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	
	
	
	
	
		
}
