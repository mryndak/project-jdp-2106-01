package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.Product;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findById(long id);

    void deleteById(long id);

    boolean existsById(Long id);
=======
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findAll();

    Product findById(long id);

    Product save(Product product);

    void deleteById(long id);
>>>>>>> b1c4854 (JDP210601-21: real implementation of ProductController, added ProductMapper, ProductRepository, ProductService, added @Builder annotation in Product)
}
