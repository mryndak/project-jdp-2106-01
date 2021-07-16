package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {   //todo remove class if unnecessary

    List<OrderItem> getByOrderId(Long id);
}
