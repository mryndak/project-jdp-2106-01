package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    void deleteById(long id);

    Cart findById(long id);
}
