package com.kodilla.ecommerce.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String signature;

    private String name;

    @Column(length = 255)
    private String description;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @OneToMany(
            targetEntity = OrderItem.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToMany(
            targetEntity = CartItem.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<CartItem> cartItems = new ArrayList<>();
}
