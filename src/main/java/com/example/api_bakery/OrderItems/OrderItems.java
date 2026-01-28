package com.example.api_bakery.OrderItems;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long order_items_id;
    private Long order_id;
    private Long product_id;
    private Integer quantity;
    private double price;

    // Getters and setters
}   