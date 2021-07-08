package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAll();

    Product findById(long id);

    Product save(Product product);

    void deleteById(long id);
}
