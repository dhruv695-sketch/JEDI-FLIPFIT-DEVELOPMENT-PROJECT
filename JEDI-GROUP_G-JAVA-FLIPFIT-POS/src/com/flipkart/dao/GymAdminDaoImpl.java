package com.flipkart.dao;

import java.sql.*;
import java.util.*;
import com.flipkart.constant.SQLQueries;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;


public class GymAdminDaoImpl implements GymAdminDao {
    public boolean verifyGymOwner(GymOwner gymOwner) {
        System.out.println("Verifying gym owner: " + gymOwner.getName());
        return true; // Placeholder
    }

    public boolean verifyGym(GymCentre gymCentre) {
        System.out.println("Verifying gym: " + gymCentre.getName());
        return true; // Placeholder
    }

    public List<GymCentre> getPendingGymVerifications() {
        List<GymCentre> pendingReq = new ArrayList<>();
        // implement MySql connection
        System.out.println("Pending gym verifications :  " );
        try{
            statement = connection.prepareStatement(SQLQueries.FETCH_PENDING_GYM_CENTERS);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                GymCentre gymCenter = new GymCenter();
                gymCenter.setGymId(rs.getInt("GymId"));
                gymCenter.setName(rs.getString("GymName"));
                gymCenter.setLocation(rs.getString("GymLocation"));
                pendingReq.add(gymCenter);
            }
        }
        catch() {
        	
        }
        return null; // Placeholder
    }

    public List<GymOwner> getPendingGymOwnerVerifications() {
        System.out.println("Pending gym owner verifications :  ");
        List<GymOwner> pendingReq = new ArrayList<>();
        // implement MySql connection
        try{
            statement = connection.prepareStatement(SQLQueries.FETCH_PENDING_GYM_CENTERS);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                GymOwner gymOwner = new GymOwner();
                gymOwner.setGymOwnerId(rs.getInt("GymOwnerId"));
                pendingReq.add(gymOwner);
            }
        }
        catch() {
        	
        }

        return null; // Placeholder
    }

    public List<Customer> getAllCustomers() {
        return null; // Placeholder
    }
}
