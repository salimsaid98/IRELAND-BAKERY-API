package com.example.api_bakery.Production;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "productions_table")
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime productionDate;
    private int total_unit_produce;
    private Long quantity;
    private Long product_id;
    private Long app_user_id;
    private Long unit_type_id;
}
