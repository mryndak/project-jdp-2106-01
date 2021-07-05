package com.kodilla.ecommerce.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal cartPrice;

    private List<Product> productList = new ArrayList<>();

    private Long userId;

    @ManyToMany(
            targetEntity = Product.class,
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @NotNull
    @Column(name = "PRODUCT_LIST")
    public List<Product> getProductList() {
        return productList;
    }

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
