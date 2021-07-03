package com.kodilla.ecommerce.controller;
import com.kodilla.ecommerce.dto.CartDto;
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


    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody final CartDto cartDto) {
        System.out.println("Uworzono koszyk1233");
    }

    @GetMapping(value="{id}", produces = APPLICATION_JSON_VALUE)
    public CartDto getCart(@PathVariable final Long id) {
        System.out.println("Koszyk 1323został pobrany");
        return CartDto.builder()
                .id(1L)
                .userId(123L)
                .build();
    }

    @PutMapping("{cartId}/{productId}")
    public List<ProductDto> addProduct(@PathVariable long cartId, @PathVariable long productId) {
        if(1 ==1) {
            // to cos tam
        }
        System.out.println("Produkt 2222dodano do koszyka");
        return null;
    }

    @DeleteMapping ("{cartId}/{productId}")
    public void removeProduct(@PathVariable long cartId, @PathVariable Long productId) {
        System.out.println("Produkt z111ostał usunięty z koszyka");
    }

//    @PostMapping(value="makeOrder", consumes = APPLICATION_JSON_VALUE)
//    public void makeOrder(@RequestBody final ExampleDto orderDto) { //finalnie OrderDto
//        System.out.println("Utworzono zamówienie i usunięto koszyk");
//    }
}
