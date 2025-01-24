package com.flipkart.business;

import com.flipkart.bean.User;
import com.flipkart.dao.UserAuthDaoImpl;

public class UserAuthService {
	
	UserAuthDaoImpl userAuthDao = new UserAuthDaoImpl();
	
    // Method to register a new user
    public boolean registerUser(User user, int num) {
        return userAuthDao.registerUser(user, num);
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
