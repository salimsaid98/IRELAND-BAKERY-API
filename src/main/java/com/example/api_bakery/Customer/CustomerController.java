package com.example.api_bakery.Customer;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@CrossOrigin(origins = "*") // Allow all origins for CORS
@RestController
@RequestMapping("api/customers")
public class CustomerController {
    private final CustomerServices customerServices;
    public CustomerController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }
@GetMapping("getAllCustomers")
    public List<Customer> getAllCustomers() {
        return customerServices.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerServices.getCustomerById(id);
    }

    @PutMapping("/customer/update/{id}")
    public ResponseEntity<?>  updateCustomer( @PathVariable Long id, @RequestBody Customer customerDetails) {
       Customer customer_2 = customerServices.updateCustomer(id, customerDetails);
       return ResponseEntity.ok(customer_2);


    }

    @DeleteMapping("/customer/delete/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerServices.deleteCustomer(id);
    }

@PostMapping("/customer")
    public CustomerDTO setCustomerServices(@RequestBody CustomerDTO customer) {

       return this.customerServices.saveCustomer(customer);
    }
    @PostMapping("/customer/getByAppUserId")
    public List<Map<String, Object>> getCustomerByAppUserId(Long app_user_id)       
    {
        return customerServices.getCustomerByAppUserId(app_user_id); // Retrieve customers by app user ID
    }

@GetMapping("/balance/{customer_id}")
    public Map<String, Object> getCustomerDetailsByAppUserId(@PathVariable Long customer_id) {
        return customerServices.getCustomerDetailsByAppUserId(customer_id);
    }

@GetMapping("/balances")
   public ResponseEntity<List<Map<String, Object>>> getAllCustomerBalanceDetails() {
       List<Map<String, Object>> balanceDetails = customerServices.findAllCustomerBalanceDetails();
       return ResponseEntity.ok(balanceDetails);
   }
}
