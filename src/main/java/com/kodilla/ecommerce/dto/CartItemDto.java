package com.kodilla.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CartItemDto {

    private Long id;
    private String name;
    private BigDecimal quantity;
}
