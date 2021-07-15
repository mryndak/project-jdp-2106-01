package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.domain.Cart;
import com.kodilla.ecommerce.domain.CartItem;
import com.kodilla.ecommerce.dto.CartDto;
import com.kodilla.ecommerce.dto.CartItemDto;
import com.kodilla.ecommerce.mapper.CartItemMapper;
import com.kodilla.ecommerce.mapper.CartMapper;
import com.kodilla.ecommerce.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;
    private final CartItemService cartItemService;
    private final CartItemMapper cartItemMapper;

    public List<CartItemDto> showCartItems(long cartId) {
        return cartItemMapper.mapToCartItemDtoList(cartRepository.findById(cartId).getCartItems());
    }

    public CartDto createCart(CartDto cartDto) {
        return cartMapper.mapToCartDto(cartRepository.save(cartMapper.mapToCart(cartDto)));
    }

    public CartDto addCartItemToCart(long productId, long cartId, CartItemDto cartItemDto) {
        cartItemService.createCartItem(productId, cartId, cartItemDto);
        return cartMapper.mapToCartDto(cartRepository.save(getCartWithCountedPrice(cartId)));
    }

    public CartDto changeCartItemQuantityInCart(long cartItemId, long cartId, CartItemDto cartItemDto) {
        cartItemService.changeCartItemQuantity(cartItemId, cartId, cartItemDto);
        return cartMapper.mapToCartDto(cartRepository.save(getCartWithCountedPrice(cartId)));
    }

    public CartDto removeCartItemFromCart(long cartItemId, long cartId) {
        cartItemService.removeCartItem(cartItemId, cartId);
        return cartMapper.mapToCartDto(cartRepository.save(getCartWithCountedPrice(cartId)));
    }

    public Cart getCartWithCountedPrice(long cartId) {
        BigDecimal sum = BigDecimal.ZERO;
        Cart cart = cartRepository.findById(cartId);
        cart.setCartPrice(countCartPrice(sum, cart));
        return cart;
    }

    private BigDecimal countCartPrice(BigDecimal sum, Cart cart) {
        for(CartItem cartItem : cart.getCartItems()) {
            BigDecimal price = cartItem.getProduct().getPrice().multiply(cartItem.getQuantity());
            sum = sum.add(price);
        }
        return sum;
    }
}
