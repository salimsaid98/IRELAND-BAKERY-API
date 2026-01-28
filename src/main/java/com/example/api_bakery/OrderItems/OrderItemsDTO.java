package com.example.api_bakery.OrderItems;

import lombok.Data;

@Data
public class OrderItemsDTO {
    private Long order_items_id;
    private Long order_id;
    private Long product_id;
    private Integer quantity;
    private double price;
}
