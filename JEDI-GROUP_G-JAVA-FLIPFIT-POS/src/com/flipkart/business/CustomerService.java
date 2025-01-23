package com.flipkart.business;

import com.flipkart.bean.BookSlot;
import com.flipkart.bean.GymCentre;
import com.flipkart.bean.Slot;
import com.flipkart.dao.CustomerDaoImpl;

import java.util.List;

public class CustomerService {
	CustomerDaoImpl customerDao = new CustomerDaoImpl();
	
    // Method to create a new booking
    public boolean createBooking(BookSlot bookSlot) {
        return customerDao.createBooking(bookSlot);
    }

    // Method to view all bookings for a customer
    public List<BookSlot> getBookingsForCustomer(int customerId) {
        return customerDao.getBookingsForCustomer(customerId); // Placeholder
    }

    // Method to cancel a booking
    public boolean cancelBooking(int bookingId) {
        return customerDao.cancelBooking(bookingId);
    }
    
    public List<GymCentre> searchGymsByLocation(String location) {
        return customerDao.searchGymsByLocation(location);
    }

    // Method to retrieve all gyms
    public List<GymCentre> getAllGyms() {
        return customerDao.getAllGyms();
    }
    
    public boolean isSlotAvailable(int slotId) {
        return customerDao.isSlotAvailable(slotId);
    }

    // Method to update slot details
//    public boolean updateSlot(Slot slot) {
//        // Logic to update slot
//        System.out.println("Updating slot: " + slot.getSlotId());
//        return true; // Placeholder
//    }
}

