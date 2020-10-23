package com.example.demo;

import com.example.demo.processor.DebtProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding({DebtProcessor.class})
public class OrderServiceTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceTestApplication.class, args);
    }

}
