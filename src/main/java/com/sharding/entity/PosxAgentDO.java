package com.sharding.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * posx_agent 表模型
 */
//@Table(name = "posx_agent")
@Data
public class PosxAgentDO {

    /**
     * 列名: agent_id
     * 备注: 代理id
     */

    private String agentId;

    /**
     * 列名: agent_no
     * 备注: 代理号,自增，从100000开始
     */

    private Integer agentNo;

    /**
     * 列名: agent_no_tree
     * 备注: 代理树,存agent_no值
     */

    private String agentNoTree;

    /**
     * 列名: agent_tree
     * 备注: 代理树,存agent_id值
     */
    private String agentTree;

    /**
     * 列名: parent_id
     * 备注: 所属父id，0是admin
     */
    private String parentId;

    /**
     * 列名: user_type
     * 备注: 用户类型:  1 平台端管理员,2-代理,3-平台端操作员，4-代理操作员，5-部门负责人，6-部门操作员 7-渠道经理 8-业务员
     */
    private Integer userType;

    /**
     * 列名: account
     * 备注: 账号名
     */
    private String account;

    /**
     * 列名: name
     * 备注: 姓名
     */
    private String name;

    /**
     * 列名: realname
     * 备注: 真实姓名
     */
    private String realname;

    /**
     * 列名: nickname
     * 备注: 昵称
     */
    private String nickname;

    /**
     * 列名: password
     * 备注: 密码
     */
    private String password;

    /**
     * 列名: phone
     * 备注: 手机号
     */
    private String phone;

    /**
     * 列名: address
     * 备注: 地址
     */
    private String address;

    /**
     * 列名: email
     * 备注: 邮箱
     */
    private String email;

    /**
     * 列名: islock
     * 备注: 是否锁定 0-否 1-是
     */
    private Integer islock;

    /**
     * 列名: isdel
     * 备注: 是否删除 0-否 1-是
     */
    private Integer isdel;

    /**
     * 列名: remark
     * 备注: 备注
     */
    private String remark;

    /**
     * 列名: level
     * 备注: 代理等级
     */
    private Integer level;

    /**
     * 列名: role_id
     * 备注: 角色id
     */
    private String roleId;

    /**
     * 列名: agent_biz_type
     * 备注: 0传统 1直营 2机构 3 邮易付 4江西邮政
     */
    private Integer agentBizType;

    /**
     * 列名: rate
     * 备注: 费率
     */
    private BigDecimal rate;

    /**
     * 列名: business_qq
     * 备注: 业务联系人QQ
     */
    private String businessQq;

    /**
     * 列名: business_email
     * 备注: 联系人邮箱
     */
    private String businessEmail;

    /**
     * 列名: business_tel
     * 备注: 联系人手机号
     */
    private String businessTel;

    /**
     * 列名: business_name
     * 备注: 业务联系人姓名
     */
    private String businessName;

    /**
     * 列名: bank_company_name
     * 备注: 开户名
     */
    private String bankCompanyName;

    /**
     * 列名: bank_no
     * 备注: 开户行账号
     */
    private String bankNo;

    /**
     * 列名: bank_addr_province
     * 备注: 开户省
     */
    private String bankAddrProvince;

    /**
     * 列名: bank_addr_city
     * 备注: 开户地
     */
    private String bankAddrCity;

    /**
     * 列名: bank_name
     * 备注: 开户行
     */
    private String bankName;

    /**
     * 列名: bank_sub_name
     * 备注: 开户支行名称
     */
    private String bankSubName;

    /**
     * 列名: bank_sub_code
     * 备注: 支行机构代码
     */
    private String bankSubCode;

    /**
     * 列名: create_time
     * 备注: 创建时间，格式：yyyyMMdd hh:mm:ss
     */
    private Date createTime;

    /**
     * 列名: update_time
     * 备注: 修改时间，格式：yyyyMMdd hh:mm:ss
     */
    private Date updateTime;

    /**
     * 列名: photo_id
     * 备注: 头像ID
     */
    private String photoId;

    /**
     * 列名: ext1
     * 备注: 扩展字段1
     */
    private String ext1;

    /**
     * 列名: ext2
     * 备注: 扩展字段2
     */
    private String ext2;

    /**
     * 列名: ext3
     * 备注: 扩展字段3
     */
    private String ext3;

    /**
     * 列名: agreement_version
     * 备注: 同意的协议版本
     */
    private String agreementVersion;

    /**
     * 列名: id_card_no
     * 备注: 身份证
     */
    private String idCardNo;

    /**
     * 列名: is_real_name
     * 备注: 是否实名认证 0 否 1是
     */
    private Integer isRealName;

    /**
     * 列名: jpush_id
     * 备注: 极光推送id
     */
    private String jpushId;

    /**
     * 列名: audit_flag
     * 备注: 商户入网审核标识，0-关闭，1-开启
     */
    private Integer auditFlag;

    /**
     * 列名: location_flag
     * 备注: 商户交易定位标识，0-关闭，1-开启
     */
    private Integer locationFlag;

    /**
     * 列名: cash_out_fix_settle_price
     * 备注: 商户提现2000及其以下固定结算底价
     */
    private BigDecimal cashOutFixSettlePrice;

    /**
     * 列名: cash_out_settle_price_rate
     * 备注: 商户提现2000以上结算底价手续费率
     */
    private BigDecimal cashOutSettlePriceRate;

    /**
     * 列名: channel_manager
     * 备注: 渠道经理名字
     */
    private String channelManager;

    /**
     * 列名: password_update_time
     * 备注: 密码修改时间
     */
    private Date passwordUpdateTime;

    /**
     * 列名: login_fail_count
     * 备注: 0 登录失败次数
     */
    private Integer loginFailCount;

    /**
     * 列名: freeze_time
     * 备注: 冻结时间 之前不能登录
     */
    private Date freezeTime;

    /**
     * 列名: fast_audit_flag
     * 备注: 快速审核标识，0-关闭，1-开启
     */
    private Integer fastAuditFlag;

    /**
     * 列名: org_struct_id
     * 备注: 组织结构编号
     */
    private Integer orgStructId;

    /**
     * 列名: org_struct_tree
     * 备注: 组织结构树
     */
    private String orgStructTree;

    /**
     * 列名: cm_id
     * 备注: 渠道经理编号
     */
    private Integer cmId;

    /**
     * 列名: activity_flag
     * 备注: 营销活动标识，0-关闭，1-开启
     */
    private Integer activityFlag;

    /**
     * 列名: pay_channel
     * 备注:接入通道
     */
    private String payChannel;

    /**
     * 列名: ext_field
     * 备注:网点编号
     */
    private String extField;

    /**
     * 列名: org_level
     * 备注:机构级别 0-无 1-S级  2-A级 3-B级 4-C级
     */
    private String orgLevel;

    /**
     * 易生合作模式编号
     */
    private String modeNumber;

}