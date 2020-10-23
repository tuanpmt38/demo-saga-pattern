package com.example.demo.service.impl;

import com.example.demo.Utils.SagaEvent;
import com.example.demo.dto.DebtOrderDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.dto.OrderEditDto;
import com.example.demo.dto.OrderPayDebtDto;
import com.example.demo.entity.Order;
import com.example.demo.processor.DebtProcessor;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by TuanPM on 2020-10-22.
 **/
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private DebtProcessor debtProcessor;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order create(OrderDto data) {

        Order order = Order.builder()
                .preTotalAmount(data.getPreTotalAmount())
                .totalAmount(data.getTotalAmount())
                .vat(data.getVat())
                .build();
        orderRepository.save(order);

        //update debt
        DebtOrderDto debtOrder = DebtOrderDto.builder()
                .orderId(order.getId())
                .totalAmountDebt(order.getTotalAmount())
                .build();


        if (!debtProcessor.output().send(MessageBuilder.withPayload(debtOrder)
                .setHeader("type", SagaEvent.PAY_ORDER_DEBT)
                .build())) {
            // roll back
            System.out.println("error");
        }
        return order;
    }

    @Override
    public void onPayOrderDebtFailed(OrderPayDebtDto response) {

        if (response == null){
            System.out.println("data null");
        }

        Order order = orderRepository.findById(response.getOrderId()).get();
        order.setTotalAmount(order.getTotalAmount().subtract(response.getTotalAmountDebt()));
        orderRepository.save(order);

    }

    @Override
    public void update(OrderEditDto data) {

        Order order = orderRepository.findById(data.getId()).get();
        BeanUtils.copyProperties(data, order);
        orderRepository.save(order);

        //update debt
        DebtOrderDto debtOrder = DebtOrderDto.builder()
                .orderId(order.getId())
                .totalAmountDebt(order.getTotalAmount())
                .build();

        if (!debtProcessor.output().send(MessageBuilder.withPayload(debtOrder)
                .setHeader("type", SagaEvent.PAY_ORDER_DEBT)
                .build())) {
            // roll back
            System.out.println("error");
        }

    }
}
