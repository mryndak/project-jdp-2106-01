package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Override
    List<Cart> findAll();

    @Override
    Optional<Cart> findById(Long id);

    @Override
    Cart save(Cart cart);

    @Override
    void deleteById(Long id);

}
