package com.example.api_bakery.Payment;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "payments_table")
public class Payment {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long payment_id;
    private Long customer_id; 
    private String payment_method;
    private double amount;
    private LocalDate payment_date;
    private String notes;
    private Long app_user_id;

    // Getters and setters
}
