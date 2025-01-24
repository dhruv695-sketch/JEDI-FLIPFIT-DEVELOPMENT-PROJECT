package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;
import com.flipkart.constant.SQLQueries;
import com.flipkart.utils.DBUtils;

public class GymOwnerDaoImpl implements GymOwnerDao {
	Connection connection = null;
	PreparedStatement statement = null;

	// Method to add a new gym
	public boolean addGym(GymCentre gymCenter) {
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.INSERT_GYM);

			// TODO: GymId should be auto incremented

			statement.setString(2, gymCenter.getName());
			statement.setString(3, gymCenter.getLocation());

			// TODO: Add current gym to gym owner's list

			statement.executeUpdate();
			statement.close();
		} catch (SQLException sqlExcep) {
			System.out.println(sqlExcep);
		} catch (Exception excep) {
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

			// TODO: SlotId auto incremented

			DateFormat dateFormat = slot.getSlotDateTime();
			// TODO: Fix hard coded date time string
			String dateString = "2025-01-23 14:30:00";  // Replace with the actual string if needed
			try {
			    Date parsedDate = dateFormat.parse(dateString);
			    Timestamp timestamp = new Timestamp(parsedDate.getTime());
			    statement.setTimestamp(2, timestamp);
			} 
			catch (ParseException e) {
			    e.printStackTrace();
			}


			statement.setInt(3, slot.getSlotSeats());
			statement.setInt(4, slot.getSlotSeatsLeft());

			// TODO: Add current slot to gym: gymId

			statement.executeUpdate();
			statement.close();

		} catch (SQLException sqlExcep) {
			System.out.println(sqlExcep);
		} catch (Exception excep) {
			excep.printStackTrace();
		}
		System.out.println("Slot added to gym ID: " + gymId);
		return true; // Placeholder
	}

	// Method to retrieve all gyms for an owner
	public List<GymCentre> getGymsForOwner(int ownerId) {
		// Logic to fetch gyms
		List<GymCentre> allGyms = new ArrayList<>();

		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.FETCH_GYMS_FOR_OWNER);
			statement.setInt(1, ownerId);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				GymCentre gym = new GymCentre(rs.getString("name"));
				gym.setGymId(rs.getInt("id"));
				gym.setName(rs.getString("name"));
				gym.setLocation(rs.getString("location"));
				//TODO: need to add list of slots
				allGyms.add(gym);
			}
		} catch (SQLException sqlExcep) {
			System.out.println(sqlExcep);
		} catch (Exception excep) {
			excep.printStackTrace();
		}

		return allGyms;
		// Placeholder
	}
	
	
}
