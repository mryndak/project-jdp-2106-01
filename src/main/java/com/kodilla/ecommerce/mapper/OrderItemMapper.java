package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.Order;
import com.kodilla.ecommerce.domain.OrderItem;
import com.kodilla.ecommerce.dto.OrderDto;
import com.kodilla.ecommerce.dto.OrderItemDto;
import com.kodilla.ecommerce.dto.ProductDto;
import com.kodilla.ecommerce.repository.OrderRepository;
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
    private final OrderRepository orderRepository;

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
        Order order = orderRepository.findById(orderId).orElse(Order.builder().build());

        return new OrderItem(
                orderItemDto.getId(),
                productId,
                orderId,
                orderItemDto.getName(),
                orderItemDto.getPrice(),
                orderItemDto.getQuantity(),
                order,
                productMapper.mapToProduct(productDto)
        );
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
