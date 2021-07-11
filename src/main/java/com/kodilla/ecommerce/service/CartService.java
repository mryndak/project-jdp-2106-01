package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.controller.request.AddProductToCartRequest;
import com.kodilla.ecommerce.controller.request.ResourceNotFoundException;
import com.kodilla.ecommerce.domain.Cart;
import com.kodilla.ecommerce.domain.Product;
import com.kodilla.ecommerce.dto.ProductDto;
import com.kodilla.ecommerce.mapper.ProductMapper;
import com.kodilla.ecommerce.repository.CartRepository;
import com.kodilla.ecommerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartService {

    private final CartRepository repository;
    private final ProductRepository productRepository;
//    private final ProductService productService;
//    private final ProductMapper productMapper;


    public Optional<Cart> getCart(final long cartId) {
//        if (repository.existsById(cartId))
        return repository.findById(cartId);
    }

    public Cart saveCart(final Cart cart) {
        return repository.save(cart);
    }

    public List<Product> addProductToCart(long cartId, AddProductToCartRequest request) {
        Product product = productRepository.findById(1); //stub
        Cart cart = repository.findById(cartId).orElseThrow();
        List<Product> productsList = cart.getProductList();
        productsList.add(product);
        return productsList;
    }

    public void deleteCart(long cartId) {
        Cart cart = repository.findById(cartId).orElseThrow();
        if (repository.existsById(cartId))
        repository.deleteById(cart.getId());
    }
}
