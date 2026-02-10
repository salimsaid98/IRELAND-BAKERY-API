package com.example.api_bakery.Unit_type;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "unit_type_table")
public class Unit_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long unit_type_id;
    private int unit_measure;
    private Long product_id;
    private Long app_user_id;
}
