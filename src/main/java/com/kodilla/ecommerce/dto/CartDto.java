package com.kodilla.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CartDto {

    private Long id;
    private BigDecimal price;
    private Long userId;
}
