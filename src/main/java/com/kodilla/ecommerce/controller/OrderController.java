package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/v1/order", produces = APPLICATION_JSON_VALUE)
public class OrderController {

    @GetMapping
    public List<OrderDto> getOrders() {
        return Arrays.asList(
                OrderDto.builder()
                        .id(1L)
                        .userId(1L)
                        .cartId(1L)
                        .orderStatus("testing getOrders")
                        .totalPrice(new BigDecimal("123"))
                        .orderDate(LocalDate.of(2021, 6, 26))
                        .orderItemDtos(Collections.emptyList())
                        .build()
        );
    }

    @GetMapping("{id}")
    public OrderDto getOrder(@PathVariable Long id) {
        return OrderDto.builder()
                .id(1L)
                .orderStatus("testing getOrder")
                .orderItemDtos(Collections.emptyList())
                .build();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestBody final OrderDto orderDto) {
        return OrderDto.builder()
                .id(1L)
                .orderStatus("testing createOrder")
                .orderItemDtos(Collections.emptyList())
                .build();
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return OrderDto.builder()
                .id(1L)
                .orderStatus("testing updateOrder")
                .orderItemDtos(Collections.emptyList())
                .build();
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable Long id) {
        System.out.println("deleted order nr: " + id);
    }
}
