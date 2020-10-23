package com.example.demo.consumer;

import com.example.demo.Utils.SagaEvent;
import com.example.demo.dto.OrderPayDebtDto;
import com.example.demo.processor.DebtProcessor;
import com.example.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Created by TuanPM on 2020-10-22.
 **/
@Component
@Slf4j
public class OrderConsumer {

    @Autowired
    private OrderService orderService;

    @StreamListener(target = DebtProcessor.INPUT, condition = "headers['type'] == '" + SagaEvent.PAY_ORDER_DEBT_FAILED + "'")
    public void onPayOrderDebtFailed(@Payload OrderPayDebtDto response) {
        orderService.onPayOrderDebtFailed(response);
    }

}
