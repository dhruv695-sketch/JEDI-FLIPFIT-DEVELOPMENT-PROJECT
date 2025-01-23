package com.flipkart.business;

import com.flipkart.bean.Payment;
import com.flipkart.dao.PaymentDaoImpl;

public class PaymentService {
    PaymentDaoImpl paymentDao = new PaymentDaoImpl();

    public boolean makePayment(Payment payment) {
        return paymentDao.makePayment(payment);
    }

    public boolean issueRefund(int paymentId) {
        return paymentDao.issueRefund(paymentId);
    }
    
    public boolean viewPaymentDetails(int paymentId) {
        return paymentDao.viewPaymentDetails(paymentId);
    }
    
}
