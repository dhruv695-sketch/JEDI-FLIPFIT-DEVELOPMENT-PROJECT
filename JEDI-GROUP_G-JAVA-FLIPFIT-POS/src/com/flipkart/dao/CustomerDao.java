/**
 * 
 */
package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.BookSlot;
import com.flipkart.bean.GymCentre;

/**
 * 
 */
public interface CustomerDao {
	public boolean createBooking(BookSlot bookSlot);
	
	public List<BookSlot> getBookingsForCustomer(int customerId);
	
	// Method to cancel a booking
    public boolean cancelBooking(int bookingId);
    
    public List<GymCentre> searchGymsByLocation(String location);

    // Method to retrieve all gyms
    public List<GymCentre> getAllGyms();
    
    public boolean isSlotAvailable(int slotId);
}
