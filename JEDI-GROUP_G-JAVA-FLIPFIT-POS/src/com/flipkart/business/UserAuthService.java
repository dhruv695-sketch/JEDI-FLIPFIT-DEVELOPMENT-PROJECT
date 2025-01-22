package com.flipkart.business;

import com.flipkart.bean.User;
import com.flipkart.dao.UserAuthDao;

public class UserAuthService {
	
	UserAuthDao userAuthDao = new UserAuthDao();
	
    // Method to register a new user
    public boolean registerUser(User user) {
        return userAuthDao.registerUser(user);
    }

    // Method to validate user login
    public boolean validateLogin(String emailId, String password) {
        return userAuthDao.validateLogin(emailId, password);
    }

   

//    // Method to retrieve all admins
//    public List<GymAdmin> getAllAdmins() {
//        // Logic to fetch all admins
//        return null; // Placeholder
//    }
}
