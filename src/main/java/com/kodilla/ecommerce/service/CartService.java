package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.domain.Cart;
import com.kodilla.ecommerce.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartService {

    private final CartRepository repository;


    public List<Cart> getAllCarts() {
        return repository.findAll();
    }

    public void deleteById

}
