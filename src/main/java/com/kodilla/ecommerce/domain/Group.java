package com.kodilla.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "ProductGroup")
public class Group {

    @Id
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
