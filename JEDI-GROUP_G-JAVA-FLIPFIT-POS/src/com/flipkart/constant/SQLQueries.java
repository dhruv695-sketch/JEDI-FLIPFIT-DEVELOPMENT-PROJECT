package com.flipkart.constant;

public class SQLQueries {
	public static final String EXAMPLE_QUERY = "SELECT * FROM CUSTOMERS";
	
	// CustomerDao getAllGyms
	public static final String FETCH_ALL_GYMS = "SELECT * FROM GymCentre";
	// CustomerDao getBookingsCustomer
	public static final String FETCH_BOOKINGS_FOR_CUSTOMER = "SELECT * FROM Booking WHERE CustomerId = ?";
	
	// GymAdminDao getAllCustomers
	public static final String FETCH_ALL_CUSTOMERS = "SELECT * FROM Customer";
	
	// GymOwnerDao getGymsForOwner
	public static final String FETCH_GYMS_FOR_OWNER = "SELECT * FROM GymCentre AS G WHERE G.GymId IN (SELECT GL.GymId FROM GymList AS GL WHERE GL.GymOwnerId = ?)";
	
	// PaymentDao viewPaymentDetails
	public static final String FETCH_PAYMENT_DETAILS = "SELECT * FROM Payment WHERE PaymentId = ?";
	
//	public static final String VALIDATE_USER = "SELECT * FROM Payment WHERE PaymentId = ?";
}
