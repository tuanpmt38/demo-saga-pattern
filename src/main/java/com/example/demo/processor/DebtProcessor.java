package com.example.demo.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by TuanPM on 2020-10-22.
 **/
public interface DebtProcessor {

    String INPUT = "order-service";
    String OUTPUT = "debt-service";

    @Input(DebtProcessor.INPUT)
    SubscribableChannel input();

    @Output(DebtProcessor.OUTPUT)
    MessageChannel output();
}
