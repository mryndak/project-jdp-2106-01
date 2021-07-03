package com.kodilla.ecommerce.controller.request;

import lombok.Data;

@Data
public class AddProductToCartRequest {
    private Long productId;
    private Long count;
}
