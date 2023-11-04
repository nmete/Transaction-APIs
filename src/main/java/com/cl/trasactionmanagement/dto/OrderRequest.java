package com.cl.trasactionmanagement.dto;

import com.cl.trasactionmanagement.entity.Order;
import com.cl.trasactionmanagement.entity.Payment;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.OrderComparator;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
