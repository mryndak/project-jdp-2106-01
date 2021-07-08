package com.kodilla.ecommerce.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
=======
@Builder
>>>>>>> f4102c8 (JDP210601-21_rev.1: comments improvements on real ProductController methods, added relations in Cart and Group entities)
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

    private BigDecimal cartPrice;

<<<<<<< HEAD
//    private List<CartItems> cartItems = new ArrayList<>(); //Encje i tabelę łączocą doda Bartek

=======
>>>>>>> f4102c8 (JDP210601-21_rev.1: comments improvements on real ProductController methods, added relations in Cart and Group entities)
    private Long userId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID")
    private User user;
<<<<<<< HEAD
=======

    @OneToMany(
            targetEntity = CartItem.class,
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private final List<CartItem> cartItems = new ArrayList<>();
>>>>>>> f4102c8 (JDP210601-21_rev.1: comments improvements on real ProductController methods, added relations in Cart and Group entities)
}
