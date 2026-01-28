package com.example.api_bakery.OrderItems;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemsServices {
    @Autowired
    private final OrderItemsRepo orderItemsRepo;
    public OrderItemsServices(OrderItemsRepo orderItemsRepo) {
        this.orderItemsRepo = orderItemsRepo;
    }   

    public List<OrderItems> saveOrderItems(List<OrderItems> orderItemsList) {
        return orderItemsRepo.saveAll(orderItemsList);
    }
    public OrderItems getOrderItemsById(Long id) {
        return orderItemsRepo.findById(id).orElse(null);
    }
    public void deleteOrderItems(Long id) {
        orderItemsRepo.deleteById(id);
    }
    public OrderItems updateOrderItems(Long id, OrderItems orderItemsDetails) {
        OrderItems orderItems = getOrderItemsById(id);
        if (orderItems != null) {
            orderItems.setOrder_id(orderItemsDetails.getOrder_id());
            orderItems.setProduct_id(orderItemsDetails.getProduct_id());
            orderItems.setQuantity(orderItemsDetails.getQuantity());
            orderItems.setPrice(orderItemsDetails.getPrice());
            return orderItemsRepo.save(orderItems);
        }
        return null;
    }
    public java.util.List<OrderItems> getAllOrderItems() {
        return orderItemsRepo.findAll();
    }

        List<Map<String,Object>> findCashOrdersByUserIdAndOrderDate(Long app_user_id, 
            LocalDate order_date){   
            return orderItemsRepo.findCashOrdersByUserIdAndOrderDate(app_user_id, order_date);
    }  
public List<Map<String, Object>> findByOrderId(Long order_id) {
        return orderItemsRepo.findByOrderId(order_id);
    }
}
