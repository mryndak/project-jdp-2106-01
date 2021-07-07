package com.kodilla.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemDto {

    private Long id;
    private Long productId;
    private Long orderId;
    private String name;
    private double price;
    private int quantity;
}
