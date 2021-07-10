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
    @Column(name = "ORDER_ITEM_ID", unique = true)
    private Long id;

    private Long productId;
    private Long orderId;
    private String name;
    private double price;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID_NR")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ID")
    private Product product;
}
