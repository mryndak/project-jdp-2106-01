package com.kodilla.ecommerce.mapper;

import com.kodilla.ecommerce.domain.Order;
import com.kodilla.ecommerce.domain.OrderItem;
import com.kodilla.ecommerce.domain.User;
import com.kodilla.ecommerce.dto.OrderDto;
import com.kodilla.ecommerce.dto.OrderItemDto;
import com.kodilla.ecommerce.dto.ProductDto;
import com.kodilla.ecommerce.repository.OrderRepository;
import com.kodilla.ecommerce.repository.UserRepository;
import com.kodilla.ecommerce.service.ProductService;
import com.kodilla.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final UserRepository userRepository;
   // private final ProductService productService;
  //  private final ProductMapper productMapper;
  //  private final OrderRepository orderRepository;

    public OrderDto mapToOrderDto(Order order) {

        List<OrderItem> orderItems = order.getOrderItems();

        return OrderDto.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .cartId(order.getCartId())
                .orderStatus(order.getOrderStatus())
                .totalPrice(order.getTotalPrice())
                .orderDate(order.getOrderDate())
                .orderItemDtos(this.mapToOrderItemDtoList(orderItems))
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
                this.mapToOrderItemList(orderItemDtos),
                userRepository.getUserById(orderDto.getUserId())
        );
    }

    public List<OrderDto> mapToOrderDtoList(List<Order> orders) {
        return orders.stream()
                .map(this::mapToOrderDto)
                .collect(Collectors.toList());
    }

    public List<Order> mapToOrderList(List<OrderDto> orderDtos) {
        return orderDtos.stream()
                .map(this::mapToOrder)
                .collect(Collectors.toList());
    }

    public OrderItemDto mapToOrderItemDto(OrderItem orderItem) {

        return new OrderItemDto(
                orderItem.getId(),
                orderItem.getProduct().getId(),
               // orderItem.getOrder().getId(),
                orderItem.getName(),
                orderItem.getPrice(),
                orderItem.getQuantity()
        );
    }

    public OrderItem mapToOrderItem(OrderItemDto orderItemDto) {

        return OrderItem.builder()
                .id(orderItemDto.getId())
                .name(orderItemDto.getName())
                .price(orderItemDto.getPrice())
                .quantity(orderItemDto.getQuantity())
                .build();

        /* Long productId = orderItemDto.getProductId();
       // Long orderId = orderItemDto.getOrderId();
        //ProductDto productDto = productService.getProductById(productId);
        //Order order = orderRepository.findById(orderId).orElse(Order.builder().build());

        return new OrderItem(
                orderItemDto.getId(),
                productId,
                //orderId,
                orderItemDto.getName(),
                orderItemDto.getPrice(),
                orderItemDto.getQuantity()
               // order,
              //  productMapper.mapToProduct(productDto)
        ); */
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
