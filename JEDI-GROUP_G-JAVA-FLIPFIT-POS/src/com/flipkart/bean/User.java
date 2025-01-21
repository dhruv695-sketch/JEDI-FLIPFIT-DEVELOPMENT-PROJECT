package com.flipkart.bean;

public class User {
	private String userId;
    private String name;
    private String emailId;
    private String password;
    
    public User(String name,  String emailId, String password) {
    	this.name = name;
    	this.emailId = emailId;
    	this.password = password;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
