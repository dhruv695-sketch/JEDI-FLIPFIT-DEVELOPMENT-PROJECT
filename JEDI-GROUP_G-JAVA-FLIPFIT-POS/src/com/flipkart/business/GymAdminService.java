package com.flipkart.business;

import com.flipkart.bean.GymOwner;
import com.flipkart.dao.GymAdminDaoImpl;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import java.util.List;

public class GymAdminService {
	
	GymAdminDaoImpl gymAdminDao = new GymAdminDaoImpl();
	
    // Method to verify a gym owner
    public boolean verifyGymOwner(GymOwner gymOwner) {
        return gymAdminDao.verifyGymOwner(gymOwner);
    }

    // Method to verify a gym
    public boolean verifyGym(GymCentre gymCentre) {
        return gymAdminDao.verifyGym(gymCentre);
    }

    // Method to retrieve pending verifications
    public List<GymCentre> getPendingGymVerifications() {
        return gymAdminDao.getPendingGymVerifications();
    }
    
    public List<GymOwner> getPendingGymOwnerVerifications() {
        return gymAdminDao.getPendingGymOwnerVerifications();
    }
    
    // Method to retrieve all customers
    public List<Customer> getAllCustomers() {
        return gymAdminDao.getAllCustomers();
    }
    
}
