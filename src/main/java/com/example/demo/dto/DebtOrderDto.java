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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DebtOrderDto {

    private Long orderId;

    private BigDecimal totalAmountDebt;
}
