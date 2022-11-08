package com.sharding.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class IncomeCountExtDo {
    /**
     * 支付方式
     */
    private String paywayId;
    /**
     * 订单金额
     */
    private BigDecimal orderAmount=BigDecimal.ZERO;
    /**
     * 订单数量
     */
    private Long orderCount=0L;
    private BigDecimal ownProfit=BigDecimal.ZERO;
}
