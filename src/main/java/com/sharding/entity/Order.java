package com.sharding.entity;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;


@Data
public class Order {
    /**
     * 旺铺管家订单号
     */
    private String orderId;

    /**
     * 通道方商户订单号
     */
    private String gatewayMerchantOrderId;

    /**
     * 接口传入订单号
     */
    private String merchantOrderId;

    /**
     * 商户id
     */
    private String merchantId;

    /**
     * 设备(SN)号
     */
    private String deviceNo;

    /**
     * 代理NO
     */
    private Integer agentNo;

    /**
     * 代理层级
     */
    private String agentNoTree;

    /**
     * 代理层级
     */
    private Integer agentLevel;

    /**
     * 支付方式
     */
    private String paywayId;

    /**
     * openId
     */
    private String customerId;

    /**
     * 订单金额
     */
    private BigDecimal orderAmount;

    /**
     * 实际到账金额
     */
    private BigDecimal orderActualAmount;

    /**
     * 支付状态: 0-初始化,1-已支付,2-未支付,3-支付失败,4-支付超时,5-已退款,6-部分退款
     */
    private Boolean orderStatus;

    /**
     * 实际手续费金额（支付金额*费率）
     */
    private BigDecimal orderFee;

    /**
     * 基础费率
     */
    private BigDecimal orderRate;

    /**
     * 手续费下限
     */
    private BigDecimal orderMin;

    /**
     * 手续费上限
     */
    private BigDecimal orderMax;

    /**
     * 项目Id
     */
    private String projectNo;

    /**
     * 活动Id
     */
    private Integer activityId;

    /**
     * 是否是银联小额，0-否/1-是
     */
    private Boolean unionpayOffers;

    /**
     * 减免手续费金额
     */
    private BigDecimal annulFee;

    /**
     * 结算方式
     */
    private String settleType;

    /**
     * 是否冻结交易，0-否，1-是
     */
    private Boolean isFreeze;

    /**
     * 请求时间(请求时间yyyyMMddhhmmssSSS形式)
     */
    private String orderTime;

    /**
     * 支付成功时间(yyyyMMddhhmmssSSS)
     */
    private String payTime;

    /**
     * 订单日期(yyyyMMdd)
     */
    private String orderDate;

    /**
     * 组织结构编号
     */
    private Integer orgStructId;

    /**
     * 渠道经理编号
     */
    private Integer cmId;

    /**
     * 组织结构树
     */
    private String orgStructTree;

    /**
     * 业务员编号
     */
    private Integer bmId;

    /**
     * 支付渠道
     */
    private String payChannel;

    /**
     * 交易应答码
     */
    private String replyCode;

    /**
     * 交易反馈结果
     */
    private String replyMsg;

    /**
     * 创建时间(yyyy-MM-dd HH:mm:ss)
     */
    private LocalDateTime createTime;

    /**
     * 修改时间(yyyy-MM-dd HH:mm:ss)
     */
    private LocalDateTime updateTime;
}

