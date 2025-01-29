/**
 * 
 */
package com.flipkart.DAO;

import java.sql.*;
import java.util.*;

import com.flipkart.bean.*;
import com.flipkart.constant.SQLQueries;
import java.util.*;

/**
 * 
 */
public interface AdminDao {
	
	public List<GymCenter> viewPendingGymRequests();
	
	public List<GymOwner> viewPendingGymOwnerRequests();
	
	public List<GymCenter> viewAllApprovedGyms();
	
	public List<GymOwner> viewAllApprovedGymOnwers();
	
	public int approveGymOwnerRegistration(int gymOwnerId);
	
	public boolean approveGymRegistration(int gymCenterId);
	
}
