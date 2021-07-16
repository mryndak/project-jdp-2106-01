package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.domain.Cart;
import com.kodilla.ecommerce.domain.CartItem;
import com.kodilla.ecommerce.domain.Product;
import com.kodilla.ecommerce.dto.CartItemDto;
import com.kodilla.ecommerce.mapper.CartItemMapper;
import com.kodilla.ecommerce.repository.CartItemRepository;
import com.kodilla.ecommerce.repository.CartRepository;
import com.kodilla.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartItemMapper cartItemMapper;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    public void createCartItem(long productId, long cartId, CartItemDto cartItemDto) {
        Product product = productRepository.findById(productId);
        Cart cart = cartRepository.findById(cartId);
        CartItem cartItem = cartItemMapper.mapToCartItem(cartItemDto);
        cartItem.setName(product.getName());
        product.getCartItems().add(cartItem);
        cart.getCartItems().add(cartItem);
        cartItem.setProduct(product);
        cartItem.setCart(cart);
    }

    public void changeCartItemQuantity(long cartItemId, long cartId, CartItemDto cartItemDto) {
        if (isCartNotExists(cartItemId, cartId)) return;
        cartItemRepository.findById(cartItemId).setQuantity(cartItemDto.getQuantity());
        if (isQuantityZero(cartItemId)) removeCartItem(cartItemId, cartId);
    }

    private boolean isQuantityZero(long cartItemId) {
        return cartItemRepository.findById(cartItemId).getQuantity().equals(BigDecimal.ZERO);
    }

    public void removeCartItem(long cartItemId, long cartId) {
        if (isCartNotExists(cartItemId, cartId)) return;
        cartItemRepository.deleteById(cartItemId);
    }

    private boolean isCartNotExists(long cartItemId, long cartId) {
        return cartItemRepository.findById(cartItemId).getCart().getId() != cartId ||
                cartItemRepository.findById(cartItemId).getCart().getId() == null;
    }
}
