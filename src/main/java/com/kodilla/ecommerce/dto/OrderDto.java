package com.kodilla.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class OrderDto {

    private Long id;
    private Long userId;
    private Long cartId;
    private String orderStatus;
    private BigDecimal totalPrice;
    private LocalDate orderDate;
    private List<OrderItemDto> orderItemDtos;
}
