package com.sharding.entity;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 支付订单表
 * </p>
 *
 * @author xp
 * @since 2020-11-26
 */
@Data
@ToString

public class PosxOrder  {

    private static final long serialVersionUID = 1L;

    /**
     * 融智付订单号
     */

    private String orderId;


    private String oriOrderId;

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


    private String merchantNo;


    private String merchantName;

    /**
     * 设备(SN)号
     */

    private String deviceNo;


    private Integer deviceType;


    private String deviceName;


    private Integer agentNo;


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
     * 顾客ID
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

    private Integer orderStatus;
    /**
     * 实际手续费金额（支付金额*费率）
     */

    private BigDecimal orderFee;
    /**
     * 费率
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


    private String projectNo;

    /**
     * 活动类型,0-正常，1-100元减免
     */

    private String activityId;


    private Integer unionpayOffers;

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

    private String isFreeze;

    /**
     * 请求时间(请求时间yyyyMMddhhmmssSSS形式)
     */

    private String orderTime;

    /**
     * 支付成功时间(yyyyMMddhhmmssSSS)
     */
    private String payTime;

    private String orderDate;

    private String cardType;

    private Integer orgStructId;

    private Integer cmId;

    private String orgStructTree;

    private Integer bmId;

    private String payChannel;

    private String gatewayRefundNo;

    private String chTrackingNo;

    private String topGatewayRefundNo;

    /**
     * 交易应答码
     */
    private String replyCode;
    /**
     * 交易反馈结果
     */
    private String replyMsg;

    private String longlatitude;


    /**
     * 创建时间(yyyy-MM-dd HH:mm:ss)
     */
    private Date createTime;
    /**
     * 修改时间(yyyy-MM-dd HH:mm:ss)
     */
    private Date updateTime;


}
