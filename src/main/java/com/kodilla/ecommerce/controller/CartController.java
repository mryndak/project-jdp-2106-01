package com.kodilla.ecommerce.controller;
import com.kodilla.ecommerce.dto.CartDto;
import com.kodilla.ecommerce.dto.ExampleDto;
import com.kodilla.ecommerce.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="/v1/cart")
@RequiredArgsConstructor
public class CartController {

//    private final CartService cartService;
//    private final CartMapper cartMapper;
//    private final ProductMapper productMapper;
//    private final OrderMapper orderMapper;


    @PostMapping
    public void createCart(@RequestBody final CartDto cartDto) {
        System.out.println("Uworzono koszyk");
    }

    @GetMapping(value = "/{id}")
    public CartDto getCart(@PathVariable final Long id) {
        System.out.println("Koszyk został pobrany");
        return CartDto.builder()
                .id(1L)
                .product(new ArrayList<>())
                .price(new BigDecimal("100"))
                .userId(123L)
                .build();
    }

    @PutMapping(value = "/{cartId}/{productId}")
    public List<ProductDto> addProduct(@PathVariable long cartId, @PathVariable long productId) {
        System.out.println("Produkt dodano do koszyka");
        return null;
    }

    @DeleteMapping (value = "/{cartId}/{productId}")
    public void removeProduct(@PathVariable long cartId, @PathVariable long productId) {
        System.out.println("Produkt został usunięty z koszyka");
    }

    @PostMapping(value = "makeOrder")
    public void makeOrder(@RequestBody final ExampleDto orderDto) { //finalnie OrderDto
        System.out.println("Utworzono zamówienie i usunięto koszyk");
    }
}
