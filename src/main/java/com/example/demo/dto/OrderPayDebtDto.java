package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by TuanPM on 2020-10-22.
 **/
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPayDebtDto {
    private String error;
    private Long orderId;
    private BigDecimal totalAmountDebt;
}
