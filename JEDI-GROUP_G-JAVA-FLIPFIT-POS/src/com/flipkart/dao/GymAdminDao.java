/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;

/**
 * 
 */
public interface GymAdminDao {
	   public boolean verifyGymOwner(GymOwner gymOwner);

	    // Method to verify a gym
	    public boolean verifyGym(GymCentre gymCentre);
	    // Method to retrieve pending verifications
	    public List<GymCentre> getPendingGymVerifications();
	    
	    public List<GymOwner> getPendingGymOwnerVerifications();
	    
	    // Method to retrieve all customers
	    public List<Customer> getAllCustomers();
	    
}
