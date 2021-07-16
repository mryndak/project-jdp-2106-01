package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.Cart;
import com.kodilla.ecommerce.dto.CartDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartMapper {

    public CartDto mapToCartDto(Cart cart) {
        return CartDto.builder()
                .id(cart.getId())
                .price(cart.getCartPrice())
                .build();
    }

    public Cart mapToCart(CartDto cartDto) {
        return Cart.builder()
                .id(cartDto.getId())
                .cartPrice(cartDto.getPrice())
                .build();
    }

    public List<CartDto> mapToCartDtoList(List<Cart> carts) {
        List<CartDto> cartDtos = new ArrayList<>();
        for (Cart cart : carts) {
            cartDtos.add(mapToCartDto(cart));
        }
        return cartDtos;
    }
}
