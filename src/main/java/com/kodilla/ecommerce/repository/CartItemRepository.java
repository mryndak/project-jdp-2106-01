package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    CartItem deleteById(long id);

    CartItem findById(long id);
}
