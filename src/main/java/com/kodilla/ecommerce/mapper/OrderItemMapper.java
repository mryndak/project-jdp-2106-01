package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.Order;
import com.kodilla.ecommerce.domain.OrderItem;
import com.kodilla.ecommerce.domain.Product;
import com.kodilla.ecommerce.dto.OrderDto;
import com.kodilla.ecommerce.dto.OrderItemDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderItemMapper {

    public OrderItemDto mapToOrderItemDto(OrderItem orderItem) {

        return new OrderItemDto(
                orderItem.getId(),
                orderItem.getProduct().getId(),
                orderItem.getOrder().getId(),
                orderItem.getName(),
                orderItem.getPrice(),
                orderItem.getQuantity()
        );
    }


    public OrderItem mapToOrderItem(OrderItemDto orderItemDto) {

        Long productId = orderItemDto.getProductId();
        Long orderId = orderItemDto.getOrderId();

        return new OrderItem(
                orderItemDto.getId(),
                productId,
                orderId,
                orderItemDto.getName(),
                orderItemDto.getPrice(),
                orderItemDto.getQuantity(),
                new Order(),   //orderService.getOrder(orderId);
                new Product()  //productService.getProduct(productId);
        );
    }

    public List<OrderItemDto> mapToOrderItemDtoList(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(this::mapToOrderItemDto)
                .collect(Collectors.toList());
    }
}
