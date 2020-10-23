package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by TuanPM on 2020-10-23.
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrDto {
    private String err;
}
