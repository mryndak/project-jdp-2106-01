package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.OrderItem;
import com.kodilla.ecommerce.dto.OrderItemDto;
import com.kodilla.ecommerce.dto.ProductDto;
import com.kodilla.ecommerce.service.OrderNotFoundException;
import com.kodilla.ecommerce.service.OrderService;
import com.kodilla.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderItemMapper {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final OrderService orderService;
    private final OrderMapper orderMapper;

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
        ProductDto productDto = productService.getProductById(productId);

        try {
            return new OrderItem(
                    orderItemDto.getId(),
                    productId,
                    orderId,
                    orderItemDto.getName(),
                    orderItemDto.getPrice(),
                    orderItemDto.getQuantity(),
                    orderMapper.mapToOrder(orderService.getOrderById(orderId)),
                    productMapper.mapToProduct(productDto)
            );
        } catch (OrderNotFoundException e) {
            log.error(">> running method: OrderItemMapper.mapToOrderItem()" + "\n>>"+ e.getMessage());
            return OrderItem.builder().build();
        }
    }

    public List<OrderItemDto> mapToOrderItemDtoList(List<OrderItem> orderItems) {
        return orderItems.stream()
                .map(this::mapToOrderItemDto)
                .collect(Collectors.toList());
    }

    public List<OrderItem> mapToOrderItemList(List<OrderItemDto> orderItemDtos) {
        return orderItemDtos.stream()
                .map(this::mapToOrderItem)
                .collect(Collectors.toList());
    }
}
