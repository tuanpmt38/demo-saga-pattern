package com.example.demo.service;

import com.example.demo.dto.OrderDto;
import com.example.demo.dto.OrderEditDto;
import com.example.demo.dto.OrderPayDebtDto;
import com.example.demo.entity.Order;

/**
 * Created by TuanPM on 2020-10-22.
 **/
public interface OrderService {

    Order create(OrderDto data);

    void onPayOrderDebtFailed(OrderPayDebtDto response);

    void update(OrderEditDto data);
}
