package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.Cart;
import com.kodilla.ecommerce.dto.CartDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartMapper {

    public CartDto mapCartToDto(final Cart cart) {
        return CartDto.builder()
                .id(cart.getId())
                .productList(cart.getProductList())
                .price(cart.getCartPrice())
                .userId(cart.getUserId())
                .build();
    }

    public Cart mapCartDtoToCart(final CartDto cartDto) {
        return Cart.builder()
                .id(cartDto.getId())
                .productList(cartDto.getProductList())
                .cartPrice(cartDto.getPrice())
                .userId(cartDto.getUserId())
                .build();
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList) {
        return cartList.stream()
                .map(this::mapCartToDto)
                .collect(Collectors.toList());
    }
}
