package com.kodilla.ecommerce.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "USER_ID")
    private Long userId;

    @NotNull
    @Column(name = "CART_ID")
    private Long cartId;

    @Column(name = "STATUS")
    private OrderStatus orderStatus;

    @NotNull
    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;

    @Column(name = "ORDER_DATE")
    private LocalDate orderDate;

    @OneToMany(
            targetEntity = OrderItem.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne//(cascade = CascadeType.ALL)  todo jaki CascadeType
    @JoinColumn(name = "ID_OF_USER")
    private User user;
}
