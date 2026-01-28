package com.example.api_bakery.Roles;

import javax.persistence.*;

import lombok.Data;
@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long role_id;

    private String name;

    // Getters and Setters
}

