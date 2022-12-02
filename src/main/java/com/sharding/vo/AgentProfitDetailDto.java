package com.sharding.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 代理分润--直属代理祥情
 * 
 * @author songzeye
 *
 */
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

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getPaywayName() {
		return paywayName;
	}

	public void setPaywayName(String paywayName) {
		this.paywayName = paywayName;
	}

	public BigDecimal getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(BigDecimal discountRate) {
		this.discountRate = discountRate;
	}

	public BigDecimal getSuccessAmount() {
		return successAmount;
	}

	public void setSuccessAmount(BigDecimal successAmount) {
		this.successAmount = successAmount;
	}

	public BigDecimal getSuccessFee() {
		return successFee;
	}

	public void setSuccessFee(BigDecimal successFee) {
		this.successFee = successFee;
	}

	public Long getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(Long successCount) {
		this.successCount = successCount;
	}

	public BigDecimal getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(BigDecimal totalProfit) {
		this.totalProfit = totalProfit;
	}

	public BigDecimal getOwnProfit() {
		return ownProfit;
	}

	public void setOwnProfit(BigDecimal ownProfit) {
		this.ownProfit = ownProfit;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getPaywayType() {
		return paywayType;
	}

	public void setPaywayType(String paywayType) {
		this.paywayType = paywayType;
	}

	public String getPaywayId() {
		return paywayId;
	}

	public void setPaywayId(String paywayId) {
		this.paywayId = paywayId;
	}

	public BigDecimal getAnnulOrderAmount() {
		return annulOrderAmount;
	}

	public void setAnnulOrderAmount(BigDecimal annulOrderAmount) {
		this.annulOrderAmount = annulOrderAmount;
	}

	public Long getAnnulOrderCount() {
		return annulOrderCount;
	}

	public void setAnnulOrderCount(Long annulOrderCount) {
		this.annulOrderCount = annulOrderCount;
	}

	public String getAgentTree() {
		return agentTree;
	}

	public void setAgentTree(String agentTree) {
		this.agentTree = agentTree;
	}

	public String getSettleType() {
		return settleType;
	}

	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}

	public String getOrderRate() {
		return orderRate;
	}

	public void setOrderRate(String orderRate) {
		this.orderRate = orderRate;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public BigDecimal getMercRateVal() {
		return mercRateVal;
	}

	public void setMercRateVal(BigDecimal mercRateVal) {
		this.mercRateVal = mercRateVal;
	}

	public Integer getMercRateUnit() {
		return mercRateUnit;
	}

	public void setMercRateUnit(Integer mercRateUnit) {
		this.mercRateUnit = mercRateUnit;
	}

	public BigDecimal getAgentRateVal() {
		return agentRateVal;
	}

	public void setAgentRateVal(BigDecimal agentRateVal) {
		this.agentRateVal = agentRateVal;
	}

	public Integer getAgentNo() {
		return agentNo;
	}

	public void setAgentNo(Integer agentNo) {
		this.agentNo = agentNo;
	}

	public String getAgentNoTree() {
		return agentNoTree;
	}

	public void setAgentNoTree(String agentNoTree) {
		this.agentNoTree = agentNoTree;
	}

	public String getDirectAgentId() {
		return directAgentId;
	}

	public void setDirectAgentId(String directAgentId) {
		this.directAgentId = directAgentId;
	}

	public Integer getDirectAgentNo() {
		return directAgentNo;
	}

	public void setDirectAgentNo(Integer directAgentNo) {
		this.directAgentNo = directAgentNo;
	}

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
