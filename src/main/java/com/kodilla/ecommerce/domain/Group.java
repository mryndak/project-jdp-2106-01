package com.kodilla.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@Entity
@Table(name = "GROUP")
public class Group {

    private long id;
    private String name;
//    private List<Product> products;
  
//    @OneToMany(
//            targetEntity = Product.class,
//            mappedBy = "group",
//            cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY
//    )
//    public List<Product> getProducts() {
//        return products;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

}
