package com.example.api_bakery.Order;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    private Long customer_id;
    // private Long product_id;
    // private Integer quantity;
    private String payment;  
    private double total_amount;
    private double subtotal;
    private double tax;
    private LocalDate order_date;
    private String status;
    private Long app_user_id;

}
