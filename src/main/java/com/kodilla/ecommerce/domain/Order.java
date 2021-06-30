package com.kodilla.ecommerce.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Order {

    private Long id;
    private Long userId;
    private Long cartId;
    private String orderStatus;
    private BigDecimal totalPrice;
    private LocalDate orderDate;
    private List<OrderItem> orderItems = new ArrayList<>();

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID", unique = true)
    public Long getId() {
        return id;
    }

    @NotNull
    @Column(name = "USER_ID")
    public Long getUserId() {
        return userId;
    }

    @NotNull
    @Column(name = "CART_ID")
    public Long getCartId() {
        return cartId;
    }

    @Column(name = "STATUS")
    public String getOrderStatus() {
        return orderStatus;
    }

    @Column(name = "TOTAL_PRICE")
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    @NotNull
    @Column(name = "ORDER_DATE")
    public LocalDate getOrderDate() {
        return orderDate;
    }

    @OneToMany(
            targetEntity = OrderItem.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @Column(name = "ORDERED_ITEMS")
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
