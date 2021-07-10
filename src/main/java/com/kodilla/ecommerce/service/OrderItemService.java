package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.dto.OrderItemDto;
import com.kodilla.ecommerce.mapper.OrderItemMapper;
import com.kodilla.ecommerce.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository repository;
    private final OrderItemMapper mapper;

    public List<OrderItemDto> getAllOrderItems() {
        return mapper.mapToOrderItemDtoList(repository.findAll());
    }

    public OrderItemDto getOrderItemById(Long id) throws OrderItemNotFoundException {

        return mapper.mapToOrderItemDto(repository.findById(id).orElseThrow(OrderItemNotFoundException::new));
    }

    public List<OrderItemDto> getOrderItemsByOrderId(Long id) {
        return mapper.mapToOrderItemDtoList(repository.getByOrderId(id));
    }

    public OrderItemDto createOrderItem(OrderItemDto orderItemDto) {
        return mapper.mapToOrderItemDto(repository.save(mapper.mapToOrderItem(orderItemDto)));
    }

    public OrderItemDto updateOrderItem(OrderItemDto orderItemDto) {
        return mapper.mapToOrderItemDto(repository.save(mapper.mapToOrderItem(orderItemDto)));
    }

    public void deleteOrderItem(Long id) {
        repository.deleteById(id);
    }
}
