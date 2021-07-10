package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.Order;
import com.kodilla.ecommerce.domain.OrderItem;
import com.kodilla.ecommerce.domain.OrderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class OrderRepositoryTestSuite {

    @Autowired      //without Autowired is NullPointer - repository not assigned
    private OrderRepository repository;

    @Test
    void TestSave() {
        //Given
        OrderItem orderItem1 = OrderItem.builder()
                .productId(1L).orderId(1L).name("test OrderItem1").price(10).quantity(1).build();

        OrderItem orderItem2 = OrderItem.builder()
                .productId(2L).orderId(2L).name("test OrderItem2").price(20).quantity(1).build();

        OrderItem orderItem3 = OrderItem.builder()
                .productId(3L).orderId(3L).name("test OrderItem3").price(30).quantity(1).build();

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem1);
        orderItems.add(orderItem2);
        orderItems.add(orderItem3);

        Order testOrder = Order.builder()
                .userId(7L).cartId(11L).orderStatus(OrderStatus.NOT_PAID)
                .totalPrice(new BigDecimal("234")).orderDate(LocalDate.of(2021, 7, 10))
                .orderItems(orderItems).build();

        //When
        System.out.println(">>>>>>>>>> START elements in repo: " + repository.count());
        repository.save(testOrder);

        //Then
        Long id = testOrder.getId();
        Optional<Order> readOrder = repository.findById(id);
        assertTrue(readOrder.isPresent());
        System.out.println(">>>>>>>>>> BEFORE CLEAN elements in repo: " + repository.count());
        System.out.println("<<<<<<<>>>>>> " + readOrder.get().getOrderDate());

        //Clean
        repository.deleteById(id);
        System.out.println(">>>>>>>>>> AFTER CLEAN elements in repo: " + repository.count());
    }
}
