package com.example.api_bakery.Customer;

import java.time.LocalDate;

import javax.persistence.*;


import lombok.Data;
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;
    private String customer_name;
    private String customer_email;
    private String customer_phone;
    private int customer_balance;
    @Column(name = "customer_created_date")
    private LocalDate customer_createdDate;
    private Long app_user_id;

    // Getters and Setters
}

