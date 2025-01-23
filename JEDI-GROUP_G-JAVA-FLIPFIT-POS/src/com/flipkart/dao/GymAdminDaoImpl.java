package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.flipkart.constant.SQLQueries;
import com.flipkart.utils.DBUtils;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.GymOwner;


public class GymAdminDaoImpl implements GymAdminDao {
	Connection connection = null;
	PreparedStatement statement = null;
    public boolean verifyGymOwner(GymOwner gymOwner) {
        System.out.println("Verifying gym owner: " + gymOwner.getUserName());
        return true; // Placeholder
    }

    public boolean verifyGym(GymCentre gymCentre) {
        System.out.println("Verifying gym: " + gymCentre.getName());
        return true; // Placeholder
    }

    public List<GymCentre> getPendingGymVerifications() {
    	List<GymCentre> pendingReq = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();
            System.out.println("Getting Pending Requests...");
            statement = connection.prepareStatement(SQLQueries.FETCH_PENDING_GYMS);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                GymCentre gymCenter = new GymCentre(rs.getString("name"));
                gymCenter.setGymId(rs.getInt("id"));
                gymCenter.setName(rs.getString("name"));
                gymCenter.setLocation(rs.getString("location"));
                gymCenter.setisApproved(false);
                pendingReq.add(gymCenter);
            }
        } catch (SQLException sqlExcep){
            System.out.println(sqlExcep);
        } catch (Exception excep){
            excep.printStackTrace();
        }
        return pendingReq;
    }
    }

    public List<GymOwner> getPendingGymOwnerVerifications() {
    	List<GymOwner> pendingGymOwnerReq = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();
            System.out.println("Getting Pending Gym Owner Requests...");
            statement = connection.prepareStatement(SQLQueries.FETCH_PENDING_GYM_OWNERS);
            statement.setString(1,"0");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                GymOwner gymOwner = new GymOwner();
                gymOwner.setUserId(rs.getInt("id"));
                gymOwner.setisApproved(false);
                gymOwner.setUserName(rs.getString("name"));
                gymOwner.setUserEmail(rs.getString("email"));

                pendingGymOwnerReq.add(gymOwner);
            }
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }
        return pendingGymOwnerReq;
    }

    public List<Customer> getAllCustomers() {
        return null; // Placeholder
    }
}
