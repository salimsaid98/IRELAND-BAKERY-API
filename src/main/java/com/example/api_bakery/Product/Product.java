package com.example.api_bakery.Product;

import javax.persistence.*;

import lombok.Data;
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    private String name;
    private String description;
    // private int quantity;
    private double price;
    private double originalPrice;
    private String image;
    private double selling_price;
    private int rating;
    private boolean inStock;
    private int quantity;
    private Long app_user_id;

    // Getters and Setters
}
