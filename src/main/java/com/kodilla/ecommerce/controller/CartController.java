package com.kodilla.ecommerce.controller;
import com.kodilla.ecommerce.dto.CartDto;
import com.kodilla.ecommerce.dto.ExampleDto;
import com.kodilla.ecommerce.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/v1/cart")
@AllArgsConstructor
public class CartController {

//    private final CartService cartService;
//    private final CartMapper cartMapper;
//    private final ProductMapper productMapper;
//    private final OrderMapper orderMapper;

    //        utworzenie pustego koszyka
    @PostMapping(value = "createCart")
    public void createCart() {
        System.out.println("Uworzono koszyk");
    }

    //        pobranie elementów z pustego koszyka
    @GetMapping(value = "getCart")
    public CartDto getCart(@RequestParam long id) {
        System.out.println("Koszyk został pobrany");
        return CartDto.builder()
                .id(1L)
                .product(new ArrayList<>())
                .price(new BigDecimal("100"))
                .userId(123L)
                .build();
    }

    //        dodanie elementów (produktów) do koszyka
    @PutMapping(value = "addProduct")
    public List<ProductDto> addProduct(@RequestParam long cartId, @RequestParam long productId) {
        System.out.println("Produkt dodano do koszyka");
        return null;
    }

    //        usunięcie konkretnego produktu z koszyka
    @DeleteMapping(value = "removeProduct")
    public void removeProduct(@RequestParam long cartId, @RequestParam long productId) {
        System.out.println("Produkt został usunięty z koszyka");
    }

    //        utworzenie zamówienia na podstawie koszyka
    @PostMapping(value = "makeOrder")
    public ExampleDto makeOrder(@RequestParam long id) { //finalnie OrderDto
        System.out.println("Utworzono zamówienie i usunięto koszyk");
        return null;
    }
}
