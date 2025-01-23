package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;
import com.flipkart.utils.DBUtils;

public class GymOwnerDaoImpl implements GymOwnerDao {
	Connection connection = null;
	PreparedStatement statement = null;
	// Method to add a new gym
    public boolean addGym(GymCentre gymCenter) {
    	try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.INSERT_GYM);

			
			statement.setString(1,gymCenter.getName());
			statement.setString(2,gymCenter.getLocation());
			statement.setInt(3,0);
			statement.executeUpdate();
			statement.close();
			
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
        // Logic to add a gym
        System.out.println("Gym added: " + gymCenter.getName());
        return true; // Placeholder
    }

    // Method to update gym details
    public boolean updateGym(GymCentre gymCentre) {
        // Logic to update gym details
        System.out.println("Gym updated: " + gymCentre.getName());
        return true; // Placeholder
    }

    // Method to add a new slot to a gym
    public boolean addSlotToGym(int gymId, Slot slot) {
        // Logic to add slot
    	try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.INSERT_SLOT);
			
			statement.setInt(1,gymId);
			statement.setInt(2,slot.getSlotId());
			statement.setString(3,slot.getStartTime());
			statement.setString(4,slot.getEndTime());
			statement.setInt(5,slot.getSeats());
			statement.setInt(6,slot.getRemainingSeats());
			statement.executeUpdate();
			statement.close();
			
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }	
        System.out.println("Slot added to gym ID: " + gymId);
        return true; // Placeholder
    }

    // Method to retrieve all gyms for an owner
    public List<GymCentre> getGymsForOwner(int ownerId) {
        // Logic to fetch gyms
List<GymCentre> allGyms =  new ArrayList<>();
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.FETCH_GYMOWNER_ALL_GYMS);
			statement.setString(1,gymownerId());
		    ResultSet rs = statement.executeQuery();
			
		    while (rs.next()) {
		    	GymCentre gym = new GymCentre();
				gym.setId(rs.getInt("id"));
				gym.setName(rs.getString("name"));
				gym.setLocation(rs.getString("location"));
				gym.setNoOfSeats(rs.getInt("noOfSeats"));
				gym.setGymOwnerEmail(rs.getString("gymOwnerEmail"));
				gym.setApproved(rs.getBoolean("isApproved"));
				allGyms.add(gym);
			}
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		
		return allGyms;
         // Placeholder
    }
}
