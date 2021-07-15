package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.domain.Order;
import com.kodilla.ecommerce.domain.OrderItem;
import com.kodilla.ecommerce.domain.Product;
import com.kodilla.ecommerce.dto.OrderDto;
import com.kodilla.ecommerce.dto.OrderItemDto;
import com.kodilla.ecommerce.mapper.OrderMapper;
import com.kodilla.ecommerce.repository.OrderRepository;
import com.kodilla.ecommerce.repository.ProductRepository;
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
    private final ProductRepository productRepository;

    public List<OrderDto> getAllOrders() {
        List<OrderDto> resultList = Optional.ofNullable(mapper.mapToOrderDtoList(repository.findAll())).orElse(Collections.emptyList());

        if(resultList.size() == 0) {
            log.warn(">> WARNING in running method: OrderService.getAllOrders() \n >>result list is EMPTY: ");
            return resultList;
        }

        log.info(">> OK running method: OrderService.getAllOrders() \n >>result list size: " + resultList.size());
        return resultList;
    }

    public OrderDto getOrderById(Long id) throws OrderNotFoundException{
        return mapper.mapToOrderDto(repository.findById(id).orElseThrow(OrderNotFoundException::new));
    }

    //create order, log customer's data, after that EMPTY CART
    public OrderDto createOrder(OrderDto orderDto) {

        if (repository.existsById(orderDto.getId())) {
            return this.updateOrder(orderDto);
        }

        Order savedOrder = repository.save(mapper.mapToOrder(orderDto));

        Long cartId = savedOrder.getCartId();
        Long userId = savedOrder.getUser().getId();
        String userLogin = savedOrder.getUser().getUserLogin();
        List<OrderItemDto> itemDtosFromOrderDto = orderDto.getOrderItemDtos();
        List<OrderItem> updateOrderItems = savedOrder.getOrderItems();

        //updating orderItems list with correct "Order order" and "Product product"
        for (int i = 0; i < updateOrderItems.size(); i++) {
            Long productId = itemDtosFromOrderDto.get(i).getProductId();
            Product product = productRepository.findById(productId).orElse(null);  //Todo - czy lepiej new Product() zamiast null
            updateOrderItems.get(i).setProduct(product);
            updateOrderItems.get(i).setOrder(savedOrder);
        }

        savedOrder.setOrderItems(updateOrderItems);
        repository.save(savedOrder);

        OrderDto resultOrderDto = mapper.mapToOrderDto(savedOrder);

        if(resultOrderDto == null || !repository.existsById(resultOrderDto.getId())) {
            log.error(">> ERROR in running method: OrderService.createOrder() " +
                    "\n >>unable to create order for userId: " + orderDto.getUserId() +
                    " and cart: " + orderDto.getCartId());
            return OrderDto.builder().build();
        }

        //ToDo atach  cart service.removeById(cartId) - empty cart

        log.info(">> OK running method: OrderService.createOrder() \n >>created order nr: "+ resultOrderDto.getId()
        + " for USER ID: " + userId + " and username: " + userLogin);
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
