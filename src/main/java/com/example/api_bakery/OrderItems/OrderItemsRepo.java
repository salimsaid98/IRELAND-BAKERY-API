package com.example.api_bakery.OrderItems;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderItemsRepo extends org.springframework.data.jpa.repository.JpaRepository<OrderItems, Long> {


@Query(value = "select o.order_date , p.name , ot.price , ot.quantity , o.app_user_id\r\n" + //
        "from order_items ot \r\n" + //
        "LEFT JOIN product p\r\n" + //
        "ON p.product_id = ot.product_id\r\n" + //
        "LEFT JOIN orders o ON o.order_id = ot.order_id\r\n" + //
        "where o.app_user_id = :app_user_id AND o.order_date = :order_date AND o.customer_id IS NULL;", nativeQuery = true)
    List<Map<String, Object>> findCashOrdersByUserIdAndOrderDate(@Param("app_user_id") Long app_user_id, @Param("order_date") LocalDate order_date);

  @Query(
  value = "select o.order_date,c.customer_name,c.customer_phone,ot.order_items_id,ot.order_id,ot.price,ot.product_id,ot.quantity,p.name as name\r\n" + //
            "from order_items ot\r\n" + //
            "LEFT JOIN product p ON p.product_id = ot.product_id\r\n" + //
            "LEFT JOIN orders o ON o.order_id = ot.order_id\r\n" + //
            "LEFT JOIN customer c  ON c.customer_id = o.customer_id\r\n" + //
            "\r\n" + //
            "where ot.order_id= :order_id",
  nativeQuery = true
)
List<Map<String, Object>> findByOrderId(@Param("order_id") Long order_id);
}