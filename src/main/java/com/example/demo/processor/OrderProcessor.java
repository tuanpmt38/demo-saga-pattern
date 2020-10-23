package com.example.demo.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by TuanPM on 2020-10-22.
 **/
public interface OrderProcessor {

    String INPUT = "debt-service";
    String OUTPUT = "order-service";

    @Input(OrderProcessor.INPUT)
    SubscribableChannel input();

    @Output(OrderProcessor.OUTPUT)
    MessageChannel output();
}
