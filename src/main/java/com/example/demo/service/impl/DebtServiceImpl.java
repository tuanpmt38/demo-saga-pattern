package com.example.demo.service.impl;

import com.example.demo.Utils.SagaEvent;
import com.example.demo.dto.DebtOrderDto;
import com.example.demo.dto.ErrDto;
import com.example.demo.dto.OrderPayDebtDto;
import com.example.demo.entity.DebtOrder;
import com.example.demo.processor.OrderProcessor;
import com.example.demo.repository.DebtRepository;
import com.example.demo.service.DebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * Created by TuanPM on 2020-10-22.
 **/
@Service
@Transactional
public class DebtServiceImpl implements DebtService {

    @Autowired
    private DebtRepository debtRepository;

    @Autowired
    private OrderProcessor orderProcessor;

    @Override
    public void onPayOrderDebtRequest(DebtOrderDto data) {

        DebtOrder debtOrders = debtRepository.findByIdOrderId(data.getOrderId());
        if (debtOrders == null){
            OrderPayDebtDto debtOrderDto = new OrderPayDebtDto();
            debtOrderDto.setOrderId(data.getOrderId());
            debtOrderDto.setTotalAmountDebt(data.getTotalAmountDebt());
            if (!orderProcessor.output().send(MessageBuilder.withPayload(debtOrderDto)
                    .setHeader("type", SagaEvent.PAY_ORDER_DEBT_FAILED)
                    .build())) {
                // roll back
                System.out.println("err");
            }
        }else {
            DebtOrder debtOrder = DebtOrder.builder()
                    .orderId(data.getOrderId())
                    .totalAmountDebt(data.getTotalAmountDebt())
                    .build();
            debtRepository.save(debtOrder);
        }



    }
}
