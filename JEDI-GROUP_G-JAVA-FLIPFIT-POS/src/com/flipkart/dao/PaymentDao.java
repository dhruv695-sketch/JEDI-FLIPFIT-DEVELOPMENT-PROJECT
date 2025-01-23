/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.Payment;

/**
 * 
 */
public interface PaymentDao {
    public boolean makePayment(Payment payment);

    // Method to issue a refund
    public boolean issueRefund(int paymentId);
    
    public boolean viewPaymentDetails(int paymentId);

}
