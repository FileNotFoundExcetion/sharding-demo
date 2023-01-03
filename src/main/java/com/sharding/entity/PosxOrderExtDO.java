package com.sharding.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author
 * @Date
 */
@Data
public class PosxOrderExtDO {

    private String orderTime;

    private BigDecimal orderAddValueFee=BigDecimal.ZERO;

    private BigDecimal orderAddValueRate=BigDecimal.ZERO;

    private String payTime;

    private String orderId;

    /**
     * 原订单号
     * */
    private String oriOrderId;

    private BigDecimal orderAmount=BigDecimal.ZERO;

    private BigDecimal orderRate=BigDecimal.ZERO;

    private BigDecimal orderFee=BigDecimal.ZERO;

    private Integer orderStatus;

    private String yinlianMerchantNo;

    private String merchantNo;

    private String merchantName;

    private String deviceNo;

    private Integer activityId;

    private String customerId;

    private BigDecimal annulFee=BigDecimal.ZERO;

    private String deviceName;

    private Integer deviceType;

    private String replyCode;

    private String replyMsg;

    private String settleType;

    private String paywayId;

    private String merchantId;

    private String agentNo;

    private String agentNoTree;

    private Integer isFreeze;

    private BigDecimal addValueFee=BigDecimal.ZERO;

    private BigDecimal addValueRate;
}
