package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.Order;
import com.kodilla.ecommerce.domain.OrderItem;
import com.kodilla.ecommerce.domain.User;
import com.kodilla.ecommerce.dto.OrderDto;
import com.kodilla.ecommerce.dto.OrderItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderItemMapper orderItemMapper;

    public OrderDto mapToOrderDto(Order order) {

        List<OrderItem> orderItems = order.getOrderItems();

        return OrderDto.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .cartId(order.getCartId())
                .orderStatus(order.getOrderStatus())
                .totalPrice(order.getTotalPrice())
                .orderDate(order.getOrderDate())
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
                orderDto.getOrderDate(),
                orderItemMapper.mapToOrderItemList(orderItemDtos),
                new User() //ToDo userService.getUser(orderDto.getUserId())
        );
    }

    public List<OrderDto> mapToOrderDtoList(List<Order> orders) {
        return orders.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
