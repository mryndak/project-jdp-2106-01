package com.kodilla.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
//import java.util.List;

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

    private Long groupId;

    private List<OrderItem> orderItems;

    @OneToMany(
            targetEntity = OrderItem.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

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
