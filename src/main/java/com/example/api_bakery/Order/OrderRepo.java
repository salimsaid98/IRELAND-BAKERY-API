package com.example.api_bakery.Order;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepo extends JpaRepository<Order ,Long> {
    @Query("SELECT o FROM Order o WHERE o.customer_id = ?1 order BY o.order_date DESC")
    java.util.List<Order> findByCustomerId(Long customer_id);

    @Query(value="SELECT order_date, SUM(total_amount) AS total_amount FROM orders WHERE customer_id IS NULL AND app_user_id = :app_user_id GROUP BY order_date ORDER BY order_date DESC;\r\n" + //
                "",nativeQuery = true)
       List<Map<String,Object>> getAllCashOrdersByUser_id(@PathParam(value = "app_user_id") Long app_user_id);

}