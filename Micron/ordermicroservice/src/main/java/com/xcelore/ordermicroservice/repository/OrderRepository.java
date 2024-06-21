package com.xcelore.ordermicroservice.repository;

import com.xcelore.ordermicroservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}