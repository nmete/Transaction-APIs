package com.cl.trasactionmanagement.repository;

import com.cl.trasactionmanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
