package com.flipkart.dao;

import com.flipkart.bean.Payment;

public class PaymentDao {
	// Method to process a payment
    public boolean makePayment(Payment payment) {
        // Logic to process payment
    	System.out.println("Making payment of amount: " + payment.getAmount());
        return true; // Placeholder
    }

    // Method to issue a refund
    public boolean issueRefund(int paymentId) {
        // Logic to issue refund
    	System.out.println("Refund issued for payment ID: " + paymentId);
        return true; // Placeholder
    }
    
    public boolean viewPaymentDetails(int paymentId) {
        // Logic to issue refund
        System.out.println("Refund issued for payment ID: " + paymentId);
        return true; // Placeholder
    }
}
