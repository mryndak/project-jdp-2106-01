package com.kodilla.ecommerce.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long id;

    //private Long productId;
    //private Long orderId;
    private String name;
    private double price;
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER_NR")
    private Order order;

    @ManyToOne(cascade = CascadeType.PERSIST) //todo
    @JoinColumn(name = "ID_OF_PRODUCT")
    private Product product;
}
