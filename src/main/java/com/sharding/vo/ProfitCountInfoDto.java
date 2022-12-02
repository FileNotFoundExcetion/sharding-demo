package com.sharding.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ProfitCountInfoDto implements Serializable {

    private String agentId;

    private List<Integer> agentNos;

    private List<Integer> unAgentNos;

    private String month;

    private String myProfitAgentName;

    private Date monthDate;

    private String beginDate;

    private String endDate;

    private Integer level;

    private String agentTree;

    private String parentId;

    private String parentAgentNo;

    private String parentTree;

    private String paywayType;

    private Integer orgStructId;

    private String orderTableName;

    private String profitTableName;

    private List<String> paywayIds;

    private List<String> paywayRefundLists;

    private Integer unionpayOffers;

    private String merchantId;

    private String tradeDate;

    private String agentNoTree;

    private String parentNoTree;

    private Integer agentNo;

    private Integer queryFlag;

    private String subOrderId;

    /**
     * C：信用卡，D：借记卡
     * */
    private String cardType;


}
