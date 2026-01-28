package com.example.api_bakery.UserAccount;

import javax.persistence.*;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)       
    private Long user_account_id;
    private String username;
    private String email;
    private Long status;
    private Long role_id;
    private String password;
    private Long app_user_id;

}
