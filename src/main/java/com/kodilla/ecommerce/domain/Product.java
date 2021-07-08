package com.kodilla.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
<<<<<<< HEAD
import java.util.List;
//import java.util.List;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> f4102c8 (JDP210601-21_rev.1: comments improvements on real ProductController methods, added relations in Cart and Group entities)

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Products")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

<<<<<<< HEAD
    private Long groupId;
=======
    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;
>>>>>>> f4102c8 (JDP210601-21_rev.1: comments improvements on real ProductController methods, added relations in Cart and Group entities)

    @OneToMany(
            targetEntity = OrderItem.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
<<<<<<< HEAD
    private List<OrderItem> orderItems;

    //
//    @ManyToOne
//    @JoinColumn(name = "GROUP_ID")
//    private Group group;
//
//    @ManyToMany(
//            cascade = CascadeType.ALL,
//            targetEntity = Cart.class,
//            mappedBy = "carts"
//    )
//    private List<Cart> carts = new ArrayList<>();
=======
    private final List<OrderItem> orderItems = new ArrayList<>();

    @OneToMany(
            targetEntity = CartItem.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private final List<CartItem> cartItems = new ArrayList<>();
>>>>>>> f4102c8 (JDP210601-21_rev.1: comments improvements on real ProductController methods, added relations in Cart and Group entities)
}
