package com.controlar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CustomerList {

    public static void main(String[] args) {
        // Specify the customer list endpoint URL
        String customerListUrl = "https://qa.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list";
        
        // Specify the bearer token received from the authentication API call
        String bearerToken = "dGVzdEBzdW5iYXNlZGF0YS5jb206VGVzdEAxMjM=";
        
        try {
            // Create a URL object from the customer list endpoint URL
            URL url = new URL(customerListUrl);
            
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set the request method to GET
            connection.setRequestMethod("GET");
            
            // Set the authorization header with the bearer token
            connection.setRequestProperty("Authorization", "Bearer " + bearerToken);
            
            // Get the response code from the connection
            int responseCode = connection.getResponseCode();
            
            // Check if the response code indicates success (200 OK)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response from the connection input stream
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                
                // Print the response (which should contain the customer list)
                System.out.println("Customer list:");
                System.out.println(response.toString());
            } else {
                // Print an error message if fetching the customer list fails
                System.out.println("Failed to fetch customer list. Response code: " + responseCode);
            }
        } catch (Exception e) {
            // Print any exceptions that occur during the process
            e.printStackTrace();
        }
    }
}