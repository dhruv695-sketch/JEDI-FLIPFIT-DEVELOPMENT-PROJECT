/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.User;

/**
 * 
 */
public interface UserAuthDao {
    public boolean registerUser(User user, int num);

    // Method to validate user login
    public boolean validateLogin(String emailId, String password);
    

}
