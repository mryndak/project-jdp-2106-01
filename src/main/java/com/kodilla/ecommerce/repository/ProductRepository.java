package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findById(long id);

    void deleteById(long id);

    boolean existsById(Long id);
}
