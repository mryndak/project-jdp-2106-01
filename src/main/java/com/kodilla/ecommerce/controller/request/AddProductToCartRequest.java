package com.kodilla.ecommerce.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddProductToCartRequest {
    @JsonProperty("productId")
    private Long productId;

    @JsonProperty("count")
    private Long count;
}
