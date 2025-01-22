package com.flipkart.dao;

import com.flipkart.bean.User;

public class UserAuthDao {
	// Method to register a new user
    public boolean registerUser(User user) {
        // Logic to register a user
        System.out.println("Registering user: " + user.getName());
        return true; // Placeholder
    }

    // Method to validate user login
    public boolean validateLogin(String emailId, String password) {
        // Logic to validate user credentials
        System.out.println("Validating login for: " + emailId);
        return true; // Placeholder
    }
}
