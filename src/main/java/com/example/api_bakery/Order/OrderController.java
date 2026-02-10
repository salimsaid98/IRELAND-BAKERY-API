package com.example.api_bakery.Order;

import java.util.List;
import java.util.Map;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*") // Allow all origins for CORS
@RestController
@RequestMapping("api/orders")
public class OrderController {
    
    private final OrderServices orderServices;
    public OrderController(OrderServices orderServices) {
        this.orderServices = orderServices;
    }   
@GetMapping("getAllOrders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderServices.getAllOrders();
        return new ResponseEntity<>(orders, org.springframework.http.HttpStatus.OK);
    }

@PostMapping("/Create_order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderServices.saveOrder(order);
        return new ResponseEntity<>(savedOrder, org.springframework.http.HttpStatus.CREATED);
    }
@PutMapping("/order/update/{id}")
    public ResponseEntity<Order> updateOrder(Long id, @RequestBody Order orderDetails) {
        Order updatedOrder = orderServices.updateOrder(id, orderDetails);
        if (updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, org.springframework.http.HttpStatus.OK);
        } else {
            return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
        }
    }

@DeleteMapping("/order/delete/{id}")
    public ResponseEntity<Void> deleteOrder(Long id) {
        orderServices.deleteOrder(id);
        return new ResponseEntity<>(org.springframework.http.HttpStatus.NO_CONTENT);
    }

@GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(Long id) {
        Order order = orderServices.getOrderById(id);
        if (order != null) {
            return new ResponseEntity<>(order, org.springframework.http.HttpStatus.OK);
        } else {
            return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
        }
    }

@GetMapping("/orderbycustomer_id/{customer_id}")
    public ResponseEntity<List<Map<String,Object>>> getOrdersByCustomerId(@PathVariable Long customer_id) {
        List<Map<String,Object>> orders = orderServices.getOrdersByCustomerId(customer_id);
        return new ResponseEntity<>(orders, org.springframework.http.HttpStatus.OK);
    }

@GetMapping("/AllcashOrderByUserId/{app_user_id}")
    public ResponseEntity <List<Map<String,Object>>>getAllCashOdersVyUserId(@PathVariable Long app_user_id){
         List<Map<String,Object>> orders = this.orderServices.getAllCashOrdersByUserId(app_user_id);
        return new ResponseEntity<>(orders, org.springframework.http.HttpStatus.OK);
    }


}
