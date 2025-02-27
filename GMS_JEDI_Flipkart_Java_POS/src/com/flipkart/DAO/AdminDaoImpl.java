package com.flipkart.DAO;

import java.sql.*;
import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.constant.SQLQueries;
import com.flipkart.utils.*;

public class AdminDaoImpl implements AdminDao{
    Connection connection = null;
    PreparedStatement statement = null;

    public List<GymCenter> viewPendingGymRequests(){
        List<GymCenter> pendingReq = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();
            System.out.println("Getting Pending Requests...");
            statement = connection.prepareStatement(SQLQueries.FETCH_PENDING_GYM_CENTERS);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                GymCenter gymCenter = new GymCenter();
                gymCenter.setId(rs.getInt("id"));
                gymCenter.setName(rs.getString("name"));
                gymCenter.setGymOwnerEmail(rs.getString("gymOwnerEmail"));
                gymCenter.setLocation(rs.getString("location"));
                gymCenter.setNoOfSeats(rs.getInt("noOfSeats"));
                gymCenter.setApproved(false);
                pendingReq.add(gymCenter);
            }
        } catch (SQLException sqlExcep){
            System.out.println(sqlExcep);
        } catch (Exception excep){
            excep.printStackTrace();
        }
        return pendingReq;
    }

    public List<GymOwner> viewPendingGymOwnerRequests(){
        List<GymOwner> pendingGymOwnerReq = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();
            System.out.println("Getting Pending Gym Owner Requests...");
            statement = connection.prepareStatement(SQLQueries.FETCH_PENDING_OR_APPROVED_GYM_OWNERS);
            statement.setString(1,"0");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                GymOwner gymOwner = new GymOwner();
                gymOwner.setId(rs.getInt("id"));
                gymOwner.setAddress(rs.getString("address"));
                gymOwner.setApproved(false);
                gymOwner.setPhone(rs.getInt("phone"));
                gymOwner.setGstNumber(rs.getString("gstNumber"));
                gymOwner.setName(rs.getString("name"));
                gymOwner.setEmail(rs.getString("email"));

                pendingGymOwnerReq.add(gymOwner);
            }
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }
        return pendingGymOwnerReq;
    }

    public List<GymCenter> viewAllApprovedGyms(){
        List<GymCenter> approvedReq = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();
            System.out.println("Getting Approved Requests...");
            statement = connection.prepareStatement(SQLQueries.FETCH_ALL_APPROVED_GYMS);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                GymCenter gymCenter = new GymCenter();
                gymCenter.setId(rs.getInt("id"));
                gymCenter.setName(rs.getString("name"));
                gymCenter.setGymOwnerEmail(rs.getString("gymOwnerEmail"));
                gymCenter.setLocation(rs.getString("location"));
                gymCenter.setNoOfSeats(rs.getInt("noOfSeats"));
                gymCenter.setApproved(true);
                approvedReq.add(gymCenter);
            }
        } catch (SQLException sqlExcep){
            System.out.println(sqlExcep);
        } catch (Exception excep){
            excep.printStackTrace();
        }
        return approvedReq;
    }

    public List<GymOwner> viewAllApprovedGymOnwers(){
        List<GymOwner> approvedGymOwnerReq = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();
            System.out.println("Getting Approved Gym Owner Requests...");
            statement = connection.prepareStatement(SQLQueries.FETCH_PENDING_OR_APPROVED_GYM_OWNERS);
            statement.setString(1,"1");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                GymOwner gymOwner = new GymOwner();
                gymOwner.setId(rs.getInt("id"));
                gymOwner.setAddress(rs.getString("address"));
                gymOwner.setApproved(true);
                gymOwner.setPhone(rs.getInt("phone"));
                gymOwner.setGstNumber(rs.getString("gstNumber"));
                gymOwner.setName(rs.getString("name"));
                gymOwner.setEmail(rs.getString("email"));

                approvedGymOwnerReq.add(gymOwner);
            }
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }
        return approvedGymOwnerReq;
    }

    public int approveGymOwnerRegistration(int gymOwnerId) {
        int result = 0;
        try {
            connection = DBUtils.getConnection();
            System.out.println("Approving Gym Owner Requests...");

            // First, check if the gym owner is already approved
            String checkQuery = "SELECT isApproved FROM GymOwner WHERE id = ?";
            statement = connection.prepareStatement(checkQuery);
            statement.setInt(1, gymOwnerId);
            ResultSet resultSet = statement.executeQuery();
            int flag = 0;
            if (resultSet.next()) {
                boolean isApproved = resultSet.getBoolean("isApproved");

                if (isApproved) {
                    // If already approved, print message and return false
                    System.out.println("Gym Owner already approved");
                    flag = 1;
                    result = 2;
                    
                }
            }
            
            // If not approved, proceed with approval
            if(flag == 0) {
            	statement = connection.prepareStatement(SQLQueries.APPROVE_GYM_OWNER);
                statement.setInt(1, gymOwnerId);
                result = statement.executeUpdate();
                statement.close();
            }
            

        } catch (SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch (Exception excep) {
            excep.printStackTrace();
        }

        // Return true if the update was successful
        return result;
    }


    public boolean approveGymRegistration(int gymCenterId){
        int result = 0;
        try{
            connection = DBUtils.getConnection();
            System.out.println("Approving Gym Center Requests...");
            statement = connection.prepareStatement(SQLQueries.APPROVE_GYM_CENTER);
            statement.setInt(1,gymCenterId);
            result = statement.executeUpdate();
            statement.close();
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }
        if(result == 1){
            return true;
        }
        return false;
    }
}
