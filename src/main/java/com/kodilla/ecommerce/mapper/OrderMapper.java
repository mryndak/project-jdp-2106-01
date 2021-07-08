package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.Order;
import com.kodilla.ecommerce.domain.OrderItem;
import com.kodilla.ecommerce.domain.User;
import com.kodilla.ecommerce.dto.OrderDto;
import com.kodilla.ecommerce.dto.OrderItemDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class OrderMapper {

    OrderItemMapper orderItemMapper;

    public OrderDto mapToOrderDto(Order order) {

        List<OrderItem> orderItems = order.getOrderItems();

        return OrderDto.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .cartId(order.getCartId())
                .orderStatus(order.getOrderStatus())
                .totalPrice(order.getTotalPrice())
                .orderDate(order.getOrderDate().toString())
                .orderItemDtos(orderItemMapper.mapToOrderItemDtoList(orderItems))
                .build();
    }


    public Order mapToOrder(OrderDto orderDto) {

        List<OrderItemDto> orderItemDtos = orderDto.getOrderItemDtos();

        return new Order(
                orderDto.getId(),
                orderDto.getUserId(),
                orderDto.getCartId(),
                orderDto.getOrderStatus(),
                orderDto.getTotalPrice(),
                LocalDate.parse(orderDto.getOrderDate()),
                orderItemMapper.mapToOrderItemList(orderItemDtos),
                new User() // userService.getUser(orderDto.getUserId())
        );
    }
}
