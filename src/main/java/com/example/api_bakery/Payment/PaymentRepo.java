package com.example.api_bakery.Payment;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
    
    @Query(value = "SELECT SUM(amount) FROM payments_table WHERE customer_id = ?1", nativeQuery = true)
    Double findTotalPaymentsByCustomerId(Long customer_id);

    @Query(value = "select p.payment_id,p.amount,p.app_user_id,p.customer_id,p.notes,\r\n" + //
                "p.payment_date,p.payment_method,a.username\r\n" + //
                "from payments_table p\r\n" + //
                "LEFT JOIN app_user a ON a.app_user_id = p.app_user_id\r\n" + //
                "where customer_id = :customer_id ORDER BY p.payment_date  desc;", nativeQuery = true)
    List<Map<String, Object>> findPaymentsByCustomerId(@Param("customer_id") Long customer_id);
}
