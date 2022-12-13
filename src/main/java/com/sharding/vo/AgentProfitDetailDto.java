package com.sharding.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 代理分润--直属代理祥情
 * 
 * @author
 *
 */
@Setter
@Getter
public class AgentProfitDetailDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 代理ID
	 */
	private String agentId;
	/**
	 * 商户编号
	 */
	private String merchantId;
	/**
	 * 代理名称
	 */
	private String agentName;
	/**
	 * 代理级别
	 */
	private Integer level;
	/**
	 * 付款类别
	 */
	private String  paywayType;
	/**
	 * 结算类型
	 */
	private String  settleType;
	
	/**
	 * 付款类别主键ID
	 */
	private String paywayId;
	/**
	 * 支付方式
	 */
	private String paywayName;
	/**
	 * 成功交易金额
	 */
	private BigDecimal successAmount;
	/**
	 * 成功交易手续费
	 */
	private BigDecimal successFee;
	/**
	 * 成功交易笔数
	 */
	private Long successCount;

	/**
	 * 我的分润比
	 */
	private BigDecimal discountRate;
	/**
	 * 总收益 
	 */
	private BigDecimal totalProfit;
	/**
	 * 净收益 
	 */
	private BigDecimal ownProfit;
	//减免手续费总交易金额
	private BigDecimal annulOrderAmount;
	//减免手续费笔数
	private Long annulOrderCount;
	private String agentTree;
	private Integer agentNo;
	private String agentNoTree;
	private String orderRate;

	private BigDecimal refundAmount;

	private BigDecimal mercRateVal;
	private Integer mercRateUnit;
	private BigDecimal agentRateVal;
	private String directAgentId;
	private Integer directAgentNo;

	@Override
	public String toString() {
		return "AgentProfitDetailDto{" +
				"agentId='" + agentId + '\'' +
				", merchantId='" + merchantId + '\'' +
				", agentName='" + agentName + '\'' +
				", level=" + level +
				", paywayType='" + paywayType + '\'' +
				", settleType='" + settleType + '\'' +
				", paywayId='" + paywayId + '\'' +
				", paywayName='" + paywayName + '\'' +
				", successAmount=" + successAmount +
				", successFee=" + successFee +
				", successCount=" + successCount +
				", discountRate=" + discountRate +
				", totalProfit=" + totalProfit +
				", ownProfit=" + ownProfit +
				", annulOrderAmount=" + annulOrderAmount +
				", annulOrderCount=" + annulOrderCount +
				", agentTree='" + agentTree + '\'' +
				", agentNo=" + agentNo +
				", agentNoTree='" + agentNoTree + '\'' +
				", orderRate='" + orderRate + '\'' +
				", refundAmount=" + refundAmount +
				", mercRateVal=" + mercRateVal +
				", mercRateUnit=" + mercRateUnit +
				", agentRateVal=" + agentRateVal +
				", directAgentId='" + directAgentId + '\'' +
				", directAgentNo=" + directAgentNo +
				'}';
	}
}
