package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Override
    List<Product> findAll();

    Product findById(long id);

    @Override
    Product save(Product product);

    void deleteById(long id);
}