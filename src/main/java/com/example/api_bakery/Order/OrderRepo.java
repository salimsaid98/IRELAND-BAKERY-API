package com.example.api_bakery.Order;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepo extends JpaRepository<Order ,Long> {
    @Query(value = "SELECT o.order_id,o.app_user_id,o.customer_id,o.order_date,o.payment,\r\n" + //
                "o.status,o.subtotal,o.tax,o.total_amount,a.username\r\n" + //
                "FROM Orders o \r\n" + //
                "LEFT JOIN app_user a ON a.app_user_id = o.app_user_id\r\n" + //
                "WHERE o.customer_id = :customer_id \r\n" + //
                "order BY o.order_date DESC", nativeQuery = true)
    List<Map<String,Object>> findByCustomerId(@Param("customer_id") Long customer_id);

    @Query(value="SELECT order_date, SUM(total_amount) AS total_amount FROM orders WHERE customer_id IS NULL AND app_user_id = :app_user_id GROUP BY order_date ORDER BY order_date DESC;\r\n" + //
                "",nativeQuery = true)
       List<Map<String,Object>> getAllCashOrdersByUser_id(@PathParam(value = "app_user_id") Long app_user_id);

}