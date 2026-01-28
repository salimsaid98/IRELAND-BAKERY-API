package com.example.api_bakery.Customer;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServices {
    private final CustomerRepo customerRepo;

    public CustomerServices(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomer_name(customerDTO.getCustomer_name());
        customer.setCustomer_email(customerDTO.getCustomer_email());
        customer.setCustomer_phone(customerDTO.getCustomer_phone());
        customer.setApp_user_id(customerDTO.getApp_user_id());
        customer.setCustomer_balance(customerDTO.getCustomer_balance());
        customer = customerRepo.save(customer);
    
        return customerDTO;
    }

    public Customer getCustomerById(Long id) {
        return customerRepo.findById(id).orElse(null);
    }

    public void deleteCustomer(Long id) {
        customerRepo.deleteById(id);
    }
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = getCustomerById(id);
        if (customer != null) {
            customer.setCustomer_name(customerDetails.getCustomer_name());
            customer.setCustomer_email(customerDetails.getCustomer_email());
            customer.setCustomer_balance(customerDetails.getCustomer_balance());    
            customer.setCustomer_phone(customerDetails.getCustomer_phone());
            return customerRepo.save(customer);
        }
        return null;
    }

     public  List<Map<String, Object>> getCustomerByAppUserId(Long app_user_id) {
        return customerRepo.findByAppUserId(app_user_id); // Retrieve products by app user ID
    }

  public Map<String, Object> getCustomerDetailsByAppUserId(Long app_user_id) {
        return customerRepo.findCustomerBalanceDetails(app_user_id);
    }

    public List<Map<String, Object>> findAllCustomerBalanceDetails() {
        return customerRepo.findAllCustomerBalanceDetails();
    }
}