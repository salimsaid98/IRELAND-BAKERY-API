package com.example.api_bakery.Order;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServices {
    @Autowired
    private final OrderRepo orderRepo;
    public OrderServices(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElse(null);
    }
    public void deleteOrder(Long id) {
        orderRepo.deleteById(id);
    }
    public Order updateOrder(Long id, Order orderDetails) {
        Order order = getOrderById(id);
        if (order != null) {
            order.setCustomer_id(orderDetails.getCustomer_id());
            order.setSubtotal(orderDetails.getSubtotal());
            order.setTax(orderDetails.getTax());
            order.setTotal_amount(orderDetails.getTotal_amount());
            order.setOrder_date(orderDetails.getOrder_date());
            order.setStatus(orderDetails.getStatus());
            order.setPayment(orderDetails.getPayment());
            return orderRepo.save(order);
        }
        return null;
    }
    public java.util.List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
    public java.util.List<Order> getOrdersByCustomerId(Long customer_id) {
        return orderRepo.findByCustomerId(customer_id);
    }

    List<Map<String,Object>> getAllCashOrdersByUserId(Long app_user_id){
            return orderRepo.getAllCashOrdersByUser_id(app_user_id);
    }
 
}
