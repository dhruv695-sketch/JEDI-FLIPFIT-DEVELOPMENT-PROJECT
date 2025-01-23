/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.User;

/**
 * 
 */
public interface UserAuthDao {
    public boolean registerUser(User user);

    // Method to validate user login
    public boolean validateLogin(String emailId, String password);
    

}
