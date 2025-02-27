/**
 * 
 */
package com.flipkart.DAO;

import com.flipkart.bean.*;
import com.flipkart.constant.SQLQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.flipkart.utils.*;
import java.util.*;

/**
 * 
 */
public class GymOwnerDaoImpl implements GymOwnerDao {

	Connection connection = null;
	PreparedStatement statement = null;
	
	public GymOwner getGymOwnerDetails(String gymOwnerEmail) {
		GymOwner gymOwner = new GymOwner();

		try {
			connection = DBUtils.getConnection();
			System.out.println("Fetching GymOnwer Details...");
			statement = connection.prepareStatement(SQLQueries.FETCH_GYMOWNER_DETAILS);		    
		    statement.setString(1,gymOwnerEmail);
		    
		    ResultSet rs = statement.executeQuery();
			while(rs.next()){
				gymOwner.setId(rs.getInt("id"));
				gymOwner.setEmail(rs.getString("email"));
				gymOwner.setAddress(rs.getString("address"));
				gymOwner.setGstNumber(rs.getString("gstNumber"));
				gymOwner.setName(rs.getString("name"));
				gymOwner.setPhone(rs.getInt("phone"));
				gymOwner.setApproved(rs.getBoolean("isApproved"));
			}
			
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		
		return gymOwner;
	}
	
	public List<GymCenter> viewAllGymCenters(String gymOwnerEmail){
		List<GymCenter> allGyms =  new ArrayList<>();
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.FETCH_GYMOWNER_ALL_GYMS);
			statement.setString(1,gymOwnerEmail);
		    ResultSet rs = statement.executeQuery();
			
		    while (rs.next()) {
		    	GymCenter gym = new GymCenter();
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
	}
	
	public List<GymCenter> viewAllApprovedGymCenters(String gymOwnerEmail){
		List<GymCenter> allApprovedGyms =  new ArrayList<>();
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.FETCH_GYMOWNER_ALL_APPROVED_GYMS);
			statement.setString(1,gymOwnerEmail);
		    ResultSet rs = statement.executeQuery();
			
		    while (rs.next()) {
		    	GymCenter gym = new GymCenter();
				gym.setId(rs.getInt("id"));
				gym.setName(rs.getString("name"));
				gym.setLocation(rs.getString("location"));
				gym.setNoOfSeats(rs.getInt("noOfSeats"));
				gym.setGymOwnerEmail(rs.getString("gymOwnerEmail"));
				gym.setApproved(rs.getBoolean("isApproved"));
				allApprovedGyms.add(gym);
			}
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		
		return allApprovedGyms;
	}
	
	public List<Slot> viewAllSlots(int gymCenterId){
		List<Slot> allSlots = new ArrayList<>();
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.FETCH_ALL_SLOTS_OF_GYM);
			statement.setInt(1,gymCenterId);
		    ResultSet rs = statement.executeQuery();
			
		    while (rs.next()) {
		    	Slot slot = new Slot();
		    	slot.setId(rs.getInt("slotId"));
		    	slot.setTime(rs.getString("time"));
		    	allSlots.add(slot);
			}
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
		
		return allSlots;
	}
	
	public void addGym(GymCenter gymCenter) {
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.INSERT_GYM);

			statement.setString(1,gymCenter.getGymOwnerEmail());
			statement.setString(2,gymCenter.getName());
			statement.setString(3,gymCenter.getLocation());
			statement.setInt(4,gymCenter.getNoOfSeats());
			statement.setInt(5,0);
			statement.executeUpdate();
			statement.close();
			
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	}

	public int createSlot(Slot slot, int gymCenterId){
	
		    boolean slotEx = false;
		    int generatedId=0, added = -1;

		try {
			   String checkSlotQuery = "SELECT COUNT(*) FROM Slot WHERE time = ?";
		        statement = connection.prepareStatement(checkSlotQuery);
//		        statement.setInt(1, gymCenterId);
		        statement.setString(1, slot.getTime());
		        
		        ResultSet resultSet = statement.executeQuery();
		        if (resultSet.next() && resultSet.getInt(1) > 0) {
		            System.out.println("Slot already exists for this time slot one.");
		            slotEx = true;
		        }
		        if (!slotEx) {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.FETCH_GYM_SEATS);
			statement.setInt(1,gymCenterId);
			
			
			ResultSet rs = statement.executeQuery();
		    int seats  = 0;
		    while (rs.next()) {
		    seats = rs.getInt("noOfSeats");
		    }
		    
			statement = connection.prepareStatement(SQLQueries.CREATE_SLOT, Statement.RETURN_GENERATED_KEYS);

//			statement.setInt(1,1);
			statement.setString(1,slot.getTime());
			statement.setInt(2, seats);
			statement.executeUpdate();
			ResultSet rss = statement.getGeneratedKeys();
			if (rss.next()) {
			    generatedId = rss.getInt(1);
			}
			statement.close();
			added = generatedId;
			}
		} catch(SQLException sqlExcep) {
			System.out.println(sqlExcep);
		} catch(Exception excep) {
			excep.printStackTrace();
		}
		return added;
	}
	
	public boolean addSlots(int gymCenterId,Slot slot) {
		boolean slotExists = false, added = false;
		try {
			connection = DBUtils.getConnection();
		       // Check if a slot already exists for the same time
	        String checkSlotQuery = "SELECT COUNT(*) FROM AllSlots WHERE gymCenterId = ? AND time = ?";
	        statement = connection.prepareStatement(checkSlotQuery);
	        statement.setInt(1, gymCenterId);
	        statement.setString(2, slot.getTime());
	        
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next() && resultSet.getInt(1) > 0) {
	            System.out.println("Slot already exists for this time.");
	            slotExists = true;
	        }
	        if (!slotExists) {
			statement = connection.prepareStatement(SQLQueries.INSERT_SLOT);
			
			statement.setInt(1,gymCenterId);
			statement.setInt(2,slot.getId());
			statement.setString(3,slot.getTime());
			statement.executeUpdate();
			
			statement.close();
			added = true;
	        }
	        
			
	    } catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }	
		return added;
	}
	
	public boolean isApproved(String gymOwnerEmail) {
		
		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.CHECK_GYMOWNER_APPROVEVAL);
			statement.setString(1, gymOwnerEmail);
		    ResultSet output = statement.executeQuery();
		    if(output.next())
		    	return true;
		} catch(SQLException sqlExcep) {
		       System.out.println(sqlExcep);
		} catch(Exception excep) {
		       excep.printStackTrace();
		}
		return false;
	}

	public boolean isApproved(int gymCenterId) {

		try {
			connection = DBUtils.getConnection();
			statement = connection.prepareStatement(SQLQueries.CHECK_GYMCENTER_APPROVEVAL);
			statement.setInt(1, gymCenterId);
			ResultSet output = statement.executeQuery();
			if(output.next())
				return true;
		} catch(SQLException sqlExcep) {
			System.out.println(sqlExcep);
		} catch(Exception excep) {
			excep.printStackTrace();
		}
		return false;
	}
	
	
}
