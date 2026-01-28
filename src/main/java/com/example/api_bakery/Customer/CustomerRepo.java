package com.example.api_bakery.Customer;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
      // Additional methods can be added as per requirements
    @Query(value = "SELECT * FROM customer WHERE app_user_id = ?1", nativeQuery = true)
    List<Map<String,Object>> findByAppUserId(Long app_user_id);   


   @Query(value = """
SELECT 
    c.customer_id AS customerId,
    c.customer_name AS customerName,
    c.customer_balance AS openingBalance,
    (
        c.customer_balance
        + COALESCE(o.total_ordered, 0)
        - COALESCE(p.total_paid, 0)
    ) AS currentBalance
FROM customer c
LEFT JOIN (
    SELECT customer_id, SUM(amount) AS total_paid
    FROM payments_table
    GROUP BY customer_id
) p ON p.customer_id = c.customer_id
LEFT JOIN (
    SELECT customer_id, SUM(total_amount) AS total_ordered
    FROM orders
    GROUP BY customer_id
) o ON o.customer_id = c.customer_id
WHERE c.customer_id = :customerId
""", nativeQuery = true)
    Map<String, Object> findCustomerBalanceDetails(@Param("customerId") Long customerId);
@Query(value = """
SELECT 
    c.customer_id ,
    c.customer_name ,
    c.customer_balance ,
    c.customer_phone ,
    (
        c.customer_balance
        + COALESCE(o.total_ordered, 0)
        - COALESCE(p.total_paid, 0)
    ) AS currentBalance
FROM customer c
LEFT JOIN (
    SELECT customer_id, SUM(amount) AS total_paid
    FROM payments_table
    GROUP BY customer_id
) p ON p.customer_id = c.customer_id
LEFT JOIN (
    SELECT customer_id, SUM(total_amount) AS total_ordered
    FROM orders
    GROUP BY customer_id
) o ON o.customer_id = c.customer_id
""", nativeQuery = true)
    List<Map<String, Object>> findAllCustomerBalanceDetails();


}
