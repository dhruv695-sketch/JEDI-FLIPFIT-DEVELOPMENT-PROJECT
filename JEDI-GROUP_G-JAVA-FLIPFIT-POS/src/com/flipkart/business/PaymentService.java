package com.flipkart.business;

import com.flipkart.bean.Payment;
import com.flipkart.dao.PaymentDao;

public class PaymentService {
    PaymentDao paymentDao = new PaymentDao();

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
