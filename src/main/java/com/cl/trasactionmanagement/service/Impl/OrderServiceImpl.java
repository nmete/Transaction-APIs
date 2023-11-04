package com.cl.trasactionmanagement.service.Impl;

import com.cl.trasactionmanagement.dto.OrderRequest;
import com.cl.trasactionmanagement.dto.OrderResponse;
import com.cl.trasactionmanagement.entity.Order;
import com.cl.trasactionmanagement.entity.Payment;
import com.cl.trasactionmanagement.exception.PaymentException;
import com.cl.trasactionmanagement.repository.OrderRepository;
import com.cl.trasactionmanagement.repository.PaymentRepository;
import com.cl.trasactionmanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order= orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOderTrackingNumber(UUID.randomUUID().toString());
        Payment payment= orderRequest.getPayment();
        orderRepository.save(order);

        if(!payment.getType().equals("DEBIT")){
            throw  new PaymentException("Card is  not suppported");
        }

        paymentRepository.save(payment);
        OrderResponse orderResponse= new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOderTrackingNumber());
        orderResponse.setStatus("SUCCESS");
        orderResponse.setMessage(order.getStatus());

        return orderResponse;
    }
}
