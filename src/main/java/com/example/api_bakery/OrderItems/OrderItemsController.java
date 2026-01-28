package com.example.api_bakery.OrderItems;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
@CrossOrigin(origins = "*") // Allow all origins for CORS
@RestController
@RequestMapping("api/orderItems")
public class OrderItemsController {
    private final OrderItemsServices orderItemsServices;    
    public OrderItemsController(OrderItemsServices orderItemsServices) {
        this.orderItemsServices = orderItemsServices;
    }
    @GetMapping("/orderItems/{id}")
    public ResponseEntity<OrderItems> getOrderItemsById(Long id) {
        OrderItems orderItems = orderItemsServices.getOrderItemsById(id);
        if (orderItems != null) {
            return new ResponseEntity<>(orderItems, org.springframework.http.HttpStatus.OK);
        } else {
            return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getAllOrderItems")
    public ResponseEntity<java.util.List<OrderItems>> getAllOrderItems() {
        java.util.List<OrderItems> orderItemsList = orderItemsServices.getAllOrderItems();
        return new ResponseEntity<>(orderItemsList, org.springframework.http.HttpStatus.OK);
    }
    @PostMapping("/Create_orderItems")
    public ResponseEntity<List<OrderItems>> createOrderItems(@RequestBody List<OrderItems> orderItemsList) {
        List<OrderItems> savedOrderItems = orderItemsServices.saveOrderItems(orderItemsList);
        return new ResponseEntity<>(savedOrderItems, org.springframework.http.HttpStatus.CREATED);
    }
    @PutMapping("/orderItems/update/{id}")
    public ResponseEntity<OrderItems> updateOrderItems(Long id, @RequestBody OrderItems orderItemsDetails) {
        OrderItems updatedOrderItems = orderItemsServices.updateOrderItems(id, orderItemsDetails);
        if (updatedOrderItems != null) {
            return new ResponseEntity<>(updatedOrderItems, org.springframework.http.HttpStatus.OK);
        } else {
            return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
        }
    }  
    @DeleteMapping("/orderItems/delete/{id}")    
    public ResponseEntity<Void> deleteOrderItems(Long id) {
        orderItemsServices.deleteOrderItems(id);
        return new ResponseEntity<>(org.springframework.http.HttpStatus.NO_CONTENT);
    }  
    
    
@GetMapping("/cashOrdersByUserIdAndOrderDate/{app_user_id}/{order_date}")
public ResponseEntity<List<Map<String, Object>>> findCashOrdersByUserIdAndOrderDate(
        @PathVariable Long app_user_id,
        @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate order_date) {

    List<Map<String, Object>> orders =
            orderItemsServices.findCashOrdersByUserIdAndOrderDate(app_user_id, order_date);

    return ResponseEntity.ok(orders);
}
@GetMapping("/orderItemsByOrderId/{order_id}")
public ResponseEntity<List<Map<String, Object>>> getOrderItemsByOrderId(@PathVariable Long order_id) {
    List<Map<String, Object>    > orderItemsList = orderItemsServices.findByOrderId(order_id);
    return ResponseEntity.ok(orderItemsList);
}
}
