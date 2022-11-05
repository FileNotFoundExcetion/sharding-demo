package com.sharding.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
    * 设备绑定历史记录
    */
@Getter
@Setter
@ToString
public class PosxDeviceBindHis {
    /**
     * 编号
     */

    private Integer id;

    /**
     * 商户编号
     */
    private String merchantId;

    /**
     * 代理商编号
     */
    private String agentId;

    /**
     * 代理树
     */
    private String agentTree;

    /**
     * 设备外键编号
     */
    private String deviceId;

    /**
     * 设备编号
     */
    private String deviceNo;

    /**
     * 配件设备号
     */
    private String fittingNo;

    /**
     * 绑定时间
     */
    private Date bindTime;

    /**
     * 解绑时间
     */
    private Date unbindTime;

    /**
     * 操作用户
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新用户
     */
    private String updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 操作备注
     */
    private String remark;
}