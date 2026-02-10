package com.example.api_bakery.Kitchen_Production;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "kitchen_production_table")
public class Kitchen_Production {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long kitchen_production_id;
    private int finished_qty;
    private int damaged_qty; 
    private Long app_user_id;   
    private String remarks;
    private Long product_id;
    private LocalDateTime productionDate;

}
