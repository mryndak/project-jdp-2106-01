package com.kodilla.ecommerce.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "CART_ITEMS")
public class CartItem {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
