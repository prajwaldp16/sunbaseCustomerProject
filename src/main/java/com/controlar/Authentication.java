package com.controlar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Authentication {

    public static void main(String[] args) {
        // Specify the authentication endpoint URL
        String authUrl = "https://qa.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp";
        
        // Specify the login credentials
        String loginId = "test@sunbasedata.com";
        String password = "Test@123";
        
        try {
            // Create a URL object from the authentication endpoint URL
            URL url = new URL(authUrl);
            
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set the request method to POST
            connection.setRequestMethod("POST");
            
            // Set the request content type to JSON
            connection.setRequestProperty("Content-Type", "application/json");
            
            // Enable output for sending data in the request body
            connection.setDoOutput(true);
            
            // Create a JSON object for the request body
            String requestBody = "{\"login_id\":\"" + loginId + "\",\"password\":\"" + password + "\"}";
            
            // Get the output stream from the connection and write the request body to it
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(requestBody.getBytes());
            outputStream.flush();
            
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
                
                // Print the response (which should contain the bearer token)
                System.out.println("Authentication successful. Bearer token: " + response.toString());
            } else {
                // Print an error message if authentication fails
                System.out.println("Authentication failed. Response code: " + responseCode);
            }
        } catch (Exception e) {
            // Print any exceptions that occur during the authentication process
            e.printStackTrace();
        }
    }
}