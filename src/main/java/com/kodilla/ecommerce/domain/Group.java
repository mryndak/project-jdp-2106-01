package com.kodilla.ecommerce.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
@Entity(name = "PRODUCT_GROUPS")
public class Group {

    @Id
    @GeneratedValue
    @Column
    private long id;

    private String name;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @Column(name = "PRODUCTS")
    private final List<Product> productList = new ArrayList<>();

}
