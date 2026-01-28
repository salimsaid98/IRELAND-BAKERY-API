package com.example.api_bakery.Payment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
    
    @Query(value = "SELECT SUM(amount) FROM payments_table WHERE customer_id = ?1", nativeQuery = true)
    Double findTotalPaymentsByCustomerId(Long customer_id);

    @Query(value = "select * from payments_table where customer_id = :customer_id", nativeQuery = true)
    List<Payment> findPaymentsByCustomerId(@Param("customer_id") Long customer_id);
}
