package com.flipkart.bean;
import java.util.List;

public class Customer extends User{
	private List<Integer> bookingList; // List of booking IDs

    // Getters and Setters
    public List<Integer> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Integer> bookingList) {
        this.bookingList = bookingList;
    }
}
