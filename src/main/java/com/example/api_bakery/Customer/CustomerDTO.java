package com.example.api_bakery.Customer;



import java.time.LocalDate;

import lombok.Data;
@Data
public class CustomerDTO {

    private String customer_name;
    private String customer_email;
    private String customer_phone;
    private int customer_balance;
    private LocalDate customer_createdDate;
    private Long app_user_id;
}
