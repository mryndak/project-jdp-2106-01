package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.dto.OrderDto;
import com.kodilla.ecommerce.mapper.OrderMapper;
import com.kodilla.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    public List<OrderDto> getAllOrders() {
        return Optional.ofNullable(mapper.mapToOrderDtoList(repository.findAll())).orElse(Collections.emptyList());
    }

    /*        without throwing exception
    public OrderDto getOrderById(Long id) {
        return mapper.mapToOrderDto(repository.findById(id).get());
    }
 */

    public OrderDto getOrderById(Long id) throws OrderNotFoundException{
        return mapper.mapToOrderDto(repository.findById(id).orElseThrow(OrderNotFoundException::new));
    }

    //create order, send customer data, after that EMPTY CART
    public OrderDto createOrder(OrderDto orderDto) {
        OrderDto resultOrderDto = mapper.mapToOrderDto(repository.save(mapper.mapToOrder(orderDto)));

        if(resultOrderDto == null) {
            log.error(">> ERROR in running method: OrderService.createOrder() \n >>unable to create order nr: "+ orderDto.getId());
            return OrderDto.builder().build();
        }
        log.info(">> OK running method: OrderService.createOrder() \n >>created order nr: "+ resultOrderDto.getId());
        return resultOrderDto;
    }

    public OrderDto updateOrder(OrderDto orderDto) {
        OrderDto resultOrderDto = mapper.mapToOrderDto(repository.save(mapper.mapToOrder(orderDto)));

        if(resultOrderDto == null) {
            log.error(">> ERROR in running method: OrderService.updateOrder() \n >>unable to update order nr: "+ orderDto.getId());
            return OrderDto.builder().build();
        }
        log.info(">> OK running method: OrderService.updateOrder() \n >>updated order nr: "+ resultOrderDto.getId());
        return resultOrderDto;
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);

        if(repository.existsById(id)) {
            log.error(">> ERROR in running method: OrderService.deleteOrder() \n >>unable to delete order nr: "+ id);
        } else {
            log.info(">> OK running method: OrderService.deleteOrder() \n >>deleted order nr: "+ id);
        }
    }
}
