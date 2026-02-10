package com.example.api_bakery.Payment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices {
    @Autowired
    private final PaymentRepo paymentRepo;
    public PaymentServices(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }
    public Payment getPaymentById(Long id) {
        return paymentRepo.findById(id).orElse(null);
    }

    public java.util.List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    public Payment savePayment(Payment payment) {
        return paymentRepo.save(payment);
    }
    public void deletePayment(Long id) {
        paymentRepo.deleteById(id);
    }   
    public Payment updatePayment(Long id, Payment paymentDetails) {
        Payment payment = getPaymentById(id);
        if (payment != null) {
            payment.setPayment_id(paymentDetails.getPayment_id());
            payment.setPayment_method(paymentDetails.getPayment_method());
            payment.setAmount(paymentDetails.getAmount());
            payment.setPayment_date(paymentDetails.getPayment_date());
            payment.setNotes(paymentDetails.getNotes());
            payment.setApp_user_id(paymentDetails.getApp_user_id());
            return paymentRepo.save(payment);
        }
        return null;
    }
 public List<Map<String,Object>> getPaymentsByAppUserId(Long app_user_id) {
        return paymentRepo.findPaymentsByCustomerId(app_user_id);
    }   

}
