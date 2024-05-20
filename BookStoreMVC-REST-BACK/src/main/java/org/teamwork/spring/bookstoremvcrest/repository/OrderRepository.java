package org.teamwork.spring.bookstoremvcrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.teamwork.spring.bookstoremvcrest.model.Costumer;
import org.teamwork.spring.bookstoremvcrest.model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByCostumer(Costumer costumer);
}
