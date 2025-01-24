package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.bean.User;

public class UserAuthDaoImpl implements UserAuthDao{
	// Method to register a new user
	
//    public boolean registerUser(User user) {
//        // Logic to register a user
//        System.out.println("Registering user: " + user.getName());
//        return true; // Placeholder
//    }
	private Connection getConnection() throws SQLException {
        // Replace with your actual DB credentials and URL
        String url = "jdbc:mysql://localhost:3306/FlipFit_Schema";
        String username = "root";
        String password = "adminadmin"; 
        return DriverManager.getConnection(url, username, password);
    }
    
    public boolean registerUser(User user, int num) {
        String query = "INSERT INTO User (userName, userEmail, userPassword, userRoleId) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {

//            stmt.setInt(1, num);
            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getUserEmail());
            stmt.setString(3, user.getUserPassword());
            stmt.setInt(4, user.getUserRoleId());
//            stmt.setString(4, user.getPassword());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User registered successfully: " + user.getUserName());
                return true;
            } else {
                System.out.println("User registration failed.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error while registering user: " + e.getMessage());
            return false;
        }
    }

    // Method to validate user login
//    public boolean validateLogin(String emailId, String password) {
//        // Logic to validate user credentials
//        System.out.println("Validating login for: " + emailId);
//        return true; // Placeholder
//    }
    
    public boolean validateLogin(String emailId, String password) {
        String query = "SELECT * FROM User WHERE userEmail = ? AND userPassword = ?";
        try (Connection conn = getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, emailId);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // If a record is found, the login is valid
                System.out.println("Login successful for: " + emailId);
                return true;
            } else {
                System.out.println("Invalid login attempt for: " + emailId);
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error while validating login: " + e.getMessage());
            return false;
        }
    }



}
