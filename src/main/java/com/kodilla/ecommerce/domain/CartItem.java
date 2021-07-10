package com.kodilla.ecommerce.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "CartItems")
public class CartItem {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "CART_ID")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}
