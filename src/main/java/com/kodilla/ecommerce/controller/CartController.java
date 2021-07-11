package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.controller.request.AddProductToCartRequest;
import com.kodilla.ecommerce.controller.request.CartNotFoundException;
import com.kodilla.ecommerce.domain.Cart;
import com.kodilla.ecommerce.domain.Product;
import com.kodilla.ecommerce.dto.CartDto;
import com.kodilla.ecommerce.dto.ProductDto;
import com.kodilla.ecommerce.mapper.CartMapper;
import com.kodilla.ecommerce.mapper.ProductMapper;
import com.kodilla.ecommerce.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping(value = "/v1/cart", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final CartMapper cartMapper;
    private final ProductMapper productMapper;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody final CartDto cartDto) {
        log.info("Create cart for request: {}", cartDto);
        Cart cart = cartMapper.mapCartDtoToCart(cartDto);
        cartService.saveCart(cart);
    }

    @GetMapping(value = "/{cartId}")
    public CartDto getCart(@PathVariable final long cartId) throws CartNotFoundException {
        log.info("Get cart for cartId: {}", cartId);
        Cart cart = cartService.getCart(cartId).orElseThrow(CartNotFoundException::new);
        return cartMapper.mapCartToDto(cart);

//        return CartDto.builder()
//                .id(1L)
//                .userId(123L)
//                .build();
    }

    @PutMapping(value = "/{cartId}", consumes = APPLICATION_JSON_VALUE)
    public List<ProductDto> addProduct(@PathVariable long cartId, @RequestBody AddProductToCartRequest request) {
        log.info("Add product to cart {} for request: {}", cartId, request);
        System.out.println(request);
//        List<Product> products = cartService.addProductToCart(cartId, request);
        return new ArrayList<>(); //productMapper.mapToProductDtoList(products);
    }

    @DeleteMapping("{cartId}/{productId}")
    public void removeProduct(@PathVariable long cartId, @PathVariable long productId) {
        log.info("Remove product {} from cartId: {}", productId, cartId);
        cartService.deleteCart(cartId);
    }

}
