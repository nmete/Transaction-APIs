package com.cl.trasactionmanagement.service;

import com.cl.trasactionmanagement.dto.OrderRequest;
import com.cl.trasactionmanagement.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}
