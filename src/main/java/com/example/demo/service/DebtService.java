package com.example.demo.service;

import com.example.demo.dto.DebtOrderDto;

/**
 * Created by TuanPM on 2020-10-22.
 **/
public interface DebtService {

    void onPayOrderDebtRequest(DebtOrderDto data);

}
