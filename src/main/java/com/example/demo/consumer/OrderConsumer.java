package com.example.demo.consumer;

import com.example.demo.Utils.SagaEvent;
import com.example.demo.dto.DebtOrderDto;
import com.example.demo.dto.OrderPayDebtDto;
import com.example.demo.processor.OrderProcessor;
import com.example.demo.service.DebtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

/**
 * Created by TuanPM on 2020-10-22.
 **/
@Component
@Slf4j
public class OrderConsumer {

    @Autowired
    private OrderProcessor orderProcessor;

    @Autowired
    private DebtService debtService;

    @StreamListener(target = OrderProcessor.INPUT, condition = "headers['type'] == '" + SagaEvent.PAY_ORDER_DEBT + "'")
    public void onPayOrderDebtRequest( @Payload @Valid DebtOrderDto data) {
        try {
            debtService.onPayOrderDebtRequest(data);
        } catch (Exception e) {
            OrderPayDebtDto debtOrderDto = new OrderPayDebtDto();
            debtOrderDto.setOrderId(data.getOrderId());
            if (!orderProcessor.output().send(MessageBuilder.withPayload(debtOrderDto)
                    .setHeader("type", SagaEvent.PAY_ORDER_DEBT_FAILED)
                    .build())) {
                // roll back
                System.out.println("errors");
            }
        }
    }
}
