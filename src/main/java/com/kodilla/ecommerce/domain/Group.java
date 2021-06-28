package com.kodilla.ecommerce.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "Group")
public class Group {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    private String groupName;

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
}
