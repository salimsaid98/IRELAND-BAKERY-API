package com.example.api_bakery.Payment;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/payments")
public class PaymentController {
    
    private final PaymentServices paymentServices;

    public PaymentController(PaymentServices paymentServices) {
        this.paymentServices = paymentServices;
    }
    @PostMapping("/Create_payment")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        Payment savedPayment = paymentServices.savePayment(payment);
        return ResponseEntity.status(201).body(savedPayment);
    }

    @GetMapping("/getAllPayments")
    public ResponseEntity<java.util.List<Payment>> getAllPayments() {
        java.util.List<Payment> paymentList = paymentServices.getAllPayments();
        return ResponseEntity.ok(paymentList);
    }
    @GetMapping("/payment/{id}")
    public ResponseEntity<Payment> getPaymentById(Long id) {
        Payment payment = paymentServices.getPaymentById(id);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/payment/delete/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentServices.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/payment/update/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
        Payment updatedPayment = paymentServices.updatePayment(id, paymentDetails);
        if (updatedPayment != null) {
            return ResponseEntity.ok(updatedPayment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
        
    @GetMapping("/paymentsByAppUser/{customer_id}")
    public ResponseEntity<List<Map<String,Object>>> getPaymentsByAppUserId(@PathVariable Long customer_id) {
        java.util.List<Map<String,Object>> payments = paymentServices.getPaymentsByAppUserId(customer_id);
        return ResponseEntity.ok(payments);
    }   

}
