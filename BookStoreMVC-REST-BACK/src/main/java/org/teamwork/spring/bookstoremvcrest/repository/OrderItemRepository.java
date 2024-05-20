package org.teamwork.spring.bookstoremvcrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamwork.spring.bookstoremvcrest.model.Costumer;
import org.teamwork.spring.bookstoremvcrest.model.OrderItem;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findAllByOrder_Costumer(Costumer costumer);
}
