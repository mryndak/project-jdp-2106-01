package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.dto.OrderDto;
import com.kodilla.ecommerce.service.OrderNotFoundException;
import com.kodilla.ecommerce.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/order")
public class OrderController {

    private final OrderService service;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<OrderDto> getOrders() {
        List<OrderDto> resultList = service.getAllOrders();
        log.info(">> running method: OrderController.getOrders() \n>> Order list size: " + resultList.size());
        return resultList;
    }

    @GetMapping( value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public OrderDto getOrder(@PathVariable Long id) {
        try {
            OrderDto resultOrderDto = service.getOrderById(id);
            log.info(">> OK running method: OrderController.getOrder() \n >>orderId: "+ resultOrderDto.getId());
            return resultOrderDto;
        } catch (OrderNotFoundException e) {
            log.error(">> ERROR in running method: OrderController.getOrder()" + "\n>>"+ e.getMessage());
            return OrderDto.builder().build();
        }
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public OrderDto createOrder(@RequestBody final OrderDto orderDto) { //todo czy ma być void?
        return service.createOrder(orderDto);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return service.updateOrder(orderDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrder(@PathVariable Long id) {
        log.info(">> running method: OrderController.deleteOrder() \n>> Order id number: " + id);
        service.deleteOrder(id);
    }
}
