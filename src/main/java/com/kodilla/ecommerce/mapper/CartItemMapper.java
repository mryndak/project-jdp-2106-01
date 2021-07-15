package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.CartItem;
import com.kodilla.ecommerce.dto.CartItemDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartItemMapper {

    public CartItemDto mapToCartItemDto(CartItem cartItem) {
        return CartItemDto.builder()
                .id(cartItem.getId())
                .name(cartItem.getProduct().getName())
                .quantity(cartItem.getQuantity())
                .build();
    }

    public CartItem mapToCartItem(CartItemDto cartItemDto) {
        return CartItem.builder()
                .id(cartItemDto.getId())
                .quantity(cartItemDto.getQuantity())
                .build();
    }

    public List<CartItemDto> mapToCartItemDtoList(List<CartItem> cartItemList) {
        List<CartItemDto> cartItemDtos = new ArrayList<>();
        for (CartItem cartItem : cartItemList) {
            cartItemDtos.add(mapToCartItemDto(cartItem));
        }
        return cartItemDtos;
    }
}
