package com.kodilla.ecommerce.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CARTS")
public class Cart {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CART_ID")
    private Long id;

    @OneToMany(
            targetEntity = CartItem.class,
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<CartItem> productList = new ArrayList<>();

    private BigDecimal cartPrice;

    private Long userId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID")
    private User user;

}
