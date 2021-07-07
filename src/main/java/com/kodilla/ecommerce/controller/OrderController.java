package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.domain.OrderStatus;
import com.kodilla.ecommerce.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping(value = "/v1/order")
public class OrderController {

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    @GetMapping( value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public OrderDto getOrder(@PathVariable Long id) {
        return null;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestBody final OrderDto orderDto) {
        return null;
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrder(@PathVariable Long id) {
        System.out.println("deleted order nr: " + id);
    }
}
