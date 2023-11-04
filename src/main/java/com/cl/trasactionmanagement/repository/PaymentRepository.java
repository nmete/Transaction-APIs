package com.cl.trasactionmanagement.repository;

import com.cl.trasactionmanagement.entity.Order;
import com.cl.trasactionmanagement.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
