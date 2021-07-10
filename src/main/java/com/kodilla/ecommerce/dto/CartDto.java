package com.kodilla.ecommerce.dto;

import com.kodilla.ecommerce.domain.CartItem;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class CartDto {

    private Long id;
    private List<CartItem> productList;
    private BigDecimal price;
    private Long userId;

}
