package com.sharding.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private BigDecimal score;

    private BigDecimal score1;

    private BigDecimal score2;

    private BigDecimal result;


}
