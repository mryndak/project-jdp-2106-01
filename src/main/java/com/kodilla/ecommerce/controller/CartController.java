package com.kodilla.ecommerce.controller;
import com.kodilla.ecommerce.controller.request.AddProductToCartRequest;
import com.kodilla.ecommerce.dto.CartDto;
import com.kodilla.ecommerce.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping(value="/v1/cart", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CartController {

//    private final CartService cartService;


    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody final CartDto cartDto) {
        log.info("Create cart for request: {}", cartDto);
    }

    @GetMapping(value="/{cartId}")
    public CartDto getCart(@PathVariable final Long cartId) {
        log.info("Get cart for cartId: {}", cartId);
        return CartDto.builder()
                .id(1L)
                .userId(123L)
                .build();
    }

    @PutMapping("/{cartId}")
    public List<ProductDto> addProduct(@PathVariable long cartId, @RequestBody AddProductToCartRequest request) {
        log.info("Add product to cart {} for request: {}", cartId, request);
        return null;
    }

    @DeleteMapping ("{cartId}/{productId}")
    public void removeProduct(@PathVariable long cartId, @PathVariable long productId) {
        log.info("Remove product {} from cartId: {}", productId, cartId);
    }

}