package com.kodilla.ecommerce.domain;

import lombok.AllArgsConstructor;
<<<<<<< HEAD
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


=======
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
>>>>>>> f4102c8 (JDP210601-21_rev.1: comments improvements on real ProductController methods, added relations in Cart and Group entities)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "ProductGroup")
public class Group {

    @Id
    @GeneratedValue
    private Long id;

    private String groupName;

<<<<<<< HEAD
//    private List<Product> productList = new ArrayList<>();
//
//    @OneToMany(
//            targetEntity = Product.class,
//            mappedBy = "group",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    public List<Product> getProducts() {
//        return productList;
//    }
=======
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private final List<Product> productList = new ArrayList<>();
>>>>>>> f4102c8 (JDP210601-21_rev.1: comments improvements on real ProductController methods, added relations in Cart and Group entities)
}
