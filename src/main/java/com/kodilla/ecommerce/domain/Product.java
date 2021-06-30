package com.kodilla.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
//import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "Products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Long groupId;

//    @ManyToOne
//    @JoinColumn(name = "ORDERITEM_ID")
//    private OrderItem orderItem;
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
}
