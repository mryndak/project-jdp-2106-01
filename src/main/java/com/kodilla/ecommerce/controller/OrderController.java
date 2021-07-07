package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.domain.OrderStatus;
import com.kodilla.ecommerce.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/v1/order")
public class OrderController {

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<OrderDto> getOrders() {
        return Arrays.asList(
                OrderDto.builder()
                        .id(1L)
                        .userId(1L)
                        .cartId(1L)
                        .orderStatus(OrderStatus.NOT_PAID)
                        .totalPrice(new BigDecimal("123"))
                        .orderDate(LocalDate.of(2021, 6, 26))
                        .orderItemDtos(Collections.emptyList())
                        .build()
        );
    }

    @GetMapping( value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public OrderDto getOrder(@PathVariable Long id) {
        return OrderDto.builder()
                .id(1L)
                .orderStatus(OrderStatus.NOT_PAID)
                .orderItemDtos(Collections.emptyList())
                .build();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestBody final OrderDto orderDto) {
        return OrderDto.builder()
                .id(1L)
                .orderStatus(OrderStatus.NOT_PAID)
                .orderItemDtos(Collections.emptyList())
                .build();
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return OrderDto.builder()
                .id(1L)
                .orderStatus(OrderStatus.NOT_PAID)
                .orderItemDtos(Collections.emptyList())
                .build();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrder(@PathVariable Long id) {
        System.out.println("deleted order nr: " + id);
    }
}