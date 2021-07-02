package com.kodilla.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class CartDto {

    private Long id;
    private List<String> product; //finalnie List<Product>
    private BigDecimal price;
    private Long userId;

}
