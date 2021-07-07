package com.kodilla.ecommerce.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID", unique = true)
    private Long id;

    private Long productId;
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
